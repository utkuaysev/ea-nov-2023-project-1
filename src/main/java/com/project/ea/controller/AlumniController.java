package com.project.ea.controller;

import com.project.ea.dto.get.GetAlumniDto;
import com.project.ea.dto.post.PostAlumniDto;
import com.project.ea.model.Address;
import com.project.ea.service.AlumniService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alumni")
public class AlumniController {
    private final AlumniService alumniService;
      /*  /alumnies/search?graduationYear -> bacha
/alumnies/search?course_name -> bacha
/alumnies/search/location -> bacha
    We need location body
/alumnies/search?industry -> bacha
    Crud university  -> bacha
*/

    @GetMapping
    public List<GetAlumniDto> getAllAlumni() {
        return alumniService.getAllAlumni();
    }

    @GetMapping("/{id}")
    public GetAlumniDto getAlumniById(@PathVariable long id) {
        return alumniService.getAlumniById(id);
    }

    @PostMapping
    public GetAlumniDto saveAlumni(@RequestBody PostAlumniDto postAlumniDto) {
        return alumniService.saveAlumni(postAlumniDto);
    }

    @PutMapping("/{id}")
    public GetAlumniDto updateAlumni(@PathVariable long id, @RequestBody PostAlumniDto postAlumniDto) {
        return alumniService.updateAlumni(id, postAlumniDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAlumni(@PathVariable long id) {
        alumniService.deleteAlumni(id);
    }
    @GetMapping("/graduationYear/{year}")
    public List<GetAlumniDto> getAlumniByGraduationYear(@PathVariable int year) {
        return alumniService.getAlumniByGraduationYear(year);
    }

    @GetMapping("/courseName/{courseName}")
    public List<GetAlumniDto> getAlumniByCourseName(@PathVariable String courseName) {
        return alumniService.getAlumniByCourseName(courseName);
    }

    @GetMapping("/address")
    public List<GetAlumniDto> getAlumniByAddress(@RequestBody Address address) {
        return alumniService.getAlumniByAddress(address);
    }

    @GetMapping("/industry/{industry}")
    public List<GetAlumniDto> getAlumniByIndustry(@PathVariable String industry) {
        return alumniService.getAlumniByIndustry(industry);
    }

}
