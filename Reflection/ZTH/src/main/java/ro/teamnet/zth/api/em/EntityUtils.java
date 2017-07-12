package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Andrei.Apostol on 7/12/2017.
 */
public class EntityUtils {
    private EntityUtils() throws UnsupportedOperationException{

    };

    public static String getTableName(Class entity){
//        for (Field f : entity.getFields()){
//            Annotation table = f.getAnnotation(Table.class);
//            if (table!=null)
//                return table.toString();
//        }
        if(entity.isAnnotationPresent(Table.class))
            return ((Table)entity.getAnnotation(Table.class)).name();
        return entity.getName();
    }

    public static ArrayList<ColumnInfo> getColumns(Class entity){
        Field[] declaredFields = entity.getDeclaredFields();

        ArrayList<ColumnInfo> columnInfos = new ArrayList<>();


        for(int i = 0; i < declaredFields.length; i++)
            if(declaredFields[i].isAnnotationPresent(Column.class)
             ||declaredFields[i].isAnnotationPresent(Id.class))
            {
                ColumnInfo toAdd = new ColumnInfo();
                toAdd.
                setDbColumnName
                (declaredFields[i].getAnnotation(Column.class).name());

                toAdd.setColumnType(declaredFields[i].getClass());
                //or getType()???

                toAdd.setColumnName(declaredFields[i].getName());

                if(declaredFields[i].isAnnotationPresent(Id.class))
                    toAdd.setId(true);
                else toAdd.setId(false);

                columnInfos.add(toAdd);

            };
        return columnInfos;
    }

    public static Object castFromSqlType(Object value, Class wantedType){
        if(value instanceof BigDecimal){
            if (wantedType.equals(Integer.class)) return (Integer) value;
            if (wantedType.equals(Long.class)) return (Long) value;
            if (wantedType.equals(Float.class)) return (Float) value;
            if (wantedType.equals(Double.class)) return (Double) value;
        };
        return value;
    }

    public static ArrayList<Field> getFieldsByAnnotations(Class clazz, Class annotation){
        ArrayList<Field> fieldsToReturn = new ArrayList<>();
        Field[] declaredFields = clazz.getDeclaredFields();

        for(int i = 0; i < declaredFields.length; i++){
            if(declaredFields[i].isAnnotationPresent(annotation))
                fieldsToReturn.add(declaredFields[i]);
        }

        return fieldsToReturn;
    }

    public static Object getSqlValue(Object object) throws IllegalAccessException {
        if (object.getClass().isAnnotationPresent(Table.class)){
            Field[] declaredFields = object.getClass().getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++)
                if (declaredFields[i].isAnnotationPresent(Id.class)) {
                    declaredFields[i].setAccessible(true);
                    return declaredFields[i].getLong(object);
                }

        }
        return object;
    }
}
