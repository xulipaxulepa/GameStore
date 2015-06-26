/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Entidades.Compra;
import Entidades.Jogo;
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
public class CompraDAO {
    
    private static final String SQL_INSERT = "INSERT INTO COMPRA (DATACOMPRA,IDUSUARIO,IDJOGO) VALUES (?, ?, ?)";
    
    private static final String SQL_DELETE = "DELETE FROM CARTAODECREDITO where ID = ?";
    
    private static final String SQL_UPDATE = "UPDATE COMPRA SET DATACOMPRA = ?, IDUSUARIO = ? IDJOGO = ? WHERE ID = ?";

    private static final String SQL_SELECT_TODOS = "SELECT ID,DATACOMPRA,IDUSUARIO,IDJOGO FROM COMPRA";

    private static final String SQL_SELECT_POR_IDUSUARIO = "SELECT ID,DATACOMPRA,IDJOGO FROM COMPRA WHERE IDUSUARIO = ?";

    public void criar(Compra compra,Usuario usuario,Jogo jogo) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet result1 = null;
        try {
//Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
//Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_INSERT);
//Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, compra.getDatacompra());
            comando.setInt(2, usuario.getId());
            comando.setInt(3, jogo.getId());
            
//Executa o comando
            comando.execute();
//Persiste o comando no banco de dados
            conexao.commit();
            result1 = comando.getGeneratedKeys();
            while(result1.next()){
                compra.setId(result1.getInt(1));
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
    
    public List<Compra> buscarCompraPorIDUsuario(Usuario usuario) throws SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        JogoDAO jogodao = new JogoDAO();
        List<Compra> compras = new ArrayList<>();
        
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_POR_IDUSUARIO);
            comando.setInt(1, usuario.getId());
            resultado = comando.executeQuery();
            while(resultado.next()){
                Compra buscacompra = new Compra();
                buscacompra.setId(resultado.getInt(1));
                buscacompra.setDatacompra(resultado.getString(2));
                buscacompra.setIdjogo(resultado.getInt(3));
                compras.add(buscacompra);
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
        return compras;
    }
    
    public List<Compra> buscarTudoCompra() throws SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        JogoDAO jogodao = new JogoDAO();
        List<Compra> compras = new ArrayList<>();
        
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_TODOS);
            resultado = comando.executeQuery();
            while(resultado.next()){
                Compra buscacompra = new Compra();
                buscacompra.setId(resultado.getInt(1));
                buscacompra.setDatacompra(resultado.getString(2));
                buscacompra.setUsuario(resultado.getInt(3));
                buscacompra.setIdjogo(resultado.getInt(4));
                compras.add(buscacompra);
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
        return compras;
    }
}
