package com.mindex.challenge.data;

import com.mindex.challenge.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*
* ReportStructure type
*/

public class ReportStructure {
    //requirements state ReportStructure needs 2 fields, numberOfReports and employee
    Employee employee;
    int numberOfReports;

    //this is used so the getReports method can properly find employee by id
    EmployeeRepository employeeRepository;

    /*
    * requirements state numberOfReports must be calculated on the fly, however, I was unable to figure a method that
    * allowed getReports to access employeeRepository without passing it through here. Therefore, I made specifying the
    * repo a requirement to make a ReportStructure.
    */
    public ReportStructure(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //requirements state numberOfReports must be calculated on the fly
    private int getReports(Employee e){
        List<Employee> totalList = new ArrayList<>();
        List<Employee> parentList = new ArrayList<>();
        List<Employee> childList = new ArrayList<>();

        parentList.add(e);

        while(!parentList.isEmpty()){
            //add everything from parent to total
            totalList.addAll(parentList);

            //find and add children to the children list
            for (Employee employee : parentList) {
                //if child exists, grab the id and add the result of the id lookup to the list
                if (employee.getDirectReports() != null) {
                    for (Employee child : employee.getDirectReports())
                        childList.add(employeeRepository.findByEmployeeId(child.getEmployeeId()));
                }
            }
            //prep for the next loop
            parentList.clear();
            parentList.addAll(childList);
            childList.clear();
        }
        return totalList.size()-1;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        this.numberOfReports = getReports(employee);
    }

}
