/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentação;

import Entidades.Compra;
import Entidades.Jogo;
import Entidades.Usuario;
import Negocio.CompraBO;
import Negocio.JogoBO;
import java.awt.Color;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author xulipaxulepa
 */
public class TelaInicial extends javax.swing.JFrame {

    public Usuario usuario = null;
    public List<Jogo> jogos = new ArrayList<>();
    public List<Jogo> jogosusuario = new ArrayList<>();
    public int linhaselecionada;

    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
        initComponents();
        TelaLogin telalogin = new TelaLogin(this);
        telalogin.setVisible(true);
        this.setEnabled(false);
        this.jLabel1.setVisible(false);
        this.txtUsername.setEditable(false);
        this.txtIdade.setEditable(false);
        this.btnAdicionar.setVisible(false);
        this.btnAtualizar.setVisible(false);
        this.preencheTabela();
        this.btnGraficoGeneros.setVisible(false);
        this.btnRelatorioCompras.setVisible(false);
        this.btnRelatorioUsuarios.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        tpnlTelaInicial = new javax.swing.JTabbedPane();
        pnlPerfil = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblIdade = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        pnlUserFoto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCartaoDeCredito = new javax.swing.JButton();
        btnEditarDados = new javax.swing.JButton();
        btnLogOff = new javax.swing.JButton();
        pnlJogos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblJogos = new javax.swing.JTable();
        btnComprar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        pnlRelatoriosGraficos = new javax.swing.JPanel();
        btnRelatorioCompras = new javax.swing.JButton();
        btnRelatorioUsuarios = new javax.swing.JButton();
        btnGraficoGeneros = new javax.swing.JButton();
        btnGraficoGeneroJogador = new javax.swing.JButton();
        pnlJogosdoUsuario = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblJogosUsuario = new javax.swing.JTable();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setExtendedState(6);

        lblUsername.setText("Username:");

        lblIdade.setText("Idade:");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Apresentação/Imagens/userpadrão.png"))); // NOI18N

