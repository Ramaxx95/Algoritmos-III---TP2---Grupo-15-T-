package visual;

import control.ControladorDeJuego;
import excepciones.NoHayAlgoritmoGuardadoException;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class AlgoritmoVista {
	private ScrollPane scroll;
	private VBox vbox;
	private ControladorDeJuego controladorDeJuego;
	private GridPane tableroAlgoritmo;
	private int cantidadElementos;
	private int cantidadElementosAux;
	
	public AlgoritmoVista(){
		scroll = new ScrollPane();
	    scroll.setPrefSize(595, 200);
		vbox = new VBox();		
		scroll.setContent(vbox);
		Button botonEjecutar = new Button("Ejecutar");
		Button botonReiniciar = new Button("Reiniciar ");
		Button botonGuardar = new Button("Guardar");
		
		botonEjecutar.setOnAction(e -> { controladorDeJuego.ejecutar(); });
		botonReiniciar.setOnAction(e -> { controladorDeJuego.reiniciar(); });
		botonGuardar.setOnAction(e -> {
			try {
				controladorDeJuego.guardarAlgoritmo();
			} catch (NoHayAlgoritmoGuardadoException excepcion) {
				excepcion.printStackTrace();
			}
		});
		tableroAlgoritmo = new GridPane();
		this.cargarBoxAlgoritmo(tableroAlgoritmo, botonEjecutar,botonReiniciar,botonGuardar);
		cantidadElementos = 0;
		cantidadElementosAux = 1;
	}

	private void cargarBoxAlgoritmo(GridPane tableroAlgoritmo, Button botonEjecutar,Button botonReiniciar,Button botonGuardar ) {
		
		HBox boxAlgoritmoHorizontal = new HBox(10);
		Text textAlgoritmo = new Text("Algoritmo");
		boxAlgoritmoHorizontal.getChildren().addAll(textAlgoritmo,botonEjecutar,botonReiniciar,botonGuardar);
		vbox.getChildren().addAll(boxAlgoritmoHorizontal,tableroAlgoritmo);
	}
	
	public ScrollPane getContenedor() {
		return scroll;
	}

	public void setControlador(ControladorDeJuego unControladorDeJuego) {
		controladorDeJuego = unControladorDeJuego;
	}

	public void agrega(Text textBloqueSubir) {
		tableroAlgoritmo.add(textBloqueSubir,0,cantidadElementos);
		cantidadElementos++;
	}
	
	public void agregaImg(Image image) {
		ImageView img = new ImageView(image);
		tableroAlgoritmo.add(img ,0,cantidadElementos);
		cantidadElementos++;
	}

	public void agregaImgContendor(Image image) {
		ImageView img = new ImageView(image);
		tableroAlgoritmo.add(img ,cantidadElementosAux,cantidadElementos -1 );
		cantidadElementosAux++;
	}
	
	public void finalizarContenedor() {
		cantidadElementosAux = 1;
	}

	public void reiniciar() {
		tableroAlgoritmo.getChildren().clear();
	}
	
}
