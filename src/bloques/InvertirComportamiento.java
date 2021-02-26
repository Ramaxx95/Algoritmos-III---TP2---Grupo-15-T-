package bloques;

import algoritmo.Personaje;
import dibujos.Dibujo;

import java.util.ArrayList;

public class InvertirComportamiento implements Bloques{

    private ArrayList<Bloques> bloques;

    public InvertirComportamiento(){
        this.bloques = new ArrayList<>();
    }

    public void agregarBloque(Bloques un_bloque){
        this.bloques.add(un_bloque);
    }

    @Override
    public void ejecutarBloque(Personaje un_personaje, Dibujo un_dibujo) {
        this.bloques.forEach(bloque -> bloque.ejecutarBloqueInvertido(un_personaje, un_dibujo));
    }

    @Override
    public void ejecutarBloqueInvertido(Personaje un_personaje, Dibujo un_dibujo) {
        this.bloques.forEach(bloque -> bloque.ejecutarBloque(un_personaje, un_dibujo));
    }

	@Override
	public String ubicacion() {
		// TODO Esbozo de método generado automáticamente
		return "invertir";
	}
}
