package com.project.ea.service;

import com.project.ea.dto.get.GetFullCourseDto;
import com.project.ea.dto.get.GetFullEduExperienceDto;
import com.project.ea.repository.EduExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EduExperienceServiceImpl implements EduExperienceService{
    private final EduExperienceRepository eduExperienceRepo;
    private final ModelMapper modelMapper;
    @Override
    public List<GetFullEduExperienceDto> getAllByAlumniId(Long id) {
        return eduExperienceRepo.findAllByAlumni_Id(id).stream()
                .map(e -> {
                    GetFullEduExperienceDto obj = modelMapper.map(e, GetFullEduExperienceDto.class);
                    List<GetFullCourseDto> courseDtoList = new ArrayList<>();
                    e.getCourses().forEach(course ->
                            courseDtoList.add(modelMapper.map(course, GetFullCourseDto.class)));
                    obj.setCourseList(courseDtoList);
                    return obj;
                })
                .collect(Collectors.toList());
    }
}
