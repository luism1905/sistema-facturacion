/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.model.implement;

import cadisystem.dto.asesor.Asesor;
import cadisystem.dto.asesor.AsesorCurso;
import cadisystem.dto.asesor.Profesion;
import cadisystem.dto.curso.Curso;
import cadisystem.model.BD.Conexion;
import cadisystem.model.DAO.AsesorCursoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JComboBox;

/**
 *
 * @author carlos
 */
public class AsesorCursoImp extends Conexion implements AsesorCursoDAO {

    @Override
    public void insertar(AsesorCurso asec) throws Exception {

        try {

            this.conectar();
            PreparedStatement st = this.cn.prepareStatement("INSERT INTO asesor_curso(idasesor,idcurso) VALUES(?,?);");
            st.setInt(1, asec.getIdAsesor());
            st.setInt(2, asec.getIdCurso());

            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }
    }

    @Override
    public void modificar(AsesorCurso asec) throws Exception {

        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("UPDATE asesor_curso "
                    + "SET idcurso = ? WHERE idasesor = ?");

            st.setInt(1, asec.getIdCurso());
            st.setInt(2, asec.getIdAsesor());
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }

    }

    @Override
    public Vector<AsesorCurso> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector<AsesorCurso> listadoCursosDaoIdAsesor(Integer id) throws Exception {
        Vector<AsesorCurso> lista = new Vector();
        AsesorCurso asec;

        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement("SELECT * FROM cadif1.asesor_curso, asesor,curso\n"
                    + "WHERE asesor.idasesor = " + id + "\n"
                    + "AND asesor.idasesor = asesor_curso.idasesor\n"
                    + "AND curso.idcurso = asesor_curso.idcurso;");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                asec = new AsesorCurso();
                asec.setIdAsesor(rs.getInt("idasesor"));
                asec.setIdCurso(rs.getInt("idcurso"));
                asec.setCurso(rs.getString("nombre"));
                asec.setAsesor(rs.getString("nombres"));
                lista.add(asec);
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
    public void cargarComboAsesorDadoIdCurso(Integer idCurso, JComboBox cmb) throws Exception {
        String sql = "SELECT asesor.idasesor, asesor.nombres, asesor.apellidos \n"
                + "FROM asesor,asesor_curso,curso\n"
                + "WHERE asesor.idasesor = asesor_curso.idasesor\n"
                + "AND curso.idcurso = " + idCurso + " \n"
                + "AND asesor_curso.idcurso = curso.idcurso\n"
                + "AND asesor.estatus = 'A'\n"
                + "AND curso.estatus = 'A';";

        cmb.removeAllItems();
        Asesor ase;

        try {
            this.conectar();
            PreparedStatement st = this.cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            ase = new Asesor();
            ase.setId(-1);
            ase.setNombre("Seleccione");
            cmb.addItem(ase);
            while (rs.next()) {
                ase = new Asesor();
                ase.setId(rs.getInt("idasesor"));
                ase.setNombre(rs.getString("nombres"));
                ase.setApellido(rs.getString("apellidos"));
                cmb.addItem(ase);
            };
            rs.close();
            st.close();

        } catch (Exception e) {

        } finally {

            this.desconectar();
        }

    }

    @Override
    public Integer obtenerIDAsesorCursoParaEliminar(Integer idAsesor, Integer idCurso) throws Exception {
        Integer id = null;
        String sql = "SELECT asesor_curso.idasesor_curso\n"
                + "FROM asesor_curso\n"
                + "WHERE asesor_curso.idasesor = " + idAsesor + "\n"
                + "AND asesor_curso.idcurso = " + idCurso + ";";

        try {
            this.conectar();
            PreparedStatement st = this.cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                id = rs.getInt("idasesor_curso");

            } else {
                id = -1;
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }
        return id;
    }

    @Override
    public void eliminar(AsesorCurso asec) throws Exception {

        String sql = "DELETE FROM asesor_curso\n"
                + "WHERE asesor_curso.idasesor = ?\n"
                + "AND asesor_curso.idcurso = ?\n"
                + "AND asesor_curso.idasesor_curso = ?;";

        try {

            this.conectar();

            PreparedStatement st = this.cn.prepareStatement(sql);

            st.setInt(1, asec.getIdAsesor());
            st.setInt(2, asec.getIdCurso());
            st.setInt(3, asec.getIdAsesorCurso());
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {

            this.desconectar();
        }

    }

    @Override
    public void cargarComboCursoDadoIdAsesor(Integer idAsesor, JComboBox cmb) throws Exception {

        String sql = "SELECT curso.idcurso, curso.nombre\n"
                + "FROM asesor,asesor_curso,curso\n"
                + "WHERE asesor.idasesor = "+idAsesor+"\n"
                + "AND asesor_curso.idasesor = asesor.idasesor\n"
                + "AND asesor_curso.idcurso = curso.idcurso\n"
                + "AND asesor.estatus = 'A'\n"
                + "AND curso.estatus = 'A';";

        cmb.removeAllItems();
        Curso curso;

        try {
            this.conectar();
            PreparedStatement st = this.cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            curso = new Curso();
            curso.setId(-1);
            curso.setNombre("Seleccione");
            cmb.addItem(curso);
            while (rs.next()) {
                curso = new Curso();
                curso.setId(rs.getInt("idcurso"));
                curso.setNombre(rs.getString("nombre"));
                cmb.addItem(curso);
            };
            rs.close();
            st.close();

        } catch (Exception e) {

        } finally {

            this.desconectar();
        }

    }

}
