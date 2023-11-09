package com.project.ea.dto.get;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetFullEduExperienceDto {
    private Long id;
    private String degree;
    private String universityName;
    private List<GetFullCourseDto> courseList;
}
