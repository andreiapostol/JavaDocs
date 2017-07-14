package ro.teamnet.zth.appl.dao;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Location;

import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Andrei.Apostol on 7/14/2017.
 */
public class LocationDaoTest {
    LocationDao locationDaoManager = new LocationDao();

    @Test
    public void findByIdTest() throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        Long id = new Long(1000);
        Location location = locationDaoManager.findById(id);
        String depId = location.getStreetAddress();
        assertEquals(depId, "1297 Via Cola di Rie");
    }
}
