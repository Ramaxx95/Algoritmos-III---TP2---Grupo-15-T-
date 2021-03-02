package creadores;

import algoritmo.Algoritmo;
import bloques.AlgoritmoPersonalizado;
import bloques.Bloque;
import excepciones.NoHayAlgoritmoGuardadoException;

import java.util.ArrayList;

public class CreadorDeAlgoritmoPersonalizado implements CreadorDeBloques{

    private AlgoritmoPersonalizado bloque;

    public CreadorDeAlgoritmoPersonalizado(ArrayList<Bloque> algoritmo) throws NoHayAlgoritmoGuardadoException{
        this.bloque = new AlgoritmoPersonalizado(algoritmo);
    }

    @Override
    public Bloque crearBloque(){
        return this.bloque;
    }
}
