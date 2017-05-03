/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.model.DAO;

import cadisystem.dto.curso.Curso;
import java.util.Vector;
import javax.swing.JComboBox;

/**
 *
 * @author carlos
 */
public interface CursoDAO {

    public void insertar(Curso curso) throws Exception;

    public void modificar(Curso curso) throws Exception;

    public void eliminar(Curso curso) throws Exception;

    public Vector<Curso> listar() throws Exception;

    public Curso buscar(String patronBusqueda, Curso curso) throws Exception;

    public Integer obtenerUltimoIdCurso() throws Exception;
    
    public String obtenerNombreSegunId(Integer id) throws Exception;
    
    public void cargarComboCurso(JComboBox jcmbx) throws Exception;
   

}
