/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.view;

import cadisystem.dto.curso.Curso;
import cadisystem.dto.factura.DetalleFactura;
import cadisystem.dto.factura.Factura;
import cadisystem.dto.seccion.Seccion;
import cadisystem.dto.seccion.SeccionEstudiante;
import cadisystem.dto.seccion.SeccionMovimiento;
import cadisystem.herramientas.Tools;
import cadisystem.model.DAO.CursoDAO;
import cadisystem.model.DAO.DetalleFacturaDAO;
import cadisystem.model.DAO.EstudianteDAO;
import cadisystem.model.DAO.FacturaDAO;
import cadisystem.model.DAO.SeccionDAO;
import cadisystem.model.DAO.SeccionEstudianteDAO;
import cadisystem.model.DAO.SeccionMovimientoDAO;
import cadisystem.model.dto.estudiante.Estudiante;
import cadisystem.model.implement.CursoImp;
import cadisystem.model.implement.DetalleFacturaImp;
import cadisystem.model.implement.EstudianteImp;
import cadisystem.model.implement.FacturaImp;
import cadisystem.model.implement.SeccionEstudianteImp;
import cadisystem.model.implement.SeccionImp;
import cadisystem.model.implement.SeccionMovimientoImp;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class InscribirEstudiante extends javax.swing.JDialog {

    Seccion seccion = new Seccion();
    Tools tools = new Tools();
    Boolean mostrarComboSeccion = false;
    DefaultTableModel m;
    Float montoCancelar;
    Curso cursoSelected = null;
 
    Vector<DetalleFactura> listDetFactura = new Vector();
    Date now = new Date(System.currentTimeMillis());
    ListadoCursos listCurso = null;
    Boolean controlador = false;
    Estudiante estudiante;
    Vector<Seccion> listSecciones = new Vector();//factura
    Factura factura = new Factura();

    public InscribirEstudiante(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        m = (DefaultTableModel) jtableCurso.getModel();
        m.setNumRows(0);
        montoCancelar = Float.valueOf("0.0");

        btnFacturar.setVisible(false);

        tools.validarMaximoCaracteresTextfield(txtCedula, 9);
        lblTotalCancelarValue.setText("0");
        cargarComboCurso();
        jtableCurso.removeAll();
        lblFechaTentativaValue.setText("");
        lblNombreValue.setText("");
        lblFechaRegistro.setText("");
        //     Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        this.fechaRegistroLbl.setText(String.valueOf(date.format(now)));
        btnCatalogoCursos.setVisible(false);
        cmbSeccion.setVisible(false);
        btnAgreCurso.setVisible(false);

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
        lblBuscar = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblNombreValue = new javax.swing.JLabel();
        lblCurso = new javax.swing.JLabel();
        lblFechaRegistro = new javax.swing.JLabel();
        btnFacturar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableCurso = new javax.swing.JTable();
        btnAgreCurso = new javax.swing.JButton();
        lblTotCanc = new javax.swing.JLabel();
        lblTotalCancelarValue = new javax.swing.JLabel();
        fechaRegistroLbl = new javax.swing.JLabel();
        lblFechaTentativaValue = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnCatalogoCursos = new javax.swing.JButton();
        cursoValue = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblEstadoValue = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblSeccion = new javax.swing.JLabel();
        cmbSeccion = new javax.swing.JComboBox();

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo-cadif1.jpg"))); // NOI18N
        jLabel1.setText("                             Inscribir Estudiante");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(37, 37, 37))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setForeground(java.awt.Color.orange);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBuscar.setText("Ingrese la cédula:");
        getContentPane().add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        getContentPane().add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 175, -1));

        lblNombre.setText("Estudiante : ");
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, -1));

        lblNombreValue.setText("Ingrese la cédula:");
        getContentPane().add(lblNombreValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 130, -1));

        lblCurso.setText("Curso: ");
        getContentPane().add(lblCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        lblFechaRegistro.setText("Fecha de Registro: ");
        getContentPane().add(lblFechaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, -1));

        btnFacturar.setText("Facturar");
        btnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarActionPerformed(evt);
            }
        });
        getContentPane().add(btnFacturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 110, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 90, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, 62, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        jtableCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Sección número", "Curso", "Precio", "Duración"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtableCurso);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 650, 190));

        btnAgreCurso.setText("Agregar curso");
        btnAgreCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgreCursoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgreCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 120, -1));

        lblTotCanc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotCanc.setText("Total a Cancelar:");
        getContentPane().add(lblTotCanc, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, 120, -1));

        lblTotalCancelarValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTotalCancelarValue.setForeground(new java.awt.Color(51, 51, 255));
        lblTotalCancelarValue.setText("jLabel3");
        getContentPane().add(lblTotalCancelarValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, 80, -1));

        fechaRegistroLbl.setText("Fecha de Registro:");
        getContentPane().add(fechaRegistroLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 130, -1));
        getContentPane().add(lblFechaTentativaValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 170, 20));

        jLabel5.setText("Fecha tentativa de Inicio:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo-cadif1.jpg"))); // NOI18N
        jLabel3.setText("                     Inscribir Estudiante");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, -1));

        btnCatalogoCursos.setLabel("Ver catálogo");
        btnCatalogoCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatalogoCursosActionPerformed(evt);
            }
        });
        getContentPane().add(btnCatalogoCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));
        getContentPane().add(cursoValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 180, 20));

        lblEstado.setText("Estado:");
        getContentPane().add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 234, 50, 20));
        getContentPane().add(lblEstadoValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 234, 170, 20));

        lblSeccion.setText("Sección:");

        cmbSeccion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSeccionItemStateChanged(evt);
            }
        });
        cmbSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSeccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeccion)
                    .addComponent(cmbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 200, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        tools.validarSoloNumeros(evt);
    }//GEN-LAST:event_txtCedulaKeyTyped
    public void cargarComboSeccion() {
        Seccion seccion = new Seccion();
        seccion.setIdSeccion(-1);
        cmbSeccion.addItem(seccion);
    }
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtCedula.getText().equals("")) {
            String msj = "Debe introducir la cédula del estudiante";
            JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            EstudianteDAO estdao = new EstudianteImp();
            Estudiante est = null;
            try {
                est = estdao.buscar(String.valueOf(txtCedula.getText()), est);
                estudiante = est;
                if(est.getId() != -1){
                    
                lblNombreValue.setText(est.getNombre() + " " + est.getApellido());
                btnCatalogoCursos.setVisible(true);
                //  cmbCurso.setVisible(true);
                mostrarComboSeccion = true;
                seccion.setEstudiante(est);
                txtCedula.setEditable(false);
                btnBuscar.setVisible(false); 
                    
                }
                else{
                String msj = "Estudiante no registrado";
                JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);
                       
                }
            } catch (Exception ex) {
                Logger.getLogger(InscribirEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        lblTotalCancelarValue.setText("0");
        jtableCurso.removeAll();
        txtCedula.setText("");
        lblNombreValue.setText("");
        montoCancelar = Float.valueOf("0.0");
        btnFacturar.setVisible(false);
        listSecciones.clear();
        listDetFactura.clear();
        btnAgreCurso.setVisible(false);
        jtableCurso.removeAll();
        cmbSeccion.setVisible(false);
        txtCedula.setEditable(true);
        btnBuscar.setVisible(true);
        lblEstadoValue.setText("");
                m.setNumRows(0);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarActionPerformed

        Factura fact = new Factura();
        fact.setFechaEmision(now);
        fact.setMontoTotal(montoCancelar);
        fact.setIdEstudiante(estudiante.getId());
       this.factura = fact;
        Facturar(factura);
//        SeccionMovimientoDAO seccMovDao = new SeccionMovimientoImp();
//        SeccionMovimiento seccMov = new SeccionMovimiento(seccion.getEstado().getNombre(),"Abierta", now, seccion.getIdSeccion());
//      
//        Integer cantEst;
        try {
           
//            cantEst = seccMovDao.obtenerCantidadDeEsttduiantesdadoIdSeccion(seccion.getIdSeccion());
//            if(cantEst == 0){
//                SeccionDAO seccDao = new SeccionImp();
//                seccion.getEstado().setNombre("Abierta");
//                seccDao.cambiarEstado(seccion);
//                seccMovDao.insertar(seccMov);
//                
//            String msj = "La Sección "+secc.getIdSeccion()+" ahora esta Abierta";
//            JOptionPane.showMessageDialog(null, msj, "Información", JOptionPane.INFORMATION_MESSAGE);
//       
//            }
        
        } catch (Exception ex) {
            Logger.getLogger(InscribirEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnFacturarActionPerformed

    private void btnAgreCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgreCursoActionPerformed
        Curso curs;
        Seccion secc;
        String msj;
        curs = cursoSelected;
        controlador = false;

        seccion = (Seccion) cmbSeccion.getSelectedItem();

        if (curs.getId() == -1) {
            msj = "Debe Seleccionar el curso";
            JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            seccion.setCurso(cursoSelected);
            seccion.setEstudiante(estudiante);
//            DetalleFactura detFact = new DetalleFactura();
//            detFact.setCantidad(1);
//            detFact.setIdEstudiante(seccion.getIdSeccion());
//            detFact.setPrecio(curs.getPrecio());
//            detFact.setIdEstudiante(seccion.getEstudiante().getId());
//            detFact.setDescripcion("Inscripción en el curso "+seccion.getCurso().getNombre());
            if (!buscarSeccionEnTablaDadoId(seccion.getIdSeccion())) {
                montoCancelar += cursoSelected.getPrecio();
                guardarItemEnTabla(seccion);
                //          listDetFactura.add(detFact);
                btnFacturar.setVisible(true);
                cmbSeccion.setVisible(false);
                cursoSelected = null;
                lblEstadoValue.setText("");
                lblFechaTentativaValue.setText("");
                cursoValue.setText("");
                listSecciones.add(seccion);
                btnAgreCurso.setVisible(false);
            } else {
                msj = "La seccion ya fué agregada";
                JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);
                lblEstadoValue.setText("");
                lblFechaTentativaValue.setText("");
                cursoValue.setText("");

            }
        }
    }//GEN-LAST:event_btnAgreCursoActionPerformed

    /*
     Retorna verdadero cuando la seccion seleccionada esta en la tabla
     */
    public Boolean buscarSeccionEnTablaDadoId(Integer id) {
        Boolean existe = false;

        if (!listSecciones.isEmpty()) {
            for (Seccion secc : listSecciones) {
                if (secc.getIdSeccion().equals(id)) {
                    return existe = true;
                }
            }

        }
        return existe;
    }

    public void obtenerSeccionDadoIdSeccion() {
        try {
            Seccion secc = (Seccion) cmbSeccion.getSelectedItem();
            if (secc != null) { 
                seccion.setIdSeccion(secc.getIdSeccion());
                SeccionDAO seccDAO = new SeccionImp();
                secc = seccDAO.obtenerSeccionDadoId(secc.getIdSeccion());
                seccion.getEstado().setNombre(secc.getEstado().getNombre());
                lblFechaTentativaValue.setText(String.valueOf(secc.getFechaTentativaInicio()));
                lblEstadoValue.setText(secc.getEstado().getNombre());
            } else {

            }

        } catch (Exception ex) {
            Logger.getLogger(InscribirEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void cmbSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSeccionActionPerformed

//        if(cmbSeccion.getItemCount() == 0){
//             String msj = "No existen secciones creadas para el curso seleccionado";
//            JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);
//                   lblFechaTentativaValue.setText("");
//                   lblEstadoValue.setText("");
//                  cmbSeccion.setVisible(false);
//                   cursoValue.setText("");
//                   
//        }   
    }//GEN-LAST:event_cmbSeccionActionPerformed

    private void btnCatalogoCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatalogoCursosActionPerformed
        listCurso = new ListadoCursos(null, true);
        listCurso.getBtnGenerarReporte().setVisible(false);
        listCurso.getBtnGenerarReporte().setName("Seleccionar");
        listCurso.setVisible(true);
        controlador = true;
    }//GEN-LAST:event_btnCatalogoCursosActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        cmbSeccion.removeAllItems();
        cursoSelected = listCurso.getCursoSeleccionado();

        if (cursoSelected != null) {

            cursoValue.setText(cursoSelected.getNombre());
            SeccionDAO seccdao = new SeccionImp();
            try {
                cmbSeccion.removeAllItems();
                seccdao.cargarComboSeccionDadoIdCurso(cmbSeccion, cursoSelected.getId());
                obtenerSeccionDadoIdSeccion();
                cmbSeccion.setVisible(true);
                if (cmbSeccion.getItemCount() == 0) {
                    cursoValue.setText("");
                    btnAgreCurso.setVisible(false);
                    cmbSeccion.setVisible(false);
                    if (controlador) {
                        cursoValue.setText("");
                        String msj = "El curso no posee secciones";
                        JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);
                        controlador = false;

                    }

                }

            } catch (Exception ex) {
                Logger.getLogger(AgregarSeccion.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void cmbSeccionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSeccionItemStateChanged
        obtenerSeccionDadoIdSeccion();
        btnAgreCurso.setVisible(true);
        seccion = (Seccion) cmbSeccion.getSelectedItem();

    }//GEN-LAST:event_cmbSeccionItemStateChanged

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
            java.util.logging.Logger.getLogger(InscribirEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InscribirEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InscribirEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InscribirEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InscribirEstudiante dialog = new InscribirEstudiante(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgreCurso;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCatalogoCursos;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cmbSeccion;
    private javax.swing.JLabel cursoValue;
    private javax.swing.JLabel fechaRegistroLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jtableCurso;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEstadoValue;
    private javax.swing.JLabel lblFechaRegistro;
    private javax.swing.JLabel lblFechaTentativaValue;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreValue;
    private javax.swing.JLabel lblSeccion;
    private javax.swing.JLabel lblTotCanc;
    private javax.swing.JLabel lblTotalCancelarValue;
    private javax.swing.JTextField txtCedula;
    // End of variables declaration//GEN-END:variables
public void cargarComboCurso() {

        Curso curs = new Curso();
        CursoDAO cursDAO = new CursoImp();
        try {
            //   cursDAO.cargarComboCurso(cmbCurso);
        } catch (Exception ex) {
            Logger.getLogger(InscribirEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void guardarItemEnTabla(Seccion secc) {
        //        
        Vector fila = new Vector();
        fila.add(secc.getIdSeccion());
        fila.add(cursoSelected.getNombre());
        fila.add(cursoSelected.getPrecio());
        fila.add(cursoSelected.getHoras());
        lblTotalCancelarValue.setText(String.valueOf(montoCancelar));
        m.addRow(fila);
        btnAgreCurso.setVisible(false);

    }

    public void generarFactura() {
    
        JasperReport jr = null;
        String archivo = "C:\\Users\\carlos\\Documents\\NetBeansProjects\\Librerias\\cadisystem\\src\\cadisystem\\report\\factura.jasper";
               
            Map params = new HashMap<String, String>();
          
          //  params.put("usuarios",listAux);
             JRDataSource jrdt = new JRBeanCollectionDataSource(listSecciones);
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
            
            jv.setTitle("Factura");
         
    }

    public void registarEstudianteEnSeccion(Vector<Seccion> listSecc, Integer idFact) {
        SeccionEstudianteDAO seccEstDAO = new SeccionEstudianteImp();
        SeccionEstudiante seccEst;
        Integer contador = 0;
        SeccionMovimientoDAO seccMovDao = new SeccionMovimientoImp();
        SeccionMovimiento seccMov;
        
        for (Seccion secc : listSecc) {
          seccMov = new SeccionMovimiento("Abierta",secc.getEstado().getNombre(), now, seccion.getIdSeccion());
      
  
            seccEst = new SeccionEstudiante(secc.getIdSeccion(), estudiante.getId(), now, idFact);
            
            try {
                   Integer cantEst;           
            cantEst = seccMovDao.obtenerCantidadDeEsttduiantesdadoIdSeccion(secc.getIdSeccion());
            if(cantEst == 0){
                SeccionDAO seccDao = new SeccionImp();
                secc.getEstado().setNombre("Abierta");
                seccDao.cambiarEstado(secc);
                seccMovDao.insertar(seccMov);
                
            String msj = "La Sección "+secc.getIdSeccion()+" ahora está Abierta";
            JOptionPane.showMessageDialog(null, msj, "Información", JOptionPane.INFORMATION_MESSAGE);
      
                seccEstDAO.insertar(seccEst);
                contador++;
            }
            } catch (Exception ex) {
                Logger.getLogger(InscribirEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        generarFactura();

    }

    public void Facturar(Factura fact) {
        FacturaDAO factDAO = new FacturaImp();
        Integer idFactura = -1;

        try {
            factDAO.insertar(fact);
            idFactura = factDAO.obtenerIdUltmimaFactura();
            factura.setIdFactura(idFactura);
            seccion.setFactura(factura);
            registarEstudianteEnSeccion(listSecciones, idFactura);

        } catch (Exception ex) {
            Logger.getLogger(InscribirEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
