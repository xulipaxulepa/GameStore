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
public class Produtora {
    
    private int id;
    private String nome;
    private String localização;
    private List<Jogo> jogos;
    
    public Produtora(){
        this.jogos = new ArrayList<>();
    }

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

    public String getLocalização() {
        return localização;
    }

    public void setLocalização(String localização) {
        this.localização = localização;
    }
    
    public void adicionaJogo(Jogo jogos){
        this.jogos.add(jogos);
    }
}
