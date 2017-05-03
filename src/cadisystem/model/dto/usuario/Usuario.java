/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.dto.usuario;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author carlos
 */
 public  class Usuario {
    
    private String username;
    private String contrasenha;
    private Integer id;
    private String correo;
    private List<Privilegio> privilegios;
    private Date fechaRegistro;
    private String estatus;
    private String estatusString;
    private String fechaRegistroString;


    public String getCorreo() {
        if(this.correo == null){
            this.correo ="";
        }
        return correo;
    }

    public void setEstatusString(String estatusString) {
        this.estatusString = estatusString;
    }

    public String getEstatus() {
        if(this.estatus.equals(""))
            estatus ="";
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    
    public Date getFechaRegistro() {
       if(fechaRegistro != null){
            return fechaRegistro; 
       }
       else {
            return fechaRegistro; 
       }
      
    }

    public void setFechaRegistro(Date fechaRegistro) {
        
        if(fechaRegistro == null){
            
            this.fechaRegistro=null;
            
        }
        else{
            this.fechaRegistro = fechaRegistro;
            
        }
    }
    
    public String getEstatusString(){
        if(this.estatus.equals("A")){
            return "Activo";
            
        }
        else{
            return "Inactivo";
            
        }
        
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
      
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
   
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }
    
    public List<Privilegio> getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(List<Privilegio> privilegios) {
        this.privilegios = privilegios;
    }

    public void setFechaRegistroString(String fechaRegistroString) {
        this.fechaRegistroString = fechaRegistroString;
    }
    
    public String getFechaRegistroString(){
               String f;
          SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
           f =String.valueOf(date.format(this.fechaRegistro));
           return f;
    }
}
