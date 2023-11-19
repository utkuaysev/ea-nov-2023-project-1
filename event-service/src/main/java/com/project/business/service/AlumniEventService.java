package com.project.business.service;

import com.project.business.dto.get.GetFullAlumniEventDto;
import com.project.business.dto.post.PostFullAlumniEventDto;

import java.util.List;

public interface AlumniEventService {

    List<GetFullAlumniEventDto> getAllAlumniEvents();
    GetFullAlumniEventDto getAlumniEventById(long alumniId, long eventId);
    GetFullAlumniEventDto saveAlumniEvent(PostFullAlumniEventDto alumniEventDto);
    GetFullAlumniEventDto updateAlumniEvent(long alumniId, long eventId, PostFullAlumniEventDto alumniEventDto);
    void deleteAlumniEvent(long alumniId, long eventId);
}
