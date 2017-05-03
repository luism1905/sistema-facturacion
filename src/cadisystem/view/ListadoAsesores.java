/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.view;

import cadisystem.dto.asesor.Asesor;
import cadisystem.model.DAO.AsesorDAO;
import cadisystem.model.DAO.EstudianteDAO;
import cadisystem.model.dto.estudiante.Estudiante;
import cadisystem.model.implement.AsesorImp;
import cadisystem.model.implement.EstudianteImp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author carlos
 */
public class ListadoAsesores extends javax.swing.JDialog {

    Vector<Asesor> LAsesor;
    Vector<Asesor> listAux = new Vector<>();
    Integer cantAsesores = 0;

    public ListadoAsesores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        limpiarTabla();

        AsesorDAO asedao = new AsesorImp();
        try {
            LAsesor = asedao.listar();
            listAux = LAsesor;
        } catch (Exception ex) {
            Logger.getLogger(ListadoAsesores.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.cargarTabla(LAsesor);
    }

    public void limpiarTabla() {

        jtableAsesor.removeAll();

    }

    public void cargarTabla(List<Asesor> LAsesor) {

        this.limpiarTabla();
        cantAsesores = 0;
        DefaultTableModel m = (DefaultTableModel) jtableAsesor.getModel();
        m.setNumRows(0);

        for (int i = 0; i < LAsesor.size(); i++) {
            Vector fila = new Vector();
            fila.add(LAsesor.get(i).getCedula());
            fila.add(LAsesor.get(i).getNombre());
            fila.add(LAsesor.get(i).getApellido());
            fila.add(LAsesor.get(i).getTelefono());
            fila.add(LAsesor.get(i).getOtroTelefono());
            fila.add(LAsesor.get(i).fechaRegistroOut());
            fila.add(LAsesor.get(i).getSexoString());
            fila.add(LAsesor.get(i).getProfesion()); 
            cantAsesores++;
            m.addRow(fila);
        }
        valueTotal.setText(String.valueOf(cantAsesores));
        if(LAsesor.isEmpty()){btnGenerarReporte.setVisible(false); }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblFiltrarPor = new javax.swing.JLabel();
        cmbFiltro = new javax.swing.JComboBox();
        lblBusqueda = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableAsesor = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnRestablecer = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        valueTotal = new javax.swing.JLabel();
        btnGenerarReporte = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo-cadif1.jpg"))); // NOI18N
        jLabel1.setText("                   Listado de Asesores");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 961, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblFiltrarPor.setText("Filtrar por:");
        getContentPane().add(lblFiltrarPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 127, 63, -1));

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cédula", "Nombre", "Apellido", "Teléfono", "Otro Teléfono", "Profesión", "Fecha de registro", "Sexo" }));
        getContentPane().add(cmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 124, 205, -1));

