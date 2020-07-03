package examen2.miguelrojas;

public class Pantalla extends Parte{


    private String tactilidad;
    private String tipo;

    public Pantalla(String tactilidad, String tipo, int tiempo_ensamblaje) {
        super(tiempo_ensamblaje);
        this.tactilidad = tactilidad;
        this.tipo = tipo;
    }

    

    public String getTactilidad() {
        return tactilidad;
    }

    public void setTactilidad(String tactilidad) {
        this.tactilidad = tactilidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
