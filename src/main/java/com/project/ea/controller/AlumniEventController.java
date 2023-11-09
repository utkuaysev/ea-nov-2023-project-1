package com.project.ea.controller;

import com.project.ea.service.AlumniEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("alumni-events")
public class AlumniEventController {
    private final AlumniEventService alumniEventService;
//    private final
//    @GetMapping("/{id}/")
//    public GetFullEventDto addEvent(@PathVariable Long id, @RequestBody List<PostFullAlumniEventDto> postFullAlumniEventDtos){
//        return eventService.addAlumniEventToEvent(id, postFullAlumniEventDtos);
//    }
//    @PutMapping("/{id}/")
//    public GetFullEventDto updateAlumniEvent(@PathVariable Long id, PostFullAlumniEventDto postFullAlumniEventDto){
//        return   eventService.updateAlumniEventInEvent(id, postFullAlumniEventDto);
//    }
}
