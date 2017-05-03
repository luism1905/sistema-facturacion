/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.view;

import cadisystem.dto.asesor.Asesor;
import cadisystem.dto.seccion.Seccion;
import cadisystem.dto.seccion.SeccionHistorico;
import cadisystem.dto.seccion.SeccionMovimiento;
import cadisystem.model.DAO.AsesorCursoDAO;
import cadisystem.model.DAO.SeccionDAO;
import cadisystem.model.DAO.SeccionHistoricoDAO;
import cadisystem.model.DAO.SeccionMovimientoDAO;
import cadisystem.model.dto.estudiante.Estudiante;
import cadisystem.model.implement.AsesorCursoImp;
import cadisystem.model.implement.SeccionHistoricoImp;
import cadisystem.model.implement.SeccionImp;
import cadisystem.model.implement.SeccionMovimientoImp;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlos
 */
public class consultarSeccion extends javax.swing.JDialog {

    Seccion seccion = new Seccion();
    Boolean modificarSeccion = false;
    Date hoy;
    Integer idAsesor;
    Date fechaTentNueva;
    Boolean cambiar = false;
    Vector<Estudiante> listEstudiante;
    public consultarSeccion(java.awt.Frame parent, boolean modal, final Integer idSeccion) {
        super(parent, modal);
        initComponents();
        cargarVista(idSeccion);
        cargarInformacionSeccionHist(idSeccion);
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        date.format(now);
        hoy = now;
        getDataParaTabla(idSeccion);
        cargarTabla(listEstudiante);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        lblSeccionValue = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblEstatus = new javax.swing.JLabel();
        lblEstatusValue = new javax.swing.JLabel();
        lblAsesor = new javax.swing.JLabel();
        cmbAsesor = new javax.swing.JComboBox();
        lblCurso = new javax.swing.JLabel();
        lblCursoValue = new javax.swing.JLabel();
        fechaTentInicio = new com.toedter.calendar.JDateChooser();
        lblFechaInicio = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEst = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        lblTotalInscritos = new javax.swing.JLabel();
        inscritosValue = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuIniciar = new javax.swing.JMenuItem();
        menuCerrar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo-cadif1.jpg"))); // NOI18N
        jLabel2.setText("           Consultar Sección");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 80));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSeccionValue.setText("Sección número:");
        jPanel2.add(lblSeccionValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 60, -1));

        jLabel1.setText("Sección número:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 29, -1, -1));

        lblEstatus.setText("Estado:");
        jPanel2.add(lblEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 53, -1, -1));

        lblEstatusValue.setText("Planificada");
        jPanel2.add(lblEstatusValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 53, -1, -1));

        lblAsesor.setText("Asesor:");
        jPanel2.add(lblAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 53, -1, -1));

        cmbAsesor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAsesor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbAsesorItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbAsesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 192, -1));

        lblCurso.setText("Curso:");
        jPanel2.add(lblCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 29, -1, -1));

        lblCursoValue.setText("Sección número:");
        jPanel2.add(lblCursoValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 29, 91, -1));

        fechaTentInicio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fechaTentInicioPropertyChange(evt);
            }
        });
        jPanel2.add(fechaTentInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 135, -1));

        lblFechaInicio.setText("Fecha Tentativa de Inicio:");
        jPanel2.add(lblFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 345, -1, -1));

        jTableEst.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Estudiantes Inscritos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableEst);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 110, 441, 204));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 345, -1, -1));

        lblTotalInscritos.setText("Total Inscritos: ");
        jPanel2.add(lblTotalInscritos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, -1, -1));

        inscritosValue.setText("0");
        jPanel2.add(inscritosValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 320, 37, -1));

        jTabbedPane1.addTab("Información general", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 520, 410));

        menuArchivo.setText("Archivo");
        menuArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArchivoActionPerformed(evt);
            }
        });

        menuIniciar.setText("Iniciar");
        menuIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIniciarActionPerformed(evt);
            }
        });
        menuArchivo.add(menuIniciar);

        menuCerrar.setText("Cerrar");
        menuCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCerrarActionPerformed(evt);
            }
        });
        menuArchivo.add(menuCerrar);

        jMenuBar1.add(menuArchivo);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void cargarVista(Integer idSeccion) {

        SeccionDAO secc = new SeccionImp();
        seccion = new Seccion();
        try {
            seccion = secc.buscar(idSeccion);
            fechaTentInicio.setDate(seccion.getFechaTentativaInicio());
            lblEstatusValue.setText(seccion.getEstado().getNombre());
            cargarCombo(seccion.getCurso().getId(), seccion.getAsesor().getId());
            lblCursoValue.setText(seccion.getCurso().getNombre());
            lblSeccionValue.setText(String.valueOf(seccion.getIdSeccion()));

            if (seccion.getEstado().getNombre().equals("Iniciada")) {
                menuIniciar.setVisible(false);
                cmbAsesor.setEnabled(false);
                fechaTentInicio.setEnabled(false);
            } else if (seccion.getEstado().getNombre().equals("Abierta")
                    || seccion.getEstado().getNombre().equals("Replanificada")) {
                menuCerrar.setVisible(false);

            } else if (seccion.getEstado().getNombre().equals("Planificada")) {
                menuCerrar.setVisible(false);
            } else if (seccion.getEstado().getNombre().equals("Cerrada")) {
                menuCerrar.setVisible(false);
                menuIniciar.setVisible(false);
                cmbAsesor.setEnabled(false);
                fechaTentInicio.setEnabled(false);
            }
        } catch (Exception ex) {
            Logger.getLogger(consultarSeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getDataParaTabla(Integer idSeccion){
        
        SeccionDAO seccDao = new SeccionImp();
        try {
            listEstudiante =  seccDao.obtenerEstudiantesDadoIdSeccion(idSeccion);
        } catch (Exception ex) {
            Logger.getLogger(consultarSeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void cargarCombo(Integer idCurso, Integer idAsesor) {

        AsesorCursoDAO asesordao = new AsesorCursoImp();
        try {
            asesordao.cargarComboAsesorDadoIdCurso(idCurso, cmbAsesor);
            Asesor asesor;
            for (int i = 0; i < cmbAsesor.getItemCount(); i++) {
                asesor = (Asesor) cmbAsesor.getItemAt(i);
                if (idAsesor.equals(asesor.getId())) {
                    cmbAsesor.setSelectedItem(asesor);
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(consultarSeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void menuIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIniciarActionPerformed
        SeccionDAO seccDao = new SeccionImp();
        SeccionMovimiento seccMov = new SeccionMovimiento("Iniciada", seccion.getEstado().getNombre(), hoy, seccion.getIdSeccion());
        SeccionMovimientoDAO seccMovDao = new SeccionMovimientoImp();
        seccion.getEstado().setNombre("Iniciada");
        seccion.setFechaInicio(hoy);
        try {
            seccDao.iniciarSeccion(seccion);
            seccMovDao.insertar(seccMov);
            String msj = "La sección se ha Iniciado ";
            JOptionPane.showMessageDialog(null, msj, "Información", JOptionPane.INFORMATION_MESSAGE);
            menuIniciar.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(consultarSeccion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_menuIniciarActionPerformed

    private void menuArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArchivoActionPerformed

    }//GEN-LAST:event_menuArchivoActionPerformed

    private void menuCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCerrarActionPerformed
        SeccionDAO seccDao = new SeccionImp();
        SeccionMovimiento seccMov = new SeccionMovimiento("Cerrada", seccion.getEstado().getNombre(), hoy, seccion.getIdSeccion());
        SeccionMovimientoDAO seccMovDao = new SeccionMovimientoImp();
        seccion.getEstado().setNombre("Cerrada");
        seccion.setFechaCulminacion(hoy);
        try {
            seccDao.cerrarSeccion(seccion);
            seccMovDao.insertar(seccMov);
            String msj = "La sección se ha Cerrado ";
            JOptionPane.showMessageDialog(null, msj, "Información", JOptionPane.INFORMATION_MESSAGE);
            menuCerrar.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(consultarSeccion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_menuCerrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Asesor asesor = (Asesor) cmbAsesor.getSelectedItem();
        fechaTentNueva = new Date(fechaTentInicio.getDate().getTime());
        idAsesor = asesor.getId();
        SeccionDAO seccDao = new SeccionImp();
        SeccionMovimientoDAO seccMovDao = new SeccionMovimientoImp();
        Date fechaLoca = seccion.getFechaTentativaInicio();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        date.format(fechaLoca);
        date.format(fechaTentNueva);
        if (!Objects.equals(idAsesor, seccion.getAsesor().getId()) || !fechaLoca.equals(fechaTentNueva) ){

            seccion.getEstado().setNombre("Replanificada");
            try {
                seccion.setAsesor(asesor);
                seccDao.modificar(seccion);

                if (seccion.getFechaTentativaInicio() != fechaTentNueva) {

                    try {
                        SeccionMovimiento seccMov = new SeccionMovimiento("Replanificada", seccion.getEstado().getNombre(), hoy, seccion.getIdSeccion());
                        seccion.setFechaTentativaInicio(fechaTentNueva);
                        seccDao.cambiarEstado(seccion);
                        seccMovDao.insertar(seccMov);
                        String msj = "La sección se ha Replanificado ";
                        JOptionPane.showMessageDialog(null, msj, "Información", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        Logger.getLogger(consultarSeccion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.dispose();
                }

            } catch (Exception ex) {
                Logger.getLogger(consultarSeccion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void fechaTentInicioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fechaTentInicioPropertyChange
        cambiar = true;
        System.out.println("Cambio la fecha");
    }//GEN-LAST:event_fechaTentInicioPropertyChange

    private void cmbAsesorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbAsesorItemStateChanged
        cambiar = true;
    }//GEN-LAST:event_cmbAsesorItemStateChanged

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
            java.util.logging.Logger.getLogger(consultarSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consultarSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consultarSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consultarSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                consultarSeccion dialog = new consultarSeccion(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cmbAsesor;
    private com.toedter.calendar.JDateChooser fechaTentInicio;
    private javax.swing.JLabel inscritosValue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableEst;
    private javax.swing.JLabel lblAsesor;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblCursoValue;
    private javax.swing.JLabel lblEstatus;
    private javax.swing.JLabel lblEstatusValue;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblSeccionValue;
    private javax.swing.JLabel lblTotalInscritos;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuItem menuCerrar;
    private javax.swing.JMenuItem menuIniciar;
    // End of variables declaration//GEN-END:variables
public void cargarInformacionSeccionHist(Integer idSeccion) {

        Vector<SeccionHistorico> LSeccH = new Vector();
        SeccionHistoricoDAO seccHdao = new SeccionHistoricoImp();
        try {
            LSeccH = seccHdao.listarHistoricoDadoIdSeccion(idSeccion);
            cargarTablaHistorico(LSeccH);
        } catch (Exception ex) {
            Logger.getLogger(consultarSeccion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarTablaHistorico(Vector<SeccionHistorico> LSeccHist) {

//        tableHistoricoSeccion.removeAll();
//        DefaultTableModel m = (DefaultTableModel) tableHistoricoSeccion.getModel();
//        m.setNumRows(0);
//
//        for (int i = 0; i < LSeccHist.size(); i++) {
//            Vector fila = new Vector();
//            fila.add(LSeccHist.get(i).getDescripcion());
//            m.addRow(fila);
//        }

    }
    
    public void cargarTabla(List<Estudiante> LCurso){
 
        Integer cantCursos = 0;
        DefaultTableModel m = (DefaultTableModel) jTableEst.getModel();
        m.setNumRows(0);

        for (int i = 0; i < LCurso.size(); i++) {
            Vector fila = new Vector();
            fila.add(LCurso.get(i).getNombreCompleto());
            cantCursos++;
            m.addRow(fila);
        }
        inscritosValue.setText(String.valueOf(cantCursos));
    }

}