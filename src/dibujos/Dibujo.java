package dibujos;

import java.util.ArrayList;

import algoritmo.Posicion;
import bloques.Bloques;

public class Dibujo {
	
	private ArrayList<Posicion> Posiciones;
	
	public Dibujo(){
		Posiciones = new ArrayList<>();
	}
	
	public void DibujarEn(Posicion posicion) {
		Posiciones.add(posicion);
	}
	
	public boolean estaEnBlanco() {
		return Posiciones.isEmpty();
	}

	public boolean EsIgualA(Dibujo otroDibujo) {
		return Posiciones.equals(otroDibujo.Posiciones);
	}
	

}
