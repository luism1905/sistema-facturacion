/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.model.implement;

import cadisystem.dto.seccion.SeccionHistorico;
import cadisystem.model.BD.Conexion;
import cadisystem.model.DAO.SeccionHistoricoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import sun.nio.cs.HistoricallyNamedCharset;

/**
 *
 * @author carlos
 */
public class SeccionHistoricoImp extends Conexion implements SeccionHistoricoDAO {

    @Override
    public void insertar(SeccionHistorico seccionH) throws Exception {

        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("INSERT INTO historico_seccion(descripcion,idseccion) VALUES (?,?);");
            st.setString(1, seccionH.getDescripcion());
            st.setInt(2, seccionH.getIdseccion());

            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }

    }

    @Override
    public Vector<SeccionHistorico> listarHistoricoDadoIdSeccion(Integer idSeccion) throws Exception {

        Vector<SeccionHistorico> lista = new Vector();
        SeccionHistorico secch;

        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("SELECT historico_seccion.descripcion\n"
                    + "FROM historico_seccion,seccion\n"
                    + "WHERE historico_seccion.idseccion = seccion.idseccion\n"
                    + "AND seccion.idseccion = "+idSeccion+";");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                secch = new SeccionHistorico();
                secch.setDescripcion(rs.getString("descripcion"));
                lista.add(secch);
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
