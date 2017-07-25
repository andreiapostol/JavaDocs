package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei.Apostol on 7/14/2017.
 */
public class ExtraExercises {
    private EntityManager entityManager = new EntityManagerImpl();

    public List<Employee> searchBySubstringOfDep (String str) throws SQLException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        Connection myConnection = DBManager.getConnection();
        List<Employee> listToReturn = new ArrayList<>();

        String tableNameEmployees = EntityUtils.getTableName(Employee.class);
        List<ColumnInfo> columnsEmployees = EntityUtils.getColumns(Employee.class);

        String tableNameDepartments = EntityUtils.getTableName(Department.class);
        List<ColumnInfo> columnsDepartments = EntityUtils.getColumns(Department.class);

        List<Employee> allEmployees = entityManager.findAll(Employee.class);
        List<Department> allDepartments = entityManager.findAll(Department.class);

        for (Employee employee : allEmployees){
            //
        }
        return null;
    }

}
