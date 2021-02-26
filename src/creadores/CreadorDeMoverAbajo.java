package creadores;

import bloques.*;


public class CreadorDeMoverAbajo implements CreadorDeBloques{

	@Override
	public Bloques crearBloque() {
		return new MoverAbajo();
	}
	
}