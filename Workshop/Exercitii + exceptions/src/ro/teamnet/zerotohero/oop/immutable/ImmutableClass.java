package ro.teamnet.zerotohero.oop.immutable;

/**
 * Created by Andrei.Apostol on 7/4/2017.
 */
public final class ImmutableClass {
    private final Integer x;
    private final Integer y;

    public Integer getX(){
        return this.x;
    }

    public Integer getY(){
        return this.y;
    }

//    public void setX(Integer toSet){
//        this.x = toSet;
//    }

    public ImmutableClass(Integer newX, Integer newY){
        this.x = newX;
        this.y = newY;
    }

    @Override
    public String toString(){
        return "x: " + this.x + "y : " + this.y;
    }
}
