package com.project.ea.service;


import com.project.ea.dto.get.GetUniversityDto;
import com.project.ea.dto.post.PostUniversityDto;

import java.util.List;

public interface UniversityService {
    List<GetUniversityDto> getAllUniversities();
    GetUniversityDto getUniversityById(long id);
    GetUniversityDto saveUniversity(PostUniversityDto postUniversityDto);
    GetUniversityDto updateUniversity(long id, PostUniversityDto postUniversityDto);
    void deleteUniversity(long id);

}
