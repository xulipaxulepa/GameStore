/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author xulipaxulepa
 */
public class CartãoDeCredito {
    
    private int id;
    private String banco;
    private String numeroCartão;
    private int idusuario;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNumeroCartão() {
        return numeroCartão;
    }

    public void setNumeroCartão(String numeroCartão) {
        this.numeroCartão = numeroCartão;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    
    
}
