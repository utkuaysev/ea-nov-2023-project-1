package com.project.ea.service;

import com.project.ea.dto.get.GetFullEventDto;
import com.project.ea.dto.post.PostFullAlumniEventDto;
import com.project.ea.dto.post.PostFullEventDto;

import java.util.List;

public interface EventService {
    List<GetFullEventDto> getAll();

    GetFullEventDto getById(long id);

    GetFullEventDto addEvent(PostFullEventDto postFullEventDto);

    GetFullEventDto updateById(long id, PostFullEventDto postFullEventDto);

    void deleteById(long id);

}
