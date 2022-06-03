package org.casaortiz.universidadbackend.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pavilion")
public class Pavilion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "square_meter")
    private Double mts2;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "postalId", column = @Column(name = "postal_id")),
            @AttributeOverride(name = "department", column = @Column(name = "department"))
    })
    private Address address;
    @Column(name = "discharge_date")
    private LocalDateTime dischargeDate;
    @Column(name = "date_last_modification")
    private LocalDateTime dateLastModification;
    @OneToMany(//recomendable poner carga peresoza
            mappedBy = "pavilion",
            fetch = FetchType.LAZY
    )
    private Set<Classroom> classrooms;

    public Pavilion() {
    }

    public Pavilion(Integer id, Double mts2, String name, Address address) {
        this.id = id;
        this.mts2 = mts2;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMts2() {
        return mts2;
    }

    public void setMts2(Double mts2) {
        this.mts2 = mts2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public Set<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(Set<Classroom> classrooms) {
        this.classrooms = classrooms;
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
        return "Pavilion{" +
                "id=" + id +
                ", mts2=" + mts2 +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", dischargeDate=" + dischargeDate +
                ", dateLastModification=" + dateLastModification +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pavilion pavilion = (Pavilion) o;
        return id.equals(pavilion.id) && name.equals(pavilion.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
