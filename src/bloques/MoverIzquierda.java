package bloques;

import dibujos.Dibujo;
import algoritmo.Personaje;

public class MoverIzquierda extends Movimiento{

    @Override
    public void moverPersonaje(Personaje un_personaje) {
        un_personaje.moverseA(-1, 0);
    }
	
    @Override
    public void ejecutarBloqueInvertido(Personaje un_personaje, Dibujo un_dibujo) {
        MoverDerecha bloque_invertido = new MoverDerecha();
        bloque_invertido.ejecutarBloque(un_personaje, un_dibujo);
    }


}
