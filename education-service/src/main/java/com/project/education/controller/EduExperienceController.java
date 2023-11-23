package com.project.education.controller;

import com.project.education.dto.get.GetFullEduExperienceDto;
import com.project.education.dto.put.PutFullEduExperienceDto;
import com.project.education.service.EduExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/edu_experiences")
@RequiredArgsConstructor
public class EduExperienceController {
    private final EduExperienceService eduExperienceService;


    @GetMapping("/{id}")
    public GetFullEduExperienceDto getEduExperienceById(@PathVariable Long id){
        try {
            return eduExperienceService.getById(id);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Edu experience not found");
        }
    }

    @GetMapping("/alumni/{alumniId}")
    public List<GetFullEduExperienceDto> getAllEduExperiencesByAlumniId(@PathVariable Long alumniId){
        try {
            return eduExperienceService.getAllByAlumniId(alumniId);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Edu experience not found");
        }
    }
    @GetMapping("/searchByGradYear/{year}")
    public List<GetFullEduExperienceDto> getAllEduExperiencesByGradYear(@PathVariable int year){
        try {
            return eduExperienceService.getAllByGradYear(year);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Edu experience not found");
        }
    }
    @GetMapping("/searchByCourse/{course}")
    public List<GetFullEduExperienceDto> getAllEduExperiencesByCourse(@PathVariable String course){
        try {
            return eduExperienceService.getAllByCourseName(course);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Edu experience not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try {
            eduExperienceService.deleteById(id);
            return new ResponseEntity<>("Alumni deleted successfully", HttpStatus.OK);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EduExperience not found");
        }
    }
}
