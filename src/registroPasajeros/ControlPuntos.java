package registroPasajeros;

//Importación de los paquetes que manejan diferentes funciones del programa
import java.io.Serializable;
import static registroPasajeros.VariablesGobales.personas;

//Clase "ControlPuntos" para ejecutar el control de los puntos que acumule el usuario a la hora de contar, registrar y cangear
public class ControlPuntos implements Serializable {

    //Declaración de variable de instancia
    int contadorVuelos = 0, puntosAcumul = 0, puntosCanj = 0;

    //Método constructor
    public ControlPuntos() {
    }

    //Método para contar la cantidad de vuelos realizados por el pasajero
    public String cantidadVuelos(String pasaporte) {

        //Ciclo para reccorrer el ArrayList personas
        for (int x = 0; x < personas.size(); x++) {

            //Condicional que se ejecuta con un contador en caso de que encuentre el pasaporte del pasajero en el ArrayList personas
            if (pasaporte.equals(personas.get(x).getPasaporte())) {
                this.contadorVuelos++;
            }
        }
        return Integer.toString(this.contadorVuelos);
    }

    //Método para contar la cantidad de puntos acumulados
    public String puntosAcumulados(String pasaporte) {

        //Ciclo para reccorrer el ArrayList personas
        for (int x = 0; x < personas.size(); x++) {

            //Condicional que se ejecuta para sumar los puntos acumulados en caso de que encuentre el pasaporte del pasajero en el ArrayList personas
            if (pasaporte.equals(personas.get(x).getPasaporte())) {
                this.puntosAcumul = this.puntosAcumul + personas.get(x).getPuntos();
            }
        }
        return Integer.toString(this.puntosAcumul);
    }

    //Método para contar la cantidad de puntos canjeados
    public String puntosCanjeados(String pasaporte) {

        //Ciclo para reccorrer el ArrayList personas       
        for (int x = 0; x < personas.size(); x++) {

            //Condicional que se ejecuta para sumar los puntos canjeados en caso de que encuentre el pasaporte del pasajero en el ArrayList personas
            if (pasaporte.equals(personas.get(x).getPasaporte())) {
                this.puntosCanj = this.puntosCanj + personas.get(x).getPuntosCanjeados();
            }
        }
        return Integer.toString(this.puntosCanj);
    }

    //Método para determinar la cantidad de puntos disponibles
    public String puntosDisponibles() {
        return Integer.toString(this.puntosAcumul - this.puntosCanj);
    }
}
