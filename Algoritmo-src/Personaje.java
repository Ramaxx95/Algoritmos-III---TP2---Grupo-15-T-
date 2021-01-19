package algoritmo;

import java.util.ArrayList;

public class Personaje {

    private int posicionX;
    private int  posicionY;
    private boolean lapiz_abajo;

    public Personaje(){
        this.posicionX = 5;
        this.posicionY = 5;
        this.lapiz_abajo = false;
    }

    public boolean puedeEscribir(){
        return this.lapiz_abajo;
    }

    public void moverseA(int posicion_x, int posicion_y){
        this.posicionX = this.posicionX + posicion_x;
        this.posicionY = this.posicionY + posicion_y;
    }

    public ArrayList<Integer> getPosicion(){
        ArrayList<Integer> posicion = new ArrayList<Integer>(2);
        posicion.add(this.posicionX);
        posicion.add(this.posicionY);   //posicion = (x,y)
        return posicion;
    }

    public void levantarLapiz(){
        this.lapiz_abajo = false;
    }

    public void bajarLapiz(){
        this.lapiz_abajo = true;
    }

}
