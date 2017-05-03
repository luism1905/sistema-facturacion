/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.model.DAO;

import cadisystem.model.dto.estudiante.Estudiante;
import java.util.Vector;

/**
 *
 * @author carlos
 */
public interface EstudianteDAO {

    public void insertar(Estudiante estudiante) throws Exception;

    public void modificar(Estudiante estudiante) throws Exception;

    public void eliminar(Estudiante estudiante) throws Exception;

    public Vector<Estudiante> listar() throws Exception;

    public Estudiante buscar(String patronBusqueda, Estudiante estudiante) throws Exception;

    public String obtenerNombreSegunId(Integer id) throws Exception;

}
