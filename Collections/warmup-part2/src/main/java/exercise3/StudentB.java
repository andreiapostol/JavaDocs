package exercise3;

/**
 * Created by Andrei.Apostol on 7/7/2017.
 */
public class StudentB extends Student {
    StudentB(){
        this.firstName = "Bobita";
        this.lastName = "Costel";
    }
    StudentB(String a, String b){
        this.firstName = a;
        this.lastName = b;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null) return false;

        if (this.getClass() != o.getClass()) return false;

        Student toCompare = (Student) o;

        return (this.firstName.equals(toCompare.getFirstName()));
    }

    @Override
    public int hashCode() {
        int result = 0;
        result += 19 * firstName.hashCode();
        result += 19 * result + lastName.hashCode();
        return result;
    }
}
