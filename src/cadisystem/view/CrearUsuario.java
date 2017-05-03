/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.view;

import cadisystem.model.DAO.PrivilegioDAO;
import cadisystem.model.DAO.UsuarioDAO;
import cadisystem.model.DAO.UsuarioPrivilegioDAO;
import cadisystem.model.dto.usuario.Privilegio;
import cadisystem.model.dto.usuario.Usuario;
import cadisystem.model.implement.PrivilegioImp;
import cadisystem.model.implement.UsuarioImp;
import cadisystem.model.implement.UsuarioPrivilegioImp;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.SpringLayout.WIDTH;

/**
 *
 * @author carlos
 */
public class CrearUsuario extends javax.swing.JDialog {

    public List<Privilegio> privilegiosSeleccionados;
    private Date now;
    
    public void cargarStatus(){
        
        for (int i = 0; i < privilegiosSeleccionados.size(); i++) {
            
            privilegiosSeleccionados.get(i).setStatus("E");
            
        }
        
    }

    public CrearUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.privilegiosSeleccionados = cargarPrivilegios();
        this.cargarStatus();
        initComponents();
        this.cargarJCheckBox();
        this.validarCampos();
        this.inicializarComponentes();

    }

    public void inicializarComponentes() {

        this.getLblUsuarioDisponible().setText("");
        this.getLblValidarPassword().setText("");
        this.getTxtPassword().setText("");
        this.getTxtPasswordRepeat().setText("");
        now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        this.lblValorFechaRegistro.setText(String.valueOf(date.format(now)));

    }

    public void validarCampos() {

        this.validarMaximoCaracteresTextfield(this.getTxtUsuario(), 15);
        this.validarMaximoCaracteresTextfield(this.getTxtPassword(), 15);
        this.validarMaximoCaracteresTextfield(this.getTxtPasswordRepeat(), 15);
    }

    public Boolean compararJPasswordFields(char[] j1, char[] j2) {

        boolean valor = true;
        int puntero = 0;
        if (j1.length != j2.length) {
            valor = false;
        } else {
            while ((valor) && (puntero < j1.length)) {
                if (j1[puntero] != j2[puntero]) {
                    valor = false;
                }
                puntero++;
            }
        }
        return valor;

    }

    public void comprobarPasswords() {
        Boolean valor = false;
        valor = this.compararJPasswordFields(txtPassword.getPassword(), txtPasswordRepeat.getPassword());
        if(txtPasswordRepeat.getPassword().length == 0){
            
             this.getLblValidarPassword().setText("");
            
        }
        else if (valor == true){
            this.getLblValidarPassword().setText("Las contraseñas coinciden");
            this.getLblValidarPassword().setForeground(Color.blue);
        } else {

            this.getLblValidarPassword().setText("Las contraseñas No coinciden");
            this.getLblValidarPassword().setForeground(Color.red);

        }
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public JPasswordField getTxtPasswordRepeat() {
        return txtPasswordRepeat;
    }

    public void cargarJCheckBox() {

        final List<Privilegio> listado = cargarPrivilegios();
        this.getjCheckBox1().setText(listado.get(0).getDescripcion());
        this.getjCheckBox2().setText(listado.get(1).getDescripcion());
        this.getjCheckBox3().setText(listado.get(2).getDescripcion());
        this.getjCheckBox4().setText(listado.get(3).getDescripcion());
        this.getjCheckBox5().setText(listado.get(4).getDescripcion());
        this.getjCheckBox6().setText(listado.get(5).getDescripcion());
        this.getjCheckBox7().setText(listado.get(6).getDescripcion());
        this.getjCheckBox8().setText(listado.get(7).getDescripcion());
        this.getjCheckBox9().setText(listado.get(8).getDescripcion());
        this.getjCheckBox10().setText(listado.get(9).getDescripcion());
        this.getjCheckBox11().setText(listado.get(10).getDescripcion());
        this.getjCheckBox12().setText(listado.get(11).getDescripcion());
        this.getjCheckBox13().setText(listado.get(12).getDescripcion());
        this.getjCheckBox14().setText(listado.get(13).getDescripcion());
        this.getjCheckBox15().setText(listado.get(14).getDescripcion());
         
    }

    public List<Privilegio> cargarPrivilegios() {
        List<Privilegio> listado = null;
        try {
            PrivilegioDAO priv = new PrivilegioImp();
            listado = priv.listar();

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return listado;
    }

    public JCheckBox getjCheckBox1() {
        return jCheckBox1;
    }

    public JCheckBox getjCheckBox2() {
        return jCheckBox2;
    }

    public JCheckBox getjCheckBox3() {
        return jCheckBox3;
    }

    public JCheckBox getjCheckBox10() {
        return jCheckBox10;
    }

    public JCheckBox getjCheckBox11() {
        return jCheckBox11;
    }

    public JCheckBox getjCheckBox12() {
        return jCheckBox12;
    }

    public JCheckBox getjCheckBox4() {
        return jCheckBox4;
    }

    public JCheckBox getjCheckBox5() {
        return jCheckBox5;
    }

    public JCheckBox getjCheckBox6() {
        return jCheckBox6;
    }

    public JCheckBox getjCheckBox7() {
        return jCheckBox7;
    }

    public JCheckBox getjCheckBox8() {
        return jCheckBox8;
    }

    public JCheckBox getjCheckBox9() {
        return jCheckBox9;
    }

    public JCheckBox getjCheckBox13() {
        return jCheckBox13;
    }

    public void setjCheckBox13(JCheckBox jCheckBox13) {
        this.jCheckBox13 = jCheckBox13;
    }

    public JCheckBox getjCheckBox14() {
        return jCheckBox14;
    }

    public void setjCheckBox14(JCheckBox jCheckBox14) {
        this.jCheckBox14 = jCheckBox14;
    }

    public JCheckBox getjCheckBox15() {
        return jCheckBox15;
    }

    public void setjCheckBox15(JCheckBox jCheckBox15) {
        this.jCheckBox15 = jCheckBox15;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        lblRepitaPassword = new javax.swing.JLabel();
        lblFechaRegistro = new javax.swing.JLabel();
        lblValorFechaRegistro = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtPasswordRepeat = new javax.swing.JPasswordField();
        lblValidarPassword = new javax.swing.JLabel();
        lblUsuarioDisponible = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        lblPrivilegios = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario.setText("Nombre de usuario:");
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 176, -1));

        lblPassword.setText("Contraseña:");
        getContentPane().add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 94, -1));

        lblRepitaPassword.setText("Repita contraseña:");
        getContentPane().add(lblRepitaPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, -1));

        lblFechaRegistro.setText("Fecha de Registro: ");
        getContentPane().add(lblFechaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        lblValorFechaRegistro.setText("XYZ");
        getContentPane().add(lblValorFechaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 79, -1));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 170, -1));

        txtPasswordRepeat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordRepeatKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordRepeatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordRepeatKeyTyped(evt);
            }
        });
        getContentPane().add(txtPasswordRepeat, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 178, -1));

        lblValidarPassword.setText("las contraseñas no coinciden");
        getContentPane().add(lblValidarPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, -1, -1));

        lblUsuarioDisponible.setText("Usuario disponible");
        getContentPane().add(lblUsuarioDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, -1, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, -1, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, -1, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 520, -1, -1));

        jCheckBox1.setText("Cambiar contraseña");
        jCheckBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 321, 230, -1));

        lblPrivilegios.setText("Agregar Privilegios");
        getContentPane().add(lblPrivilegios, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 289, -1, -1));

        jCheckBox2.setText("Cambiar contraseña");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 362, 210, -1));

        jCheckBox3.setText("Cambiar contraseña");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 403, 210, -1));

        jCheckBox4.setText("Cambiar contraseña");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, 210, -1));

        jCheckBox5.setText("Cambiar contraseña");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 180, -1));

        jCheckBox6.setText("Cambiar contraseña");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 180, -1));

        jCheckBox7.setText("Cambiar contraseña");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 260, -1));

        jCheckBox8.setText("Cambiar contraseña");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 180, -1));

        jCheckBox9.setText("Cambiar contraseña");
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, 210, -1));

        jCheckBox10.setText("Cambiar contraseña");
        jCheckBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox10ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, 190, -1));

        jCheckBox11.setText("Cambiar contraseña");
        jCheckBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox11ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, 210, -1));

        jCheckBox12.setText("Cambiar contraseña");
        jCheckBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox12ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, 200, -1));

        lblCorreo.setText("Correo:");
        getContentPane().add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 270, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo-cadif1.jpg"))); // NOI18N
        jLabel4.setText("                     Usuario");
        jLabel4.setToolTipText("");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 730, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 90));

        jCheckBox13.setText("Cambiar contraseña");
        jCheckBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox13ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox13, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 444, 220, -1));

        jCheckBox14.setText("Cambiar contraseña");
        jCheckBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox14ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 200, -1));

        jCheckBox15.setText("Cambiar contraseña");
        jCheckBox15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox15ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox15, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, 220, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public JLabel getLblUsuarioDisponible() {
        return lblUsuarioDisponible;
    }

    public JLabel getLblValidarPassword() {
        return lblValidarPassword;
    }

    public JLabel getLblValorFechaRegistro() {
        return lblValorFechaRegistro;
    }


    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged

    }//GEN-LAST:event_jCheckBox1StateChanged
    public Integer ObtenerIdDadoPrivilegio(String priv) {
        List<Privilegio> laux = cargarPrivilegios();
        Integer n = null;
        for (int i = 0; i < laux.size(); i++) {

            if (priv.equals(laux.get(i).getDescripcion())) {
                return laux.get(i).getId();
            } else {
                n = -1;
            }

        }
        return n;
    }

    public Boolean eliminarCheckBox(String desc) {
        List<Privilegio> laux = cargarPrivilegios();
        Boolean valor = null;
        for (int i = 0; i < privilegiosSeleccionados.size(); i++) {

            if (desc.equals(privilegiosSeleccionados.get(i).getDescripcion())) {
                privilegiosSeleccionados.get(i).setStatus("E");
                valor = true;
            } else {
                valor = false;
            }

        }

        return valor;
    }
    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        Privilegio priv = new Privilegio();
        if (jCheckBox1.isSelected()) {
        Boolean valor = null;
        for (int i = 0; i < privilegiosSeleccionados.size(); i++) {

            if (jCheckBox1.getText().equals(privilegiosSeleccionados.get(i).getDescripcion())) {
                privilegiosSeleccionados.get(i).setStatus("A");
                valor = true;
            } else {
                valor = false;
            }

        }

        } else {

            if (this.eliminarCheckBox(jCheckBox1.getText())) {
                System.out.println("Eliminado de la ista temporal");
            } else {

                System.out.println("no encontre el valor en la lista temporal");
            }

        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
   Privilegio priv = new Privilegio();
        if (jCheckBox2.isSelected()) {

        Boolean valor = null;
        for (int i = 0; i < privilegiosSeleccionados.size(); i++) {

            if (jCheckBox2.getText().equals(privilegiosSeleccionados.get(i).getDescripcion())) {
                privilegiosSeleccionados.get(i).setStatus("A");
                valor = true;
            } else {
                valor = false;
            }

        }

        } else {

            if (this.eliminarCheckBox(jCheckBox2.getText())) {
                System.out.println("Eliminado de la ista temporal");
            } else {

                System.out.println("no encontre el valor en la lista temporal");
            }

        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
          Privilegio priv = new Privilegio();
        if (jCheckBox3.isSelected()) {

        Boolean valor = null;
        for (int i = 0; i < privilegiosSeleccionados.size(); i++) {

            if (jCheckBox3.getText().equals(privilegiosSeleccionados.get(i).getDescripcion())) {
                privilegiosSeleccionados.get(i).setStatus("A");
                valor = true;
            } else {
                valor = false;
            }

        }

//            priv.setDescripcion(jCheckBox1.getText());
//            priv.setId(this.ObtenerIdDadoPrivilegio(priv.getDescripcion()));
//            priv.setStatus("A");
//            privilegiosSeleccionados.add(priv);
//            System.out.println("Agregado el check a la lista temporal");

        } else {

            if (this.eliminarCheckBox(jCheckBox3.getText())) {
                System.out.println("Eliminado de la lista temporal");
            } else {

                System.out.println("no encontre el valor en la lista temporal");
            }

        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String msj;

        if (this.getLblUsuarioDisponible().getText().equals("Campo vacío")) {
            msj = "Introduzca un nombre de usuario";
            JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);

        } else if (this.privilegiosSeleccionados.isEmpty()) {
            msj = "Debe seleccionar al menos un privilegio";
            JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);

        } else if (this.getLblUsuarioDisponible().getText().equals("Usuario No disponible")) {
            msj = "Introduzca un nombre de usuario disponible";
            JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);

        } else if (lblValidarPassword.getText().equals("Las contraseñas No coinciden")) {

            msj = "Las contraseñas no coinciden, Por favor, verifique";
            JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);
            txtPassword.setText("");
            txtPasswordRepeat.setText("");

        } else if (txtPassword.getPassword().length == 0) {

            msj = "Debe indroducir una contraseña";
            JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);

        } else if (txtPasswordRepeat.getPassword().length == 0) {

            msj = "Por favor, repita la contraseña";
            JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);

        }
        else if(txtCorreo.getText().equals("")){
            
                msj = "Por favor,Ingrese un correo electrónico";
            JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);
            
        }
        else if(!txtCorreo.getText().contains("@")){
            
                msj = "Por favor,Ingrese un correo electrónico válido";
            JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE); 
            
        }
        else {
            
            Usuario user = new Usuario();
            UsuarioDAO userDAO = new UsuarioImp();
            user.setUsername(this.txtUsuario.getText());
            user.setContrasenha(String.valueOf(this.txtPassword.getPassword()));
            user.setCorreo(this.txtCorreo.getText());
            user.setFechaRegistro(now);
            // Inserto los datos
            try {
                userDAO.registrar(user);
            } catch (Exception ex) {
                Logger.getLogger(CrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
                System.out.append("Error al registrar al usuario");
            }
            
            try {
                user.setId(userDAO.obtenerUltimoIdUsuario());
            } catch (Exception ex) {
                Logger.getLogger(CrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            user.setPrivilegios(this.privilegiosSeleccionados);
           Boolean value=null;
           Integer contador = 0;
            for(Integer i=0;i<user.getPrivilegios().size();i++){
                
              value=  insertarUsuarioPrivilegioServicio(user,i);
             
              if(value){
                  
                     contador++;
                  
              }
               
            }
            if(contador.equals(user.getPrivilegios().size())){
                
                     msj = "Ha creado al usuario satisfactoriamente";
            JOptionPane.showMessageDialog(null, msj, "Información", JOptionPane.INFORMATION_MESSAGE); 
                this.dispose();
            }
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    public Boolean insertarUsuarioPrivilegioServicio(Usuario user,Integer i){
       Boolean valor= false;
       UsuarioPrivilegioDAO updao = new UsuarioPrivilegioImp();
        try {
            updao.insertarUsuariosPrivilegios(user,i);
            valor=true;
        } catch (Exception ex) {
            Logger.getLogger(CrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
   }
    /**
     * Metodo que carga el atributo lista de privilegios del objeto usuario
     * 
     * 
     * @return lista de privilrgios con estatus A y E dependiendo de la seleccion
     * de los checkbox
     */
    public List<Privilegio> PrepareListInsertar(){
        List<Privilegio> listaInsertar = new ArrayList();
        Privilegio priv;
        List<Privilegio> lista = cargarPrivilegios(); //trae todos los privilegios de base de datos
        
//        for(Integer i=0;i<listaGeneral.size();i++){
//            
//             for(Integer j=0;j<privilegiosSeleccionados.size();j++){
////                
//                if(privilegiosSeleccionados.get(j).getDescripcion().equals(listaGeneral.get(i).getDescripcion())){
//                   
//                    priv = new Privilegio(privilegiosSeleccionados.get(j).getId(),privilegiosSeleccionados.get(i).getDescripcion(),"A");
//                    listaInsertar.add(priv);
//                
//                }
//                else{
//                
//                    priv = new Privilegio(privilegiosSeleccionados.get(j).getId(),privilegiosSeleccionados.get(i).getDescripcion(),"E");
//                    listaInsertar.add(priv);
//                    
//                }
//            }
//            
//        }
        
        
//        for(Integer i=0;i<privilegiosSeleccionados.size();i++){
//            
//           
//            for(Integer j=0;j<lista.size();j++){
//                
//                if(privilegiosSeleccionados.get(i).getDescripcion().equals(lista.get(j).getDescripcion())){
//                   
//                    priv = new Privilegio(privilegiosSeleccionados.get(i).getId(),privilegiosSeleccionados.get(i).getDescripcion(),"A");
//                    listaInsertar.add(priv);
//                
//                }
//                else{
//                
//                    priv = new Privilegio(privilegiosSeleccionados.get(i).getId(),privilegiosSeleccionados.get(i).getDescripcion(),"E");
//                    listaInsertar.add(priv);
//                    
//                }
//            }
//            
//        }
        
        
       
        
        
        return listaInsertar;
    }
    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        UsuarioDAO userDAO = new UsuarioImp();
        Usuario userDTO = new Usuario();
        try {
            if (txtUsuario.getText().equals("")) {
                this.getLblUsuarioDisponible().setText("Campo vacío");
                this.getLblUsuarioDisponible().setForeground(Color.red);
            } else {
                this.getLblUsuarioDisponible().setText("");
                userDTO = userDAO.buscar(txtUsuario.getText());
            }

        } catch (Exception ex) {
            Logger.getLogger(CrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al buscar el username");
        }

        if (userDTO.getId().equals(-1)) {

            this.getLblUsuarioDisponible().setText("Usuario disponible");
            this.getLblUsuarioDisponible().setForeground(Color.blue);
        } else {

            this.getLblUsuarioDisponible().setText("Usuario No disponible");
            this.getLblUsuarioDisponible().setForeground(Color.red);

        }

    }//GEN-LAST:event_txtUsuarioFocusLost

    private void txtPasswordRepeatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordRepeatKeyTyped

    }//GEN-LAST:event_txtPasswordRepeatKeyTyped

    private void txtPasswordRepeatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordRepeatKeyPressed

    }//GEN-LAST:event_txtPasswordRepeatKeyPressed

    private void txtPasswordRepeatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordRepeatKeyReleased
        this.comprobarPasswords();
    }//GEN-LAST:event_txtPasswordRepeatKeyReleased

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtCorreo.setText("");
        txtPassword.setText("");
        txtPasswordRepeat.setText("");
        txtUsuario.setText("");
        this.getjCheckBox1().setSelected(false);
        this.getjCheckBox2().setSelected(false);
        this.getjCheckBox3().setSelected(false);
        this.getjCheckBox4().setSelected(false);
        this.getjCheckBox5().setSelected(false);
        this.getjCheckBox6().setSelected(false);
        this.getjCheckBox7().setSelected(false);
        this.getjCheckBox8().setSelected(false);
        this.getjCheckBox9().setSelected(false);
        this.getjCheckBox10().setSelected(false);
        this.getjCheckBox11().setSelected(false);
        this.getjCheckBox12().setSelected(false);
        this.getjCheckBox13().setSelected(false);
        this.getjCheckBox14().setSelected(false);
        this.getjCheckBox15().setSelected(false);
        this.lblValidarPassword.setText("");
        this.lblUsuarioDisponible.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jCheckBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox13ActionPerformed
        Privilegio priv = new Privilegio();
        if (jCheckBox13.isSelected()) {

        Boolean valor = null;
        for (int i = 0; i < privilegiosSeleccionados.size(); i++) {

            if (jCheckBox13.getText().equals(privilegiosSeleccionados.get(i).getDescripcion())) {
                privilegiosSeleccionados.get(i).setStatus("A");
                valor = true;
            } else {
                valor = false;
            }

        }

        } else {

            if (this.eliminarCheckBox(jCheckBox13.getText())) {
                System.out.println("Eliminado de la ista temporal");
            } else {

                System.out.println("no encontre el valor en la lista temporal");
            }

        }
    }//GEN-LAST:event_jCheckBox13ActionPerformed

    private void jCheckBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox14ActionPerformed
      Privilegio priv = new Privilegio();
        if (jCheckBox14.isSelected()) {

        Boolean valor = null;
        for (int i = 0; i < privilegiosSeleccionados.size(); i++) {

            if (jCheckBox14.getText().equals(privilegiosSeleccionados.get(i).getDescripcion())) {
                privilegiosSeleccionados.get(i).setStatus("A");
                valor = true;
            } else {
                valor = false;
            }

        }

        } else {

            if (this.eliminarCheckBox(jCheckBox14.getText())) {
                System.out.println("Eliminado de la ista temporal");
            } else {

                System.out.println("no encontre el valor en la lista temporal");
            }

        }
    }//GEN-LAST:event_jCheckBox14ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        Privilegio priv = new Privilegio();
        if (jCheckBox8.isSelected()) {

        Boolean valor = null;
        for (int i = 0; i < privilegiosSeleccionados.size(); i++) {

            if (jCheckBox8.getText().equals(privilegiosSeleccionados.get(i).getDescripcion())) {
                privilegiosSeleccionados.get(i).setStatus("A");
                valor = true;
            } else {
                valor = false;
            }

        }

        } else {

            if (this.eliminarCheckBox(jCheckBox8.getText())) {
                System.out.println("Eliminado de la ista temporal");
            } else {

                System.out.println("no encontre el valor en la lista temporal");
            }

        }
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
         Privilegio priv = new Privilegio();
        if (jCheckBox7.isSelected()) {

        Boolean valor = null;
        for (int i = 0; i < privilegiosSeleccionados.size(); i++) {

            if (jCheckBox7.getText().equals(privilegiosSeleccionados.get(i).getDescripcion())) {
                privilegiosSeleccionados.get(i).setStatus("A");
                valor = true;
            } else {
                valor = false;
            }

        }

        } else {

            if (this.eliminarCheckBox(jCheckBox7.getText())) {
                System.out.println("Eliminado de la ista temporal");
            } else {

                System.out.println("no encontre el valor en la lista temporal");
            }

        }
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
       Privilegio priv = new Privilegio();
        if (jCheckBox5.isSelected()) {

        Boolean valor = null;
        for (int i = 0; i < privilegiosSeleccionados.size(); i++) {

            if (jCheckBox5.getText().equals(privilegiosSeleccionados.get(i).getDescripcion())) {
                privilegiosSeleccionados.get(i).setStatus("A");
                valor = true;
            } else {
                valor = false;
            }

        }

        } else {

            if (this.eliminarCheckBox(jCheckBox5.getText())) {
                System.out.println("Eliminado de la ista temporal");
            } else {

                System.out.println("no encontre el valor en la lista temporal");
            }

        }
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
       Privilegio priv = new Privilegio();
        if (jCheckBox6.isSelected()) {

        Boolean valor = null;
        for (int i = 0; i < privilegiosSeleccionados.size(); i++) {

            if (jCheckBox6.getText().equals(privilegiosSeleccionados.get(i).getDescripcion())) {
                privilegiosSeleccionados.get(i).setStatus("A");
                valor = true;
            } else {
                valor = false;
            }

        }

        } else {

            if (this.eliminarCheckBox(jCheckBox6.getText())) {
                System.out.println("Eliminado de la ista temporal");
            } else {

                System.out.println("no encontre el valor en la lista temporal");
            }

        }
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox10ActionPerformed
      Privilegio priv = new Privilegio();
        if (jCheckBox10.isSelected()) {

        Boolean valor = null;
        for (int i = 0; i < privilegiosSeleccionados.size(); i++) {

            if (jCheckBox10.getText().equals(privilegiosSeleccionados.get(i).getDescripcion())) {
                privilegiosSeleccionados.get(i).setStatus("A");
                valor = true;
            } else {
                valor = false;
            }

        }

        } else {

            if (this.eliminarCheckBox(jCheckBox10.getText())) {
                System.out.println("Eliminado de la ista temporal");
            } else {

                System.out.println("no encontre el valor en la lista temporal");
            }

        }
    }//GEN-LAST:event_jCheckBox10ActionPerformed

    private void jCheckBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox12ActionPerformed
         Privilegio priv = new Privilegio();
        if (jCheckBox12.isSelected()) {

        Boolean valor = null;
        for (int i = 0; i < privilegiosSeleccionados.size(); i++) {

            if (jCheckBox12.getText().equals(privilegiosSeleccionados.get(i).getDescripcion())) {
                privilegiosSeleccionados.get(i).setStatus("A");
                valor = true;
            } else {
                valor = false;
            }

        }

        } else {

            if (this.eliminarCheckBox(jCheckBox12.getText())) {
                System.out.println("Eliminado de la ista temporal");
            } else {

                System.out.println("no encontre el valor en la lista temporal");
            }

        }
    }//GEN-LAST:event_jCheckBox12ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
      Privilegio priv = new Privilegio();
        if (jCheckBox9.isSelected()) {

        Boolean valor = null;
        for (int i = 0; i < privilegiosSeleccionados.size(); i++) {

            if (jCheckBox9.getText().equals(privilegiosSeleccionados.get(i).getDescripcion())) {
                privilegiosSeleccionados.get(i).setStatus("A");
                valor = true;
            } else {
                valor = false;
            }

        }

        } else {

            if (this.eliminarCheckBox(jCheckBox9.getText())) {
                System.out.println("Eliminado de la ista temporal");
            } else {

                System.out.println("no encontre el valor en la lista temporal");
            }

        }
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void jCheckBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox11ActionPerformed
       Privilegio priv = new Privilegio();
        if (jCheckBox11.isSelected()) {

        Boolean valor = null;
        for (int i = 0; i < privilegiosSeleccionados.size(); i++) {

            if (jCheckBox11.getText().equals(privilegiosSeleccionados.get(i).getDescripcion())) {
                privilegiosSeleccionados.get(i).setStatus("A");
                valor = true;
            } else {
                valor = false;
            }

        }

        } else {

            if (this.eliminarCheckBox(jCheckBox11.getText())) {
                System.out.println("Eliminado de la ista temporal");
            } else {

                System.out.println("no encontre el valor en la lista temporal");
            }

        }
    }//GEN-LAST:event_jCheckBox11ActionPerformed

    private void jCheckBox15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox15ActionPerformed
      Privilegio priv = new Privilegio();
        if (jCheckBox15.isSelected()) {

        Boolean valor = null;
        for (int i = 0; i < privilegiosSeleccionados.size(); i++) {

            if (jCheckBox15.getText().equals(privilegiosSeleccionados.get(i).getDescripcion())) {
                privilegiosSeleccionados.get(i).setStatus("A");
                valor = true;
            } else {
                valor = false;
            }

        }

        } else {

            if (this.eliminarCheckBox(jCheckBox15.getText())) {
                System.out.println("Eliminado de la ista temporal");
            } else {

                System.out.println("no encontre el valor en la lista temporal");
            }

        }
    }//GEN-LAST:event_jCheckBox15ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
       Privilegio priv = new Privilegio();
        if (jCheckBox4.isSelected()) {

        Boolean valor = null;
        for (int i = 0; i < privilegiosSeleccionados.size(); i++) {

            if (jCheckBox4.getText().equals(privilegiosSeleccionados.get(i).getDescripcion())) {
                privilegiosSeleccionados.get(i).setStatus("A");
                valor = true;
            } else {
                valor = false;
            }

        }

        } else {

            if (this.eliminarCheckBox(jCheckBox4.getText())) {
                System.out.println("Eliminado de la ista temporal");
            } else {

                System.out.println("no encontre el valor en la lista temporal");
            }

        }
    }//GEN-LAST:event_jCheckBox4ActionPerformed
    public void validarMaximoCaracteresTextfield(JTextField jtxt, int max) {

        jtxt.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (jtxt.getText().length() == max) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
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
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CrearUsuario dialog = new CrearUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblFechaRegistro;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPrivilegios;
    private javax.swing.JLabel lblRepitaPassword;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuarioDisponible;
    private javax.swing.JLabel lblValidarPassword;
    private javax.swing.JLabel lblValorFechaRegistro;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordRepeat;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
