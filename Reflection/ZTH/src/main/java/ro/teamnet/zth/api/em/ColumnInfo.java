package ro.teamnet.zth.api.em;

/**
 * Created by Andrei.Apostol on 7/12/2017.
 */
//columnName (type String),
//        columnType (type Class), dbColumnName (type String),
//        isId (type boolean), value
//        (type Object). Create getters and setters
//        for these fields.
public class ColumnInfo {
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Class getColumnType() {
        return columnType;
    }

    public void setColumnType(Class columnType) {
        this.columnType = columnType;
    }

    public String getDbColumnName() {
        return dbColumnName;
    }

    public void setDbColumnName(String dbColumnName) {
        this.dbColumnName = dbColumnName;
    }

    public boolean isId() {
        return isId;
    }

    public void setId(boolean id) {
        isId = id;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    private String columnName;
    private Class columnType;
    private String dbColumnName;
    private boolean isId;
    private Object value;



}
