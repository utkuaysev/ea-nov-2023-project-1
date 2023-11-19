package com.project.business.dto.get;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GetFullProfExperienceDto {
    private Long id;
    private String companyName;
    private LocalDate startDate;
    private LocalDate endDate;
}
