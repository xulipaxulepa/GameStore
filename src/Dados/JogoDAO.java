/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Entidades.Compra;
import Entidades.Jogo;
import Entidades.Produtora;
import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xulipaxulepa
 */
public class JogoDAO {
    
    private static final String SQL_INSERT = "INSERT INTO JOGO (NOME,ESRB,DATALANCAMENTO,VALOR,PLATAFORMA,GENERO,IDPRODUTORA) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_DELETE = "DELETE FROM JOGO where ID = ?";

    private static final String SQL_UPDATE = "UPDATE JOGO SET NOME = ?, ESRB = ?, DATALANCAMENTO = ?, VALOR = ?, PLATAFORMA = ?, GENERO = ? WHERE ID = ?";

    private static final String SQL_SELECT_TODOS = "SELECT ID,NOME,ESRB,DATALANCAMENTO,VALOR,PLATAFORMA,GENERO FROM JOGO";
    
    private static final String SQL_SELECT_POR_ID = "SELECT ID,NOME,ESRB,DATALANCAMENTO,VALOR,PLATAFORMA,GENERO FROM JOGO WHERE ID = ?";

    public void criar(Jogo jogo,Produtora produtora) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet result1 = null;
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_INSERT);
//Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, jogo.getNome());
            comando.setString(2, jogo.getESRB());
            comando.setString(3, jogo.getDatadelançamento());
            comando.setFloat(4, jogo.getValor());
            comando.setString(5, jogo.getPlataforma());
            comando.setString(6, jogo.getGenero());
            comando.setInt(7, produtora.getId());
//Executa o comando
            comando.execute();
//Persiste o comando no banco de dados
            conexao.commit();
            result1 = comando.getGeneratedKeys();
            while (result1.next()) {
                jogo.setId(result1.getInt(1));
            }
        } catch (Exception e) {
//Caso aconteça alguma exeção é feito um rollback para o banco de
//dados retornar ao seu estado anterior.
            if (conexao != null) {
                conexao.rollback();
            }
//Lança a exceção do tipo sem verificação
            throw new RuntimeException(e);
        } finally {
//Todo objeto que referencie o banco de dados deve ser fechado
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }

    }
    
    public void excluir(Jogo jogo) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_DELETE);
            comando.setInt(1, jogo.getId());
            comando.execute();
            conexao.commit();
            
        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }

    }

    public void Atualizar(Jogo jogo) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_UPDATE);
//Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, jogo.getNome());
            comando.setString(2, jogo.getESRB());
            comando.setString(3, jogo.getDatadelançamento());
            comando.setFloat(4, jogo.getValor());
            comando.setString(5, jogo.getPlataforma());
            comando.setString(6, jogo.getGenero());
            
//Executa o comando
            comando.execute();
//Persiste o comando no banco de dados
            //Persiste o comando no banco de dados
            conexao.commit();
        } catch (Exception e) {
//Caso aconteça alguma exeção é feito um rollback para o banco de
//dados retornar ao seu estado anterior.
            if (conexao != null) {
                conexao.rollback();
            }
//Lança a exceção do tipo sem verificação
            throw new RuntimeException(e);
        } finally {
//Todo objeto que referencie o banco de dados deve ser fechado
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }
    
    public List<Jogo> buscarTodos() throws SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Jogo> jogos = new ArrayList<>();
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_TODOS);
            resultado = comando.executeQuery();
            while(resultado.next()){
                Jogo jogo = new Jogo();
                jogo.setId(resultado.getInt(1));
                jogo.setNome(resultado.getString(2));
                jogo.setESRB(resultado.getString(3));
                jogo.setDatadelançamento(resultado.getString(4));
                jogo.setValor(resultado.getFloat(5));
                jogo.setPlataforma(resultado.getString(6));
                jogo.setGenero(resultado.getString(7));
            
                jogos.add(jogo);
            }
            } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
        return jogos;
    }
    
    public Jogo buscarPorID(int idjogo) throws SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Jogo jogorecuperado = new Jogo();
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_POR_ID);
            comando.setInt(1, idjogo);
            resultado = comando.executeQuery();
            while(resultado.next()){
                jogorecuperado.setId(resultado.getInt(1));
                jogorecuperado.setNome(resultado.getString(2));
                jogorecuperado.setESRB(resultado.getString(3));
                jogorecuperado.setDatadelançamento(resultado.getString(4));
                jogorecuperado.setValor(resultado.getFloat(5));
                jogorecuperado.setPlataforma(resultado.getString(6));
                jogorecuperado.setGenero(resultado.getString(7));
            
            } } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
        return jogorecuperado;
}
}
