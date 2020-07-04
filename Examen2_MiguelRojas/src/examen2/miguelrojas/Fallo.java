package examen2.miguelrojas;

public class Fallo {

    private String nombre_computadora;
    private String nombre_tecnico;

    public Fallo(String nombre_computadora, String nombre_tecnico) {
        this.nombre_computadora = nombre_computadora;
        this.nombre_tecnico = nombre_tecnico;
    }

    public String getNombre_computadora() {
        return nombre_computadora;
    }

    public void setNombre_computadora(String nombre_computadora) {
        this.nombre_computadora = nombre_computadora;
    }

    public String getNombre_tecnico() {
        return nombre_tecnico;
    }

    public void setNombre_tecnico(String nombre_tecnico) {
        this.nombre_tecnico = nombre_tecnico;
    }

    @Override
    public String toString() {
        return nombre_computadora + ","+ nombre_tecnico;
    }
    
    
}
