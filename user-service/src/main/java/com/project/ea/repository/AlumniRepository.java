package com.project.ea.repository;

import com.project.ea.model.Alumni;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface AlumniRepository extends ListCrudRepository<Alumni,Long> {
}
















