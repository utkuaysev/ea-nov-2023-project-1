package com.project.ea.repository;

import com.project.ea.model.Course;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends ListCrudRepository<Course, Long> {
}
