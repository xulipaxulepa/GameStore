/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Dados.Criptografia.ConversorUtil;
import Entidades.CartãoDeCredito;
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
public class UsuarioDAO {

    private static final String SQL_INSERT = "INSERT INTO USUARIO (USERNAME,IDADE,LOGIN,SENHA) VALUES (?, ?, ?, ?)";

    private static final String SQL_DELETE = "DELETE FROM USUARIO where ID = ?";

    private static final String SQL_UPDATE = "UPDATE USUARIO SET USERNAME = ?, IDADE = ?, LOGIN = ?, SENHA =? WHERE ID = ?";

    private static final String SQL_SELECT_TODOS = "SELECT ID,USERNAME,IDADE,LOGIN,SENHA FROM USUARIO";

    private static final String SQL_SELECT_POR_ID = "SELECT ID, USERNAME, IDADE, LOGIN, SENHA FROM USUARIO WHERE ID = ?";

    public void criar(Usuario usuario) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet result1 = null;
        ConversorUtil conv = new ConversorUtil();    
        
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_INSERT);
//Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, usuario.getUsername());
            comando.setInt(2, usuario.getIdade());
            comando.setString(3, usuario.getLogin());
            String senhacriptografada = conv.ConverteMD5(usuario.getSenha());
            comando.setString(4, senhacriptografada);
//Executa o comando
            comando.execute();
//Persiste o comando no banco de dados
            conexao.commit();
            result1 = comando.getGeneratedKeys();
            while (result1.next()) {
                usuario.setId(result1.getInt(1));
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
    
    public void excluir(Usuario usuario) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        CartaoDeCreditoDAO cartaoDAO = new CartaoDeCreditoDAO();
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_DELETE);
            comando.setInt(1, usuario.getId());
            comando.execute();
            conexao.commit();
            cartaoDAO.excluir(usuario);
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

    public void Atualizar(Usuario usuario) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ConversorUtil conv = new ConversorUtil();    
                
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_UPDATE);
//Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, usuario.getUsername());
            comando.setInt(2, usuario.getIdade());
            comando.setString(3, usuario.getLogin());
            String senhacriptografada = conv.ConverteMD5(usuario.getSenha());
            comando.setString(4, senhacriptografada);
            comando.setInt(5, usuario.getId());
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
    
    public List<Usuario> buscarTodos() throws SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        CartaoDeCreditoDAO cartao = new CartaoDeCreditoDAO();
        List<Usuario> usuarios = new ArrayList<>();
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_TODOS);
            resultado = comando.executeQuery();
            while(resultado.next()){
                Usuario user = new Usuario();
                user.setId(resultado.getInt(1));
                user.setUsername(resultado.getString(2));
                user.setIdade(resultado.getInt(3));
                user.setLogin(resultado.getString(4));
                user.setSenha(resultado.getString(5));
                user.adicionaListaCartão(cartao.buscarPorIDUsuario(user));
                usuarios.add(user);
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
        return usuarios;
    }
    
    public Usuario buscarPorID(int idusuario) throws SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        CartaoDeCreditoDAO cartao = new CartaoDeCreditoDAO();
        Usuario user = new Usuario();
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_POR_ID);
            comando.setInt(1, idusuario);
            resultado = comando.executeQuery();
            while(resultado.next()){
                
                user.setId(resultado.getInt(1));
                user.setUsername(resultado.getString(2));
                user.setIdade(resultado.getInt(3));
                user.setLogin(resultado.getString(4));
                user.setSenha(resultado.getString(5));
                user.adicionaListaCartão(cartao.buscarPorIDUsuario(user));
                
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
        return user;
    }
}
