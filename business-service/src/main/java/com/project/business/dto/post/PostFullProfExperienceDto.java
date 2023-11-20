package com.project.business.dto.post;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PostFullProfExperienceDto {
    private Long alumniId;
    private Long companyId;
    private LocalDate startDate;
    private LocalDate endDate;
}
