package com.project.ea.repository;

import com.project.ea.model.Report;
import com.project.ea.model.type.ReportType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends CrudRepository<Report,Long> {
    List<Report> findAllByReportType(ReportType type);
    // List<Report> findByType(String type);
}
