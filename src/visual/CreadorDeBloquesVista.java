package visual;

import bloques.Bloque;
import control.ControladorDeBloques;
import control.ControladorDeJuego;
import excepciones.NoHayAlgoritmoGuardadoException;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import creadores.*;

import java.util.ArrayList;

public class CreadorDeBloquesVista {
	private VBox vBox;
	ControladorDeJuego controladorDeJuego;
	
	public CreadorDeBloquesVista(){
		vBox = new VBox();
		vBox.setSpacing(3);
		vBox.setPrefSize(1000,70);
		Text textoBloques = new Text("Bloques");
		this.cargarBoxBloques(textoBloques);
		
	}

	public VBox getContenedor() {
		return vBox;
	}
	
	public void cargarBoxBloques(Text textoBloques) {
		HBox HboxBLoque = new HBox();
		HboxBLoque.setSpacing(10);
		Button finalizar = new Button("finalizar");
		finalizar.setOnAction(e -> { 
			controladorDeJuego.finalizarContenedor(); });
		
		
		Button subir = new Button();
		Image imgSubir = new Image(ControladorDeBloques.moverArriba);
		subir.setGraphic(new ImageView(imgSubir));
		subir.setOnAction(e -> {
			controladorDeJuego.guardarBloque( new CreadorDeMoverArriba(),ControladorDeBloques.moverArriba); });
		
		Button bajar = new Button();
		Image imgBajar = new Image(ControladorDeBloques.moverAbajo);
		bajar.setGraphic(new ImageView(imgBajar));
		bajar.setOnAction(e -> { 
			controladorDeJuego.guardarBloque( new CreadorDeMoverAbajo(),ControladorDeBloques.moverAbajo); });

		Button derecha = new Button();
		Image imgDerecha = new Image(ControladorDeBloques.moverDerecha);
		derecha.setGraphic(new ImageView(imgDerecha));
		derecha.setOnAction(e -> { 
			controladorDeJuego.guardarBloque( new CreadorDeMoverDerecha(),ControladorDeBloques.moverDerecha ); });

		Button izquierda = new Button();
		Image imgIzquierda = new Image(ControladorDeBloques.moverIzquierda);
		izquierda.setGraphic(new ImageView(imgIzquierda));
		izquierda.setOnAction(e -> { 
			controladorDeJuego.guardarBloque( new CreadorDeMoverIzquierda(),ControladorDeBloques.moverIzquierda ); });

		Button subirLapiz = new Button();
		Image imgSubirLapiz = new Image(ControladorDeBloques.subirLapiz);
		subirLapiz.setGraphic(new ImageView(imgSubirLapiz));
		subirLapiz.setOnAction(e -> { 
			controladorDeJuego.guardarBloque( new CreadorDeSubirLapiz(),ControladorDeBloques.subirLapiz ); });

		Button bajarLapiz = new Button();
		Image imgBajarLapiz = new Image(ControladorDeBloques.bajarLapiz);
		bajarLapiz.setGraphic(new ImageView(imgBajarLapiz));
		bajarLapiz.setOnAction(e -> { 
			controladorDeJuego.guardarBloque( new CreadorDeBajarLapiz(),ControladorDeBloques.bajarLapiz ); });
		
		Button repeticionX2 = new Button();
		Image imgRepeticionX2 = new Image(ControladorDeBloques.repetirDosVeces);
		repeticionX2.setGraphic(new ImageView(imgRepeticionX2));
		repeticionX2.setOnAction(e -> { 
			controladorDeJuego.guardarBloqueContenedor( new CreadorDeRepetirDosVeces(),ControladorDeBloques.repetirDosVeces ); });

		Button repeticionX3 = new Button();
		Image imgRepeticionX3 = new Image(ControladorDeBloques.repetirTresVeces);
		repeticionX3.setGraphic(new ImageView(imgRepeticionX3));
		repeticionX3.setOnAction(e -> { 
			controladorDeJuego.guardarBloqueContenedor( new CreadorDeRepetirTresVeces(),ControladorDeBloques.repetirTresVeces ); });
		
		Button invertir = new Button();
		Image imgInvertir = new Image(ControladorDeBloques.invertirComportamiento);
		invertir.setGraphic(new ImageView(imgInvertir));
		invertir.setOnAction(e -> {
			controladorDeJuego.guardarBloqueContenedor(new CreadorDeInvertirComportamiento(), ControladorDeBloques.invertirComportamiento);
		});
		
		Button boton_vacio = new Button("  ");
		
		HBox box = new HBox();
		box.getChildren().addAll(textoBloques,finalizar);		
		finalizar.setTranslateX(1000);
		HboxBLoque.getChildren().addAll(subir,bajar,derecha,izquierda,subirLapiz,bajarLapiz,repeticionX2,repeticionX3,invertir);
		vBox.getChildren().addAll(box,HboxBLoque );
		vBox.getChildren().add(boton_vacio);
	}

	public void setControlador(ControladorDeJuego unControladorDeJuego) {
		controladorDeJuego = unControladorDeJuego;
	}
	
	public void cargarBotonAlgoritmoPersonalizado(String nombre, ArrayList<Bloque> algoritmo){
		Button guardarAlgoritmo = new Button(nombre);
		guardarAlgoritmo.setOnAction(e -> {
			try {
				controladorDeJuego.guardarBloque(new CreadorDeAlgoritmoPersonalizado(algoritmo), ControladorDeBloques.algoritmoPersonalizado);
			} catch (NoHayAlgoritmoGuardadoException excepcion) {
				excepcion.printStackTrace();
			}
		});
		
		vBox.getChildren().add(2, guardarAlgoritmo);
	}
	
}
