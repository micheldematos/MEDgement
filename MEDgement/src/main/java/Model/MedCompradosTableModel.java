/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.CompraDAO;
import Objetos.MedComprados;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user_acronus
 */
public class MedCompradosTableModel extends AbstractTableModel {
    
    private List<MedComprados> dados = new ArrayList<>();
    private String [] colunas = {"DATA COMPRA","VALOR UN","VALOR TOTAL","QUANTIDADE","CÓDIGO MEDICAMENTO"};

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
                //return dados.get(linha).getDatacompra();
                
                String dataDigitada = dados.get(linha).getDatacompra();
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
            case 1:{
                return dados.get(linha).getValorUnMed();
            }
            case 2:{
                return dados.get(linha).getValorComp();
            }
            case 3:{
                return dados.get(linha).getQuantidademed();
            }
            case 4:{
                return dados.get(linha).getCodmedicamento();
            }
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0:{
                dados.get(linha).setDatacompra((String) valor);
                break;
            }
            case 1:{
                dados.get(linha).setValorUnMed(Double.parseDouble((String) valor));
                break;
            }
            case 2:{
                dados.get(linha).setValorComp(Double.parseDouble((String)valor));
                break;
            }
            case 3:{
                dados.get(linha).setQuantidademed(Integer.parseInt((String)valor));
                break;
            }
            case 4:{
                dados.get(linha).setCodmedicamento(Integer.parseInt((String) valor));
                break;
            }
            case 5:{
                dados.get(linha).setCodcompra(Integer.parseInt((String)valor));
                break;
            }
            
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    
    public void addLinha (MedComprados medComp){
        this.dados.add(medComp);
        this.fireTableDataChanged();
    }
    
    public void removeLinha (int linha){
        this.dados.remove(linha);
        this.fireTableDataChanged();
    }
    
    public MedComprados pegaDadosLinha(int linha){
        return dados.get(linha);
    }
    
    public void lerDadosPesq(String pesq){
        CompraDAO compdao = new CompraDAO();

        try {
            for (MedComprados medComp : compdao.pesqItens(pesq)) {
            this.addLinha(medComp);
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
    
    
    
    
    
    
    
    
//    for (int i = 0; i < TAlunos.getRowCount(); i++) {
//            System.out.println(TAlunos.getValueAt(i, 0));
//            System.out.println(TAlunos.getValueAt(i, 1));
//            System.out.println(TAlunos.getValueAt(i, 2));
//    }
    
    
}