        javax.swing.GroupLayout pnlUserFotoLayout = new javax.swing.GroupLayout(pnlUserFoto);
        pnlUserFoto.setLayout(pnlUserFotoLayout);
        pnlUserFotoLayout.setHorizontalGroup(
            pnlUserFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlUserFotoLayout.setVerticalGroup(
            pnlUserFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
        );

        btnCartaoDeCredito.setText("Cartôes de Credito");
        btnCartaoDeCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartaoDeCreditoActionPerformed(evt);
            }
        });

        btnEditarDados.setText("Editar Dados");
        btnEditarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDadosActionPerformed(evt);
            }
        });

        btnLogOff.setText("Logoff");
        btnLogOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPerfilLayout = new javax.swing.GroupLayout(pnlPerfil);
        pnlPerfil.setLayout(pnlPerfilLayout);
        pnlPerfilLayout.setHorizontalGroup(
            pnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlUserFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPerfilLayout.createSequentialGroup()
                        .addGroup(pnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPerfilLayout.createSequentialGroup()
                                .addComponent(txtUsername)
                                .addGap(16, 16, 16))
                            .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditarDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPerfilLayout.createSequentialGroup()
                                .addComponent(lblIdade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(102, 102, 102))
                            .addGroup(pnlPerfilLayout.createSequentialGroup()
                                .addComponent(txtIdade)
                                .addContainerGap())
                            .addGroup(pnlPerfilLayout.createSequentialGroup()
                                .addComponent(btnCartaoDeCredito, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPerfilLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLogOff))))
        );
        pnlPerfilLayout.setVerticalGroup(
            pnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlUserFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlPerfilLayout.createSequentialGroup()
                        .addGroup(pnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCartaoDeCredito, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                            .addComponent(btnEditarDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogOff)))
                .addContainerGap())
        );

        tpnlTelaInicial.addTab("Perfil", pnlPerfil);

        pnlJogos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jogos a venda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tblJogos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblJogos);

        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlJogosLayout = new javax.swing.GroupLayout(pnlJogos);
        pnlJogos.setLayout(pnlJogosLayout);
        pnlJogosLayout.setHorizontalGroup(
            pnlJogosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlJogosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlJogosLayout.createSequentialGroup()
                .addGap(0, 159, Short.MAX_VALUE)
                .addComponent(btnComprar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizar)
                .addGap(9, 9, 9))
        );
        pnlJogosLayout.setVerticalGroup(
            pnlJogosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJogosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlJogosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tpnlTelaInicial.addTab("Jogos", pnlJogos);

        btnRelatorioCompras.setText("Relatorio de compras");
        btnRelatorioCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioComprasActionPerformed(evt);
            }
        });

        btnRelatorioUsuarios.setText("Relatorio de usuarios");
        btnRelatorioUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioUsuariosActionPerformed(evt);
            }
        });

        btnGraficoGeneros.setText("Grafico de generos");
        btnGraficoGeneros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficoGenerosActionPerformed(evt);
            }
        });

        btnGraficoGeneroJogador.setText("Grafico de Generos");
        btnGraficoGeneroJogador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficoGeneroJogadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRelatoriosGraficosLayout = new javax.swing.GroupLayout(pnlRelatoriosGraficos);
        pnlRelatoriosGraficos.setLayout(pnlRelatoriosGraficosLayout);
        pnlRelatoriosGraficosLayout.setHorizontalGroup(
            pnlRelatoriosGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRelatoriosGraficosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRelatoriosGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnRelatorioCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRelatorioUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGraficoGeneros, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(btnGraficoGeneroJogador)
                .addContainerGap())
        );
        pnlRelatoriosGraficosLayout.setVerticalGroup(
            pnlRelatoriosGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRelatoriosGraficosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlRelatoriosGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGraficoGeneroJogador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlRelatoriosGraficosLayout.createSequentialGroup()
                        .addComponent(btnRelatorioCompras)
                        .addGap(18, 18, 18)
                        .addComponent(btnRelatorioUsuarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGraficoGeneros)
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tpnlTelaInicial.addTab("Relatorios e Graficos", pnlRelatoriosGraficos);

        pnlJogosdoUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Meus Jogos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tblJogosUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblJogosUsuario);

        javax.swing.GroupLayout pnlJogosdoUsuarioLayout = new javax.swing.GroupLayout(pnlJogosdoUsuario);
        pnlJogosdoUsuario.setLayout(pnlJogosdoUsuarioLayout);
        pnlJogosdoUsuarioLayout.setHorizontalGroup(
            pnlJogosdoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pnlJogosdoUsuarioLayout.setVerticalGroup(
            pnlJogosdoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
        );

        this.setBackground(Color.BLACK);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpnlTelaInicial)
            .addComponent(pnlJogosdoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tpnlTelaInicial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlJogosdoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDadosActionPerformed
        TelaCadastroUsuario telacadastrausuario = new TelaCadastroUsuario(this);
        telacadastrausuario.setVisible(true);
    }//GEN-LAST:event_btnEditarDadosActionPerformed

    private void btnCartaoDeCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartaoDeCreditoActionPerformed
        TelaCartao telacartao;
        try {
            telacartao = new TelaCartao(this);
            telacartao.setVisible(true);
        } catch (SQLException ex) {

        }

    }//GEN-LAST:event_btnCartaoDeCreditoActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        TelaProdutora telaprodutora;
        try {
            telaprodutora = new TelaProdutora(this);
            telaprodutora.setVisible(true);
        } catch (SQLException ex) {

        }

    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        this.linhaselecionada = this.tblJogos.getSelectedRow();
        try {
            Jogo jogo = new Jogo();
            jogo = this.jogos.get(linhaselecionada);
            String mensagem = "Deseja alterar este jogo?";
            String titulo = "Alterar jogo";
            int resultado = JOptionPane.showConfirmDialog(this, mensagem, titulo, JOptionPane.YES_NO_CANCEL_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                TelaCadastroJogo telacadastrojogo = new TelaCadastroJogo(this);
                telacadastrojogo.setVisible(true);
            } else {

            }

        } catch (ArrayIndexOutOfBoundsException e) {
            String mensagem = "Nenhum jogo selecionado";
            String titulo = "Erro";
            JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
        } finally {
            this.atualizaLista();
        }

    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnLogOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOffActionPerformed
        this.jLabel1.setVisible(false);
        this.txtUsername.setText("");
        this.txtIdade.setText("");
        this.jogosusuario = new ArrayList<>();
        TelaLogin telalogin = new TelaLogin(this);
        telalogin.setVisible(true);
        this.setEnabled(false);

    }//GEN-LAST:event_btnLogOffActionPerformed

    public void mostraBotos(){
        this.btnGraficoGeneroJogador.setVisible(false);
        this.btnGraficoGeneros.setVisible(true);
        this.btnRelatorioCompras.setVisible(true);
        this.btnRelatorioUsuarios.setVisible(true);
    }
    
    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        this.linhaselecionada = this.tblJogos.getSelectedRow();
        Compra compra = new Compra();
        Date dataatual = new Date(System.currentTimeMillis());
        compra.setDatacompra(dataatual.toString());
        try {
            if (this.usuario.getListaCartão().isEmpty()) {
                String mensagem = "Nenhum cartão cadastrado";
                String titulo = "Erro";
                JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
            } else {
                Jogo jogo = new Jogo();
                jogo = this.jogos.get(linhaselecionada);
                String mensagem = "Deseja comprar este jogo?";
                String titulo = "Comprar jogo";
                int resultado = JOptionPane.showConfirmDialog(this, mensagem, titulo, JOptionPane.YES_NO_CANCEL_OPTION);
                if (resultado == JOptionPane.YES_OPTION) {
                    TelaCartao telacartao = new TelaCartao(this, jogo);
                    telacartao.setVisible(true);
                    CompraBO comprabo = new CompraBO();
                    comprabo.criar(compra, usuario, jogo);
                    
                } else {

                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            String mensagem = "Nenhum jogo selecionado";
            String titulo = "Erro";
            JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.atualizaLista();
        }
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnRelatorioComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioComprasActionPerformed
        List<Jogo> jogoscomprados = new ArrayList<>();
        List<Compra> todascompras = new ArrayList<>();
        CompraBO comprabo = new CompraBO();
        try {
            todascompras = comprabo.buscarTudoCompra();
            for(Compra compra : todascompras){
                Jogo jogo = new Jogo();
                jogo = comprabo.buscaJogoComprado(compra.getIdjogo());
                jogoscomprados.add(jogo);
            }
            this.relatorioJogosMaisVendidos(jogos);
        } catch (SQLException ex) {
            String mensagem = "Houve um erro";
            String titulo = "Erro";
            JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
        } catch (JRException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao exibir relatorio","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRelatorioComprasActionPerformed

    private void btnRelatorioUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioUsuariosActionPerformed
        List<Usuario> usuarioscompraram = new ArrayList<>();
        List<Compra> todascompras = new ArrayList<>();
        CompraBO comprabo = new CompraBO();
        try {
            todascompras = comprabo.buscarTudoCompra();
            for(Compra compra : todascompras){
                Usuario usuario = new Usuario();
                usuario = comprabo.buscaUsuarioComprou(compra.getUsuario());
                usuarioscompraram.add(usuario);
            }
            this.relatorioUsuariosMaisCompraram(usuarioscompraram);
        } catch (SQLException ex) {
            String mensagem = "Houve um erro";
            String titulo = "Erro";
            JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
        } catch (JRException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao exibir relatorio","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRelatorioUsuariosActionPerformed

    private void btnGraficoGenerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficoGenerosActionPerformed
        List<Jogo> jogoscomprados = new ArrayList<>();
        List<Compra> todascompras = new ArrayList<>();
        CompraBO comprabo = new CompraBO();
        try {
            todascompras = comprabo.buscarTudoCompra();
            for(Compra compra : todascompras){
                Jogo jogo = new Jogo();
                jogo = comprabo.buscaJogoComprado(compra.getIdjogo());
                jogoscomprados.add(jogo);
            }
            this.GraficoGeneroMaisVendidos(jogoscomprados);
        } catch (SQLException ex) {
            String mensagem = "Houve um erro";
            String titulo = "Erro";
            JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
        } catch (JRException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao exibir relatorio","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGraficoGenerosActionPerformed

    private void btnGraficoGeneroJogadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficoGeneroJogadorActionPerformed
        try {
            this.GraficoGeneroMaisJoga(this.jogosusuario);
        } catch (JRException ex) {
          Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao exibir relatorio","Erro",JOptionPane.ERROR_MESSAGE);  
        }
    }//GEN-LAST:event_btnGraficoGeneroJogadorActionPerformed

    public void relatorioJogosMaisVendidos(List<Jogo> jogos) throws JRException{
        String arquivoRelatorio = System.getProperty("user.dir")+"/Relatorios/RelatorioJogosMaisVendidos.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(jogos);
        JasperPrint relatorioGerado = JasperFillManager.fillReport(arquivoRelatorio, parametros, fonteDados);
        JasperViewer telaExibiçãoRelatorio = new JasperViewer(relatorioGerado,false);
        telaExibiçãoRelatorio.setTitle("Relatorio de Jogos vendidos");
        telaExibiçãoRelatorio.setVisible(true);
    }
    
    public void relatorioUsuariosMaisCompraram(List<Usuario> usuarioscompraram) throws JRException{
        String arquivoRelatorio = System.getProperty("user.dir")+"/Relatorios/RelatorioUsuariosMaisCompraram.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(usuarioscompraram);
        JasperPrint relatorioGerado = JasperFillManager.fillReport(arquivoRelatorio, parametros, fonteDados);
        JasperViewer telaExibiçãoRelatorio = new JasperViewer(relatorioGerado,false);
        telaExibiçãoRelatorio.setTitle("Relatorio de Usuarios mais compraram");
        telaExibiçãoRelatorio.setVisible(true);
    }
    
    public void GraficoGeneroMaisVendidos(List<Jogo> jogos) throws JRException{
        String arquivoRelatorio = System.getProperty("user.dir")+"/Relatorios/GraficoGenerosMaisVendidos.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(jogos);
        JasperPrint relatorioGerado = JasperFillManager.fillReport(arquivoRelatorio, parametros, fonteDados);
        JasperViewer telaExibiçãoRelatorio = new JasperViewer(relatorioGerado,false);
        telaExibiçãoRelatorio.setTitle("Relatorio de Jogos vendidos");
        telaExibiçãoRelatorio.setVisible(true);
    }
    
    public void GraficoGeneroMaisJoga(List<Jogo> jogos) throws JRException{
        String arquivoRelatorio = System.getProperty("user.dir")+"/Relatorios/GraficoGenerosMaisJoga.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(jogos);
        JasperPrint relatorioGerado = JasperFillManager.fillReport(arquivoRelatorio, parametros, fonteDados);
        JasperViewer telaExibiçãoRelatorio = new JasperViewer(relatorioGerado,false);
        telaExibiçãoRelatorio.setTitle("Relatorio de Jogos vendidos");
        telaExibiçãoRelatorio.setVisible(true);
    }
    
    public void preencheUsuario(Usuario user) {
        this.usuario = user;
        this.preencheDadosTela(usuario);
    }

    public void preencheDadosTela(Usuario usuario) {
        this.txtUsername.setText(usuario.getUsername());
        this.txtIdade.setText(String.valueOf(usuario.getIdade()));
    }

    public void visualizaperfil() {
        this.jLabel1.setVisible(true);
    }

    public void visualizaAdicionarJogos() {
        this.btnAdicionar.setVisible(true);
        this.btnAtualizar.setVisible(true);
    }

    private void preencheTabela() {
        try {
            JogoBO jogoBO = new JogoBO();
            this.jogos = jogoBO.buscarTodos();
            this.atualizaLista();
        } catch (SQLException sqle) {
            String mensagem = "Houve um erro na Exibiçao";
            String titulo = "Erro ao exibir pedido";
            JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void atualizaLista() {
        ModeloDadosJogos modelo = new ModeloDadosJogos();
        this.tblJogos.setModel(modelo);
    }

    public void preencheTabelaUsuario() {
        try {
            List<Compra> compras = new ArrayList<>();
            CompraBO compraBO = new CompraBO();
            compras = compraBO.buscarCompraPorIDUsuario(this.usuario);
            for(Compra compra : compras){
                Jogo jogo = new Jogo();
                jogo = compraBO.buscaJogoComprado(compra.getIdjogo());
                this.jogosusuario.add(jogo);
            }
            this.atualizaListaUsuario();
        } catch (SQLException sqle) {
            String mensagem = "Houve um erro na Exibiçao";
            String titulo = "Erro ao exibir pedido";
            JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void atualizaListaUsuario() {
        ModeloDadosJogosUsuario modelo = new ModeloDadosJogosUsuario();
        this.tblJogosUsuario.setModel(modelo);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCartaoDeCredito;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnEditarDados;
    private javax.swing.JButton btnGraficoGeneroJogador;
    private javax.swing.JButton btnGraficoGeneros;
    private javax.swing.JButton btnLogOff;
    private javax.swing.JButton btnRelatorioCompras;
    private javax.swing.JButton btnRelatorioUsuarios;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlJogos;
    private javax.swing.JPanel pnlJogosdoUsuario;
    private javax.swing.JPanel pnlPerfil;
    private javax.swing.JPanel pnlRelatoriosGraficos;
    private javax.swing.JPanel pnlUserFoto;
    private javax.swing.JTable tblJogos;
    private javax.swing.JTable tblJogosUsuario;
    private javax.swing.JTabbedPane tpnlTelaInicial;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
class ModeloDadosJogos extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return jogos.size();
        }

        @Override
        public String getColumnName(int column) {
            if (column == 0) {
                return "Nome";
            } else if (column == 1) {
                return "ESRB";
            } else if (column == 2) {
                return "Data de lançamento";
            } else if (column == 3) {
                return "plataforma";
            } else if (column == 4) {
                return "Genero";
            } else {
                return "valor";
            }
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Jogo jogo = jogos.get(rowIndex);
            if (columnIndex == 0) {
                return jogo.getNome();
            } else if (columnIndex == 1) {
                return jogo.getESRB();
            } else if (columnIndex == 2) {
                return jogo.getDatadelançamento();
            } else if (columnIndex == 3) {
                return jogo.getPlataforma();
            } else if (columnIndex == 4) {
                return jogo.getGenero();
            } else {
                return jogo.getValor();
            }
        }
    }

    class ModeloDadosJogosUsuario extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return jogosusuario.size();
        }

        @Override
        public String getColumnName(int column) {
            if (column == 0) {
                return "Nome";
            } else if (column == 1) {
                return "ESRB";
            } else if (column == 2) {
                return "Data de lançamento";
            } else if (column == 3) {
                return "plataforma";
            } else if (column == 4) {
                return "Genero";
            } else {
                return "valor";
            }
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Jogo jogo = jogosusuario.get(rowIndex);
            if (columnIndex == 0) {
                return jogo.getNome();
            } else if (columnIndex == 1) {
                return jogo.getESRB();
            } else if (columnIndex == 2) {
                return jogo.getDatadelançamento();
            } else if (columnIndex == 3) {
                return jogo.getPlataforma();
            } else if (columnIndex == 4) {
                return jogo.getGenero();
            } else {
                return jogo.getValor();
            }
        }
    }
}
