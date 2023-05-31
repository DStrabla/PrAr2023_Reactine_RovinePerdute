import java.util.ArrayList;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Mappa {
    private ArrayList<Citta> cittas = new ArrayList<Citta>();
    //private ArrayList<ArrayList<Integer>> pesi=new ArrayList();
    private ArrayList<Strada> strade= new ArrayList<Strada>();

    public void printMappa(Mappa mappa){
        for (int i = 0; i < mappa.cittas.size(); i++) {
            System.out.println("citta "+ (i+1) + ": id ->"+ i+ ", nome-> "+ mappa.cittas.get(i).getNome());
        }
        for (int i = 0; i < strade.size(); i++) {

            System.out.println("partenza: "+ strade.get(i).id_partenza);
            System.out.println("arrivo: "+ strade.get(i).id_arrivo);
            System.out.println("peso: "+ strade.get(i).peso_h);
            System.out.println("peso euclideo: "+ strade.get(i).peso_euclideo);

            //System.out.println(i+"->"+j+"= "+pesi[i][j]);

        }
    }

    public void calcoloPesi(Mappa mappa){
        for (int i = 0; i < mappa.cittas.size(); i++) {
            for (int j = 0; j < mappa.cittas.get(i).getLink().size(); j++) {
                int k=mappa.cittas.get(i).getLink().get(j);

                double peso_euclideo= sqrt((cittas.get(i).getX()-cittas.get(k).getX())*(cittas.get(i).getX()-cittas.get(k).getX())+
                        (cittas.get(i).getY()-cittas.get(k).getY())*(cittas.get(i).getY()-cittas.get(k).getY()));

                /*int peso_euclideo= sqrt((a.coordinataX-b.coordinataX)*(a.coordinataX-b.coordinataX) +
                        (a.coordinataY-b.coordinataY)*(a.coordinataY-b.coordinataY));*/

                double peso_h=abs((cittas.get(i).getH()-cittas.get(k).getH()));
                strade.add(new Strada(i, k, peso_h, peso_euclideo));


                /*pesi.add(new ArrayList<Integer>());
                pesi.get(i).add(k, (mappa.cittas.get(i).getH())-(mappa.cittas.get(k).getH()));*/


                //pesi.add()= (mappa.cittas.get(i).getH())-(mappa.cittas.get(k).getH());
                //pesi[i][k]=(mappa.cittas.get(i).getH())-(mappa.cittas.get(k).getH());
            }
        }
    }

    public Mappa(ArrayList<Citta> cittas) {
        this.cittas = cittas;
    }

    public ArrayList<Citta> getCittas() {
        return cittas;
    }

    public void setCittas(ArrayList<Citta> cittas) {
        this.cittas = cittas;
    }

    public ArrayList<Strada> getStrade() {
        return strade;
    }

    public void setStrade(ArrayList<Strada> strade) {
        this.strade = strade;
    }
}