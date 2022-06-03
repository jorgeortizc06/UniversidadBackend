package org.casaortiz.universidadbackend.model.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "person_id")
public class Student extends Person {
    @ManyToOne(
            optional = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "career_id")
    private Career career;
    public Student() {
    }

    public Student(Integer id, String firstName, String lastName, String dni, Address address) {
        super(id, firstName, lastName, dni, address);
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tStudent{}";
    }
}
