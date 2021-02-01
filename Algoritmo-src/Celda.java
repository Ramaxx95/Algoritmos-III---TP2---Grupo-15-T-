package algoritmo;

public class Celda {

    private boolean esta_pintada;
    private int fila;
    private int columna;

    public Celda(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
        this.esta_pintada = false;
    }
}
