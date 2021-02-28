package creadores;

import bloques.*;


public class CreadorDeSubirLapiz implements CreadorDeBloques{

	@Override
	public Bloque crearBloque() {
		return new SubirLapiz();
	}
	
}