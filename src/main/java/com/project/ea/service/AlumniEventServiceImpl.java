package com.project.ea.service;

import com.project.ea.repository.AlumniEventRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlumniEventServiceImpl  implements AlumniEventService{
    private final AlumniEventRepository alumniEventRepository;
    private final ModelMapper modelMapper;
}
