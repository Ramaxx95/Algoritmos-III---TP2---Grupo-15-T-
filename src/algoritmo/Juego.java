package algoritmo;

import java.util.ArrayList;

import bloques.Bloques;

public class Juego {

    private Tablero tablero;
    private Personaje personaje;

    public Juego(){
        this.tablero = new Tablero();
        this.personaje = new Personaje();
    }

    public void agregarBloque(Bloques un_bloque){
        this.tablero.agregarBloqueAlAlgoritmo(un_bloque);
    }

    public Posicion posicionActual(){
        return this.personaje.getPosicion();
    }
    
    public boolean tableroVacio(){
        return this.tablero.dibujoVacio();
    }

    public boolean personajePuedeEscribir(){
        return this.personaje.puedeEscribir();
    }
    
    public void guardarAlgoritmo(){
        this.tablero.guardarAlgoritmoActual();
    }

    public Algoritmo pasarAlgoritmo(){
        return this.tablero.darAlgoritmo();
    }

    public void ejecutarAlgoritmo(){
        this.tablero.ejecutarAlgoritmoCon(this.personaje);
    }

    public void reiniciar(){
        this.tablero.reiniciarAlgoritmo();
        this.personaje.resetearPosicion();
    }
    
}
