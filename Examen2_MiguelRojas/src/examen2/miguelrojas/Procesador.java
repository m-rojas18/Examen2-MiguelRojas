package examen2.miguelrojas;

public class Procesador extends Parte{
    private int numero_nucleos;
    private double velocidad;

    public Procesador(int numero_nucleos, double velocidad, int tiempo_ensamblaje) {
        super(tiempo_ensamblaje);
        this.numero_nucleos = numero_nucleos;
        this.velocidad = velocidad;
    }

    

    public int getNumero_nucleos() {
        return numero_nucleos;
    }

    public void setNumero_nucleos(int numero_nucleos) {
        this.numero_nucleos = numero_nucleos;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    
    
    
}
