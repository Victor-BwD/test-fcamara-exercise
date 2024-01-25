package com.victorbwd.desafiofcamara.controllers;

import com.victorbwd.desafiofcamara.domain.report.ReportDTO;
import com.victorbwd.desafiofcamara.report.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public ResponseEntity<ReportDTO> getEntryTotal() {
        ReportDTO report = this.reportService.getEntryTotal();
        return ResponseEntity.ok().body(report);
    }
}
