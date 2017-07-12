package ro.teamnet.zerotohero.reflection.demoobjects;

/**
 * Created by Andrei.Apostol on 7/12/2017.
 */
public class clasaExercitii {
    public clasaExercitii(){
        this.variabilaMea = 10;
        this.stringPrivat = "abcd";
    }
    public clasaExercitii(int a){
        this.variabilaMea = a;
        this.stringPrivat = "abcd";
    }

    public int variabilaMea;

    public boolean variabilaMeaBooleana;

    public class clasaNouaInClasaExercitii{
        public int altaVariabila;
    }

    public void metodaMea(){
        System.out.println("A MERS");
    }

    public void pentruTestat(){
        variabilaMea *= ((variabilaMea + 10)*variabilaMea)%100;
    }
    private String stringPrivat;
}
