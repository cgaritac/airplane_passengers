package registroPasajeros;

//Importación de los paquetes que manejan diferentes funciones del programa como el manejo de excepciones 
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static registroPasajeros.VariablesGobales.personas;

//Clase "AgregarEditarPasajero" para desarrollar el el formulario de agregar o editar pasajeros de forma gráfica para la interfaz de usuario
public class AgregarEditarPasajero extends javax.swing.JDialog {

    //Declaración de las variables de instancia
    private Descuentos personaEditar;
    private boolean opcion, canjeado = false;
    private String edad;
    private Validaciones validar = new Validaciones();  //Crea un objeto "Validaciones" y lo asigna a "validar" para poder tener acceso a los métodos de la clase Validaciones

    //Constructor 
    public AgregarEditarPasajero() {
    }

    //Constructor para la opción de agregar persona
    public AgregarEditarPasajero(java.awt.Frame parent, boolean modal, boolean opcion) {
        super(parent, modal); //Llamado al constructor de la clase padre
        initComponents(); //Carga todo los objetos que halla en el JFrame       
        this.setLocationRelativeTo(null); //Posiciona el JFrame en el centro de la pantalla

        //Asignación de radioButtons a un buttonGroup
        this.buttonGroup1.add(this.rdbMasc);
        this.buttonGroup1.add(this.rdbFem);

        //Asignación de radioButtons a un buttonGroup
        this.buttonGroup2.add(this.rdbNCA);
        this.buttonGroup2.add(this.rdbPNA);

        //Asignación de radioButtons a un buttonGroup
        this.buttonGroup3.add(this.rdbPermNo);
        this.buttonGroup3.add(this.rdbPermSi);

        //Asignación de radioButtons a un buttonGroup
        this.buttonGroup4.add(this.rdbCCSS);
        this.buttonGroup4.add(this.rdbMagNac);

        //Asignación de radioButtons a un buttonGroup
        this.buttonGroup5.add(this.rdbPremium);
        this.buttonGroup5.add(this.rdbPlatinum);
        this.buttonGroup5.add(this.rdbNinguna);

        //Asignación de radioButtons a un buttonGroup
        this.buttonGroup6.add(this.rdbEnProceso);
        this.buttonGroup6.add(this.rdbCompletado);

        //Asignación de radioButtons a un buttonGroup
        this.buttonGroup7.add(this.rdbPuntos);
        this.buttonGroup7.add(this.rdbNormal);

        //Desactiva varios radioButttons, text Fields y labels
        this.rdbPermSi.setEnabled(false);
        this.rdbPermNo.setEnabled(false);
        this.txtNombreEncargado.setEnabled(false);
        this.lblNombEncarg.setEnabled(false);
        this.lblPermiso.setEnabled(false);

        this.rdbCCSS.setEnabled(false);
        this.rdbMagNac.setEnabled(false);
        this.lblRegimenDat.setEnabled(false);
        this.rdbPuntos.setEnabled(false);
        this.rdbNormal.setEnabled(false);
        this.lbltipoPago.setEnabled(false);
        this.lblCantVuelos.setEnabled(false);
        this.lblPuntAcum.setEnabled(false);
        this.lblPuntCanj.setEnabled(false);
        this.lblPuntDisp.setEnabled(false);
        this.txtCantVuelos.setEnabled(false);
        this.txtPuntosAcum.setEnabled(false);
        this.txtPuntosCanjea.setEnabled(false);
        this.txtPuntosDisp.setEnabled(false);
        this.btnCanjPuntosDat.setEnabled(false);
        this.btnConsultPuntosDat.setEnabled(false);

        this.opcion = opcion; //Asigna el valor ingresado en el constructor a la variable de instancia
    }

    //Constructor para la opción de editar persona
    public AgregarEditarPasajero(java.awt.Frame parent, boolean modal, Descuentos personaEditar, boolean opcion) {
        super(parent, modal); //Llamado al constructor de la clase padre
        initComponents(); //Carga todo los objetos que halla en el JFrame            
        this.setLocationRelativeTo(null); //Posiciona el JFrame en el centro de la pantalla

        //Asignación de radioButtons a un buttonGroup
        this.buttonGroup1.add(this.rdbMasc);
        this.buttonGroup1.add(this.rdbFem);

        //Asignación de radioButtons a un buttonGroup
        this.buttonGroup2.add(this.rdbNCA);
        this.buttonGroup2.add(this.rdbPNA);

        //Asignación de radioButtons a un buttonGroup
        this.buttonGroup3.add(this.rdbPermNo);
        this.buttonGroup3.add(this.rdbPermSi);

        //Asignación de radioButtons a un buttonGroup
        this.buttonGroup4.add(this.rdbCCSS);
        this.buttonGroup4.add(this.rdbMagNac);

        //Asignación de radioButtons a un buttonGroup
        this.buttonGroup5.add(this.rdbPremium);
        this.buttonGroup5.add(this.rdbPlatinum);
        this.buttonGroup5.add(this.rdbNinguna);

        //Asignación de radioButtons a un buttonGroup
        this.buttonGroup6.add(this.rdbEnProceso);
        this.buttonGroup6.add(this.rdbCompletado);

        //Asignación de radioButtons a un buttonGroup
        this.buttonGroup7.add(this.rdbPuntos);
        this.buttonGroup7.add(this.rdbNormal);

        this.rdbPuntos.setEnabled(false);
        this.rdbNormal.setEnabled(false);
        this.lbltipoPago.setEnabled(false);
        this.lblCantVuelos.setEnabled(false);
        this.lblPuntAcum.setEnabled(false);
        this.lblPuntCanj.setEnabled(false);
        this.lblPuntDisp.setEnabled(false);
        this.txtCantVuelos.setEnabled(false);
        this.txtPuntosAcum.setEnabled(false);
        this.txtPuntosCanjea.setEnabled(false);
        this.txtPuntosDisp.setEnabled(false);
        this.btnCanjPuntosDat.setEnabled(false);

        this.personaEditar = personaEditar; //Asigna el valor ingresado en el constructor a la variable de instancia

        this.opcion = opcion; //Asigna el valor ingresado en el constructor a la variable de instancia

        cargarDatos(); //Ejecuta el método
        
        //this.btnConsultPuntosDat.setEnabled(true);
    }

