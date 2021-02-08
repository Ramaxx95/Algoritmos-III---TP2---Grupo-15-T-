package dibujos;

import algoritmo.Personaje;
import algoritmo.Posicion;
import bloques.MoverArriba;

public class SectorDibujo{
	
	Dibujo dibujo;
	
	public SectorDibujo() {
		dibujo = new Dibujo();
		dibujo.DibujarEn(new Posicion(5,5));
	}
	

	public boolean PuedeDibujar() {
		return true;
	}

	public void ActualizarPosicion(Personaje personaje) {
		Posicion posAux = personaje.getPosicion();
		dibujo.DibujarEn(posAux);
	}
	
	public Dibujo getDibujo(){
		return dibujo;
	}
	
	
}