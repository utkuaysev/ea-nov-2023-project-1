package com.project.ea.dto.get;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class GetFullEduExperienceDto {
    private Long id;
    private String degree;
    private String universityName;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<GetFullCourseDto> courseList;
}
