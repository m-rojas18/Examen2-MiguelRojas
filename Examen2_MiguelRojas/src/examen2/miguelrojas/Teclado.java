package examen2.miguelrojas;

public class Teclado extends Parte{

    private String material;
    private String color;

    public Teclado(String material, String color, int tiempo_ensamblaje) {
        super(tiempo_ensamblaje);
        this.material = material;
        this.color = color;
    }

    

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
    
}
