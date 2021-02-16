package bloques;

import algoritmo.Personaje;
import dibujos.Dibujo;

import java.util.ArrayList;

public abstract class Repeticion implements Bloques {

    protected ArrayList<Bloques> bloques;

    public Repeticion(){
        this.bloques = new ArrayList<>();
    }

    public void agregarBloque(Bloques un_bloque){
        this.bloques.add(un_bloque);
    }

    @Override
    public void ejecutarBloque(Personaje un_personaje, Dibujo un_dibujo) {
        this.repetirBloque(un_personaje, un_dibujo);
    }

    public abstract void repetirBloque(Personaje un_personaje, Dibujo un_dibujo);
}
