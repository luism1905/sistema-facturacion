/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.model.DAO;

import cadisystem.dto.seccion.Seccion;
import cadisystem.model.dto.estudiante.Estudiante;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;

/**
 *
 * @author carlos
 */
public interface SeccionDAO {

    public void insertar(Seccion seccion) throws Exception;

    public void modificar(Seccion seccion) throws Exception;

    public void eliminar(Seccion seccion) throws Exception;

    public Vector<Seccion> listar() throws Exception;

    public Seccion buscar(Integer idSeccion) throws Exception;

    public Integer obtenerUltimoIdSeccion() throws Exception;

    public Boolean cambiarEstado(Seccion seccion) throws Exception;
    
    public void cargarComboAsesor(JComboBox jcmbx) throws Exception;
    
    public void cargarComboCurso(JComboBox jcmbx) throws Exception;
    
    public void cargarComboSeccionDadoIdCurso(JComboBox jcmbx,Integer idCurso) throws Exception;

    public Seccion obtenerSeccionDadoId(Integer idSeccion) throws Exception;
    
    public void cargarComboAsesorDadiIdCurso(JComboBox jcmbx, Integer idCurso) throws Exception;

    public void iniciarSeccion(Seccion seccion) throws Exception;
    
    public void cerrarSeccion(Seccion seccion) throws Exception;
    
    public Vector<Estudiante> obtenerEstudiantesDadoIdSeccion(Integer idSeccion) throws Exception;
    
    
}
