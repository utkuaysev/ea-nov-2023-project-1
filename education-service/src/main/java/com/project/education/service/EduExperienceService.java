package com.project.education.service;

import com.project.education.dto.get.GetFullEduExperienceDto;
import com.project.education.dto.put.PutFullEduExperienceDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface EduExperienceService {

    GetFullEduExperienceDto getById(Long id);

    @Transactional
    void deleteById(Long alumniId);

    List<GetFullEduExperienceDto> getAllByAlumniId(Long alumniId);

    List<GetFullEduExperienceDto> getAllByGradYear(int year);

    List<GetFullEduExperienceDto> getAllByCourseName(String course);
}
