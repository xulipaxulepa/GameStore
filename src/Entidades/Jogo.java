/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;

/**
 *
 * @author xulipaxulepa
 */
public class Jogo {
    private int id;
    private String nome;
    private String ESRB;
    private String datadelançamento;
    private float valor;
    private String plataforma;
    private String genero;
    private int idprodutora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getESRB() {
        return ESRB;
    }

    public void setESRB(String ESRB) {
        this.ESRB = ESRB;
    }

    public String getDatadelançamento() {
        return datadelançamento;
    }

    public void setDatadelançamento(String datadelançamento) {
        this.datadelançamento = datadelançamento;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    
    public int getIdprodutora() {
        return idprodutora;
    }

    public void setIdprodutora(int idprodutora) {
        this.idprodutora = idprodutora;
    }
    
    
}
