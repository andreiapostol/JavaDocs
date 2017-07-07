package exercise3;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Andrei.Apostol on 7/7/2017.
 */
public class WhereMainIs {
    public static void main(String[] args){

        Map<Student, Integer> map1 = new HashMap<Student, Integer>();
        Map<Student, Integer> map2 = new HashMap<Student, Integer>();
        Map<Student, Integer> map3 = new HashMap<Student, Integer>();
        Map<Student, Integer> map4 = new HashMap<Student, Integer>();

        map1.put(new StudentA("Maria", "Ana"), 20);
        map1.put(new StudentA("Maria", "Silvia"), 20);

        map2.put(new StudentA("George", "Marius"), 25);
        map2.put(new StudentA("George", "Gica"), 25);

        map3.put(new StudentA("Constantin", "Cosmin"), 10);
        map3.put(new StudentA("Constantin", "Radu"), 30);

        map4.put(new Student("Irina", "Maria"), 30);
        map4.put(new Student("Irina", "Georgiana"), 15);

        for(Map.Entry<Student, Integer> entry : map1.entrySet())
            System.out.println(entry.getKey().getFirstName() + " " + entry.getKey().getLastName() +
            " = " + entry.getValue());

        for(Map.Entry<Student, Integer> entry : map2.entrySet())
            System.out.println(entry.getKey().getFirstName() + " " + entry.getKey().getLastName() +
                    " = " + entry.getValue());

        for(Map.Entry<Student, Integer> entry : map3.entrySet())
            System.out.println(entry.getKey().getFirstName() + " " + entry.getKey().getLastName() +
                    " = " + entry.getValue());

        for(Map.Entry<Student, Integer> entry : map4.entrySet())
            System.out.println(entry.getKey().getFirstName() + " " + entry.getKey().getLastName() +
                    " = " + entry.getValue());
    }
}
