package bloques;

import java.util.ArrayList;
import java.util.Arrays;

import algoritmo.*;

public class SectorBloques{
    
    private static ArrayList<Bloques> bloques;

    public SectorBloques(){
        //this.bloques = new ArrayList<>();
    	bloques = new ArrayList<Bloques>(Arrays.asList( 
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

    public Bloques seleccionarBloque(int posicion){
        return bloques.get(posicion);
    }
}