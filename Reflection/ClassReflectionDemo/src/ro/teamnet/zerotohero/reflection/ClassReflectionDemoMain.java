package ro.teamnet.zerotohero.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import ro.teamnet.zerotohero.reflection.demoobjects.clasaExercitii;
import ro.teamnet.zerotohero.reflection.demoobjects.clasaExercitiiExtinsa;
/**
 * TODO
 * in order to resolve the exercises below, you will have to create
 * all the needed clasees, with their members and methods
 * (in ro.teamnet.zerotohero.reflection.demoobjects package)
 */
public class ClassReflectionDemoMain  {

    public ClassReflectionDemoMain()  {
    }

    public enum days{
        SUNDAY, MONDAY, FRIDAY;
    }


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        //TODO get the class for a String object, and print it

        String myString = new String("Ana");
        System.out.println(myString.getClass());


        //TODO get the class of an Enum, and print it
        System.out.println(days.SUNDAY.getClass());

        //TODO get the class of a collection, and print it
        List<Integer> myList = new ArrayList<>();

        System.out.println(myList.getClass());

        //TODO get the class of a primitive type, and print it

        System.out.println(int.class);

        //TODO get and print the class for a field of primitive type
        clasaExercitii clasaMea = new clasaExercitii();
        Field variabilaMeaField = clasaExercitii.class.getDeclaredField("variabilaMea");
        Integer fieldValue = (Integer) variabilaMeaField.get(clasaMea);
        System.out.println(clasaMea.getClass().getDeclaredField("variabilaMea"));


        //TODO get and print the class for a primitive type, using the wrapper class
        Class clasa2 = Integer.TYPE;
        System.out.println(clasa2);

        //TODO get the class for a specified class name

        System.out.println(clasaExercitii.class);

        //TODO get the superclass of a class, and print it

        System.out.println(clasaMea.getClass().getSuperclass());

        //TODO get the superclass of the superclass above, and print it

        clasaExercitiiExtinsa clasaMeaExtinsa = new clasaExercitiiExtinsa();
        System.out.println(clasaMeaExtinsa.getClass().getSuperclass().getSuperclass());

        //TODO get and print the declared classes within some other class
        Class[] classes = clasaMea.getClass().getDeclaredClasses();
        for(int i = 0; i < classes.length; i++) System.out.println(classes[i]);

        //TODO print the number of constructors of a class
        Constructor[] constructors = clasaMea.getClass().getConstructors();
        System.out.println(constructors.length);

        //TODO get and invoke a public constructor of a class
        clasaExercitii ptInvocat = (clasaExercitii) constructors[1].newInstance(16);
        System.out.println(ptInvocat.variabilaMea);

        //TODO get and print the class of one private field 
        Field stringPrivatField = clasaExercitii.class.getDeclaredField("stringPrivat");
        stringPrivatField.setAccessible(true);
        System.out.println(stringPrivatField.get(clasaMea).getClass());

        //TODO set and print the value of one private field for an object
        stringPrivatField.set(clasaMea, "Franta");
        System.out.println(stringPrivatField.get(clasaMea));

        //TODO get and print only the public fields class
        System.out.println();
        Field[] campurilePublice = clasaExercitii.class.getFields();
        for(int i = 0; i < campurilePublice.length; i++)
            System.out.println(campurilePublice[i].get(clasaMea).getClass());

        //TODO get and invoke one public method of a class
        System.out.println();
        Method testMetodaMea = clasaExercitii.class.getMethod("metodaMea", null);
        testMetodaMea.invoke(clasaMea);

        //TODO get and invoke one inherited method of a class
        System.out.println();
        Method testMetodaMeaExtinsa = clasaExercitiiExtinsa.class.getMethod("metodaMea", null);
        testMetodaMeaExtinsa.invoke(clasaMeaExtinsa);

        //TODO invoke a method of a class the classic way for ten times, and print the timestamp (System.currentTimeMillis())

        long initialTime = System.currentTimeMillis();
        for (int i = 1; i <= 10000; i++){
            clasaMea.pentruTestat();
        }
        System.out.println("TIMP 1: " + (System.currentTimeMillis() - initialTime));

        //TODO invoke a method of a class by Reflection for 100 times, and print the timestamp

        Method pentruTestatMetoda = clasaExercitii.class.getMethod("pentruTestat", null);
        initialTime = System.currentTimeMillis();
        for(int i = 1; i <= 10000; i++){
            pentruTestatMetoda.invoke(clasaMea);
        }
        System.out.println("TIMP 2: " + (System.currentTimeMillis() - initialTime));
        //what do you observe?
		
    }
}
