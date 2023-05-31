import java.util.ArrayList;
import java.util.List;

// Una classe per rappresentare un oggetto graph
class Graph
{
    // Un elenco di elenchi per rappresentare un elenco di adiacenze
    List<List<Edge>> adjList = null;

    // Costruttore
    Graph(List<Edge> edges, int n)
    {
        adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // aggiunge i bordi al graph diretto
        for (Edge edge: edges) {
            adjList.get(edge.source).add(edge);
        }
    }
}