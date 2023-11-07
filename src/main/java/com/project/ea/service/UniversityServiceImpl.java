package com.project.ea.service;

import com.project.ea.dto.get.GetUniversityDto;
import com.project.ea.dto.post.PostUniversityDto;
import com.project.ea.model.University;
import com.project.ea.repository.UniversityRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {
    private final UniversityRepo universityRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<GetUniversityDto> getAllUniversities() {
        List<University> universities = universityRepo.findAll();
        return universities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public GetUniversityDto getUniversityById(long id) {
        University university = universityRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("University not found with id: " + id));
        return convertToDto(university);
    }

    @Override
    public GetUniversityDto saveUniversity(PostUniversityDto postUniversityDto) {
        University university = convertToEntity(postUniversityDto);
        University savedUniversity = universityRepo.save(university);
        return convertToDto(savedUniversity);
    }

    @Override
    public GetUniversityDto updateUniversity(long id, PostUniversityDto postUniversityDto) {
        University university = universityRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("University not found with id: " + id));
        university.setId(id);
        University updatedUniversity = universityRepo.save(university);
        return convertToDto(updatedUniversity);
    }

    @Override
    public void deleteUniversity(long id) {
        University university = universityRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("University not found with id: " + id));
        universityRepo.delete(university);
    }

    // Helper methods for conversion
    private GetUniversityDto convertToDto(University university) {
        return modelMapper.map(university, GetUniversityDto.class);
    }

    private University convertToEntity(PostUniversityDto postUniversityDto) {
        return modelMapper.map(postUniversityDto, University.class);
    }
}
