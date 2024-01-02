/*
Universidad: UNED
Curso:        Programación Intermedia 
Código:       00824
Tema:         Proyecto Final
Estudiante:   Carlos Garita Campos
Periodo:      I Cuatrimestre 2020
 */
package registroPasajeros;

//Importación de los paquetes que manejan diferentes funciones del programa
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import static registroPasajeros.VariablesGobales.personas;

//Clase "Menú" para desarrollar el menú general del programa de forma gráfica para la interfaz de usuario
public class Menu extends javax.swing.JFrame {

    //Declaración de las variables de instancia
    private DefaultTableModel modeloTabla;
    private final int MAX_PERSONAS = 40;
    private final int ConsulNomb = 1;
    private final int ConsulVuelo = 2;
    private boolean opcionEditarAgregar;

    //Constructor 
    public Menu() {
        initComponents(); //Carga todo los objetos que halla en el JFrame          
        this.setLocationRelativeTo(null); //Posiciona el JFrame en el centro de la pantalla   
        this.cargarDatos(ConsulNomb, this.txtConsulta.getText()); //Ejecuta el método "cargarDatos" 

        //Asignación de radioButtons a un buttonGroup
        this.bgConsultas.add(this.rdbConsulNomb);
        this.bgConsultas.add(this.rdbConsulNumVuel);

        //Establece el radioButton de consulta por nombre como seleccionado al iniciar
        rdbConsulNomb.setSelected(true);
    }

    //Método para cargar y mostrar los datos en la tabla, ya sea a la hora de ingresar los datos o de hacer las consultas
    public void cargarDatos(int tipoConsulta, String coincidenciaNombre) {

        //Inicializa la variable "modeloTabla" con los valores de "DefaultTableModel" para establecer el modelo inicial de la tabla
        this.modeloTabla = new DefaultTableModel() {

            //Método para impedir que la la información de la tabla sea editable de forma directa por el usuario sin usar la opción de editar del menú
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //Regresa el valor de la variable
            }
        };

        //Se establecen los nombres de los encabezados de las columnas de la tabla
        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Edad");
        modeloTabla.addColumn("Régimen");
        modeloTabla.addColumn("Género");
        modeloTabla.addColumn("Pasaporte");
        modeloTabla.addColumn("Tipo Pasajero");
        modeloTabla.addColumn("Encargado");
        modeloTabla.addColumn("Permiso");
        modeloTabla.addColumn("Membresía");
        modeloTabla.addColumn("Vuelo");
        modeloTabla.addColumn("Asiento");
        modeloTabla.addColumn("Tiquete");
        modeloTabla.addColumn("Destino");
        modeloTabla.addColumn("Descuento");
        modeloTabla.addColumn("Costo Boleto");
        modeloTabla.addColumn("Tipo Pago");
        modeloTabla.addColumn("Estado Vuelo");

        //Se establece el formato de la tabla
        this.tbPasajeros.getTableHeader().setFont(new Font("Tahoma", 0, 14));
        this.tbPasajeros.setRowHeight(20);

        //Se define un array para manejar la informacion a ingresar en cada fila
        Object[] fila;
        this.tbPasajeros.setModel(modeloTabla); //Se establece el modelo de la tabla "tbPasajeros"

