package com.project.business.repository;

import com.project.business.model.Alumni;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumniRepository extends ListCrudRepository<Alumni,Long> {
}
















