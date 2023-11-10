package com.project.ea.controller;

import com.project.ea.dto.get.GetFullOpenJobDto;
import com.project.ea.dto.post.PostFullOpenJobDto;
import com.project.ea.service.OpenJobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/open_jobs")
@RequiredArgsConstructor
public class OpenJobController {
    private final OpenJobService openJobService;


    @PostMapping
    public GetFullOpenJobDto addOpenJob(@RequestBody PostFullOpenJobDto openJob) {
        return openJobService.addOpenJob(openJob);
    }

    @GetMapping
    public List<GetFullOpenJobDto> getAllOpenJobs() {
            return openJobService.getAll();
    }

    @GetMapping("/{id}")
    public GetFullOpenJobDto getOpenJobById(@PathVariable Long id) {
        try {
            return openJobService.getById(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Open Job not found");
        }
    }

    @PutMapping("/{id}")
    public GetFullOpenJobDto updateById(@PathVariable Long id,
                                              @RequestBody PostFullOpenJobDto postFullOpenJobDto) {
        try {
            return openJobService.updateById(id, postFullOpenJobDto);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Open Job not found");
        }
    }

    @DeleteMapping("/{id}")
    public GetFullOpenJobDto deleteById(@PathVariable Long id) {
        try {
            return openJobService.deleteById(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Open Job not found");
        }
    }
}
