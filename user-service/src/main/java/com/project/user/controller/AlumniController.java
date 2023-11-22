package com.project.user.controller;

import com.project.user.dto.get.GetAlumniAuth;
import com.project.user.dto.get.GetFullAlumniDto;
import com.project.user.dto.post.AuthRequest;
import com.project.user.dto.post.PostFullAlumniDto;
import com.project.user.dto.put.PutFullAlumniDto;
import com.project.user.service.AlumniService;
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

    @GetMapping
    public List<GetFullAlumniDto> getAllAlumni() {
        return alumniService.getAllAlumni();
    }

    @GetMapping("/{id}")
    public GetFullAlumniDto getAlumniById(@PathVariable long id) {
        return alumniService.getAlumniById(id);
    }

    @GetMapping("/searchByMail/{mail}")
    public GetAlumniAuth getAlumniByMail(@PathVariable String mail) {
        return alumniService.getAlumniByMail(mail);
    }

    @PostMapping
    public ResponseEntity<GetAlumniAuth> saveAlumni(@RequestBody AuthRequest authRequest) {
        var res = alumniService.saveAlumni(authRequest);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAlumni(@PathVariable long id, @RequestBody PutFullAlumniDto putFullAlumniDto) {
        alumniService.updateAlumni(id, putFullAlumniDto);
        return new ResponseEntity<>("Alumni updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAlumni(@PathVariable long id) {
        alumniService.deleteAlumni(id);
        return new ResponseEntity<>("Alumni deleted successfully", HttpStatus.OK);
    }
//    @GetMapping("/graduationYear/{year}")
//    public List<GetFullAlumniDto> getAlumniByGraduationYear(@PathVariable int year) {
//        return alumniService.getAlumniByGraduationYear(year);
//    }
//
//    @GetMapping("/courseName/{courseName}")
//    public List<GetFullAlumniDto> getAlumniByCourseName(@PathVariable String courseName) {
//        return alumniService.getAlumniByCourseName(courseName);
//    }


}