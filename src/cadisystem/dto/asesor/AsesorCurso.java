/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.dto.asesor;

/**
 *
 * @author carlos
 */
public class AsesorCurso {

    private Integer idAsesor;
    private Integer idCurso;
    private String curso;
    private String asesor;
    private Integer idAsesorCurso;

    public Integer getIdAsesor() {
        return idAsesor;
    }

    public void setIdAsesor(Integer idAsesor) {
        this.idAsesor = idAsesor;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getAsesor() {
        return asesor;
    }

    public void setAsesor(String asesor) {
        this.asesor = asesor;
    }

    public Integer getIdAsesorCurso() {
        return idAsesorCurso;
    }

    public void setIdAsesorCurso(Integer idAsesorCurso) {
        this.idAsesorCurso = idAsesorCurso;
    }
    
    
}
