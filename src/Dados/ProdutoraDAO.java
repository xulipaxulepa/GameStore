/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Dados.Criptografia.ConversorUtil;
import Entidades.Produtora;
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
public class ProdutoraDAO {
    
    private static final String SQL_INSERT = "INSERT INTO PRODUTORA (NOME, LOCALIZACAO) VALUES (?, ?)";
    
    private static final String SQL_DELETE = "DELETE FROM PRODUTORA where ID = ?";
    
    private static final String SQL_UPDATE = "UPDATE PRODUTORA SET NOME = ?, LOCALIZACAO = ? WHERE ID = ?";

    private static final String SQL_SELECT_TODOS = "SELECT ID,NOME, LOCALIZACAO FROM PRODUTORA";

    private static final String SQL_SELECT_POR_IDUSUARIO = "SELECT NOME, LOCALIZACAO FROM PRODUTORA WHERE ID = ?";
    
    public void criar(Produtora produtora) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet result1 = null;
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_INSERT);
//Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, produtora.getNome());
            comando.setString(2, produtora.getLocalização());
            
            
//Executa o comando
            comando.execute();
//Persiste o comando no banco de dados
            conexao.commit();
            result1 = comando.getGeneratedKeys();
            while(result1.next()){
                produtora.setId(result1.getInt(1));
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
    
    public List<Produtora> buscarTodos() throws SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        ConversorUtil conv = new ConversorUtil();
        List<Produtora> produtoras = new ArrayList<>();
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_TODOS);
            resultado = comando.executeQuery();
            while(resultado.next()){
                Produtora cdc = new Produtora();
                cdc.setId(resultado.getInt(1));
                cdc.setNome(resultado.getString(2));
                cdc.setLocalização(resultado.getString(3));
                produtoras.add(cdc);
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
        return produtoras;
    }
    
    public void excluir(Produtora produtora) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_DELETE);
            comando.setInt(1, produtora.getId());    
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
    
    public void Atualizar(Produtora produtora) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_UPDATE);
//Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, produtora.getNome());
            comando.setString(2, produtora.getLocalização());
            comando.setInt(3, produtora.getId());
                        
//Executa o comando
            comando.execute();
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
}
