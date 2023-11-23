package com.project.education.service;

import com.project.education.dto.get.GetFullCourseDto;
import com.project.education.dto.get.GetFullEduExperienceDto;
import com.project.education.dto.put.PutFullEduExperienceDto;
import com.project.education.repository.EduExperienceRepository;
import com.project.education.model.EduExperience;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EduExperienceServiceImpl implements EduExperienceService {
    private final EduExperienceRepository eduExperienceRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<GetFullEduExperienceDto> getAllByAlumniId(Long alumniId) {
        List<EduExperience> eduExperiences = eduExperienceRepository.findAllByAlumniId(alumniId);
        return eduExperiences.stream()
                .map(this::populateCoursesAndReturnDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GetFullEduExperienceDto> getAllByGradYear(int year) {
        List<EduExperience> eduExperiences = eduExperienceRepository.findAllByEndDate_Year(year);
        return eduExperiences.stream()
                .map(this::populateCoursesAndReturnDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GetFullEduExperienceDto> getAllByCourseName(String course) {
        List<EduExperience> eduExperiences = eduExperienceRepository.findByCourseName(course);
        return eduExperiences.stream()
                .map(this::populateCoursesAndReturnDto)
                .collect(Collectors.toList());
    }

    @Override
    public GetFullEduExperienceDto getById(Long id) {
            var pe = eduExperienceRepository.findById(id).orElseThrow();
            return populateCoursesAndReturnDto(pe);
        }
    @Transactional
    @Override
    public void deleteById(Long id) {
        eduExperienceRepository.deleteById(id);

    }
    private GetFullEduExperienceDto populateCoursesAndReturnDto(EduExperience eduExperience){
        List<GetFullCourseDto> courseDtoList = new ArrayList<>();
        GetFullEduExperienceDto obj = modelMapper.map(eduExperience, GetFullEduExperienceDto.class);
        eduExperience.getCourses().forEach(course ->
                courseDtoList.add(modelMapper.map(course, GetFullCourseDto.class)));
        obj.setCourseList(courseDtoList);
        return obj;
    }
}
