/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Janelas;

import DAO.MedVendidosDAO;
import DAO.MedicamentoDAO;
import DAO.VendaDAO;
import Model.MedVendidosTableModel;
import Objetos.MedVendidos;
import Objetos.Medicamento;
import Objetos.Venda;
import java.awt.Cursor;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 *
 * @author miche
 */
public final class JanelaMedVendidos extends javax.swing.JFrame {

    /**
     * Creates new form JanelaMedVendidos
     */
    
    MedicamentoDAO medDao = new MedicamentoDAO();
    MedVendidosTableModel model = new MedVendidosTableModel();
    Venda v = new Venda();
    VendaDAO vendDao = new VendaDAO();
    
    List<Medicamento> medList = medDao.read();
    
    int clique = -1;
    
    public JanelaMedVendidos() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        for (int i = 0; i < medList.size(); i++) {
            MedComboBox.addItem(String.valueOf((medList.get(i).getCodmedicamento())) + " - " + 
                    medList.get(i).getNomemedicamento() + " (" + medList.get(i).getQuantidadeestoque() + " unidades)");
        }
        
        caixaValorTotal.setVisible(false);
        caixaInsValorTotal.setVisible(false);
        
        TabMedVend.setModel(model);
        formatar();
    }
    
    public JanelaMedVendidos(Venda vendaEfetuada, String botao) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        for (int i = 0; i < medList.size(); i++) {
            MedComboBox.addItem(String.valueOf((medList.get(i).getCodmedicamento())) + " - " + 
                    medList.get(i).getNomemedicamento() + " (" + medList.get(i).getQuantidadeestoque() + " unidades)");
        }
        
        String botaoPress = "Avançar";
        
        if (botaoPress.equals(botao)) {
            caixaTitulo.setText("ADICIONAR ITENS (VENDA)");
        } else {
            caixaTitulo.setText("CONSULTAR ITENS - CÓDIGO VENDA: " + vendaEfetuada.getCodpedido());
            caixaInsValorTotal.setText(String.valueOf(vendaEfetuada.getValorpedidovenda()));
            
            model.recarregaTabelaPesq(String.valueOf(vendaEfetuada.getCodpedido()));
            botaoCadastrarVenda.setText("Fechar");
        }
        
        caixaValorTotal.setVisible(false);
        caixaInsValorTotal.setVisible(false);
        
        v.setDatavenda(vendaEfetuada.getDatavenda());
        v.setFormapagamentovenda(vendaEfetuada.getFormapagamentovenda());
        v.setCoddrogaria(vendaEfetuada.getCoddrogaria());
        v.setCodpedido(vendaEfetuada.getCodpedido());
        
        caixaInsData.setText(desconverterData(vendaEfetuada.getDatavenda()));
        
        TabMedVend.setModel(model);
        formatar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        caixaTitulo = new javax.swing.JLabel();
        caixaData = new javax.swing.JLabel();
        caixaInsData = new javax.swing.JLabel();
        caixaValorUnMed = new javax.swing.JLabel();
        caixaInsValorUnMed = new javax.swing.JTextField();
        caixaQntdMed = new javax.swing.JLabel();
        caixaInsQntdMed = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        MedComboBox = new javax.swing.JComboBox<>();
        caixaValVend = new javax.swing.JLabel();
        caixaInsValVend = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabMedVend = new javax.swing.JTable();
        botaoAdd = new javax.swing.JButton();
        botaoAlt = new javax.swing.JButton();
        botaoDel = new javax.swing.JButton();
        botaoCadastrarVenda = new javax.swing.JButton();
        caixaValorTotal = new javax.swing.JLabel();
        caixaInsValorTotal = new javax.swing.JLabel();
        botaoVoltar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);

        caixaTitulo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        caixaTitulo.setText("ADICIONAR ITENS (VENDA)");

        caixaData.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        caixaData.setText("Data da venda");

        caixaInsData.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        caixaInsData.setText("inserirData");

        caixaValorUnMed.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        caixaValorUnMed.setText("Valor unitário");

        caixaInsValorUnMed.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        caixaInsValorUnMed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                caixaInsValorUnMedKeyReleased(evt);
            }
        });

        caixaQntdMed.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        caixaQntdMed.setText("Quantidade");

        caixaInsQntdMed.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        caixaInsQntdMed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                caixaInsQntdMedKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setText("Medicamento");

        MedComboBox.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        MedComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedComboBoxMouseClicked(evt);
            }
        });
        MedComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedComboBoxActionPerformed(evt);
            }
        });

        caixaValVend.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        caixaValVend.setText("Valor total");

        caixaInsValVend.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        TabMedVend.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TabMedVend.setModel(new javax.swing.table.DefaultTableModel(
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
        TabMedVend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabMedVendMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabMedVend);

        botaoAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/Adicionar.png"))); // NOI18N
        botaoAdd.setMaximumSize(new java.awt.Dimension(35, 35));
        botaoAdd.setMinimumSize(new java.awt.Dimension(35, 35));
        botaoAdd.setPreferredSize(new java.awt.Dimension(35, 35));
        botaoAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAddActionPerformed(evt);
            }
        });

        botaoAlt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/Alterar.png"))); // NOI18N
        botaoAlt.setMaximumSize(new java.awt.Dimension(35, 35));
        botaoAlt.setMinimumSize(new java.awt.Dimension(35, 35));
        botaoAlt.setPreferredSize(new java.awt.Dimension(35, 35));
        botaoAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAltActionPerformed(evt);
            }
        });

        botaoDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/Remover.png"))); // NOI18N
        botaoDel.setMaximumSize(new java.awt.Dimension(35, 35));
        botaoDel.setMinimumSize(new java.awt.Dimension(35, 35));
        botaoDel.setPreferredSize(new java.awt.Dimension(35, 35));
        botaoDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDelActionPerformed(evt);
            }
        });

        botaoCadastrarVenda.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        botaoCadastrarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/FinalizarCompVend.png"))); // NOI18N
        botaoCadastrarVenda.setText(" Finalizar Venda");
        botaoCadastrarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarVendaActionPerformed(evt);
            }
        });

        caixaValorTotal.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        caixaValorTotal.setText("Valor total da venda - R$");

        caixaInsValorTotal.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        caixaInsValorTotal.setText("Valor total:");

        botaoVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/Voltar.png"))); // NOI18N
        botaoVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoVoltarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoVoltarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoVoltarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(caixaInsValorUnMed, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(caixaValorUnMed)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(caixaData)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(caixaInsData, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(MedComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoVoltar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(caixaTitulo))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoDel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(caixaQntdMed)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(caixaValVend)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(caixaInsQntdMed)
                            .addComponent(caixaInsValVend, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoCadastrarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(caixaValorTotal)
                        .addGap(3, 3, 3)
                        .addComponent(caixaInsValorTotal)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(caixaTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caixaData)
                    .addComponent(caixaInsData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(MedComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caixaValorUnMed)
                    .addComponent(caixaInsValorUnMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caixaQntdMed)
                    .addComponent(caixaInsQntdMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caixaValVend)
                    .addComponent(caixaInsValVend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoDel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoAlt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(caixaValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(caixaInsValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botaoCadastrarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void caixaInsValorUnMedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caixaInsValorUnMedKeyReleased
        // TODO add your handling code here:
        if (!"".equals(caixaInsQntdMed.getText()) && !"".equals(caixaInsValorUnMed.getText())) {
            double somatoria = Double.parseDouble(caixaInsQntdMed.getText()) * Double.parseDouble(caixaInsValorUnMed.getText());
            caixaInsValVend.setText(String.valueOf(somatoria));
        } else {
            caixaInsValVend.setText("");
        }
    }//GEN-LAST:event_caixaInsValorUnMedKeyReleased

    private void caixaInsQntdMedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caixaInsQntdMedKeyReleased
        // TODO add your handling code here:
        if (!"".equals(caixaInsQntdMed.getText()) && !"".equals(caixaInsValorUnMed.getText())) {
            double somatoria = Double.parseDouble(caixaInsQntdMed.getText()) * Double.parseDouble(caixaInsValorUnMed.getText());
            caixaInsValVend.setText(String.valueOf(somatoria));
        } else {
            caixaInsValVend.setText("");
        }
    }//GEN-LAST:event_caixaInsQntdMedKeyReleased

    private void MedComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedComboBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MedComboBoxMouseClicked

    private void botaoAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAddActionPerformed
        // TODO add your handling code here:
        if (MedComboBox.getSelectedIndex() != -1) {
            boolean  medcadastrado = false;
        
            int qntdVendida = Integer.parseInt(caixaInsQntdMed.getText());
            int estoque = medList.get(MedComboBox.getSelectedIndex()).getQuantidadeestoque();

            if (qntdVendida <= estoque) {
                if (TabMedVend.getRowCount() == 0) {
                medcadastrado = false;
                } else {
                    for (int i = 0; i < TabMedVend.getRowCount(); i++) {
                        int codmed = medList.get(MedComboBox.getSelectedIndex()).getCodmedicamento();
                        int codMedAdd = Integer.parseInt(String.valueOf(TabMedVend.getValueAt(i, 4)));

                            if (codmed == codMedAdd) {
                                medcadastrado = true;
                        }
                    }
                }

                String botaoPress = botaoCadastrarVenda.getText();

                if (medcadastrado) {
                    JOptionPane.showMessageDialog(null, "Medicamento já cadastrado!");
                } else {
                    addItens(botaoPress);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Quantidade insuficiente!");
            }
        }
    }//GEN-LAST:event_botaoAddActionPerformed

    private void botaoDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDelActionPerformed
        // TODO add your handling code here:
        
        int removerItem = JOptionPane.showConfirmDialog(null, "Remover item?","CONFIRMAR",JOptionPane.YES_NO_OPTION);
        
        if (removerItem == 0) {
            String botaoPress = botaoCadastrarVenda.getText();
        
            if (botaoPress.equals(" Finalizar Venda")) {
                if (TabMedVend.getSelectedRow() != -1) {
                model.removeLinha(TabMedVend.getSelectedRow());
                calcularTotal();
                }
            } else {
                if (TabMedVend.getSelectedRow() != -1) {
                    MedVendidosDAO medVendDao = new MedVendidosDAO();
                    MedVendidos medVend = new MedVendidos();

                    medVend.setCodmedicamento(Integer.parseInt(String.valueOf(TabMedVend.getValueAt(TabMedVend.getSelectedRow(), 4))));

                    boolean cadastro = medVendDao.remover(medVend, v);
                    model.recarregaTabelaPesq(String.valueOf(v.getCodpedido()));

                    if (cadastro) {
                        double valorTotal = calcularTotal();
                        v.setValorpedidovenda(valorTotal);

                        vendDao.atualizarValor(v);
                    }
                }
            }
        } else if (removerItem == 1) {
            ocultar();
        }
        
        
    }//GEN-LAST:event_botaoDelActionPerformed

    private void botaoAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAltActionPerformed
        // TODO add your handling code here:
        int alterarItem = JOptionPane.showConfirmDialog(null, "Alterar item?","CONFIRMAR",JOptionPane.YES_NO_OPTION);
        
        if (alterarItem == 0) {
            boolean medCadastrado = false;
        
            if (TabMedVend.getSelectedRow() != -1) {
                for (int i = 0; i < TabMedVend.getRowCount(); i++) {
                    int codmed = medList.get(MedComboBox.getSelectedIndex()).getCodmedicamento();
                    int codMedAdd = Integer.parseInt(String.valueOf(TabMedVend.getValueAt(i, 4)));
                    int codMedSel = Integer.parseInt(String.valueOf(TabMedVend.getValueAt(TabMedVend.getSelectedRow(), 4)));

                    if (codmed == codMedAdd) {
                        medCadastrado = true;
                        if (codmed == codMedSel) {
                            medCadastrado = false;
                        }
                    }
                }
            }

            String botaoPress = botaoCadastrarVenda.getText();

            if (medCadastrado) {
                JOptionPane.showMessageDialog(null, "Medicamento já cadastrado!");
            } else {
                attItens(botaoPress);
                calcularTotal();
            }
        } else if (alterarItem == 1) {
            ocultar();
        }
        
    }//GEN-LAST:event_botaoAltActionPerformed

    private void botaoCadastrarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarVendaActionPerformed
        // TODO add your handling code here:
        String botaoPress = botaoCadastrarVenda.getText();
        
        if (botaoPress.equals(" Finalizar Venda")) {
            List<MedVendidos> medVendidos = new ArrayList<>();
            MedVendidos medVend = new MedVendidos();
            
            for (int i = 0; i < TabMedVend.getRowCount(); i++) {
                medVendidos.add(i, addItensTab(i));
            }
            
            v.setValorpedidovenda(Double.valueOf(caixaInsValorTotal.getText()));
            
            int cadastro = vendDao.criar(v);
            
            if (cadastro != 0) {
                if (vendDao.addItensVend(v, medVendidos)) {
                    
                    this.dispose();
                    
                }
            } else {
                vendDao.deletar(v);
            }
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_botaoCadastrarVendaActionPerformed

    private void MedComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedComboBoxActionPerformed
        // TODO add your handling code here:
        if (MedComboBox.getSelectedIndex() != -1) {
            caixaInsValorUnMed.setText(String.valueOf(medList.get(MedComboBox.getSelectedIndex()).getValorvenda()));
        }
    }//GEN-LAST:event_MedComboBoxActionPerformed

    private void TabMedVendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabMedVendMouseClicked
        // TODO add your handling code here:
        
        if (TabMedVend.getSelectedRow() != -1 && TabMedVend.getSelectedRow() != clique) {
            clique = TabMedVend.getSelectedRow();
            MedVendidos medVend = model.pegaDadosLinha(TabMedVend.getSelectedRow());
        
            caixaInsValorUnMed.setText(String.valueOf(medVend.getValorUnMed()));
            caixaInsValVend.setText(String.valueOf(medVend.getValorvenda()));
            caixaInsQntdMed.setText(String.valueOf(medVend.getQuantidademed()));

            for (int i = 0; i < medList.size(); i++) {
                if (medList.get(i).getCodmedicamento()== medVend.getCodmedicamento()) {
                    MedComboBox.setSelectedIndex(i);
                }
            }
        } else {
            ocultar();
        }
    }//GEN-LAST:event_TabMedVendMouseClicked

    public void formatar(){
        JTableHeader tituloTabela = TabMedVend.getTableHeader();
        tituloTabela.setFont(new Font("century gothic", Font.BOLD, 12));
        
        DefaultTableCellRenderer centralizar = (DefaultTableCellRenderer)
        tituloTabela.getDefaultRenderer();
        
        centralizar.setHorizontalAlignment(JLabel.CENTER);
    }
    
    public void ocultar(){
        clique = -1;
        TabMedVend.clearSelection();
    }
    
    private void botaoVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoVoltarMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botaoVoltarMouseClicked

    private void botaoVoltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoVoltarMouseEntered
        // TODO add your handling code here:
        this.setCursor(Cursor.HAND_CURSOR);
        botaoVoltar.setToolTipText("Voltar");
    }//GEN-LAST:event_botaoVoltarMouseEntered

    private void botaoVoltarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoVoltarMouseExited
        // TODO add your handling code here:
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_botaoVoltarMouseExited
    
    public MedVendidos addItensTab(int i){
        MedVendidos medVend = new MedVendidos();
        
        medVend.setDatavenda(converterData(String.valueOf(TabMedVend.getValueAt(i, 0))));
        medVend.setValorUnMed(Double.parseDouble(String.valueOf(TabMedVend.getValueAt(i, 1))));
        medVend.setValorvenda(Double.parseDouble(String.valueOf(TabMedVend.getValueAt(i, 2))));
        medVend.setQuantidademed(Integer.parseInt(String.valueOf(TabMedVend.getValueAt(i, 3))));
        medVend.setCodmedicamento(Integer.parseInt(String.valueOf(TabMedVend.getValueAt(i, 4))));
        
        return medVend;
    }
    
    public void attItens(String botaoPress){
        
        if (TabMedVend.getSelectedRow() != -1) {
            if (botaoPress.equals(" Finalizar Venda")) {
            model.setValueAt(caixaInsValorUnMed.getText(), TabMedVend.getSelectedRow(), 1);
            model.setValueAt(caixaInsValVend.getText(), TabMedVend.getSelectedRow(), 2);
            model.setValueAt(caixaInsQntdMed.getText(), TabMedVend.getSelectedRow(), 3);
            model.setValueAt(String.valueOf(medList.get(MedComboBox.getSelectedIndex()).getCodmedicamento()), TabMedVend.getSelectedRow(), 4);
            } else {

                int codMedTab = Integer.parseInt(String.valueOf(TabMedVend.getValueAt(TabMedVend.getSelectedRow(), 4)));
                int codMedAtt = medList.get(MedComboBox.getSelectedIndex()).getCodmedicamento();

                if(codMedTab == codMedAtt){

                    MedVendidos medVend = new MedVendidos();
                    MedVendidosDAO medVendDao = new MedVendidosDAO();

                    medVend.setValorUnMed(Double.parseDouble(caixaInsValorUnMed.getText()));
                    medVend.setValorvenda(Double.parseDouble(caixaInsValVend.getText()));
                    medVend.setQuantidademed(Integer.parseInt(caixaInsQntdMed.getText()));
                    medVend.setCodmedicamento(medList.get(MedComboBox.getSelectedIndex()).getCodmedicamento());

                    boolean cadastro = calcularDiferença(medVend);

                    if (cadastro) {
                        cadastro = medVendDao.atualizar(medVend, v);
                        model.recarregaTabelaPesq(String.valueOf(v.getCodpedido()));

                        if (cadastro) {
                            double valorTotal = calcularTotal();
                            v.setValorpedidovenda(valorTotal);

                            vendDao.atualizarValor(v);
                        }
                    } 
                } else if (codMedTab != codMedAtt){

                    MedVendidos medVend = new MedVendidos();
                    MedVendidos medVendAnt = new MedVendidos();
                    MedVendidosDAO medVendDao = new MedVendidosDAO();

                    medVend.setDatavenda(caixaInsData.getText());
                    medVend.setValorUnMed(Double.parseDouble(caixaInsValorUnMed.getText()));
                    medVend.setValorvenda(Double.parseDouble(caixaInsValVend.getText()));
                    medVend.setQuantidademed(Integer.parseInt(caixaInsQntdMed.getText()));
                    medVend.setCodmedicamento(medList.get(MedComboBox.getSelectedIndex()).getCodmedicamento());

                    medVendAnt.setCodmedicamento(codMedTab);
                    boolean cadastro = medVendDao.remover(medVendAnt, v);

                    if (cadastro) {
                        cadastro = medVendDao.criar(medVend, v);
                        model.recarregaTabelaPesq(String.valueOf(v.getCodpedido())); 

                        if (cadastro) {
                            double valorTotal = calcularTotal();
                            v.setValorpedidovenda(valorTotal);

                            vendDao.atualizarValor(v);             
                        }
                    }
                }
            }
        }
    }
    
    public boolean calcularDiferença(MedVendidos medVend){
        
        boolean cadastro = false;
        
        if (TabMedVend.getSelectedRow() != -1) {
            
            MedicamentoDAO medDao = new MedicamentoDAO();
            MedVendidosDAO medVendDao = new MedVendidosDAO();
            
            int antAtt = Integer.parseInt(String.valueOf(TabMedVend.getValueAt(TabMedVend.getSelectedRow(), 3)));
            int depAtt = medVend.getQuantidademed();
            int estMed = medDao.pesquisarCod(String.valueOf(medVend.getCodmedicamento())).get(0).getQuantidadeestoque();
            
            if (depAtt > antAtt) {
                int dif = (depAtt - antAtt);
                if (dif <= estMed) {
                    cadastro = medVendDao.removerEstoque(medVend, dif);
                } else {
                    JOptionPane.showMessageDialog(null, "Estoque insuficiente!");
                }
            } else if (depAtt < antAtt) {
                    int dif = (antAtt - depAtt);
                    cadastro = medVendDao.adicionarEstoque(medVend, dif);
                } else {
                    cadastro = true;
                } 
        }
        return cadastro;
    }
    
    public void addItens(String botaoPress){
        MedVendidos vend = new MedVendidos();
        MedVendidosDAO medVendDao = new MedVendidosDAO();
        
        vend.setDatavenda(converterData(caixaInsData.getText()));
        vend.setValorUnMed(Double.parseDouble(caixaInsValorUnMed.getText()));
        vend.setValorvenda(Double.parseDouble(caixaInsValVend.getText()));
        vend.setQuantidademed(Integer.parseInt(caixaInsQntdMed.getText()));
        vend.setCodmedicamento(medList.get(MedComboBox.getSelectedIndex()).getCodmedicamento());
        
        if (botaoPress.equals(" Finalizar Venda")) {
            model.addLinha(vend);
            calcularTotal();
        } else {
            
            boolean cadastro = medVendDao.criar(vend, v);
            model.recarregaTabelaPesq(String.valueOf(v.getCodpedido()));
            
            if (cadastro) {
                
                double valorTotal = calcularTotal();
                v.setValorpedidovenda(valorTotal);
                
                vendDao.atualizarValor(v);
            }
        }
    }
    
    public double calcularTotal(){
        
        List<MedVendidos> medVendidos = new ArrayList<>();
        MedVendidos medVend = new MedVendidos();
        double valor = 0.0;
        double valorTotal = 0.0;
        
        for (int i = 0; i < TabMedVend.getRowCount() ; i++) {
            medVend.setDatavenda(String.valueOf(TabMedVend.getValueAt(i, 0)));
            medVend.setValorUnMed(Double.parseDouble(String.valueOf(TabMedVend.getValueAt(i, 1))));
            medVend.setValorvenda(Double.parseDouble(String.valueOf(TabMedVend.getValueAt(i, 2))));
            medVend.setQuantidademed(Integer.parseInt(String.valueOf(TabMedVend.getValueAt(i, 3))));
            medVend.setCodmedicamento(Integer.parseInt(String.valueOf(TabMedVend.getValueAt(i, 4))));
            medVendidos.add(medVend);
            
            valor = medVendidos.get(i).getValorvenda();
            valorTotal = (valorTotal + valor);
        }
        
        if (valorTotal != 0) {
            caixaValorTotal.setVisible(true);
            caixaInsValorTotal.setVisible(true);
            caixaInsValorTotal.setText(String.valueOf(valorTotal));
        } else {
            caixaValorTotal.setVisible(false);
            caixaInsValorTotal.setVisible(false);
        }
        
        
        return valorTotal;
    }
    
    public String converterData(String dataDigitada){
            String dataConvertida = null;
        try {
            SimpleDateFormat in = new SimpleDateFormat("dd/MM/yyyy");
            Date data = in.parse(dataDigitada);
            dataConvertida = String.valueOf(new java.sql.Date(data.getTime()));
        } catch (java.text.ParseException ex) {
            Logger.getLogger(JanelaDrogaria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataConvertida;
    }
    
    public String desconverterData(String dataDigitada){
        String dataFormatada = null;
        
        SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoDesejado = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            Date dataBanco = new Date(formatoBanco.parse(dataDigitada).getTime());
            dataFormatada = formatoDesejado.format(dataBanco);
        } catch (ParseException e) {
        }
        return dataFormatada;
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
            java.util.logging.Logger.getLogger(JanelaMedVendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaMedVendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaMedVendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaMedVendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaMedVendidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> MedComboBox;
    private javax.swing.JTable TabMedVend;
    private javax.swing.JButton botaoAdd;
    private javax.swing.JButton botaoAlt;
    private javax.swing.JButton botaoCadastrarVenda;
    private javax.swing.JButton botaoDel;
    private javax.swing.JLabel botaoVoltar;
    private javax.swing.JLabel caixaData;
    private javax.swing.JLabel caixaInsData;
    private javax.swing.JTextField caixaInsQntdMed;
    private javax.swing.JTextField caixaInsValVend;
    private javax.swing.JLabel caixaInsValorTotal;
    private javax.swing.JTextField caixaInsValorUnMed;
    private javax.swing.JLabel caixaQntdMed;
    private javax.swing.JLabel caixaTitulo;
    private javax.swing.JLabel caixaValVend;
    private javax.swing.JLabel caixaValorTotal;
    private javax.swing.JLabel caixaValorUnMed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
