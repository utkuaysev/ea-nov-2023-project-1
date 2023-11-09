package com.project.ea.controller;

import com.project.ea.dto.get.GetFullUniversityDto;
import com.project.ea.dto.post.PostFullUniversityDto;
import com.project.ea.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/universities")
public class UniversityController {
    private final UniversityService universityService;

    @GetMapping
    public List<GetFullUniversityDto> getAllUniversities() {
        return universityService.getAllUniversities();
    }

    @GetMapping("/{id}")
    public GetFullUniversityDto getUniversityById(@PathVariable long id) {
        return universityService.getUniversityById(id);
    }

    @PostMapping
    public GetFullUniversityDto saveUniversity(@RequestBody PostFullUniversityDto postFullUniversityDto) {
        return universityService.saveUniversity(postFullUniversityDto);
    }

    @PutMapping("/{id}")
    public GetFullUniversityDto updateUniversity(@PathVariable long id, @RequestBody PostFullUniversityDto postFullUniversityDto) {
        return universityService.updateUniversity(id, postFullUniversityDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUniversity(@PathVariable long id) {
        universityService.deleteUniversity(id);
    }

}
