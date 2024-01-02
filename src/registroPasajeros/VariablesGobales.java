package registroPasajeros;

//Importación de los paquetes que manejan diferentes funciones del programa como el manejo de excepciones 
import java.io.Serializable;
import java.util.ArrayList;

//Clase "VariablesGlobales" para varianles que sean de uso general por las demás clases
public class VariablesGobales implements Serializable {

    //Declaración de un ArrayList como instancia estática de la clase "Descuentos"
    public static ArrayList<Descuentos> personas = new ArrayList<>();
}
