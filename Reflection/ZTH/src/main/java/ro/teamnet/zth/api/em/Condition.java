package ro.teamnet.zth.api.em;

/**
 * Created by Andrei.Apostol on 7/12/2017.
 */
public class Condition {
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    private String columnName;
    private Object value;
}
