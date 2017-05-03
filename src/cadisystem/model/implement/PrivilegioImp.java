/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.implement;

import cadisystem.model.BD.Conexion;
import cadisystem.model.DAO.PrivilegioDAO;
import cadisystem.model.dto.usuario.Privilegio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos
 */
public class PrivilegioImp extends Conexion implements PrivilegioDAO {

    @Override
    public List<Privilegio> listar() throws Exception {

    List<Privilegio> lista = null;
        
            try{
            
             this.conectar();
             
           
            PreparedStatement st =  this.cn.prepareStatement("SELECT * FROM privilegio");
           
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Privilegio pri = new Privilegio();
                pri.setId(rs.getInt("id"));
                pri.setDescripcion(rs.getString("descripcion"));
                lista.add(pri);
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
