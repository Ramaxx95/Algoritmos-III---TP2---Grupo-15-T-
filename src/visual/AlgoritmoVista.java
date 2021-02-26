package visual;

import control.ControladorDeJuego;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class AlgoritmoVista {
	private VBox vbox;
	ControladorDeJuego controladorDeJuego;
	GridPane tableroAlgoritmo;
	int cantidadElementos;
	
	public AlgoritmoVista(){
		vbox = new VBox();
		Button botonEjecutar = new Button("Ejecutar");
		botonEjecutar.setOnAction(e -> { controladorDeJuego.ejecutar(); });
		tableroAlgoritmo = new GridPane();
		this.cargarBoxAlgoritmo(tableroAlgoritmo, botonEjecutar);
		cantidadElementos = 0;
	}

	private void cargarBoxAlgoritmo(GridPane tableroAlgoritmo, Button botonEjecutar) {
		
		HBox boxAlgoritmoHorizontal = new HBox(10);
		Text textAlgoritmo = new Text("Algoritmo");
		boxAlgoritmoHorizontal.getChildren().addAll(textAlgoritmo,botonEjecutar);
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				tableroAlgoritmo.add(new Rectangle(50,50,Color.BEIGE),i,j);
			}
		}
		
		vbox.getChildren().addAll(boxAlgoritmoHorizontal,tableroAlgoritmo);
	}

	public VBox getContenedor() {
		return vbox;
	}

	public void setControlador(ControladorDeJuego unControladorDeJuego) {
		controladorDeJuego = unControladorDeJuego;
	}

	public void agrega(Text textBloqueSubir) {
		tableroAlgoritmo.add(textBloqueSubir,0,cantidadElementos);
		cantidadElementos++;
	}
	
}