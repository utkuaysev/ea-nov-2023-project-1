package com.project.ea.repository;

import com.project.ea.model.EduExperience;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EduExperienceRepository extends ListCrudRepository<EduExperience, Long> {
    List<EduExperience> findAllByAlumni_Id(Long id);
}
