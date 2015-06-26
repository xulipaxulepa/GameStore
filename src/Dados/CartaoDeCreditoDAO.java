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
public class CartaoDeCreditoDAO {
    
    private static final String SQL_INSERT = "INSERT INTO CARTAODECREDITO (BANCO,NUMEROCARTAO,IDUSUARIO) VALUES (?, ?, ?)";
    
    private static final String SQL_DELETE = "DELETE FROM CARTAODECREDITO where ID = ?";
    
    private static final String SQL_UPDATE = "UPDATE CARTAODECREDITO SET BANCO = ?, NUMEROCARTAO = ? WHERE IDUSUARIO = ?";

    private static final String SQL_SELECT_TODOS = "SELECT * FROM CARTAODECREDITO";

    private static final String SQL_SELECT_POR_IDUSUARIO = "SELECT BANCO, NUMEROCARTAO FROM CARTAODECREDITO WHERE IDUSUARIO = ?";
    
    public void criar(CartãoDeCredito cartaodecredito) throws SQLException {
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
            comando.setString(1, cartaodecredito.getBanco());
            String numcartaocriptografado = conv.EncriptaCipher(cartaodecredito);
            comando.setString(2, numcartaocriptografado);
            comando.setInt(3, cartaodecredito.getIdusuario());
            
//Executa o comando
            comando.execute();
//Persiste o comando no banco de dados
            conexao.commit();
            result1 = comando.getGeneratedKeys();
            while(result1.next()){
                cartaodecredito.setId(result1.getInt(1));
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
    
    public List<CartãoDeCredito> buscarPorIDUsuario(Usuario usuario) throws SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        ConversorUtil conv = new ConversorUtil();
        List<CartãoDeCredito> cartao = new ArrayList<>();
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_POR_IDUSUARIO);
            comando.setInt(1, usuario.getId());
            resultado = comando.executeQuery();
            while(resultado.next()){
                CartãoDeCredito cdc = new CartãoDeCredito();
                cdc.setBanco(resultado.getString(1));
                cdc.setNumeroCartão(resultado.getString(2));
                cartao.add(cdc);
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
        return cartao;
    }
    
    public void excluir(Usuario usuario) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        List<CartãoDeCredito> listacartao = new ArrayList<>();
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_DELETE);
            listacartao = usuario.getListaCartão();
            for(CartãoDeCredito cartao : listacartao){
            comando.setInt(1, cartao.getId());    
            comando.execute();
            conexao.commit();
            listacartao.remove(cartao);
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

    }
    
    public void Atualizar(CartãoDeCredito cartaodecredito) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ConversorUtil conv = new ConversorUtil();
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_UPDATE);
//Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, cartaodecredito.getBanco());
            String numcartaocriptografado = conv.EncriptaCipher(cartaodecredito);
            comando.setString(2, numcartaocriptografado);
            comando.setInt(3, cartaodecredito.getIdusuario());
                        
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
