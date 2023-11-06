package com.project.ea.Service;

import com.project.ea.Repository.EventRepository;
import com.project.ea.model.Alumni;
import com.project.ea.model.AlumniEvent;
import com.project.ea.model.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;


    @Override
    public Event AddEvent(Event event) {
        if (event.getEventType() == null) {
            throw new IllegalArgumentException("Event type is required.");
        }
        return eventRepository.save(event);
    }

    @Override
    public void deleteById(long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public Event updateById(long id, Event event) {
         if(eventRepository.existsById(id)){
             event.setId(id);
             return eventRepository.save(event);
         }throw new IllegalArgumentException("Event with ID " + id + " not found.");
    }



    @Override
    public Event getById(long id) {
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("""
                no such element with the give id: ${id}"""));
    }

    @Override
    public List<Event> getAll() {
        return (List<Event>) eventRepository.findAll();
    }

    @Override
    public Event addAlumniEventToEvent(Long eventId, AlumniEvent alumniEvent) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        alumniEvent.setEvent(event);
        event.getAlumniEvents().add(alumniEvent);
        eventRepository.save(event);

        return event;
    }

    @Override
    public Event updateAlumniEventInEvent(Long eventId, AlumniEvent alumniEvent) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        AlumniEvent existingAlumniEvent = event.getAlumniEvents().stream()
                .filter(ae -> ae.getId().equals(alumniEvent.getId()))
                .findFirst()
                .orElse(null);

        if (existingAlumniEvent == null) {
            throw new IllegalArgumentException("AlumniEvent not found in Event");
        }

        // Update properties of existingAlumniEvent with the properties of updatedAlumniEvent.
      //  existingAlumniEvent.setAlumniEvent(updatedAlumniEvent.getAlumniEvent());

        eventRepository.save(event);

        return event;
    }
}