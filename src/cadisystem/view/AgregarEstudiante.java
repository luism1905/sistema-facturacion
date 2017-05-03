/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.view;

import cadisystem.herramientas.Tools;
import cadisystem.model.DAO.EstudianteDAO;
import cadisystem.model.dto.estudiante.Estudiante;
import cadisystem.model.implement.EstudianteImp;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos
 */
public class AgregarEstudiante extends javax.swing.JDialog {

    Boolean estudianteEncontrado = false;
    Estudiante est;
    Tools tools = new Tools();

    public AgregarEstudiante(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        this.lblValorFechaRegistro.setText(String.valueOf(date.format(now)));
        btnEliminar.setVisible(false);
        tools.validarMaximoCaracteresTextfield(txtCedula, 9);
        tools.validarMaximoCaracteresTextfield(txtNombre, 20);
        tools.validarMaximoCaracteresTextfield(txtApellido, 20);
        tools.validarMaximoCaracteresTextfield(txtCorreo, 40);
        tools.validarMaximoCaracteresTextfield(txtTelefono, 11);
        tools.validarMaximoCaracteresTextfield(txtOtroTelefono, 11);
        tools.validarMaximoCaracteresTextfield(txtDireccion, 44);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnLimpiar = new javax.swing.JButton();
        txtCedula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtOtroTelefono = new javax.swing.JTextField();
        lblOtroTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblDirecion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblFechaRegistro = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblValorFechaRegistro = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblSexo = new javax.swing.JLabel();
        rbtnMasculino = new javax.swing.JRadioButton();
        rbtnFemenino = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        txtCedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCedulaFocusLost(evt);
            }
        });
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/m.png"))); // NOI18N

        lblCedula.setText("Cedula:");

        lblNombre.setText("Nombre:");

        lblApellido.setText("Apellido:");

        lblCorreo.setText("Correo Electrónico:");

        lblTelefono.setText("Teléfono:");

        txtOtroTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOtroTelefonoKeyTyped(evt);
            }
        });

        lblOtroTelefono.setText("Otro telefono:");

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        lblDirecion.setText("Dirección:");

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        lblFechaRegistro.setText("Fecha de registro:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblValorFechaRegistro.setText("XYZ");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblSexo.setText("Sexo:");

        buttonGroup1.add(rbtnMasculino);
        rbtnMasculino.setText("M");

        buttonGroup1.add(rbtnFemenino);
        rbtnFemenino.setText("F");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(lblDirecion, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCedula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNombre)
                        .addGap(29, 29, 29)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblOtroTelefono)
                        .addGap(28, 28, 28)
                        .addComponent(txtOtroTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDireccion)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(lblCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblValorFechaRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(223, 223, 223))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnMasculino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnFemenino)
                        .addGap(528, 528, 528))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCedula)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApellido)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCorreo))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefono)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOtroTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOtroTelefono)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDirecion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaRegistro)
                    .addComponent(lblValorFechaRegistro))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(rbtnMasculino)
                    .addComponent(rbtnFemenino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Datos personales", jPanel1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo-cadif1.jpg"))); // NOI18N
        jLabel2.setText("                           Estudiante");
        jLabel2.setToolTipText("");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 42, 895, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtCedula.setText("");
        txtNombre.setText("");
        txtOtroTelefono.setText("");
        txtDireccion.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        btnEliminar.setVisible(false);
        buttonGroup1.clearSelection();
