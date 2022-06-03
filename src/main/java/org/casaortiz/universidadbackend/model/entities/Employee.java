package org.casaortiz.universidadbackend.model.entities;

import org.casaortiz.universidadbackend.model.entities.enumeradores.EmployeeType;

import java.math.BigDecimal;

public class Employee extends Person{
    private BigDecimal salary;
    private EmployeeType employeeType;

    public Employee() {
    }

    public Employee(Integer id, String firstName, String lastName, String dni, Address address, BigDecimal salary, EmployeeType employeeType) {
        super(id, firstName, lastName, dni, address);
        this.salary = salary;
        this.employeeType = employeeType;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }
}
