package ro.teamnet.zth.appl.dao;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Andrei.Apostol on 7/14/2017.
 */
public class DepartmentDaoTest {
    DepartmentDao departmentDaoManager = new DepartmentDao();

    @Test
    public void findByIdTest() throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        Long id = new Long(10);
        Department department = departmentDaoManager.findById(id);
        String depId = department.getDepartmentName();
        assertEquals(depId, "NuMaiEAdministration");
    }
}
