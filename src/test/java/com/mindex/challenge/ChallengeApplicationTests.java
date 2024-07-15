package com.mindex.challenge;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportStructure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	CompensationRepository compensationRepository;

	@Test
	public void someTests() {
		//employee, reportStructure, and compensation we will be using for test
		Employee john = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");

		ReportStructure johnReport = new ReportStructure(employeeRepository);
		johnReport.setEmployee(john);

		Compensation johnCompensation = compensationRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");

		//ensure john lennon has 4 "children"
		assertEquals(4, johnReport.getNumberOfReports());
		//ensure compensation and employee share an ID
		assertEquals(john.getEmployeeId(), johnCompensation.getEmployeeId());
	}

}
