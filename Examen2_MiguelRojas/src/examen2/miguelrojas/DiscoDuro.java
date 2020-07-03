package examen2.miguelrojas;

public class DiscoDuro extends Parte{

    private int tamano;
    private String marca;

    public DiscoDuro(int tamano, String marca, int tiempo_ensamblaje) {
        super(tiempo_ensamblaje);
        this.tamano = tamano;
        this.marca = marca;
    }


    

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
}
