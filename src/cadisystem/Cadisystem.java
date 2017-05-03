/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem;

import cadisystem.model.BD.Conexion;
import cadisystem.model.DAO.UsuarioDAO;
import cadisystem.model.dto.usuario.Usuario;
import cadisystem.model.implement.UsuarioImp;
import cadisystem.view.IngresarSistema;
import cadisystem.view.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos
 */
public class Cadisystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //  PRODUCCIÓN
        IngresarSistema ingrS;
        ingrS = new IngresarSistema(null, true);
        ingrS.setVisible(true);
//        
//        Principal princ = new Principal(null,false);
//        princ.setVisible(true);
        
        
        
    }
    
}
