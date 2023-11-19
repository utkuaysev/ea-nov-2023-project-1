package com.project.business.dto.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostFullCompanyDto {
    private String name;
    private String industry;
    private PostFullAddressDto address;

}
