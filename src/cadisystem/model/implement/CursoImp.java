/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.implement;

import cadisystem.dto.curso.Curso;
import cadisystem.model.BD.Conexion;
import cadisystem.model.DAO.CursoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JComboBox;

/**
 *
 * @author carlos
 */
public class CursoImp extends Conexion implements CursoDAO {

    @Override
    public void insertar(Curso curso) throws Exception {

    
        try {

            this.conectar();
            PreparedStatement st = this.cn.prepareStatement("INSERT INTO curso(nombre, horas,precio) VALUES(?,?,?)");
            st.setString(1, curso.getNombre());
            st.setInt(2, curso.getHoras());
            st.setFloat(3, curso.getPrecio());
          
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }
    }

    @Override
    public void modificar(Curso curso) throws Exception {
        
        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement
                    ("UPDATE curso "
                    + "SET nombre = ?,horas = ?,precio = ? "
                    + " WHERE idcurso = ?");

            st.setString(1, curso.getNombre());
            st.setInt(2, curso.getHoras());
            st.setFloat(3, curso.getPrecio());
            st.setInt(4, curso.getId());
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }

    }

    @Override
    public void eliminar(Curso curso) throws Exception {

     try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("UPDATE curso "
                    + "SET estatus = 'E' WHERE idcurso = ?");
            st.setInt(1, curso.getId());
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }

    }

    @Override
    public Vector<Curso> listar() throws Exception {

    
        Curso curso;
        Vector<Curso> lista = new Vector();

        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("SELECT * FROM curso WHERE estatus = 'A'");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
               curso = new Curso();
                curso.setId(rs.getInt("idcurso"));
                curso.setNombre(rs.getString("nombre"));
                curso.setPrecio(rs.getFloat("precio"));
                curso.setHoras(rs.getInt("horas"));
                lista.add(curso);
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
    public Curso buscar(String patronBusqueda, Curso curso) throws Exception {

     try {
            this.conectar();
            PreparedStatement st = this.cn.prepareStatement("SELECT * FROM asesor where nombre = '" + patronBusqueda + "' and estatus =" + "'A'");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                curso = new Curso();
                curso.setId(rs.getInt("idcurso"));
                curso.setNombre(rs.getString("nombre"));
                curso.setHoras(rs.getInt("horas"));
                curso.setPrecio(rs.getFloat("telefono"));
                

            } else {
                curso = new Curso();
                curso.setId(-1);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }

        return curso;
    }

    @Override
    public Integer obtenerUltimoIdCurso() throws Exception {

     Integer id = -2;
            try{
            
             this.conectar();
             
           
            PreparedStatement st =  this.cn.prepareStatement
                ("SELECT MAX(idcurso) FROM curso ");
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
    public String obtenerNombreSegunId(Integer id) throws Exception {

            String nombre;
        try {
            this.conectar();
            PreparedStatement st = this.cn.prepareStatement("SELECT nombre FROM curso\n"
                    + "WHERE idcurso = ?;");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                nombre = rs.getString("nombre");

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
    
    public void cargarComboCurso(JComboBox jcmbx) throws Exception {

     
         jcmbx.removeAllItems();
         Curso curso;

            try {
                this.conectar();
                PreparedStatement st = this.cn.prepareStatement("SELECT * FROM curso WHERE estatus = 'A'");
                ResultSet rs = st.executeQuery();
                               curso = new Curso();
                    curso.setId(-1);
                    curso.setNombre("Seleccione");
                    jcmbx.addItem(curso);
                while (rs.next()) {
                    curso = new Curso();
                    curso.setId(rs.getInt("idcurso"));
                    curso.setNombre(rs.getString("nombre"));
                    jcmbx.addItem(curso);
                };
                rs.close();
                st.close();

            } catch (Exception e) {

            } finally {

                this.desconectar();
            }
    }
  
}
