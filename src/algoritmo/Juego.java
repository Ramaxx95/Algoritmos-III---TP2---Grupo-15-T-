package algoritmo;

import java.util.ArrayList;

import bloques.Bloque;
import bloques.Contenedor;
import dibujos.Dibujo;

import java.util.ArrayList;

public class Juego {

    private Tablero tablero;
    private Personaje personaje;
    private Contenedor bloqueContenedor;

    public Juego(){
        this.tablero = new Tablero();
        this.personaje = new Personaje();
        bloqueContenedor = null;
    }

    public void agregarBloque(Bloque un_bloque){
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
	
    public ArrayList<Bloque> pasarAlgoritmoGuardado(){
        return this.tablero.darAlgoritmoGuardado();
    }

    public void ejecutarAlgoritmo(){
        this.tablero.ejecutarAlgoritmoCon(this.personaje);
    }

    public void reiniciar(){
        this.tablero.reiniciarAlgoritmo();
        this.personaje.resetearPosicion();
    }
    
    public Dibujo mostrarDibujo() {
    	return tablero.mostrarDibujo();
    }

	public Personaje getPersonaje() {
		return personaje;
	}

	public void borrarDibujo() {
		this.personaje.resetearPosicion();
		this.tablero.borrarDibujo();
	}

	public void agregarBloqueContenedor(Contenedor bloque) {
		bloqueContenedor = bloque;
	}
	
	public void agregarAlBloque(Bloque un_bloque) {
		bloqueContenedor.agregarBloque(un_bloque);
	}
	
	public void finalizarBloqueContenedor() {
		this.agregarBloque(bloqueContenedor);
		bloqueContenedor = null;
	}
}
