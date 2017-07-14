package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Department;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrei.Apostol on 7/14/2017.
 */
public class DepartmentDao {
    private EntityManagerImpl entityManager = new EntityManagerImpl();

    public Department findById(Long id) throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return entityManager.findById(Department.class, id);
    }
    public Department insert(Department entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return entityManager.insert(entity);
    }
    public List<Department> findAll() throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        return entityManager.findAll(Department.class);
    }
    public Department update(Department entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return entityManager.update(entity);
    }
    public void delete(Department entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        entityManager.delete(entity);
    }
    public List<Department> findByParams(Map<String, Object> params) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return entityManager.findByParams(Department.class, params);
    }

    }
