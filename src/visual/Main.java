package visual;
	
import java.util.ArrayList;
import java.util.Calendar;

import algoritmo.Juego;
import visual.Main;
import algoritmo.Posicion;
import algoritmo.RepresentadorAlgoritmo;
import dibujos.Dibujo;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class Main extends Application {
	
	Juego juego;

	@Override
	public void start(Stage primaryStage) {		
		VBox contenedor = this.cargarContenedor();
		
		this.juego = new Juego();
		
		

		Scene display = new Scene(contenedor);
		primaryStage.setScene(display);
		primaryStage.setTitle("Prueba de interfaz");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public VBox cargarContenedor() {
		final Circle circulo = new Circle(15,Color.BLACK);
		final GridPane tablero = new GridPane();
		Button boton = new Button("Borrar");
		VBox vbox = new VBox();
		Main.cargarBoxDibujo(tablero, boton,circulo,vbox);
		
		
		//*****Dibujo
		
		
		Button botonEjecutar = new Button("Ejecutar");
		GridPane tableroAlgoritmo = new GridPane();
		VBox boxAlgortimo = this.cargarBoxAlgoritmo(tableroAlgoritmo, botonEjecutar);
		//***********************ejecutar
		
		HBox BoxDibujoAlgoritmo = new HBox(50);
		BoxDibujoAlgoritmo.setPadding(new Insets(10));
		BoxDibujoAlgoritmo.getChildren().addAll(vbox,boxAlgortimo);
		
		//***********************ejecutar dibujo
		
		
		Text textoBloques = new Text("Bloques");
		HBox tableroBloques = new HBox();
		VBox HboxBLoque = this.cargarBoxBloques(tableroBloques, textoBloques);
		
		VBox contenedor = new VBox();
		contenedor.getChildren().addAll(BoxDibujoAlgoritmo,HboxBLoque);
		contenedor.setPadding(new Insets(10));
		
		botonEjecutar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				juego.ejecutarAlgoritmo();
				Dibujo dibujoAux = juego.mostrarDibujo();
				ArrayList<Posicion> posiciones_tablero = dibujoAux.getDibujado();
				
				for(int i = 0; i<posiciones_tablero.size();i++ ) {
					
					Posicion posAux = posiciones_tablero.get(i);
					System.out.println( posAux.getColumna() );
					System.out.println( posAux.getFila() );
					
					final Circle circuloAux = new Circle(5,Color.BLUE);
					GridPane.setHalignment(circuloAux, HPos.CENTER);
					
					int columna = GridPane.getColumnIndex(circulo);
					int fila = GridPane.getRowIndex(circulo);
					tablero.add(circuloAux, columna, fila);
					
					int filaX = 5 - posAux.getColumna();
					int columnaFinal = 5 + filaX;
					System.out.println( columnaFinal );
					
					GridPane.setColumnIndex(circulo, posAux.getFila() );
					GridPane.setRowIndex(circulo, columnaFinal );
					
				}
			}
			
		});
		
		
		boton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				tablero.getChildren().clear();
				juego.borrarDibujo();
				//Main.cargarBoxDibujo(tablero,boton,circulo,vbox);
				Main.cargarTableroDibujo(tablero, circulo);
			}
			
		});
		
		//***********actualizar flame
		Calendar calendario = Calendar.getInstance();
		
		Timeline lineaTiempo = new Timeline();
		Timeline segundaLineaDeTiempo = new Timeline();
				
		segundaLineaDeTiempo.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame keyPrimario = new KeyFrame(
				new Duration(1000 - calendario.get(Calendar.MILLISECOND)%1000 ),
				(event) -> {
					this.actualizarBoxAlgoritmo(tableroAlgoritmo);
					segundaLineaDeTiempo.play();
				}
				);
		KeyFrame keySecundario = new KeyFrame(
				Duration.seconds(1),
				(event) -> {
					this.actualizarBoxAlgoritmo(tableroAlgoritmo);
				}
		);
		lineaTiempo.getKeyFrames().add(keyPrimario);
		segundaLineaDeTiempo.getKeyFrames().add(keySecundario);
		
		lineaTiempo.play();
		
		return contenedor;
	}
	
	public static void cargarBoxDibujo(GridPane tablero,Button boton, Circle circulo, VBox vbox ) {
		Main.cargarTableroDibujo(tablero,circulo);
		
		HBox boxDibujar = new HBox(10);
		Text textDibujo = new Text("dibujo");
		boxDibujar.getChildren().addAll(textDibujo,boton);
		
		vbox.getChildren().addAll(boxDibujar,tablero);
	}
	
	public static void cargarTableroDibujo(GridPane tablero, Circle circulo) {
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				tablero.add(new Rectangle(50,50,Color.BEIGE),i,j);
			}
		}
		//tablero.setGridLinesVisible(true);
		circulo.setEffect(new Lighting());
		tablero.add(circulo,5,5);
		GridPane.setHalignment(circulo, HPos.CENTER);
	}
	
	public VBox cargarBoxAlgoritmo(GridPane tableroAlgoritmo,Button botonEjecutar) {
		VBox boxAlgoritmo = new VBox();
		
		HBox boxAlgoritmoHorizontal = new HBox(10);
		Text textAlgoritmo = new Text("Algoritmo");
		boxAlgoritmoHorizontal.getChildren().addAll(textAlgoritmo,botonEjecutar);
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				tableroAlgoritmo.add(new Rectangle(50,50,Color.BEIGE),i,j);
			}
		}
		
		boxAlgoritmo.getChildren().addAll(boxAlgoritmoHorizontal,tableroAlgoritmo);
		
		return boxAlgoritmo;
	}
	
	public VBox cargarBoxBloques(HBox tableroBloques ,Text textoBloques) {
		VBox HboxBLoque = new VBox();
		Button subir = new Button("Subir");
		subir.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				juego.seleccionarBloque(0);
				
			}
			
		});
		Button bajar = new Button("Bajar");
		bajar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				juego.seleccionarBloque(1);
			}
			
		});
		Button derecha = new Button("Derecha");
		derecha.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				juego.seleccionarBloque(2);
			}
			
		});
		Button izquierda = new Button("izquierda");
		izquierda.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				juego.seleccionarBloque(3);
			}
			
		});
		Button subirLapiz = new Button("Subir Lapiz");
		subirLapiz.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				juego.seleccionarBloque(4);
			}
			
		});
		Button bajarLapiz = new Button("Bajar Lapiz");
		bajarLapiz.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				juego.seleccionarBloque(5);
			}
			
		});
		Button repeticionX2 = new Button("Repetir dos veces");
		repeticionX2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				juego.seleccionarBloque(6);
			}
			
		});
		Button repeticionX3 = new Button("Repetir tres veces");
		repeticionX3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				juego.seleccionarBloque(7);
			}
			
		});
				
		tableroBloques.getChildren().addAll(subir,bajar,derecha,izquierda,subirLapiz,bajarLapiz,repeticionX2,repeticionX3);
		HboxBLoque.getChildren().addAll(textoBloques,tableroBloques );
		return HboxBLoque;
	}
	
	public void actualizarBoxAlgoritmo(GridPane tableroAlgoritmo) {
		RepresentadorAlgoritmo representador = new RepresentadorAlgoritmo();
		tableroAlgoritmo.getChildren().clear();
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				tableroAlgoritmo.add(new Rectangle(50,50,Color.BEIGE),i,j);
			}
		}
		ArrayList<String> ubicaciones = representador.representar(juego);
		
		for(int i = 0; i < ubicaciones.size(); i++) {
			Text textAux = new Text(ubicaciones.get(i));
			tableroAlgoritmo.add(textAux, 0, i);
		}
	}
	
	
}	