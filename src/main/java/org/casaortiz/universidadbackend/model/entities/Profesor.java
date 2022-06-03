package org.casaortiz.universidadbackend.model.entities;

import java.math.BigDecimal;

public class Profesor extends Person{

    private BigDecimal salary;

    public Profesor() {
    }

    public Profesor(Integer id, String firstName, String lastName, String dni, Address address, BigDecimal salary) {
        super(id, firstName, lastName, dni, address);
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }


}
