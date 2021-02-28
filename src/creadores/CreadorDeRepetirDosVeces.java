package creadores;

import bloques.*;


public class CreadorDeRepetirDosVeces implements CreadorDeBloques{

	@Override
	public Bloque crearBloque() {
		return new RepetirDosVeces();
	}
	
}