package com.project.ea.controller;

import com.project.ea.dto.get.GetFullAlumniDto;
import com.project.ea.dto.post.PostFullAlumniDto;
import com.project.ea.model.Address;
import com.project.ea.service.AlumniService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alumni")
public class AlumniController {
    private final AlumniService alumniService;

    @GetMapping
    public List<GetFullAlumniDto> getAllAlumni() {
        return alumniService.getAllAlumni();
    }

    @GetMapping("/{id}")
    public GetFullAlumniDto getAlumniById(@PathVariable long id) {
        return alumniService.getAlumniById(id);
    }

    @PostMapping
    public GetFullAlumniDto saveAlumni(@RequestBody PostFullAlumniDto postFullAlumniDto) {
        return alumniService.saveAlumni(postFullAlumniDto);
    }

    @PutMapping("/{id}")
    public GetFullAlumniDto updateAlumni(@PathVariable long id, @RequestBody PostFullAlumniDto postFullAlumniDto) {
        return alumniService.updateAlumni(id, postFullAlumniDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAlumni(@PathVariable long id) {
        alumniService.deleteAlumni(id);
    }
    @GetMapping("/graduationYear/{year}")
    public List<GetFullAlumniDto> getAlumniByGraduationYear(@PathVariable int year) {
        return alumniService.getAlumniByGraduationYear(year);
    }

    @GetMapping("/courseName/{courseName}")
    public List<GetFullAlumniDto> getAlumniByCourseName(@PathVariable String courseName) {
        return alumniService.getAlumniByCourseName(courseName);
    }

    @GetMapping("/address")
    public List<GetFullAlumniDto> getAlumniByAddress(@RequestBody Address address) {
        return alumniService.getAlumniByAddress(address);
    }

    @GetMapping("/industry/{industry}")
    public List<GetFullAlumniDto> getAlumniByIndustry(@PathVariable String industry) {
        return alumniService.getAlumniByIndustry(industry);
    }

}