//        rbtnFemenino.setSelected(false);
//        rbtnMasculino.setSelected(false);
        lblFechaRegistro.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtCedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCedulaFocusLost
        if (!"".equals(txtCedula.getText())) {

            String busqueda;
            busqueda = txtCedula.getText();

            EstudianteDAO estdao = new EstudianteImp();
            try {
                est = estdao.buscar(busqueda, est);
            } catch (Exception ex) {
                System.out.println("Error al buscar el estudiante");
                Logger.getLogger(AgregarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (est.getId() != -1) {

                estudianteEncontrado = true;
                txtCedula.setText(est.getCedula());
                txtNombre.setText(est.getNombre());
                txtOtroTelefono.setText(est.getOtroTelefono());
                txtDireccion.setText(est.getDireccion());
                txtApellido.setText(est.getApellido());
                txtTelefono.setText(est.getTelefono());
                txtCorreo.setText(est.getCorreo());
                this.setSexo(est.getSexo());
                btnEliminar.setVisible(true);
                if (est.getFecharegistro() != null) {
                    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                    this.lblValorFechaRegistro.setText(String.valueOf(date.format(est.getFecharegistro())));

                }
            } else {

                estudianteEncontrado = false;

            }
        }
    }//GEN-LAST:event_txtCedulaFocusLost

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (camposVacios()) {
            mostrarMensajeError();
        } else {

            if (estudianteEncontrado) {

                actualizarDatosEstudiante(est);

            } else {
                agregarDatosEstudiante();

            }

        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        EstudianteDAO estdaos = new EstudianteImp();
        try {
            estdaos.eliminar(est);
            String msj = "Ha eliminado al estudiante satisfactoriamente";
            JOptionPane.showMessageDialog(null, msj, "Información", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(AgregarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        tools.validarSoloNumeros(evt);
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtOtroTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOtroTelefonoKeyTyped
        tools.validarSoloNumeros(evt);
    }//GEN-LAST:event_txtOtroTelefonoKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
         tools.validarSoloNumeros(evt);
    }//GEN-LAST:event_txtTelefonoKeyTyped
    public void agregarDatosEstudiante() {
        /*
        
         public class ManejoDeFechas(){ 
         public static void main(String [] args){ 
         Este es el formato de fecha de la mayoria de paises latinos 
         String fecha1 = "12/09/2011"; 

         El metodo split de java permite dividir una cadena de String como si fuera un array
         String [] fecha2 = fecha1.split("/"; 

         Sencillamente le especificamos cual es el parametro para hacer la divicion.

         } 

         } 
        
         */

        // Date f = Date.valueOf(lblValorFechaRegistro.getText());
        Date f = new Date(System.currentTimeMillis());
        Estudiante est = new Estudiante(txtCedula.getText(), txtNombre.getText(),
                txtApellido.getText(), txtTelefono.getText(), txtDireccion.getText(),
                txtOtroTelefono.getText(), getSexo(), f, txtCorreo.getText());

        EstudianteDAO estdao = new EstudianteImp();
        try {
            estdao.insertar(est);
            String msj = "Ha guardado los datos del estudiante satisfactoriamente";
            JOptionPane.showMessageDialog(null, msj, "Información", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(AgregarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al insertar los datos");
        }

    }

    public void actualizarDatosEstudiante(Estudiante est) {

        est.setCedula(txtCedula.getText());
        est.setNombre(txtNombre.getText());
        est.setApellido(txtApellido.getText());
        est.setTelefono(txtTelefono.getText());
        est.setDireccion(txtDireccion.getText());
        est.setOtroTelefono(txtOtroTelefono.getText());
        est.setSexo(getSexo());
        est.setCorreo(txtCorreo.getText());

        EstudianteDAO estdao = new EstudianteImp();
        try {
            estdao.modificar(est);
            String msj = "Ha actualizado los datos del estudiante";
            JOptionPane.showMessageDialog(null, msj, "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(AgregarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al modificar los datos");
        }

    }

    public void mostrarMensajeError() {

        String msj;
        if (txtCedula.getText().equals("")) {
            msj = "Introduzca la cedula del Estudiante";
            JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);

        } else if (txtNombre.getText().equals("")) {
            msj = "Introduzca el nombre del Estudiante";
            JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);

        } else if (txtApellido.getText().equals("")) {
            msj = "Introduzca el apellido del Estudiante";
            JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);

        } else if (txtCorreo.getText().equals("")) {
            msj = "Introduzca la cedula del Estudiante";
            JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);

        } else if (txtDireccion.getText().equals("")) {
            msj = "Introduzca la dirección del Estudiante";
            JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);

        } else if (txtTelefono.getText().equals("")) {
            msj = "Introduzca el numero de teléfono del Estudiante";
            JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public Boolean camposVacios() {

        if (txtApellido.getText().equals("") || txtCedula.getText().equals("")
                || txtCorreo.getText().equals("") || txtDireccion.getText().equals("")
                || txtNombre.getText().equals("") || txtTelefono.getText().equals("") || txtNombre.getText().equals("")) {

            return true;
        } else {
            return false;

        }

    }

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
            java.util.logging.Logger.getLogger(AgregarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarEstudiante dialog = new AgregarEstudiante(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDirecion;
    private javax.swing.JLabel lblFechaRegistro;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblOtroTelefono;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblValorFechaRegistro;
    private javax.swing.JRadioButton rbtnFemenino;
    private javax.swing.JRadioButton rbtnMasculino;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOtroTelefono;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    private String getSexo() {

        if (rbtnMasculino.isSelected()) {
            return "M";
        } else if (rbtnFemenino.isSelected()) {
            return "F";
        } else {
            return " ";
        }

    }

    private void setSexo(String s) {

        if (s == null) {
            rbtnMasculino.setSelected(false);
            rbtnFemenino.setSelected(false);

        } else {
            if ("M".equals(s)) {
                rbtnMasculino.setSelected(true);
                rbtnFemenino.setSelected(false);
            } else if (s.equals("F")) {
                rbtnMasculino.setSelected(false);
                rbtnFemenino.setSelected(true);
            } else {
                rbtnMasculino.setSelected(false);
                rbtnFemenino.setSelected(false);

            }
        }
    }
}
