/*_
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.dto.usuario;

/**
 *
 * @author carlos
 */
public class Privilegio {
    
    private Integer id;
    
    private String descripcion;
    
    private String status;

    public Privilegio(Integer id, String descripcion, String status) {
        this.id = id;
        this.descripcion = descripcion;
        this.status = status;
    }

    public Privilegio() {
    }
    
    

    public Integer getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    
    
    
}
