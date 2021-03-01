package bloques;

import algoritmo.Algoritmo;
import algoritmo.Personaje;
import dibujos.Dibujo;
import excepciones.*;
import java.util.ArrayList;

public class AlgoritmoPersonalizado implements Bloque{

    private ArrayList<Bloque> algoritmo;

    public AlgoritmoPersonalizado(){

        this.algoritmo = new ArrayList<>();

    }
	
    public AlgoritmoPersonalizado(Algoritmo algoritmoAGuardar) throws NoHayAlgoritmoGuardadoException{

        this.algoritmo = new ArrayList<>();
        this.agregarAlgoritmo(algoritmoAGuardar);

    }
	
    public void agregarAlgoritmo(Algoritmo algoritmoAGuardar) throws NoHayAlgoritmoGuardadoException{
        if (algoritmoAGuardar.getAlgoritmo().size() == 0){
            throw new NoHayAlgoritmoGuardadoException();
        }
        algoritmoAGuardar.getAlgoritmo().forEach(bloque -> this.algoritmo.add(bloque));
    }

    @Override
    public void ejecutarBloque(Personaje un_personaje, Dibujo un_dibujo) {
        this.algoritmo.forEach(bloques -> bloques.ejecutarBloque(un_personaje, un_dibujo));
    }
	
    @Override
    public void ejecutarBloqueInvertido(Personaje un_personaje, Dibujo un_dibujo) {
        this.algoritmo.forEach(bloque -> bloque.ejecutarBloqueInvertido(un_personaje, un_dibujo));
    }
}
