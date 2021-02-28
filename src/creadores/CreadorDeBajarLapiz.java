package creadores;

import bloques.*;


public class CreadorDeBajarLapiz implements CreadorDeBloques{

	@Override
	public Bloque crearBloque() {
		return new BajarLapiz();
	}
	
}