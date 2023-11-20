package com.project.business.dto.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostFullAlumniDto {
    private String mail;
    private String password;
    private String phone;
    private String profilePicture;
    private String location;
    private Long roleId;
}
