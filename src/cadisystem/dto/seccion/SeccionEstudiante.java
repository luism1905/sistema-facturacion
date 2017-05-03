/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.dto.seccion;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author carlos
 */
public class SeccionEstudiante {

    private Integer idSeccion;
    
    private Integer idEstudiante;
    
    private Date fechaRegistro;
    
    private Integer idFactura;

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }
    
    
    public Date getFechaRegistro() {
        fechaRegistro = new Date(System.currentTimeMillis());
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

       public String fechaRegistroOut(){
        String f;
          SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
           f =String.valueOf(date.format(this.fechaRegistro));
           return f;
    }   
    public Integer getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public SeccionEstudiante(Integer idSeccion, Integer idEstudiante, Date fechaRegistro,Integer idFactura) {
        this.idSeccion = idSeccion;
        this.idEstudiante = idEstudiante;
        this.fechaRegistro = fechaRegistro;
        this.idFactura = idFactura;
    }

    
    
    
    
}
