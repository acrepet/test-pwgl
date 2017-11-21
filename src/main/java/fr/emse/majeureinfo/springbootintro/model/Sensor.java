package fr.emse.majeureinfo.springbootintro.model;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
public class Sensor {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer signal;

    @Enumerated(EnumType.STRING)
    private Status status;

    @SuppressWarnings("unused")
    public Sensor(){
    }

    public Sensor(Integer signal, Status status) {
        this.signal = signal;
        this.status = status;
    }



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSignal() {
        return signal;
    }

    public void setSignal(Integer signal) {
        this.signal = signal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
