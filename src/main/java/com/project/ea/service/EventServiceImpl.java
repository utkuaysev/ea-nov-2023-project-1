package com.project.ea.service;

import com.project.ea.dto.get.GetFullEventDto;
import com.project.ea.dto.post.PostFullEventDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Override
    public List<GetFullEventDto> getAll() {
        return null;
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
}
