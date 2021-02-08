package algoritmo;

import java.util.ArrayList;

public class Personaje {

    private Posicion posicion;
    private boolean lapiz_abajo;

    public Personaje(){
        this.posicion = new Posicion(5,5);
        this.lapiz_abajo = false;
    }

    public boolean puedeEscribir(){
        return this.lapiz_abajo;
    }

    public void moverseA(int posicion_x, int posicion_y){
        this.posicion.moverEnX(posicion_x);
        this.posicion.moverEnY(posicion_y);
    }

    public Posicion getPosicion(){
    	/*
        ArrayList<Integer> posicion = new ArrayList<>(2);
        posicion.add(this.posicion.getColumna());
        posicion.add(this.posicion.getFila());   //posicion = (x,y)
        */
        return posicion;
    }

    public void levantarLapiz(){
        this.lapiz_abajo = false;
    }

    public void bajarLapiz(){
        this.lapiz_abajo = true;
    }

}
