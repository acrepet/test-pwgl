package fr.emse.majeureinfo.springbootintro.model;

import ch.qos.logback.core.joran.action.ActionUtil;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
public class Actuator {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Integer speed;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Actuator(Integer speed, Status status) {
        this.speed = speed;
        this.status = status;
    }

    public Actuator(){}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

