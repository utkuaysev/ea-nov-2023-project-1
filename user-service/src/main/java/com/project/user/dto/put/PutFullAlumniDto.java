package com.project.user.dto.put;

import com.project.user.dto.put.business.PutProfExperienceDto;
import com.project.user.dto.put.education.EduExperienceDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PutFullAlumniDto {

    private String mail;
    private String password;
    private String phone;
    private String profilePicture;
    private String location;
    private Long roleId;
    private List<PutProfExperienceDto> profExperiences;
    private List<EduExperienceDto> eduExperiences;
}
