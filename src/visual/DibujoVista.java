package visual;

import algoritmo.Posicion;
import control.ControladorDeJuego;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class DibujoVista {
	
	private VBox vbox;
	ControladorDeJuego controladorDeJuego;
	Circle circulo;
	GridPane tablero;
	
	public DibujoVista(){
		//configuracion de la vista dibujo
		vbox = new VBox();
		circulo = new Circle(15,Color.BLACK);
		tablero = new GridPane();
		Button boton = new Button("Borrar");
		boton.setOnAction(e -> { controladorDeJuego.borrarDibujo(); });
		this.cargarBoxDibujo(tablero, boton,vbox);
		
	}

	private void cargarBoxDibujo(GridPane tablero, Button boton, VBox vbox2) {
		this.cargarTableroDibujo(tablero);
		
		HBox boxDibujar = new HBox(10);
		Text textDibujo = new Text("dibujo");
		boxDibujar.getChildren().addAll(textDibujo,boton);
		
		vbox.getChildren().addAll(boxDibujar,tablero);
		
	}


	private void cargarTableroDibujo(GridPane tablero) {
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				tablero.add(new Rectangle(50,50,Color.BEIGE),i,j);
			}
		}
		circulo.setEffect(new Lighting());
		tablero.add(circulo,5,5);
		GridPane.setHalignment(circulo, HPos.CENTER);
	}

	public VBox getContenedor() {
		return vbox;
	}

	public void setControlador(ControladorDeJuego unControladorDeJuego) {
		controladorDeJuego = unControladorDeJuego;
	}

	public void moverPersonaje(Posicion posAux) {
		final Circle circuloAux = new Circle(5,Color.BLUE);
		GridPane.setHalignment(circuloAux, HPos.CENTER);
		
		int columna = GridPane.getColumnIndex(circulo);
		int fila = GridPane.getRowIndex(circulo);
		tablero.add(circuloAux, columna, fila);
		
		int filaX = 5 - posAux.getColumna();
		int columnaFinal = 5 + filaX;
		
		GridPane.setColumnIndex(circulo, posAux.getFila() );
		GridPane.setRowIndex(circulo, columnaFinal );
	}

	public void resetearTablero() {
		tablero.getChildren().clear();
		this.cargarTableroDibujo(tablero);
	}
}