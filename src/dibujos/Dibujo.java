package dibujos;

import java.util.ArrayList;

import algoritmo.Posicion;
import algoritmo.Personaje;

public class Dibujo {
	
	private ArrayList<Posicion> posiciones_tablero;
	
	public Dibujo(){
		posiciones_tablero = new ArrayList<>();
	}
	
	public void DibujarEn(Posicion posicion, Personaje personaje) {
		if(personaje.puedeEscribir()) {
			Posicion posAux = new Posicion(posicion.getColumna(),posicion.getFila());
            posiciones_tablero.add(posAux);
       }
	}
	
	public boolean estaEnBlanco() {
		return posiciones_tablero.isEmpty();
	}
	
	public void borrar(){
        	this.posiciones_tablero.clear();
    	}

	public boolean EsIgualA(Dibujo otroDibujo) {		
		return posiciones_tablero.equals(otroDibujo.posiciones_tablero);
	}

	public ArrayList<Posicion> getDibujado() {
		return posiciones_tablero;
	}
	

}
