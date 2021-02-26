package visual;

import algoritmo.Posicion;
import control.ControladorDeJuego;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class JuegoVista {
	
	VBox contenedorPrincipal;
	DibujoVista dibujoVista;
	AlgoritmoVista algoritmoVista;
	CreadorDeBloquesVista creadorDeBloquesVista;
	ControladorDeJuego controladorDeJuego;
	
	public JuegoVista(){
		contenedorPrincipal = new VBox();
		dibujoVista = new DibujoVista();
		algoritmoVista = new AlgoritmoVista();
		HBox BoxAux = new HBox();
		BoxAux.getChildren().addAll(dibujoVista.getContenedor(),
				algoritmoVista.getContenedor());
		
		creadorDeBloquesVista = new CreadorDeBloquesVista();
		
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

	public void moverPersonaje(Posicion posAux) {
		dibujoVista.moverPersonaje(posAux);
	}

	public void borrarDibujo() {
		dibujoVista.resetearTablero();
	}

	public void agregarImgBloque(String img) {
		algoritmoVista.agrega(new Text(img));
	}

}