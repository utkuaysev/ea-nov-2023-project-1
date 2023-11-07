package com.project.ea.controller;

import com.project.ea.dto.get.GetUniversityDto;
import com.project.ea.dto.post.PostUniversityDto;
import com.project.ea.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/universities")
public class UniversityController {
    private final UniversityService universityService;

    @GetMapping
    public List<GetUniversityDto> getAllUniversities() {
        return universityService.getAllUniversities();
    }

    @GetMapping("/{id}")
    public GetUniversityDto getUniversityById(@PathVariable long id) {
        return universityService.getUniversityById(id);
    }

    @PostMapping
    public GetUniversityDto saveUniversity(@RequestBody PostUniversityDto postUniversityDto) {
        return universityService.saveUniversity(postUniversityDto);
    }

    @PutMapping("/{id}")
    public GetUniversityDto updateUniversity(@PathVariable long id, @RequestBody PostUniversityDto postUniversityDto) {
        return universityService.updateUniversity(id, postUniversityDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUniversity(@PathVariable long id) {
        universityService.deleteUniversity(id);
    }

}