    //Método para cargar los datos del objeto personaEditar al formulario
    private void cargarDatos() {

        //Asignación de valores de cada variable de instancia del objeto personaEditar a las diferentes opciones del formulario
        this.txtNombreDat.setText(this.personaEditar.getNombre());
        this.txtApellidoDat.setText(this.personaEditar.getApellido());
        this.txtEdadDat.setText(this.personaEditar.getEdad());
        this.txtNumPassDat.setText(this.personaEditar.getPasaporte());
        this.txtNombreEncargado.setText(this.personaEditar.getNombreEncargado());
        this.txtNumAsientoDat.setText(this.personaEditar.getNumAsiento());

        //Obtiene y convierte el valor de "edad" del objeto personaEditar y lo asigna a la variable local "edadNum"
        int edadNum = Integer.parseInt(this.personaEditar.getEdad());

        //Condicional para activar y desactivar varios radioButtons, text fields y labels según el rango de edades del pasajero
        if (edadNum < 14 && edadNum >= 0) {

            //Activa y desactiva varios radioButttons, text Fields y labels
            this.rdbPermSi.setEnabled(true);
            this.rdbPermNo.setEnabled(true);
            this.txtNombreEncargado.setEnabled(true);
            this.lblNombEncarg.setEnabled(true);
            this.lblPermiso.setEnabled(true);

            this.rdbCCSS.setEnabled(false);
            this.rdbMagNac.setEnabled(false);
            this.lblRegimenDat.setEnabled(false);

        } else if (edadNum > 65) {

            //Activa y desactiva varios radioButttons, text Fields y labels
            this.rdbPermSi.setEnabled(false);
            this.rdbPermNo.setEnabled(false);
            this.txtNombreEncargado.setEnabled(false);
            this.lblNombEncarg.setEnabled(false);
            this.lblPermiso.setEnabled(false);

            this.rdbCCSS.setEnabled(true);
            this.rdbMagNac.setEnabled(true);
            this.lblRegimenDat.setEnabled(true);
        } else {

            //Desactiva varios radioButttons, text Fields y labels
            this.rdbPermSi.setEnabled(false);
            this.rdbPermNo.setEnabled(false);
            this.txtNombreEncargado.setEnabled(false);
            this.lblNombEncarg.setEnabled(false);
            this.lblPermiso.setEnabled(false);

            this.rdbCCSS.setEnabled(false);
            this.rdbMagNac.setEnabled(false);
            this.lblRegimenDat.setEnabled(false);
        }

        /*Condicional que compara el valor de la variable de instancia "Regimen" del objeto personaEditar con un string definido para
        activar o desactivar varios radioButtons*/
        switch (this.personaEditar.getRegimen()) {
            case "CCSS":
                this.rdbCCSS.setSelected(true);
                break;
            case "Magisterio Nacional":
                rdbMagNac.setSelected(true);
                break;
            default:
                this.rdbCCSS.setSelected(false);
                this.rdbMagNac.setSelected(false);
                break;
        }

        /*Condicional que compara el valor de la variable de instancia "Genero" del objeto personaEditar con un string definido para
        activar o desactivar varios radioButtons*/
        if (this.personaEditar.getGenero().equals("Femenino")) {
            this.rdbFem.setSelected(true);
        } else {
            this.rdbMasc.setSelected(true);
        }

        /*Condicional que compara el valor de la variable de instancia "Permiso" del objeto personaEditar con un string definido para
        activar o desactivar varios radioButtons*/
        switch (this.personaEditar.getPermiso()) {
            case "Si":
                rdbPermSi.setSelected(true);
                break;
            case "No":
                this.rdbPermNo.setSelected(true);
                break;
            default:
                rdbPermSi.setSelected(false);
                this.rdbPermNo.setSelected(false);
                break;
        }

        /*Condicional que compara el valor de la variable de instancia "Destino" del objeto personaEditar con un string definido para
        activar o desactivar varios radioButtons*/
        if (this.personaEditar.getDestino().equals("Panamá")) {
            this.rdbPNA.setSelected(true);
        } else {
            this.rdbNCA.setSelected(true);
        }

        /*Condicional que compara el valor de la variable de instancia "Estado de Vuelo" del objeto personaEditar con un string definido para
        activar o desactivar varios radioButtons*/
        if (this.personaEditar.getEstadoVuelo().equals("En Proceso")) {
            this.rdbEnProceso.setSelected(true);
        } else {
            this.rdbCompletado.setSelected(true);
        }

        /*Condicional que compara el valor de la variable de instancia "Tipo de Membresía" del objeto personaEditar con un string definido para
        activar o desactivar varios radioButtons*/
        switch (this.personaEditar.getTipoMembresia()) {
            case "Premium":
                this.rdbPremium.setSelected(true);
                break;
            case "Platinum":
                this.rdbPlatinum.setSelected(true);
                break;
            default:
                this.rdbNinguna.setSelected(true);
                break;
        }

        String membresia = this.personaEditar.getTipoMembresia();

        if (membresia.equals("Premium") || membresia.equals("Platinum")) {
            this.btnConsultPuntosDat.setEnabled(true);
        } else {
            this.btnConsultPuntosDat.setEnabled(false);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        rdbCCSS = new javax.swing.JRadioButton();
        rdbMagNac = new javax.swing.JRadioButton();
        lblRegimenDat = new javax.swing.JLabel();
        lblNombEncarg = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rdbCompletado = new javax.swing.JRadioButton();
        rdbEnProceso = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtApellidoDat = new javax.swing.JTextField();
        txtEdadDat = new javax.swing.JTextField();
        txtNombreDat = new javax.swing.JTextField();
        txtNumAsientoDat = new javax.swing.JTextField();
        txtNumPassDat = new javax.swing.JTextField();
        rdbFem = new javax.swing.JRadioButton();
        rdbMasc = new javax.swing.JRadioButton();
        rdbPNA = new javax.swing.JRadioButton();
        rdbNCA = new javax.swing.JRadioButton();
        txtNombreEncargado = new javax.swing.JTextField();
        rdbPermSi = new javax.swing.JRadioButton();
        rdbPermNo = new javax.swing.JRadioButton();
        lblPermiso = new javax.swing.JLabel();
        lblCantVuelos = new javax.swing.JLabel();
        txtCantVuelos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        rdbNinguna = new javax.swing.JRadioButton();
        txtPuntosCanjea = new javax.swing.JTextField();
        lblPuntAcum = new javax.swing.JLabel();
        lblPuntCanj = new javax.swing.JLabel();
        txtPuntosDisp = new javax.swing.JTextField();
        rdbPlatinum = new javax.swing.JRadioButton();
        lblPuntDisp = new javax.swing.JLabel();
        rdbPremium = new javax.swing.JRadioButton();
        txtPuntosAcum = new javax.swing.JTextField();
        btnCanjPuntosDat = new javax.swing.JButton();
        btnAceptarDat = new javax.swing.JButton();
        btnConsultPuntosDat = new javax.swing.JButton();
        btnCancelarDat = new javax.swing.JButton();
        lblMembresia = new javax.swing.JLabel();
        lbltipoPago = new javax.swing.JLabel();
        rdbPuntos = new javax.swing.JRadioButton();
        rdbNormal = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        rdbCCSS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbCCSS.setText("CCSS");
        rdbCCSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbCCSSActionPerformed(evt);
            }
        });

        rdbMagNac.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbMagNac.setText("Magisterio Nacional");

        lblRegimenDat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblRegimenDat.setText("Régimen:");

        lblNombEncarg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombEncarg.setText("Nombre del encargado:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Destino:");

        rdbCompletado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbCompletado.setText("Completado");

        rdbEnProceso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbEnProceso.setText("En proceso");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Apellido:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Edad:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Género:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Número de Pasaporte:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Datos del vuelo");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Número de asiento (00 a 20):");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Estado del vuelo:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Datos Personales");

        txtApellidoDat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtEdadDat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEdadDat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEdadDatFocusLost(evt);
            }
        });
        txtEdadDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadDatActionPerformed(evt);
            }
        });
        txtEdadDat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEdadDatKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEdadDatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadDatKeyTyped(evt);
            }
        });

        txtNombreDat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtNumAsientoDat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtNumPassDat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNumPassDat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumPassDatKeyReleased(evt);
            }
        });

        rdbFem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbFem.setText("Femenino");

        rdbMasc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbMasc.setText("Masculino");

        rdbPNA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbPNA.setText("Panamá");

        rdbNCA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbNCA.setText("Nicaragua");

        txtNombreEncargado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombreEncargado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEncargadoActionPerformed(evt);
            }
        });

        rdbPermSi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbPermSi.setText("Si");
        rdbPermSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPermSiActionPerformed(evt);
            }
        });

        rdbPermNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbPermNo.setText("No");

        lblPermiso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPermiso.setText("Permiso ambos padres:");

        lblCantVuelos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCantVuelos.setText("Cantidad de vuelos:");

        txtCantVuelos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Membresía");

        rdbNinguna.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbNinguna.setText("Ninguna");
        rdbNinguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbNingunaActionPerformed(evt);
            }
        });

        txtPuntosCanjea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblPuntAcum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPuntAcum.setText("Puntos acumulados:");

        lblPuntCanj.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPuntCanj.setText("Puntos canjeados:");

        txtPuntosDisp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        rdbPlatinum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbPlatinum.setText("Platinum");
        rdbPlatinum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPlatinumActionPerformed(evt);
            }
        });

        lblPuntDisp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPuntDisp.setText("Puntos disponibles:");

        rdbPremium.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbPremium.setText("Premium");
        rdbPremium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPremiumActionPerformed(evt);
            }
        });

        txtPuntosAcum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnCanjPuntosDat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCanjPuntosDat.setText("Canjear Puntos");
        btnCanjPuntosDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanjPuntosDatActionPerformed(evt);
            }
        });

        btnAceptarDat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAceptarDat.setText("Aceptar");
        btnAceptarDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarDatActionPerformed(evt);
            }
        });

        btnConsultPuntosDat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnConsultPuntosDat.setText("Consulta Puntos");
        btnConsultPuntosDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultPuntosDatActionPerformed(evt);
            }
        });

        btnCancelarDat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelarDat.setText("Cancelar");
        btnCancelarDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarDatActionPerformed(evt);
            }
        });

        lblMembresia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMembresia.setText("Tipo de membresía:");

        lbltipoPago.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbltipoPago.setText("Tipo de Pago:");

        rdbPuntos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbPuntos.setText("Puntos");
        rdbPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPuntosActionPerformed(evt);
            }
        });

        rdbNormal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbNormal.setText("Normal");
        rdbNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbNormalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btnAceptarDat, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(67, 67, 67)
                            .addComponent(btnCancelarDat, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(96, 96, 96))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblMembresia)
                                .addComponent(lbltipoPago))
                            .addGap(90, 90, 90)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(rdbPuntos)
                                    .addGap(18, 18, 18)
                                    .addComponent(rdbNormal))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(rdbPremium)
                                    .addGap(18, 18, 18)
                                    .addComponent(rdbPlatinum)
                                    .addGap(18, 18, 18)
                                    .addComponent(rdbNinguna, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCantVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPuntAcum)
                                .addComponent(lblPuntCanj)
                                .addComponent(lblPuntDisp))
                            .addGap(85, 85, 85)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPuntosAcum, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCantVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPuntosDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPuntosCanjea, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(37, 37, 37)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnCanjPuntosDat, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnConsultPuntosDat)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(234, 234, 234)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumAsientoDat, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdbEnProceso)
                                    .addComponent(rdbPNA))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdbNCA)
                                    .addComponent(rdbCompletado)))
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRegimenDat, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(lblNombEncarg, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdbFem)
                                    .addComponent(rdbCCSS))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdbMagNac)
                                    .addComponent(rdbMasc)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtNumPassDat, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombreDat, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtApellidoDat, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEdadDat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombreEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdbPermSi)
                                .addGap(18, 18, 18)
                                .addComponent(rdbPermNo))
                            .addComponent(jLabel9))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumAsientoDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbPNA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdbNCA)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbEnProceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdbCompletado)
                    .addComponent(jLabel8))
                .addGap(39, 39, 39)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtEdadDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdbFem)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdbCCSS)
                            .addComponent(lblRegimenDat)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdbMasc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdbMagNac)))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumPassDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombEncarg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbPermSi)
                    .addComponent(rdbPermNo)
                    .addComponent(lblPermiso))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbPlatinum)
                    .addComponent(rdbNinguna)
                    .addComponent(rdbPremium)
                    .addComponent(lblMembresia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbPuntos)
                    .addComponent(rdbNormal)
                    .addComponent(lbltipoPago))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCantVuelos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPuntosAcum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPuntAcum)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnConsultPuntosDat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPuntosCanjea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPuntCanj))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPuntosDisp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPuntDisp)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnCanjPuntosDat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarDat)
                    .addComponent(btnCancelarDat))
                .addGap(49, 49, 49))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbNormalActionPerformed
        this.btnCanjPuntosDat.setEnabled(false);
    }//GEN-LAST:event_rdbNormalActionPerformed

    private void rdbPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPuntosActionPerformed
        this.btnCanjPuntosDat.setEnabled(true);
    }//GEN-LAST:event_rdbPuntosActionPerformed

    private void btnCancelarDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarDatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarDatActionPerformed

    private void btnConsultPuntosDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultPuntosDatActionPerformed

        if (this.canjeado == true) {

        } else {
            //Declaración de variables locales
            String errores = "";
            boolean encuentraPasajero = false;

            //Obtiene el texto y lo asigna a una variable local "pasaporte"
            String pasaporte = this.txtNumPassDat.getText();
            errores += validar.EnterosVacios(pasaporte, "número de pasaporte");
            /*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la
        variable local "errores"*/

            errores += validar.arrayListtVacio();  //Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la

            //Condicional que se ejecuta en caso de que "errores" no tenga ningún caracter
            if (errores.isEmpty()) {

                //Asigna un valor de "null" al objeto de la clase "Descuentos"
                Descuentos datosPersona = null;

                //Ciclo para recorrer un objeto p de la clase "Descuentos" del ArrayList "personas" de la clase "VariablesGlobales" para obtener los datos almacenados
                for (Descuentos p : personas) {

                    //Condicional para determinar si el valor de la variable local "Pasaporte" es igual al valor almacenado en el campo Pasaporte del objeto "p"
                    if (p.getPasaporte().equals(pasaporte)) {
                        datosPersona = p; //Asigna el objeto "p" al objeto "datosPersona"
                        ControlPuntos control = new ControlPuntos(); //Crea un objeto "ControlPuntos" y lo asigna a la variable local "control", para inicializarlo con el constructor respectivo

                        //Asignación de valores de cada variable de instancia del objeto "datosPersona" a las diferentes opciones del formulario
                        this.txtCantVuelos.setText(control.cantidadVuelos(datosPersona.getPasaporte()));
                        this.txtPuntosAcum.setText(control.puntosAcumulados(datosPersona.getPasaporte()));
                        this.txtPuntosCanjea.setText(control.puntosCanjeados(datosPersona.getPasaporte()));
                        this.txtPuntosDisp.setText(control.puntosDisponibles());

                        encuentraPasajero = true; //Asigna un valor a la variable local
                    }
                }

                //Condicional para mostrar un mensaje en pantalla en caso de que la variable local sea false
                if (encuentraPasajero == false) {
                    //Muestra un mensaje en pantalla 
                    JOptionPane.showMessageDialog(this,
                            "El pasajero no ha realizado vuelos con anterioridad",
                            "Atención",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                //Muestra un mensaje en pantalla para indicar que hay error en la información ingresada e indica cuál o cuáles son los errores
                JOptionPane.showMessageDialog(this,
                        errores,
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnConsultPuntosDatActionPerformed

    private void btnAceptarDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarDatActionPerformed

        //Condicional que se ejecuta en caso de que no haya canjeado los puntos y haya seleccionado la opción de pago con puntos
        if (this.rdbPuntos.isSelected() && canjeado == false) {
            //Muestra un mensaje en pantalla para indicar que no se pueden aplicar los puntos debido a que no hay suficientes para aplicar
            JOptionPane.showMessageDialog(this,
                    "Es necesario canjear los puntos antes de continuar, o seleccionar la opción de pago 'Normal'",
                    "Alto",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            //Declaración de variables locales
            String errores = "";
            String genero = "";
            String destino = "";
            String permiso = "";
            String regimen = "";
            String estadoVuelo = "";
            String tipoMembresia = "";
            String tipoPago = "";

            String nombre = this.txtNombreDat.getText(); //Declara la variable local y le asigna los datos del txt field respectivo
            errores += validar.StringVacios(nombre, "nombre");
            /*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la
            variable local "errores"*/

            String apellido = this.txtApellidoDat.getText(); //Declara la variable local y le asigna los datos del txt field respectivo
            errores += validar.StringVacios(apellido, "apellido");
            /*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la
            variable local "errores"*/

            edad = this.txtEdadDat.getText(); //Declara la variable local y le asigna los datos del txt field respectivo
            errores += validar.EnterosVacios(edad, "edad");
            /*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la
            variable local "errores"*/

            String numPass = this.txtNumPassDat.getText(); //Declara la variable local y le asigna los datos del txt field respectivo
            errores += validar.EnterosVacios(numPass, "número de pasaporte");
            /*Ejecuta un método del objeto "validar" y lo adiciona a la
            cadena string de la variable local "errores"*/

            String numAsiento = this.txtNumAsientoDat.getText(); //Declara la variable local y le asigna los datos del txt field respectivo
            errores += validar.EnterosVacios(numAsiento, "número de asiento");
            /*Ejecuta un método del objeto "validar" y lo adiciona a la
            cadena string de la variable local "errores"*/

            String nombreEncargado = this.txtNombreEncargado.getText(); //Declara la variable local y le asigna los datos del txt field respectivo
            try { //Prueba si existe una excepción
                //convierte el valor de la variable de instancia "edad" lo asigna a la variable local "edadNum"
                int edadNum = Integer.parseInt(edad);

                //Condicional que determina si edad está en un cierto intervalo para determinar si el pasajero ocupa permiso de los padres
                if (edadNum < 14 && edadNum >= 0) {
                    errores += validar.StringVacios(nombreEncargado, "nombre del encargado");
                    /*Ejecuta un método del objeto "validar"
                    y lo adiciona a la cadena string de la variable local "errores"*/
                    //Condicional que determina si un radioButton está seleccionado para asignar un string a una variable local
                    if (this.rdbPermNo.isSelected()) {
                        permiso = "No"; //Asigna un string a una variable local
                    } else {
                        permiso = "Si"; //Asigna un string a una variable local
                    }
                    /*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/
                    errores += validar.seleccionRadioButton(this.rdbPermNo.isSelected(), this.rdbPermSi.isSelected(), "permiso de padres");
                }

                //Condicional que determina si edad está por encima de cierto valor para asignar a variables locales un string específico
                if (edadNum >= 14) {
                    nombreEncargado = "No aplica"; //Asigna un string a una variable local
                    permiso = "No aplica"; //Asigna un string a una variable local
                }
            } catch (NumberFormatException e) //Atrapa la excepción NumberFormatException en caso de que ocurra en el bloque "Try"
            {
                //No se realiza nada.
            }

            //Condicional que determina si un radioButton está seleccionado para asignar un string a una variable local
            if (this.rdbFem.isSelected()) {
                genero = "Femenino"; //Asigna un string a una variable local
            } else {
                genero = "Masculino"; //Asigna un string a una variable local
            }
            /*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/
            errores += validar.seleccionRadioButton(this.rdbFem.isSelected(), this.rdbMasc.isSelected(), "género");

            //Condicional que determina si un radioButton está seleccionado para asignar un string a una variable local
            if (this.rdbNCA.isSelected()) {
                destino = "Nicaragua"; //Asigna un string a una variable local
            } else {
                destino = "Panamá"; //Asigna un string a una variable local
            }
            /*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/
            errores += validar.seleccionRadioButton(this.rdbNCA.isSelected(), this.rdbPNA.isSelected(), "destino");

            //Condicional que determina si un radioButton está seleccionado para asignar un string a una variable local
            if (this.rdbEnProceso.isSelected()) {
                estadoVuelo = "En Proceso"; //Asigna un string a una variable local
            } else {
                estadoVuelo = "Completado"; //Asigna un string a una variable local
            }
            /*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/
            errores += validar.seleccionRadioButton(this.rdbEnProceso.isSelected(), this.rdbCompletado.isSelected(), "Estado de Vuelo");

            //Condicional que determina si un radioButton está seleccionado para asignar un string a una variable local
            if (this.rdbPremium.isSelected()) {
                tipoMembresia = "Premium"; //Asigna un string a una variable local

                if (this.rdbPuntos.isSelected()) {
                    tipoPago = "Puntos"; //Asigna un string a una variable local
                } else {
                    tipoPago = "Normal";//Asigna un string a una variable local
                }

                if (opcion == false) {
                    /*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/
                    errores += validar.seleccionRadioButton(this.rdbPuntos.isSelected(), this.rdbNormal.isSelected(), "Tipo de Pago");
                }

            } else if (this.rdbPlatinum.isSelected()) {
                tipoMembresia = "Platinum"; //Asigna un string a una variable local

                if (this.rdbPuntos.isSelected()) {
                    tipoPago = "Puntos"; //Asigna un string a una variable local
                } else {
                    tipoPago = "Normal"; //Asigna un string a una variable local
                }

                if (opcion == false) {
                    /*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/
                    errores += validar.seleccionRadioButton(this.rdbPuntos.isSelected(), this.rdbNormal.isSelected(), "Tipo de Pago");
                }
            } else {
                tipoMembresia = "Ninguna"; //Asigna un string a una variable local
                tipoPago = "Normal";
            }
            /*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/
            errores += validar.seleccionRadioButton(this.rdbEnProceso.isSelected(), this.rdbCompletado.isSelected(), "Tipo de Membresia");

            try { //Prueba si existe una excepción
                //convierte el valor de la variable de instancia "edad" lo asigna a la variable local "edadNum"
                int edadNum = Integer.parseInt(edad);

                //Condicional que determina si edad está por encima de cierto valor para asignar a variables locales un string específico
                if (edadNum > 65) {
                    //Condicional que determina si un radioButton está seleccionado para asignar un string a una variable local
                    if (this.rdbCCSS.isSelected()) {
                        regimen = "CCSS"; //Asigna un string a una variable local
                    } else {
                        regimen = "Magisterio Nacional"; //Asigna un string a una variable local
                    }
                    /*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/
                    errores += validar.seleccionRadioButton(this.rdbCCSS.isSelected(), this.rdbMagNac.isSelected(), "régimen");
                }

                //Condicional que determina si edad está por encima de cierto valor para asignar a variables locales un string específico
                if (edadNum <= 65) {
                    regimen = "No aplica"; //Asigna un string a una variable local
                }
            } catch (NumberFormatException e) //Atrapa la excepción NumberFormatException en caso de que ocurra en el bloque "Try"
            {
                //No se realiza nada.
            }

            //Condicional para determinar si el asiento que se desea ingresar o modificar ya se encuentra ocupado
            if (opcion == true
                    && Integer.parseInt(this.personaEditar.getNumAsiento()) != Integer.parseInt(numAsiento)
                    && this.personaEditar.getDestino().equals(destino)) {
                /*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/
                errores += validar.disponibilidadAsiento(numAsiento, destino, "Asiento");
            } else if (opcion == true
                    && Integer.parseInt(this.personaEditar.getNumAsiento()) == Integer.parseInt(numAsiento)
                    && !this.personaEditar.getDestino().equals(destino)) {
                /*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/
                errores += validar.disponibilidadAsiento(numAsiento, destino, "Asiento");
            } else if (opcion == true
                    && Integer.parseInt(this.personaEditar.getNumAsiento()) != Integer.parseInt(numAsiento)
                    && !this.personaEditar.getDestino().equals(destino)) {
                /*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/
                errores += validar.disponibilidadAsiento(numAsiento, destino, "Asiento");
            } else if (opcion == false) {
                /*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/
                errores += validar.disponibilidadAsiento(numAsiento, destino, "Asiento");
            }

            //Condicional para ejecutar en caso de que no haya errores detectados en la ejecución
            if (errores.isEmpty()) {

                //convierte el valor de la variable local "numAsiento" y lo asigna a la variable local "numAsientoNum"
                int numAsientoNum = Integer.parseInt(numAsiento);

                //Condicional para asignar un 0 antes del número ingresado por el usuario en la variable numAsiento si el valor es menor a 10
                if (numAsientoNum >= 0 && numAsientoNum < 10) {
                    numAsiento = "0" + numAsientoNum; //Asignación a la variable de instancia
                } else {
                    numAsiento = Integer.toString(numAsientoNum);
                    /*Conversión a string de una variable local numérica y asignación otra variable local*/
                }

                /*Condicional para asignar los valores nuevos ingresados en la edicion, a cada variable de instancia del objeto "personaEditar"
                en caso de que se esté editando la información de algún pasajero*/
                if (this.personaEditar != null) {
                    //Editando

                    //Asignación a las variables de instancia del objeto "personaEditar"
                    this.personaEditar.setNombre(nombre);
                    this.personaEditar.setApellido(apellido);
                    this.personaEditar.setEdad(edad);
                    this.personaEditar.setRegimen(regimen);
                    this.personaEditar.setGenero(genero);
                    this.personaEditar.setPasaporte(numPass);
                    this.personaEditar.setTipoMembresia(tipoMembresia);
                    this.personaEditar.setNombreEncargado(nombreEncargado);
                    this.personaEditar.setPermiso(permiso);
                    this.personaEditar.setNumAsiento(numAsiento);
                    this.personaEditar.setDestino(destino);
                    this.personaEditar.setNumVuelo();
                    this.personaEditar.setNumTiquete();
                    this.personaEditar.setTipoPersona();
                    this.personaEditar.setDescuento();
                    this.personaEditar.setEstadoVuelo(estadoVuelo);
                    this.personaEditar.CostoFinalDesc();
                    this.personaEditar.setPuntos();
                } else {
                    //Creando

                    /*Crea un objeto "Descuentos" y lo asigna a "p" para inicializar los valores del objeto mediante la ejecución del método constructor
                    de la clase Descuentos*/
                    Descuentos p = new Descuentos(nombre, apellido, edad, genero, numPass, tipoMembresia, numAsiento, destino, permiso, nombreEncargado, regimen, estadoVuelo, tipoPago);

                    personas.add(p);  //Adiciona el objeto "p" al arraylist "personas"                  
                }

                //Muestra un mensaje en pantalla para indicar que se ingresaron los datos correctamente
                JOptionPane.showMessageDialog(this,
                        "Datos ingresados correctamente!",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);

                //Cierra la ventana del formulario de AgregarEditarPasajero
                this.dispose();

            } else {
                //Muestra un mensaje en pantalla para indicar que hay error en la información ingresada e indica cuál o cuáles son los errores
                JOptionPane.showMessageDialog(this,
                        errores,
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAceptarDatActionPerformed

    private void btnCanjPuntosDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanjPuntosDatActionPerformed

        //Condicional que se ejecuta en caso de que puntos disponibles este vacío
        if (this.txtPuntosDisp.getText().equals("")) {
            //Muestra un mensaje en pantalla 
            JOptionPane.showMessageDialog(this,
                    "Debe consultar los puntos antes de canjear",
                    "Alto",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            //Declaración de variables locales
            int puntosDisp, puntosCanj;

            //Convierte texto a número entero y lo asigna a la variable local respectiva
            puntosDisp = Integer.parseInt(this.txtPuntosDisp.getText());
            puntosCanj = Integer.parseInt(this.txtPuntosCanjea.getText());

            //Condicional que se ejecuta en caso de que los puntos disponibles sean menores a 400
            if (puntosDisp < 400) {
                //Muestra un mensaje en pantalla 
                JOptionPane.showMessageDialog(this,
                        "Puntos insuficientes",
                        "Alto",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                //Condicional que se ejecuta en caso de que se haya seleccionado el destino "Panamá" y no haya canjeado puntos aún
                if (this.rdbPNA.isSelected() && canjeado == false) {

                    //Asignación de valores a los cuadros de texto respectivos del formulario en pantalla
                    this.txtPuntosCanjea.setText(Integer.toString(puntosCanj + 400));
                    this.txtPuntosDisp.setText(Integer.toString(puntosDisp - 400));
                    this.rdbPNA.setEnabled(false);
                    this.rdbPNA.setEnabled(false);
                    this.btnCanjPuntosDat.setEnabled(false);
                    this.canjeado = true; //Asignación para registrar que se canjearon puntos

                    //Condicional que se ejecuta en caso de que se haya seleccionado el destino "Nicaragua" y no haya canjeado puntos aún
                } else if (this.rdbNCA.isSelected() && canjeado == false) {

                    //Condicional que se ejecuta en caso de que se tengan menos de 500 puntos
                    if (puntosDisp < 500) {
                        //Muestra un mensaje en pantalla 
                        JOptionPane.showMessageDialog(this,
                                "Puntos insuficientes",
                                "Alto",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        //Asignación de valores a los cuadros de texto respectivos del formulario en pantalla
                        this.txtPuntosCanjea.setText(Integer.toString(puntosCanj + 500));
                        this.txtPuntosDisp.setText(Integer.toString(puntosDisp - 500));
                        this.rdbPNA.setEnabled(false);
                        this.rdbPNA.setEnabled(false);
                        this.btnCanjPuntosDat.setEnabled(false);
                        this.canjeado = true; //Asignación para registrar que se canjearon puntos
                    }
                    //Condicional que se ejecuta en caso de que se haya seleccionado algún destino y ya se hayan canjeado los puntos    
                } else if (this.rdbPNA.isSelected() || this.rdbNCA.isSelected() && canjeado == true) {
                    //Muestra un mensaje en pantalla 
                    JOptionPane.showMessageDialog(this,
                            "Los puntos ya fueron aplicados, no es posible aplicar puntos dos veces al mismo pago",
                            "Alto",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    //Muestra un mensaje en pantalla 
                    JOptionPane.showMessageDialog(this,
                            "Debe seleccionar un destino para canjear",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnCanjPuntosDatActionPerformed

    private void rdbPremiumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPremiumActionPerformed
        //Condicional para restringir el canjeo de puntos en caso de se esté editando un pasajero, debido a que el pago ya habría sido realizado
        if (opcion == true) {
            this.btnConsultPuntosDat.setEnabled(true); //Activa solamente el botón consultar puntos
        } else {
            this.rdbPuntos.setEnabled(true);
            this.rdbNormal.setEnabled(true);
            this.lbltipoPago.setEnabled(true);
            this.lblCantVuelos.setEnabled(true);
            this.lblPuntAcum.setEnabled(true);
            this.lblPuntCanj.setEnabled(true);
            this.lblPuntDisp.setEnabled(true);
            this.btnConsultPuntosDat.setEnabled(true);
        }
    }//GEN-LAST:event_rdbPremiumActionPerformed

    private void rdbPlatinumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPlatinumActionPerformed
        //Condicional para restringir el canjeo de puntos en caso de se esté editando un pasajero, debido a que el pago ya habría sido realizado
        if (opcion == true) {
            this.btnConsultPuntosDat.setEnabled(true); //Activa solamente el botón consultar puntos
        } else {
            this.rdbPuntos.setEnabled(true);
            this.rdbNormal.setEnabled(true);
            this.lbltipoPago.setEnabled(true);
            this.lblCantVuelos.setEnabled(true);
            this.lblPuntAcum.setEnabled(true);
            this.lblPuntCanj.setEnabled(true);
            this.lblPuntDisp.setEnabled(true);
            this.btnConsultPuntosDat.setEnabled(true);
        }
    }//GEN-LAST:event_rdbPlatinumActionPerformed

    private void rdbNingunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbNingunaActionPerformed
        //Condicional para restringir el canjeo de puntos en caso de se esté editando un pasajero, debido a que el pago ya habría sido realizado    
        if (opcion == true) {
            this.btnConsultPuntosDat.setEnabled(false); //Desactiva el botón consultar puntos
        } else {
            this.rdbPuntos.setEnabled(false);
            this.rdbNormal.setEnabled(false);
            this.rdbNormal.setSelected(true);
            this.lbltipoPago.setEnabled(false);
            this.lblCantVuelos.setEnabled(false);
            this.lblPuntAcum.setEnabled(false);
            this.lblPuntCanj.setEnabled(false);
            this.lblPuntDisp.setEnabled(false);
            this.btnConsultPuntosDat.setEnabled(false);
            this.btnCanjPuntosDat.setEnabled(false);
            this.txtCantVuelos.setText("");
            this.txtPuntosAcum.setText("");
            this.txtPuntosCanjea.setText("");
            this.txtPuntosDisp.setText("");
        }
    }//GEN-LAST:event_rdbNingunaActionPerformed

    private void rdbPermSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPermSiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbPermSiActionPerformed

    private void txtNombreEncargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEncargadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEncargadoActionPerformed

    private void txtNumPassDatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumPassDatKeyReleased

    }//GEN-LAST:event_txtNumPassDatKeyReleased

    private void txtEdadDatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadDatKeyTyped

    }//GEN-LAST:event_txtEdadDatKeyTyped

    private void txtEdadDatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadDatKeyReleased

    }//GEN-LAST:event_txtEdadDatKeyReleased

    private void txtEdadDatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadDatKeyPressed

    }//GEN-LAST:event_txtEdadDatKeyPressed

    private void txtEdadDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadDatActionPerformed

    }//GEN-LAST:event_txtEdadDatActionPerformed

    private void txtEdadDatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEdadDatFocusLost
        try { //Prueba si existe una excepción

            //Obtiene la información del text field como string y lo asigna a la variable de instancia "edad"
            edad = this.txtEdadDat.getText();

            //convierte el valor de la variable de instancia "edad" lo asigna a la variable local "edadNum"
            int edadNum = Integer.parseInt(edad);

            //Condicional para activar y desactivar varios radioButtons, text fields y labels según el rango de edades del pasajero
            if (edadNum < 14 && edadNum >= 0) {

                //Activa y desactiva varios radioButttons, text Fields y labels
                this.rdbPermSi.setEnabled(true);
                this.rdbPermNo.setEnabled(true);
                this.txtNombreEncargado.setText("");
                this.txtNombreEncargado.setEnabled(true);
                this.lblNombEncarg.setEnabled(true);
                this.lblPermiso.setEnabled(true);

                this.rdbCCSS.setEnabled(false);
                this.rdbMagNac.setEnabled(false);
                this.lblRegimenDat.setEnabled(false);

            } else if (edadNum > 65) {

                //Activa y desactiva varios radioButttons, text Fields y labels
                this.rdbPermSi.setEnabled(false);
                this.rdbPermNo.setEnabled(false);
                this.txtNombreEncargado.setEnabled(false);
                this.lblNombEncarg.setEnabled(false);
                this.lblPermiso.setEnabled(false);

                this.rdbCCSS.setEnabled(true);
                this.rdbMagNac.setEnabled(true);
                this.lblRegimenDat.setEnabled(true);
            } else {

                //Desactiva varios radioButttons, text Fields y labels
                this.rdbPermSi.setEnabled(false);
                this.rdbPermNo.setEnabled(false);
                this.txtNombreEncargado.setEnabled(false);
                this.lblNombEncarg.setEnabled(false);
                this.lblPermiso.setEnabled(false);

                this.rdbCCSS.setEnabled(false);
                this.rdbMagNac.setEnabled(false);
                this.lblRegimenDat.setEnabled(false);
            }
        } catch (NumberFormatException e) //Atrapa la excepción NumberFormatException en caso de que ocurra en el bloque "Try"
        {
            //No realiza nada
        }
    }//GEN-LAST:event_txtEdadDatFocusLost

    private void rdbCCSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbCCSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbCCSSActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarDat;
    private javax.swing.JButton btnCancelarDat;
    private javax.swing.JButton btnCanjPuntosDat;
    private javax.swing.JButton btnConsultPuntosDat;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantVuelos;
    private javax.swing.JLabel lblMembresia;
    private javax.swing.JLabel lblNombEncarg;
    private javax.swing.JLabel lblPermiso;
    private javax.swing.JLabel lblPuntAcum;
    private javax.swing.JLabel lblPuntCanj;
    private javax.swing.JLabel lblPuntDisp;
    private javax.swing.JLabel lblRegimenDat;
    private javax.swing.JLabel lbltipoPago;
    private javax.swing.JRadioButton rdbCCSS;
    private javax.swing.JRadioButton rdbCompletado;
    private javax.swing.JRadioButton rdbEnProceso;
    private javax.swing.JRadioButton rdbFem;
    private javax.swing.JRadioButton rdbMagNac;
    private javax.swing.JRadioButton rdbMasc;
    private javax.swing.JRadioButton rdbNCA;
    private javax.swing.JRadioButton rdbNinguna;
    private javax.swing.JRadioButton rdbNormal;
    private javax.swing.JRadioButton rdbPNA;
    private javax.swing.JRadioButton rdbPermNo;
    private javax.swing.JRadioButton rdbPermSi;
    private javax.swing.JRadioButton rdbPlatinum;
    private javax.swing.JRadioButton rdbPremium;
    private javax.swing.JRadioButton rdbPuntos;
    private javax.swing.JTextField txtApellidoDat;
    private javax.swing.JTextField txtCantVuelos;
    private javax.swing.JTextField txtEdadDat;
    private javax.swing.JTextField txtNombreDat;
    private javax.swing.JTextField txtNombreEncargado;
    private javax.swing.JTextField txtNumAsientoDat;
    private javax.swing.JTextField txtNumPassDat;
    private javax.swing.JTextField txtPuntosAcum;
    private javax.swing.JTextField txtPuntosCanjea;
    private javax.swing.JTextField txtPuntosDisp;
    // End of variables declaration//GEN-END:variables
}
