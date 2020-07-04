package examen2.miguelrojas;

import java.io.Serializable;

public class Computadora implements Serializable{
    
    private int numero_serie;
    private int year;
    private String color;
    private String material;
    private RAM ram;
    private DiscoDuro discoduro;
    private Bateria bateria;
    private Teclado teclado;
    private Pantalla pantalla;
    private Procesador procesador;
    private final static long SerialVersionUID = 555l;
        

    public Computadora(int numero_serie, int year, String color, String material, RAM ram, DiscoDuro discoduro, Bateria bateria, Teclado teclado, Pantalla pantalla, Procesador procesador) {
        this.numero_serie = numero_serie;
        this.year = year;
        this.color = color;
        this.material = material;
        this.ram = ram;
        this.discoduro = discoduro;
        this.bateria = bateria;
        this.teclado = teclado;
        this.pantalla = pantalla;
        this.procesador = procesador;
    }

    public int getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(int numero_serie) {
        this.numero_serie = numero_serie;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public DiscoDuro getDiscoduro() {
        return discoduro;
    }

    public void setDiscoduro(DiscoDuro discoduro) {
        this.discoduro = discoduro;
    }

    public Bateria getBateria() {
        return bateria;
    }

    public void setBateria(Bateria bateria) {
        this.bateria = bateria;
    }

    public Teclado getTeclado() {
        return teclado;
    }

    public void setTeclado(Teclado teclado) {
        this.teclado = teclado;
    }

    public Pantalla getPantalla() {
        return pantalla;
    }

    public void setPantalla(Pantalla pantalla) {
        this.pantalla = pantalla;
    }

    public Procesador getProcesador() {
        return procesador;
    }

    public void setProcesador(Procesador procesador) {
        this.procesador = procesador;
    }
    

    @Override
    public String toString() {
        return "Numero Serie - " + numero_serie + ", año - " + year + ", color - " + color;
    } 
}
