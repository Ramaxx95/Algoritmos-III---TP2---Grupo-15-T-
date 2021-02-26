package creadores;

import bloques.*;


public class CreadorDeBajarLapiz implements CreadorDeBloques{

	@Override
	public Bloques crearBloque() {
		return new BajarLapiz();
	}
	
}