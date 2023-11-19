package com.project.business.dto.post;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PostFullEduExperienceDto {
    private Long universityId;
    private String degree;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Long> courseIdList;
}
