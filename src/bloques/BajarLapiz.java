package bloques;


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
    public void ejecutarBloqueInvertido(Personaje un_personaje, Dibujo un_dibujo) {
        SubirLapiz bloque_invertido = new SubirLapiz();
        bloque_invertido.ejecutarBloque(un_personaje, un_dibujo);
    }


}
