package com.project.ea.service;

import com.project.ea.dto.get.GetFullEventDto;
import com.project.ea.dto.post.PostFullAlumniEvent;
import com.project.ea.dto.post.PostFullEventDto;
import com.project.ea.model.AlumniEvent;

import java.util.List;

public interface EventService {
    List<GetFullEventDto> getAll();

    GetFullEventDto getById(long id);

    GetFullEventDto addEvent(PostFullEventDto postFullEventDto);

    GetFullEventDto updateById(long id, PostFullEventDto postFullEventDto);

    void deleteById(long id);

    GetFullEventDto addAlumniEventToEvent(Long eventId, PostFullAlumniEvent postFullAlumniEvent);

    GetFullEventDto updateAlumniEventInEvent(Long eventId, PostFullAlumniEvent postFullAlumniEvent);
}
