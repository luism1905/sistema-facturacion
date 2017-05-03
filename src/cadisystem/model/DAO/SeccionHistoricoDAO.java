/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.DAO;

import cadisystem.dto.seccion.SeccionHistorico;
import java.util.Vector;

/**
 *
 * @author carlos
 */
public interface SeccionHistoricoDAO {
    
    public void insertar(SeccionHistorico seccionH) throws Exception;
    
    public Vector<SeccionHistorico> listarHistoricoDadoIdSeccion(Integer idSeccion) throws Exception;
    
}