        lblBusqueda.setText("Busqueda:");
        getContentPane().add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 127, -1, -1));
        getContentPane().add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 124, 211, -1));

        jtableAsesor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "Apellido", "Telefono", "Otro teléfono", "Fecha de Registro", "Sexo", "Profesion"
            }
        ));
        jScrollPane2.setViewportView(jtableAsesor);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 152, 906, 230));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, 60, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(714, 123, -1, -1));

        btnRestablecer.setText("Restablecer");
        btnRestablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestablecerActionPerformed(evt);
            }
        });
        getContentPane().add(btnRestablecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Total: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 390, 50, 20));

        valueTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        valueTotal.setText("xyz");
        getContentPane().add(valueTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 390, 50, 20));

        btnGenerarReporte.setText("Generar Reporte");
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 130, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    
        if (cmbFiltro.getSelectedItem().equals("Cédula")) {
            this.busquedaPorCedula(LAsesor, listAux);

        } else if (cmbFiltro.getSelectedItem().equals("Nombre")) {
            this.busquedaPorNombre(LAsesor, listAux);

        } else if (cmbFiltro.getSelectedItem().equals("Apellido")) {
            this.busquedaPorApellido(LAsesor, listAux);

        } else if (cmbFiltro.getSelectedItem().equals("Teléfono")) {
            this.busquedaPorTelefono(LAsesor, listAux);

        } else if (cmbFiltro.getSelectedItem().equals("Otro Teléfono")) {
            this.busquedaPorOtroTelefono(LAsesor, listAux);

        } else if (cmbFiltro.getSelectedItem().equals("Profesión")) {
            this.busquedaPorProfesion(LAsesor, listAux);

        } else if (cmbFiltro.getSelectedItem().equals("Fecha de registro")) {
            this.busquedaPorFecha(LAsesor, listAux);

        } else if (cmbFiltro.getSelectedItem().equals("Sexo")) {
            this.busquedaPorSexo(LAsesor, listAux);

        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecerActionPerformed
       txtBusqueda.setText("");
   
        AsesorDAO asedao = new AsesorImp();
        try {
            LAsesor = asedao.listar();
            listAux = LAsesor;
        } catch (Exception ex) {
            Logger.getLogger(ListadoAsesores.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.cargarTabla(LAsesor);
        cmbFiltro.setSelectedIndex(0);
        btnGenerarReporte.setVisible(true);
    }//GEN-LAST:event_btnRestablecerActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed

        JasperReport jr = null;
        String archivo = "C:\\Users\\carlos\\Documents\\NetBeansProjects\\Librerias\\cadisystem\\src\\cadisystem\\report\\ReporteAsesores.jasper";

        Map params = new HashMap<String, String>();

        //  params.put("usuarios",listAux);
        JRDataSource jrdt = new JRBeanCollectionDataSource(listAux);
        try {
            jr = (JasperReport) JRLoader.loadObjectFromFile(archivo);
        } catch (JRException ex) {
            Logger.getLogger(ListadoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperPrint jp = null;
        try {
            jp = JasperFillManager.fillReport(jr,params,jrdt);
        } catch (JRException ex) {
            Logger.getLogger(ListadoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperViewer jv = new JasperViewer(jp,false);
        this.setModal(false);
        this.dispose();
        jv.setVisible(true);

        jv.setTitle("Reporte de Asesores");

    }//GEN-LAST:event_btnGenerarReporteActionPerformed

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
            java.util.logging.Logger.getLogger(ListadoAsesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoAsesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoAsesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoAsesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListadoAsesores dialog = new ListadoAsesores(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnRestablecer;
    private javax.swing.JComboBox cmbFiltro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jtableAsesor;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblFiltrarPor;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JLabel valueTotal;
    // End of variables declaration//GEN-END:variables

    public void busquedaPorSexo(Vector<Asesor> listAs, Vector<Asesor> listAux) {
  listAux.removeAllElements();
        AsesorDAO asedao = new AsesorImp();
        try {
            listAs = asedao.listar();
 
        } catch (Exception ex) {
            Logger.getLogger(ListadoAsesores.class.getName()).log(Level.SEVERE, null, ex);
        }
        String busqueda = String.valueOf(txtBusqueda.getText());

        for (int i = 0; i < listAs.size(); i++) {

            if (busqueda.equals(listAs.get(i).getSexoString())
                    || listAs.get(i).getSexoString().contains(busqueda)) {
                listAux.add(listAs.get(i));
            }

        }
  //      System.out.println("selecciono esexo");
        this.cargarTabla(listAux);
        if(listAux.isEmpty()){
              btnGenerarReporte.setVisible(false);
        }
    }

    public void busquedaPorProfesion(Vector<Asesor> listAs, Vector<Asesor> listAux) {
 listAux.removeAllElements();
        AsesorDAO asedao = new AsesorImp();
        try {
           listAs = asedao.listar();
 
        } catch (Exception ex) {
            Logger.getLogger(ListadoAsesores.class.getName()).log(Level.SEVERE, null, ex);
        }
        String busqueda = String.valueOf(txtBusqueda.getText());

        for (int i = 0; i < listAs.size(); i++) {

            if (busqueda.equals(listAs.get(i).getProfesion())
                    || listAs.get(i).getProfesion().contains(busqueda)) {
                listAux.add(listAs.get(i));
            }

        }
      //  System.out.println("selecciono la  profesion");
        this.cargarTabla(listAux);
        if(listAux.isEmpty()){
              btnGenerarReporte.setVisible(false);
        }
    }

    public void busquedaPorOtroTelefono(Vector<Asesor> listAs, Vector<Asesor> listAux) {
    listAux.removeAllElements();
        AsesorDAO asedao = new AsesorImp();
        try {
            listAs = asedao.listar();
 
        } catch (Exception ex) {
            Logger.getLogger(ListadoAsesores.class.getName()).log(Level.SEVERE, null, ex);
        }
        String busqueda = String.valueOf(txtBusqueda.getText());

        for (int i = 0; i < listAs.size(); i++) {

            if (busqueda.equals(listAs.get(i).getOtroTelefono())
                    || listAs.get(i).getOtroTelefono().contains(busqueda)) {
                listAux.add(listAs.get(i));
            }

        }
      //  System.out.println("selecciono el otro telefono");
        this.cargarTabla(listAux);
        if(listAux.isEmpty()){
              btnGenerarReporte.setVisible(false);
        }
    }

    public void busquedaPorTelefono(Vector<Asesor> listAs, Vector<Asesor> listAux) {
        listAux.removeAllElements();
        AsesorDAO asedao = new AsesorImp();
        try {
            listAs = asedao.listar();
 
        } catch (Exception ex) {
            Logger.getLogger(ListadoAsesores.class.getName()).log(Level.SEVERE, null, ex);
        }
        String busqueda = String.valueOf(txtBusqueda.getText());

        for (int i = 0; i < listAs.size(); i++) {

            if (busqueda.equals(listAs.get(i).getTelefono())
                    || listAs.get(i).getTelefono().contains(busqueda)) {
                listAux.add(listAs.get(i));
            }

        }
       // System.out.println("selecciono el telefono");
        this.cargarTabla(listAux);
        if(listAux.isEmpty()){
              btnGenerarReporte.setVisible(false);
        }
    }

    public void busquedaPorApellido(Vector<Asesor> listAs, Vector<Asesor> listAux) {
 listAux.removeAllElements();
        AsesorDAO asedao = new AsesorImp();
        try {
            listAs = asedao.listar();
 
        } catch (Exception ex) {
            Logger.getLogger(ListadoAsesores.class.getName()).log(Level.SEVERE, null, ex);
        }
        String busqueda = String.valueOf(txtBusqueda.getText());

        for (int i = 0; i < listAs.size(); i++) {

            if (busqueda.equals(listAs.get(i).getApellido())
                    || listAs.get(i).getApellido().contains(busqueda)) {
                listAux.add(listAs.get(i));
            }

        }
  
        this.cargarTabla(listAux);
        if(listAux.isEmpty()){
              btnGenerarReporte.setVisible(false);
        }
    }

    public void busquedaPorNombre(Vector<Asesor> listAs, Vector<Asesor> listAux) {
 listAux.removeAllElements();
        AsesorDAO asedao = new AsesorImp();
        try {
            listAs = asedao.listar();
 
        } catch (Exception ex) {
            Logger.getLogger(ListadoAsesores.class.getName()).log(Level.SEVERE, null, ex);
        }
        String nombre = String.valueOf(txtBusqueda.getText());

        for (int i = 0; i < listAs.size(); i++) {

            if (nombre.equals(listAs.get(i).getNombre())
                    || listAs.get(i).getNombre().contains(nombre)) {
                listAux.add(listAs.get(i));
            }

        }
   
        this.cargarTabla(listAux);
        if(listAux.isEmpty()){
              btnGenerarReporte.setVisible(false);
        }
    }

    public void busquedaPorCedula(Vector<Asesor> listAs, Vector<Asesor> listAux) {
 listAux.removeAllElements();
        AsesorDAO asedao = new AsesorImp();
        try {
           listAs = asedao.listar();
 
        } catch (Exception ex) {
            Logger.getLogger(ListadoAsesores.class.getName()).log(Level.SEVERE, null, ex);
        }
        String cedula = String.valueOf(txtBusqueda.getText());

        for (int i = 0; i < listAs.size(); i++) {

            if (cedula.equals(listAs.get(i).getCedula())
                    || listAs.get(i).getCedula().contains(cedula)) {
                listAux.add(listAs.get(i));
               
            }

        }

        this.cargarTabla(listAux);
        if(listAux.isEmpty()){
              btnGenerarReporte.setVisible(false);
        }

    }

    public void busquedaPorFecha(Vector<Asesor> listAs, Vector<Asesor> listAux) {
 listAux.removeAllElements();
        AsesorDAO asedao = new AsesorImp();
        try {
            listAs = asedao.listar();
 
        } catch (Exception ex) {
            Logger.getLogger(ListadoAsesores.class.getName()).log(Level.SEVERE, null, ex);
        }
        String date = String.valueOf(txtBusqueda.getText());

        for (int i = 0; i < listAs.size(); i++) {

            if (date.equals(listAs.get(i).fechaRegistroOut())
                    || listAs.get(i).fechaRegistroOut().contains(date)) {
                listAux.add(listAs.get(i));
            }

        }
    
        this.cargarTabla(listAux);
                if(listAux.isEmpty()){
              btnGenerarReporte.setVisible(false);
        }

    }
}
