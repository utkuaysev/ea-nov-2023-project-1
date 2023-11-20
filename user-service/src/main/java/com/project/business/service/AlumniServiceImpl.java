package com.project.business.service;

import com.project.business.dto.get.GetFullAlumniDto;
import com.project.business.dto.post.PostFullAlumniDto;
import com.project.business.model.Alumni;
import com.project.business.repository.AlumniRepository;
import com.project.business.repository.RoleTypeRepository;
import com.project.business.service.feign.BusinessServiceClient;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlumniServiceImpl implements AlumniService {
    private final AlumniRepository alumniRepository;
    private final RoleTypeRepository roleTypeRepository;
    private final ModelMapper modelMapper;
    private final BusinessServiceClient businessServiceClient;

    @Override
    public List<GetFullAlumniDto> getAllAlumni() {
        var alumniList = alumniRepository.findAll();
        return alumniList.stream()
                .map(this::mapGetResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GetFullAlumniDto getAlumniById(long id) {
        return mapGetResponse(alumniRepository.findById(id).orElseThrow());
    }

    @Override
    public GetFullAlumniDto saveAlumni(PostFullAlumniDto postFullAlumniDto) {
        Alumni alumni = modelMapper.map(postFullAlumniDto, Alumni.class);
        alumni.setRole(roleTypeRepository.findById(postFullAlumniDto.getRoleId()).orElseThrow());
        var result = alumniRepository.save(alumni);
        return modelMapper.map(result, GetFullAlumniDto.class);
    }

    @Override
    public GetFullAlumniDto updateAlumni(long id, PostFullAlumniDto postFullAlumniDto) {
        if (alumniRepository.existsById(id)) {
            Alumni alumni = modelMapper.map(postFullAlumniDto, Alumni.class);
            alumni.setId(id);
            alumni.setRole(roleTypeRepository.findById(postFullAlumniDto.getRoleId()).orElseThrow());
            var result = alumniRepository.save(alumni);
            return modelMapper.map(result, GetFullAlumniDto.class);
        }
        throw new RuntimeException("""
                No Alumni with id:${id} exists.""");
    }

    @Override
    public void deleteAlumni(long id) {
        alumniRepository.deleteById(id);
    }
    private GetFullAlumniDto mapGetResponse(Alumni alumni) {
        var alumniDto = modelMapper.map(alumni, GetFullAlumniDto.class);
        alumniDto.setRoleName(alumni.getRole().getName());
        var peList = businessServiceClient.getProfExperiencesByAlumniId(alumni.getId());
        alumniDto.setProfExperiences(peList);
        return alumniDto;

    }


}
