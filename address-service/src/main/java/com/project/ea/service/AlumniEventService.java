package com.project.ea.service;

import com.project.ea.dto.get.GetFullAlumniDto;
import com.project.ea.dto.get.GetFullAlumniEventDto;
import com.project.ea.dto.post.PostFullAlumniEventDto;
import com.project.ea.dto.post.PostFullEventDto;
import com.project.ea.model.AlumniEvent;

import java.util.List;

public interface AlumniEventService {

    List<GetFullAlumniEventDto> getAllAlumniEvents();
    GetFullAlumniEventDto getAlumniEventById(long alumniId, long eventId);
    GetFullAlumniEventDto saveAlumniEvent(PostFullAlumniEventDto alumniEventDto);
    GetFullAlumniEventDto updateAlumniEvent(long alumniId, long eventId, PostFullAlumniEventDto alumniEventDto);
    void deleteAlumniEvent(long alumniId, long eventId);
}
