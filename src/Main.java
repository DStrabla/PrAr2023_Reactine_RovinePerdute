import javax.xml.stream.*;

import it.kibo.fp.lib.* ;

import java.util.*;

public class Main {

    public static final String SALUTI = "Allora fottiti";

    public static void main(String[] args) throws XMLStreamException {

        //Creazione del menu
        Menu menu = new Menu("Seleziona la mappa da usare", new String[]{
                "Map 5","Map 12", "Map 50", "Map 200", "Map 2000", "Map 10000"
        }, true, true, true);

        int scelta = menu.choose();

        if (scelta!=0) {
            ControllerInputFile.leggiXML(scelta);

            List<Edge> edges = new ArrayList<>();
            Edge edge;

            // inizializza i bordi come nel diagramma sopra
            // (u, v, w) rappresentano lo spigolo dal vertice `u` al vertice `v` avente peso `w`
            for (int i = 0; i < ControllerInputFile.mappa.getStrade().size(); i++) {
                edge = new Edge(ControllerInputFile.mappa.getStrade().get(i).getId_partenza(),
                        ControllerInputFile.mappa.getStrade().get(i).getId_arrivo(),
                        ControllerInputFile.mappa.getStrade().get(i).getPeso_euclideo());
                edges.add(edge);
            }

            // numero totale di nodi nel graph (etichettato da 0 a 4)
            int n = ControllerInputFile.mappa.getCittas().size();

            // costruisci il graph
            Graph graph = new Graph(edges, n);

            int source = 0;
            // esegue l'algoritmo di Dijkstra da ogni nodo
            //for (int source = 0; source < n; source++) {
            FindPath.findShortestPaths(graph, source, n, 0);
            //}
            edges.clear();

            for (int i = 0; i < ControllerInputFile.mappa.getStrade().size(); i++) {
                edge = new Edge(ControllerInputFile.mappa.getStrade().get(i).getId_partenza(),
                        ControllerInputFile.mappa.getStrade().get(i).getId_arrivo(),
                        ControllerInputFile.mappa.getStrade().get(i).getPeso_h());
                edges.add(edge);
            }

            // costruisci il graph
            graph = new Graph(edges, n);

            // esegue l'algoritmo di Dijkstra da ogni nodo
            //for (int source = 0; source < n; source++) {
            FindPath.findShortestPaths(graph, source, n, 1);
        }

        else
            System.out.println(SALUTI);


    }
}