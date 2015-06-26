/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dados.JogoDAO;
import Entidades.Jogo;
import Entidades.Produtora;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author xulipaxulepa
 */
public class JogoBO {
    
    public void criar(Jogo jogo,Produtora produtora) throws SQLException{
        JogoDAO jogodao = new JogoDAO();
        jogodao.criar(jogo,produtora);
    }
    
    public List<Jogo> buscarTodos() throws SQLException{
        JogoDAO jogodao = new JogoDAO();
        List<Jogo> jogos = jogodao.buscarTodos();
        return jogos;
    }
    
        public void atualizar(Jogo jogo) throws SQLException{
        JogoDAO jogodao = new JogoDAO();
        jogodao.Atualizar(jogo);
    }
        
    public void excluir(Jogo jogo) throws SQLException{
        JogoDAO jogodao = new JogoDAO();
        jogodao.excluir(jogo);
    }    
}
