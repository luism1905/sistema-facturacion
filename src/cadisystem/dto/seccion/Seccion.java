/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.dto.seccion;

import cadisystem.dto.asesor.Asesor;
import cadisystem.dto.curso.Curso;
import cadisystem.dto.factura.Factura;
import cadisystem.model.dto.estudiante.Estudiante;
import java.sql.Date;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author carlos
 */
public class Seccion {

    private Asesor asesor;
    private Estado estado;
    private Estudiante estudiante;
    private Curso curso;
    private Factura factura;
    private Date fechaRegistro;
    private Date fechaInicio;
    private Date fechaCulminacion;
    private Date fechaTentativaInicio;
    private Vector<Estudiante> lEstudiantes;
    private Integer idSeccion;

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaCulminacion() {
        return fechaCulminacion;
    }

    public void setFechaCulminacion(Date fechaCulminacion) {
        this.fechaCulminacion = fechaCulminacion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Vector<Estudiante> getlEstudiantes() {
        return lEstudiantes;
    }

    public void setlEstudiantes(Vector<Estudiante> lEstudiantes) {
        this.lEstudiantes = lEstudiantes;
    }

    public Date getFechaTentativaInicio() {
        return fechaTentativaInicio;
    }

    public void setFechaTentativaInicio(Date fechaTentativaInicio) {
        this.fechaTentativaInicio = fechaTentativaInicio;
    }

    public Seccion() {
        asesor = new Asesor();
        curso = new Curso();
        estado = new Estado();

    }

    public Asesor getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesor asesor) {
        this.asesor = asesor;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }

    @Override
    public String toString() {
        if (idSeccion == -1) {
            return "Seleccione";
        } else {
            return String.valueOf(this.idSeccion);
        }
    }
}
