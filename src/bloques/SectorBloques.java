package bloques;

import java.util.ArrayList;
import java.util.Arrays;

import algoritmo.*;

public class SectorBloques{
    
    private static ArrayList<Bloque> bloques;

    public SectorBloques(){
        //this.bloques = new ArrayList<>();
    	bloques = new ArrayList<Bloque>(Arrays.asList( 
    			new MoverArriba(),//0
    			new MoverAbajo(),
    			new MoverDerecha(),
    			new MoverIzquierda(),//3
    			new SubirLapiz(),
    			new BajarLapiz(),
    			new RepetirDosVeces(),
    			new RepetirTresVeces() //7
    			) 
    			);
    }

    public Bloque seleccionarBloque(int posicion){
        return bloques.get(posicion);
    }
}