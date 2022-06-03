package org.casaortiz.universidadbackend.model.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "profesor")
@PrimaryKeyJoinColumn(name = "person_id")

public class Profesor extends Person {

    private BigDecimal salary;
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "profesor_career",
            joinColumns = @JoinColumn(name = "profesor_id"),
            inverseJoinColumns = @JoinColumn(name = "career_id")
    )
    private Set<Career> careers;

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

    public Set<Career> getCareers() {
        return careers;
    }

    public void setCareers(Set<Career> careers) {
        this.careers = careers;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tProfesor{" +
                "salary=" + salary +
                '}';
    }
}
