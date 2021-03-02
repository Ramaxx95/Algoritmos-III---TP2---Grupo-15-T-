package control;

import java.util.ArrayList;

import algoritmo.Juego;
import algoritmo.Personaje;
import bloques.*;
import creadores.CreadorDeBloques;
import dibujos.Dibujo;
import excepciones.NoHayAlgoritmoGuardadoException;
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
		Dibujo dibujo = juego.mostrarDibujo();
		juegoVista.dibujarCon(dibujo);
		
		Personaje personaje = juego.getPersonaje();
		juegoVista.dibujarPosicionActual(personaje);
	}

	public void borrarDibujo() {
		juego.borrarDibujo();
		juegoVista.borrarDibujo();
	}

	public void guardarBloque(CreadorDeBloques creadorDeBloques, String img) {
		controladorDeGuardado.guardarBloque(creadorDeBloques, img);
	}
	
	public void guardarBloqueContenedor(CreadorDeBloques creadorDeBloques, String img) {
		controladorDeGuardado.guardarBloqueContenedor(creadorDeBloques, img);
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
	
	public void guardarAlgoritmo() throws NoHayAlgoritmoGuardadoException{
		juego.guardarAlgoritmo();
		ArrayList<Bloque> algoritmo_guardado = juego.pasarAlgoritmoGuardado();
		if(algoritmo_guardado.size() == 0){
			throw new NoHayAlgoritmoGuardadoException();
		}
		juegoVista.insertarNombreAlgoritmoGuardado(algoritmo_guardado);
	}
	
}
