package com.project.business.service;

import com.project.business.dto.post.PostFullEduExperienceDto;
import com.project.business.dto.get.GetFullEduExperienceDto;
import jakarta.transaction.Transactional;

public interface EduExperienceService {

//    GetFullEduExperienceDto getByAlumniId(Long alumniId);


    @Transactional
    GetFullEduExperienceDto updateById(Long alumniId, PostFullEduExperienceDto eduExperienceDto);

    @Transactional
    GetFullEduExperienceDto deleteById(Long alumniId);

    GetFullEduExperienceDto addEduExperience(Long alumniId, PostFullEduExperienceDto eduExperience);
}
