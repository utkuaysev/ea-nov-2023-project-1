package com.project.business.service;

import com.project.business.dto.get.GetFullAlumniDto;
import com.project.business.dto.post.PostFullAlumniDto;
import com.project.business.model.Alumni;
import com.project.business.repository.AlumniRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlumniServiceImpl implements AlumniService {
    private final AlumniRepository alumniRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<GetFullAlumniDto> getAllAlumni() {
        List<GetFullAlumniDto> result = new ArrayList<>();
        var alumni = alumniRepository.findAll();
        alumni.forEach(a -> result.add(modelMapper.map(a, GetFullAlumniDto.class)));
        return result;
    }

    @Override
    public GetFullAlumniDto getAlumniById(long id) {
        var alumni = alumniRepository.findById(id).orElseThrow();
        return modelMapper.map(alumni, GetFullAlumniDto.class);
    }

    @Override
    public GetFullAlumniDto saveAlumni(PostFullAlumniDto postFullAlumniDto) {
        Alumni alumni = modelMapper.map(postFullAlumniDto, Alumni.class);
        var result = alumniRepository.save(alumni);
        return modelMapper.map(result, GetFullAlumniDto.class);
    }

    @Override
    public GetFullAlumniDto updateAlumni(long id, PostFullAlumniDto postFullAlumniDto) {
        if (alumniRepository.existsById(id)) {
            Alumni alumni = modelMapper.map(postFullAlumniDto, Alumni.class);
            alumni.setId(id);
            var result = alumniRepository.save(alumni);
            return modelMapper.map(result, GetFullAlumniDto.class);
        }
        throw new RuntimeException("""
                No Alumni with id:${id} exists.""");
    }

    @Override
    public void deleteAlumni(long id) {
        alumniRepository.deleteById(id);
    }


}
