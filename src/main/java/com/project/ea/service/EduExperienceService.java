package com.project.ea.service;

import com.project.ea.dto.post.PostFullEduExperienceDto;
import com.project.ea.dto.get.GetFullEduExperienceDto;
import jakarta.transaction.Transactional;

public interface EduExperienceService {

    GetFullEduExperienceDto getByAlumniId(Long alumniId);


    @Transactional
    GetFullEduExperienceDto updateById(Long alumniId, PostFullEduExperienceDto eduExperienceDto);

    @Transactional
    GetFullEduExperienceDto deleteById(Long alumniId);

    GetFullEduExperienceDto addEduExperience(Long alumniId, PostFullEduExperienceDto eduExperience);
}
