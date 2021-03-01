package control;

import java.util.ArrayList;

import algoritmo.Juego;
import algoritmo.Personaje;
import algoritmo.Posicion;
import bloques.*;
import creadores.CreadorDeBloques;
import dibujos.Dibujo;
import visual.JuegoVista;

public class ControladorDeJuego {
	
	private Juego juego;
	private JuegoVista juegoVista;
	private ControladorDeGuardado controladorDeGuardado;
	
	
	public ControladorDeJuego(Juego unJuego, JuegoVista unVistaJuego){
		this.juego = unJuego;
		this.juegoVista = unVistaJuego;
		this.controladorDeGuardado = new ControladorDeGuardadoPrincipal( unJuego, unVistaJuego );
	}

	public void ejecutar() {
		this.borrarDibujo();
		juego.ejecutarAlgoritmo();
		Dibujo dibujoAux = juego.mostrarDibujo();
		ArrayList<Posicion> posiciones_tablero = dibujoAux.getDibujado();
		
		for(int i = 0; i<posiciones_tablero.size();i++ ) {
			Posicion posAux = posiciones_tablero.get(i);
			juegoVista.moverPersonaje(posAux);
		}
		Personaje personaje = juego.getPersonaje();
		juegoVista.dibujarPosicionActual(personaje);
	}

	public void borrarDibujo() {
		juego.borrarDibujo();
		juegoVista.borrarDibujo();
	}

	public void añadirBloque(CreadorDeBloques creadorDeBloques, String img) {
		controladorDeGuardado.añadirBloque(creadorDeBloques, img);
	}
	
	public void añadirBloqueContenedor(CreadorDeBloques creadorDeBloques, String img) {
		controladorDeGuardado.añadirBloqueContenedor(creadorDeBloques, img);
		controladorDeGuardado = new ControladorDeGuardadAlternativo(juego,juegoVista);
	}
	
	public void finalizarContenedor() {
		controladorDeGuardado.finalizarContenedor();
		controladorDeGuardado = new ControladorDeGuardadoPrincipal( juego, juegoVista );
	}

	public void reiniciar() {
		juego.reiniciar();
		juegoVista.reiniciar();
	}
	
}
