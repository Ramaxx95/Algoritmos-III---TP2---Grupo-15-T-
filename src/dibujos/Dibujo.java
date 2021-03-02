package dibujos;

import java.util.ArrayList;
import java.util.HashMap;

import algoritmo.Posicion;
import algoritmo.Personaje;

public class Dibujo {
	
	private ArrayList<Posicion> posiciones_tablero;
	private HashMap<Posicion,Posicion> unidas;
	
	public Dibujo(){
		posiciones_tablero = new ArrayList<>();
		unidas = new HashMap<>();
	}
	
	public void DibujarEn(Posicion posicionAnterior, Personaje personaje) {
		if(personaje.puedeEscribir()) {
			Posicion posAux = new Posicion(posicionAnterior.getColumna(),posicionAnterior.getFila());
			Posicion posDePersonaje = new Posicion(personaje.getPosicion().getColumna(),personaje.getPosicion().getFila());
            posiciones_tablero.add(posDePersonaje);
            unidas.put(posDePersonaje, posAux);
       }
	}
	
	public boolean estaEnBlanco() {
		return posiciones_tablero.isEmpty();
	}
	
	public void borrar(){
        	this.posiciones_tablero.clear();
        	this.unidas.clear();
    	}

	public boolean EsIgualA(Dibujo otroDibujo) {		
		return posiciones_tablero.equals(otroDibujo.posiciones_tablero);
	}

	public ArrayList<Posicion> getDibujado() {
		return posiciones_tablero;
	}

	public boolean estaUnida(Posicion posAux) {
		return unidas.containsKey(posAux);
	}

	public Posicion buscarUnion(Posicion posActual) {
		return unidas.get(posActual);
	}
	

}
