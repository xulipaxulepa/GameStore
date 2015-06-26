/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dados.UsuarioDAO;
import Entidades.CartãoDeCredito;
import Entidades.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xulipaxulepa
 */
public class UsuarioBO {
    
    public void criar(Usuario usuario) throws SQLException{
        UsuarioDAO usuariodao = new UsuarioDAO();
        usuariodao.criar(usuario);
    }
    
    public List<Usuario> buscarUsuario() throws SQLException{
        UsuarioDAO usuariodao = new UsuarioDAO();
        List<Usuario> usuarios = usuariodao.buscarTodos();
        return usuarios;
    }
    
        public void atualizar(Usuario usuario) throws SQLException{
        UsuarioDAO usuariodao = new UsuarioDAO();
        usuariodao.Atualizar(usuario);
    }
}
