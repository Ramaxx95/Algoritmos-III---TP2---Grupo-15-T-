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
		//configuracion de la vista dibujo
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

	public void moverPersonaje(Posicion posAux) {
		int filaX = 5 - posAux.getFila();
		int filaFinal = 5 + filaX;
		
		double finalx = (double) (posAux.getColumna() * 50);
        double finaly = (double) (filaFinal * 50);
        Circle circulo2 = new Circle(5,Color.BLUE);
        anchor.getChildren().addAll(circulo2);
        AnchorPane.setTopAnchor(circulo2, finaly -5);
        AnchorPane.setLeftAnchor(circulo2, finalx -5) ;
        double absolutoX = Math.abs(linea.getStartX() - finalx);
        double absolutoY = Math.abs(linea.getStartY() - finaly);
        if( absolutoX+absolutoY   < 100 ) {
        	linea.setEndX(finalx);
	        linea.setEndY(finaly);
	        anchor.getChildren().addAll(linea);
        }
        /*
        if( (Math.abs(linea.getStartX() - finalx) < 100) && (Math.abs(linea.getStartY() - finaly) < 100)   ) {
        	linea.setEndX(finalx);
	        linea.setEndY(finaly);
	        anchor.getChildren().addAll(linea);
        }
        */
	    Line lineaAux = new Line();
	    lineaAux.setStartX( finalx );
	    lineaAux.setStartY( finaly);
	    linea = lineaAux;
	}
	
	public void actualizarPosicion(Personaje un_personaje) {
		Posicion pos_personaje = un_personaje.getPosicion();
		this.moverPersonaje(pos_personaje);
		int filaX = 5 - pos_personaje.getFila();
		int filaFinal = 5 + filaX;
		AnchorPane.setTopAnchor(circulo, (double) (filaFinal * 50) -10 );
        AnchorPane.setLeftAnchor(circulo, (double) pos_personaje.getColumna() * 50 -10  );
		
	}

	public void resetearTablero() {
		anchor.getChildren().clear();
		this.cargarTableroDibujo(anchor);
	}
}

