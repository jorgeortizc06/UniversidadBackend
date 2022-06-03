package org.casaortiz.universidadbackend.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @Inheritance(strategy = InheritanceType.JOINED) //(recomendable) crea una tabla padre y hace una relacion con las hijas
 *      //table_per_class = genera una tabla por cada hija, lo cual genera redundancia
 *      //sinlge_table = genera una sola tabla del padre junto a las hijas, debe permitir valores nulos
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 60)
    private String firstName;
    @Column(nullable = false, length = 60)
    private String lastName;
    @Column(nullable = false, unique = true, length = 10)
    private String dni;
    @Column(name = "discharge_date")
    private LocalDateTime dischargeDate;
    @Column(name = "date_last_modification")
    private LocalDateTime dateLastModification;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "postalId", column = @Column(name = "postal_id")),
            @AttributeOverride(name = "department", column = @Column(name = "department"))
    })
    private Address address;

    public Person() {}

    public Person(Integer id, String firstName, String lastName, String dni, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", dischargeDate=" + dischargeDate +
                ", dateLastModification=" + dateLastModification +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id) && dni.equals(person.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni);
    }
}
