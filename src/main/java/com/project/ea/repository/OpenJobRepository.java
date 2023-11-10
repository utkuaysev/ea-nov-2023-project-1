package com.project.ea.repository;

import com.project.ea.model.OpenJob;
import com.project.ea.model.OpenJob;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OpenJobRepository extends ListCrudRepository<OpenJob, Long> {
    List<OpenJob> findAll();
    Optional<OpenJob> findById(Long id);

    @Override
    default void delete(OpenJob openJob) {
        openJob.setDeleted(true);
    }
}
