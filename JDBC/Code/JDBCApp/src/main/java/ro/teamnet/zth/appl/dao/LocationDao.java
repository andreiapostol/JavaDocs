package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Location;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrei.Apostol on 7/14/2017.
 */
public class LocationDao {
    private EntityManagerImpl entityManager = new EntityManagerImpl();

    public Location findById(Long id) throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return entityManager.findById(Location.class, id);
    }
    public Location insert(Location entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return entityManager.insert(entity);
    }
    public List<Location> findAll() throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        return entityManager.findAll(Location.class);
    }
    public Location update(Location entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return entityManager.update(entity);
    }
    public void delete(Location entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        entityManager.delete(entity);
    }
    public List<Location> findByParams(Map<String, Object> params) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return entityManager.findByParams(Location.class, params);
    }
}
