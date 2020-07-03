package examen2.miguelrojas;

public class Tecnico {
    
    private String nombre_tecnico;
    private int edad_tecnico;
    private String genero;
    private int cant_computadorasEnsambladas = 0;

    
    public Tecnico(String nombre_tecnico, int edad_tecnico, String genero) {
        this.nombre_tecnico = nombre_tecnico;
        this.edad_tecnico = edad_tecnico;
        this.genero = genero;
    }
    
    public Tecnico(String nombre_tecnico, int edad_tecnico, String genero, int cantidad_compus) {
        this.nombre_tecnico = nombre_tecnico;
        this.edad_tecnico = edad_tecnico;
        this.genero = genero;
        this.cant_computadorasEnsambladas = cantidad_compus;
    }

    public String getNombre_tecnico() {
        return nombre_tecnico;
    }

    public void setNombre_tecnico(String nmbre_tecnico) {
        this.nombre_tecnico = nmbre_tecnico;
    }

    public int getEdad_tecnico() {
        return edad_tecnico;
    }

    public void setEdad_tecnico(int edad_tecnico) {
        this.edad_tecnico = edad_tecnico;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCant_computadorasEnsambladas() {
        return cant_computadorasEnsambladas;
    }

    public void setCant_computadorasEnsambladas(int cant_computadorasEnsambladas) {
        this.cant_computadorasEnsambladas = cant_computadorasEnsambladas;
    }

    @Override
    public String toString() {
        return nombre_tecnico;
    }
    
    
}
