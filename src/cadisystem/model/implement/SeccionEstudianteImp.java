/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.model.implement;

import cadisystem.dto.seccion.SeccionEstudiante;
import cadisystem.model.BD.Conexion;
import cadisystem.model.DAO.SeccionEstudianteDAO;
import cadisystem.model.dto.estudiante.Estudiante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author carlos
 */
public class SeccionEstudianteImp extends Conexion implements SeccionEstudianteDAO {

    @Override
    public void insertar(SeccionEstudiante secEst) throws Exception {

        try {

            this.conectar();
            PreparedStatement st = this.cn.prepareStatement("INSERT INTO seccion_estudiante(idseccion,idestudiante,fechainscripcion,idfactura) VALUES(?,?,?,?);");
            st.setInt(1, secEst.getIdSeccion());
            st.setInt(2, secEst.getIdEstudiante());
            st.setDate(3, secEst.getFechaRegistro());
            st.setInt(4, secEst.getIdFactura());
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }

    }

    @Override
    public Vector<Estudiante> listarEstudiantesDadoIdSeccion(Integer idSeccion) {

        Vector<Estudiante> lista = new Vector();
        Estudiante estudiante;

        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("SELECT * FROM estudiante,seccion,seccion_estudiante\n"
                    + "WHERE estudiante.estatus ='A'\n"
                    + "AND estudiante.idestudiante = seccion_estudiante.idestudiante\n"
                    + "AND seccion.idseccion = seccion_estudiante.idseccion\n"
                    + "AND seccion.idseccion = "+idSeccion+";");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                estudiante = new Estudiante();
                estudiante.setId(rs.getInt("idestudiante"));
                estudiante.setCedula(rs.getString("cedula"));
                estudiante.setNombre(rs.getString("nombres"));
                estudiante.setApellido(rs.getString("apellidos"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setOtroTelefono(rs.getString("otrotelefono"));
                estudiante.setSexo(rs.getString("sexo"));
                estudiante.setStatus(rs.getString("estatus"));
                estudiante.setFecharegistro(rs.getDate("fecharegistro"));
                estudiante.setCorreo(rs.getString("correo"));
                estudiante.setDireccion(rs.getString("direccion"));
                lista.add(estudiante);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println(e);
        } finally {

            this.desconectar();
        }
        return lista;

    }

}
