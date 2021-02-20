package dibujos;

import algoritmo.Personaje;
import algoritmo.Posicion;

public class SectorDibujo{
	
	Dibujo dibujo;
	
	public SectorDibujo() {
		dibujo = new Dibujo();
	}
	
	public void borrarDibujo(){
        	this.dibujo.borrar();
    	}
	
	public boolean PuedeDibujar() {
		return this.dibujo.estaEnBlanco();
	}

	public void ActualizarPosicion(Personaje personaje) {
		int nueva_columna = personaje.getPosicion().getColumna();
        	int nueva_fila = personaje.getPosicion().getFila();
        	Posicion posAux = new Posicion(nueva_columna, nueva_fila);
        	dibujo.DibujarEn(posAux, personaje);
	}
	
	public Dibujo getDibujo(){
		return dibujo;
	}
	
	
}
