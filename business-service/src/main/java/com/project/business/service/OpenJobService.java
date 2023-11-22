package com.project.business.service;

import com.project.business.dto.get.GetFullOpenJobDto;
import com.project.business.dto.post.PostOpenJobDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface OpenJobService {
    GetFullOpenJobDto addOpenJob(PostOpenJobDto openJob);

    List<GetFullOpenJobDto> getAll();

    GetFullOpenJobDto getById(Long alumniId);

    List<GetFullOpenJobDto> searchByState(String state);

    List<GetFullOpenJobDto> searchByCity(String city);

    List<GetFullOpenJobDto> searchBycompanyName(String companyName);


    @Transactional
    GetFullOpenJobDto updateById(Long id, PostOpenJobDto openJobDto);

    @Transactional
    GetFullOpenJobDto deleteById(Long id);

}
