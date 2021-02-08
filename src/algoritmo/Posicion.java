package algoritmo;

public class Posicion {

    private int fila;
    private int columna;

    public Posicion(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }

    public boolean sonIguales(Posicion otraPosicion) {
        return this.fila == otraPosicion.fila && this.columna == otraPosicion.columna;
    }
    
    @Override
    public boolean equals(Object otraPosicion) {
    	Posicion posAux = (Posicion) otraPosicion;
    	return this.fila == posAux.fila && this.columna == posAux.columna;
    }

    public void reemplazar(Posicion otraPosicion) {
        this.fila = otraPosicion.fila;
        this.columna = otraPosicion.columna;
    }

    public void moverEnX(int pasos){
        this.columna = this.columna + pasos;
    }

    public void moverEnY(int pasos){
        this.fila = this.fila + pasos;
    }

    public int getFila(){
        return this.fila;
    }

    public int getColumna(){
        return this.columna;
    }
}
