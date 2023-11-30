/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import Objetos.Fornecedor;
import DAO.FornecedorDAO;

/**
 *
 * @author user_acronus
 */
public class FornecedorTableModel extends AbstractTableModel {
    
    private List<Fornecedor> dados = new ArrayList<>();
    private String[] colunas = {"COD FORNECEDOR","SITUAÇÃO","INSCRIÇÃO ESTADUAL","CNPJ","NOME"};

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
            case 0: {
                return dados.get(linha).getCodfornecedor();
            }
            case 1: {
                String situacao = null;
                if (dados.get(linha).getSituacaofornecedor() == 1) {
                    situacao = "Ativo";
                } else {
                    situacao = "Inativo";
                }
                
                return situacao;
            }
            case 2: {
                return dados.get(linha).getInscricaoestadualfornecedor();
            }
            case 3: {
                return dados.get(linha).getCnpjfornecedor();
            }
            case 4: {
                return dados.get(linha).getNomefornecedor();
            }
//            case 5: {
//                return dados.get(linha).getRuafornecedor();
//            }
//            case 6: {
//                return dados.get(linha).getNumerofornecedor();
//            }
//            case 7: {
//                return dados.get(linha).getComplementofornecedor();
//            }
//            case 8: {
//                return dados.get(linha).getBairrofornecedor();
//            }
//            case 9: {
//                return dados.get(linha).getCidadefornecedor();
//            }
//            case 10: {
//                return dados.get(linha).getEstadofornecedor();
//            }
//            case 11: {
//                return dados.get(linha).getCepfornecedor();
//            }
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0: {
                dados.get(linha).setCodfornecedor(Integer.parseInt((String) valor));
                break;
            }
            case 1: {
                dados.get(linha).setSituacaofornecedor(Integer.parseInt((String) valor));
                break;
            }
            case 2: {
                dados.get(linha).setInscricaoestadualfornecedor((String) valor);
                break;
            }
            case 3: {
                dados.get(linha).setCnpjfornecedor(((String) valor));
                break;
            }
            case 4: {
                dados.get(linha).setNomefornecedor(((String) valor));
                break;
            }
            case 5: {
                dados.get(linha).setRuafornecedor(((String) valor));
                break;
            }
            case 6: {
                dados.get(linha).setNumerofornecedor(((String) valor));
                break;
            }
            case 7: {
                dados.get(linha).setComplementofornecedor(((String) valor));
                break;
            }
            case 8: {
                dados.get(linha).setBairrofornecedor(((String) valor));
                break;
            }
            case 9: {
                dados.get(linha).setCidadefornecedor(((String) valor));
                break;
            }
            case 10: {
                dados.get(linha).setEstadofornecedor(((String) valor));
                break;
            }
            case 11: {
                dados.get(linha).setCepfornecedor(((String) valor));
                break;
            }
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    
    public void addLinha(Fornecedor f) {
        this.dados.add(f);
        this.fireTableDataChanged();
    }
    
    public void removeLinha(int linha) {
        this.dados.remove(linha);
        this.fireTableDataChanged();
    }
    
    public Fornecedor pegaDadosLinha(int linha){
        return dados.get(linha);
    }
    
    public void lerDados(){
        FornecedorDAO fdao = new FornecedorDAO();

        for (Fornecedor f : fdao.read()) {
            this.addLinha(f);
        }
        this.fireTableDataChanged();
    }
    
    public void recarregaTabela(){
        this.dados.clear();
        lerDados();
        this.fireTableDataChanged();
    }
    
    public void lerDadosPesq(String pesq){
        FornecedorDAO fdao = new FornecedorDAO();

        for (Fornecedor f : fdao.pesquisarCod(pesq)) {
            this.addLinha(f);
        }
        for (Fornecedor f : fdao.pesquisarNome(pesq)) {
            this.addLinha(f);
        }
        this.fireTableDataChanged();
    }
    
    public void recarregaTabelaPesq(String pesq){
        this.dados.clear();
        lerDadosPesq(pesq);
        this.fireTableDataChanged();
    }
    
}
