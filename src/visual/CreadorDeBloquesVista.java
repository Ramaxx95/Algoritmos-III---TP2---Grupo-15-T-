package visual;

import control.ControladorDeBloques;
import control.ControladorDeJuego;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import creadores.*;

public class CreadorDeBloquesVista {
	private VBox vBox;
	ControladorDeJuego controladorDeJuego;
	
	public CreadorDeBloquesVista(){
		vBox = new VBox();
		Text textoBloques = new Text("Bloques");
		this.cargarBoxBloques(textoBloques);
		
	}

	public VBox getContenedor() {
		return vBox;
	}
	
	public void cargarBoxBloques(Text textoBloques) {
		HBox HboxBLoque = new HBox();
		
		Button subir = new Button("Subir");
		subir.setOnAction(e -> { 
			controladorDeJuego.añadirBloque( new CreadorDeMoverArriba(),ControladorDeBloques.moverArriba ); });
		
		Button bajar = new Button("Bajar");
		bajar.setOnAction(e -> { 
			controladorDeJuego.añadirBloque( new CreadorDeMoverAbajo(),ControladorDeBloques.moverAbajo); });

		Button derecha = new Button("Derecha");
		derecha.setOnAction(e -> { 
			controladorDeJuego.añadirBloque( new CreadorDeMoverDerecha(),ControladorDeBloques.moverDerecha ); });

		Button izquierda = new Button("izquierda");
		izquierda.setOnAction(e -> { 
			controladorDeJuego.añadirBloque( new CreadorDeMoverIzquierda(),ControladorDeBloques.moverIzquierda ); });

		Button subirLapiz = new Button("Subir Lapiz");
		subirLapiz.setOnAction(e -> { 
			controladorDeJuego.añadirBloque( new CreadorDeSubirLapiz(),ControladorDeBloques.subirLapiz ); });

		Button bajarLapiz = new Button("Bajar Lapiz");
		bajarLapiz.setOnAction(e -> { 
			controladorDeJuego.añadirBloque( new CreadorDeBajarLapiz(),ControladorDeBloques.bajarLapiz ); });
		
		Button repeticionX2 = new Button("Repetir dos veces");
		repeticionX2.setOnAction(e -> { 
			controladorDeJuego.añadirBloque( new CreadorDeRepetirDosVeces(),ControladorDeBloques.repetirDosVeces ); });

		Button repeticionX3 = new Button("Repetir tres veces");
		repeticionX3.setOnAction(e -> { 
			controladorDeJuego.añadirBloque( new CreadorDeRepetirTresVeces(),ControladorDeBloques.repetirTresVeces ); });
				
		HboxBLoque.getChildren().addAll(subir,bajar,derecha,izquierda,subirLapiz,bajarLapiz,repeticionX2,repeticionX3);
		vBox.getChildren().addAll(textoBloques,HboxBLoque );
	}

	public void setControlador(ControladorDeJuego unControladorDeJuego) {
		controladorDeJuego = unControladorDeJuego;
	}
	
}
