package com.project.business.repository;

import com.project.business.model.University;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends ListCrudRepository<University, Long> {
}
