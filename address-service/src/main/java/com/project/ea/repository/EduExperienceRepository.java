package com.project.ea.repository;

import com.project.ea.model.Address;
import com.project.ea.model.Company;
import com.project.ea.model.EduExperience;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EduExperienceRepository extends ListCrudRepository<EduExperience, Long> {
    Optional<EduExperience> findByAlumni_Id(Long alumniId);
    @Override
    default void delete(EduExperience eduExperience) {
        eduExperience.setDeleted(true);
    }
}
