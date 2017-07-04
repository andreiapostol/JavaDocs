package ro.teamnet.zerotohero.zoo.classes;

import ro.teamnet.zerotohero.zoo.classes.abstractclasses.Animal;
import ro.teamnet.zerotohero.zoo.exceptions.*;
import ro.teamnet.zerotohero.zoo.interfaces.AngajatZoo;

/**
 * Created by Andrei.Apostol on 7/4/2017.
 */
public class AnimalZooRar extends Animal{
    private String nume;
    private String numeTaraOrigine;

    public AnimalZooRar(){
        this.nume = "Girafa";
        this.numeTaraOrigine = "Africa";
    }

    public AnimalZooRar(String numele){
        this.nume = numele;
        this.numeTaraOrigine = "Europa";
    }

    public AnimalZooRar(String numele, String numeleTarii){
        this.nume = numele;
        this.numeTaraOrigine = numeleTarii;
    }
    @Override
    public void mananca(Object mancare){
        if (mancare instanceof AngajatZoo) throw new AnimalManancaOmException("l-a mancat");
        else System.out.println("AnimalulZooRar mananca");
    }
    @Override
    public void seJoaca(){
        System.out.println("AnimalulZooRar se joaca");
        super.doarme();
    }

    @Override
    public void faceBaie(){
        System.out.println("AnimalulZooRar face baie");
    }
}
