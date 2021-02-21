package bloques;

import algoritmo.Personaje;

public interface Bloques {

    public void ejecutarBloque(Personaje un_personaje, Dibujo un_dibujo);{
        un_dibujo.DibujarEn(un_personaje.getPosicion());
    }        
}
