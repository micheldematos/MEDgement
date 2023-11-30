/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Objetos.Medicamento;
import java.util.ArrayList;
import DAO.MedicamentoDAO;

/**
 *
 * @author michel.matos
 */
public class MedicamentoTableModel extends AbstractTableModel {
    
    private List<Medicamento> dados = new ArrayList<>();
    
    // ************************************************************************* VALIDADO
    private String[] colunas = {"CÓDIGO", "NOME", "VALOR VENDA", 
        "SITUAÇÃO", "ESTOQUE"};
    
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
    
    
    // ************************************************************************* VALIDADO
    @Override
    public Object getValueAt(int linha, int coluna) {
       switch (coluna) {
            case 0: {
                return dados.get(linha).getCodmedicamento();
            }
            case 1: {
                return dados.get(linha).getNomemedicamento();
            }
//            case 2: {
//                return dados.get(linha).getDescricaomedicamento();
//            }
//            case 3: {
//                if (dados.get(linha).getDataultimacompra() == null) {
//                    String vazio = "Sem compra";
//                    return vazio;
//                } else {
//                    return dados.get(linha).getDataultimacompra();
//                }
//            }
//            case 4: {
//                return dados.get(linha).getValorcusto();
//            }
            case 2: {
                return dados.get(linha).getValorvenda();
            }
            case 3: {
                String situacao = null;
                if (dados.get(linha).getSituacaomed() == 1) {
                    situacao = "Ativo";
                } else {
                    situacao = "Inativo";
                }
                
                return situacao;
            }
            case 4: {
                return dados.get(linha).getQuantidadeestoque();
            }
//            case 8: {
//                return dados.get(linha).getCodfornecedor();
//            }
        }
        return null;
    }
    
    
    // ************************************************************************* VALIDADO
    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0: {
                dados.get(linha).setCodmedicamento(Integer.parseInt((String) valor));
                break;
            }
            case 1: {
                dados.get(linha).setNomemedicamento((String) valor);
                break;
            }
            case 2: {
                dados.get(linha).setDescricaomedicamento((String) valor);
                break;
            }
            case 3: {
                dados.get(linha).setDataultimacompra((String) valor);
                break;
            }
            case 4: {
                dados.get(linha).setValorcusto(Double.parseDouble((String) valor));
                break;
            }
            case 5: {
                dados.get(linha).setValorvenda(Double.parseDouble((String) valor));
                break;
            }
            case 6: {
                dados.get(linha).setSituacaomed(Integer.parseInt((String) valor));
                break;
            }
            case 7: {
                dados.get(linha).setQuantidadeestoque(Integer.parseInt((String) valor));
                break;
            }
            case 8: {
                dados.get(linha).setCodfornecedor(Integer.parseInt((String) valor));
                break;
            }
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    

    public void addLinha(Medicamento med) {
        this.dados.add(med);
        this.fireTableDataChanged();
    }
    
    public void removeLinha(int linha) {
        this.dados.remove(linha);
        this.fireTableDataChanged();
    }
    
    public Medicamento pegaDadosLinha(int linha){
        return dados.get(linha);
    }
    
    public void lerDados(){
        MedicamentoDAO meddao = new MedicamentoDAO();

        for (Medicamento med : meddao.read()) {
            this.addLinha(med);
        }
        this.fireTableDataChanged();
    }
    
    public void recarregaTabela(){
        this.dados.clear();
        lerDados();
        this.fireTableDataChanged();
    }
    
    public void lerDadosPesq(String pesq){
        MedicamentoDAO meddao = new MedicamentoDAO();

        for (Medicamento med : meddao.pesquisar(pesq)) {
            this.addLinha(med);
        }
        for (Medicamento med : meddao.pesquisarCod(pesq)) {
            this.addLinha(med);
        }
        this.fireTableDataChanged();
    }
    
    public void recarregaTabelaPesq(String pesq){
        this.dados.clear();
        lerDadosPesq(pesq);
        this.fireTableDataChanged();
    }
}
