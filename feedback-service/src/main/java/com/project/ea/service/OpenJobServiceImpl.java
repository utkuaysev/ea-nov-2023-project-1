package com.project.ea.service;

import com.project.ea.dto.get.GetFullOpenJobDto;
import com.project.ea.dto.post.PostFullOpenJobDto;
import com.project.ea.model.Alumni;
import com.project.ea.model.Company;
import com.project.ea.model.OpenJob;
import com.project.ea.repository.AlumniRepository;
import com.project.ea.repository.CompanyRepository;
import com.project.ea.repository.OpenJobRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OpenJobServiceImpl implements OpenJobService {
    private final OpenJobRepository openJobRepository;
    private final CompanyRepository companyRepo;
    private final AlumniRepository alumniRepo;
    private final ModelMapper modelMapper;

    @Override
    public GetFullOpenJobDto addOpenJob(PostFullOpenJobDto openJobDto) {
        Alumni creator = alumniRepo.findById(openJobDto.getCreatorAlumniId()).orElseThrow();
        Company company = creator.getProfExperiences().stream()
                .filter(profExperience -> profExperience.getEndDate() == null)
                .findFirst().orElseThrow()
                .getCompany();
        OpenJob openJob = modelMapper.map(openJobDto, OpenJob.class);
        openJob.setId(null);
        openJob.setCompany(company);
        openJob.setCreator(creator);
        openJob.setApplicants(
                openJobDto.getApplicantIds().stream()
                        .map(applicantId -> {
                            Alumni alumni = alumniRepo.findById(applicantId).orElseThrow();
                            return modelMapper.map(alumni, Alumni.class);
                        })
                        .collect(Collectors.toList())
        );
        openJobRepository.save(openJob);
        return populateAndReturnDto(openJob);
    }

    @Override
    public List<GetFullOpenJobDto> getAll() {
        return openJobRepository.findAll().stream()
                .map(this::populateAndReturnDto)
                .collect(Collectors.toList());
    }

    @Override
    public GetFullOpenJobDto getById(Long id) {
        OpenJob openJob = openJobRepository.findById(id).orElseThrow();
        return populateAndReturnDto(openJob);
    }

    @Override
    public List<GetFullOpenJobDto> searchByState(String state) {
        return openJobRepository.findAllByCompany_Address_State(state).stream()
                .map(this::populateAndReturnDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GetFullOpenJobDto> searchByCity(String city) {
        return openJobRepository.findAllByCompany_Address_City(city).stream()
                .map(this::populateAndReturnDto)
                .collect(Collectors.toList());

    }

    @Override
    public List<GetFullOpenJobDto> searchBycompanyName(String companyName) {
        return openJobRepository.findAllByCompany_Name(companyName).stream()
                .map(this::populateAndReturnDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public GetFullOpenJobDto updateById(Long id, PostFullOpenJobDto openJobDto) {
        Alumni creator = alumniRepo.findById(openJobDto.getCreatorAlumniId()).orElseThrow();
        Company company = creator.getProfExperiences().stream()
                .filter(profExperience -> profExperience.getEndDate() == null)
                .findFirst().orElseThrow()
                .getCompany();
        OpenJob openJob;
        openJob = modelMapper.map(openJobDto, OpenJob.class);
        openJob.setCompany(company);
        openJob.setCreator(creator);
        openJob.setApplicants(
                openJobDto.getApplicantIds().stream()
                        .map(applicantId -> {
                            Alumni alumni = alumniRepo.findById(applicantId).orElseThrow();
                            return modelMapper.map(alumni, Alumni.class);
                        })
                        .collect(Collectors.toList())
        );
        openJobRepository.save(openJob);
        return populateAndReturnDto(openJob);
    }

    @Transactional
    @Override
    public GetFullOpenJobDto deleteById(Long id) {
        OpenJob openJob = openJobRepository.findById(id).orElseThrow();
        GetFullOpenJobDto retOpenJob = populateAndReturnDto(openJob);
        openJobRepository.delete(openJob);
        return retOpenJob;
    }
    private GetFullOpenJobDto populateAndReturnDto(OpenJob openJob){
        GetFullOpenJobDto obj = modelMapper.map(openJob, GetFullOpenJobDto.class);
        obj.setCompanyName(openJob.getCompany().getName());
        obj.setCompanyIndustry(openJob.getCompany().getIndustry());
        obj.setState(openJob.getCompany().getAddress().getState());
        obj.setCity(openJob.getCompany().getAddress().getCity());
        obj.setApplicants(
                openJob.getApplicants().stream()
                        .map(alumni -> modelMapper.map(alumni, GetFullOpenJobDto.InnerAlumniDto.class))
                        .collect(Collectors.toList())
        );
        return obj;
    }
}
