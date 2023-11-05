package com.project.ea.Controller;

import com.project.ea.Service.ReportService;
import com.project.ea.model.Report;
import com.project.ea.model.type.ReportType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reports")
public class ReportController {
    private final ReportService reportService;

      @GetMapping("/{id}")
    public Report getById(@PathVariable long id){
        return reportService.getById(id);
    }
  @PutMapping("/{id}")
    public Report updateById(@PathVariable long id, @RequestBody Report report){
         return  reportService.updateById(id,report);
  }

    @PostMapping()
       public Report addReport(@RequestBody Report report){
          return reportService.addReport(report);
    }
   @GetMapping("/type")
    public List<Report> findAllByReportType(@RequestParam ReportType type){
          return reportService.findAllByReportType(type );
    }

}
