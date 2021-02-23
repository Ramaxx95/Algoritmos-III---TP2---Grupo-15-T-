package bloques;

import algoritmo.Escritura;
import algoritmo.Personaje;
import dibujos.Dibujo;

public class BajarLapiz extends Escritura{
	
	 @Override
	 public void ejecutarBloque(Personaje un_personaje, Dibujo un_dibujo) {
		 this.moverLapiz(un_personaje);
		 un_dibujo.DibujarEn(un_personaje.getPosicion(), un_personaje);
	}
	
    @Override
    public void moverLapiz(Personaje un_personaje) {
        un_personaje.bajarLapiz();
    }

	@Override
	public String ubicacion() {
		// TODO Esbozo de método generado automáticamente
		return "bajar lapiz";
	}

}
