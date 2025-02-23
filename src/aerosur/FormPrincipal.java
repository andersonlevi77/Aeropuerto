package aerosur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anderson
 */
public class FormPrincipal extends javax.swing.JFrame {

    public FormPrincipal() {
        initComponents();
   
        
        // Agregar los nombres de las líneas aéreas al JComboBox
        cbxaerea.addItem("Aerovías");
        cbxaerea.addItem("Aeromar");
        cbxaerea.addItem("Volaris");

       
        jdsalida.setDateFormatString("dd/MM/yyyy");
        jdsalida.setFont(new java.awt.Font("Roboto", 1, 14));

        jdingreso.setDateFormatString("dd/MM/yyyy");
        jdingreso.setFont(new java.awt.Font("Roboto", 1, 14));

    }
            // Método para limpiar los campos después de guardar
private void limpiarCampos() {
    txtnovuelo.setText("");
    txtorigen.setText("");
    txtdestino.setText("");
    cbxaerea.setSelectedIndex(0);
    jdsalida.setDate(null);
    jdingreso.setDate(null);

    // Limpiar las tablas de tripulación y pasajeros
    ((DefaultTableModel) tbltripulacion.getModel()).setRowCount(0);
    ((DefaultTableModel) tblpasajeros.getModel()).setRowCount(0);

    // Limpiar los campos de cantidad de tripulación y pasajeros
    txttripulacion.setText("");
    txtpasajeros.setText("");
}
private boolean verificarPasaporteDuplicadoEnTabla(String pasaporte, String nombre, javax.swing.JTable tabla) {
    DefaultTableModel model = (DefaultTableModel) tabla.getModel();
    
    for (int i = 0; i < model.getRowCount(); i++) {
        String pasaporteEnTabla = model.getValueAt(i, 0) != null ? model.getValueAt(i, 0).toString().trim() : "";
        String nombreEnTabla = model.getValueAt(i, 1) != null ? model.getValueAt(i, 1).toString().trim() : "";
        
        if (pasaporte.equals(pasaporteEnTabla)) {
            // Si el pasaporte ya existe, verifica que el nombre coincida
            if (!nombre.equals(nombreEnTabla)) {
                // Si el nombre no coincide, muestra error de duplicado con nombre diferente
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "El pasaporte " + pasaporte + " ya está registrado con un nombre diferente.", 
                    "Error de Duplicado", javax.swing.JOptionPane.ERROR_MESSAGE);
                return true; // Indica que hay un duplicado con nombre diferente
            } else {
                // Si el pasaporte y el nombre coinciden, está correcto (la persona puede estar varias veces)
                return false; // No es un duplicado conflictivo
            }
        }
    }
    return false; // No se encontró ningún duplicado conflictivo
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jdingreso = new com.toedter.calendar.JDateChooser();
        txtorigen = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbxaerea = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jdsalida = new com.toedter.calendar.JDateChooser();
        txtdestino = new javax.swing.JTextField();
        txtnovuelo = new javax.swing.JTextField();
        btnvuelos = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btntripulacion = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txttripulacion = new javax.swing.JTextField();
        btnpasajeros = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpasajeros = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbltripulacion = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtpasajeros = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AeroSur");
        setBackground(new java.awt.Color(1, 81, 154));
        setForeground(new java.awt.Color(52, 90, 187));
        setName("frmPrincipal"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 0, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(29, 73, 122));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 50)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRAR");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 280, -1));
        jPanel2.add(jdingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 185, -1));

        txtorigen.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        txtorigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtorigenActionPerformed(evt);
            }
        });
        jPanel2.add(txtorigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 185, -1));

        jLabel7.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha  de Ingreso");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Origen");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 56, -1));

        cbxaerea.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jPanel2.add(cbxaerea, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 185, -1));

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Línea Aérea");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("No. Vuelo");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 73, -1));

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Destino");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 73, -1));

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha de Salida");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, -1, -1));
        jPanel2.add(jdsalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 185, -1));

        txtdestino.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        txtdestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdestinoActionPerformed(evt);
            }
        });
        jPanel2.add(txtdestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 185, -1));

        txtnovuelo.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jPanel2.add(txtnovuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, 185, -1));

        btnvuelos.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnvuelos.setForeground(new java.awt.Color(255, 255, 255));
        btnvuelos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-aterrizaje-70.png"))); // NOI18N
        btnvuelos.setText("VER VUELOS");
        btnvuelos.setBorderPainted(false);
        btnvuelos.setContentAreaFilled(false);
        btnvuelos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnvuelos.setFocusPainted(false);
        btnvuelos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnvuelos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-aterrizaje-80.png"))); // NOI18N
        btnvuelos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-aterrizaje-70.png"))); // NOI18N
        btnvuelos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-avión-70.png"))); // NOI18N
        btnvuelos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnvuelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvuelosActionPerformed(evt);
            }
        });
        jPanel2.add(btnvuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, 120, 140));

        btnguardar.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-add-bookmark-90(1).png"))); // NOI18N
        btnguardar.setText("GUARDAR");
        btnguardar.setBorderPainted(false);
        btnguardar.setContentAreaFilled(false);
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar.setFocusPainted(false);
        btnguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-add-bookmark-100.png"))); // NOI18N
        btnguardar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-add-bookmark-90(1).png"))); // NOI18N
        btnguardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 680, 130, 140));

        btntripulacion.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btntripulacion.setForeground(new java.awt.Color(255, 255, 255));
        btntripulacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-crear-30.png"))); // NOI18N
        btntripulacion.setText("CREAR");
        btntripulacion.setAlignmentX(0.5F);
        btntripulacion.setBorderPainted(false);
        btntripulacion.setContentAreaFilled(false);
        btntripulacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btntripulacion.setDefaultCapable(false);
        btntripulacion.setFocusPainted(false);
        btntripulacion.setFocusable(false);
        btntripulacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btntripulacion.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btntripulacion.setRequestFocusEnabled(false);
        btntripulacion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-crear-40.png"))); // NOI18N
        btntripulacion.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-crear-30.png"))); // NOI18N
        btntripulacion.setVerifyInputWhenFocusTarget(false);
        btntripulacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btntripulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntripulacionActionPerformed(evt);
            }
        });
        jPanel2.add(btntripulacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 430, 90, 60));

        jLabel11.setFont(new java.awt.Font("Poppins", 1, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cantidad a Ingresar");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 360, 104, 30));

        txttripulacion.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        txttripulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttripulacionActionPerformed(evt);
            }
        });
        jPanel2.add(txttripulacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 390, 60, 29));

        btnpasajeros.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btnpasajeros.setForeground(new java.awt.Color(255, 255, 255));
        btnpasajeros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-crear-30.png"))); // NOI18N
        btnpasajeros.setText("CREAR");
        btnpasajeros.setBorderPainted(false);
        btnpasajeros.setContentAreaFilled(false);
        btnpasajeros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnpasajeros.setDefaultCapable(false);
        btnpasajeros.setFocusPainted(false);
        btnpasajeros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnpasajeros.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-crear-40.png"))); // NOI18N
        btnpasajeros.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-crear-30.png"))); // NOI18N
        btnpasajeros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnpasajeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpasajerosActionPerformed(evt);
            }
        });
        jPanel2.add(btnpasajeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 600, 100, 60));

        tblpasajeros.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tblpasajeros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NOMBRES", "APELLIDOS", "NACIONALIDAD", "ASIENTO", "PASAPORTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblpasajeros);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, 756, 140));

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TRIPULACIÓN");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 145, -1));

        tbltripulacion.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tbltripulacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PASAPORTE", "NOMBRE", "NACIONALIDAD", "PUESTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbltripulacion);
        if (tbltripulacion.getColumnModel().getColumnCount() > 0) {
            tbltripulacion.getColumnModel().getColumn(0).setResizable(false);
            tbltripulacion.getColumnModel().getColumn(1).setResizable(false);
            tbltripulacion.getColumnModel().getColumn(2).setResizable(false);
            tbltripulacion.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 759, 116));

        jLabel9.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("PASAJEROS");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, -1, -1));

        jLabel10.setFont(new java.awt.Font("Poppins", 1, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cantidad a Ingresar");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 530, 104, 30));

        txtpasajeros.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jPanel2.add(txtpasajeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 560, 60, 31));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 860));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdestinoActionPerformed

    private void txtorigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtorigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtorigenActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
      // Crear una instancia de Vuelo
    Vuelo vuelo = new Vuelo();
    VueloDAO vueloDAO = new VueloDAO();
    vuelo.setNumeroVuelo(txtnovuelo.getText().trim());
    vuelo.setLineaAerea(cbxaerea.getSelectedItem() != null ? cbxaerea.getSelectedItem().toString() : "");
    vuelo.setOrigen(txtorigen.getText().trim());
    vuelo.setDestino(txtdestino.getText().trim());
    vuelo.setFechaSalida(jdsalida.getDate() != null ? jdsalida.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime() : null);
    vuelo.setFechaIngreso(jdingreso.getDate() != null ? jdingreso.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime() : null);

    // Validar que los campos esenciales del vuelo no estén vacíos
    if (vuelo.getNumeroVuelo().isEmpty() || vuelo.getOrigen().isEmpty() || vuelo.getDestino().isEmpty() || vuelo.getFechaSalida() == null || vuelo.getFechaIngreso() == null) {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor complete todos los campos obligatorios del vuelo.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }
