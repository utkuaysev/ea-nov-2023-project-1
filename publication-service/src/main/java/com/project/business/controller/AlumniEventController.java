package com.project.business.controller;

import com.project.business.dto.get.GetFullAlumniEventDto;
import com.project.business.dto.post.PostFullAlumniEventDto;
import com.project.business.service.AlumniEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumni-events")
@RequiredArgsConstructor
public class AlumniEventController {

    private final AlumniEventService alumniEventService;

    @GetMapping
    public ResponseEntity<List<GetFullAlumniEventDto>> getAllAlumniEvents() {
        List<GetFullAlumniEventDto> alumniEvents = alumniEventService.getAllAlumniEvents();
        return ResponseEntity.ok(alumniEvents);
    }

    @GetMapping("/{alumniId}/{eventId}")
    public ResponseEntity<GetFullAlumniEventDto> getAlumniEventById(
            @PathVariable long alumniId,
            @PathVariable long eventId) {
        GetFullAlumniEventDto alumniEvent = alumniEventService.getAlumniEventById(alumniId, eventId);
        return ResponseEntity.ok(alumniEvent);
    }

    @PostMapping
    public ResponseEntity<GetFullAlumniEventDto> saveAlumniEvent(
            @RequestBody PostFullAlumniEventDto alumniEventDto) {
        GetFullAlumniEventDto savedAlumniEvent = alumniEventService.saveAlumniEvent(alumniEventDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAlumniEvent);
    }

    @PutMapping("/{alumniId}/{eventId}")
    public ResponseEntity<GetFullAlumniEventDto> updateAlumniEvent(
            @PathVariable long alumniId,
            @PathVariable long eventId,
            @RequestBody PostFullAlumniEventDto alumniEventDto) {
        GetFullAlumniEventDto updatedAlumniEvent = alumniEventService.updateAlumniEvent(alumniId, eventId, alumniEventDto);
        return ResponseEntity.ok(updatedAlumniEvent);
    }

    @DeleteMapping("/{alumniId}/{eventId}")
    public ResponseEntity<Void> deleteAlumniEvent(
            @PathVariable long alumniId,
            @PathVariable long eventId) {
        alumniEventService.deleteAlumniEvent(alumniId, eventId);
        return ResponseEntity.noContent().build();
    }
}

