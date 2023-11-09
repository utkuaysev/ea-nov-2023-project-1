package com.project.ea.service;

import com.project.ea.dto.get.GetFullEduExperienceDto;

import java.util.List;

public interface EduExperienceService {
    List<GetFullEduExperienceDto> getAllByAlumniId(Long id);
}
