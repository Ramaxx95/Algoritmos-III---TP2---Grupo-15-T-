package bloques;

import algoritmo.Personaje;
import dibujos.Dibujo;

import java.util.ArrayList;

public class InvertirComportamiento extends Contenedor{

    private ArrayList<Bloque> bloques;

    public InvertirComportamiento(){
        this.bloques = new ArrayList<>();
    }

    @Override
    public void ejecutarBloque(Personaje un_personaje, Dibujo un_dibujo) {
        this.bloques.forEach(bloque -> bloque.ejecutarBloqueInvertido(un_personaje, un_dibujo));
    }

    @Override
    public void ejecutarBloqueInvertido(Personaje un_personaje, Dibujo un_dibujo) {
        this.bloques.forEach(bloque -> bloque.ejecutarBloque(un_personaje, un_dibujo));
    }
    
    public void agregarBloque(Bloque un_bloque){
        this.bloques.add(un_bloque);
    }
}
