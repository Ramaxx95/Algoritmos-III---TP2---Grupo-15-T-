package control;

import algoritmo.Juego;
import bloques.*;
import creadores.CreadorDeBloques;
import visual.JuegoVista;

public class ControladorDeGuardadAlternativo extends ControladorDeGuardado {
	
	private Juego juego;
	private JuegoVista juegoVista;
	
	public ControladorDeGuardadAlternativo(Juego unJuego, JuegoVista unJuegoVista ) {
		juego = unJuego;
		juegoVista = unJuegoVista;
	}
	
	public void añadirBloque(CreadorDeBloques creadorDeBloques, String img) {
		Bloque bloque = creadorDeBloques.crearBloque();
		juego.agregarAlBloque(bloque);
		juegoVista.agregarImgBloqueContenedor(img);
	}
	
	public void añadirBloqueContenedor(CreadorDeBloques creadorDeBloques, String img) {

	}

	@Override
	public void finalizarContenedor() {
		juego.finalizarBloqueContenedor();
		juegoVista.finalizarImgBloqueContenedor();
	}
	
}