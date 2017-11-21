package fr.emse.majeureinfo.springbootintro.web;

import fr.emse.majeureinfo.springbootintro.model.Actuator;
import fr.emse.majeureinfo.springbootintro.model.Robot;
import fr.emse.majeureinfo.springbootintro.model.Sensor;

public class RobotDto {

    private final Long id;
    private final SensorDto sensor;
    private final ActuatorDto actuator;

    public RobotDto(Robot robot) {
        this.id = robot.getId();
        this.sensor = robot.getSensor()==null ? null : new SensorDto(robot.getSensor());
        this.actuator = robot.getActuator()==null ? null : new ActuatorDto(robot.getActuator());
    }

    public Long getId() {
        return id;
    }

    public SensorDto getSensor() {
        return sensor;
    }

    public ActuatorDto getActuator() {
        return actuator;
    }

}
