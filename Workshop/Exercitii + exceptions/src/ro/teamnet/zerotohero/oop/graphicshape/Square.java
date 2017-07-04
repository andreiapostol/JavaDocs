package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Andrei.Apostol on 7/4/2017.
 */
public class Square extends Shape {
    private int side;

    public Square(int newSide){
        this.side = newSide;
    }

    @Override
    public double area(){
        return side*side;
    }
}
