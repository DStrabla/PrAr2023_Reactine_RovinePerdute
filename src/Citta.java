import java.util.ArrayList;

public class Citta {
    private int id;
    private String nome;
    private int x;
    private int y;
    private int h;
    private ArrayList<Integer> link;

    public Citta(int id, String nome, int x, int y, int h, ArrayList<Integer> link) {
        this.id = id;
        this.nome = nome;
        this.x = x;
        this.y = y;
        this.h = h;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getH() {
        return h;
    }

    public ArrayList<Integer> getLink() {
        return link;
    }


}