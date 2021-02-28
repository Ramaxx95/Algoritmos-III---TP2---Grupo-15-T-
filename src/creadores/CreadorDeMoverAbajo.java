package creadores;

import bloques.*;


public class CreadorDeMoverAbajo implements CreadorDeBloques{

	@Override
	public Bloque crearBloque() {
		return new MoverAbajo();
	}
	
}