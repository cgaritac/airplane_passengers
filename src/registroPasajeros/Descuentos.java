package registroPasajeros;

//Importación de los paquetes que manejan diferentes funciones del programa
import java.io.Serializable;

//Clase "Descuentos" para implementar descuentos según edad del pasajero
public class Descuentos extends Persona implements Serializable {

    //Constructor 
    public Descuentos() {
        super(); //Llamado al constructor de la clase padre
    }

    //Constructor 
    public Descuentos(String nombre, String apellido, String edad, String genero, String pasaporte, String tipoMembresia, String numAsiento, String destino, String permiso, String nombreEncargado, String regimen, String estadoVuelo, String tipoPago) {
        super(nombre, apellido, edad, genero, pasaporte, tipoMembresia, numAsiento, destino, permiso, nombreEncargado, regimen, estadoVuelo, tipoPago);  //Llamado al constructor de la clase padre
        this.CostoFinalDesc(); //Ejecuta método
    }

    //Metodo que se encarga de modificar el valor de la variable de instancia CostoBoleto de la clase padre "Persona" según el descuento aplicado
    public double CostoFinalDesc() {
        int edadNum = Integer.parseInt(getEdad()); //Convierte el valor de "edad" de la clase "Persona" a entero y lo asigna a la variable local "edadNum"

        setCostoBoleto(); //Ejecuta el método "setCostoBoleto" de la clase padre para reiniciar los valor según el país de destino

        //Condicional para valorar si se encuentra en un rango de edades   
        if (edadNum < 14) {
            costoBoleto = getCostoBoleto() * (1 - 0.10); //Asignación a la variable de instancia del padre
        }

        //Condicional para valorar si se encuentra en un rango de edades   
        if (edadNum > 65) {
            costoBoleto = getCostoBoleto() * (1 - 0.35); //Asignación a la variable de instancia del padre
        }

        //Condicional para valorar si se encuentra en un rango de edades           
        if (edadNum <= 65 && edadNum >= 14) {
            costoBoleto = getCostoBoleto(); //Asignación a la variable de instancia del padre
        }

        return costoBoleto; //Regresa el valor de la variable de instancia CostoBoleto de la clase padre "Persona" según el descuento aplicado
    }
}
