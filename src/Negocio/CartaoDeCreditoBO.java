/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dados.CartaoDeCreditoDAO;
import Entidades.CartãoDeCredito;
import Entidades.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author xulipaxulepa
 */
public class CartaoDeCreditoBO {
    
    public void criar(CartãoDeCredito cartao) throws SQLException{
        CartaoDeCreditoDAO cartaodecreditoDAO = new CartaoDeCreditoDAO();
        cartaodecreditoDAO.criar(cartao);
    }
    
    public List<CartãoDeCredito> buscarPorIDUsuario(Usuario usuario) throws SQLException{
        CartaoDeCreditoDAO cartaodecreditoDAO = new CartaoDeCreditoDAO();
        List<CartãoDeCredito> cartoes = cartaodecreditoDAO.buscarPorIDUsuario(usuario);
        return cartoes;
    }
    
    public void atualizar(CartãoDeCredito cartao) throws SQLException{
        CartaoDeCreditoDAO cartaodecreditoDAO = new CartaoDeCreditoDAO();
        cartaodecreditoDAO.Atualizar(cartao);
    }
}
