package fr.emse.majeureinfo.springbootintro.dao;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.operation.DeleteAll;
import com.ninja_squad.dbsetup.operation.Insert;
import com.ninja_squad.dbsetup.operation.Operation;
import fr.emse.majeureinfo.springbootintro.CommonOperations;
import fr.emse.majeureinfo.springbootintro.model.Status;
import fr.emse.majeureinfo.webserviceproject.model.Status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource("/test.properties")
public class RobotDaoCustomTest {

    @Autowired
    private RobotDao robotDao;


    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    protected static final DbSetupTracker TRACKER = new DbSetupTracker();

    protected void dbSetup(Operation operation) {
        DbSetup setup = new DbSetup(new DataSourceDestination(dataSource),
                Operations.sequenceOf(CommonOperations.DELETE_ALL,operation));
        TRACKER.launchIfNecessary(setup);
    }

    @Before
    public void prepare() {
        Operation sensor =
                Insert.into("SENSOR")
                        .withDefaultValue("status", Status.ON)
                        .columns("id", "signal")
                        .values(1L, 22)
                        .build();

        Operation actuator =
                Insert.into("ACTUATOR")
                        .withDefaultValue("status", Status.ON)
                        .columns("id", "speed")
                        .values(1L, 22)
                        .build();

        Operation robot =
                Insert.into("ROBOT")
                        .columns("id", "sensor_id", "actuator_id")
                        .values(1L, 1L, 1L)
                        .build();

        dbSetup(Operations.sequenceOf(sensor,actuator,robot));
    }

    @Test
    public void findRoomsWithOnLights() {
        TRACKER.skipNextLaunch();
        assertThat(robotDao.findWithOnSensors()).hasSize(1);
    }


}


