package com.project.ea.dto.get;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class GetFullProfExperienceDto {
    private Long id;
    private String companyName;
    private LocalDate startDate;
    private LocalDate endDate;
}
