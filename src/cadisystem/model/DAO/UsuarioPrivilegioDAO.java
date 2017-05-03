/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.DAO;

import cadisystem.model.dto.usuario.Usuario;
import cadisystem.model.dto.usuario.UsuarioPrivilegio;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface UsuarioPrivilegioDAO {

    public List<UsuarioPrivilegio> listar() throws Exception;
    public List<UsuarioPrivilegio> buscarPrivilegios(UsuarioPrivilegio usp) throws Exception;
    public void insertarUsuariosPrivilegios(Usuario us,Integer iterador) throws Exception;
    public List<UsuarioPrivilegio> buscarPrivilegiosDadoUsuario(Integer usuario) throws Exception;
    public void actualizarEstatusPrivilegios(Integer id, String status) throws Exception;
}
