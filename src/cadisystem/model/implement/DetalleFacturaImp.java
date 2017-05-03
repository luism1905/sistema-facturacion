/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.model.implement;

import cadisystem.dto.factura.DetalleFactura;
import cadisystem.dto.factura.Factura;
import cadisystem.model.BD.Conexion;
import cadisystem.model.DAO.DetalleFacturaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author carlos
 */
public class DetalleFacturaImp extends Conexion implements DetalleFacturaDAO {

    @Override
    public void insertar(DetalleFactura detFactura) throws Exception {

        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("INSERT INTO detfactura(precio,cantidad,idfactura,idestudiante,descripcion,monto) VALUES (?,?,?,?,?,?);");

            st.setFloat(1, detFactura.getPrecio());
            st.setInt(2, detFactura.getCantidad());
            st.setInt(3, detFactura.getIdFactura());
            st.setInt(4, detFactura.getIdEstudiante());
            st.setString(5, detFactura.getDescripcion());
            st.setFloat(6, detFactura.getMonto());
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }
    }

    @Override
    public  Vector <DetalleFactura> listarDetalleFacturaDadoIdfactura(Integer idFactura) throws Exception {

     DetalleFactura detFactura;
        Vector <DetalleFactura> lista = new Vector();

            try{
            
             this.conectar();
             
           
            PreparedStatement st =  this.cn.prepareStatement("SELECT * FROM detfactura WHERE idfactura = "+idFactura+";");
           
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                detFactura = new DetalleFactura();
                detFactura.setIdDetalleFactura(rs.getInt("id"));
                detFactura.setPrecio(rs.getFloat("precio"));
                detFactura.setIdFactura(rs.getInt("idfactura"));
                detFactura.setMonto(rs.getFloat("monto"));
                detFactura.setCantidad(rs.getInt("cantidad"));  
                detFactura.setIdEstudiante(rs.getInt("idestudiante"));
                detFactura.setDescripcion(rs.getString("descripcion"));
                lista.add(detFactura);
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
