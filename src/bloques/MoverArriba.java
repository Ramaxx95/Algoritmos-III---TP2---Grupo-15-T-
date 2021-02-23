package bloques;

import dibujos.Dibujo;
import algoritmo.Personaje;

public class MoverArriba extends Movimiento{

    @Override
    public void moverPersonaje(Personaje un_personaje) {
        un_personaje.moverseA(0, 1);
    }
	
    @Override
    public void ejecutarBloqueInvertido(Personaje un_personaje, Dibujo un_dibujo) {
        MoverAbajo bloque_invertido = new MoverAbajo();
        bloque_invertido.ejecutarBloque(un_personaje, un_dibujo);
    }

	@Override
	public String ubicacion() {
		// TODO Esbozo de método generado automáticamente
		return "mover arriba";
	}

}
