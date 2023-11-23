package com.project.business.service;

import com.project.business.dto.get.GetProfExperienceDto;
import com.project.business.dto.post.PostProfExperienceDto;
import com.project.business.model.ProfExperience;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ProfExperienceService {
    GetProfExperienceDto getById(Long id);

    List<GetProfExperienceDto> getByAlumniId(Long alumniId);


    void deleteById(Long id, String mail);

    GetProfExperienceDto mapGetResponse(ProfExperience profExperience);


    List<GetProfExperienceDto> searchByIndustry(String industry);
}
