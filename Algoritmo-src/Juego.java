package algoritmo;

import java.util.ArrayList;

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

    public ArrayList<Integer> posicionActual(){
        return this.personaje.getPosicion();
    }

    public boolean personajePuedeEscribir(){
        return this.personaje.puedeEscribir();
    }

    public void ejecutarAlgoritmo(){
        this.tablero.ejecutarAlgoritmoCon(this.personaje);
    }

}
