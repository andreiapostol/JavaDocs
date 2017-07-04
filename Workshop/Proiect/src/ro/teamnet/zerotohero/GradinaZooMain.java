package ro.teamnet.zerotohero;

import ro.teamnet.zerotohero.zoo.classes.AnimalZooFeroce;
import ro.teamnet.zerotohero.zoo.classes.AnimalZooRar;
import ro.teamnet.zerotohero.zoo.classes.IngrijitorZoo;
import ro.teamnet.zerotohero.zoo.classes.VeterinarZoo;
import ro.teamnet.zerotohero.zoo.exceptions.AnimalManancaOmException;
import ro.teamnet.zerotohero.zoo.exceptions.AnimalPeCaleDeDisparitieException;
import ro.teamnet.zerotohero.zoo.interfaces.AngajatZoo;

/**
 * Created by Andrei.Apostol on 7/4/2017.
 */
public class GradinaZooMain {
    public static void main(String[] args){
        AnimalZooRar animal1 = new AnimalZooRar("Pinguin");
        AnimalZooRar animal2 = new AnimalZooRar("Elefant", "Africa");
        AnimalZooRar animal3 = new AnimalZooRar();

        AnimalZooFeroce animalFeroce = new AnimalZooFeroce();

        AngajatZoo angajat1 = new IngrijitorZoo();
        IngrijitorZoo angajat2 = new IngrijitorZoo();

        AngajatZoo angajat3 = new VeterinarZoo();
        VeterinarZoo angajat4 = new VeterinarZoo();

//aici se vor afisa informatiile despre animal1 si animal2 (nume si tara)
//System.out.println(animal1.getNume());

//apelul metodelor
        angajat3.lucreaza(animal1);
        angajat3.lucreaza(animal2);
        angajat3.lucreaza(animal3);
        angajat4.lucreaza(animal1);
        angajat4.lucreaza(animal2);
        angajat4.lucreaza(animal3);

        angajat1.lucreaza(animal1);
        angajat1.lucreaza(animal2);
        angajat1.lucreaza(animal3);

        angajat2.lucreaza(animal1);
        angajat2.lucreaza(animal2);
        angajat2.lucreaza(animal3);

        try {
            angajat2.lucreaza(animal1, null);
            angajat2.lucreaza(animal1, angajat1);
            angajat2.lucreaza(animal1, new String("Mancare"));

            angajat2.lucreaza(animalFeroce);
            angajat2.lucreaza(animalFeroce, null);
            angajat2.lucreaza(animalFeroce, new String("Mancare"));
        }
        catch(AnimalPeCaleDeDisparitieException | AnimalManancaOmException e){
            System.out.println(e);
        }

        System.out.println(angajat1.calculeazaBonusSalarial());
        System.out.println(angajat2.calculeazaBonusSalarial());
        System.out.println(angajat3.calculeazaBonusSalarial());
        System.out.println(angajat4.calculeazaBonusSalarial());

        System.out.println("Finish!");

    }
}
