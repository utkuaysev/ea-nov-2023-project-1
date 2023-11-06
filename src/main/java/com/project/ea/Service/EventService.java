package com.project.ea.Service;

import com.project.ea.model.Alumni;
import com.project.ea.model.AlumniEvent;
import com.project.ea.model.Event;

import java.util.List;

public interface EventService {
    Event AddEvent(Event event);
    void deleteById(long id);
    Event updateById(long id,Event event);
    Event getById(long id);
    List<Event> getAll();
    Event addAlumniEventToEvent(Long eventId, AlumniEvent alumniEvent);
    Event updateAlumniEventInEvent(Long eventId, AlumniEvent alumniEvent);
}
//    AlumniEvent addAlumniEvent(AlumniEvent alumniEvent, Event event);
//    AlumniEvent updateById(long id,AlumniEvent alumniEvent);