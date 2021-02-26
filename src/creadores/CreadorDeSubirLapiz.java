package creadores;

import bloques.*;


public class CreadorDeSubirLapiz implements CreadorDeBloques{

	@Override
	public Bloques crearBloque() {
		return new SubirLapiz();
	}
	
}