package ro.teamnet.zerotohero.zoo.classes.abstractclasses;



/**
 * Created by Andrei.Apostol on 7/4/2017.
 */
public abstract class Animal {
    public abstract void mananca(Object a);
    public abstract void seJoaca();
    public abstract void faceBaie();
    public void doarme(){
        System.out.println("Animalul doarme!");
    }

    public Animal(){
        System.out.println("Animal nou");
    }
}
