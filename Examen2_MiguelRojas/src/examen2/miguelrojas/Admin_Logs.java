package examen2.miguelrojas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admin_Logs {
    
    
    private ArrayList<Fallo> lista_fallos = new ArrayList();
    private File archivo = null;
    
    
    public Admin_Logs(String path){
        archivo = new File(path);
    }

    public ArrayList<Fallo> getLista_fallos() {
        return lista_fallos;
    }

    public void setLista_fallos(ArrayList<Fallo> lista_fallos) {
        this.lista_fallos = lista_fallos;
    }

    

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
     public void escribirArchivo(){

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(archivo);
            bw = new BufferedWriter(fw);

            for (Fallo f : lista_fallos) {
                bw.write(f.getNombre_computadora() + ";");
                bw.write(f.getNombre_tecnico() + ";");
            }
            bw.flush();
        } catch (Exception e) {
        }
        try {
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Admin_Tecnico.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
     
     public void cargar() {
        Scanner sc = null;
        lista_fallos = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter(";");
                while(sc.hasNext()){
                    lista_fallos.add(new Fallo(sc.next(), sc.next()));
                }
            } catch (Exception e) {
            }
            sc.close();
        }
    } 
    
}
