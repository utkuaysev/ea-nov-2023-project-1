package com.project.user.service;

import com.project.user.dto.get.GetAlumniAuth;
import com.project.user.dto.get.GetFullAlumniDto;
import com.project.user.dto.post.AuthRequest;
import com.project.user.dto.post.PostFullAlumniDto;
import com.project.user.dto.put.PutFullAlumniDto;


import java.util.List;

public interface AlumniService {
    List<GetFullAlumniDto> getAllAlumni();
    GetFullAlumniDto getAlumniById(long id);

    GetAlumniAuth getAlumniByMail(String mail);

    GetAlumniAuth saveAlumni(AuthRequest getAlumniAuth);
    void updateAlumni(long id, PutFullAlumniDto postFullAlumniDto);
    void deleteAlumni(long id);


//    GetFullAlumniDto getAlumniByMail(String mail);
}
