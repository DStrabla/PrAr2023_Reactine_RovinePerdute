import javax.xml.stream.*;
import it.kibo.fp.lib.* ;
import java.util.*;

public class Main {

    public static final String SALUTI = "Arrivederci";
    public static final String[] ENTRIES = {"Map 5", "Map 12", "Map 50", "Map 200", "Map 2000", "Map 10000"};
    public static final String TITLE = "Seleziona la mappa da usare";

    public static void main(String[] args) throws XMLStreamException {

        //Creazione del menu
        Menu menu = new Menu(TITLE, ENTRIES, true, true, true);

        //L'utente inserisce la mappa che vuole usare
        int scelta = menu.choose();

        //Caso in cui l'utente scelga una mappa
        if (scelta!=0) {

            //Si usa il metodo per leggere il file xml e salvare tutte le città
            ControllerInputFile.leggiXML(scelta);

            //Si inizializza il numero totale di nodi nel graph
            int n = ControllerInputFile.mappa.getCittas().size();

            //Si inizializza la lista di archi
            List<Edge> edges = new ArrayList<>();
            Edge edge; //Arco provvisorio che viene inserito nell'Arraylist di archi

            //Si inizializzano gli archi pesati usando il peso euclideo (Tonathiu)
            // (u, v, w) rappresentano l'arco dal nodo `u` al nodo `v` avente peso `w`
            for (int i = 0; i < ControllerInputFile.mappa.getStrade().size(); i++) {
                edge = new Edge(ControllerInputFile.mappa.getStrade().get(i).getId_partenza(),
                        ControllerInputFile.mappa.getStrade().get(i).getId_arrivo(),
                        ControllerInputFile.mappa.getStrade().get(i).getPeso_euclideo());
                edges.add(edge);
            }

            //Si costruisce il graph
            Graph graph = new Graph(edges, n);

            int source = 0; //Rappresenta il campo base
            // esegue l'algoritmo di Dijkstra dal nodo 0 (campo base)
            FindPath.findShortestPaths(graph, source, n, 0);

            //Viene pulito l'arrayList di archi
            edges.clear();

            //Si inizializzano gli archi pesati usando il peso tramite altezza (Metztli)
            // (u, v, w) rappresentano l'arco dal nodo `u` al nodo `v` avente peso `w`
            for (int i = 0; i < ControllerInputFile.mappa.getStrade().size(); i++) {
                edge = new Edge(ControllerInputFile.mappa.getStrade().get(i).getId_partenza(),
                        ControllerInputFile.mappa.getStrade().get(i).getId_arrivo(),
                        ControllerInputFile.mappa.getStrade().get(i).getPeso_h());
                edges.add(edge);
            }

            //Si costruisce il graph
            graph = new Graph(edges, n);

            // esegue l'algoritmo di Dijkstra dal nodo 0 (campo base)
            FindPath.findShortestPaths(graph, source, n, 1);
        }

        System.out.println(SALUTI);

    }
}