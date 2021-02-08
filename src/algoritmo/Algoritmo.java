package algoritmo;

import java.util.ArrayList;

import bloques.Bloques;

public class Algoritmo {

    private ArrayList<Bloques> listaAlgoritmo;

    public Algoritmo(){
        this.listaAlgoritmo = new ArrayList<>();
    }

    public void agregarBloque(Bloques un_bloque){
        this.listaAlgoritmo.add(un_bloque);
    }

    public void ejecutar(Personaje un_personaje){
        this.listaAlgoritmo.forEach(bloques -> bloques.ejecutarBloque(un_personaje));
    }
}
