/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.implement;

import cadisystem.dto.factura.Factura;
import cadisystem.model.BD.Conexion;
import cadisystem.model.DAO.FacturaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author carlos
 */
public class FacturaImp extends Conexion implements FacturaDAO {

    @Override
    public void insertar(Factura factura) throws Exception {
       
        try {

            this.conectar();
                    // call AGREGAR_FACTURA(?,?,?);
            PreparedStatement st = this.cn.prepareStatement("insert into factura(idestudiante,fechaemision,montoTotal) values(?,?,?)");
            st.setInt(1,factura.getIdEstudiante());
            st.setDate(2, factura.getFechaEmision());
            st.setFloat(3, factura.getMontoTotal());
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }
    }

    @Override
    public Integer obtenerIdUltmimaFactura() throws Exception {
        Integer id = -1;
            try{
            
             this.conectar();
             
           
            PreparedStatement st =  this.cn.prepareStatement
                ("SELECT MAX(id_factura) FROM factura");
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
    public Vector <Factura> listar() throws Exception {
        
     Factura factura;
        Vector <Factura> lista = new Vector();

            try{
            
             this.conectar();
             
           
            PreparedStatement st =  this.cn.prepareStatement("SELECT * FROM factura;");
           
          
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                factura = new Factura();
                factura.setIdFactura(rs.getInt("id_factura"));
                factura.setIdEstudiante(rs.getInt("idestudiante"));
                factura.setFechaEmision(rs.getDate("fechaemision"));
                factura.setMontoTotal(rs.getFloat("montoTotal"));
                lista.add(factura);
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
