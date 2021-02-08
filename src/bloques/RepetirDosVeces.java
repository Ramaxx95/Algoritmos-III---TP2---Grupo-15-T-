package bloques;

import java.util.Iterator;

import algoritmo.Personaje;

public class RepetirDosVeces extends Repeticion{

    @Override
    public void repetirBloque(Personaje un_personaje) {
    	/*
    	//int cantidad = bloques.size();
    	
        for (int i = 0; i < 2; i++){
        	
        	for(int x = 0; x < cantidad; x++) {
        		
        		System.out.print(x);
        		
        		Bloques bloque = bloques.get(x);
        		
        		bloque.ejecutarBloque(un_personaje);
        		
        	}
        	//bloques.forEach(bloques -> bloques.ejecutarBloque(un_personaje));
        	
            //bloque.ejecutarBloque(un_personaje);
        }
        
    	Iterator iterador = bloques.iterator();
    	while(iterador.hasNext()) {
    		System.out.print("x");
    		Bloques bloque = (Bloques) iterador.next();
    		bloque.ejecutarBloque(un_personaje);
    	}
    	
    	*/
    	
    	for (int i = 0; i < 2; i++){
    		bloque.ejecutarBloque(un_personaje);
    	}
        
    }

}
