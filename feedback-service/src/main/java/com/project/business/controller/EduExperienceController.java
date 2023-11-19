package com.project.business.controller;

import com.project.business.dto.get.GetFullEduExperienceDto;
import com.project.business.dto.post.PostFullEduExperienceDto;
import com.project.business.service.EduExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/alumni/{alumniId}/edu_experience")
@RequiredArgsConstructor
public class EduExperienceController {
    private final EduExperienceService eduExperienceService;


    @PostMapping
    public GetFullEduExperienceDto addEduExperience(@PathVariable Long alumniId,
                                                    @RequestBody PostFullEduExperienceDto eduExperience) {
        return eduExperienceService.addEduExperience(alumniId, eduExperience);
    }
    @GetMapping
    public GetFullEduExperienceDto getEduExperienceById(@PathVariable Long alumniId){
        try {
            return eduExperienceService.getByAlumniId(alumniId);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Edu experience not found");
        }
    }

    @PutMapping
    public GetFullEduExperienceDto updateById(@PathVariable Long alumniId,
                                              @RequestBody PostFullEduExperienceDto postFullEduExperienceDto){
        try {
            return eduExperienceService.updateById(alumniId, postFullEduExperienceDto);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EduExperience not found");
        }
    }
    @DeleteMapping
    public GetFullEduExperienceDto deleteById(@PathVariable Long alumniId){
        try {
            return eduExperienceService.deleteById(alumniId);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EduExperience not found");
        }
    }
}
