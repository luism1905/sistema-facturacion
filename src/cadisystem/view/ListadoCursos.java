/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.view;

import cadisystem.dto.asesor.Asesor;
import cadisystem.dto.curso.Curso;
import cadisystem.model.DAO.AsesorDAO;
import cadisystem.model.DAO.CursoDAO;
import cadisystem.model.DAO.EstudianteDAO;
import cadisystem.model.dto.estudiante.Estudiante;
import cadisystem.model.implement.AsesorImp;
import cadisystem.model.implement.CursoImp;
import cadisystem.model.implement.EstudianteImp;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTable;
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
public class ListadoCursos extends javax.swing.JDialog {

    private Vector<Curso> LCurso;
    Vector<Curso> listAux = new Vector<>();
    Integer cantCursos = 0;
    private Curso cursoSeleccionado = null;

    public ListadoCursos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        limpiarTabla();

        CursoDAO cursodao = new CursoImp();
        try {
            LCurso = cursodao.listar();
            listAux = LCurso;
        } catch (Exception ex) {
            Logger.getLogger(ListadoCursos.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.cargarTabla(LCurso);

        jtableCurso.addMouseListener(new MouseAdapter() {
         
            @Override
            public void mouseClicked(final MouseEvent e) {
                if (e.getClickCount() == 2) {
                    final JTable target = (JTable) e.getSource();
                    final int row = target.getSelectedRow();
                    final int column = target.getSelectedColumn();
                    // Cast to ur Object type
                    final Integer cell = (Integer) target.getValueAt(row, 0);
                   // Integer numero = (Integer) jtableCurso.getModel().getValueAt(row, 1);
                    String nombre = (String) jtableCurso.getModel().getValueAt(row, 1);
                    Float precio = (Float) jtableCurso.getModel().getValueAt(row, 2);
                    Integer duracion = (Integer) jtableCurso.getModel().getValueAt(row, 3);
                    cursoSeleccionado = new Curso(cell, nombre, duracion, precio);
                    
                    

                }
            }
            
        });
    
    }

    public void cerrar(){this.dispose();}
    public Curso getCursoSeleccionado() {
        return cursoSeleccionado;
    }

    public void limpiarTabla() {

        jtableCurso.removeAll();

    }

    public void cargarTabla(List<Curso> LCurso) {

        this.limpiarTabla();
        cantCursos = 0;
        DefaultTableModel m = (DefaultTableModel) jtableCurso.getModel();
        m.setNumRows(0);

        for (int i = 0; i < LCurso.size(); i++) {
            Vector fila = new Vector();
            fila.add(LCurso.get(i).getId());
            fila.add(LCurso.get(i).getNombre());
            fila.add(LCurso.get(i).getPrecio());
            fila.add(LCurso.get(i).getHoras());
            cantCursos++;
            m.addRow(fila);
        }
        valueTotal.setText(String.valueOf(cantCursos));
        if (LCurso.isEmpty()) {
            btnGenerarReporte.setVisible(false);
        }

    }

    public JButton getBtnGenerarReporte() {
        return btnGenerarReporte;
    }

    public void setBtnGenerarReporte(JButton btnGenerarReporte) {
        this.btnGenerarReporte = btnGenerarReporte;
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
        jtableCurso = new javax.swing.JTable();
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
        jLabel1.setText("                   Listado de Cursos");

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
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblFiltrarPor.setText("Filtrar por:");
        getContentPane().add(lblFiltrarPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 127, 63, -1));

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Duración", "Precio" }));
        getContentPane().add(cmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 124, 205, -1));

