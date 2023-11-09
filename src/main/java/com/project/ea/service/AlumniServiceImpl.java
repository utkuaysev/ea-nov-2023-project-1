package com.project.ea.service;

import com.project.ea.dto.get.GetFullAlumniDto;
import com.project.ea.dto.post.PostFullAlumniDto;
import com.project.ea.model.Address;
import com.project.ea.model.Alumni;
import com.project.ea.repository.AlumniRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlumniServiceImpl implements AlumniService {
    private final AlumniRepo alumniRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<GetFullAlumniDto> getAllAlumni() {
        List<GetFullAlumniDto> result = new ArrayList<>();
        var alumni = alumniRepo.findAll();
        alumni.forEach(a -> result.add(modelMapper.map(a, GetFullAlumniDto.class)));
        return result;
    }

    @Override
    public GetFullAlumniDto getAlumniById(long id) {
        var alumni = alumniRepo.findById(id).orElseThrow();
        return modelMapper.map(alumni, GetFullAlumniDto.class);
    }

    @Override
    public GetFullAlumniDto saveAlumni(PostFullAlumniDto postFullAlumniDto) {
        Alumni alumni = modelMapper.map(postFullAlumniDto, Alumni.class);
        var result = alumniRepo.save(alumni);
        return modelMapper.map(result, GetFullAlumniDto.class);
    }

    @Override
    public GetFullAlumniDto updateAlumni(long id, PostFullAlumniDto postFullAlumniDto) {
        if (alumniRepo.existsById(id)) {
            Alumni alumni = modelMapper.map(postFullAlumniDto, Alumni.class);
            alumni.setId(id);
            var result = alumniRepo.save(alumni);
            return modelMapper.map(result, GetFullAlumniDto.class);
        }
        throw new RuntimeException("""
                No Alumni with id:${id} exists.""");
    }

    @Override
    public void deleteAlumni(long id) {
        alumniRepo.deleteById(id);
    }

    @Override
    public List<GetFullAlumniDto> getAlumniByGraduationYear(int year) {
        List<GetFullAlumniDto> result = new ArrayList<>();
        LocalDate localDate1 = LocalDate.of(year,1,1);
        LocalDate localDate2 = LocalDate.of(year,12,31);
        var alumni = alumniRepo.findByEduExperience_EndDateBetween(localDate1,localDate2);
        alumni.forEach(a -> result.add(modelMapper.map(a, GetFullAlumniDto.class)));
        return result;
    }

    @Override
    public List<GetFullAlumniDto> getAlumniByCourseName(String courseName) {
        List<GetFullAlumniDto> result = new ArrayList<>();
        var alumni = alumniRepo.findByEduExperience_Courses_Name(courseName);
        alumni.forEach(a -> result.add(modelMapper.map(a, GetFullAlumniDto.class)));
        return result;
    }

    @Override
    public List<GetFullAlumniDto> getAlumniByAddress(Address address) {
        List<GetFullAlumniDto> result = new ArrayList<>();
        var alumni = alumniRepo.findByAddress(address);
        alumni.forEach(a -> result.add(modelMapper.map(a, GetFullAlumniDto.class)));
        return result;
    }

    @Override
    public List<GetFullAlumniDto> getAlumniByIndustry(String industry) {
        List<GetFullAlumniDto> result = new ArrayList<>();
        var alumni = alumniRepo.findByProfExperiences_Company_Industry(industry);
        alumni.forEach(a -> result.add(modelMapper.map(a, GetFullAlumniDto.class)));
        return result;
    }
}
