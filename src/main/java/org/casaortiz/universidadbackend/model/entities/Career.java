package org.casaortiz.universidadbackend.model.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "career")
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false, unique = true, length = 80)
    private String name;
    @Column(name = "amount_subject_matter")
    private Integer amountSubjectMatter;
    @Column(name = "number_years")
    private Integer numberYears;
    @Column(name = "discharge_date")
    private LocalDateTime dischargeDate;
    @Column(name = "date_last_modification")
    private LocalDateTime dateLastModification;
    @OneToMany(
            mappedBy = "career",
            fetch = FetchType.LAZY
    )
    private Set<Student> students;
    @ManyToMany(
            mappedBy = "careers",
            fetch = FetchType.LAZY
    )
    private Set<Profesor> profesors;

    public Career() {
    }

    public Career(Integer id, String name, Integer amountSubjectMatter, Integer numberYears) {
        this.id = id;
        this.name = name;
        this.amountSubjectMatter = amountSubjectMatter;
        this.numberYears = numberYears;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmountSubjectMatter() {
        return amountSubjectMatter;
    }

    public void setAmountSubjectMatter(Integer amountSubjectMatter) {
        this.amountSubjectMatter = amountSubjectMatter;
    }

    public Integer getNumberYears() {
        return numberYears;
    }

    public void setNumberYears(Integer numberYears) {
        this.numberYears = numberYears;
    }

    public LocalDateTime getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDateTime dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public LocalDateTime getDateLastModification() {
        return dateLastModification;
    }

    public void setDateLastModification(LocalDateTime dateLastModification) {
        this.dateLastModification = dateLastModification;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Profesor> getProfesors() {
        return profesors;
    }

    public void setProfesors(Set<Profesor> profesors) {
        this.profesors = profesors;
    }

    @PrePersist
    private void beforePersist(){
        this.dischargeDate = LocalDateTime.now();
    }
    @PreUpdate
    private void beforeUpdate(){
        this.dateLastModification = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Career{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amountSubjectMatter=" + amountSubjectMatter +
                ", numberYears=" + numberYears +
                ", dischargeDate=" + dischargeDate +
                ", dateLastModification=" + dateLastModification +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Career career = (Career) o;
        return id.equals(career.id) && name.equals(career.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


}
