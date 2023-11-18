package com.project.ea.dto.post;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PostFullOpenJobDto {
    private String description;
    private LocalDateTime openDate;
    private Long creatorAlumniId;
    private List<Long> applicantIds;
}
