package creadores;

import bloques.*;


public class CreadorDeRepetirDosVeces implements CreadorDeBloques{

	@Override
	public Bloques crearBloque() {
		return new RepetirDosVeces();
	}
	
}