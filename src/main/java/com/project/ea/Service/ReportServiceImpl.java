package com.project.ea.Service;

import com.project.ea.Repository.ReportRepository;
import com.project.ea.model.Report;
import com.project.ea.model.type.ReportType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
