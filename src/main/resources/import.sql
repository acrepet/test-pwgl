INSERT INTO SENSOR (ID, SIGNAL, STATUS) VALUES (1, 20,'ON');
INSERT INTO ACTUATOR (ID, SPEED, STATUS) VALUES (1, 30,'ON');

INSERT INTO SENSOR (ID, SIGNAL, STATUS) VALUES (2, 10,'OFF');
INSERT INTO ACTUATOR (ID, SPEED, STATUS) VALUES (2, 30,'OFF');

INSERT INTO ROBOT (ID, SENSOR_ID, ACTUATOR_ID) VALUES (1, 1, 1);
INSERT INTO ROBOT (ID, SENSOR_ID, ACTUATOR_ID) VALUES (2, 2, 2);
