package com.project.ea.repository;

import com.project.ea.model.ProfExperience;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfExperienceRepository extends ListCrudRepository<ProfExperience, Long> {
//    List<ProfExperience> findAllByAlumni_Id(Long alumniId);
//    Optional<ProfExperience> findByAlumni_IdAndId(Long alumniId, Long id);

    @Override
    default void delete(ProfExperience profExperience) {
        profExperience.setDeleted(true);
    }
}
