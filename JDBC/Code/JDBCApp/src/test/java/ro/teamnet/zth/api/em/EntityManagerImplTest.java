package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.api.em.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        assertEquals(depId, "NuMaiEAdministration");

    }

    @Test
    public void findByIdTest2() throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        Long id = new Long(2);
        Department department = entityManager.findById(Department.class, id);
        assertNotNull(department);
    }

//    @Test
//    public void findNextValTest() throws SQLException, ClassNotFoundException {
//        assertEquals(276, entityManager.getNextIdVal("Departments", "department_id") );
//    }
    @Test
    public void insertTest() throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        Department myDepartment = new Department();
        myDepartment.setDepartmentName("VALOARE");
        Department test = entityManager.insert(myDepartment);
        assertNotNull(test.getDepartmentName());
        assertEquals("VALOARE", test.getDepartmentName());
    }

    @Test
    public void findAllTest() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        List<Department> myDepartments = new ArrayList<>();
        myDepartments = entityManager.findAll(Department.class);
        //assertEquals();
        assertEquals("NuMaiEAdministration", myDepartments.get(0).getDepartmentName());
    }

    @Test
    public void updateTest() throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException {
        Department myDepartment = new Department();

        myDepartment.setDepartmentName("NuMaiEAdministration");
        myDepartment.setId(new Long(10));
        myDepartment.setLocation(new Long(1700));

        Department test = entityManager.update(myDepartment);

        assertEquals("NuMaiEAdministration", test.getDepartmentName());

    }

    @Test
    public void deleteTest() throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        Department myDepartment = new Department();
        myDepartment.setDepartmentName("PentruSters");
        myDepartment.setLocation(new Long(2500));
        Department test = entityManager.insert(myDepartment);

        assertEquals("PentruSters", test.getDepartmentName());

        int id = entityManager.getNextIdVal("Departments", "department_id") - 1;
        System.out.println(id);

        myDepartment.setId(new Long(id));
        entityManager.delete(myDepartment);

        assertEquals(new Department(), entityManager.findById(Department.class, new Long(id)));
    }

    @Test
    public void findByParamsTest() throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException {
        Map<String, Object> conditii = new HashMap<>();
        conditii.put("location_id", 1800);


        Department myDepartment = new Department();
        myDepartment.setId(new Long(10));
        myDepartment.setLocation(new Long(1800));
        myDepartment.setDepartmentName("Marketing");

        List<Department> listaReturnata = entityManager.findByParams(Department.class, conditii);

        assertEquals(myDepartment.getDepartmentName(), listaReturnata.get(0).getDepartmentName());
    }
}
