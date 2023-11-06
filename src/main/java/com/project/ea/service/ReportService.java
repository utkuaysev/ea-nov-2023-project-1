package com.project.ea.service;

import com.project.ea.model.Report;
import com.project.ea.model.type.ReportType;

import java.util.List;


public interface ReportService {
    Report getById(long id);
    Report updateById(long id,Report report);
    Report addReport(Report report);
    void deleteById(long id);
    List<Report> findAllByReportType(ReportType type);

}
