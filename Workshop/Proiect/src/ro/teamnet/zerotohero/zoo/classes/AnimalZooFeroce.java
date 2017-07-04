package ro.teamnet.zerotohero.zoo.classes;

import ro.teamnet.zerotohero.zoo.classes.abstractclasses.Animal;
import ro.teamnet.zerotohero.zoo.exceptions.AnimalManancaOmException;
import ro.teamnet.zerotohero.zoo.interfaces.AngajatZoo;

/**
 * Created by Andrei.Apostol on 7/4/2017.
 */
public class AnimalZooFeroce extends Animal {

    @Override
    public void mananca(Object mancare){
       if(mancare instanceof AngajatZoo) throw new AnimalManancaOmException("Animalul feroce a mancat omul");
       else System.out.println("AnimalulZooFeroce mananca");
    }
    @Override
    public void seJoaca(){
        System.out.println("AnimalulZooFeroce se joaca");
    }

    @Override
    public void faceBaie(){
        System.out.println("AnimalulZooFeroce face baie");
    }

    @Override
    public void doarme(){
        super.doarme();
        System.out.println("Animalul feroce vaneaza");
    }
}
