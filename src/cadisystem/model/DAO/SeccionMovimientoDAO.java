/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.DAO;

import cadisystem.dto.seccion.SeccionMovimiento;

/**
 *
 * @author carlos
 */
public interface SeccionMovimientoDAO {
    
    public void insertar(SeccionMovimiento seccEst) throws Exception;
    public void listarEstadosDadoIdSeccion(Integer idSeccion);
    public Integer obtenerCantidadDeEsttduiantesdadoIdSeccion(Integer id)throws Exception; 
    
}
