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
	private static int FACTORDEADAPTACION = 50;
	
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
		Posicion posicionInicial = this.posicionAdaptada(pos_personaje);
		AnchorPane.setTopAnchor(circulo, (double) posicionInicial.getFila() -10 );
        AnchorPane.setLeftAnchor(circulo, (double) posicionInicial.getColumna() * 50 -10  );
		
	}

	public void resetearTablero() {
		anchor.getChildren().clear();
		this.cargarTableroDibujo(anchor);
	}

	public void marcarPunto(Posicion posActual) {
		Posicion posicionInicial = this.posicionAdaptada(posActual);
		
		double finalx = (double) posicionInicial.getColumna();
        double finaly = (double) posicionInicial.getFila();
        Circle circulo2 = new Circle(5,Color.BLUE);
        anchor.getChildren().addAll(circulo2);
        AnchorPane.setTopAnchor(circulo2, finaly -5);
        AnchorPane.setLeftAnchor(circulo2, finalx -5) ;
	}

	public void dibujarLinea(Posicion posActual, Posicion posAux) {
		Line lineaAux = new Line();
		Posicion posicionInicial = this.posicionAdaptada(posActual);
		Posicion posicionFinal = this.posicionAdaptada(posAux);
		
		double inicialx = (double) posicionInicial.getColumna();
        double inicialy = (double) posicionInicial.getFila();
		double finalx = (double) posicionFinal.getColumna();
        double finaly = (double) posicionFinal.getFila();
        lineaAux.setStartX( inicialx );
        lineaAux.setStartY( inicialy);
        lineaAux.setEndX(finalx);
        lineaAux.setEndY(finaly);
        anchor.getChildren().addAll(lineaAux);
	}
	
	private Posicion posicionAdaptada(Posicion posActual) {
		int filaX = 5 - posActual.getFila();
		int filaFinal = 5 + filaX;
		int inicialx = (posActual.getColumna() * FACTORDEADAPTACION);
        int inicialy = (filaFinal * FACTORDEADAPTACION);
        Posicion posicion = new Posicion(inicialx,inicialy);
        return posicion;
	}
	
}

