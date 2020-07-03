package examen2.miguelrojas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admin_Tecnico {
    
    private ArrayList<Tecnico> lista_tecnicos = new ArrayList();
    private File archivo = null;
    
    
    public Admin_Tecnico(String path){
        archivo = new File(path);
    }

    public ArrayList<Tecnico> getLista_tecnicos() {
        return lista_tecnicos;
    }

    public void setLista_tecnicos(ArrayList<Tecnico> lista_tecnicos) {
        this.lista_tecnicos = lista_tecnicos;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    //Metodos Administrativos
    public void escribirArchivo(){

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(archivo);
            bw = new BufferedWriter(fw);

            for (Tecnico t : lista_tecnicos) {
                bw.write(t.getNombre_tecnico() + ";");
                bw.write(t.getEdad_tecnico() + ";");
                bw.write(t.getGenero() + ";");
                bw.write(t.getCant_computadorasEnsambladas() + ";");
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
    
    public void cargarArchivo2() {
        
        Scanner sc1 = null;
        lista_tecnicos = new ArrayList();
        // Scanner sc2 = null;
        try {
            sc1 = new Scanner(archivo);
            sc1.useDelimiter(";");
            while (sc1.hasNext()) {
                Tecnico t = new Tecnico(sc1.next(), sc1.nextInt(), sc1.next(), sc1.nextInt());
                lista_tecnicos.add(t);
            }
        } catch (Exception e) {
        } finally {
            sc1.close();
            // sc2.close();
        }
        
    }
    
}
