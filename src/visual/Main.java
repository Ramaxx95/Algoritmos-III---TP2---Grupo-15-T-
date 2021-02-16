package visual;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
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
	@Override
	public void start(Stage primaryStage) {		
		GridPane tablero = new GridPane();
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				tablero.add(new Rectangle(50,50,Color.BEIGE),i,j);
			}
		}
		
		VBox vbox = new VBox();
		
		HBox boxDibujar = new HBox(10);
		Button boton = new Button("Borrar");
		Text textDibujo = new Text("dibujo");
		boxDibujar.getChildren().addAll(textDibujo,boton);
		
		vbox.getChildren().addAll(boxDibujar,tablero);
		
		VBox boxAlgortimo = new VBox();
		
		HBox boxAlgoritmo = new HBox(10);
		Button botonEjecutar = new Button("Ejecutar");
		Text textAlgoritmo = new Text("Algoritmo");
		boxAlgoritmo.getChildren().addAll(textAlgoritmo,botonEjecutar);
		
		GridPane tableroAlgoritmo = new GridPane();
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				tableroAlgoritmo.add(new Rectangle(50,50,Color.BEIGE),i,j);
			}
		}
		
		boxAlgortimo.getChildren().addAll(boxAlgoritmo,tableroAlgoritmo);
		
		HBox BoxDibujoAlgoritmo = new HBox(50);
		BoxDibujoAlgoritmo.setPadding(new Insets(10));
		BoxDibujoAlgoritmo.getChildren().addAll(vbox,boxAlgortimo);
		
		
		VBox contenedor = new VBox();
		
		VBox HboxBLoque = new VBox();
		Text textoBloques = new Text("Bloques");
		GridPane tableroBloques = new GridPane();
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 1; j++) {
				tableroBloques.add(new Rectangle(50,50,Color.RED),i,j);
			}
		}
		tableroBloques.setHgap(5);//espacio
		
		HboxBLoque.getChildren().addAll(textoBloques,tableroBloques );
		
		
		contenedor.getChildren().addAll(BoxDibujoAlgoritmo,HboxBLoque);
		contenedor.setPadding(new Insets(10));
		
		Scene display = new Scene(contenedor);
		primaryStage.setScene(display);
		primaryStage.setTitle("interfaz basica");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
