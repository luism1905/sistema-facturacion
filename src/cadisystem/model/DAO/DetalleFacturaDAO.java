
package cadisystem.model.DAO;

import cadisystem.dto.factura.DetalleFactura;
import java.util.Vector;

/**
 *
 * @author carlos
 */
public interface DetalleFacturaDAO {
    public void insertar(DetalleFactura detFactura) throws Exception;
    public   Vector <DetalleFactura> listarDetalleFacturaDadoIdfactura(Integer idFactura) throws Exception;
    
}
