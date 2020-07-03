package examen2.miguelrojas;

import java.io.Serializable;

public class Parte implements Serializable{
    
    private int tiempo_ensamblaje;
    private final static long SerialVersionUID = 77l;

    public Parte(int tiempo_ensamblaje) {
        this.tiempo_ensamblaje = tiempo_ensamblaje;
    }

    public int getTiempo_ensamblaje() {
        return tiempo_ensamblaje;
    }

    public void setTiempo_ensamblaje(int tiempo_ensamblaje) {
        this.tiempo_ensamblaje = tiempo_ensamblaje;
    }
    
    
    
}
