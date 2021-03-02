package control;

import algoritmo.Juego;
import bloques.*;
import creadores.CreadorDeBloques;
import visual.JuegoVista;

public class ControladorDeGuardadoPrincipal extends ControladorDeGuardado {
	
	private Juego juego;
	private JuegoVista juegoVista;
	
	public ControladorDeGuardadoPrincipal(Juego unJuego, JuegoVista unJuegoVista ) {
		juego = unJuego;
		juegoVista = unJuegoVista;
	}

	@Override
	public void finalizarContenedor() {
	}

	@Override
	protected void guardarBloque(CreadorDeBloques creadorDeBloques, String img) {
		Bloque bloque = creadorDeBloques.crearBloque();
		juego.agregarBloque(bloque);
		juegoVista.agregarImgBloque(img);
	}

	@Override
	protected void guardarBloqueContenedor(CreadorDeBloques creadorDeBloques, String img) {
		Contenedor bloque = (Contenedor) creadorDeBloques.crearBloque();
		juego.agregarBloqueContenedor(bloque);
		juegoVista.agregarImgBloque(img);
	}
	
}