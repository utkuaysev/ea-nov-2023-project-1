package com.project.business.service;

import com.project.business.dto.get.GetProfExperienceDto;
import com.project.business.dto.post.PostFullProfExperienceDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ProfExperienceService {
    GetProfExperienceDto addProfExperience(PostFullProfExperienceDto profExperience);


    GetProfExperienceDto getById(Long id);
    List<GetProfExperienceDto> getByAlumniId(Long alumniId);


    @Transactional
    GetProfExperienceDto updateById(Long alumniId, Long id, PostFullProfExperienceDto profExperienceDto);

    @Transactional
    GetProfExperienceDto deleteById(Long alumniId,Long id);

}
