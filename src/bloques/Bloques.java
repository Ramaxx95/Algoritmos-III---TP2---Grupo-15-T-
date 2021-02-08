package bloques;

import algoritmo.Personaje;

public interface Bloques {

    public void ejecutarBloque(Personaje un_personaje, Dibujo un_dibujo);{
        //falta validar si el lapiz está abajo o arriba, lo hacemos en Dibujo
        un_dibujo.DibujarEn(un_personaje.getPosicion());
    }        
}
