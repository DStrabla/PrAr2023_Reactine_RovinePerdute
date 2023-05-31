public class Strada {
    int id_partenza;
    int id_arrivo;
    double peso_h;

    double peso_euclideo;

    public Strada(int id_partenza, int id_arrivo, double peso_h, double peso_euclideo) {
        this.id_partenza = id_partenza;
        this.id_arrivo = id_arrivo;
        this.peso_h = peso_h;
        this.peso_euclideo = peso_euclideo;
    }

    public int getId_partenza() {
        return id_partenza;
    }

    public void setId_partenza(int id_partenza) {
        this.id_partenza = id_partenza;
    }

    public int getId_arrivo() {
        return id_arrivo;
    }

    public void setId_arrivo(int id_arrivo) {
        this.id_arrivo = id_arrivo;
    }

    public double getPeso_h() {
        return peso_h;
    }

    public void setPeso_h(int peso_h) {
        this.peso_h = peso_h;
    }

    public double getPeso_euclideo() {
        return peso_euclideo;
    }

    public void setPeso_euclideo(int peso_euclideo) {
        this.peso_euclideo = peso_euclideo;
    }
}