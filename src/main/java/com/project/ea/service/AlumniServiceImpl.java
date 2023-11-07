package com.project.ea.service;

import com.project.ea.dto.get.GetAlumniDto;
import com.project.ea.dto.post.PostAlumniDto;
import com.project.ea.model.Address;
import com.project.ea.model.Alumni;
import com.project.ea.repository.AlumniRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlumniServiceImpl implements AlumniService {
    private final AlumniRepo alumniRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<GetAlumniDto> getAllAlumni() {
        List<GetAlumniDto> result = new ArrayList<>();
        var alumni = alumniRepo.findAll();
        alumni.forEach(a -> result.add(modelMapper.map(a, GetAlumniDto.class)));
        return result;
    }

    @Override
    public GetAlumniDto getAlumniById(long id) {
        var alumni = alumniRepo.findById(id).orElseThrow();
        return modelMapper.map(alumni, GetAlumniDto.class);
    }

    @Override
    public GetAlumniDto saveAlumni(PostAlumniDto postAlumniDto) {
        Alumni alumni = modelMapper.map(postAlumniDto, Alumni.class);
        var result = alumniRepo.save(alumni);
        return modelMapper.map(result, GetAlumniDto.class);
    }

    @Override
    public GetAlumniDto updateAlumni(long id, PostAlumniDto postAlumniDto) {
        if (alumniRepo.existsById(id)) {
            Alumni alumni = modelMapper.map(postAlumniDto, Alumni.class);
            alumni.setId(id);
            var result = alumniRepo.save(alumni);
            return modelMapper.map(result, GetAlumniDto.class);
        }
        throw new RuntimeException("""
                No Alumni with id:${id} exists.""");
    }

    @Override
    public void deleteAlumni(long id) {
        alumniRepo.deleteById(id);
    }

    @Override
    public List<GetAlumniDto> getAlumniByGraduationYear(int year) {
        List<GetAlumniDto> result = new ArrayList<>();
        var alumni = alumniRepo.findByEduExperience_EndDate_Year(year);
        alumni.forEach(a -> result.add(modelMapper.map(a, GetAlumniDto.class)));
        return result;
    }

    @Override
    public List<GetAlumniDto> getAlumniByCourseName(String courseName) {
        List<GetAlumniDto> result = new ArrayList<>();
        var alumni = alumniRepo.findByEduExperience_Courses_Name(courseName);
        alumni.forEach(a -> result.add(modelMapper.map(a, GetAlumniDto.class)));
        return result;
    }

    @Override
    public List<GetAlumniDto> getAlumniByAddress(Address address) {
        List<GetAlumniDto> result = new ArrayList<>();
        var alumni = alumniRepo.findByAddress(address);
        alumni.forEach(a -> result.add(modelMapper.map(a, GetAlumniDto.class)));
        return result;
    }

    @Override
    public List<GetAlumniDto> getAlumniByIndustry(String industry) {
        List<GetAlumniDto> result = new ArrayList<>();
        var alumni = alumniRepo.findByProfExperiences_Company_Industry(industry);
        alumni.forEach(a -> result.add(modelMapper.map(a, GetAlumniDto.class)));
        return result;
    }
}
