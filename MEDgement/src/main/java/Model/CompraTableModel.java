/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import Objetos.Compra;
import DAO.CompraDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author michel.matos
 */
public class CompraTableModel extends AbstractTableModel {
    
    private final List<Compra> dados = new ArrayList<>();
    private final String[] colunas = {"COD","DATA COMPRA","NF","VALOR NF"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0 -> {
                return dados.get(linha).getCodCompra();
            }
            case 1 -> {
                
                String dataDigitada = dados.get(linha).getDataCompra();
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
//            case 2 -> {
//                return dados.get(linha).getDataEntregaCompra();
//            }
            case 2 -> {
                return dados.get(linha).getNumeroNFCompra();
            }
            case 3 -> {
                return dados.get(linha).getValorNFCompra();
            }
//            case 5 -> {
//                return dados.get(linha).getFormaPagamentoCompra();
//            }
//            case 6 -> {
//                return dados.get(linha).getCodFornecedor();
//            }
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        switch (coluna) {
            case 0 -> {
                dados.get(linha).setCodCompra(Integer.parseInt((String) valor));
            }
            case 1 -> {
                dados.get(linha).setDataCompra(((String) valor));
            }
            case 2 -> {
                dados.get(linha).setDataEntregaCompra((String) valor);
            }
            case 3 -> {
                dados.get(linha).setNumeroNFCompra(Integer.parseInt((String) valor));
            }
            case 4 -> {
                dados.get(linha).setValorNFCompra(Double.parseDouble((String)valor));
            }
            case 5 -> {
                dados.get(linha).setFormaPagamentoCompra((String) valor);
            }
            case 6 -> {
                dados.get(linha).setCodFornecedor(Integer.parseInt((String) valor));
            }
        }
    }
    
    public void addLinha(Compra comp) {
        this.dados.add(comp);
        this.fireTableDataChanged();
    }
    
    public void removeLinha(int linha) {
        this.dados.remove(linha);
        this.fireTableDataChanged();
    }
    
    public Compra pegaDadosLinha(int linha){
        return dados.get(linha);
    }
    
    public void lerDados(){
        CompraDAO compdao = new CompraDAO();

        try {
            for (Compra comp : compdao.read()) {
            this.addLinha(comp);
            }
            this.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados (95406093): " + e);
        }
    }
    
    public void recarregaTabela(){
        this.dados.clear();
        lerDados();
        this.fireTableDataChanged();
    }
    
    public void lerDadosPesq(String pesq){
        CompraDAO compdao = new CompraDAO();

        try {
            for (Compra comp : compdao.pesquisar(pesq)) {
            this.addLinha(comp);
            }
            for (Compra comp : compdao.pesquisarNF(pesq)) {
            this.addLinha(comp);
            }
            this.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados (95406093): " + e);
        }
    }
    
    public void recarregaTabelaPesq(String pesq){
        this.dados.clear();
        lerDadosPesq(pesq);
        this.fireTableDataChanged();
    }
}
