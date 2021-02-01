package algoritmo;

import java.util.ArrayList;

public class Dibujo {

    private ArrayList<Celda> posiciones_tablero;

    public Dibujo(){
        this.posiciones_tablero = new ArrayList<>();
        for (int fila = 0; fila < 11; fila++){
            for (int columna = 0; columna < 11; columna++){
                Celda pos_aux = new Celda(fila, columna);
                posiciones_tablero.add(pos_aux);
            }
        }
    }

    public void pintarCelda(){}
}
