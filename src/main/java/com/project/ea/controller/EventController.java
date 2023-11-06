package com.project.ea.controller;

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
    public Event AddEvent(@RequestBody Event event) {
       return eventService.AddEvent(event);
    }
   @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        eventService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Event updateEventById(@PathVariable long id, @RequestBody Event event) {
        return eventService.updateById(id, event);
    }
    @GetMapping("/{id}")
    public Event getById(@PathVariable long id){
       return  eventService.getById(id);
    }
   @GetMapping("/{id}/")
    public Event addAlumniEventToEvent(@PathVariable Long id, @RequestBody AlumniEvent alumniEvent){
       return eventService.addAlumniEventToEvent(id,alumniEvent);
   }
@PutMapping("/{id}/")
    public Event updateAlumniEventInEvent(@PathVariable Long id, AlumniEvent alumniEvent){
     return   eventService.updateAlumniEventInEvent(id,alumniEvent);
}
}
