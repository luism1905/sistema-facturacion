/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.DAO;

import cadisystem.dto.asesor.Profesion;
import java.util.Vector;
import javax.swing.JComboBox;

/**
 *
 * @author carlos
 */
public interface ProfesionDAO {
    
     Vector<Profesion> listar() throws Exception;
     
       public String obtenerNombreSegunId(Integer id) throws Exception;
       
       public void cargarComboProfesion(JComboBox jcmbx) throws Exception;
    
}
