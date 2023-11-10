package com.project.ea.service;

import com.project.ea.dto.post.PostFullEduExperienceDto;
import com.project.ea.dto.get.GetFullEduExperienceDto;
import com.project.ea.dto.get.GetFullCourseDto;
import com.project.ea.model.*;
import com.project.ea.repository.AlumniRepo;
import com.project.ea.repository.CourseRepo;
import com.project.ea.repository.EduExperienceRepository;
import com.project.ea.repository.UniversityRepo;
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
    private final UniversityRepo universityRepo;
    private final CourseRepo courseRepo;
    private final AlumniRepo alumniRepo;
    private final ModelMapper modelMapper;

    @Override
    public GetFullEduExperienceDto addEduExperience(Long alumniId, PostFullEduExperienceDto eduExperienceDto) {
        University university = universityRepo.findById(eduExperienceDto.getUniversityId())
                .orElseThrow(() -> new RuntimeException("University not found with id: " + eduExperienceDto.getUniversityId()));
        Alumni alumni = alumniRepo.findById(alumniId)
                .orElseThrow(() -> new RuntimeException("Alumni not found with id: " + eduExperienceDto.getUniversityId()));
        List<Course> courseList = new ArrayList<>();
        eduExperienceDto.getCourseIdList().forEach(courseId -> {
            Course course = courseRepo.findById(courseId).orElseThrow();
            if (course.getUniversity().getId() != university.getId()) {
                throw new NoSuchElementException("Course not found with id:" + courseId);
            }
            courseList.add(course);
        });
        EduExperience eduExperience = modelMapper.map(eduExperienceDto, EduExperience.class);
        eduExperience.setUniversity(university);
        eduExperience.setCourses(courseList);
        eduExperience.setAlumni(alumni);
        eduExperienceRepository.save(eduExperience);
        return populateCoursesAndReturnDto(eduExperience);
    }

    @Override
    public GetFullEduExperienceDto getByAlumniId(Long alumniId) {
        EduExperience eduExperience = eduExperienceRepository.findByAlumni_Id(alumniId).orElseThrow();
        return populateCoursesAndReturnDto(eduExperience);
    }

    @Transactional
    @Override
    public GetFullEduExperienceDto updateById(Long alumniId, PostFullEduExperienceDto eduExperienceDto) {
        University university = universityRepo.findById(eduExperienceDto.getUniversityId())
                .orElseThrow(() -> new RuntimeException("University not found with id: " + eduExperienceDto.getUniversityId()));
        Alumni alumni = alumniRepo.findById(alumniId)
                .orElseThrow(() -> new RuntimeException("Alumni not found with id: " + eduExperienceDto.getUniversityId()));
        List<Course> courseList = new ArrayList<>();
        eduExperienceDto.getCourseIdList().forEach(courseId -> {
            Course course = courseRepo.findById(courseId).orElseThrow();
            if (course.getUniversity().getId() != university.getId()) {
                throw new NoSuchElementException("Course not found with id:" + courseId);
            }
            courseList.add(course);
        });
        EduExperience eduExperience = eduExperienceRepository.findByAlumni_Id(alumniId).orElseThrow();
        eduExperience.setUniversity(university);
        eduExperience.setCourses(courseList);
        eduExperience.setAlumni(alumni);
        eduExperience.setDegree(eduExperienceDto.getDegree());
        eduExperience.setEndDate(eduExperienceDto.getEndDate());
        eduExperience.setStartDate(eduExperienceDto.getStartDate());
        eduExperienceRepository.save(eduExperience);
        return populateCoursesAndReturnDto(eduExperience);
    }

    @Transactional
    @Override
    public GetFullEduExperienceDto deleteById(Long alumniId) {
        EduExperience eduExperience = eduExperienceRepository.findByAlumni_Id(alumniId).orElseThrow();
        GetFullEduExperienceDto retEduExperience = populateCoursesAndReturnDto(eduExperience);
        eduExperienceRepository.delete(eduExperience);
        return retEduExperience;
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
