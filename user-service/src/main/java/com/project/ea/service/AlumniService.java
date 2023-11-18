package com.project.ea.service;

import com.project.ea.dto.get.GetFullAlumniDto;
import com.project.ea.dto.post.PostFullAlumniDto;


import java.util.List;

public interface AlumniService {
    List<GetFullAlumniDto> getAllAlumni();
    GetFullAlumniDto getAlumniById(long id);
    GetFullAlumniDto saveAlumni(PostFullAlumniDto postFullAlumniDto);
    GetFullAlumniDto updateAlumni(long id, PostFullAlumniDto postFullAlumniDto);
    void deleteAlumni(long id);


}
