package com.project.ea.controller;

import com.project.ea.dto.get.GetFullCompanyDto;
import com.project.ea.dto.post.PostFullCompanyDto;
import com.project.ea.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    public GetFullCompanyDto addCompany(@RequestBody PostFullCompanyDto company) {
        return companyService.addCompany(company);
    }

    @GetMapping
    public List<GetFullCompanyDto> getAll(){
        return companyService.getAll();
    }
    @GetMapping("/{id}")
    public GetFullCompanyDto getById(@PathVariable Long id){
        try {
            return companyService.getById(id);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found");
        }
    }
    @PutMapping("/{id}")
    public GetFullCompanyDto updateById(@PathVariable Long id, @RequestBody PostFullCompanyDto postFullCompanyDto){
        try {
            return companyService.updateById(id, postFullCompanyDto);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found");
        }
    }
    @DeleteMapping("/{id}")
    public GetFullCompanyDto deleteById(@PathVariable Long id){
        try {
            return companyService.deleteById(id);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found");
        }
    }
}
