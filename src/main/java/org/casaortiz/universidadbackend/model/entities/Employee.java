package org.casaortiz.universidadbackend.model.entities;

import org.casaortiz.universidadbackend.model.entities.enumeradores.EmployeeType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "employee")
@PrimaryKeyJoinColumn(name = "person_id")
public class Employee extends Person {
    private BigDecimal salary;
    @Column(name = "employee_type")
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;
    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "pavilion_id", foreignKey = @ForeignKey(name = "FK_PAVILION_ID"))
    private Pavilion pavilion;

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

    public Pavilion getPavilion() {
        return pavilion;
    }

    public void setPavilion(Pavilion pavilion) {
        this.pavilion = pavilion;
    }

    @Override
    public String toString() { //super.toString() => optengo el toString de mi padre
        return super.toString() +
                "\tEmployee{" +
                "salary=" + salary +
                ", employeeType=" + employeeType +
                ", pavilion=" + pavilion +
                '}';
    }
}
