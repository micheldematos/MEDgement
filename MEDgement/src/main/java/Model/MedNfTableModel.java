/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.CompraDAO;
import DAO.MedicamentoDAO;
import DAO.VendaDAO;
import Objetos.MedComprados;
import Objetos.MedVendidos;
import Objetos.Medicamento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author miche
 */
public class MedNfTableModel  extends AbstractTableModel {

//    public MedNfTableModel() {
//    }
    
    private List<MedVendidos> dados = new ArrayList<>();
    private String [] colunas = {"MEDICAMENTO", "CÓDIGO MEDICAMENTO", "DATA VENDA", "VALOR UN", "QUANTIDADE", "VALOR TOTAL"};
    
    MedicamentoDAO medDao = new MedicamentoDAO();

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
                List<Medicamento> medicamento =  medDao.pesquisarCod(String.valueOf(dados.get(linha).getCodmedicamento()));
                return medicamento.get(0).getNomemedicamento();
            }
            case 1:{
                return dados.get(linha).getCodmedicamento();
            }
            case 2:{
                return dados.get(linha).getDatavenda();
            }
            case 3:{
                return dados.get(linha).getValorUnMed();
            }
            case 4:{
                return dados.get(linha).getQuantidademed();
            }
            case 5:{
                return dados.get(linha).getValorvenda();
            }
        }
        return null;
    }
    
    public void teste(int linha){
        System.out.println(dados.get(linha).getCodmedicamento());
//        List<Medicamento> medicamento =  medDao.pesquisarCod(String.valueOf(dados.get(linha).getCodmedicamento()));
//        return medicamento.get(linha).getNomemedicamento();
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        switch (coluna) {
            case 0:{
                dados.get(linha).setDatavenda((String) valor);
                break;
            }
            case 1:{
                dados.get(linha).setValorUnMed(Double.parseDouble((String) valor));
                break;
            }
            case 2:{
                dados.get(linha).setValorvenda(Double.parseDouble((String)valor));
                break;
            }
            case 3:{
                dados.get(linha).setQuantidademed(Integer.parseInt((String)valor));
                break;
            }
            case 4:{
                dados.get(linha).setCodmedicamento(Integer.parseInt((String)valor));
                break;
            }
            case 5:{
                dados.get(linha).setCodmedicamento(Integer.parseInt((String)valor));
                break;
            }
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    
    public void addLinha (MedVendidos medVend){
        this.dados.add(medVend);
        this.fireTableDataChanged();
    }
    
    public void removeLinha (int linha){
        this.dados.remove(linha);
        this.fireTableDataChanged();
    }
    
    public MedVendidos pegaDadosLinha(int linha){
        return dados.get(linha);
    }
    
    public void lerDadosPesq(String pesq){
        VendaDAO vendDao = new VendaDAO();

        try {
            for (MedVendidos medVend : vendDao.pesqItens(pesq)) {
            this.addLinha(medVend);
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
    

    

