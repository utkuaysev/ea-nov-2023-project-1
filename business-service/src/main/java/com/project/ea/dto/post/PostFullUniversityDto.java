package com.project.ea.dto.post;

import com.project.ea.model.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostFullUniversityDto {
    private boolean  isDeleted;
    private String name;
    private PostFullAddressDto address;
}
