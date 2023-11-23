package com.project.education.repository;

import com.project.education.model.EduExperience;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface EduExperienceRepository extends ListCrudRepository<EduExperience, Long> {
    List<EduExperience> findAllByAlumniId(Long alumniId);
    default List<EduExperience> findAllByEndDate_Year(int year){
        var alist = findAll();
        return alist.stream()
                .filter(a -> {
                    LocalDate date = a.getEndDate();
                    return date.getYear() == year;
                })
                .collect(Collectors.toList());
    }

    @Query("SELECT DISTINCT e FROM EduExperience e JOIN e.courses c WHERE c.name = :courseName")
    List<EduExperience> findByCourseName(@Param("courseName") String courseName);

    @Override
    default void deleteById(Long id){
        delete(findById(id).orElseThrow());
    }
    @Override
    default void delete(EduExperience eduExperience) {
        eduExperience.setDeleted(true);
        eduExperience.getCourses().stream()
                .forEach(course -> course.setDeleted(true));
    }

    default void deleteAllByAlumniId(Long alumniId){
        this.findAllByAlumniId(alumniId).stream()
                .forEach(eduExperience -> {
                    eduExperience.setDeleted(true);
                    eduExperience.getCourses().stream()
                            .forEach(course -> course.setDeleted(true));
                });
    }
}
