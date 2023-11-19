package com.project.business.service;

import com.project.business.dto.get.GetFullAlumniDto;
import com.project.business.dto.post.PostFullAlumniDto;


import java.util.List;

public interface AlumniService {
    List<GetFullAlumniDto> getAllAlumni();
    GetFullAlumniDto getAlumniById(long id);
    GetFullAlumniDto saveAlumni(PostFullAlumniDto postFullAlumniDto);
    GetFullAlumniDto updateAlumni(long id, PostFullAlumniDto postFullAlumniDto);
    void deleteAlumni(long id);


}
