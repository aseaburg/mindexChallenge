package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
* This controller facilitates the endpoints related to Compensation
*/

@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;

    //endpoint to read compensation
    @GetMapping("/employee/{id}/compensation")
    public Compensation read(@PathVariable String id) {

        return compensationService.read(id);
    }
    //endpoint to create compensation, compensation cannot be created if employee of {id} is not found
    @PostMapping("/employee/{id}/compensation")
    public Compensation create(@PathVariable String id, @RequestBody Compensation compensation) {

        compensation.setEmployeeId(id);
        return compensationService.create(compensation);
    }
}
