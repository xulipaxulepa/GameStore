/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dados.CompraDAO;
import Dados.JogoDAO;
import Dados.UsuarioDAO;
import Entidades.Compra;
import Entidades.Jogo;
import Entidades.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author xulipaxulepa
 */
public class CompraBO {
    
    public void criar(Compra compra, Usuario usuario, Jogo jogo) throws SQLException{
        CompraDAO compraDAO = new CompraDAO();
        compraDAO.criar(compra,usuario,jogo);
    }
    
    public List<Compra> buscarCompraPorIDUsuario(Usuario usuario) throws SQLException{
        CompraDAO compraDAO = new CompraDAO();
        List<Compra> compras = compraDAO.buscarCompraPorIDUsuario(usuario);
        return compras;
    }
    
    public Jogo buscaJogoComprado(int idjogo) throws SQLException{
        JogoDAO jogoDAO = new JogoDAO();
        Jogo jogo = new Jogo();
        jogo = jogoDAO.buscarPorID(idjogo);
        return jogo;
    }
    
    public List<Compra> buscarTudoCompra() throws SQLException{
        CompraDAO compraDAO = new CompraDAO();
        List<Compra> compras = compraDAO.buscarTudoCompra();
        return compras;
    }
    
    public Usuario buscaUsuarioComprou(int idusuario) throws SQLException{
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario = usuarioDAO.buscarPorID(idusuario);
        return usuario;
    }
    
}
