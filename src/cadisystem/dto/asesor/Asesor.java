/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.dto.asesor;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author carlos
 */
public class Asesor {

    private Integer id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String profesion;
    private String telefono;
    private String correo;
    private String otroTelefono;
    private Date fechaRegistro;
    private String sexo;
    private Integer idProfesion;
    private String status;
    private String nombreApellido;

    public Asesor() {
    }
    
    

    public Asesor(String cedula, String nombre, String apellido,
            String telefono, String correo, String otroTelefono,
            Date fechaRegistro, String sexo, Integer idProfesion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.otroTelefono = otroTelefono;
        this.fechaRegistro = fechaRegistro;
        this.sexo = sexo;
        this.idProfesion = idProfesion;
    }

    public String getNombreApellido() {
        return nombre +" "+ apellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        if(cedula == null)
            cedula="";
        
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        if(nombre == null)
            nombre ="";
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        if(apellido == null)
            apellido = "";
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getProfesion() {
        if(profesion == null)
            profesion ="";
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getTelefono() {
        if(telefono == null)
            telefono ="";
        
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        if(correo == null)
            correo = "";
            
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getOtroTelefono() {
        if(otroTelefono == null)
            otroTelefono ="";
        
        return otroTelefono;
    }

    public void setOtroTelefono(String otroTelefono) {
        this.otroTelefono = otroTelefono;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
       if(fechaRegistro != null)
        this.fechaRegistro = fechaRegistro;

    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(Integer idProfesion) {
        this.idProfesion = idProfesion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

     public String getSexoString() {

        if (this.sexo == null) {
            return " ";
        } else {

            if (this.sexo.equals("M")) {
                return "Masculino";
            } else {
                return "Femenino";
            }
        }

    }
    public String fechaRegistroOut(){
        String f;
        if(this.fechaRegistro == null){
            f="";
        }
        else{
             SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
             f =String.valueOf(date.format(this.fechaRegistro));
        }    
        

           return f;
    }
    @Override
    public String toString(){
         return this.nombre+" "+this.getApellido();
    }
    
    public String nombreCompleto(){
        return nombre+" "+apellido;
    }
}
