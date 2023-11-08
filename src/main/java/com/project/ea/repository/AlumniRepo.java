package com.project.ea.repository;

import com.project.ea.model.Address;
import com.project.ea.model.Alumni;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface AlumniRepo extends ListCrudRepository<Alumni,Long> {
    List<Alumni> findByEduExperience_EndDateBetween(LocalDate localDate1, LocalDate localDate2);
    List<Alumni> findByEduExperience_Courses_Name(String courseName);
    List<Alumni> findByAddress(Address address);
    List<Alumni> findByProfExperiences_Company_Industry(String industry);
}
















