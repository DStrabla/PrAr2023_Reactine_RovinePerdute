//Classe per memorizzare un bordo del graph
class Edge
{
    int source, dest;
    double weight;

    public Edge(int source, int dest, double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}