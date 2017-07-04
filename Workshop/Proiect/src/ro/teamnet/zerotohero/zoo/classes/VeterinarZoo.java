package ro.teamnet.zerotohero.zoo.classes;

import ro.teamnet.zerotohero.zoo.classes.abstractclasses.Animal;
import ro.teamnet.zerotohero.zoo.interfaces.AngajatZoo;

/**
 * Created by Andrei.Apostol on 7/4/2017.
 */
public class VeterinarZoo implements AngajatZoo {

    private Integer bonusSalarial;

    public VeterinarZoo(){
        this.bonusSalarial = 0;
    }

    @Override
    public Integer calculeazaBonusSalarial() {
        //System.out.println(this.bonusSalarial); //I know this is a side effect
        return this.bonusSalarial;

    }

    public void lucreaza(Animal animal){
        System.out.println("Veterinarul are grija de animal");
        if(animal instanceof AnimalZooFeroce) animal.faceBaie();
        bonusSalarial+=2*valoareBonusPerAnimal;
    }
}
