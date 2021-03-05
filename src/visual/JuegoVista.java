package visual;

import algoritmo.Algoritmo;
import algoritmo.Personaje;
import bloques.Bloque;
import control.ControladorDeDibujo;
import control.ControladorDeJuego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextInputDialog;
import dibujos.Dibujo;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Optional;

public class JuegoVista {
	
	private VBox contenedorPrincipal;
	private DibujoVista dibujoVista;
	private AlgoritmoVista algoritmoVista;
	private CreadorDeBloquesVista creadorDeBloquesVista;
	private ControladorDeJuego controladorDeJuego;
	private ControladorDeDibujo controladorDeDibujo;
	
	public JuegoVista(){
		contenedorPrincipal = new VBox();
		contenedorPrincipal.setPadding(new Insets(20, 0, 20, 20));
		dibujoVista = new DibujoVista(500,500);
		algoritmoVista = new AlgoritmoVista();
		HBox BoxAux = new HBox();
		BoxAux.getChildren().addAll(dibujoVista.getContenedor(),
				algoritmoVista.getContenedor());
		BoxAux.setAlignment(Pos.CENTER);
		BoxAux.setPadding(new Insets(20, 20, 20, 20));
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
	
	public void insertarNombreAlgoritmoGuardado(ArrayList<Bloque> algoritmo){
		TextInputDialog ventana_dialogo = new TextInputDialog("");
		ventana_dialogo.setTitle("Nombre del Algoritmo");
		ventana_dialogo.setContentText("Introduzca el nombre de su Algoritmo Personalizado:");
		Optional<String> respuesta = ventana_dialogo.showAndWait();
		String nombre = "";

		if (respuesta.isPresent()){
			nombre = respuesta.get();
		}

		creadorDeBloquesVista.cargarBotonAlgoritmoPersonalizado(nombre, algoritmo);
	}
}
