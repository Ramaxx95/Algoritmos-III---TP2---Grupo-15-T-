package visual;

import algoritmo.Personaje;
import algoritmo.Posicion;
import control.ControladorDeJuego;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class DibujoVista {
	
	private VBox vbox;
	private ControladorDeJuego controladorDeJuego;
	private Circle circulo;
	private AnchorPane anchor;
	private int ancho;
	private int alto;
	private Line linea;
	
	public DibujoVista(int unAncho, int unAlto){
		vbox = new VBox();
		circulo = new Circle(10,Color.BLACK);
		anchor  = new AnchorPane();
		linea = new Line();
		ancho = unAncho;
		alto = unAlto;
        anchor.setPrefSize(ancho, alto);
        anchor.setMinSize(ancho, alto);
		Button boton = new Button("Borrar");
		boton.setOnAction(e -> { controladorDeJuego.borrarDibujo(); });
		this.cargarBoxDibujo(anchor, boton,vbox);
		
	}

	private void cargarBoxDibujo(AnchorPane anchor, Button boton, VBox vbox2) {
		this.cargarTableroDibujo(anchor);
		
		HBox boxDibujar = new HBox(10);
		Text textDibujo = new Text("dibujo");
		boxDibujar.getChildren().addAll(textDibujo,boton);
		
		vbox.getChildren().addAll(boxDibujar,anchor);
		
	}


	private void cargarTableroDibujo(AnchorPane anchor) {
		circulo.setEffect(new Lighting());
		anchor.getChildren().add(circulo);
		AnchorPane.setTopAnchor(circulo, (double) ((ancho/2) -10));
        AnchorPane.setLeftAnchor(circulo, (double) ((alto/2) -10));
        linea.setStartX((ancho/2));
        linea.setStartY(alto/2);
	}

	public VBox getContenedor() {
		return vbox;
	}

	public void setControlador(ControladorDeJuego unControladorDeJuego) {
		controladorDeJuego = unControladorDeJuego;
	}
	
	public void actualizarPosicion(Personaje un_personaje) {
		Posicion pos_personaje = un_personaje.getPosicion();
		int filaX = 5 - pos_personaje.getFila();
		int filaFinal = 5 + filaX;
		AnchorPane.setTopAnchor(circulo, (double) (filaFinal * 50) -10 );
        AnchorPane.setLeftAnchor(circulo, (double) pos_personaje.getColumna() * 50 -10  );
		
	}

	public void resetearTablero() {
		anchor.getChildren().clear();
		this.cargarTableroDibujo(anchor);
	}

	public void marcarPunto(Posicion posAux) {
		int filaX = 5 - posAux.getFila();
		int filaFinal = 5 + filaX;
		
		double finalx = (double) (posAux.getColumna() * 50);
        double finaly = (double) (filaFinal * 50);
        Circle circulo2 = new Circle(5,Color.BLUE);
        anchor.getChildren().addAll(circulo2);
        AnchorPane.setTopAnchor(circulo2, finaly -5);
        AnchorPane.setLeftAnchor(circulo2, finalx -5) ;
	}

	public void dibujarLinea(Posicion posActual, Posicion posAux) {
		
		
		Line lineaAux = new Line();
		int filaX = 5 - posActual.getFila();
		int filaFinal = 5 + filaX;
		double inicialx = (double) (posActual.getColumna() * 50);
        double inicialy = (double) (filaFinal * 50);
        int xfilaX = 5 - posAux.getFila();
		int xfilaFinal = 5 + xfilaX;
		double finalx = (double) (posAux.getColumna() * 50);
        double finaly = (double) (xfilaFinal * 50);
        lineaAux.setStartX( inicialx );
        lineaAux.setStartY( inicialy);
        lineaAux.setEndX(finalx);
        lineaAux.setEndY(finaly);
        anchor.getChildren().addAll(lineaAux);
	}
}

