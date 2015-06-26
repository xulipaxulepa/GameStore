/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dados.ProdutoraDAO;
import Entidades.Produtora;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author xulipaxulepa
 */
public class ProdutoraBO {
    
    public void criar(Produtora produtora) throws SQLException{
        ProdutoraDAO produtoraDAO = new ProdutoraDAO();
        produtoraDAO.criar(produtora);
    }
    
    public List<Produtora> buscarTodos() throws SQLException{
        ProdutoraDAO produtoraDAO = new ProdutoraDAO();
        List<Produtora> produtoras = produtoraDAO.buscarTodos();
        return produtoras;
    }
    
    public void atualizar(Produtora produtora) throws SQLException{
        ProdutoraDAO produtoraDAO = new ProdutoraDAO();
        produtoraDAO.Atualizar(produtora);
    }
    
    public void excluir(Produtora produtora) throws SQLException{
        ProdutoraDAO produtoraDAO = new ProdutoraDAO();
        produtoraDAO.excluir(produtora);
    }
}
