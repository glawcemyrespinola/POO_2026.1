package Interfaces;

import ClassesAuxiliares.ConexaoBD;
import ClassesAuxiliares.Funcionario;

import javax.swing.*;
import java.util.ArrayList;

public class Login extends JFrame {

    public Login() {
        initComponents();
        this.setTitle("Acesso ao Sistema da Drogaria Maria Vitória");
        this.setSize(430, 270); // Garante largura suficiente para o título completo aparecer
        this.setLocationRelativeTo(null);
        jButton1.setText("Entrar");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new JSplitPane();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        jLabel2 = new JLabel();
        jButton1 = new JButton();
        jPasswordField1 = new JPasswordField();
        jLabel3 = new JLabel();
        jButtonNovoUsuario = new JButton();
        jButtonEsquecerSenha = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Acesso ao Sistema da Drogaria Maria Vitória");
        setResizable(false);

        jLabel1.setText("Login:");

        jLabel2.setText("Senha:");

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonNovoUsuario.setText("Novo Usuário");
        jButtonNovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoUsuarioActionPerformed(evt);
            }
        });

        jButtonEsquecerSenha.setText("Esqueci a Senha");
        jButtonEsquecerSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEsquecerSenhaActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextField1, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                                        .addComponent(jPasswordField1)))
                                        .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButtonNovoUsuario, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                                .addComponent(jButtonEsquecerSenha, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonNovoUsuario, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonEsquecerSenha, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(35, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ConexaoBD conexao = new ConexaoBD();
        conexao.conectar();
        ArrayList<Funcionario> lista = conexao.consultaFuncionario();
        conexao.fecharConexao();

        String loginDigitado = jTextField1.getText() != null ? jTextField1.getText().trim() : "";
        String senhaDigitada = String.valueOf(jPasswordField1.getPassword()) != null ? String.valueOf(jPasswordField1.getPassword()).trim() : "";

        boolean autenticado = false;

        for (Funcionario func : lista) {
            String loginBanco = func.getLogin() != null ? func.getLogin().trim() : "";
            String senhaBanco = func.getSenha() != null ? func.getSenha().trim() : "";

            if (loginDigitado.equals(loginBanco) && senhaDigitada.equals(senhaBanco)) {
                autenticado = true;

                Principal inicio = new Principal(func.getNome());
                inicio.setVisible(true);
                this.dispose();
                break;
            }
        }

        if (!autenticado) {
            jLabel3.setText("Login ou senha incorreto");
            jTextField1.setText("");
            jPasswordField1.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonNovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoUsuarioActionPerformed
        String nome = JOptionPane.showInputDialog(this, "Digite o Nome completo do funcionário:");
        if (nome != null && !nome.trim().isEmpty()) {
            String login = JOptionPane.showInputDialog(this, "Defina o Login:");
            if (login != null && !login.trim().isEmpty()) {
                String senha = JOptionPane.showInputDialog(this, "Defina a Senha:");
                if (senha != null && !senha.trim().isEmpty()) {
                    ConexaoBD conexao = new ConexaoBD();
                    conexao.conectar();
                    conexao.inserirFuncionario(nome.trim(), login.trim(), senha.trim());
                    conexao.fecharConexao();
                    JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso! Já pode realizar o login.");
                }
            }
        }
    }//GEN-LAST:event_jButtonNovoUsuarioActionPerformed

    private void jButtonEsquecerSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEsquecerSenhaActionPerformed
        String loginBusca = JOptionPane.showInputDialog(this, "Informe o seu Login para recuperar a senha:");
        if (loginBusca != null && !loginBusca.trim().isEmpty()) {
            ConexaoBD conexao = new ConexaoBD();
            conexao.conectar();
            ArrayList<Funcionario> lista = conexao.consultaFuncionario();
            conexao.fecharConexao();

            boolean encontrado = false;
            for (Funcionario f : lista) {
                if (f.getLogin() != null && f.getLogin().trim().equalsIgnoreCase(loginBusca.trim())) {
                    JOptionPane.showMessageDialog(this, "Sua senha é: " + f.getSenha(), "Recuperação de Senha", JOptionPane.INFORMATION_MESSAGE);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(this, "Login não encontrado no sistema.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonEsquecerSenhaActionPerformed

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton jButton1;
    private JButton jButtonEsquecerSenha;
    private JButton jButtonNovoUsuario;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPasswordField jPasswordField1;
    private JSplitPane jSplitPane1;
    private JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}