package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Andrei.Apostol on 7/4/2017.
 */
public class Point {
    int xPos, yPos;

    public Point (){
        xPos = 0;
        yPos = 0;
    }
    public Point(int newxPos, int newyPos){
        xPos = newxPos;
        yPos = newyPos;
    }

    // override the equals method to perform "deep" comparison of two Point objects
    @Override
    public boolean equals(Object other) {
        if(other == null)
            return false;
        // check if the dynamic type of 'other' is Point
        // if 'other' is of any other type than 'Point', the two objects cannot be
        // equal if 'other' is of type Point (or one of its derived classes), then
        // downcast the object to Point type and then compare members for equality
        if(other instanceof Point) {
            Point anotherPoint = (Point) other;
            // two points are equal only if their x and y positions are equal
            if( (xPos == anotherPoint.xPos) && (yPos == anotherPoint.yPos) )
                return true;
        }
        return false;
    }

}
