package ro.teamnet.zerotohero.oop.graphicshape;
import ro.teamnet.zerotohero.oop.exceptions.MyException;

import java.lang.Math.*;

import static java.lang.Math.PI;

public class Circle extends Shape implements ShapeBehaviour{
    private int xPos;
    private int yPos;
    private int radius;

    public Circle(){
        this.xPos = 0;
        this.yPos = 0;
        this.radius = 0;
    }

    public Circle (int newRadius) throws MyException{
        if (newRadius < 0) throw new MyException("Am aruncat");
        this.radius = newRadius;
    }

    public Circle (int newxPos, int newyPos){
        this.xPos = newxPos;
        this.yPos = newyPos;
    }

    public Circle (int newxPos, int newyPos, int newRadius) {
        this.xPos = newxPos;
        this.yPos = newyPos;
        this.radius = newRadius;
    }

    @Override
    public double area(){
        return PI *radius*radius;
    }

    @Override
    public String toString(){
        return ("center = (" + this.xPos +", " + this.yPos + ") and radius = " + this.radius);
    }


    public void fillColour(){
        System.out.println(super.color);
    }
    public void fillColour(int newColor){
        super.setColor(newColor);
        System.out.println("The super color is: "+ super.color);
    }

    public void fillColour(float newSaturation){
        super.setSaturation(newSaturation);
        System.out.println("The super color is: "+ super.saturation);
    }

    public void metoda1() throws MyException{
        metoda2();
    }
    public void metoda2() throws MyException{
        metoda3();
    }
    public void metoda3() throws MyException{
        throw new MyException("in metoda 3");
    }

}