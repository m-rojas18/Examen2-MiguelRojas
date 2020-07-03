package examen2.miguelrojas;

public class Bateria extends Parte{
    
    private int capacidad_horas;
    private String material;


    public Bateria(int capacidad_horas, String material, int tiempo_ensamblaje) {
        super(tiempo_ensamblaje);
        this.capacidad_horas = capacidad_horas;
        this.material = material;
    }

    public int getCapacidad_horas() {
        return capacidad_horas;
    }

    public void setCapacidad_horas(int capacidad_horas) {
        this.capacidad_horas = capacidad_horas;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
    
}
