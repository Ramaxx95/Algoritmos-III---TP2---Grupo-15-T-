package control;


import creadores.CreadorDeBloques;

public abstract class ControladorDeGuardado {
	
	public abstract void finalizarContenedor();
	protected abstract void guardarBloque(CreadorDeBloques creadorDeBloques, String img);
	protected abstract void guardarBloqueContenedor(CreadorDeBloques creadorDeBloques, String img);
}