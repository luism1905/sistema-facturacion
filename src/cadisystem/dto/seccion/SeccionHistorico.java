/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.dto.seccion;

/**
 *
 * @author carlos
 */
public class SeccionHistorico {
    
    private Integer id;
    
    private String descripcion;
    
    private Integer idseccion;

    public SeccionHistorico(String descripcion, Integer idseccion) {
        this.descripcion = descripcion;
        this.idseccion = idseccion;
    }

    public SeccionHistorico() {
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdseccion() {
        return idseccion;
    }

    public void setIdseccion(Integer idseccion) {
        this.idseccion = idseccion;
    }
    
    
    
}
