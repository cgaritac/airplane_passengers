package registroPasajeros;

//Importación de los paquetes que manejan diferentes funciones del programa como el manejo de excepciones 
import static registroPasajeros.VariablesGobales.personas;

//Clase "Validaciones" para validar algunos de los datos ingresados por el usuario
public class Validaciones {

    //Constructor 
    public Validaciones() {
    }

    //Método para determinar si hay datos en una variable
    public String StringVacios(String valor, String tipo) {

        //Declaración de variables
        String resultado = "";

        //Condicional para evaluar si hay datos en una variable
        if (valor.isEmpty()) {
            return resultado = "- El parámetro " + tipo + " no puede estar vacío \n"; //Regresa el valor de la variable            
        } else {
            return resultado = ""; //Regresa el valor de la variable
        }
    }

    //Método para determinar si hay datos de tipo entero en una variable
    public String EnterosVacios(String valor, String tipo) {

        //Declaración de variables
        String resultado = "";

        //Condicional para evaluar si hay datos en una variable
        if (valor.isEmpty()) {
            return resultado = "- El parámetro " + tipo + " no puede estar vacío \n"; //Regresa el valor de la variable        
        } else {
            try //Prueba si existe una excepción
            {
                int valorEntero = Integer.parseInt(valor); //Convierte el valor de una variable a entero y lo asigna a otra variable
                resultado += numerosNegativos(valorEntero, tipo); //LLama el método "numerosNegativos" de la clase "Validaciones" y asigna el valor a la 
                //variable 
                //Condicional para valorar si una variable es igual a un String determinado
                if (tipo == "número de asiento") {
                    resultado += intervaloNumerico(valorEntero, 00, 20, tipo); //LLama el método "intervaloNumerico" de la clase "Validaciones" y asigna  
                    //el valor a la variable 
                }

                return resultado; //Regresa el valor de la variable
            } catch (NumberFormatException e) //Atrapa la excepción NumberFormatException en caso de que ocurra en el bloque "Try"
            {
                return resultado = "- El parámetro " + tipo + " debe ser un número entero \n"; //Regresa el valor de la variable
            }
        }
    }

    //Metodo que se encarga de evaluar si el número ingresado por el usuario es negativo
    public String numerosNegativos(int valor, String tipo) {

        //Declaración de variables
        String resultado = "";

        //Condicional para evaluar si un valor es menor a 0
        if (valor < 0) {
            return resultado = "- El parámetro " + tipo + " debe ser un número entero positivo \n"; //Regresa el valor de la variable                 
        } else {
            return resultado = ""; //Regresa el valor de la variable   
        }
    }

    //Método que se encarga de evaluar si ambos radioButtos aún no han sido seleccionados
    public String seleccionRadioButton(boolean rdb1, boolean rdb2, String tipo) {

        //Declaración de variables
        String resultado = "";

        //Condicional para evaluar si una u otra variable son "true"
        if (rdb1 || rdb2) {
            return resultado = ""; //Regresa el valor de la variable               
        } else {
            return resultado = "- Debe seleccionar una opción del parámetro " + tipo + "\n"; //Regresa el valor de la variable 
        }
    }

    //Método que se encarga de evaluar si el número ingresado por el usuario se encuentra dentro de un intervalo definido
    public String intervaloNumerico(int valor, int minimo, int maximo, String tipo) {

        //Declaración de variables
        String resultado = "";

        //Condicional para evaluar si un valor se encuentra entre un máximo y un mínimo
        if (valor < minimo || valor > maximo) {
            return resultado = "- El parámetro " + tipo + " debe encontrarse entre 00 y 20 \n"; //Regresa el valor de la variable          
        } else {
            return resultado = ""; //Regresa el valor de la variable
        }
    }

    //Método que se encarga de valorar si un asiento ya se encuentra ocupado
    public String disponibilidadAsiento(String numAsiento, String destino, String tipo) {

        //Declaración de variables
        String resultado = "";

        //Condicional para evaluar si hay datos en una u otra variable
        if (numAsiento.isEmpty() || destino.isEmpty()) {
            return resultado; //Regresa el valor de la variable
        } else {
            try //Prueba si existe una excepción
            {
                int numAsientoEntero = Integer.parseInt(numAsiento); //Convierte el valor de una variable a entero y lo asigna a otra variable

                //Declaración de variable local
                boolean encontrado = false;

                //Condicional para valorar si una variable se encuentra entre dos valores definidos
                if (numAsientoEntero >= 0 && numAsientoEntero <= 20) {

                    //Ciclo para recorrer el objeto de ArrayList de Personas de la clase variablesGlobales
                    for (int i = 0; i < personas.size(); i++) {
                        Descuentos p = personas.get(i); //Asigna el resultado del ArrayList en la posición "i" al objeto "p" de la clase "Descuentos"

                        //Condicional para valorar si los valores del ArrayList en posiciones específicas son iguales a las variables de entrada al método
                        if (Integer.parseInt(p.getNumAsiento()) == (numAsientoEntero) && p.getDestino().equals(destino)) {
                            encontrado = true; //Asigna un valor a la variable si se cumple la condición del "if"
                            break; //Detiene el ciclo si se cumple la condición del "if"
                        }
                    }

                    //Condicional para valorar si el asiento está efectivamente ocupado
                    if (encontrado) {
                        return resultado = "- El " + tipo + " se encuentra ocupado \n"; //Regresa el valor de la variable       
                    } else {
                        return resultado; //Regresa el valor de la variable
                    }
                } else {
                    return resultado; //Regresa el valor de la variable
                }
            } catch (NumberFormatException e) //Atrapa la excepción NumberFormatException en caso de que ocurra en el bloque "Try"
            {
                return resultado; //Regresa el valor de la variable
            }
        }
    }

    //Método para evaluar si el ArrayList se encuentra vacío
    public String arrayListtVacio() {

        //Declaración de variables
        String resultado = "";

        //Condicional que se ejecuta en caso de que el ArrayList se encuentre vacío
        if (personas.isEmpty()) {
            resultado += "- El pasajero no ha realizado vuelos con anterioridad\n"; //Regresa el valor de la variable                  
        }

        return resultado;  //Regresa el valor de la variable    
    }
}
