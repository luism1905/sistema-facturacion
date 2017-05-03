/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.DAO;

import cadisystem.dto.asesor.AsesorCurso;
import java.util.Vector;
import javax.swing.JComboBox;

/**
 *
 * @author carlos
 */
public interface AsesorCursoDAO {
    
    public void insertar(AsesorCurso asec) throws Exception;
    
    public void modificar(AsesorCurso asec) throws Exception;
    
    public Vector<AsesorCurso> listar() throws Exception;
    
    public Vector<AsesorCurso> listadoCursosDaoIdAsesor(Integer id) throws Exception;
    
    public void cargarComboAsesorDadoIdCurso(Integer idCurso,JComboBox cmb) throws Exception;
    
    public Integer obtenerIDAsesorCursoParaEliminar(Integer idAsesor,Integer idCurso) throws Exception;

    public void eliminar(AsesorCurso asec) throws Exception;
    
    public void cargarComboCursoDadoIdAsesor(Integer idAsesor,JComboBox cmb) throws Exception;
}
