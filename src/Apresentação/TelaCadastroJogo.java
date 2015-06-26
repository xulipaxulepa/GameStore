/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentação;

import Entidades.Jogo;
import Entidades.Produtora;
import Negocio.JogoBO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author xulipaxulepa
 */
public class TelaCadastroJogo extends javax.swing.JFrame {

    public Jogo jogo = new Jogo();
    public Produtora produtora = new Produtora();
    public TelaInicial telainicial = null;
    /**
     * Creates new form TelaCadastroUsuario
     * @param telacartao
     */
    public TelaCadastroJogo(Produtora produtora) {
        initComponents();
        this.produtora = produtora;
        this.btnAlterar.setVisible(false);
        
    }
    
    public TelaCadastroJogo(TelaInicial telainicial) {
        initComponents();
        this.telainicial = telainicial;
        this.btnAlterar.setVisible(true);
        this.btnCadastrar.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTelaCadastraUsuario = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblDataLancamento = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtDatalancamento = new javax.swing.JTextField();
        lblESRB = new javax.swing.JLabel();
        txtESRB = new javax.swing.JTextField();
        lblPlataforma = new javax.swing.JLabel();
        txtPlataforma = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        lblGenero = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        pnlTelaCadastraUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        lblNome.setText("Nome:");

        lblDataLancamento.setText("Data de lançamento:");

        lblESRB.setText("ESRB:");

        lblPlataforma.setText("Plataforma:");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnAlterar.setText("Editar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        lblValor.setText("Valor:");

        lblGenero.setText("Genero:");

        javax.swing.GroupLayout pnlTelaCadastraUsuarioLayout = new javax.swing.GroupLayout(pnlTelaCadastraUsuario);
        pnlTelaCadastraUsuario.setLayout(pnlTelaCadastraUsuarioLayout);
        pnlTelaCadastraUsuarioLayout.setHorizontalGroup(
            pnlTelaCadastraUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelaCadastraUsuarioLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(btnCadastrar)
                .addGap(18, 18, 18)
                .addComponent(btnAlterar)
                .addGap(0, 155, Short.MAX_VALUE))
            .addGroup(pnlTelaCadastraUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTelaCadastraUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTelaCadastraUsuarioLayout.createSequentialGroup()
                        .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(149, 149, 149)
                        .addComponent(lblDataLancamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlTelaCadastraUsuarioLayout.createSequentialGroup()
                        .addGroup(pnlTelaCadastraUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlTelaCadastraUsuarioLayout.createSequentialGroup()
                                .addGroup(pnlTelaCadastraUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtESRB, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(109, 109, 109))
                            .addGroup(pnlTelaCadastraUsuarioLayout.createSequentialGroup()
                                .addComponent(lblESRB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(17, 17, 17)))
                        .addGroup(pnlTelaCadastraUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPlataforma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlTelaCadastraUsuarioLayout.createSequentialGroup()
                                .addGroup(pnlTelaCadastraUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDatalancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 91, Short.MAX_VALUE))))
                    .addGroup(pnlTelaCadastraUsuarioLayout.createSequentialGroup()
                        .addGroup(pnlTelaCadastraUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(pnlTelaCadastraUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlTelaCadastraUsuarioLayout.createSequentialGroup()
                                .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pnlTelaCadastraUsuarioLayout.setVerticalGroup(
            pnlTelaCadastraUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelaCadastraUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTelaCadastraUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(lblDataLancamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTelaCadastraUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDatalancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTelaCadastraUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblESRB)
                    .addComponent(lblPlataforma))
                .addGap(18, 18, 18)
                .addGroup(pnlTelaCadastraUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtESRB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTelaCadastraUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(lblGenero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTelaCadastraUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnlTelaCadastraUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTelaCadastraUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTelaCadastraUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (this.txtNome.getText().isEmpty() || this.txtDatalancamento.getText().isEmpty() || this.txtESRB.getText().isEmpty() || this.txtPlataforma.getText().isEmpty()) {
            String mensagem = "Nenhum valor inserido";
            String titulo = "Erro";
            JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
        } else {
            this.preencheUsuario(this.jogo);
            JogoBO jogobo = new JogoBO();
            
            try {
                jogobo.criar(jogo,this.produtora);
                String mensagem = "Cadastro efetuado com sucesso";
                String titulo = "Parabêns";
                JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (SQLException ex) {
                String mensagem = "Houve um erro";
                String titulo = "Erro no banco";
                JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
            } 
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (this.txtNome.getText().isEmpty() || this.txtDatalancamento.getText().isEmpty() || this.txtESRB.getText().isEmpty() || this.txtPlataforma.getText().isEmpty()) {
            String mensagem = "Nenhum valor inserido";
            String titulo = "Erro";
            JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
        } else{
        JogoBO jogobo = new JogoBO();
        this.jogo = this.telainicial.jogos.get(this.telainicial.linhaselecionada);
        this.preencheUsuario(this.jogo);
        this.jogo.setNome(this.txtNome.getText());
        this.jogo.setDatadelançamento(this.txtDatalancamento.getText());
        this.jogo.setESRB(this.txtESRB.getText());
        this.jogo.setPlataforma(this.txtPlataforma.getText());
        this.jogo.setValor(Float.valueOf(this.txtValor.getText()));
        this.jogo.setGenero(this.txtGenero.getText());
        try {
            jogobo.atualizar(this.jogo);
            String mensagem = "Dados atualizados com sucesso";
            String titulo = "Sucesso";
            JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (SQLException ex) {
            String mensagem = "Houve um Erro";
            String titulo = "Erro";
            JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    
    public void preencheUsuario(Jogo jogo) {
        jogo.setNome(this.txtNome.getText());
        jogo.setDatadelançamento(this.txtDatalancamento.getText());
        jogo.setESRB(this.txtESRB.getText());
        jogo.setPlataforma(this.txtPlataforma.getText());
        jogo.setValor(Float.valueOf(this.txtValor.getText()));
        jogo.setGenero(this.txtGenero.getText());
        jogo.setIdprodutora(this.produtora.getId());
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel lblDataLancamento;
    private javax.swing.JLabel lblESRB;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPlataforma;
    private javax.swing.JLabel lblValor;
    private javax.swing.JPanel pnlTelaCadastraUsuario;
    private javax.swing.JTextField txtDatalancamento;
    private javax.swing.JTextField txtESRB;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPlataforma;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
