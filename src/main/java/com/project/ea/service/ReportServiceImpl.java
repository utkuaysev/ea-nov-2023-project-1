package com.project.ea.service;

import com.project.ea.repository.ReportRepository;
import com.project.ea.model.Report;
import com.project.ea.model.type.ReportType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;

    @Override
    public Report getById(long id) {
        return reportRepository.findById(id).orElseThrow(()->new RuntimeException("""
                no report by the id:${id}"""));
    }

    @Override
    public Report updateById(long id, Report report) {
        if(reportRepository.existsById(id)){
            report.setId(id);
            return reportRepository.save(report);
        }return  reportRepository.save(report);
    }

    @Override
    public Report addReport(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public void deleteById(long id) {
          reportRepository.deleteById(id);
    }

    @Override
    public List<Report> findAllByReportType(ReportType type) {
        return reportRepository.findAllByReportType(type);
    }


}
