package exercise3;

/**
 * Created by Andrei.Apostol on 7/7/2017.
 */
public class Student {
    protected String firstName;
    protected String lastName;

    Student(){
        this.firstName = "Bobita";
        this.lastName = "Costel";
    }
    Student(String a, String b){
        this.firstName = a;
        this.lastName = b;
    }

    public String getFirstName(){return this.firstName;}
    public String getLastName(){return this.lastName;}

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null) return false;

        if (this.getClass() != o.getClass()) return false;

        Student toCompare = (Student) o;

        return (this.firstName.equals(toCompare.getFirstName())
                && this.lastName.equals(toCompare.getLastName()));
    }
    @Override
    public int hashCode() {
        int result = 0;
        result += 19 * firstName.hashCode();
        result += 19 * result + lastName.hashCode();
        return result;
    }
}
