package com.project.ea.controller;

import com.project.ea.dto.get.GetFullEventDto;
import com.project.ea.dto.post.PostFullAlumniEvent;
import com.project.ea.dto.post.PostFullEventDto;
import com.project.ea.service.EventService;
import com.project.ea.model.AlumniEvent;
import com.project.ea.model.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

   @PostMapping
    public GetFullEventDto addEvent(@RequestBody PostFullEventDto postFullEventDto) {
       return eventService.addEvent(postFullEventDto);
    }
   @DeleteMapping("/{id}")
   public void deleteById(@PathVariable long id) {
        eventService.deleteById(id);
    }

    @PutMapping("/{id}")
    public GetFullEventDto updateEventById(@PathVariable long id, @RequestBody PostFullEventDto postFullEventDto) {
        return eventService.updateById(id, postFullEventDto);
    }
    @GetMapping("/{id}")
    public GetFullEventDto getById(@PathVariable long id){
       return  eventService.getById(id);
    }
   @GetMapping("/{id}/")
   public GetFullEventDto addAlumniEventToEvent(@PathVariable Long id, @RequestBody PostFullAlumniEvent postFullAlumniEvent){
       return eventService.addAlumniEventToEvent(id,postFullAlumniEvent);
   }
@PutMapping("/{id}/")
public GetFullEventDto updateAlumniEventInEvent(@PathVariable Long id, PostFullAlumniEvent postFullAlumniEvent){
     return   eventService.updateAlumniEventInEvent(id,postFullAlumniEvent);
}
}