        //Ciclo para recorrer un objeto p de la clase "Descuentos" del ArrayList "personas" de la clase "VariablesGlobales" para obtener los datos almacenados
        for (Descuentos p : personas) {

            //Switch para ejecutar el tipo de consulta seleccionada por el usuario
            switch (tipoConsulta) {
                case 1: //Consulta por nombre   

                    //Condicional para determinar si el valor de nombre del objeto "p" coincide con el dato ingresado por el usuario
                    if (p.getNombre().toLowerCase().contains(coincidenciaNombre.toLowerCase())) {

                        //Se define un array de 16 campos y se asigna a la variable "fila"
                        fila = new Object[19];

                        //Se asignan los valores de las variables de instancia del objeto p a cada campo del array "fila"
                        fila[0] = p.getId();
                        fila[1] = p.getNombre();
                        fila[2] = p.getApellido();
                        fila[3] = p.getEdad();
                        fila[4] = p.getRegimen();
                        fila[5] = p.getGenero();
                        fila[6] = p.getPasaporte();
                        fila[7] = p.getTipoPersona();
                        fila[8] = p.getNombreEncargado();
                        fila[9] = p.getPermiso();
                        fila[10] = p.getTipoMembresia();
                        fila[11] = p.getNumVuelo();
                        fila[12] = p.getNumAsiento();
                        fila[13] = p.getNumTiquete();
                        fila[14] = p.getDestino();
                        fila[15] = p.getDescuento();
                        fila[16] = p.CostoFinalDesc();
                        fila[17] = p.getTipoPago();
                        fila[18] = p.getEstadoVuelo();

                        modeloTabla.addRow(fila); //Se adicionan los valores del array "fila" a una fila del modelo de la tabla

                        break; //Sale del Switch
                    }
                case 2: //Consulta por número de vuelo

                    //Condicional para determinar si el valor de número de vuelo del objeto "p" coincide con el dato ingresado por el usuario
                    if (p.getNumVuelo().toLowerCase().contains(coincidenciaNombre.toLowerCase())) {

                        //Se define un array de 16 campos y se asigna a la variable "fila"
                        fila = new Object[19];

                        //Se asignan los valores de las variables de instancia del objeto p a cada campo del array "fila"
                        fila[0] = p.getId();
                        fila[1] = p.getNombre();
                        fila[2] = p.getApellido();
                        fila[3] = p.getEdad();
                        fila[4] = p.getRegimen();
                        fila[5] = p.getGenero();
                        fila[6] = p.getPasaporte();
                        fila[7] = p.getTipoPersona();
                        fila[8] = p.getNombreEncargado();
                        fila[9] = p.getPermiso();
                        fila[10] = p.getTipoMembresia();
                        fila[11] = p.getNumVuelo();
                        fila[12] = p.getNumAsiento();
                        fila[13] = p.getNumTiquete();
                        fila[14] = p.getDestino();
                        fila[15] = p.getDescuento();
                        fila[16] = p.CostoFinalDesc();
                        fila[17] = p.getTipoPago();
                        fila[18] = p.getEstadoVuelo();

                        modeloTabla.addRow(fila); //Se adicionan los valores del array "fila" a una fila del modelo de la tabla

                        break; //Sale del Switch
                    }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgConsultas = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        rdbConsulNomb = new javax.swing.JRadioButton();
        rdbConsulNumVuel = new javax.swing.JRadioButton();
        txtConsulta = new javax.swing.JTextField();
        lblConsulta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPasajeros = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArchivos = new javax.swing.JMenu();
        mitAbrir = new javax.swing.JMenuItem();
        mitGuardar = new javax.swing.JMenuItem();
        mnuGestionPasajeros = new javax.swing.JMenu();
        mitAgregar = new javax.swing.JMenuItem();
        mitEditar = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenu();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal");
        setIconImages(null);
        setSize(new java.awt.Dimension(325, 173));

        rdbConsulNomb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbConsulNomb.setText("Consulta por nombre");
        rdbConsulNomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbConsulNombActionPerformed(evt);
            }
        });

        rdbConsulNumVuel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbConsulNumVuel.setText("Consulta por número de vuelo");
        rdbConsulNumVuel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbConsulNumVuelActionPerformed(evt);
            }
        });

        txtConsulta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtConsultaMouseClicked(evt);
            }
        });
        txtConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsultaActionPerformed(evt);
            }
        });
        txtConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConsultaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConsultaKeyReleased(evt);
            }
        });

        lblConsulta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblConsulta.setText("Introduzca el nombre del pasajero a consultar:");

        tbPasajeros.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tbPasajeros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbPasajeros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbPasajeros);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(701, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbConsulNomb)
                    .addComponent(rdbConsulNumVuel))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(199, 199, 199))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblConsulta)
                        .addGap(22, 22, 22)
                        .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdbConsulNomb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdbConsulNumVuel)))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel2);

        mnuArchivos.setText("|Archivos|");
        mnuArchivos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        mitAbrir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mitAbrir.setText("Abrir");
        mitAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitAbrirActionPerformed(evt);
            }
        });
        mnuArchivos.add(mitAbrir);

        mitGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mitGuardar.setText("Guardar");
        mitGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitGuardarActionPerformed(evt);
            }
        });
        mnuArchivos.add(mitGuardar);

        jMenuBar1.add(mnuArchivos);

        mnuGestionPasajeros.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mnuGestionPasajeros.setText("|Gestión de Pasajeros|");
        mnuGestionPasajeros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        mitAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mitAgregar.setText("Agregar Pasajeros");
        mitAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitAgregarActionPerformed(evt);
            }
        });
        mnuGestionPasajeros.add(mitAgregar);

        mitEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mitEditar.setText("Editar Pasajero");
        mitEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitEditarActionPerformed(evt);
            }
        });
        mnuGestionPasajeros.add(mitEditar);

        jMenuBar1.add(mnuGestionPasajeros);

        mnuSalir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mnuSalir.setText("|Salir|");
        mnuSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mnuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mitEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitEditarActionPerformed

        //Obtiene un valor númerico en caso de que la fila se encuentre seleccionada y lo asigna a una variable local "fila"
        int fila = this.tbPasajeros.getSelectedRow();

        opcionEditarAgregar = true; //Asigna un valor de "true" a la variable de instancia "opcionEditarAgregar"

        //Condicional para determinar si la fila se encuentra seleccionada para continuar con el formulario de edición de datos
        if (fila != -1) {

            //Obtiene el valor de "id" en la fila seleccionada de la tabla y lo almacena en una variable local llamada "id"
            int id = (int) this.tbPasajeros.getValueAt(fila, 0);

            //Asigna un valor de "null" al objeto "personaEditar" de la clase "Descuentos"
            Descuentos personaEditar = null;

            //Ciclo para recorrer un objeto p de la clase "Descuentos" del ArrayList "personas" de la clase "VariablesGlobales" para obtener los datos almacenados 
            for (Descuentos p : personas) {

                //Condicional para determinar si el valor de la variable local "id" es igual al valor de la variable de instancia del objeto "p"
                if (p.getId() == id) {
                    personaEditar = p; //Asigna el objeto "p" al objeto "personaEditar"
                }
            }

            //Crea el objeto "ventana" de la clase "AgregarEditarPasajero" y lo inicializa mediante el método constructor "AgregarEditarPasajero"
            AgregarEditarPasajero ventana = new AgregarEditarPasajero(this, true, personaEditar, opcionEditarAgregar);

            //Hace visible el objeto "ventana"
            ventana.setVisible(true);

            //Ejecuta el método "cargarDatos"
            this.cargarDatos(ConsulNomb, this.txtConsulta.getText());

        } else {

            //Muestra mensaje en pantalla para indicar que no se seleccionó ninguna fila
            JOptionPane.showMessageDialog(this,
                    "No hay filas seleccionadas",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_mitEditarActionPerformed

    private void mnuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSalirMouseClicked

        try {
            //Ejecuta el método para escribir un fichero de autoguardardo al salir del programa para evitar perdida de información en caso de que el usuario olvide guardar al salir
            MetodosSueltos.escribirPasajeros(personas, "pasajerosAutoGuardado.txt");
        } catch (IOException ex) {
        }

        //Cierra la ventana y finaliza el programa
        System.exit(0);
    }//GEN-LAST:event_mnuSalirMouseClicked

    private void mitAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitAgregarActionPerformed

        opcionEditarAgregar = false; //Asigna un valor de "false" a la variable de instancia "opcionEditarAgregar"

        //Crea el objeto "p" de la clase "Descuentos" para tener acceso a los métodos de la clase "Descuentos"
        Descuentos p = new Descuentos();

        //Condicional para restringir la cantidad de personas que se pueden ingresar al máximo de capacidad de ambos vuelos que sería de 40 personas
        if (p.getId() <= MAX_PERSONAS) {

            /* Crea el objeto ventana para mostrar el JDialog AgregarEditarPasajero, y se indica "this" para hacer referencia al padre y "true" para indicar que es modal
            en otras palabras que no permite hacer nada más hasta que se cierre la ventana.*/
            AgregarEditarPasajero ventana = new AgregarEditarPasajero(this, true, opcionEditarAgregar);

            //Hace visible el objeto ventana
            ventana.setVisible(true);

            //Ejecuta el método "cargarDatos"
            this.cargarDatos(ConsulNomb, this.txtConsulta.getText());
        } else {

            //Muestra mensaje en pantalla para indicar que no se puede agregar más pasajeros
            JOptionPane.showMessageDialog(this,
                    "No se puede agregar más pasajeros!",
                    "Alto",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_mitAgregarActionPerformed

    private void txtConsultaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultaKeyReleased

        //Condicional para ejecutar la consulta seleccionada por el usuario con base en la información que ingrese cuando se libere la tecla
        if (rdbConsulNomb.isSelected()) {
            this.cargarDatos(ConsulNomb, this.txtConsulta.getText()); //Se ejecuta el método "cargarDatos" para mostrar los resultados de la consulta 
        }

        //Condicional para ejecutar la consulta seleccionada por el usuario con base en la información que ingrese cuando se libere la tecla
        if (rdbConsulNumVuel.isSelected()) {
            this.cargarDatos(ConsulVuelo, this.txtConsulta.getText()); //Se ejecuta el método "cargarDatos" para mostrar los resultados de la consulta 
        }
    }//GEN-LAST:event_txtConsultaKeyReleased

    private void rdbConsulNombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbConsulNombActionPerformed

        //Condicional para modificar el label que describe el tipo de información que debe ingresar el usuario para realizar la consulta
        if (rdbConsulNomb.isSelected()) {
            lblConsulta.setText("Introduzca el nombre del pasajero a consultar:"); //Establece el string que mostrará el label según el tipo de consulta seleccionada
        }
    }//GEN-LAST:event_rdbConsulNombActionPerformed

    private void rdbConsulNumVuelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbConsulNumVuelActionPerformed

        //Condicional para modificar el label que describe el tipo de información que debe ingresar el usuario para realizar la consulta
        if (rdbConsulNumVuel.isSelected()) {
            lblConsulta.setText("Introduzca el número de vuelo a consultar:"); //Establece el string que mostrará el label según el tipo de consulta seleccionada
        }
    }//GEN-LAST:event_rdbConsulNumVuelActionPerformed

    private void txtConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsultaActionPerformed

    }//GEN-LAST:event_txtConsultaActionPerformed

    private void txtConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtConsultaMouseClicked

    }//GEN-LAST:event_txtConsultaMouseClicked

    private void txtConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConsultaKeyPressed

    private void mitAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitAbrirActionPerformed
        //Definición de variables locales
        int contador = 0;

        //Se crea el objeto JFileChooser
        JFileChooser fc = new JFileChooser();

        //Se crea el filtro
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");

        //Se le indica el filtro
        fc.setFileFilter(filtro);

        //Se abre la ventana y se guarda la opcion seleccionada por el usuario
        int seleccion = fc.showOpenDialog(this);

        //Si el usuario selecciona aceptar
        if (seleccion == JFileChooser.APPROVE_OPTION) {

            //Se selecciona el fichero
            File fichero = fc.getSelectedFile();

            //Obtiene la ruta del fichero y la asigna a variable "ruta"
            String ruta = fichero.getAbsolutePath();

            //Ejecuta el método para leer el fichero
            MetodosSueltos.leerPasajeros(ruta);

            //Recorre el arraylist "personas" para contar con cuantos registros inicia despues de acrgar el fichero
            for (Descuentos d : personas) {
                ++contador; //Contador de registros
            }

            //Condicional que se ejecuta en caso de que el contador sea cero
            if (contador == 0) {

            } else {
                //Crea un objeto Persona y lo asigna a la variable "p" y lo inicializa con el constructor que recibe un entero, utilizando como entero el contador de registros
                Persona p = new Persona(contador);
            }

            //Ejecuta el método para cargar los datos en la tabla
            this.cargarDatos(ConsulNomb, this.txtConsulta.getText()); //Ejecuta el método "cargarDatos"       
        }
    }//GEN-LAST:event_mitAbrirActionPerformed

    private void mitGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitGuardarActionPerformed
        //Se crea el objeto JFileChooser
        JFileChooser fc = new JFileChooser();

        //Se crea el filtro
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");

        //Se le indica el filtro
        fc.setFileFilter(filtro);

        //Se abre la ventana, se guarda la opcion seleccionada porm el usuario
        int seleccion = fc.showSaveDialog(this);

        //Si el usuario, pincha en aceptar
        if (seleccion == JFileChooser.APPROVE_OPTION) {

            //Se selecciona el fichero
            File fichero = fc.getSelectedFile();

            //Obtiene la ruta del fichero y lo asigna a la variable local "ruta"
            String ruta = fichero.getAbsolutePath();

            try {
                //Se ejecuta el método para escribir un fichero con la información indicada por el usuario
                MetodosSueltos.escribirPasajeros(personas, ruta);
            } catch (IOException ex) {
            }
        }
    }//GEN-LAST:event_mitGuardarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgConsultas;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblConsulta;
    private javax.swing.JMenuItem mitAbrir;
    private javax.swing.JMenuItem mitAgregar;
    private javax.swing.JMenuItem mitEditar;
    private javax.swing.JMenuItem mitGuardar;
    private javax.swing.JMenu mnuArchivos;
    private javax.swing.JMenu mnuGestionPasajeros;
    private javax.swing.JMenu mnuSalir;
    private javax.swing.JRadioButton rdbConsulNomb;
    private javax.swing.JRadioButton rdbConsulNumVuel;
    private javax.swing.JTable tbPasajeros;
    private javax.swing.JTextField txtConsulta;
    // End of variables declaration//GEN-END:variables
}
