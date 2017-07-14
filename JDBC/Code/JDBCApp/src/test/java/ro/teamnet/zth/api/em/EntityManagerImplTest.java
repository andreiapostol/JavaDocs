package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.api.em.*;
import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Andrei.Apostol on 7/13/2017.
 */
public class EntityManagerImplTest {

    EntityManagerImpl entityManager = new EntityManagerImpl();
    @Test
    public void findByIdTest() throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        Long id = new Long(10);
        Department department = entityManager.findById(Department.class, id);
        String depId = department.getDepartmentName();
        assertEquals(depId, "Administration");

    }

    @Test
    public void findByIdTest2() throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        Long id = new Long(2);
        Department department = entityManager.findById(Department.class, id);
        assertNotNull(department);
    }

    @Test
    public void findNextValTest() throws SQLException, ClassNotFoundException {
        assertEquals(entityManager.getNextIdVal("Departments", "department_id"), 271);
    }
    @Test
    public void insertTest() throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        Department myDepartment = new Department();
        myDepartment.setDepartmentName("VALOARE");
        Department test = entityManager.insert(myDepartment);
        assertEquals(test.getDepartmentName(), "VALOARE");
    }
}
