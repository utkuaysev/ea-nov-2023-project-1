package com.project.business.service;

import com.project.business.dto.get.GetFullProfExperienceDto;
import com.project.business.dto.post.PostFullProfExperienceDto;
import com.project.business.model.Alumni;
import com.project.business.model.ProfExperience;
import com.project.business.model.Company;
import com.project.business.repository.AlumniRepository;
import com.project.business.repository.ProfExperienceRepository;
import com.project.business.repository.CompanyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfExperienceServiceImpl implements ProfExperienceService {
    private final ProfExperienceRepository profExperienceRepository;
    private final CompanyRepository companyRepo;
    private final AlumniRepository alumniRepository;
    private final ModelMapper modelMapper;

    @Override
    public GetFullProfExperienceDto addProfExperience(Long alumniId, PostFullProfExperienceDto profExperienceDto) {
        Company company = companyRepo.findById(profExperienceDto.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + profExperienceDto.getCompanyId()));
        Alumni alumni = alumniRepository.findById(alumniId)
                .orElseThrow(() -> new RuntimeException("Alumni not found with id: " + profExperienceDto.getCompanyId()));
        ProfExperience profExperience = modelMapper.map(profExperienceDto, ProfExperience.class);
        profExperience.setCompany(company);
        profExperience.setAlumni(alumni);
        profExperienceRepository.save(profExperience);
        return modelMapper.map(profExperience, GetFullProfExperienceDto.class);
    }

    @Override
    public List<GetFullProfExperienceDto> getAllByAlumniId(Long alumniId) {
        return profExperienceRepository.findAllByAlumni_Id(alumniId).stream()
                .map(m -> modelMapper.map(m, GetFullProfExperienceDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetFullProfExperienceDto getByAlumniIdAndId(Long alumniId, Long id) {
        ProfExperience profExperience = profExperienceRepository.findByAlumni_IdAndId(alumniId, id).orElseThrow();
        return modelMapper.map(profExperience, GetFullProfExperienceDto.class);
    }

    @Transactional
    @Override
    public GetFullProfExperienceDto updateById(Long alumniId, Long id, PostFullProfExperienceDto profExperienceDto) {
        Company company = companyRepo.findById(profExperienceDto.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + profExperienceDto.getCompanyId()));
        Alumni alumni = alumniRepository.findById(alumniId)
                .orElseThrow(() -> new RuntimeException("Alumni not found with id: " + profExperienceDto.getCompanyId()));
        ProfExperience profExperience = profExperienceRepository.findByAlumni_IdAndId(alumniId, id).orElseThrow();
        profExperience.setCompany(company);
        profExperience.setAlumni(alumni);
        profExperience.setEndDate(profExperienceDto.getEndDate());
        profExperience.setStartDate(profExperienceDto.getStartDate());
        profExperienceRepository.save(profExperience);
        return modelMapper.map(profExperience, GetFullProfExperienceDto.class);
    }

    @Transactional
    @Override
    public GetFullProfExperienceDto deleteById(Long alumniId, Long id) {
        ProfExperience profExperience = profExperienceRepository.findByAlumni_IdAndId(alumniId, id).orElseThrow();
        GetFullProfExperienceDto retProfExperience = modelMapper.map(profExperience, GetFullProfExperienceDto.class);
        profExperienceRepository.delete(profExperience);
        return retProfExperience;
    }
}
