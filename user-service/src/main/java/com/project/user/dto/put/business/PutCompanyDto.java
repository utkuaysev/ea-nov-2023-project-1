package com.project.user.dto.put.business;

import lombok.Data;

@Data
public class PutCompanyDto {
    private String id;
    private String name;
    private String industry;
    private PutAddressDto address;
}
