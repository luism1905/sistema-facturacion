/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.dto.usuario;

/**
 *
 * @author carlos
 */
public class UsuarioPrivilegio {
  
    private Integer idUsuario;
    
    private Integer idPrivilegios;
    
    private String nombrePrivilegio;
    
    private String status;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdPrivilegios() {
        return idPrivilegios;
    }

    public String getNombrePrivilegio() {
        return nombrePrivilegio;
    }

    public void setNombrePrivilegio(String nombrePrivilegio) {
        this.nombrePrivilegio = nombrePrivilegio;
    }

     
    public void setIdPrivilegios(Integer idPrivilegios) {
        this.idPrivilegios = idPrivilegios;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
