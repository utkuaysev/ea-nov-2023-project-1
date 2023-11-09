package com.project.ea.controller;

import com.project.ea.dto.get.GetFullCompanyDto;
import com.project.ea.dto.get.GetFullEduExperienceDto;
import com.project.ea.service.CompanyService;
import com.project.ea.service.EduExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumni/{id}")
@RequiredArgsConstructor
public class EduExperienceController {
    private final EduExperienceService eduExperienceService;
    private final CompanyService companyService;


    @GetMapping("/edu_experiences")
    public List<GetFullEduExperienceDto> getAllEduExperiences(@PathVariable Long id){
        return eduExperienceService.getAllByAlumniId(id);
    }
 }
