package visual;

import bloques.Bloque;
import control.ControladorDeBloques;
import control.ControladorDeJuego;
import excepciones.NoHayAlgoritmoGuardadoException;
import javafx.scene.control.Button;
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
			controladorDeJuego.guardarBloque( new CreadorDeMoverArriba(),ControladorDeBloques.moverArriba); });
		
		Button bajar = new Button("Bajar");
		bajar.setOnAction(e -> { 
			controladorDeJuego.guardarBloque( new CreadorDeMoverAbajo(),ControladorDeBloques.moverAbajo); });

		Button derecha = new Button("Derecha");
		derecha.setOnAction(e -> { 
			controladorDeJuego.guardarBloque( new CreadorDeMoverDerecha(),ControladorDeBloques.moverDerecha ); });

		Button izquierda = new Button("izquierda");
		izquierda.setOnAction(e -> { 
			controladorDeJuego.guardarBloque( new CreadorDeMoverIzquierda(),ControladorDeBloques.moverIzquierda ); });

		Button subirLapiz = new Button("Subir Lapiz");
		subirLapiz.setOnAction(e -> { 
			controladorDeJuego.guardarBloque( new CreadorDeSubirLapiz(),ControladorDeBloques.subirLapiz ); });

		Button bajarLapiz = new Button("Bajar Lapiz");
		bajarLapiz.setOnAction(e -> { 
			controladorDeJuego.guardarBloque( new CreadorDeBajarLapiz(),ControladorDeBloques.bajarLapiz ); });
		
		Button repeticionX2 = new Button("Repetir dos veces");
		repeticionX2.setOnAction(e -> { 
			controladorDeJuego.guardarBloqueContenedor( new CreadorDeRepetirDosVeces(),ControladorDeBloques.repetirDosVeces ); });

		Button repeticionX3 = new Button("Repetir tres veces");
		repeticionX3.setOnAction(e -> { 
			controladorDeJuego.guardarBloqueContenedor( new CreadorDeRepetirTresVeces(),ControladorDeBloques.repetirTresVeces ); });
		
		Button invertir = new Button("Invertir Comportamiento");
		invertir.setOnAction(e -> {
			controladorDeJuego.guardarBloqueContenedor(new CreadorDeInvertirComportamiento(), ControladorDeBloques.invertirComportamiento);
		});
		
		Button boton_vacio = new Button("  ");
		
		HBox box = new HBox();
		box.getChildren().addAll(textoBloques,finalizar);		
		
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
