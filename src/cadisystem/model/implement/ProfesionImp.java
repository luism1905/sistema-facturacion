/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.implement;

import cadisystem.dto.asesor.Profesion;
import cadisystem.herramientas.Combo;
import cadisystem.model.BD.Conexion;
import cadisystem.model.DAO.ProfesionDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JComboBox;

/**
 *
 * @author carlos
 */
public class ProfesionImp extends Conexion implements ProfesionDAO{

    @Override
    public Vector<Profesion> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String obtenerNombreSegunId(Integer id) throws Exception {

            String nombre;
        try {
            this.conectar();
            PreparedStatement st = this.cn.prepareStatement("SELECT descripcion FROM profesion\n"
                    + "WHERE idprofesion = ?;");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                nombre = rs.getString("descripcion");

            } else {

                nombre = "";
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }

        return nombre;
    }

    @Override
    public void cargarComboProfesion(JComboBox jcmbx) throws Exception {

     
         jcmbx.removeAllItems();
         Profesion prof;

            try {
                this.conectar();
                PreparedStatement st = this.cn.prepareStatement("SELECT * FROM profesion WHERE estatus = 'A'");
                ResultSet rs = st.executeQuery();
                               prof = new Profesion();
                    prof.setId(-1);
                    prof.setDescripcion("Seleccione");
                    jcmbx.addItem(prof);
                while (rs.next()) {
                    prof = new Profesion();
                    prof.setId(rs.getInt("id"));
                    prof.setDescripcion(rs.getString("descripcion"));
                    jcmbx.addItem(prof);
                };
                rs.close();
                st.close();

            } catch (Exception e) {

            } finally {

                this.desconectar();
            }
    }
    
}
