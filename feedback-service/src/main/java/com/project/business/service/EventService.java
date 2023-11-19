package com.project.business.service;

import com.project.business.dto.get.GetFullEventDto;
import com.project.business.dto.post.PostFullEventDto;

import java.util.List;

public interface EventService {
    List<GetFullEventDto> getAll();

    GetFullEventDto getById(long id);

    GetFullEventDto addEvent(PostFullEventDto postFullEventDto);

    GetFullEventDto updateById(long id, PostFullEventDto postFullEventDto);

    void deleteById(long id);

}
