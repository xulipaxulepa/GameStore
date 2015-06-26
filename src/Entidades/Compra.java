/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xulipaxulepa
 */
public class Compra {

    private int id;
    private int idusuario;
    private List<Jogo> jogos;
    private String datacompra;
    private int idjogo;
    
    public Compra(){
        
        jogos = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario() {
        return idusuario;
    }

    public void setUsuario(int idusuario) {
        this.idusuario = idusuario;
    }
    
    public void adicionaJogo(Jogo jogos){
        this.jogos.add(jogos);
    }
    
    public void removeJogo(Jogo jogos){
        this.jogos.remove(jogos);
    }

    public String getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(String datacompra) {
        this.datacompra = datacompra;
    }

    public int getIdjogo() {
        return idjogo;
    }

    public void setIdjogo(int idjogo) {
        this.idjogo = idjogo;
    }
    
    public List<Jogo> getJogos(){
        return this.jogos;
    }
}
