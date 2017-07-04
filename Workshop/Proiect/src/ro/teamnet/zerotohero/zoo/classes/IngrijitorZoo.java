package ro.teamnet.zerotohero.zoo.classes;

import ro.teamnet.zerotohero.zoo.classes.abstractclasses.Animal;
import ro.teamnet.zerotohero.zoo.exceptions.AnimalPeCaleDeDisparitieException;
import ro.teamnet.zerotohero.zoo.interfaces.AngajatZoo;

/**
 * Created by Andrei.Apostol on 7/4/2017.
 */
public class IngrijitorZoo implements AngajatZoo {

    private Integer bonusSalarial;
    public IngrijitorZoo(){
        this.bonusSalarial = 0;
    }
    @Override
    public Integer calculeazaBonusSalarial() {
        System.out.println(this.bonusSalarial);
        return this.bonusSalarial;
    }

    public void lucreaza(Animal animal){
        this.bonusSalarial += 3*valoareBonusPerAnimal;
        //System.out.println("Ingrijitorul intra in cusca animalului"); //I know this would be a side effect
    }

    public void lucreaza(Animal animal, Object mancare) throws AnimalPeCaleDeDisparitieException{
        if(animal instanceof AnimalZooRar && mancare == null) throw new
                AnimalPeCaleDeDisparitieException("Animalul pe care de disparitie nu are mancare");

        this.lucreaza(animal);

        animal.mananca(mancare);
        animal.seJoaca();
        animal.faceBaie();
        animal.doarme();
    }
}
