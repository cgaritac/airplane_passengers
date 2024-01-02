package registroPasajeros;

//Importación de los paquetes que manejan diferentes funciones del programa
import java.io.Serializable;

//Clase "Persona" para manejar los datos del pasajero que se ingrese
public class Persona implements Serializable {

    //Declaración de las variables de instancia
    protected String nombre, apellido, edad, genero, pasaporte, tipoMembresia, numTiquete, numAsiento, numVuelo, destino, tipoPersona, descuento, permiso, nombreEncargado, regimen, estadoVuelo, tipoPago;
    protected double costoBoleto;
    protected int id, puntos = 0, puntosCanjeados;
    protected static int idAutonumerado = 0;

    //Constructor 
    public Persona(int id) {
        this.idAutonumerado = id; //Asigna un valor de la variable estática a la variable de instancia          
    }

    //Constructor 
    public Persona() {
        this.id = idAutonumerado; //Asigna un valor de la variable estática a la variable de instancia     
    }

    //Constructor 
    public Persona(String nombre, String apellido, String edad, String genero, String pasaporte, String tipoMembresia, String numAsiento, String destino, String permiso, String nombreEncargado, String regimen, String estadoVuelo, String tipoPago) {
        this.setId(); //Ejecuta método
        this.nombre = nombre; //Asigna el valor ingresado en el constructor a la variable de instancia
        this.apellido = apellido; //Asigna el valor ingresado en el constructor a la variable de instancia
        this.edad = edad; //Asigna el valor ingresado en el constructor a la variable de instancia
        this.regimen = regimen; //Asigna el valor ingresado en el constructor a la variable de instancia
        this.genero = genero; //Asigna el valor ingresado en el constructor a la variable de instancia
        this.pasaporte = pasaporte; //Asigna el valor ingresado en el constructor a la variable de instancia
        this.tipoMembresia = tipoMembresia; //Asigna el valor ingresado en el constructor a la variable de instancia
        this.numAsiento = numAsiento; //Asigna el valor ingresado en el constructor a la variable de instancia
        this.destino = destino; //Asigna el valor ingresado en el constructor a la variable de instancia
        this.setNumVuelo(); //Ejecuta método
        this.setNumTiquete(); //Ejecuta método
        this.setTipoPersona(); //Ejecuta método
        this.setDescuento(); //Ejecuta método
        this.permiso = permiso; //Asigna el valor ingresado en el constructor a la variable de instancia
        this.nombreEncargado = nombreEncargado; //Asigna el valor ingresado en el constructor a la variable de instancia
        this.estadoVuelo = estadoVuelo; //Asigna el valor ingresado en el constructor a la variable de instancia
        this.setPuntos();
        this.setCostoBoleto();  //Ejecuta método
        this.tipoPago = tipoPago;
        this.setPuntosCanjeados();
    }

    //Metodo que se encarga de obtener el valor de la variable de instancia
    public int getId() {
        return id; //Regresa el valor de la variable de instancia
    }

    //Metodo que se encarga de establecer el valor de la variable de instancia
    public void setId() {
        this.id = ++idAutonumerado; //Suma 1 a la variable estática y asigna el valor a de instancia     
    }

    //Metodo que se encarga de obtener el valor de la variable de instancia 
    public String getNombre() {
        return nombre; //Regresa el valor de la variable de instancia
    }

    //Metodo que se encarga de establecer el valor de la variable de instancia
    public void setNombre(String nombre) {
        this.nombre = nombre; //Asigna el valor ingresado en el método a la variable de instancia
    }

    //Metodo que se encarga de obtener el valor de la variable de instancia 
    public String getApellido() {
        return apellido; //Regresa el valor de la variable de instancia
    }

    //Metodo que se encarga de establecer el valor de la variable de instancia
    public void setApellido(String apellido) {
        this.apellido = apellido;  //Asigna el valor ingresado en el método a la variable de instancia
    }

    //Metodo que se encarga de obtener el valor de la variable de instancia 
    public String getEdad() {
        return edad; //Regresa el valor de la variable de instancia
    }

    //Metodo que se encarga de establecer el valor de la variable de instancia
    public void setEdad(String edad) {
        this.edad = edad;  //Asigna el valor ingresado en el método a la variable de instancia
    }

    //Metodo que se encarga de obtener el valor de la variable de instancia 
    public String getRegimen() {
        return regimen; //Regresa el valor de la variable de instancia
    }

