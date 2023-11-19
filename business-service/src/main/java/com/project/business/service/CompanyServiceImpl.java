package com.project.business.service;

import com.project.business.dto.get.GetFullCompanyDto;
import com.project.business.dto.post.PostFullCompanyDto;
import com.project.business.model.Address;
import com.project.business.model.Company;
import com.project.business.repository.CompanyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;
    @Override
    public GetFullCompanyDto addCompany(PostFullCompanyDto fullCompanyDto) {
        Company savedC = modelMapper.map(fullCompanyDto, Company.class);
        Address savedA = savedC.getAddress();
        savedA.setCompany(savedC);
        companyRepository.save(savedC);
        GetFullCompanyDto returnC = modelMapper.map(savedC, GetFullCompanyDto.class);
        return returnC;
    }

    @Override
    public List<GetFullCompanyDto> getAll() {
        return companyRepository.findAll().stream()
                .map(c -> modelMapper.map(c, GetFullCompanyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetFullCompanyDto getById(Long id) {
        Company company = companyRepository.findById(id).orElseThrow();
        return modelMapper.map(company, GetFullCompanyDto.class);
    }

    @Transactional
    @Override
    public GetFullCompanyDto updateById(Long id, PostFullCompanyDto postFullCompanyDto) {
        Company company = companyRepository.findById(id).orElseThrow();
        Address address = company.getAddress();
        address.setCity(postFullCompanyDto.getAddress().getCity());
        address.setState(postFullCompanyDto.getAddress().getState());
        address.setStreet(postFullCompanyDto.getAddress().getStreet());
        address.setZip(postFullCompanyDto.getAddress().getZip());
        company.setIndustry(postFullCompanyDto.getIndustry());
        company.setName(postFullCompanyDto.getName());
        return modelMapper.map(company, GetFullCompanyDto.class);
    }

    @Transactional
    @Override
    public GetFullCompanyDto deleteById(Long id) {
        Company company = companyRepository.findById(id).orElseThrow();
        GetFullCompanyDto retCompany = modelMapper.map(company, GetFullCompanyDto.class);
        companyRepository.delete(company);
        return retCompany;
    }
}
