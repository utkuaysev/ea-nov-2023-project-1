package com.project.business.service.feign;

import com.project.business.dto.get.GetFullAlumniDto;
import com.project.business.dto.get.GetProfExperienceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@FeignClient("BUSINESS-SERVICE")
public interface BusinessServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/prof_experiences/{id}")
    GetProfExperienceDto getProfExperience(@PathVariable("id") Long id);
    @RequestMapping(method = RequestMethod.GET, value = "/prof_experiences/alumni/{alumniId}")
    List<GetProfExperienceDto> getProfExperiencesByAlumniId(@PathVariable Long alumniId);
}