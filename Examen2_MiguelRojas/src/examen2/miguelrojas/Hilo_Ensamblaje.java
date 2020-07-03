package examen2.miguelrojas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Hilo_Ensamblaje extends Thread {

    public JProgressBar barra;
    public JTable tabla;
    public Computadora compu;
    public boolean empezar = true;
    public int cont = 0;
    public JFrame frame;

    public Hilo_Ensamblaje(JProgressBar barra, JTable tabla, Computadora compu, JFrame frame) {
        this.barra = barra;
        this.tabla = tabla;
        this.compu = compu;
        this.frame = frame;
    }

    
    

    public void run() {

        while (empezar) {
            DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
            
            switch (cont) {
                case 0:
                    //Agregar Ram
                    barra.setMaximum(compu.getRam().getTiempo_ensamblaje() * 10);
                    if (barra.getValue() >= barra.getMaximum()) {
                        barra.setValue(0);
                        Object[] obj0 = {"RAM",compu.getRam().getTamano(), compu.getRam().getMarca(), compu.getRam().getTiempo_ensamblaje() + "s"};
                        modelo.addRow(obj0);
                        tabla.setModel(modelo);
                        cont++;
                    } else {
                        barra.setValue(barra.getValue() + 10);
                    }
                    break;
                case 1:
                    //Agregar Disco duro
                    barra.setMaximum(compu.getDiscoduro().getTiempo_ensamblaje() * 10);
                    if (barra.getValue() >= barra.getMaximum()) {
                        barra.setValue(0);
                        Object[] obj1 = {"Disco Duro",compu.getDiscoduro().getTamano(), compu.getDiscoduro().getMarca(), compu.getDiscoduro().getTiempo_ensamblaje() + "s"};
                        modelo.addRow(obj1);
                        tabla.setModel(modelo);
                        cont++;
                    } else {
                        barra.setValue(barra.getValue() + 10);
                    }
                    break;
                case 2:
                    //Agregar Bateria
                    barra.setMaximum(compu.getBateria().getTiempo_ensamblaje() * 10);
                    if (barra.getValue() >= barra.getMaximum()) {
                        barra.setValue(0);
                        Object[] obj2 = {"Bateria",compu.getBateria().getCapacidad_horas(), compu.getBateria().getMaterial(), compu.getBateria().getTiempo_ensamblaje() + "s"};
                        modelo.addRow(obj2);
                        tabla.setModel(modelo);
                        cont++;
                    } else {
                         barra.setValue(barra.getValue() + 10);
                    }
                    break;
                case 3:
                    //Agregar Teclado
                    barra.setMaximum(compu.getTeclado().getTiempo_ensamblaje() * 10);
                    if (barra.getValue() >= barra.getMaximum()) {
                        barra.setValue(0);
                        Object[] obj3 = {"Teclado",compu.getTeclado().getMaterial(), compu.getTeclado().getColor(), compu.getTeclado().getTiempo_ensamblaje() + "s"};
                        modelo.addRow(obj3);
                        tabla.setModel(modelo);
                        cont++;
                    } else {
                        barra.setValue(barra.getValue() +10);
                    }
                    break;
                case 4:
                    //Agregar Pantalla
                    barra.setMaximum(compu.getPantalla().getTiempo_ensamblaje() * 10);
                    if (barra.getValue() >= barra.getMaximum()) {
                        barra.setValue(0);
                        Object[] obj4 = {"Pantalla", "Tactil: " + compu.getPantalla().getTactilidad(), compu.getPantalla().getTipo(), compu.getPantalla().getTiempo_ensamblaje() + "s"};
                        modelo.addRow(obj4);
                        tabla.setModel(modelo);
                        cont++;
                    } else {
                        barra.setValue(barra.getValue() +10);
                    }
                    break;
                case 5:
                    //Agregar Procesador
                    //Ultima vuelta del hilo
                    barra.setMaximum(compu.getProcesador().getTiempo_ensamblaje() * 10);
                    if (barra.getValue() >= barra.getMaximum()) {
                        barra.setValue(0);
                        Object[] obj5 = {"Procesador","# Nucleos: " + compu.getProcesador().getNumero_nucleos(), "Velocidad:" +compu.getProcesador().getVelocidad(), compu.getProcesador().getTiempo_ensamblaje() + "s"};
                        modelo.addRow(obj5);
                        tabla.setModel(modelo);
                        JOptionPane.showMessageDialog(frame, "Fin de Ensamblamiento");
                        empezar = false;
                        
                        
                    } else {
                        barra.setValue(barra.getValue() +10);
                    }
                    break;

            }
            //Sleep
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo_Ensamblaje.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
