/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.dto.factura;

import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author luiscarrasco1991@gmail.com
 */
public class Factura {
    private Integer idFactura;
    private Integer idEstudiante;
    private Date fechaEmision;
    private Float montoTotal;
    private Vector<DetalleFactura> ListDetalleFactura;

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Vector<DetalleFactura> getListDetalleFactura() {
        return ListDetalleFactura;
    }

    public void setListDetalleFactura(Vector<DetalleFactura> ListDetalleFactura) {
        this.ListDetalleFactura = ListDetalleFactura;
    }
    
    
    
}
