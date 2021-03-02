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

	@Override
	public void finalizarContenedor() {
		juego.finalizarBloqueContenedor();
		juegoVista.finalizarImgBloqueContenedor();
	}

	@Override
	protected void guardarBloque(CreadorDeBloques creadorDeBloques, String img) {
		Bloque bloque = creadorDeBloques.crearBloque();
		juego.agregarAlBloque(bloque);
		juegoVista.agregarImgBloqueContenedor(img);
	}

	@Override
	protected void guardarBloqueContenedor(CreadorDeBloques creadorDeBloques, String img) {
		
	}
	
}