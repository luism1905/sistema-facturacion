/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.DAO;

import cadisystem.dto.factura.Factura;
import java.util.Vector;

/**
 *
 * @author carlos
 */
public interface FacturaDAO {
    
    public void insertar(Factura factura) throws Exception;
    public Integer obtenerIdUltmimaFactura() throws Exception;
    public Vector <Factura> listar() throws Exception;
}
