package control;

import java.util.ArrayList;

import algoritmo.Juego;
import algoritmo.Posicion;
import bloques.Bloques;
import creadores.CreadorDeBloques;
import dibujos.Dibujo;
import visual.JuegoVista;

public class ControladorDeJuego {
	
	private Juego juego;
	private JuegoVista juegoVista;
	
	
	public ControladorDeJuego(Juego unJuego, JuegoVista unVistaJuego){
		this.juego = unJuego;
		this.juegoVista = unVistaJuego;
	}

	public void ejecutar() {
		juego.ejecutarAlgoritmo();
		Dibujo dibujoAux = juego.mostrarDibujo();
		ArrayList<Posicion> posiciones_tablero = dibujoAux.getDibujado();
		
		for(int i = 0; i<posiciones_tablero.size();i++ ) {
			Posicion posAux = posiciones_tablero.get(i);
			juegoVista.moverPersonaje(posAux);
		}
	}

	public void borrarDibujo() {
		juego.borrarDibujo();
		juegoVista.borrarDibujo();
	}

	public void añadirBloque(CreadorDeBloques creadorDeBloques, String img) {
		Bloques bloque = creadorDeBloques.crearBloque();
		juego.agregarBloque(bloque);
		juegoVista.agregarImgBloque(img);
	}
	
	
	
}