package com.project.business.service;

import com.project.business.dto.get.GetFullProfExperienceDto;
import com.project.business.dto.post.PostFullProfExperienceDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ProfExperienceService {
    GetFullProfExperienceDto addProfExperience(Long alumniId, PostFullProfExperienceDto profExperience);

    List<GetFullProfExperienceDto> getAllByAlumniId(Long alumniId);

    GetFullProfExperienceDto getByAlumniIdAndId(Long alumniId, Long id);


    @Transactional
    GetFullProfExperienceDto updateById(Long alumniId, Long id, PostFullProfExperienceDto profExperienceDto);

    @Transactional
    GetFullProfExperienceDto deleteById(Long alumniId,Long id);

}
