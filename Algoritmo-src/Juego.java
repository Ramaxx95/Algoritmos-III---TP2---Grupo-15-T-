package algoritmo;

import java.util.ArrayList;

public class Juego {

    private Algoritmo algoritmo;
    private Personaje personaje;

    public Juego(){
        this.algoritmo = new Algoritmo();
        this.personaje = new Personaje();
    }

    public void agregarBloque(Bloques un_bloque){
        this.algoritmo.agregarBloque(un_bloque);
    }

    public ArrayList<Integer> posicionActual(){
        return this.personaje.getPosicion();
    }

    public boolean personajePuedeEscribir(){
        return this.personaje.puedeEscribir();
    }

    public void ejecutarAlgoritmo(){
        this.algoritmo.ejecutar(this.personaje);
    }

}
