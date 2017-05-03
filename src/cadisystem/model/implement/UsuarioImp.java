/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.implement;

import cadisystem.model.BD.Conexion;
import cadisystem.model.DAO.UsuarioDAO;
import cadisystem.model.dto.usuario.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlos
 */
public class UsuarioImp extends Conexion implements UsuarioDAO {

    @Override
    public void registrar(Usuario usuario) throws Exception {

            try{
            
             this.conectar();
           
            PreparedStatement st =  this.cn.prepareStatement("call AGREGAR_USUARIO(?,?,?,?);");
            st.setString(1, usuario.getUsername());
            st.setString(2, usuario.getContrasenha());
            st.setString(3, usuario.getCorreo());
            st.setDate(4,usuario.getFechaRegistro());
            st.executeUpdate();
            
        }catch(Exception e){
            throw e;
        }
        finally{
           
             this.desconectar();
        }
    
    }

    @Override
    public void modificar(Usuario usuario) throws Exception {
        
        try{
            
             this.conectar();
           
            PreparedStatement st =  this.cn.prepareStatement("UPDATE usuario SET contrasenha = ? where id =? ");
            st.setString(1, usuario.getContrasenha());
            st.setInt(2, usuario.getId());      
            st.executeUpdate();
            
        }catch(Exception e){
            throw e;
        }
        finally{
           
            this.desconectar();
        }
        
    }

    @Override
    public void eliminar(Usuario usuario) throws Exception {

            try{
            
             this.conectar();
           
            PreparedStatement st =  this.cn.prepareStatement("UPDATE usuario SET estatus ="+"'E'"+" where id = ? ");
            st.setInt(1, usuario.getId());
            st.executeUpdate();
            
        }catch(Exception e){
            throw e;
        }
        finally{
           
             this.desconectar();
        }
    
    }


    @Override
    public Usuario buscar(String patronBusqueda) throws Exception {
        Usuario us = new Usuario();
            try{
            
             this.conectar();
             
           
            PreparedStatement st =  this.cn.prepareStatement
                ("SELECT * FROM usuario where nombre = '"+patronBusqueda+"' and estatus ="+"'A'");
              ResultSet rs = st.executeQuery();
            if(rs.next()){
                us.setId(rs.getInt("id"));
                us.setUsername(rs.getString("nombre"));
                us.setContrasenha(rs.getString("contrasenha"));
                us.setCorreo(rs.getString("correo"));
                us.setFechaRegistro(rs.getDate("fecharegistro"));

            }
            else{
                us.setId(-1);
            }
            rs.close();
            st.close();
            
        }catch(Exception e){
            throw e;
        }
        finally{
           
             this.desconectar();
        }
            return us;
    
    }

    @Override
    public Usuario autenticar(String n, String p) throws Exception {
     Usuario user = null;
    Integer id = -2;
            try{
            
             this.conectar();
             
           
            PreparedStatement st =  this.cn.prepareStatement
                ("SELECT * FROM usuario where nombre = ? AND contrasenha = ? AND estatus ="+"'A'");
            st.setString(1, n);
            st.setString(2, p);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                user = new Usuario();
                user.setUsername(rs.getString("nombre"));
                user.setId(rs.getInt("id"));
                user.setContrasenha(rs.getString("contrasenha"));
            }
            else{
                
                user = null;
            }
            
            rs.close();
            st.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        finally{
           
             this.desconectar();
        }
            return user;
    
    }

    @Override
    public Integer obtenerUltimoIdUsuario () {
        Integer id = -2;
            try{
            
             this.conectar();
             
           
            PreparedStatement st =  this.cn.prepareStatement
                ("SELECT MAX(id) FROM usuario");
              ResultSet rs = st.executeQuery();
            while(rs.next()){
                id = rs.getInt(1);
     
            }
            
            rs.close();
            st.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        finally{
           
             this.desconectar();
        }
            return id;
    }

    @Override
    public Usuario login() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector<Usuario> listar() throws Exception {

     Usuario us;
        Vector <Usuario> lista = new Vector();

            try{
            
             this.conectar();
             
           
            PreparedStatement st =  this.cn.prepareStatement("SELECT * FROM usuario where estatus ="+"'A' ORDER BY fecharegistro");
           
          
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                us = new Usuario();
                us.setId(rs.getInt("id"));
                us.setUsername(rs.getString("nombre"));
                us.setContrasenha(rs.getString("contrasenha"));
                us.setCorreo(rs.getString("correo"));
                us.setFechaRegistro(rs.getDate("fecharegistro"));
                us.setEstatus(rs.getString("estatus"));
                lista.add(us);
            }
            rs.close();
            st.close();
            
        }catch(Exception e){
            throw e;
        }
        finally{
           
             this.desconectar();
        }
            return lista;
        
    }

    
}
