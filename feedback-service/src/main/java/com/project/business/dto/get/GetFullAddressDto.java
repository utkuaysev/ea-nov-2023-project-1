package com.project.business.dto.get;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GetFullAddressDto implements Serializable {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zip;

}
