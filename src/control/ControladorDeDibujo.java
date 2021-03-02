package control;

import java.util.ArrayList;

import algoritmo.Posicion;
import dibujos.Dibujo;
import visual.DibujoVista;

public class ControladorDeDibujo {
	
	DibujoVista vistaDibujo;
	
	public ControladorDeDibujo(DibujoVista unDibujoVista) {
		vistaDibujo = unDibujoVista;
	}

	public void dibujarCon(Dibujo dibujo) {
		ArrayList<Posicion> posiciones_tablero = dibujo.getDibujado();
		for(int i = 0; i<posiciones_tablero.size();i++ ) {
			Posicion posActual = posiciones_tablero.get(i);
			vistaDibujo.marcarPunto(posActual);
			if(dibujo.estaUnida(posActual)) {
				Posicion posAux = dibujo.buscarUnion(posActual);
				vistaDibujo.dibujarLinea(posActual,posAux);
			}
			
		}
	}
	
}
