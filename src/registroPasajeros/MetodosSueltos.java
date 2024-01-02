package registroPasajeros;

//Importación de los paquetes que manejan diferentes funciones del programa
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import static registroPasajeros.VariablesGobales.personas;

//Clase que maneja méttodos variados relacionados con el manejo de archivos
public class MetodosSueltos {

    //Método para leer un archivo
    public static void leerPasajeros(String ruta) {
        try {
            ObjectInputStream ios = new ObjectInputStream(new FileInputStream(ruta));

            while (true) {
                ArrayList<Descuentos> p = (ArrayList<Descuentos>) ios.readObject(); //Se lee el archivo

                personas = new ArrayList<>(p); //Se almacena la información del archivo en el ArrayList personas
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (EOFException ex) {
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Método para escribir un archivo
    public static void escribirPasajeros(ArrayList<Descuentos> p, String ruta) throws FileNotFoundException, IOException {
        //File f = new File("pasajeros.txt");        

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(p); //Se crea o escribe el archivo
        }
    }
}
