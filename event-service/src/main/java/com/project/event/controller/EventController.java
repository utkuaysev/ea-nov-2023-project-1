package com.project.event.controller;

import com.project.event.dto.get.GetFullEventDto;
import com.project.event.dto.post.PostFullEventDto;
import com.project.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
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

}
