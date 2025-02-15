package ejemplos;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
//import librerias.estructurasDeDatos.modelos.Map;
import librerias.estructurasDeDatos.modelos.ListaPI;
import librerias.estructurasDeDatos.deDispersion.TablaHash;

public class TestTablaHash {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        TablaHash<String,Integer> tabla = new TablaHash(100);

        Scanner fichero = null;
        
        try {
            fichero = new Scanner(new File(args[0]));
        }
        catch (FileNotFoundException e) {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
        }

        while(fichero.hasNext()) {
            String palabra = fichero.next();
            Integer apariciones = tabla.recuperar(palabra);
            if (apariciones == null)
                tabla.insertar(palabra,1);
            else {
                apariciones++;
                tabla.insertar(palabra,apariciones);
            }
        }

        /*
        ListaPI<String> lista = tabla.claves();
        lista.irInicio();

        while(!lista.esFinal()) {
            String palabra = lista.recuperar();
            Integer apariciones = tabla.recuperar(palabra);
            System.out.println(palabra + " --> " + apariciones + " veces");
            lista.siguiente();
        }
        */

        //System.out.println("Media: " + tabla.factor_carga());
        //System.out.println("Varianza: " + tabla.varianza());
        //System.out.println("Cubetas: " + tabla.elArray.length);

        int[] histo = tabla.histograma();

        for (int i = 0; i < histo.length; i++) {
            System.out.println(i + " " + histo[i]);
        }
    }
}
