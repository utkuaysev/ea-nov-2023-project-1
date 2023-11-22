package com.project.business.controller;

import com.project.business.dto.get.GetProfExperienceDto;
import com.project.business.dto.post.PostProfExperienceDto;
import com.project.business.service.ProfExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/prof_experiences")
@RequiredArgsConstructor
public class ProfExperienceController {
    private final ProfExperienceService profExperienceService;


//    @PostMapping
//    public GetProfExperienceDto addProfExperience(@RequestBody PostFullProfExperienceDto profExperience) {
//        return profExperienceService.addProfExperience(profExperience);
//    }
    @GetMapping("/{id}")
    public GetProfExperienceDto getProfExperienceById(@PathVariable Long id) {
        try {
            return profExperienceService.getById(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Prof experience not found");
        }
    }

    @GetMapping("/alumni/{alumniId}")
    public List<GetProfExperienceDto> getProfExperienceByAlumniId(@PathVariable Long alumniId) {
        try {
            return profExperienceService.getByAlumniId(alumniId);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Prof experience not found");
        }
    }

    @PutMapping("/{id}")
    public GetProfExperienceDto updateById(@PathVariable Long alumniId,
                                               @PathVariable Long id,
                                              @RequestBody PostProfExperienceDto postFullProfExperienceDto) {
        try {
            return profExperienceService.updateById(alumniId, id, postFullProfExperienceDto);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ProfExperience not found");
        }
    }

    @DeleteMapping("/{id}")
    public GetProfExperienceDto deleteById(@PathVariable Long alumniId, @PathVariable Long id) {
        try {
            return profExperienceService.deleteById(alumniId, id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ProfExperience not found");
        }
    }

}
