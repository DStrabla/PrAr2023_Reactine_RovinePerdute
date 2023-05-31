import java.util.*;

public class FindPath {

    static List<List<Integer>> routes = new ArrayList<>();
    static double costoCarburanteTonathiu;
    static double costoCarburanteMetztli;

    public static void findShortestPaths(Graph graph, int source, int n, int flag)
    {
        // crea un min-heap e invia il nodo sorgente con distanza 0
        PriorityQueue<Node> minHeap;
        minHeap = new PriorityQueue<>(Comparator.comparingDouble(node -> node.weight));
        minHeap.add(new Node(source, 0));

        // imposta la distanza iniziale dalla sorgente a `v` come infinito
        List<Double> dist;
        dist = new ArrayList<>(Collections.nCopies(n, Double.MAX_VALUE));

        // la distanza dalla sorgente a se stessa è zero
        dist.set(source, 0.0);

        // array booleano per tenere traccia dei vertici per quale minimo
        // il costo è già stato trovato
        boolean[] done = new boolean[n];
        done[source] = true;

        // memorizza il predecessore di un vertice (in un percorso di stampa)
        int[] prev = new int[n];
        prev[source] = -1;

        // corri finché min-heap non è vuoto
        while (!minHeap.isEmpty())
        {
            // Rimuove e restituisce il vertice migliore
            Node node = minHeap.poll();

            // ottieni il numero del vertice
            int u = node.vertex;

            // fare per ogni vicino `v` di `u`
            for (Edge edge: graph.adjList.get(u))
            {
                int v = edge.dest;
                double weight = edge.weight;

                // Fase di rilassamento
                if (!done[v] && (dist.get(u) + weight) < dist.get(v))
                {
                    dist.set(v, dist.get(u) + weight);
                    prev[v] = u;
                    minHeap.add(new Node(v, dist.get(v)));
                }
            }

            // contrassegna il vertice `u` come fatto in modo che non venga più ripreso
            done[u] = true;
        }

        List<Integer> route1 = new ArrayList<>();
        List<Integer> route2 = new ArrayList<>();

        int i = n-1;
        //for (int i = 0; i < n; i++)
        {
            if (i != source && dist.get(i) != Double.MAX_VALUE && flag == 0) {
                getRoute(prev, i, route1);
                System.out.println("Path (" + source + "->" + i + "): Minimum cost= " + dist.get(i) + ", Route=" + route1);
                //System.out.println("Path (%d —> %d): Minimum cost = %d, Route = %s\n", source, i, dist.get(i), route);
                costoCarburanteTonathiu = dist.get(i);
                routes.add(route1);
            }
            if (i != source && dist.get(i) != Double.MAX_VALUE && flag == 1)
            {
                getRoute(prev, i, route2);
                System.out.println("Path ("+source+"->"+i+"): Minimum cost= "+dist.get(i)+", Route="+route2);
                //System.out.println("Path (%d —> %d): Minimum cost = %d, Route = %s\n", source, i, dist.get(i), route);
                costoCarburanteMetztli = dist.get(i);
                routes.add(route2);

                CompilatoreOutputFile.Output(routes, costoCarburanteTonathiu, costoCarburanteMetztli);
            }
        }
    }

    private static void getRoute(int[] prev, int i, List<Integer> route)
    {
        if (i >= 0)
        {
            getRoute(prev, prev[i], route);
            route.add(i);
        }
    }
}