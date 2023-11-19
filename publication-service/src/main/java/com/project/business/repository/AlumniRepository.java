package com.project.business.repository;

import com.project.business.model.Address;
import com.project.business.model.Alumni;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface AlumniRepository extends ListCrudRepository<Alumni,Long> {
    List<Alumni> findByEduExperience_EndDateBetween(LocalDate localDate1, LocalDate localDate2);
    List<Alumni> findByEduExperience_Courses_Name(String courseName);
    List<Alumni> findByAddress(Address address);
    List<Alumni> findByProfExperiences_Company_Industry(String industry);
}
















