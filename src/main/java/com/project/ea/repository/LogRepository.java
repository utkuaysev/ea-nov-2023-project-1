package com.project.ea.repository;

import com.project.ea.model.Log;
import org.springframework.data.repository.ListCrudRepository;

public interface LogRepository extends ListCrudRepository<Log,Long> {
}
