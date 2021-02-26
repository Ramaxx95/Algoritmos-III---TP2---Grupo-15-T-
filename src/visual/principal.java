package visual;

import algoritmo.Juego;
import control.ControladorDeJuego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class principal extends Application {

	@Override
	public void start(Stage primaryStage) {
		Juego juego = new Juego();
		JuegoVista vistaJuego = new JuegoVista();
		ControladorDeJuego controlador = new ControladorDeJuego(juego,vistaJuego);
		vistaJuego.setControlador(controlador);
		
		VBox contenedor = vistaJuego.getEscena();
		Scene display = new Scene(contenedor);
		primaryStage.setScene(display);
		primaryStage.setTitle("AlgoBlocks");
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
