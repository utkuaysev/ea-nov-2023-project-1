package com.project.business.dto.get;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetProfExperienceDto {
    private String id;
    private GetCompanyDto companyDto;
    private LocalDate startDate;
    private LocalDate endDate;
}
