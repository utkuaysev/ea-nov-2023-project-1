package com.project.ea.repository;

import com.project.ea.model.University;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends ListCrudRepository<University, Long> {
}
