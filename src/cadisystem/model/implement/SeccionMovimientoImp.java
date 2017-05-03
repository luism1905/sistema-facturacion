/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.model.implement;

import cadisystem.dto.seccion.SeccionMovimiento;
import cadisystem.model.BD.Conexion;
import cadisystem.model.DAO.SeccionMovimientoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author carlos
 */
public class SeccionMovimientoImp extends Conexion implements SeccionMovimientoDAO {

    @Override
    public void insertar(SeccionMovimiento seccEst) throws Exception {

        try {

            this.conectar();
            PreparedStatement st = this.cn.prepareStatement("INSERT INTO movimiento_seccion(estadoanterior,estadoactual,fecha,idseccion) VALUES (?,?,?,?);");
            st.setString(1, seccEst.getEstadoAnterior());
            st.setString(2, seccEst.getEstadoActual());          
            st.setDate(3, seccEst.getFecha());
            st.setInt(4, seccEst.getIdSeccion());  

            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }
    }

    @Override
    public void listarEstadosDadoIdSeccion(Integer idSeccion) {

//        SeccionMovimiento seccEst;
//        Vector <SeccionEstado> lista = new Vector();
//
//            try{
//            
//             this.conectar();
//             
//           
//            PreparedStatement st =  this.cn.prepareStatement("SELECT * FROM seccion_estado WHERE idfactura = "+idSeccion+";");
//           
//            ResultSet rs = st.executeQuery();
//            
//            while(rs.next()){
//                seccEst = new SeccionMovimiento();
//                seccEst.setId(rs.getInt("id"));
//                seccEst.setIdSeccion(rs.getInt("idseccion"));
//                seccEst.setIdEstado(rs.getInt("idestado"));
//                seccEst.setFecha(rs.getDate("monto"));
//                seccEst.setCantidad(rs.getInt("cantidad"));  
//                seccEst.setIdSeccion(rs.getInt("idseccion"));
//                seccEst.setDescripcion(rs.getString("descripcion"));
//                lista.add(seccEst);
//            }
//            rs.close();
//            st.close();
//            
//        }catch(Exception e){
//                throw e;
//            }
//            finally{
//
//                 this.desconectar();
//            }
//                return lista;
    }

    @Override
    public Integer obtenerCantidadDeEsttduiantesdadoIdSeccion(Integer id) throws Exception {
        Integer cantidad = -1;
        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("Select count(*) \n"
                    + "FROM estudiante, seccion, seccion_estudiante\n"
                    + "WHERE estudiante.idestudiante = seccion_estudiante.idestudiante\n"
                    + "AND seccion.idseccion = seccion_estudiante.idseccion\n"
                    + "AND seccion.idseccion = "+id+";");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cantidad = rs.getInt(1);

            }

            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println(e);
        } finally {

            this.desconectar();
        }
        return cantidad;

    }

}
