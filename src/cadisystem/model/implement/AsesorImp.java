/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.model.implement;

import cadisystem.dto.asesor.Asesor;
import cadisystem.dto.curso.Curso;
import cadisystem.model.BD.Conexion;
import cadisystem.model.DAO.AsesorDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JComboBox;

/**
 *
 * @author carlos
 */
public class AsesorImp extends Conexion implements AsesorDAO {

    @Override
    public void insertar(Asesor asesor) throws Exception {

        try {

            this.conectar();
            PreparedStatement st = this.cn.prepareStatement("call AGREGAR_ASESOR(?,?,?,?,?,?,?,?,?)");
            st.setString(1, asesor.getCedula());
            st.setString(2, asesor.getNombre());
            st.setString(3, asesor.getApellido());
            st.setInt(4, asesor.getIdProfesion());
            st.setString(5, asesor.getTelefono());
            st.setString(6, asesor.getCorreo());
            st.setDate(7, asesor.getFechaRegistro());
            st.setString(9, asesor.getOtroTelefono());
            st.setString(8, asesor.getSexo());

            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }
    }

    @Override
    public void modificar(Asesor asesor) throws Exception {

        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("UPDATE asesor "
                    + "SET cedula = ?,nombres = ?,apellidos = ?,"
                    + "idprofesion = ?,telefono = ?,correo = ?,"
                    + "otrotelefono = ?,sexo = ? \n"
                    + " WHERE idasesor = ?");

            st.setString(1, asesor.getCedula());
            st.setString(2, asesor.getNombre());
            st.setString(3, asesor.getApellido());
            st.setInt(4, asesor.getIdProfesion());
            st.setString(5, asesor.getTelefono());
            st.setString(6, asesor.getCorreo());
            st.setString(7, asesor.getOtroTelefono());
            st.setString(8, asesor.getSexo());
            st.setInt(9, asesor.getId());
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }

    }

    @Override
    public void eliminar(Asesor asesor) throws Exception {

        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("UPDATE asesor "
                    + "SET estatus = 'E' WHERE idasesor = ?");
            st.setInt(1, asesor.getId());
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }

    }

    @Override
    public Vector<Asesor> listar() throws Exception {

        Asesor asesor;
        Vector<Asesor> lista = new Vector();

        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("SELECT * FROM asesor,profesion WHERE asesor.estatus = 'A' AND idprofesion = id;");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                asesor = new Asesor();
                asesor.setId(rs.getInt("idasesor"));
                asesor.setCedula(rs.getString("cedula"));
                asesor.setNombre(rs.getString("nombres"));
                asesor.setApellido(rs.getString("apellidos"));
                asesor.setTelefono(rs.getString("telefono"));
                asesor.setOtroTelefono(rs.getString("otrotelefono"));
                asesor.setSexo(rs.getString("sexo"));
                asesor.setStatus(rs.getString("estatus"));
                asesor.setFechaRegistro(rs.getDate("fecharegistro"));
                asesor.setCorreo(rs.getString("correo"));
                asesor.setIdProfesion(rs.getInt("idprofesion"));
                asesor.setProfesion(rs.getString("descripcion"));      
                lista.add(asesor);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }
        return lista;

    }

    @Override
    public Asesor buscar(String patronBusqueda, Asesor asesor) throws Exception {

        try {
            this.conectar();
            PreparedStatement st = this.cn.prepareStatement("SELECT * FROM asesor where cedula = '" + patronBusqueda + "' and estatus =" + "'A'");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                asesor = new Asesor();
                asesor.setId(rs.getInt("idasesor"));
                asesor.setCedula(rs.getString("cedula"));
                asesor.setNombre(rs.getString("nombres"));
                asesor.setApellido(rs.getString("apellidos"));
                asesor.setTelefono(rs.getString("telefono"));
                asesor.setOtroTelefono(rs.getString("otrotelefono"));
                asesor.setSexo(rs.getString("sexo"));
                asesor.setStatus(rs.getString("estatus"));
                asesor.setFechaRegistro(rs.getDate("fecharegistro"));
                asesor.setCorreo(rs.getString("correo"));
                asesor.setIdProfesion(rs.getInt("idprofesion"));

            } else {
                asesor = new Asesor();
                asesor.setId(-1);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }

        return asesor;
    }

    @Override
    public String obtenerNombreSegunId(Integer id) throws Exception {

        String nombre;
        try {
            this.conectar();
            PreparedStatement st = this.cn.prepareStatement("SELECT nombres FROM asesor\n"
                    + "WHERE idasesor = ?;");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                nombre = rs.getString("nombres");

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
    
    

}
