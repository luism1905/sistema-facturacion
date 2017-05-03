/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.model.implement;

import cadisystem.model.BD.Conexion;
import cadisystem.model.DAO.UsuarioPrivilegioDAO;
import cadisystem.model.dto.usuario.Usuario;
import cadisystem.model.dto.usuario.UsuarioPrivilegio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos
 */
public class UsuarioPrivilegioImp extends Conexion implements UsuarioPrivilegioDAO {

    @Override
    public List<UsuarioPrivilegio> listar() throws Exception {

        List<UsuarioPrivilegio> lista = null;

        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("SELECT * FROM usuario_privilegio");

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UsuarioPrivilegio usp = new UsuarioPrivilegio();
                usp.setIdUsuario(rs.getInt("idusuario"));
                usp.setIdPrivilegios(rs.getInt("idprivilegio"));
                usp.setStatus(rs.getString("estatus"));
                lista.add(usp);
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
    public List<UsuarioPrivilegio> buscarPrivilegios(UsuarioPrivilegio usp) throws Exception {

        List<UsuarioPrivilegio> lista = new ArrayList();

        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("SELECT * FROM usuario_privilegio where idusuario ="
                    + " '" + usp.getIdUsuario() + "' and idprivilegio =" + " '" + usp.getIdPrivilegios() + "'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                usp.setIdUsuario(rs.getInt("idusuario"));
                usp.setIdPrivilegios(rs.getInt("idprivilegio"));
                usp.setStatus(rs.getString("estatus"));
                lista.add(usp);

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
    public void insertarUsuariosPrivilegios(Usuario us, Integer iterador) throws Exception {

        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("INSERT INTO usuario_privilegio(idusuario,idprivilegio,estatus) VALUES (?,?,?)");
            st.setInt(1, us.getId());
            st.setInt(2, us.getPrivilegios().get(iterador).getId());
            st.setString(3, us.getPrivilegios().get(iterador).getStatus());
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }

    }

    @Override
    public List<UsuarioPrivilegio> buscarPrivilegiosDadoUsuario(Integer usuario) throws Exception {

        List<UsuarioPrivilegio> listaP = new ArrayList();
        UsuarioPrivilegio usp;

        try {

            this.conectar();

            String sql = "SELECT cadif1.usuario_privilegio.id,idusuario,idprivilegio,estatus,descripcion"
                    + " FROM cadif1.usuario_privilegio, privilegio \n"
                    + "WHERE cadif1.usuario_privilegio.idusuario = " + usuario + "\n"
                    + "AND cadif1.usuario_privilegio.idprivilegio = cadif1.privilegio.id;";

            PreparedStatement st = this.cn.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                usp = new UsuarioPrivilegio();
                usp.setId(rs.getInt("id"));
                usp.setIdUsuario(rs.getInt("idusuario"));
                usp.setIdPrivilegios(rs.getInt("idprivilegio"));
                usp.setStatus(rs.getString("estatus"));
                usp.setNombrePrivilegio(rs.getString("descripcion"));
                listaP.add(usp);

            }
            rs.close();
            st.close();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }
        return listaP;

    }

    @Override
    public void actualizarEstatusPrivilegios(Integer id, String status) throws Exception {

        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("UPDATE usuario_privilegio "
                    + "SET estatus = ? "
                    + "WHERE id = ?;");
            st.setString(1, status);
            st.setInt(2, id);
       
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }

    }
}
