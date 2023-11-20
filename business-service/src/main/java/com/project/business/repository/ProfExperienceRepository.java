package com.project.business.repository;

import com.project.business.model.ProfExperience;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfExperienceRepository extends ListCrudRepository<ProfExperience, Long> {
      List<ProfExperience> findAllByAlumniId(Long alumniId);
//    Optional<ProfExperience> findByAlumni_IdAndId(Long alumniId, Long id);

    @Override
    default void delete(ProfExperience profExperience) {
        profExperience.setDeleted(true);
    }
}
