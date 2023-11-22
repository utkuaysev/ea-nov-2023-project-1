package com.project.business.service;

import com.project.business.dto.get.GetAddressDto;
import com.project.business.dto.get.GetCompanyDto;
import com.project.business.dto.get.GetProfExperienceDto;
import com.project.business.dto.post.PostProfExperienceDto;
import com.project.business.model.Address;
import com.project.business.model.Company;
import com.project.business.model.ProfExperience;
import com.project.business.repository.ProfExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfExperienceServiceImpl implements ProfExperienceService {
    private final ProfExperienceRepository profExperienceRepository;
    private final ModelMapper modelMapper;
    @Override
    public GetProfExperienceDto addProfExperience(PostProfExperienceDto profExperienceDto) {
//        Company company = companyRepo.findById(profExperienceDto.getCompanyId())
//                .orElseThrow(() -> new RuntimeException("Company not found with id: " + profExperienceDto.getCompanyId()));
//        GetFullAlumniDto alumni = getAlumni(profExperienceDto.getAlumniId());
//        ProfExperience profExperience = mapResponse(profExperienceDto, alumni, modelMapper.map(company, GetFullCompanyDto.class));
//        profExperienceRepository.save(profExperience);
//        return modelMapper.map(profExperience, GetProfExperienceDto.class);
            return null;
    }

    @Override
    public GetProfExperienceDto getById(Long id) {
        var pe = profExperienceRepository.findById(id).orElseThrow();
        return mapGetResponse(pe);
    }

    @Override
    public List<GetProfExperienceDto> getByAlumniId(Long alumniId) {
        var peList = profExperienceRepository.findAllByAlumniId(alumniId);
        return peList.stream()
                .map(pe -> mapGetResponse(pe))
                .collect(Collectors.toList());
    }

    @Override
    public GetProfExperienceDto updateById(Long alumniId, Long id, PostProfExperienceDto profExperienceDto) {
        return null;
    }

    @Override
    public GetProfExperienceDto deleteById(Long alumniId, Long id) {
        return null;
    }

    public GetProfExperienceDto mapGetResponse(ProfExperience profExperience) {
        var peDto = modelMapper.map(profExperience, GetProfExperienceDto.class);
        var cDto = modelMapper.map(profExperience.getCompany(), GetCompanyDto.class);
        var aDto = modelMapper.map(profExperience.getCompany().getAddress(), GetAddressDto.class);
        cDto.setAddress(aDto);
        peDto.setCompany(cDto);
        return peDto;
    }

    public ProfExperience mapProfExperience(PostProfExperienceDto profExperienceDto) {
        var pe = modelMapper.map(profExperienceDto, ProfExperience.class);
        var c = modelMapper.map(profExperienceDto.getCompany(), Company.class);
        var a = modelMapper.map(profExperienceDto.getCompany().getAddress(), Address.class);
        c.setAddress(a);
        pe.setCompany(c);
        return pe;
    }

}
