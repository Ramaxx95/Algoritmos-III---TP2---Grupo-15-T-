package bloques;

import algoritmo.algoritmo;

public class SectorBloques{
    
    private ArrayList<Bloques> bloques;

    public SectorBloques(){
        this.bloques = new ArrayList<>();
    }

    public Bloques seleccionarBloque(Bloques un_bloque){
        Bloques bloque = this.buscarBloque(un_bloque);
        return bloque;
    }

    public void agregarBloque(Algoritmo sector_algoritmo){
        //agregar bloque al sector algoritmo
        sector_algoritmo.agregarBloque(bloques);
    }
    
    //Falta implementar método buscarBloque para buscar bloque dentro
    //de la lista de bloques del sector
}