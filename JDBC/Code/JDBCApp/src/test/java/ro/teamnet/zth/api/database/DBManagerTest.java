package ro.teamnet.zth.api.database;

import org.junit.Test;

import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;
import static ro.teamnet.zth.api.database.DBManager.checkConnection;
import static ro.teamnet.zth.api.database.DBManager.getConnection;

/**
 * Created by Andrei.Apostol on 7/13/2017.
 */
public class DBManagerTest {
    @Test
    public void testGetConnection(){
        //merge
    }

    @Test
    public void testCheckConnection() throws SQLException, ClassNotFoundException {
        assertEquals(checkConnection(getConnection()), "1");
    }
}
