/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.NotaFiscalDAO;
import Objetos.NotaFiscal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author miche
 */
public class NotaFiscalTableModel extends AbstractTableModel {
    
    private List<NotaFiscal> dados = new ArrayList<>();
    private String[] colunas = {"N° NF","DATA DE EMISSÃO","VALOR","CÓDIGO (PEDIDO DE VENDA)"};

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
                return dados.get(linha).getNumeronf();
            }
            case 1: {
                return dados.get(linha).getDataemissaonf();
            }
            case 2: {
                return dados.get(linha).getValornfvenda();
            }
            case 3: {
                return dados.get(linha).getCodpedido();
            }
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0: {
                dados.get(linha).setNumeronf(Integer.parseInt((String) valor));
                break;
            }
            case 1: {
                dados.get(linha).setDataemissaonf((String) valor);
                break;
            }
            case 2: {
                dados.get(linha).setValornfvenda(Double.parseDouble((String) valor));
                break;
            }
            case 3: {
                dados.get(linha).setCodpedido(Integer.parseInt((String) valor));
                break;
            }
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    
    public void addLinha(NotaFiscal nf) {
        this.dados.add(nf);
        this.fireTableDataChanged();
    }
    
    public void removeLinha(int linha) {
        this.dados.remove(linha);
        this.fireTableDataChanged();
    }
    
    public NotaFiscal pegaDadosLinha(int linha){
        return dados.get(linha);
    }
    
    public void lerDados(){
        NotaFiscalDAO nfdao = new NotaFiscalDAO();

        for (NotaFiscal nf : nfdao.read()) {
            this.addLinha(nf);
        }
        this.fireTableDataChanged();
    }
    
    public void recarregaTabela(){
        this.dados.clear();
        lerDados();
        this.fireTableDataChanged();
    }    
}
