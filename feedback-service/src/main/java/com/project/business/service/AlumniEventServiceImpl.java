package com.project.business.service;

import com.project.business.dto.get.GetFullAlumniEventDto;
import com.project.business.dto.post.PostFullAlumniEventDto;
import com.project.business.model.AlumniEvent;
import com.project.business.model.id.AlumniEventId;
import com.project.business.repository.AlumniEventRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlumniEventServiceImpl  implements AlumniEventService{
    private final AlumniEventRepository alumniEventRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<GetFullAlumniEventDto> getAllAlumniEvents() {
        var result = alumniEventRepository.findAll();
        List<GetFullAlumniEventDto> alumniEventDtos = new ArrayList<>();
        result.forEach(alumniEvent -> alumniEventDtos.add(modelMapper.map(alumniEvent, GetFullAlumniEventDto.class)));
        return alumniEventDtos;
    }

    @Override
    public GetFullAlumniEventDto getAlumniEventById(long alumniId, long eventId) {
        var result = alumniEventRepository.findAlumniEventByAlumni_IdAndEvent_Id(alumniId, eventId);
        return modelMapper.map(result, GetFullAlumniEventDto.class);
    }

    @Override
    public GetFullAlumniEventDto saveAlumniEvent(PostFullAlumniEventDto alumniEventDto) {
        var result = alumniEventRepository.save(modelMapper.map(alumniEventDto, AlumniEvent.class));
        return modelMapper.map(result, GetFullAlumniEventDto.class);
    }

    @Override
    public GetFullAlumniEventDto updateAlumniEvent(long alumniId, long eventId, PostFullAlumniEventDto alumniEventDto) {
        AlumniEvent alumniEvent = modelMapper.map(alumniEventDto, AlumniEvent.class);
        AlumniEventId alumniEventId = new AlumniEventId();
        alumniEventId.setEventId(eventId);
        alumniEventId.setAlumniId(alumniId);
        alumniEvent.setId(alumniEventId);
        var result = alumniEventRepository.save(alumniEvent);
        return modelMapper.map(result, GetFullAlumniEventDto.class);
    }

    @Override
    public void deleteAlumniEvent(long alumniId, long eventId) {
        var alumniEvent = alumniEventRepository.findAlumniEventByAlumni_IdAndEvent_Id(alumniId, eventId);
        alumniEventRepository.delete(alumniEvent);
    }

}
