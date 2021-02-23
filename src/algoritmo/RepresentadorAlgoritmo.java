package algoritmo;

import bloques.*;

import java.util.ArrayList;

public class RepresentadorAlgoritmo {
	
	private ArrayList<String> ubicaciones;

    public RepresentadorAlgoritmo(){
    	this.ubicaciones = new ArrayList<>();
    }
    
    public ArrayList<String> representar(Juego juego ){
    	
    	Algoritmo algoritmo = juego.pasarAlgoritmo();
    	ArrayList<Bloques> listaDeBloques = algoritmo.getAlgoritmo();
    	for(int i = 0; i < listaDeBloques.size();i++) {
    		String Aux = listaDeBloques.get(i).ubicacion();
    		ubicaciones.add(Aux);
    	}
    	
		return ubicaciones;
    	
    }
    
    /*
	private String representarBloque(MoverArriba moverArriba) {
		return "Bloque arriba";
	}
    
	private String representarBloque(MoverAbajo moverAbajo) {
		return "Bloque Abajo";
	}
	
	private String representarBloque(MoverDerecha moverderecha) {
		return "Bloque derecha";
	}
	
	private String representarBloque(MoverIzquierda moverIzquierda) {
		return "Bloque izquierda";
	}
	
	private String representarBloque(SubirLapiz subirLapiz) {
		return "Bloque subir Lapiz";
	}
	
	private String representarBloque(BajarLapiz bajarLapiz) {
		return "Bloque bajar lapiz";
	}
    */
    
}
