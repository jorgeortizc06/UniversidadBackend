package org.casaortiz.universidadbackend.model.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Address implements Serializable {
    private String calle;
    private String number;
    private String postalId;
    private String department;
    private String location;

    public Address() {
    }

    public Address(String calle, String number, String postalId, String department, String location) {
        this.calle = calle;
        this.number = number;
        this.postalId = postalId;
        this.department = department;
        this.location = location;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostalId() {
        return postalId;
    }

    public void setPostalId(String postalId) {
        this.postalId = postalId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Address{" +
                "calle='" + calle + '\'' +
                ", number='" + number + '\'' +
                ", postalId='" + postalId + '\'' +
                ", department='" + department + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
