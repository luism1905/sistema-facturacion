package cadisystem.dto.seccion;

import java.sql.Date;

/**
 *
 * @author carlos
 */
public class SeccionMovimiento {
    
    private Integer id;
    private String estadoActual;
    private String estadoAnterior;
    private Date fecha;
    private Integer idSeccion;

    public Integer getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }
    
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public String getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(String estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    public SeccionMovimiento(String estadoActual, String estadoAnterior, Date fecha,Integer idSeccion) {
        this.estadoAnterior = estadoAnterior;
        this.estadoActual = estadoActual;
        this.fecha = fecha;
        this.idSeccion = idSeccion;
    }

         
}
