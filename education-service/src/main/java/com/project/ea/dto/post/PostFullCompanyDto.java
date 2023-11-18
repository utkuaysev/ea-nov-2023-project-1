package com.project.ea.dto.post;

import com.project.ea.model.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostFullCompanyDto {
    private String name;
    private String industry;
    private PostFullAddressDto address;

}
