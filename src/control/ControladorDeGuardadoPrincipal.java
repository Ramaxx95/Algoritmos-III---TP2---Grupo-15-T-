package control;

import java.util.ArrayList;

import algoritmo.Juego;
import algoritmo.Posicion;
import bloques.*;
import creadores.CreadorDeBloques;
import dibujos.Dibujo;
import visual.JuegoVista;

public class ControladorDeGuardadoPrincipal extends ControladorDeGuardado {
	
	private Juego juego;
	private JuegoVista juegoVista;
	
	public ControladorDeGuardadoPrincipal(Juego unJuego, JuegoVista unJuegoVista ) {
		juego = unJuego;
		juegoVista = unJuegoVista;
	}
	
	public void añadirBloque(CreadorDeBloques creadorDeBloques, String img) {
		Bloque bloque = creadorDeBloques.crearBloque();
		juego.agregarBloque(bloque);
		juegoVista.agregarImgBloque(img);
	}
	
	public void añadirBloqueContenedor(CreadorDeBloques creadorDeBloques, String img) {
		Contenedor bloque = (Contenedor) creadorDeBloques.crearBloque();
		juego.agregarBloqueContenedor(bloque);
		juegoVista.agregarImgBloque(img);
	}

	@Override
	public void finalizarContenedor() {
	}
	
}