        lblBusqueda.setText("Busqueda:");
        getContentPane().add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 127, -1, -1));
        getContentPane().add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 124, 211, -1));

        jtableCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Número", "Nombre", "Precio", "Duración"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableCursoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtableCurso);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 152, 906, 230));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, 60, -1));

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
        getContentPane().add(btnRestablecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Total:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 390, 40, 20));

        valueTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        valueTotal.setText("xyz");
        getContentPane().add(valueTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 390, 50, 20));

        btnGenerarReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerarReporte.setLabel("Generar Reporte");
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 130, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        CursoDAO cursodao = new CursoImp();
        try {
            LCurso = cursodao.listar();
        } catch (Exception ex) {
            Logger.getLogger(ListadoCursos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (cmbFiltro.getSelectedItem().equals("Nombre")) {
            this.busquedaPorNombre(LCurso, listAux);

        } else if (cmbFiltro.getSelectedItem().equals("Precio")) {
            this.busquedaPorPrecio(LCurso, listAux);

        } else if (cmbFiltro.getSelectedItem().equals("Duración")) {
            this.busquedaPorHoras(LCurso, listAux);

        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecerActionPerformed
        txtBusqueda.setText("");
        limpiarTabla();
        cmbFiltro.setSelectedIndex(0);
        cargarTabla(LCurso);
        btnGenerarReporte.setVisible(true);
        if (btnGenerarReporte.getName().equals("Seleccionar")) {
            btnGenerarReporte.setVisible(false);
        }
    }//GEN-LAST:event_btnRestablecerActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
        JasperReport jr = null;
        String archivo = "C:\\Users\\carlos\\Documents\\NetBeansProjects\\Librerias\\cadisystem\\src\\cadisystem\\report\\ReporteCursos.jasper";

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
            jp = JasperFillManager.fillReport(jr, params, jrdt);
        } catch (JRException ex) {
            Logger.getLogger(ListadoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperViewer jv = new JasperViewer(jp, false);
        this.setModal(false);
        this.dispose();
        jv.setVisible(true);

        jv.setTitle("Reporte de Cursos");
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    private void jtableCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableCursoMouseClicked
        if(evt.getClickCount() == 2){
            this.dispose();
        }
    }//GEN-LAST:event_jtableCursoMouseClicked

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
            java.util.logging.Logger.getLogger(ListadoCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListadoCursos dialog = new ListadoCursos(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable jtableCurso;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblFiltrarPor;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JLabel valueTotal;
    // End of variables declaration//GEN-END:variables

    public void busquedaPorNombre(Vector<Curso> listCur, Vector<Curso> listAux) {

        listAux.clear();
        String busqueda = String.valueOf(txtBusqueda.getText());

        for (int i = 0; i < listCur.size(); i++) {

            if (busqueda.equals(listCur.get(i).getNombre())
                    || listCur.get(i).getNombre().contains(busqueda)) {
                listAux.add(listCur.get(i));
            }

        }
        //  System.out.println("selecciono nombre ");
        this.cargarTabla(listAux);

    }

    public void busquedaPorPrecio(Vector<Curso> listCur, Vector<Curso> listAux) {

        listAux.clear();
        Float busqueda = Float.valueOf(txtBusqueda.getText());

        for (int i = 0; i < listCur.size(); i++) {

            if (busqueda.equals(listCur.get(i).getPrecio())) {
                listAux.add(listCur.get(i));
            }

        }
        //      System.out.println("selecciono precio");
        this.cargarTabla(listAux);

    }

    public void busquedaPorHoras(Vector<Curso> listCur, Vector<Curso> listAux) {

        listAux.clear();
        Integer busqueda = Integer.valueOf(txtBusqueda.getText());

        for (int i = 0; i < listCur.size(); i++) {

            if (listCur.get(i).getHoras().equals(busqueda)) {
                listAux.add(listCur.get(i));
            }
        }
        //       System.out.println("selecciono horas");
        this.cargarTabla(listAux);

    }

    public void mouseClicked(MouseEvent e) {

        if (btnGenerarReporte.getName().equals("Seleccionar")) {
            if (e.getClickCount() == 2) {
                JTable target = (JTable) e.getSource();
                int row = target.getSelectedRow();
                int column = target.getSelectedColumn();
                // do some action
                Integer numero = (Integer) jtableCurso.getModel().getValueAt(row, 1);
                String nombre = (String) jtableCurso.getModel().getValueAt(row, 2);
                Float precio = (Float) jtableCurso.getModel().getValueAt(row, 3);
                Integer duracion = (Integer) jtableCurso.getModel().getValueAt(row, 4);
                cursoSeleccionado = new Curso(numero, nombre, duracion, precio);

                this.dispose();
            }
        }

    }
}
