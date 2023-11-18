package com.project.ea.dto.get;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GetFullCompanyDto implements Serializable {
    private Long id;
    private String name;
    private String industry;
    private GetFullAddressDto address;

}
