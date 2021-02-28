package bloques;

import algoritmo.Personaje;
import dibujos.Dibujo;

import java.util.ArrayList;

public abstract class Repeticion extends Contenedor {

    protected ArrayList<Bloque> bloques;

    public Repeticion(){
        this.bloques = new ArrayList<>();
    }

    @Override
    public void ejecutarBloque(Personaje un_personaje, Dibujo un_dibujo) {
        this.repetirBloque(un_personaje, un_dibujo);
    }
    
    public void agregarBloque(Bloque un_bloque){
        this.bloques.add(un_bloque);
    }

    public abstract void repetirBloque(Personaje un_personaje, Dibujo un_dibujo);
}
