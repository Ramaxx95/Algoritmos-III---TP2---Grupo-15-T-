package algoritmo;

import java.util.ArrayList;

public class Algoritmo {

    private ArrayList<Bloques> listaAlgoritmo;

    public Algoritmo(){
        this.listaAlgoritmo = new ArrayList<Bloques>();
    }

    public void agregarBloque(Bloques un_bloque){
        this.listaAlgoritmo.add(un_bloque);
    }

    public void ejecutar(Personaje un_personaje){
        Bloques bloque;
        for (int i = 0; i < this.listaAlgoritmo.size(); i++){
            bloque = this.listaAlgoritmo.get(i);
            bloque.ejecutarBloque(un_personaje);
        }
    }
}
