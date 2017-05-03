/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.DAO;

import cadisystem.dto.seccion.SeccionEstudiante;
import cadisystem.model.dto.estudiante.Estudiante;
import java.util.Vector;

/**
 *
 * @author carlos
 */
public interface SeccionEstudianteDAO {
    
   public void insertar(SeccionEstudiante secEst) throws Exception;
   
   public Vector<Estudiante> listarEstudiantesDadoIdSeccion(Integer idSeccion);
}
