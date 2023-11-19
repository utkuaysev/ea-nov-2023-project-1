package com.project.business.service;


import com.project.business.dto.get.GetFullUniversityDto;
import com.project.business.dto.post.PostFullUniversityDto;

import java.util.List;

public interface UniversityService {
    List<GetFullUniversityDto> getAllUniversities();
    GetFullUniversityDto getUniversityById(long id);
    GetFullUniversityDto saveUniversity(PostFullUniversityDto postFullUniversityDto);
    GetFullUniversityDto updateUniversity(long id, PostFullUniversityDto postFullUniversityDto);
    void deleteUniversity(long id);

}
