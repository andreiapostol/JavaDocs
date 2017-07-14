package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.database.DBManager;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei.Apostol on 7/13/2017.
 */
public class EntityManagerImpl implements EntityManager {

    public <T> T findById(Class<T> entityClass, Long id)
            throws SQLException, ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchFieldException {
        Connection myConnection = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);
        List<Field> fields = EntityUtils.getFieldsByAnnotations(entityClass, Column.class);

        Condition myCondition = new Condition();

        for (ColumnInfo column : columns){
            if(column.isId()) {
                myCondition.setColumnName(column.getDbColumnName());
                myCondition.setValue(id);
            }
        }

        QueryBuilder myQueryBuilder = new QueryBuilder();
        myQueryBuilder.setTableName(tableName);
        myQueryBuilder.addQueryColumns(columns);
        myQueryBuilder.addCondition(myCondition);
        myQueryBuilder.setQueryType(QueryType.SELECT);

        String queryToExecute = myQueryBuilder.createQuery();

        try (Statement stmt = myConnection.createStatement()){
            ResultSet myResultSet = stmt.executeQuery(queryToExecute);
            T myObject = entityClass.newInstance();
            if (myResultSet.next()){
                for (ColumnInfo column : columns) {
                    Field fieldToSet = myObject.getClass().getDeclaredField(column.getColumnName());
                    fieldToSet.setAccessible(true);
                    fieldToSet.set(myObject, EntityUtils.castFromSqlType(myResultSet.getObject(column.getDbColumnName()), fieldToSet.getType()));
                }
            }
            myConnection.close();
            return myObject;
        }
        catch (SQLException e) {
            System.out.println("Nu a mers cu statementul + " + e);
        }
        myConnection.close();;
        return entityClass.newInstance();

    }

    @Override
    public int getNextIdVal(String tableName, String columnIdName) throws SQLException, ClassNotFoundException {
        Connection myConnection = DBManager.getConnection();
        String myQueryToFindMaximum = "SELECT MAX(" + columnIdName + ") FROM " + tableName;
        try(Statement stmt = myConnection.createStatement()){
            ResultSet maximumId = stmt.executeQuery(myQueryToFindMaximum);
            //myConnection.close();
            maximumId.next();
            return maximumId.getInt("max("+columnIdName+")") + 1;
        }
        catch (Exception e){
            System.out.println(e);
        }
        myConnection.close();
        return 0;
    }

    @Override
    public <T> T insert(T entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        long id = 0;
        Connection myConnection = DBManager.getConnection();

        String tableName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> columns = EntityUtils.getColumns(entity.getClass());

        for (ColumnInfo column : columns){
            if(column.isId()) {
                id = getNextIdVal(tableName, column.getColumnName());
                column.setValue(id);
            }
            else{
                Field field = entity.getClass().getDeclaredField(column.getColumnName());
                field.setAccessible(true);
                column.setValue(field.get(entity));
            }
        }

        QueryBuilder myQueryBuilder = new QueryBuilder();
        myQueryBuilder.setTableName(tableName);
        myQueryBuilder.addQueryColumns(columns);
        myQueryBuilder.setQueryType(QueryType.INSERT);

        String queryToCreate = myQueryBuilder.createQuery();

        try(Statement stmt = myConnection.createStatement()){
            stmt.executeQuery(queryToCreate);
            //myConnection.close();
            return (T) findById(entity.getClass(), id);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Connection myConnection = DBManager.getConnection();

        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);

        QueryBuilder myQueryBuilder = new QueryBuilder();
        myQueryBuilder.setTableName(tableName);
        myQueryBuilder.addQueryColumns(columns);
        myQueryBuilder.setQueryType(QueryType.SELECT);

        String myQueryToSelect = myQueryBuilder.createQuery();

        try (Statement stmt = myConnection.createStatement()){
            ResultSet myResultSet = stmt.executeQuery(myQueryToSelect);
            ArrayList<T> myListToReturn = new ArrayList<>();

            while (myResultSet.next()){
                for (ColumnInfo column : columns) {
                    T objectToInsert = entityClass.newInstance();
                    Field fieldToSet = objectToInsert.getClass().getDeclaredField(column.getColumnName());
                    fieldToSet.setAccessible(true);
                    fieldToSet.set(objectToInsert, EntityUtils.castFromSqlType(myResultSet.getObject(column.getDbColumnName()), fieldToSet.getType()));
                    myListToReturn.add(objectToInsert);
                }
            }
            myConnection.close();
            return myListToReturn;
        }
        catch (SQLException e) {
            System.out.println("Eroare 4 + " + e);
        }

        return null;
    }

}
