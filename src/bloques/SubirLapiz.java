package bloques;

import dibujos.Dibujo;
import algoritmo.Personaje;

public class SubirLapiz extends Escritura{

    @Override
    public void moverLapiz(Personaje un_personaje) {
        un_personaje.levantarLapiz();
    }

    @Override
    public void ejecutarBloqueInvertido(Personaje un_personaje, Dibujo un_dibujo) {
        BajarLapiz bloque_invertido = new BajarLapiz();
        bloque_invertido.ejecutarBloque(un_personaje, un_dibujo);
    }
	
	@Override
	public String ubicacion() {
		// TODO Esbozo de método generado automáticamente
		return "Subir lapiz";
	}

}
