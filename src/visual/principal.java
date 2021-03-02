package visual;

import algoritmo.Juego;
import control.ControladorDeJuego;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class principal extends Application {
	
	BorderPane border;
	Scene display;
	Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		border = new BorderPane();
		border.setPadding(new Insets(20, 0, 20, 20));
		display = new Scene(border,1000,500);
		
		Button botonInicio = new Button("iniciar");
		botonInicio.setOnAction(e -> { 
			primaryStage.setScene(new Scene(this.cargarJuego())); });
		
		Button botonCreditos = new Button("creditos");
		botonCreditos.setOnAction(e -> { 
			primaryStage.setScene(new Scene(this.cargarCreditos(),1000,500)); });
		
		Button botonSalir = new Button("Salir");
		botonSalir.setOnAction(e -> { 
			this.salir(); });
		
		VBox botonera = new VBox();
		botonera.setAlignment(Pos.CENTER);
		botonera.setSpacing(10);
        botonera.setPadding(new Insets(0, 25, 15, 25));
		botonera.getChildren().addAll(botonInicio,botonCreditos,botonSalir);
		border.setCenter(botonera);
		
		primaryStage.setScene(display);
		primaryStage.setTitle("AlgoBlocks");
		primaryStage.setResizable(false);
		primaryStage.show();
		
		
	}

	private Parent cargarCreditos() {
		BorderPane borderCreditos = new BorderPane();
		borderCreditos.setPadding(new Insets(20, 0, 20, 20));
		Text titulo = new Text("Creditos");
		borderCreditos.setTop(titulo);
		borderCreditos.setAlignment(titulo, Pos.TOP_CENTER);
		
		
		VBox nombres = new VBox();
		Text tituloCred = new Text("Integrantes del proyecto:");
        tituloCred.setStyle("-fx-color:white;");
        Text vacio = new Text("");
        Text nombre1 = new Text("Lozano, Ramiro.");
        Text nombre2 = new Text("Sayos, Alberto.");
        Text nombre3 = new Text("Arrua, Rocio.");
        nombres.setAlignment(Pos.CENTER);
        nombres.setSpacing(10);
        nombres.setPadding(new Insets(0, 25, 15, 25));
        nombres.getChildren().addAll(tituloCred,vacio,nombre1,nombre2,nombre3);
        borderCreditos.setCenter(nombres);
        
        Button botonAtras = new Button("Atras");
        botonAtras.setOnAction(e -> { 
			primaryStage.setScene(display); });
        borderCreditos.setLeft(botonAtras);
        
		return borderCreditos;
	}

	private VBox cargarJuego() {
		Juego juego = new Juego();
		JuegoVista vistaJuego = new JuegoVista();
		ControladorDeJuego controlador = new ControladorDeJuego(juego,vistaJuego);
		vistaJuego.setControlador(controlador);      
		return vistaJuego.getEscena();
	}
	
	private void salir() {
        Platform.exit();
        System.exit(0);
    }

	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}
