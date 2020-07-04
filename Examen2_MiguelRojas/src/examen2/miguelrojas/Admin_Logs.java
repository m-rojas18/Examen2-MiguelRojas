package examen2.miguelrojas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admin_Logs {
    
    
    private ArrayList<String> lista_fallos = new ArrayList();
    private File archivo = null;
    
    
    public Admin_Logs(String path){
        archivo = new File(path);
    }

    public ArrayList<String> getLista_fallos() {
        return lista_fallos;
    }

    public void setLista_fallos(ArrayList<String> lista_fallos) {
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

            for (String s : lista_fallos) {
                bw.write(s + "\n");
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
    
}
