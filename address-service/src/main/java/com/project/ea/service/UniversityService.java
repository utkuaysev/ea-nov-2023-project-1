package com.project.ea.service;


import com.project.ea.dto.get.GetFullUniversityDto;
import com.project.ea.dto.post.PostFullUniversityDto;

import java.util.List;

public interface UniversityService {
    List<GetFullUniversityDto> getAllUniversities();
    GetFullUniversityDto getUniversityById(long id);
    GetFullUniversityDto saveUniversity(PostFullUniversityDto postFullUniversityDto);
    GetFullUniversityDto updateUniversity(long id, PostFullUniversityDto postFullUniversityDto);
    void deleteUniversity(long id);

}
