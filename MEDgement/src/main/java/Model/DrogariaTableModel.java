/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Objetos.Drogaria;
import java.util.ArrayList;
import DAO.DrogariaDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author miche
 */
public class DrogariaTableModel extends AbstractTableModel {
    
    private List<Drogaria> dados = new ArrayList<>();
    private String[] colunas = {"COD", "SIT", "CNPJ", "NOME"}; // "COD", "SIT", "CNPJ", "NOME", "RUA", "N°", "COMP", "BAIRRO", "CIDADE", "UF", "CEP"
    
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
            case 0:{
                return dados.get(linha).getCoddrogaria();
            }
            case 1:{
                String situacao = null;
                if (dados.get(linha).getSituacaodrogaria() == 1) {
                    situacao = "Ativo";
                } else {
                    situacao = "Inativo";
                }
                return situacao;
            }
            case 2:{
                return dados.get(linha).getCnpjdrogaria();
            }
            case 3:{
                return dados.get(linha).getNomedrogaria();
            }
//            case 4:{
//                return dados.get(linha).getBairrodrogaria();
//            }
//            case 5:{
//                return dados.get(linha).getCidadedrogaria();
//            }
//            case 6:{
//                return dados.get(linha).getEstadodrogaria();
//            }
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        switch (coluna) {
            case 0:{
                dados.get(linha).setCoddrogaria(Integer.parseInt((String) valor));
                break;
            }
            case 1:{
                dados.get(linha).setSituacaodrogaria(Integer.parseInt((String) valor));
                break;
            }
            case 2:{
                dados.get(linha).setCnpjdrogaria((String) valor);
                break;
            }
            case 3:{
                dados.get(linha).setNomedrogaria((String) valor);
                break;
            }
            case 4:{
                dados.get(linha).setRuadrogaria((String)valor);
                break;
            }
            case 5:{
                dados.get(linha).setNumerodrogaria((String) valor);
                break;
            }
            case 6:{
                dados.get(linha).setComplementodrogaria((String) valor);
                break;        
            }
            case 7:{
                dados.get(linha).setBairrodrogaria((String) valor);
                break;   
            }
            case 8:{
                dados.get(linha).setCidadedrogaria((String)valor);
                break;   
            }
            case 9:{
                dados.get(linha).setEstadodrogaria((String)valor);
                break;   
            }
            case 10:{
                dados.get(linha).setCepdrogaria((String)valor);
                break;   
            }
        }
    }
    
    public void addLinha(Drogaria d) {
        this.dados.add(d);
        this.fireTableDataChanged();
    }
    
    public void removeLinha(int linha) {
        this.dados.remove(linha);
        this.fireTableDataChanged();
    }
    
    public Drogaria pegaDadosLinha(int linha){
        return dados.get(linha);
    }
    
    public void lerDados(){
        DrogariaDAO ddao = new DrogariaDAO();

        try {
            for (Drogaria d : ddao.read()) {
            this.addLinha(d);
            }
            this.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados (65460451): " + e);
        }
    }
    
    public void recarregaTabela(){
        this.dados.clear();
        lerDados();
        this.fireTableDataChanged();
    }
    
    public void lerDadosPesq(String pesq){
        DrogariaDAO ddao = new DrogariaDAO();

        try {
            for (Drogaria d : ddao.pesquisarCod(pesq)) {
                this.addLinha(d);
            }
            for (Drogaria d : ddao.pesquisarNome(pesq)) {
                this.addLinha(d);
            }
            this.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados (65460451): " + e);
        }
    }
    
    public void recarregaTabelaPesq(String pesq){
        this.dados.clear();
        lerDadosPesq(pesq);
        this.fireTableDataChanged();
    }
    
}
