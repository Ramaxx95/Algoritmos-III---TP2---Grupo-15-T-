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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
		Image titulo = new Image("File:src/img/titulo.png");
		ImageView imgTitulo = new ImageView(titulo);
		border.setTop(imgTitulo);
		border.setAlignment(imgTitulo, Pos.CENTER);
		border.setPadding(new Insets(20, 0, 20, 20));
		display = new Scene(border,500,400);
		
		Button botonInicio = new Button("iniciar");
		botonInicio.setPrefSize(100, 40);
		botonInicio.setOnAction(e -> {this.cargarJuego(); });
		
		Button botonCreditos = new Button("creditos");
		botonCreditos.setPrefSize(100, 40);
		botonCreditos.setOnAction(e -> { this.cargarCreditos(); });
		
		Button botonSalir = new Button("Salir");
		botonSalir.setPrefSize(100, 40);
		botonSalir.setOnAction(e -> { 
			this.salir(); });
		
		VBox botonera = new VBox();
		botonera.setAlignment(Pos.CENTER);
		botonera.setSpacing(10);
        botonera.setPadding(new Insets(0, 25, 15, 25));
		botonera.getChildren().addAll(botonInicio,botonCreditos,botonSalir);
		border.setCenter(botonera);
		
		primaryStage.setScene(display);
		primaryStage.getScene().getStylesheets().add( getClass().getResource("colores.css").toExternalForm());
		primaryStage.setTitle("AlgoBlocks");
		primaryStage.getIcons().add(new Image("File:src/img/personaje.png"));
		primaryStage.setResizable(false);
		primaryStage.show();
		
		
	}

	private Parent cargarCreditos() {
		
		BorderPane borderCreditos = new BorderPane();
		borderCreditos.setPadding(new Insets(20, 0, 20, 20));
		Text titulo = new Text("Creditos");
		titulo.setScaleX(3);
		titulo.setScaleY(3);
		borderCreditos.setTop(titulo);
		borderCreditos.setAlignment(titulo, Pos.TOP_CENTER);
		
		
		VBox nombres = new VBox();
		Text tituloCred = new Text("Integrantes del proyecto:");
		tituloCred.setScaleX(2);
		tituloCred.setScaleY(2);
        tituloCred.setStyle("-fx-color:white;");
        Text vacio = new Text("");
        Text nombre1 = new Text("Lozano, Ramiro.");
        nombre1.setScaleX(1);
        nombre1.setScaleY(1);
        Text nombre2 = new Text("Sayos, Alberto.");
        nombre2.setScaleX(1);
        nombre2.setScaleY(1);
        Text nombre3 = new Text("Arrua, Rocio.");
        nombre3.setScaleX(1);
        nombre3.setScaleY(1);
        nombres.setAlignment(Pos.CENTER);
        nombres.setSpacing(10);
        nombres.setPadding(new Insets(0, 25, 15, 25));
        nombres.getChildren().addAll(tituloCred,vacio,nombre1,nombre2,nombre3);
        borderCreditos.setCenter(nombres);
        
        Button botonAtras = new Button("Atras");
        botonAtras.setScaleY(0.7);
        botonAtras.setScaleX(0.7);
        botonAtras.setTranslateY(250);
        botonAtras.setOnAction(e -> { 
        	primaryStage.setScene(display); });
        borderCreditos.setLeft(botonAtras);
        
        Scene display2 = new Scene(borderCreditos,500,400);
        primaryStage.setScene(display2);
        primaryStage.getScene().getStylesheets().add( getClass().getResource("colores.css").toExternalForm());
		return borderCreditos;
	}

	private VBox cargarJuego() {
		Juego juego = new Juego();
		JuegoVista vistaJuego = new JuegoVista();
		ControladorDeJuego controlador = new ControladorDeJuego(juego,vistaJuego);
		vistaJuego.setControlador(controlador);
		Scene display3 = new Scene(vistaJuego.getEscena(),1280,800);
        primaryStage.setScene(display3);
        primaryStage.getScene().getStylesheets().add( getClass().getResource("colores.css").toExternalForm());
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
