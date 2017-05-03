/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.model.DAO;

import cadisystem.dto.asesor.Asesor;
import java.util.Vector;

/**
 *
 * @author carlos
 */
public interface AsesorDAO {

    public void insertar(Asesor asesor) throws Exception;

    public void modificar(Asesor asesor) throws Exception;

    public void eliminar(Asesor asesor) throws Exception;

    public Vector<Asesor> listar() throws Exception;

    public Asesor buscar(String patronBusqueda,Asesor asesor) throws Exception;
    
     public String obtenerNombreSegunId(Integer id) throws Exception;

}
