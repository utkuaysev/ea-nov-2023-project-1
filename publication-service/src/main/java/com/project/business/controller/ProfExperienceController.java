package com.project.business.controller;

import com.project.business.dto.get.GetFullProfExperienceDto;
import com.project.business.dto.post.PostFullProfExperienceDto;
import com.project.business.service.ProfExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/alumni/{alumniId}/prof_experiences")
@RequiredArgsConstructor
public class ProfExperienceController {
    private final ProfExperienceService profExperienceService;


    @PostMapping
    public GetFullProfExperienceDto addProfExperience(@PathVariable Long alumniId,
                                                      @RequestBody PostFullProfExperienceDto profExperience) {
        return profExperienceService.addProfExperience(alumniId, profExperience);
    }

    @GetMapping
    public List<GetFullProfExperienceDto> getProfExperienceByAlumni(@PathVariable Long alumniId) {
        try {
            return profExperienceService.getAllByAlumniId(alumniId);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Prof experiences not found");
        }
    }

    @GetMapping("/{id}")
    public GetFullProfExperienceDto getProfExperienceById(@PathVariable Long alumniId, @PathVariable Long id) {
        try {
            return profExperienceService.getByAlumniIdAndId(alumniId, id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Prof experience not found");
        }
    }

    @PutMapping("/{id}")
    public GetFullProfExperienceDto updateById(@PathVariable Long alumniId,
                                               @PathVariable Long id,
                                              @RequestBody PostFullProfExperienceDto postFullProfExperienceDto) {
        try {
            return profExperienceService.updateById(alumniId, id, postFullProfExperienceDto);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ProfExperience not found");
        }
    }

    @DeleteMapping("/{id}")
    public GetFullProfExperienceDto deleteById(@PathVariable Long alumniId, @PathVariable Long id) {
        try {
            return profExperienceService.deleteById(alumniId, id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ProfExperience not found");
        }
    }
}
