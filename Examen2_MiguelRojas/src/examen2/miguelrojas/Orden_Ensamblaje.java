package examen2.miguelrojas;

public class Orden_Ensamblaje {
    
    
    private Computadora compu;
    private Tecnico tecnico;

    public Orden_Ensamblaje(Computadora compu, Tecnico tecnico) {
        this.compu = compu;
        this.tecnico = tecnico;
    }

    public Computadora getCompu() {
        return compu;
    }

    public void setCompu(Computadora compu) {
        this.compu = compu;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
    
    
}
