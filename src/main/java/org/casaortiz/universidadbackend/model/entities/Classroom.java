package org.casaortiz.universidadbackend.model.entities;

import org.casaortiz.universidadbackend.model.entities.enumeradores.Blackboard;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
@Entity
@Table(name = "classroom")
public class Classroom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nro_classroom")
    private Integer nroClassroom;
    @Column(name="measures_mtsxmts")
    private String measures;
    @Column(name = "number_desktop")
    private Integer numberDesks;
    @Column(name = "blackboard")
    @Enumerated(EnumType.STRING)
    private Blackboard blackboard;
    @Column(name = "discharge_date")
    private LocalDateTime dischargeDate;
    @Column(name = "date_last_modification")
    private LocalDateTime dateLastModification;
    @ManyToOne(
            optional = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(
            name = "pavilion_id",
            foreignKey = @ForeignKey(name = "FK_PAVILION_ID")
    )
    private Pavilion pavilion;

    public Classroom() {
    }

    public Classroom(Integer id, Integer nroClassroom, String measures, Integer numberDesks, Blackboard blackboard) {
        this.id = id;
        this.nroClassroom = nroClassroom;
        this.measures = measures;
        this.numberDesks = numberDesks;
        this.blackboard = blackboard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNroClassroom() {
        return nroClassroom;
    }

    public void setNroClassroom(Integer nroClassroom) {
        this.nroClassroom = nroClassroom;
    }

    public String getMeasures() {
        return measures;
    }

    public void setMeasures(String measures) {
        this.measures = measures;
    }

    public Integer getNumberDesks() {
        return numberDesks;
    }

    public void setNumberDesks(Integer numberDesks) {
        this.numberDesks = numberDesks;
    }

    public Blackboard getBlackboard() {
        return blackboard;
    }

    public void setBlackboard(Blackboard blackboard) {
        this.blackboard = blackboard;
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

    public Pavilion getPavilion() {
        return pavilion;
    }

    public void setPavilion(Pavilion pavilion) {
        this.pavilion = pavilion;
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
        return "Classroom{" +
                "id=" + id +
                ", nroClassroom=" + nroClassroom +
                ", measures='" + measures + '\'' +
                ", numberDesks=" + numberDesks +
                ", blackboard=" + blackboard +
                ", dischargeDate=" + dischargeDate +
                ", dateLastModification=" + dateLastModification +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return id.equals(classroom.id) && nroClassroom.equals(classroom.nroClassroom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nroClassroom);
    }
}
