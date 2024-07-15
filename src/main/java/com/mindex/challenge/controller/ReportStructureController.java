package com.mindex.challenge.controller;


import com.mindex.challenge.data.ReportStructure;
import com.mindex.challenge.service.ReportStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
* This Controller facilitates the endpoints related to ReportStructure
*/

@RestController
public class ReportStructureController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportStructureController.class);

    @Autowired
    private ReportStructureService reportStructureService;

    //endpoint to read reportStructure
    @GetMapping("/employee/{id}/report-structure")
    public ReportStructure read(@PathVariable String id) {

        return reportStructureService.read(id);
    }
}
