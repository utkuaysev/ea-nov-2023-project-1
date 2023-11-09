package com.project.ea.service;

import com.project.ea.dto.get.GetFullEventDto;
import com.project.ea.dto.post.PostFullAlumniEvent;
import com.project.ea.dto.post.PostFullEventDto;
import com.project.ea.repository.EventRepository;
import com.project.ea.model.AlumniEvent;
import com.project.ea.model.Event;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor

public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<GetFullEventDto> getAll() {
        var result = eventRepository.findAll();
        List<GetFullEventDto> getFullEventDtos = new ArrayList<>();
        result.forEach(event -> modelMapper.map(event, GetFullEventDto.class));
        return getFullEventDtos;
    }

    @Override
    public GetFullEventDto getById(long id) {
        return null;
    }

    @Override
    public GetFullEventDto addEvent(PostFullEventDto postFullEventDto) {
        return null;
    }

    @Override
    public GetFullEventDto updateById(long id, PostFullEventDto postFullEventDto) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public GetFullEventDto addAlumniEventToEvent(Long eventId, PostFullAlumniEvent postFullAlumniEvent) {
        return null;
    }

    @Override
    public GetFullEventDto updateAlumniEventInEvent(Long eventId, PostFullAlumniEvent postFullAlumniEvent) {
        return null;
    }
}