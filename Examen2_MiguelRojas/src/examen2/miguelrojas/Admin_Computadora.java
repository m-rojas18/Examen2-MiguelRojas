package examen2.miguelrojas;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Admin_Computadora {

    private ArrayList<Computadora> lista_compus = new ArrayList();
    private File archivo = null;
    
    
    public Admin_Computadora(String path){
        archivo = new File(path);
    }

    public ArrayList<Computadora> getLista_compus() {
        return lista_compus;
    }

    public void setLista_compus(ArrayList<Computadora> lista_compus) {
        this.lista_compus = lista_compus;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    
    
    
    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Computadora c : lista_compus) {
                bw.writeObject(c);
            }
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }
    
    public void cargarArchivo() {
        try {
            lista_compus = new ArrayList();
            Computadora temp;
            if (archivo.exists()) {
                FileInputStream entrada
                        = new FileInputStream(archivo);
                ObjectInputStream objeto
                        = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Computadora) objeto.readObject()) != null  ) {
                        lista_compus.add(temp);
                        
                    } 
                } catch (EOFException e) {
                    //encontro el final del archivo
                }
                objeto.close();
                entrada.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
