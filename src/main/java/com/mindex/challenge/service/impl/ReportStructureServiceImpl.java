package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportStructure;
import com.mindex.challenge.service.ReportStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportStructureServiceImpl implements ReportStructureService {
    private static final Logger LOG = LoggerFactory.getLogger(ReportStructureServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    //method to return ReportStructure with all fields filled
    @Override
    public ReportStructure read(String id) {
        LOG.debug("Creating employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        ReportStructure reportStructure = new ReportStructure(employeeRepository);
        reportStructure.setEmployee(employee);

        return reportStructure;
    }

}
