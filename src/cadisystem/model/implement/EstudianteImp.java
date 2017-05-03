/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.implement;

import cadisystem.model.BD.Conexion;
import cadisystem.model.DAO.EstudianteDAO;
import cadisystem.model.dto.estudiante.Estudiante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author carlos
 */
public class EstudianteImp extends Conexion implements EstudianteDAO {

    @Override
    public void insertar(Estudiante estudiante) throws Exception {

    
            try{
            
             this.conectar();
      //     cedula,nombres,apellidos,fecharegistro,telefono,direccion,estatus,otrotelefono,sexo
            PreparedStatement st =  this.cn.prepareStatement("call AGREGAR_ESTUDIANTE(?,?,?,?,?,?,?,?,?)");
            st.setString(1, estudiante.getCedula());
            st.setString(2, estudiante.getNombre());
            st.setString(3, estudiante.getApellido());
            st.setDate(4, estudiante.getFecharegistro());
            st.setString(5, estudiante.getTelefono());
            st.setString(6, estudiante.getDireccion());
            st.setString(7, estudiante.getOtroTelefono());
            st.setString(8, estudiante.getSexo());  
            st.setString(9, estudiante.getCorreo());    
            st.executeUpdate();
            
        }catch(Exception e){
            throw e;
        }
        finally{
           
             this.desconectar();
        }
    
    }

    @Override
    public void modificar(Estudiante estudiante) throws Exception {

     
        try{
            
             this.conectar();
           
            PreparedStatement st =  this.cn.prepareStatement("UPDATE estudiante "
                                    + "SET cedula = ?,nombres = ?,apellidos =?,"
                                    + "telefono = ?,direccion = ?,"
                                     + "otrotelefono = ?,sexo = ?, correo = ? \n" +
                                    " WHERE idestudiante = ?");
            st.setString(1, estudiante.getCedula());
            st.setString(2, estudiante.getNombre());
            st.setString(3, estudiante.getApellido());
            st.setString(4, estudiante.getTelefono());
            st.setString(5, estudiante.getDireccion());
            st.setString(6, estudiante.getOtroTelefono());
            st.setString(7, estudiante.getSexo());
            st.setString(8, estudiante.getCorreo());
            st.setInt(9,estudiante.getId());
     
            st.executeUpdate();
            
        }catch(Exception e){
            throw e;
        }
        finally{
           
            this.desconectar();
        }
        
    }

    @Override
    public void eliminar(Estudiante estudiante) throws Exception {
     
        try{
            
             this.conectar();
           
            PreparedStatement st =  this.cn.prepareStatement("UPDATE estudiante "
                                    + "SET estatus = 'E' WHERE idestudiante = ?");
            st.setInt(1, estudiante.getId());
            st.executeUpdate();
            
        }catch(Exception e){
            throw e;
        }
        finally{
           
            this.desconectar();
        }
    }

    @Override
    public Vector<Estudiante> listar() throws Exception {

      Estudiante estudiante;
        Vector <Estudiante> lista = new Vector();

            try{
            
             this.conectar();
             
           
            PreparedStatement st =  this.cn.prepareStatement("SELECT * FROM estudiante WHERE estatus = 'A'");
           
          
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
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
            
        }catch(Exception e){
            throw e;
        }
        finally{
           
             this.desconectar();
        }
            return lista;
        
     }

    @Override
    public Estudiante buscar(String patronBusqueda,Estudiante estudiante) throws Exception {

      try{
             this.conectar();
            PreparedStatement st =  this.cn.prepareStatement
                ("SELECT * FROM estudiante where cedula = '"+patronBusqueda+"' and estatus ="+"'A'");
              ResultSet rs = st.executeQuery();
            if(rs.next()){
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

            }
            else{
                 estudiante = new Estudiante();
                estudiante.setId(-1);
            }
            rs.close();
            st.close();
            
        }catch(Exception e){
            throw e;
        }
        finally{
           
             this.desconectar();
        }
    
    return estudiante;
    }

    @Override
    public String obtenerNombreSegunId(Integer id) throws Exception {
            String nombre;
        try {
            this.conectar();
            PreparedStatement st = this.cn.prepareStatement("SELECT nombres FROM estudiante\n"
                    + "WHERE idestudiante = ?;");
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
