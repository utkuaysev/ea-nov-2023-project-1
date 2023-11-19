package com.project.business.repository;

import com.project.business.model.ProfExperience;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfExperienceRepository extends ListCrudRepository<ProfExperience, Long> {
//    List<ProfExperience> findAllByAlumni_Id(Long alumniId);
//    Optional<ProfExperience> findByAlumni_IdAndId(Long alumniId, Long id);

    @Override
    default void delete(ProfExperience profExperience) {
        profExperience.setDeleted(true);
    }
}
