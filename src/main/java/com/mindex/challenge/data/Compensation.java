package com.mindex.challenge.data;

/*
* Compensation type
* the connection to employee is facilitated through employeeId
*/

public class Compensation {
    //requirements state it needs 2 fields, salary and effectiveDate
    int salary;
    String effectiveDate;
    String employeeId;

    public Compensation(){
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
