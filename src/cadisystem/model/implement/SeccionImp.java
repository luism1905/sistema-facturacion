/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.model.implement;

import cadisystem.dto.asesor.Asesor;
import cadisystem.dto.curso.Curso;
import cadisystem.dto.seccion.Seccion;
import cadisystem.model.BD.Conexion;
import cadisystem.model.DAO.SeccionDAO;
import cadisystem.model.dto.estudiante.Estudiante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;

/**
 *
 * @author carlos
 */
public class SeccionImp extends Conexion implements SeccionDAO {

    @Override
    public void insertar(Seccion seccion) throws Exception {
        try {

            this.conectar();
            PreparedStatement st = this.cn.prepareStatement("call AGREGAR_SECCION(?,?,?,?,?);");
            st.setInt(1, seccion.getCurso().getId());
            st.setInt(2, seccion.getAsesor().getId());
            st.setDate(3, seccion.getFechaRegistro());
            st.setString(4, "Planificada"); //  estado planificada
            st.setDate(5, seccion.getFechaTentativaInicio());

            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }

    }

    @Override
    public void modificar(Seccion seccion) throws Exception {

        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("UPDATE seccion "
                    + "SET idasesor = ? , fechatentativainicio = ? "
                    + " WHERE idseccion = ?");

            st.setInt(1, seccion.getAsesor().getId());
            st.setDate(2, seccion.getFechaTentativaInicio());
            st.setInt(3, seccion.getIdSeccion());
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }
    }

    @Override
    public void eliminar(Seccion seccion) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // TODO: modificar este algoritmo YA NO FUNCIONA
    @Override
    public Vector<Seccion> listar() throws Exception {

        Seccion seccion;
        Vector<Seccion> lista = new Vector();

        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("SELECT seccion.idseccion,seccion.idasesor,seccion.idcurso,curso.nombre as nombrecurso, asesor.nombres as nombreasesor, seccion.estado as nombreestado, asesor.apellidos\n"
                    + "FROM seccion, asesor,curso\n"
                    + "WHERE seccion.idasesor = asesor.idasesor\n"
                    + "AND seccion.idcurso = curso.idcurso;");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                seccion = new Seccion();
                seccion.setIdSeccion(rs.getInt("idseccion"));
                seccion.getAsesor().setId(rs.getInt("idasesor"));
                seccion.getCurso().setId(rs.getInt("idcurso"));
                seccion.getAsesor().setNombre(rs.getString("nombreasesor"));
                seccion.getAsesor().setApellido(rs.getString("apellidos"));
                seccion.getCurso().setNombre(rs.getString("nombrecurso"));
                seccion.getEstado().setNombre(rs.getString("nombreestado"));
                lista.add(seccion);
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
    public Seccion buscar(Integer idSeccion) throws Exception {

        Seccion seccion;
        try {
            this.conectar();
            PreparedStatement st = this.cn.prepareStatement("SELECT fechatentativainicio as fechati, asesor.idasesor as idasesor, asesor.nombres as nombreasesor, asesor.apellidos,\n"
                    + " curso.idcurso as idcurso, curso.nombre as nombrecurso,curso.precio,\n"
                    + "seccion.idseccion as idseccion, estado as nombreestado\n"
                    + "FROM asesor, curso,seccion,asesor_curso\n"
                    + "WHERE seccion.idseccion = " + idSeccion + "  \n"
                    + "AND seccion.idasesor = asesor.idasesor\n"
                    + "AND seccion.idcurso = curso.idcurso\n"
                    + "AND asesor_curso.idasesor = asesor.idasesor\n"
                    + "AND asesor_curso.idcurso = curso.idcurso");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                seccion = new Seccion();
                seccion.setIdSeccion(rs.getInt("idseccion"));
                seccion.setFechaTentativaInicio(rs.getDate("fechati"));
                seccion.getAsesor().setId(rs.getInt("idasesor"));
                seccion.getAsesor().setNombre(rs.getString("nombreasesor"));
                seccion.getAsesor().setApellido(rs.getString("apellidos"));
                seccion.getCurso().setId(rs.getInt("idcurso"));
                seccion.getCurso().setNombre(rs.getString("nombrecurso"));
                seccion.getCurso().setPrecio(-rs.getFloat("precio"));
                seccion.getCurso().setId(rs.getInt("idcurso"));
                seccion.getEstado().setNombre(rs.getString("nombreestado"));

            } else {
                seccion = new Seccion();
                seccion.setIdSeccion(-1);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }
        return seccion;

    }

    @Override
    public Integer obtenerUltimoIdSeccion() throws Exception {

        Integer id = -2;
        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("SELECT MAX(idseccion) FROM seccion ");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);

            }

            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println(e);
        } finally {

            this.desconectar();
        }
        return id;

    }

    @Override
    public Boolean cambiarEstado(Seccion seccion) throws Exception {
        Boolean updated = false;
        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("UPDATE seccion\n"
                    + "SET estado = ?\n"
                    + "WHERE idseccion = ?;");

            st.setString(1, seccion.getEstado().getNombre());
            st.setInt(2, seccion.getIdSeccion());
            st.executeUpdate();
            updated = true;

        } catch (Exception e) {
            updated = false;
            throw e;
        } finally {

            this.desconectar();
        }
        /*
                
         */

        return updated;
    }

    /*
    
     @Override
     public void modificar(Curso seccion) throws Exception {
        
        

     }

     @Override
     public void eliminar(Curso seccion) throws Exception {

     try {

     this.conectar();

     PreparedStatement st = this.cn.prepareStatement("UPDATE seccion "
     + "SET estatus = 'E' WHERE idcurso = ?");
     st.setInt(1, seccion.getId());
     st.executeUpdate();

     } catch (Exception e) {
     throw e;
     } finally {

     this.desconectar();
     }

     }

     @Override
     public Vector<Curso> listar() throws Exception {

    
     }

     @Override
     public Curso buscar(String patronBusqueda, Curso seccion) throws Exception {

     try {
     this.conectar();
     PreparedStatement st = this.cn.prepareStatement("SELECT * FROM asesor where nombre = '" + patronBusqueda + "' and estatus =" + "'A'");
     ResultSet rs = st.executeQuery();
     if (rs.next()) {
     seccion = new Curso();
     seccion.setId(rs.getInt("idcurso"));
     seccion.setNombre(rs.getString("nombre"));
     seccion.setHoras(rs.getInt("horas"));
     seccion.setPrecio(rs.getFloat("telefono"));
                

     } else {
     seccion = new Curso();
     seccion.setId(-1);
     }
     rs.close();
     st.close();

     } catch (Exception e) {
     throw e;
     } finally {

     this.desconectar();
     }

     return seccion;
     }

     @Override
     public Integer obtenerUltimoIdCurso() throws Exception {

     Integer id = -2;
     try{
            
     this.conectar();
             
           
     PreparedStatement st =  this.cn.prepareStatement
     ("SELECT MAX(id) FROM seccion ");
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
    
    
     }

    
     */
    @Override
    public void cargarComboAsesor(JComboBox jcmbx) throws Exception {

        jcmbx.removeAllItems();
        Asesor asesor;

        try {
            this.conectar();
            PreparedStatement st = this.cn.prepareStatement("SELECT * FROM asesor WHERE estatus = 'A'");
            ResultSet rs = st.executeQuery();
            asesor = new Asesor();
            asesor.setId(-1);
            asesor.setNombre("Seleccione");
            jcmbx.addItem(asesor);
            while (rs.next()) {
                asesor = new Asesor();
                asesor.setId(rs.getInt("idasesor"));
                asesor.setNombre(rs.getString("nombres"));
                asesor.setApellido(rs.getString("apellidos"));
                jcmbx.addItem(asesor);
            };
            rs.close();
            st.close();

        } catch (Exception e) {

        } finally {

            this.desconectar();
        }
    }

    @Override
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
                curso.setPrecio(rs.getFloat("precio"));
                jcmbx.addItem(curso);
            };
            rs.close();
            st.close();

        } catch (Exception e) {

        } finally {

            this.desconectar();
        }
    }

    @Override
    public void cargarComboSeccionDadoIdCurso(JComboBox jcmbx, Integer idCurso) throws Exception {

        Seccion seccion;

        try {
            this.conectar();
            PreparedStatement st = this.cn.prepareStatement("SELECT  * FROM seccion,curso "
                    + "where  seccion.idcurso = " + idCurso + "\n"
                    + "  AND seccion.idcurso = curso.idcurso;;");
            ResultSet rs = st.executeQuery();
            //          seccion = new Seccion();
//            seccion.setIdSeccion(-1);
//            jcmbx.addItem(seccion);
            jcmbx.removeAllItems();
            while (rs.next()) {
                if (!rs.getString("estado").equals("Cerrada")) {
                    seccion = new Seccion();
                    seccion.setIdSeccion(rs.getInt("idseccion"));
                    jcmbx.addItem(seccion);
                }

            };
            rs.close();
            st.close();

        } catch (Exception e) {

        } finally {

            this.desconectar();
        }
    }

    @Override
    public Seccion obtenerSeccionDadoId(Integer idSeccion) throws Exception {

        Seccion secc = new Seccion();
        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("SELECT * FROM seccion where idseccion = " + idSeccion + ";");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                secc.setIdSeccion(rs.getInt("idseccion"));
                secc.setFechaTentativaInicio(rs.getDate("fechatentativainicio"));
                secc.getEstado().setNombre(rs.getString("estado"));
            } else {
                secc.setIdSeccion(-1);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }
        return secc;

    }

    @Override
    public void cargarComboAsesorDadiIdCurso(JComboBox jcmbx, Integer idCurso) throws Exception {

        jcmbx.removeAllItems();
        Asesor asesor;

        try {
            this.conectar();
            PreparedStatement st = this.cn.prepareStatement("SELECT *\n"
                    + " FROM asesor,curso,asesor_curso\n"
                    + " WHERE asesor.estatus = 'A'\n"
                    + " AND asesor.idasesor = asesor_curso.idasesor\n"
                    + " AND curso.idcurso = asesor_curso.idcurso\n"
                    + " AND curso.idcurso = " + idCurso + ";");
            ResultSet rs = st.executeQuery();
            asesor = new Asesor();
            asesor.setId(-1);
            asesor.setNombre("Seleccione");
            jcmbx.addItem(asesor);
            while (rs.next()) {
                asesor = new Asesor();
                asesor.setId(rs.getInt("idasesor"));
                asesor.setNombre(rs.getString("nombres"));
                asesor.setApellido(rs.getString("apellidos"));
                jcmbx.addItem(asesor);
            };
            rs.close();
            st.close();

        } catch (Exception e) {

        } finally {

            this.desconectar();
        }

    }

    @Override
    public void iniciarSeccion(Seccion seccion) throws Exception {

        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("UPDATE seccion "
                    + "SET fechainicio = ? , estado = ? "
                    + " WHERE idseccion = ?");

            st.setDate(1, seccion.getFechaInicio());
            st.setString(2, seccion.getEstado().getNombre());
            st.setInt(3, seccion.getIdSeccion());
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }

    }

    @Override
    public void cerrarSeccion(Seccion seccion) throws Exception {

        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("UPDATE seccion "
                    + "SET fechaculminacion = ? , estado = ? "
                    + " WHERE idseccion = ?");

            st.setDate(1, seccion.getFechaCulminacion());
            st.setString(2, seccion.getEstado().getNombre());
            st.setInt(3, seccion.getIdSeccion());
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }

    }

    @Override
    public Vector<Estudiante> obtenerEstudiantesDadoIdSeccion(Integer idSeccion) throws Exception {
        Estudiante estudiante;
        Vector<Estudiante> lista = new Vector();

        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("SELECT * FROM estudiante,seccion_estudiante,seccion\n"
                    + "WHERE estudiante.idestudiante = seccion_estudiante.idestudiante\n"
                    + "AND seccion_estudiante.idseccion = seccion.idseccion\n"
                    + "AND seccion.idseccion ="+idSeccion+";");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                estudiante = new Estudiante();
                estudiante.setNombre(rs.getString("nombres"));
                estudiante.setApellido(rs.getString("apellidos"));
                lista.add(estudiante);
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
}
