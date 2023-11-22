package com.project.user.service;

import com.project.user.dto.get.GetAlumniAuth;
import com.project.user.dto.get.GetFullAlumniDto;
import com.project.user.dto.post.AuthRequest;
import com.project.user.dto.post.PostFullAlumniDto;
import com.project.user.dto.put.PutFullAlumniDto;
import com.project.user.model.Alumni;
import com.project.user.repository.AlumniRepository;
import com.project.user.repository.RoleTypeRepository;
import com.project.user.service.feign.BusinessServiceClient;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlumniServiceImpl implements AlumniService {
    private final AlumniRepository alumniRepository;
    private final RoleTypeRepository roleTypeRepository;
    private final ModelMapper modelMapper;
    private final BusinessServiceClient businessServiceClient;
    private final RabbitTemplate rabbitTemplate;


    @Override
    public List<GetFullAlumniDto> getAllAlumni() {
        var alumniList = alumniRepository.findAll();
        return alumniList.stream()
                .map(this::mapGetResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GetFullAlumniDto getAlumniById(long id) {
        try {
            return mapGetResponse(alumniRepository.findById(id).orElseThrow());
        }catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public GetAlumniAuth getAlumniByMail(String mail) {
        try {
            return modelMapper.map(alumniRepository.findAlumniByMail(mail).orElseThrow(), GetAlumniAuth.class);
        }catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public GetAlumniAuth saveAlumni(AuthRequest authRequest) {
        Alumni alumni = modelMapper.map(authRequest, Alumni.class);
        alumni.setRole(roleTypeRepository.findById(authRequest.getRoleId()).orElseThrow());
        if(alumniRepository.findAlumniByMail(alumni.getMail()).isPresent()){
            return null;
        }
        alumni.setId(null);
        var result = alumniRepository.save(alumni);
        return GetAlumniAuth.builder()
                .mail(result.getMail())
                .password(result.getPassword())
                .roleId(result.getRole().getId()).build();
    }
    @Override
    public void updateAlumni(long id, PutFullAlumniDto putFullAlumniDto) {
        if (alumniRepository.existsById(id)) {
            Alumni alumni = modelMapper.map(putFullAlumniDto, Alumni.class);
            alumni.setId(id);
            alumni.setRole(roleTypeRepository.findById(putFullAlumniDto.getRoleId()).orElseThrow());
            var result = alumniRepository.save(alumni);
            var profExpDtos = putFullAlumniDto.getProfExperiences();
            profExpDtos.forEach(pe -> {
                pe.setAlumniId(result.getId());
                rabbitTemplate.convertAndSend("direct-prof-experience-exchange",
                        "update-prof-experience", pe);
            });
        } else {
            throw new RuntimeException("""
                    No Alumni with id:${id} exists.""");
        }
    }

    @Override
    public void deleteAlumni(long id) {
        alumniRepository.deleteById(id);
        rabbitTemplate.convertAndSend("delete-alumni-exchange", "", id);
    }


    private GetFullAlumniDto mapGetResponse(Alumni alumni) {
        var alumniDto = modelMapper.map(alumni, GetFullAlumniDto.class);
        alumniDto.setRoleName(alumni.getRole().getName());
        var peList = businessServiceClient.getProfExperiencesByAlumniId(alumni.getId());
        alumniDto.setProfExperiences(peList);
        return alumniDto;

    }


}
