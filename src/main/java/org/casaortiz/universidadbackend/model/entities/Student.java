package org.casaortiz.universidadbackend.model.entities;

import java.io.Serializable;

public class Student extends Person {
    public Student() {
    }

    public Student(Integer id, String firstName, String lastName, String dni, Address address) {
        super(id, firstName, lastName, dni, address);
    }
}
