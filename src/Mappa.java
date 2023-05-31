import java.util.ArrayList;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Mappa {
    private ArrayList<Citta> cittas = new ArrayList<Citta>();
    private ArrayList<Strada> strade= new ArrayList<Strada>();


    /**
     * Metodo per calcolare entrambe le varianti (peso euclideo e peso per differenza di altitudine) del peso degli archi
     * @param mappa mappa contenente tutte le città e le relative informazioni
     */
    public void calcoloPesi(Mappa mappa){
        for (int i = 0; i < mappa.cittas.size(); i++) { // selezione della città per calcorale il peso degli archi uscenti da essa
            for (int j = 0; j < mappa.cittas.get(i).getLink().size(); j++) { // selezione del collegamento di cui va calcolato il peso
                int k= mappa.cittas.get(i).getLink().get(j);

                //calcolo del peso euclideo
                double peso_euclideo= sqrt((cittas.get(i).getX()-cittas.get(k).getX())*(cittas.get(i).getX()-cittas.get(k).getX())+
                        (cittas.get(i).getY()-cittas.get(k).getY())*(cittas.get(i).getY()-cittas.get(k).getY()));

                //calcolo del peso dato dalla variazione di altitudine
                double peso_h=abs((cittas.get(i).getH()-cittas.get(k).getH()));
                strade.add(new Strada(i, k, peso_h, peso_euclideo));
            }
        }
    }

    // costruttore
    public Mappa(ArrayList<Citta> cittas) {
        this.cittas = cittas;
    }

    public ArrayList<Citta> getCittas() {
        return cittas;
    }

    public ArrayList<Strada> getStrade() {
        return strade;
    }
}