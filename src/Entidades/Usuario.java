/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xulipaxulepa
 */
public class Usuario {

    private int id; //indentifcação banco de dados
    private String username;
    private int idade;
    private String login;
    private String senha;
    private List<CartãoDeCredito> cartões;
    
    public Usuario(){
        this.cartões = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void adicionaCartão(CartãoDeCredito cartão){
        this.cartões.add(cartão);
    }
    
    public void adicionaListaCartão(List cartão){
        this.cartões = cartão;
    }
    
    public List getListaCartão(){
        return this.cartões;
    }
}
