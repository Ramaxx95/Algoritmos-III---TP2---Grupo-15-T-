package algoritmo;

import java.util.ArrayList;

import bloques.Bloque;
import dibujos.Dibujo;

public class Algoritmo {

    private ArrayList<Bloque> listaAlgoritmo;

    public Algoritmo(){
        this.listaAlgoritmo = new ArrayList<>();
    }
    
    public ArrayList<Bloque> getAlgoritmo(){
        return this.listaAlgoritmo;
    }

    public void agregarBloque(Bloque un_bloque){
        this.listaAlgoritmo.add(un_bloque);
    }
    
    public void borrarBloques(){
        this.listaAlgoritmo.clear();
    }

    public void ejecutar(Personaje un_personaje, Dibujo un_dibujo){
        this.listaAlgoritmo.forEach(bloques -> bloques.ejecutarBloque(un_personaje, un_dibujo));
    }
}
