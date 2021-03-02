package visual;

import algoritmo.Personaje;
import algoritmo.Posicion;
import control.ControladorDeDibujo;
import control.ControladorDeJuego;
import dibujos.Dibujo;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class JuegoVista {
	
	VBox contenedorPrincipal;
	DibujoVista dibujoVista;
	AlgoritmoVista algoritmoVista;
	CreadorDeBloquesVista creadorDeBloquesVista;
	ControladorDeJuego controladorDeJuego;
	ControladorDeDibujo controladorDeDibujo;
	
	public JuegoVista(){
		contenedorPrincipal = new VBox();
		dibujoVista = new DibujoVista(500,500);
		algoritmoVista = new AlgoritmoVista();
		HBox BoxAux = new HBox();
		BoxAux.getChildren().addAll(dibujoVista.getContenedor(),
				algoritmoVista.getContenedor());
		
		creadorDeBloquesVista = new CreadorDeBloquesVista();
		controladorDeDibujo = new ControladorDeDibujo(dibujoVista);
		contenedorPrincipal.getChildren().addAll(BoxAux,creadorDeBloquesVista.getContenedor());
	}

	public VBox getEscena() {
		return contenedorPrincipal;
	}
	
	public void setControlador(ControladorDeJuego unControladorDeJuego) {
		controladorDeJuego = unControladorDeJuego;
		creadorDeBloquesVista.setControlador(unControladorDeJuego);
		dibujoVista.setControlador(unControladorDeJuego);
		algoritmoVista.setControlador(unControladorDeJuego);
	}
	
	/*
	public void moverPersonaje(Posicion posAux) {
		dibujoVista.moverPersonaje(posAux);
	}
	*/
	
	
	public void dibujarPosicionActual(Personaje un_personaje){
		dibujoVista.actualizarPosicion(un_personaje);
	}

	public void borrarDibujo() {
		dibujoVista.resetearTablero();
	}

	public void agregarImgBloque(String img) {
		algoritmoVista.agregaImg(new Image(img));
	}
	
	public void agregarImgBloqueContenedor(String img) {
		algoritmoVista.agregaImgContendor(new Image(img));
	}
	
	public void finalizarImgBloqueContenedor() {
		algoritmoVista.finalizarContenedor();
	}
	
	public void reiniciar() {
		this.borrarDibujo();
		this.algoritmoVista.reiniciar();
	}

	public void dibujarCon(Dibujo dibujo) {
		controladorDeDibujo.dibujarCon(dibujo);
	}
}
