/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.DAO;

import cadisystem.model.dto.usuario.Privilegio;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface PrivilegioDAO {

    public List<Privilegio> listar() throws Exception;
    
    
}
