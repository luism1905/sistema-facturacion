/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.dto.curso;

/**
 *
 * @author carlos
 */
public class Curso {

    private Integer id;
    private String nombre;
    private Integer horas;
    private Float precio;
    private String estatus;

    public Curso(Integer id, String nombre, Integer horas, Float precio) {
        this.nombre = nombre;
        this.horas = horas;
        this.precio = precio;
        this.id = id;
    }

    public Curso() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getEstatus() {
        if (estatus == null) {
            estatus = "";
        }
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

}
