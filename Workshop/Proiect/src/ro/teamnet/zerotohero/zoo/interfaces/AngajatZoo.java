package ro.teamnet.zerotohero.zoo.interfaces;
import ro.teamnet.zerotohero.zoo.classes.abstractclasses.Animal;

/**
 * Created by Andrei.Apostol on 7/4/2017.
 */
public interface AngajatZoo {
    void lucreaza (Animal animal);
    Integer valoareBonusPerAnimal = 50;
    Integer calculeazaBonusSalarial();
}
