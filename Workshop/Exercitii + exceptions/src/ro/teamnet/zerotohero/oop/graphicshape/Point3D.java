package ro.teamnet.zerotohero.oop.graphicshape;
import ro.teamnet.zerotohero.oop.graphicshape.*;
/**
 * Created by Andrei.Apostol on 7/4/2017.
 */
public class Point3D extends Point {
    int zPos;
    Point3D(int newxPos, int newyPos, int newzPos){
        super(newxPos, newyPos);
        zPos = newzPos;
    }
}
