package examen2.miguelrojas;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Hilo_Ensamblaje extends Thread {

    public JProgressBar barra;
    public JTable tabla;
    public Computadora compu;
    public boolean empezar = true;
    public boolean fallo = true;
    public int cont = 0;
    public JLabel etiqueta;
    public Tecnico tecnico;
    public Admin_Tecnico at;
    public Admin_Logs admin_logs;
    public JDialog ventana;
    public JButton boton_salir;

    public Hilo_Ensamblaje(JProgressBar barra, JTable tabla, Computadora compu, JLabel etiqueta, Tecnico tecnico, Admin_Tecnico at, Admin_Logs admin_logs, JDialog ventana, JButton boton_salir) {
        this.barra = barra;
        this.tabla = tabla;
        this.compu = compu;
        this.etiqueta = etiqueta;
        this.tecnico = tecnico;
        this.at = at;
        this.admin_logs = admin_logs;
        this.ventana = ventana;
        this.boton_salir = boton_salir;
    }

    public void run() {

        while (empezar) {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            Random r = new Random();
            switch (cont) {
                case 0:
                    //Agregar Ram
                    barra.setMaximum(compu.getRam().getTiempo_ensamblaje() * 10);
                    etiqueta.setText("Ensamblando RAM...");
                    if (barra.getValue() >= barra.getMaximum()) {
                        barra.setValue(0);
                        Object[] obj0 = {"RAM", compu.getRam().getTiempo_ensamblaje() + "s"};
                        modelo.addRow(obj0);
                        tabla.setModel(modelo);
                        cont++;
                    } else {
                        barra.setValue(barra.getValue() + 10);

                    }
                    break;
                case 1:
                    //Agregar Disco duro
                    etiqueta.setText("Ensamblando Disco Duro...");
                    barra.setMaximum(compu.getDiscoduro().getTiempo_ensamblaje() * 10);
                    if (barra.getValue() >= barra.getMaximum()) {
                        barra.setValue(0);
                        Object[] obj1 = {"Disco Duro", compu.getDiscoduro().getTiempo_ensamblaje() + "s"};
                        modelo.addRow(obj1);
                        tabla.setModel(modelo);
                        cont++;
                    } else {
                        barra.setValue(barra.getValue() + 10);
                    }
                    break;
                case 2:
                    //Agregar Bateria
                    etiqueta.setText("Ensamblando Bateria...");
                    barra.setMaximum(compu.getBateria().getTiempo_ensamblaje() * 10);
                    if (barra.getValue() >= barra.getMaximum()) {
                        barra.setValue(0);
                        Object[] obj2 = {"Bateria", compu.getBateria().getTiempo_ensamblaje() + "s"};
                        modelo.addRow(obj2);
                        tabla.setModel(modelo);
                        cont++;
                    } else {
                        barra.setValue(barra.getValue() + 10);
                    }
                    break;
                case 3:
                    //Agregar Teclado
                    etiqueta.setText("Ensamblando Teclado...");
                    barra.setMaximum(compu.getTeclado().getTiempo_ensamblaje() * 10);
                    if (barra.getValue() >= barra.getMaximum()) {
                        barra.setValue(0);
                        Object[] obj3 = {"Teclado", compu.getTeclado().getTiempo_ensamblaje() + "s"};
                        modelo.addRow(obj3);
                        tabla.setModel(modelo);
                        cont++;
                    } else {
                        barra.setValue(barra.getValue() + 10);
                    }
                    break;
                case 4:
                    //Agregar Pantalla
                    etiqueta.setText("Ensamblando Pantalla...");
                    barra.setMaximum(compu.getPantalla().getTiempo_ensamblaje() * 10);
                    if (barra.getValue() >= barra.getMaximum()) {
                        barra.setValue(0);
                        Object[] obj4 = {"Pantalla", compu.getPantalla().getTiempo_ensamblaje() + "s"};
                        modelo.addRow(obj4);
                        tabla.setModel(modelo);
                        cont++;
                    } else {
                        barra.setValue(barra.getValue() + 10);

                    }
                    break;
                case 5:
                    //Agregar Procesador
                    etiqueta.setText("Ensamblando Procesador...");
                    //Ultima vuelta del hilo
                    barra.setMaximum(compu.getProcesador().getTiempo_ensamblaje() * 10);
                    if (barra.getValue() >= barra.getMaximum()) {
                        barra.setValue(0);
                        Object[] obj5 = {"Procesador", compu.getProcesador().getTiempo_ensamblaje() + "s"};
                        modelo.addRow(obj5);
                        tabla.setModel(modelo);
                        //Calcular Fallo
                        probarfallo();
                        if (fallo == true) {
                            JOptionPane.showMessageDialog(ventana, "Ensamblamiento exitoso y sin errores.");
                            tecnico.setCant_computadorasEnsambladas(tecnico.getCant_computadorasEnsambladas() + 1);
                            //Escribir
                            at.escribirArchivo();
                        } else {
                            JOptionPane.showMessageDialog(ventana, "Fallo en Ensamblamiento");
                        }
                        etiqueta.setText("Fin de Ensamblamiento");
                        boton_salir.setVisible(true);
                        empezar = false;
                    } else {
                        barra.setValue(barra.getValue() + 10);
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

    public void probarfallo() {
        Random r = new Random();
        //Calcular Fallo
        //1-5
        if (tecnico.getCant_computadorasEnsambladas() >= 0 && tecnico.getCant_computadorasEnsambladas() <= 5) {
            int fallo1 = r.nextInt(99) + 1;
            //30%
            if (fallo1 >= 1 && fallo1 <= 30) {
                //GenerarLog
                Fallo f = new Fallo("Numero de Serie:" + compu.getNumero_serie() + ", Color: " + compu.getColor() + ",Año: " + compu.getYear(), tecnico.getNombre_tecnico());
                admin_logs.getLista_fallos().add(f);
                admin_logs.escribirArchivo();
                fallo = false;
            }
        } //6-15
        else if (tecnico.getCant_computadorasEnsambladas() >= 6 && tecnico.getCant_computadorasEnsambladas() <= 15) {
            int fallo2 = r.nextInt(99) + 1;
            if (fallo2 >= 1 && fallo2 <= 22) {
                //Generar Log
                Fallo f = new Fallo("Numero de Serie:" + compu.getNumero_serie() + ", Color: " + compu.getColor() + ",Año: " + compu.getYear(), tecnico.getNombre_tecnico());
                admin_logs.getLista_fallos().add(f);
                admin_logs.escribirArchivo();
                fallo = false;
            }
        } //16 - 30
        else if (tecnico.getCant_computadorasEnsambladas() >= 16 && tecnico.getCant_computadorasEnsambladas() <= 30) {
            int fallo3 = r.nextInt(99) + 1;
            if (fallo3 >= 1 && fallo3 <= 13) {
                //Generar Log
                Fallo f = new Fallo("Numero de Serie:" + compu.getNumero_serie() + ", Color: " + compu.getColor() + ",Año: " + compu.getYear(), tecnico.getNombre_tecnico());
                admin_logs.getLista_fallos().add(f);
                admin_logs.escribirArchivo();
                fallo = false;
            }
        } else {
            //mayor a 30
            int fallo4 = r.nextInt(99) + 1;
            if (fallo4 >= 1 && fallo4 <= 7) {
                //Generar Log
                Fallo f = new Fallo("Numero de Serie:" + compu.getNumero_serie() + ", Color: " + compu.getColor() + ",Año: " + compu.getYear(), tecnico.getNombre_tecnico());
                admin_logs.getLista_fallos().add(f);
                admin_logs.escribirArchivo();
                fallo = false;
            }
        }
    }
}
