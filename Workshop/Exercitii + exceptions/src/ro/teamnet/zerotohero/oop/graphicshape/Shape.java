package ro.teamnet.zerotohero.oop.graphicshape;

public class Shape extends AbstractShape{
    protected int color;
    protected float saturation;

    public void setColor(int newColor){
        this.color = newColor;
    }

    public void setSaturation(float newSaturation){
        this.saturation = newSaturation;
    }

    public double area(){
        return 0;
    }
}