    //Metodo que se encarga de establecer el valor de la variable de instancia
    public void setRegimen(String regimen) {
        this.regimen = regimen;  //Asigna el valor ingresado en el método a la variable de instancia
    }

    //Metodo que se encarga de obtener el valor de la variable de instancia 
    public String getGenero() {
        return genero; //Regresa el valor de la variable de instancia
    }

    //Metodo que se encarga de establecer el valor de la variable de instancia
    public void setGenero(String genero) {
        this.genero = genero;  //Asigna el valor ingresado en el método a la variable de instancia
    }

    //Metodo que se encarga de obtener el valor de la variable de instancia 
    public String getPasaporte() {
        return pasaporte; //Regresa el valor de la variable de instancia
    }

    //Metodo que se encarga de establecer el valor de la variable de instancia
    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;  //Asigna el valor ingresado en el método a la variable de instancia
    }

    public String getTipoMembresia() {
        return tipoMembresia; //Regresa el valor de la variable de instancia
    }

    //Metodo que se encarga de establecer el valor de la variable de instancia
    public void setTipoMembresia(String tipoMembresia) {
        this.tipoMembresia = tipoMembresia;  //Asigna el valor ingresado en el método a la variable de instancia
    }

    //Metodo que se encarga de obtener el valor de la variable de instancia 
    public int getPuntos() {
        return puntos; //Regresa el valor de la variable de instancia
    }

    //Metodo que se encarga de establecer el valor de la variable de instancia
    public void setPuntos() {

        //Condiocional que se ejecuta en caso de que la membresía sea "Premium y se haya completado el vuelo
        if (tipoMembresia.equals("Premium") && estadoVuelo.equals("Completado")) {
            this.puntos = this.puntos + 200;
        } else if (tipoMembresia.equals("Platinum") && estadoVuelo.equals("Completado")) {
            this.puntos = this.puntos + 100;
        } else {
            this.puntos = 0;
        }
    }

    //Metodo que se encarga de obtener el valor de la variable de instancia 
    public int getPuntosCanjeados() {
        return puntosCanjeados; //Regresa el valor de la variable de instancia
    }

    //Metodo que se encarga de establecer el valor de la variable de instancia
    public void setPuntosCanjeados() {

        //Condicional que se ejecuta en caso de que el pago sea con puntos y el destino sea "Panamá"
        if (this.tipoPago.equals("Puntos") && this.destino.equals("Panamá")) {
            this.puntosCanjeados = 400;
        } else if (this.tipoPago.equals("Puntos") && this.destino.equals("Nicaragua")) {
            this.puntosCanjeados = 500;
        } else {
            this.puntosCanjeados = 0;
        }
    }

    //Metodo que se encarga de obtener el valor de la variable de instancia     
    public String getTipoPago() {
        return tipoPago; //Regresa el valor de la variable de instancia
    }

    //Metodo que se encarga de establecer el valor de la variable de instancia
    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;  //Asigna el valor ingresado en el método a la variable de instancia
    }

    //Metodo que se encarga de obtener el valor de la variable de instancia
    public String getTipoPersona() {
        return tipoPersona; //Regresa el valor de la variable de instancia
    }

    //Metodo que se encarga de establecer el valor de la variable de instancia
    public void setTipoPersona() {

        int edadNum = Integer.parseInt(edad); //Convierte "edad" a entero y lo asigna a la variable local "edadNum"

        //Condicional para valorar si se encuentra en un rango de edades
        if (edadNum >= 14 && edadNum <= 65) {
            this.tipoPersona = "Normal"; //Asigna un string a la variable de instancia "tipoPersona" según el rango de edades
        }

        //Condicional para valorar si se encuentra en un rango de edades
        if (edadNum < 14) {
            this.tipoPersona = "Menor"; //Asigna un string a la variable de instancia "tipoPersona" según el rango de edades
        }

        //Condicional para valorar si se encuentra en un rango de edades           
        if (edadNum > 65) {
            this.tipoPersona = "Ciudadano de Oro"; //Asigna un string a la variable de instancia "tipoPersona" según el rango de edades
        }
    }

    //Metodo que se encarga de obtener el valor de la variable de instancia 
    public String getDescuento() {
        return descuento; //Regresa el valor de la variable de instancia
    }

    //Metodo que se encarga de establecer el valor de la variable de instancia
    public void setDescuento() {

        int edadNum = Integer.parseInt(edad); //Convierte "edad" a entero y lo asigna a la variable local "edadNum"

        //Condicional para valorar si se encuentra en un rango de edades   
        if (edadNum >= 14 && edadNum <= 65) {
            this.descuento = "0%"; //Asigna un string a la variable de instancia "descuento" según el rango de edades
        }

        //Condicional para valorar si se encuentra en un rango de edades           
        if (edadNum < 14) {
            this.descuento = "10%"; //Asigna un string a la variable de instancia "descuento" según el rango de edades
        }

        //Condicional para valorar si se encuentra en un rango de edades           
        if (edadNum > 65) {
            this.descuento = "35%"; //Asigna un string a la variable de instancia "descuento" según el rango de edades
        }
    }

    //Metodo que se encarga de obtener el valor de la variable de instancia 
    public String getNombreEncargado() {
        return nombreEncargado; //Regresa el valor de la variable de instancia
    }

    //Metodo que se encarga de establecer el valor de la variable de instancia
    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;  //Asigna el valor ingresado en el método a la variable de instancia
    }

    //Metodo que se encarga de obtener el valor de la variable de instancia 
    public String getPermiso() {
        return permiso; //Regresa el valor de la variable de instancia
    }

    //Metodo que se encarga de establecer el valor de la variable de instancia
    public void setPermiso(String permiso) {
        this.permiso = permiso;  //Asigna el valor ingresado en el método a la variable de instancia
    }

    //Metodo que se encarga de obtener el valor de la variable de instancia 
    public String getNumTiquete() {
        return numTiquete; //Regresa el valor de la variable de instancia
    }

    //Metodo que se encarga de establecer el valor de la variable de instancia
    public void setNumTiquete() {
        numTiquete = numVuelo + numAsiento; //Asignación a la variable de instancia
    }

    //Metodo que se encarga de obtener el valor de la variable de instancia 
    public String getNumAsiento() {
        return numAsiento; //Regresa el valor de la variable de instancia
    }

    //Metodo que se encarga de establecer el valor de la variable de instancia
    public void setNumAsiento(String numAsiento) {
        this.numAsiento = numAsiento;  //Asigna el valor ingresado en el método a la variable de instancia
    }

    //Metodo que se encarga de obtener el valor de la variable de instancia 
    public String getNumVuelo() {
        return numVuelo; //Regresa el valor de la variable de instancia
    }

    //Metodo que se encarga de establecer el valor de la variable de instancia
    public void setNumVuelo() {
        //Condicional para asignar la palabra "PNA" a la variable de instancia "numVuelo" si el usuario ingreso como destino Panamá
        if (destino.equals("Panamá")) {
            numVuelo = "PNA"; //Asignación a la variable de instancia
        }
        //Condicional para asignar la palabra "NCA" a la variable de instancia "numVuelo" si el usuario ingreso como destino Nicaragua
        if (destino.equals("Nicaragua")) {
            numVuelo = "NCA"; //Asignación a la variable de instancia
        }
    }

    //Metodo que se encarga de obtener el valor de la variable de instancia 
    public String getDestino() {
        return destino; //Regresa el valor de la variable de instancia
    }

    //Metodo que se encarga de establecer el valor de la variable de instancia
    public void setDestino(String destino) {
        this.destino = destino;  //Asigna el valor ingresado en el método a la variable de instancia
    }

    public String getEstadoVuelo() {
        return estadoVuelo;
    }

    public void setEstadoVuelo(String estadoVuelo) {
        this.estadoVuelo = estadoVuelo;
    }

    //Metodo que se encarga de obtener el valor de la variable de instancia 
    public double getCostoBoleto() {
        return costoBoleto; //Regresa el valor de la variable de instancia
    }

    //Metodo que se encarga de establecer el valor de la variable de instancia
    public void setCostoBoleto() {

        //Condicional para asignar el valor de 100 a la variable de instancia "costoBoleto" si el usuario indico como destino Panamá
        if (this.destino.equals("Panamá")) {
            this.costoBoleto = 100; //Asignación a la variable de instancia del padre
        }

        //Condicional para asignar el valor de 95 a la variable de instancia "costoBoleto" si el usuario indico como destino Nicaragua
        if (this.destino.equals("Nicaragua")) {
            this.costoBoleto = 95; //Asignación a la variable de instancia del padre
        }
    }
}
