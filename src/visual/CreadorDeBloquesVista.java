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
		Button finalizar = new Button("finalizar");
		finalizar.setOnAction(e -> { 
			controladorDeJuego.finalizarContenedor(); });
		
		
		Button subir = new Button("Subir");
		subir.setOnAction(e -> { 
			controladorDeJuego.a�adirBloque( new CreadorDeMoverArriba(),ControladorDeBloques.moverArriba); });
		
		Button bajar = new Button("Bajar");
		bajar.setOnAction(e -> { 
			controladorDeJuego.a�adirBloque( new CreadorDeMoverAbajo(),ControladorDeBloques.moverAbajo); });

		Button derecha = new Button("Derecha");
		derecha.setOnAction(e -> { 
			controladorDeJuego.a�adirBloque( new CreadorDeMoverDerecha(),ControladorDeBloques.moverDerecha ); });

		Button izquierda = new Button("izquierda");
		izquierda.setOnAction(e -> { 
			controladorDeJuego.a�adirBloque( new CreadorDeMoverIzquierda(),ControladorDeBloques.moverIzquierda ); });

		Button subirLapiz = new Button("Subir Lapiz");
		subirLapiz.setOnAction(e -> { 
			controladorDeJuego.a�adirBloque( new CreadorDeSubirLapiz(),ControladorDeBloques.subirLapiz ); });

		Button bajarLapiz = new Button("Bajar Lapiz");
		bajarLapiz.setOnAction(e -> { 
			controladorDeJuego.a�adirBloque( new CreadorDeBajarLapiz(),ControladorDeBloques.bajarLapiz ); });
		
		Button repeticionX2 = new Button("Repetir dos veces");
		repeticionX2.setOnAction(e -> { 
			controladorDeJuego.a�adirBloqueContenedor( new CreadorDeRepetirDosVeces(),ControladorDeBloques.repetirDosVeces ); });

		Button repeticionX3 = new Button("Repetir tres veces");
		repeticionX3.setOnAction(e -> { 
			controladorDeJuego.a�adirBloqueContenedor( new CreadorDeRepetirTresVeces(),ControladorDeBloques.repetirTresVeces ); });
		
		Button invertir = new Button("Invertir Comportamiento");
		invertir.setOnAction(e -> {
			controladorDeJuego.a�adirBloqueContenedor(new CreadorDeInvertirComportamiento(), ControladorDeBloques.invertirComportamiento);
		});
		
		HBox box = new HBox();
		box.getChildren().addAll(textoBloques,finalizar);		
		
		HboxBLoque.getChildren().addAll(subir,bajar,derecha,izquierda,subirLapiz,bajarLapiz,repeticionX2,repeticionX3,invertir);
		vBox.getChildren().addAll(box,HboxBLoque );
	}

	public void setControlador(ControladorDeJuego unControladorDeJuego) {
		controladorDeJuego = unControladorDeJuego;
	}
	
}
