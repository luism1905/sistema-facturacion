/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.model.dto.estudiante;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author carlos
 */
public class Estudiante {

    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String otroTelefono;
    private String Sexo;
    private Date fecharegistro;
    private String status;
    private Integer id;
    private String correo;
    private String sexoString;
    private String fechaRegistroOut;
    private String nombreCompleto;

    public void setSexoString(String sexoString) {
        this.sexoString = sexoString;
    }

    public String getNombreCompleto() {
        
        this.nombreCompleto = nombre+" "+apellido;
        
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setFechaRegistroOut(String fechaRegistroOut) {
        this.fechaRegistroOut = fechaRegistroOut;
    }
    
    
    

    public Estudiante(String cedula, String nombre, String apellido,
            String telefono, String direccion, String otroTelefono,
            String Sexo, Date fecharegistro, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.otroTelefono = otroTelefono;
        this.Sexo = Sexo;
        this.fecharegistro = fecharegistro;
        this.correo = correo;
    }

    public Estudiante(String cedula, String nombre, String apellido,
            String telefono, String direccion, String otroTelefono,
            String Sexo, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.otroTelefono = otroTelefono;
        this.Sexo = Sexo;
        this.correo = correo;
    }

    public Estudiante() {

    }

    public String getCedula() {
        if(cedula == null)
            cedula ="";
        
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        if(nombre == null)
            nombre = "";
        
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        if(apellido == null)
            apellido ="";
        
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
    if(this.telefono == null || this.telefono.equals(""))
            this.telefono = "-";
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        if(direccion == null)
            direccion = "";
        
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getOtroTelefono() {
        if(this.otroTelefono == null || this.otroTelefono.equals(""))
            this.otroTelefono = "-";
        return otroTelefono;
    }

    public void setOtroTelefono(String otroTelefono) {
        this.otroTelefono = otroTelefono;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public Date getFecharegistro() { 
  
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        if(correo == null)
            correo ="";
        
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexoString() {

        if (this.Sexo == null) {
            return " ";
        } else {

            if (this.Sexo.equals("M")) {
                return "Masculino";
            } else {
                return "Femenino";
            }
        }

    }
    public String getFechaRegistroOut(){
        String f;
          SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
           f =String.valueOf(date.format(this.fecharegistro));
           return f;
    }
}
