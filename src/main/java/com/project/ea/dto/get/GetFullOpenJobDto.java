package com.project.ea.dto.get;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class GetFullOpenJobDto {

    @Getter
    @Setter
    public static class InnerAlumniDto{
        private String mail;
        private String phone;
    }

    private Long id;
    private String companyName;
    private String companyIndustry;
    private String description;
    private LocalDateTime openDate;
    private InnerAlumniDto creator;
    private List<InnerAlumniDto> applicants;
}