for (int i = 0; i < tbltripulacion.getRowCount(); i++) {
    String pasaporte = tbltripulacion.getValueAt(i, 0) != null ? tbltripulacion.getValueAt(i, 0).toString().trim() : "";
    String nombre = tbltripulacion.getValueAt(i, 1) != null ? tbltripulacion.getValueAt(i, 1).toString().trim() : "";
    
    // Usar el método específico para tripulación
    if (!vueloDAO.verificarPasaporteConNombreTripulacion(pasaporte, nombre)) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "El pasaporte " + pasaporte + " ya está registrado en la base de datos con un nombre diferente en tripulación.", 
            "Error de Duplicado", javax.swing.JOptionPane.ERROR_MESSAGE);
        return; // Detener si hay un conflicto
    }
}

// Verificación para pasajeros
for (int i = 0; i < tblpasajeros.getRowCount(); i++) {
    String pasaporte = tblpasajeros.getValueAt(i, 4) != null ? tblpasajeros.getValueAt(i, 4).toString().trim() : "";
    String nombre = tblpasajeros.getValueAt(i, 0) != null ? tblpasajeros.getValueAt(i, 0).toString().trim() : "";
    
    // Usar el método específico para pasajeros
    if (!vueloDAO.verificarPasaporteConNombrePasajeros(pasaporte, nombre)) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "El pasaporte " + pasaporte + " ya está registrado en la base de datos con un nombre diferente en pasajeros.", 
            "Error de Duplicado", javax.swing.JOptionPane.ERROR_MESSAGE);
        return; // Detener si hay un conflicto
    }
}
    List<Tripulante> tripulacion = new ArrayList<>();
    for (int i = 0; i < tbltripulacion.getRowCount(); i++) {
        String pasaporte = tbltripulacion.getValueAt(i, 0) != null ? tbltripulacion.getValueAt(i, 0).toString().trim() : "";
        String nombre = tbltripulacion.getValueAt(i, 1) != null ? tbltripulacion.getValueAt(i, 1).toString().trim() : "";
        String nacionalidad = tbltripulacion.getValueAt(i, 2) != null ? tbltripulacion.getValueAt(i, 2).toString().trim() : "";
        String puesto = tbltripulacion.getValueAt(i, 3) != null ? tbltripulacion.getValueAt(i, 3).toString().trim() : "";

        if (!pasaporte.isEmpty() && !nombre.isEmpty()) {
            Tripulante tripulante = new Tripulante();
            tripulante.setPasaporte(pasaporte);
            tripulante.setNombre(nombre);
            tripulante.setNacionalidad(nacionalidad);
            tripulante.setPuesto(puesto);
            
            // Verificar si el pasaporte ya existe en la base de datos
            if (vueloDAO.verificarPasaporteExistente(pasaporte)) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "El pasaporte " + pasaporte + " ya está registrado en la base de datos.", 
                    "Error de Duplicado", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            tripulacion.add(tripulante);
        } else if (!pasaporte.isEmpty() || !nombre.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Complete todos los campos obligatorios en la fila de tripulación.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    vuelo.setTripulacion(tripulacion);

    // Crear una lista de pasajeros al inicio del método
List<Pasajero> pasajeros = new ArrayList<>();

// Verificar duplicados en pasajeros
for (int i = 0; i < tblpasajeros.getRowCount(); i++) {
    String nombre = tblpasajeros.getValueAt(i, 0) != null ? tblpasajeros.getValueAt(i, 0).toString().trim() : "";
    String apellido = tblpasajeros.getValueAt(i, 1) != null ? tblpasajeros.getValueAt(i, 1).toString().trim() : "";
    String nacionalidad = tblpasajeros.getValueAt(i, 2) != null ? tblpasajeros.getValueAt(i, 2).toString().trim() : "";
    String pasaporte = tblpasajeros.getValueAt(i, 4) != null ? tblpasajeros.getValueAt(i, 4).toString().trim() : "";

    // Verificar que el campo de asiento es un número válido
    String asientoStr = tblpasajeros.getValueAt(i, 3) != null ? tblpasajeros.getValueAt(i, 3).toString().trim() : "";
    int asiento;
    try {
        asiento = Integer.parseInt(asientoStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido en el campo de Asiento para el pasajero " + nombre + " " + apellido + ".", "Error en Asiento", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Verificar que el número de asiento esté dentro del rango permitido
    if (asiento < 1 || asiento > 300) {
        JOptionPane.showMessageDialog(this, "El número de asiento debe estar entre 1 y 300 para el pasajero " + nombre + " " + apellido + ".", "Asiento fuera de rango", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Crear el objeto Pasajero solo si todas las validaciones pasan
    if (!pasaporte.isEmpty() && !nombre.isEmpty()) {
        Pasajero pasajero = new Pasajero();
        pasajero.setPasaporte(pasaporte);
        pasajero.setNombre(nombre);
        pasajero.setApellido(apellido);
        pasajero.setNacionalidad(nacionalidad);
        pasajero.setAsiento(asiento);
        
        // Añadir pasajero a la lista
        pasajeros.add(pasajero);
    } else if (!pasaporte.isEmpty() || !nombre.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Complete todos los campos obligatorios en la fila de pasajeros.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
}
vuelo.setPasajeros(pasajeros);

    // Guardar el vuelo en la base de datos
    vueloDAO.guardarVuelo(vuelo);

    // Mostrar mensaje de éxito
    javax.swing.JOptionPane.showMessageDialog(this, "Vuelo guardado exitosamente.", "Confirmación", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    
    // Limpiar los campos después de guardar
    limpiarCampos();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnvuelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvuelosActionPerformed
        frmVuelos formv = new frmVuelos();
        // Hacer visible el formulario
        formv.setVisible(true);
        
        // Centrar el formulario en la pantalla
        formv.setLocationRelativeTo(null);
        
        formv.setVisible(true);  // Hace visible el formulario
        
        // Cerrar el formulario actual (FormPrincipal)
        this.dispose();
        
        
    }//GEN-LAST:event_btnvuelosActionPerformed

    private void txttripulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttripulacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttripulacionActionPerformed

    private void btntripulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntripulacionActionPerformed
      // Obtener la cantidad de tripulantes del campo de texto
    int cantidadTripulacion;
    try {
        cantidadTripulacion = Integer.parseInt(txttripulacion.getText());
        if (cantidadTripulacion <= 0) {
            throw new NumberFormatException("La cantidad debe ser mayor a 0.");
        }
    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, ingrese una cantidad válida para la tripulación.", 
                "Entrada inválida", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Configurar la tabla de tripulación con la cantidad de filas ingresadas y columnas adecuadas
    javax.swing.table.DefaultTableModel modelTripulacion = new javax.swing.table.DefaultTableModel(
            new Object[cantidadTripulacion][4], // Número de filas
            new String[] { "PASAPORTE", "NOMBRE", "NACIONALIDAD", "PUESTO" }
    );
    tbltripulacion.setModel(modelTripulacion);
    }//GEN-LAST:event_btntripulacionActionPerformed

    private void btnpasajerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpasajerosActionPerformed
   // Obtener la cantidad de pasajeros del campo de texto
    int cantidadPasajeros;
    try {
        cantidadPasajeros = Integer.parseInt(txtpasajeros.getText());
        if (cantidadPasajeros <= 0) {
            throw new NumberFormatException("La cantidad debe ser mayor a 0.");
        }
    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, ingrese una cantidad válida para los pasajeros.", 
                "Entrada inválida", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Configurar la tabla de pasajeros con la cantidad de filas ingresadas y columnas adecuadas
    javax.swing.table.DefaultTableModel modelPasajeros = new javax.swing.table.DefaultTableModel(
            new Object[cantidadPasajeros][5], // Número de filas
            new String[] { "NOMBRES", "APELLIDOS", "NACIONALIDAD", "ASIENTO", "PASAPORTE" }
    );
    tblpasajeros.setModel(modelPasajeros);
    }//GEN-LAST:event_btnpasajerosActionPerformed

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
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnpasajeros;
    private javax.swing.JButton btntripulacion;
    private javax.swing.JButton btnvuelos;
    private javax.swing.JComboBox<String> cbxaerea;
    private com.toedter.calendar.JDateChooser jDateChooser1;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdingreso;
    private com.toedter.calendar.JDateChooser jdsalida;
    private javax.swing.JTable tblpasajeros;
    private javax.swing.JTable tbltripulacion;
    private javax.swing.JTextField txtdestino;
    private javax.swing.JTextField txtnovuelo;
    private javax.swing.JTextField txtorigen;
    private javax.swing.JTextField txtpasajeros;
    private javax.swing.JTextField txttripulacion;
    // End of variables declaration//GEN-END:variables
}
