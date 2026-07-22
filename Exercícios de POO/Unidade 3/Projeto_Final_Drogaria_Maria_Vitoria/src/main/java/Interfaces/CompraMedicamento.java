package Interfaces;

import ClassesAuxiliares.ConexaoBD;
import ClassesAuxiliares.Medicamento;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class CompraMedicamento extends JInternalFrame {

    public CompraMedicamento() {
        initComponents();
        listaCompra = new ArrayList<>();
        banco.conectar();
        lista = banco.consultarMedicamento();
        banco.fecharConexao();
        for (Medicamento M : lista) {
            jComboBox1.addItem(M.getDescricao());
        }
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTop = new JPanel();
        jLabelTitulo = new JLabel();
        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();
        jComboBox1 = new JComboBox<>();
        jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jTextField2 = new JTextField();
        jButton3 = new JButton();
        jButton2 = new JButton();
        jButton1 = new JButton();

        // Título da tela no topo (igual ao padrão de funcionários)
        jLabelTitulo.setFont(new Font("Ubuntu", Font.BOLD, 18));
        jLabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelTitulo.setText("Compra de Medicamentos");

        GroupLayout jPanelTopLayout = new GroupLayout(jPanelTop);
        jPanelTop.setLayout(jPanelTopLayout);
        jPanelTopLayout.setHorizontalGroup(
                jPanelTopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelTopLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitulo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanelTopLayout.setVerticalGroup(
                jPanelTopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelTopLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitulo, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jTable1.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Descrição", "Fornecedor", "Quantidade", "Valor Unitário", "Valor Total"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        jLabel1.setText("Medicamento:");

        jLabel2.setText("Quantidade:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("SubTotal:");

        jLabel4.setText("0,00");

        jLabel5.setText("Valor:");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, 0, 100, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setText("Finalizar Compra");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Remover");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                                .addGap(28, 28, 28)
                                                .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                                .addGap(28, 28, 28)
                                                .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelTop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String qtdTexto = jTextField1.getText().trim();
            String valTexto = jTextField2.getText().trim();

            if (qtdTexto.isEmpty() || valTexto.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha a quantidade e o valor unitário.");
                return;
            }

            int quantidade = Integer.parseInt(qtdTexto);
            double valorUnitario = Double.parseDouble(valTexto.replace(",", "."));

            if (quantidade <= 0 || valorUnitario < 0) {
                JOptionPane.showMessageDialog(null, "Informe valores válidos maiores que zero.");
                return;
            }

            String produtoSelecionado = (String) jComboBox1.getSelectedItem();

            banco.conectar();
            lista = banco.consultarMedicamento();
            banco.fecharConexao();

            Medicamento medicamentoEscolhido = null;
            for (Medicamento p : lista) {
                if (p.getDescricao().equals(produtoSelecionado)) {
                    medicamentoEscolhido = p;
                    break;
                }
            }

            if (medicamentoEscolhido != null) {
                medicamentoEscolhido.setQuantidade(quantidade);
                medicamentoEscolhido.setValorUnitario(valorUnitario);
                medicamentoEscolhido.setValorTotal(quantidade * valorUnitario);

                listaCompra.add(medicamentoEscolhido);

                modelo = (DefaultTableModel) jTable1.getModel();
                modelo.addRow(new Object[]{
                        medicamentoEscolhido.getDescricao(),
                        medicamentoEscolhido.getFornecedor(),
                        medicamentoEscolhido.getQuantidade(),
                        medicamentoEscolhido.getValorUnitario(),
                        medicamentoEscolhido.getValorTotal()
                });

                atualizarSubtotal();
                jTextField1.setText("");
                jTextField2.setText("");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Preencha os campos numéricos corretamente.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (listaCompra.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há itens na lista para finalizar a compra.");
            return;
        }

        for (Medicamento p : listaCompra) {
            p.setQuantidadeEstoque(p.getQuantidadeEstoque() + p.getQuantidade());
            banco.conectar();
            banco.atualizarQV(p.getCod(), p.getValorUnitario(), p.getQuantidadeEstoque());
            banco.fecharConexao();
        }

        JOptionPane.showMessageDialog(null, "Compra Finalizada com sucesso!");
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int indice = jTable1.getSelectedRow();
            if (indice >= 0) {
                listaCompra.remove(indice);
                ((DefaultTableModel) jTable1.getModel()).removeRow(indice);
                atualizarSubtotal();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um produto na tabela para remover.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover o item.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void atualizarSubtotal() {
        double totalGeral = 0;
        for (Medicamento m : listaCompra) {
            totalGeral += m.getValorTotal();
        }
        jLabel4.setText(String.format("R$ %.2f", totalGeral));
    }

    ArrayList<Medicamento> listaCompra;
    ArrayList<Medicamento> lista;
    ConexaoBD banco = new ConexaoBD();
    private DefaultTableModel modelo;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabelTitulo;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanelTop;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}