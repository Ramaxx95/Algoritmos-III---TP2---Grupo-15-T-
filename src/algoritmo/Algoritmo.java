package algoritmo;

import java.util.ArrayList;

import bloques.Bloques;
import dibujos.Dibujo;

public class Algoritmo {

    private ArrayList<Bloques> listaAlgoritmo;

    public Algoritmo(){
        this.listaAlgoritmo = new ArrayList<>();
    }
    
    public ArrayList<Bloques> getAlgoritmo(){
        return this.listaAlgoritmo;
    }

    public void agregarBloque(Bloques un_bloque){
        this.listaAlgoritmo.add(un_bloque);
    }
    
    public void borrarBloques(){
        this.listaAlgoritmo.clear();
    }

    public void ejecutar(Personaje un_personaje, Dibujo un_dibujo){
        this.listaAlgoritmo.forEach(bloques -> bloques.ejecutarBloque(un_personaje, un_dibujo));
    }
}
