/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.herramientas;

/**
 *
 * @author carlos
 */
public class Combo {
    
    private Integer id;
    
    private String profesion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    
    @Override
    public String toString(){
        
        return this.profesion;
    }
    
}
