package com.project.user.service.feign;

import com.project.user.dto.get.GetFullEduExperienceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@FeignClient("EDUCATION-SERVICE")
public interface EducationServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/edu_experiences/{id}")
    GetFullEduExperienceDto getEduExperience(@PathVariable("id") Long id);
    @RequestMapping(method = RequestMethod.GET, value = "/edu_experiences/searchByGradYear/{year}")
    List<GetFullEduExperienceDto> getEduExperiencesByGradYear(@PathVariable int year);
    @RequestMapping(method = RequestMethod.GET, value = "/edu_experiences/searchByCourse/{course}")
    List<GetFullEduExperienceDto> getEduExperiencesByCourse(@PathVariable String course);
    @RequestMapping(method = RequestMethod.GET, value = "/edu_experiences/alumni/{alumniId}")
    List<GetFullEduExperienceDto> getEduExperiencesByAlumniId(Long id);
}