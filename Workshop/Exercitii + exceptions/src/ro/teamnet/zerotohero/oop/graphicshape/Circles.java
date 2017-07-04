package ro.teamnet.zerotohero.oop.graphicshape;

import ro.teamnet.zerotohero.oop.exceptions.MyException;

/**
 * Created by Andrei.Apostol on 7/4/2017.
 */
public class Circles {
    Circle myCircle = new Circle(5,5,10);
    public double getAreaPub(){

        return myCircle.area();
    }

    public String getStringOut(){
        return myCircle.toString();
    }

    public void getAreaDef(){
        myCircle.fillColour();
        myCircle.fillColour(40);
        myCircle.fillColour((float) 102.3);
    }
}
