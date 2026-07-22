package Interfaces;

import ClassesAuxiliares.ConexaoBD;
import ClassesAuxiliares.Fornecedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class CadastrarFornecedor extends JInternalFrame {

    public CadastrarFornecedor() {
        initComponents();
        modelo = (DefaultTableModel) jTable1.getModel();
        carregaTabela();

        // Substitui o MouseListener por ListSelectionListener para capturar a seleção perfeitamente
        jTable1.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && jTable1.getSelectedRow() != -1) {
                preencherCamposSelecionados();
            }
        });
    }

    public void carregaTabela() {
        modelo.setNumRows(0);
        lista = new ArrayList<>();
        conexao = new ConexaoBD();
        conexao.conectar();
        lista = conexao.consultarFornecedor();
        conexao.fecharConexao();
        for (Fornecedor f : lista) {
            modelo.addRow(new Object[]{f.getCnpj(), f.getNome(), f.getCidade(), f.getTelefone()});
        }
    }

    private void preencherCamposSelecionados() {
        int linha = jTable1.getSelectedRow();
        if (linha != -1) {
            jFormattedTextField1.setText(jTable1.getValueAt(linha, 0).toString());
            jTextField1.setText(jTable1.getValueAt(linha, 1).toString());
            jTextField2.setText(jTable1.getValueAt(linha, 2).toString());
            jTextField3.setText(jTable1.getValueAt(linha, 3).toString());

            // O CNPJ é a chave primária, então desativamos a edição dele para evitar conflitos
            jFormattedTextField1.setEnabled(false);
        }
    }

    private void limparCampos() {
        jFormattedTextField1.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jFormattedTextField1.setEnabled(true);
        jTable1.clearSelection();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jFormattedTextField1 = new JFormattedTextField();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jLabel4 = new JLabel();
        jTextField2 = new JTextField();
        jLabel5 = new JLabel();
        jTextField3 = new JTextField();
        jButton1 = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jButton2 = new JButton();
        jButtonAtualizar = new JButton();

        // Título ajustado para "Cadastro de Fornecedores" com fonte padronizada
        jLabel1.setFont(new Font("Ubuntu", Font.BOLD, 18));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Fornecedores");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jLabel2.setText("CNPJ:");

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel3.setText("NOME:");

        jLabel4.setText("CIDADE:");

        jLabel5.setText("TELEFONE:");

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "CNPJ", "Nome", "Cidade", "Telefone"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel2))
                                                .addGap(4, 4, 4)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jFormattedTextField1)
                                                        .addComponent(jTextField1)
                                                        .addComponent(jTextField2)
                                                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButtonAtualizar, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                .addGap(53, 53, 53)
                                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jFormattedTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(jButtonAtualizar))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
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
        String cnpj = jFormattedTextField1.getText().trim();
        String nome = jTextField1.getText().trim();
        String cidade = jTextField2.getText().trim();
        String telefone = jTextField3.getText().trim();

        if (cnpj.replace(" ", "").replace(".", "").replace("/", "").replace("-", "").isEmpty() ||
                nome.isEmpty() || cidade.isEmpty() || telefone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos do fornecedor.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        conexao = new ConexaoBD();
        conexao.conectar();
        conexao.inserirFornecedor(cnpj, nome, telefone, cidade);
        conexao.fecharConexao();

        limparCampos();
        carregaTabela();
        JOptionPane.showMessageDialog(this, "Fornecedor cadastrado com sucesso!");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int indice = jTable1.getSelectedRow();
            if (indice != -1) {
                String cnpjSelecionado = (String) jTable1.getValueAt(indice, 0);

                UIManager.put("OptionPane.yesButtonText", "Sim");
                UIManager.put("OptionPane.noButtonText", "Não");

                int confirmacao = JOptionPane.showConfirmDialog(
                        this,
                        "Deseja realmente excluir o fornecedor selecionado?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (confirmacao == JOptionPane.YES_OPTION) {
                    conexao = new ConexaoBD();
                    conexao.conectar();
                    conexao.removerFornecedor(cnpjSelecionado);
                    conexao.fecharConexao();

                    limparCampos();
                    carregaTabela();
                    JOptionPane.showMessageDialog(this, "Fornecedor removido com sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um fornecedor na tabela para excluir.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao remover o fornecedor.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        int linha = jTable1.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um fornecedor na tabela para atualizar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String cnpj = jFormattedTextField1.getText().trim();
        String nome = jTextField1.getText().trim();
        String cidade = jTextField2.getText().trim();
        String telefone = jTextField3.getText().trim();

        if (nome.isEmpty() || cidade.isEmpty() || telefone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos para atualizar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        conexao = new ConexaoBD();
        conexao.conectar();
        conexao.atualizarFornecedor(cnpj, nome, telefone, cidade);
        conexao.fecharConexao();

        limparCampos();
        carregaTabela();
        JOptionPane.showMessageDialog(this, "Fornecedor atualizado com sucesso!");
    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    public static DefaultTableModel modelo;
    ArrayList<Fornecedor> lista;
    ConexaoBD conexao;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButtonAtualizar;
    private JFormattedTextField jFormattedTextField1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}