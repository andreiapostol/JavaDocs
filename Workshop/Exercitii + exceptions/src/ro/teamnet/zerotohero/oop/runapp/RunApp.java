package ro.teamnet.zerotohero.oop.runapp;
import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.exceptions.MyException;
import ro.teamnet.zerotohero.oop.graphicshape.*;
import ro.teamnet.zerotohero.oop.immutable.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Andrei.Apostol on 7/4/2017.
 */
public class RunApp {
    public static void main(String[] args) throws MyException{
        Circles myCircles = new Circles();
        System.out.println("The area is " + myCircles.getAreaPub());
        System.out.println(myCircles.getStringOut());

        myCircles.getAreaDef();


//        Canvas myCanvas = new Canvas ();
//        myCanvas.paint();
        try {
            Shape myShape = new Circle(10);
            System.out.println("The myShape area is: " + myShape.area());
        }
        catch(MyException e){
            System.out.println(e);
        }


        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));

        ImmutableClass testImmutable = new ImmutableClass(10, 5);

        System.out.println("Get x: " + testImmutable.getX());

        System.out.println(testImmutable);

        System.out.println("------------------------------------------------");

        System.out.println("Exceptions time");


//        Circle circle = new Circle(10);
//        circle.metoda1();
//
//        try{
//            Circle circle2 = new Circle(-5);
//        }
//        catch(MyException e){
//            System.out.println(e);
//        }
//
//        try (BufferedReader br =
//                     new BufferedReader(new FileReader("C:\\Users\\andrei.apostol\\zero-to-hero\\JavaDocs\\Workshop\\src\\ro\\teamnet\\zerotohero\\oop\\graphicshape\\test.txt"))) {
//            br.readLine();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try{
//            Circle circle2 = new Circle(-5);
//        }
//        finally {
//            System.out.println("FINALLY!");
//        }


    }
}
