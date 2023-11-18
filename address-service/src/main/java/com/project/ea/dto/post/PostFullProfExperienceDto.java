package com.project.ea.dto.post;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PostFullProfExperienceDto {
    private Long companyId;
    private LocalDate startDate;
    private LocalDate endDate;
}
