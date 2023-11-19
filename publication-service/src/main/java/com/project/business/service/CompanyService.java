package com.project.business.service;

import com.project.business.dto.get.GetFullCompanyDto;
import com.project.business.dto.post.PostFullCompanyDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CompanyService {
    GetFullCompanyDto addCompany(PostFullCompanyDto company);

    List<GetFullCompanyDto> getAll();

    GetFullCompanyDto getById(Long id);


    @Transactional
    GetFullCompanyDto updateById(Long id, PostFullCompanyDto postFullCompanyDto);

    GetFullCompanyDto deleteById(Long id);
}
