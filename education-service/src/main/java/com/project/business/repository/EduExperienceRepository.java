package com.project.business.repository;

import com.project.business.model.EduExperience;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EduExperienceRepository extends ListCrudRepository<EduExperience, Long> {
//    Optional<EduExperience> findByAlumni_Id(Long alumniId);
    @Override
    default void delete(EduExperience eduExperience) {
        eduExperience.setDeleted(true);
    }
}
