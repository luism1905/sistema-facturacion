/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.DAO;

import cadisystem.model.dto.usuario.Usuario;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlos
 */
public interface UsuarioDAO {
    
    public void registrar(Usuario usuario) throws Exception;
    public void modificar(Usuario usuario) throws Exception;    
    public void eliminar(Usuario usuario) throws Exception;
    public Vector<Usuario> listar() throws Exception;
    public Usuario buscar(String patronBusqueda) throws Exception;
    public Usuario autenticar(String n,String p) throws Exception;
    public Integer obtenerUltimoIdUsuario() throws Exception;
    public Usuario login() throws Exception;
}
