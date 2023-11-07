package com.project.ea.service;

import com.project.ea.dto.get.GetAlumniDto;
import com.project.ea.dto.post.PostAlumniDto;
import com.project.ea.model.Address;


import java.util.List;

public interface AlumniService {
    List<GetAlumniDto> getAllAlumni();
    GetAlumniDto getAlumniById(long id);
    GetAlumniDto saveAlumni(PostAlumniDto postAlumniDto);
    GetAlumniDto updateAlumni(long id, PostAlumniDto postAlumniDto);
    void deleteAlumni(long id);
    List<GetAlumniDto> getAlumniByGraduationYear(int year);
    List<GetAlumniDto> getAlumniByCourseName(String courseName);
    List<GetAlumniDto> getAlumniByAddress(Address address);
    List<GetAlumniDto> getAlumniByIndustry(String industry);


}
