/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.VendaDAO;
import Objetos.Venda;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author michel.matos
 */
public class VendTableModel extends AbstractTableModel {
    
    private List<Venda> dados = new ArrayList<>();
    private String[] colunas = {"CÓDIGO","DATA DA VENDA","FORMA DE PAGAMENTO","VALOR TOTAL","DROGARIA","NOTA FISCAL"};
    
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
                return dados.get(linha).getCodpedido();
            }
            case 1:{
                String dataDigitada = dados.get(linha).getDatavenda();
                String dataFormatada = null;
                
                SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat formatoDesejado = new SimpleDateFormat("dd/MM/yyyy");
                
                try {
                    Date dataBanco = new Date (formatoBanco.parse(dataDigitada).getTime());
                    dataFormatada = formatoDesejado.format(dataBanco);
                } catch (ParseException e) {
                }
                
                return dataFormatada;
            }
            case 2:{
                return dados.get(linha).getFormapagamentovenda();
            }
            case 3:{
                return dados.get(linha).getValorpedidovenda();
            }
            case 4:{
                return dados.get(linha).getCoddrogaria();
            }
            case 5:{
                if (dados.get(linha).getEmissaoNf() == 0) {
                    return "Sem emissão";
                } else {
                    return dados.get(linha).getEmissaoNf();
                }
            }
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        switch (coluna) {
            case 0:{
                dados.get(linha).setCodpedido(Integer.parseInt((String) valor));
                break;
            }
            case 1:{
                dados.get(linha).setDatavenda(((String) valor));
                break;
            }
            case 2:{
                dados.get(linha).setFormapagamentovenda((String) valor);
                break;
            }
            case 3:{
                dados.get(linha).setValorpedidovenda(Double.valueOf((String)valor));
                break;
            }
            case 4:{
                dados.get(linha).setCoddrogaria(Integer.parseInt((String)valor));
                break;        
            }
            case 5:{
                dados.get(linha).setEmissaoNf(Integer.parseInt((String)valor));
                break;        
            }
        }
    }
    
    public void addLinha(Venda v) {
        this.dados.add(v);
        this.fireTableDataChanged();
    }
    
    public void removeLinha(int linha) {
        this.dados.remove(linha);
        this.fireTableDataChanged();
    }
    
    public Venda pegaDadosLinha(int linha){
        return dados.get(linha);
    }
    
    public void lerDados(){
        VendaDAO dao = new VendaDAO();

        try {
            for (Venda v : dao.read()) {
            this.addLinha(v);
            }
            this.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados (646774651): " + e);
        }
    }
    
    public void recarregaTabela(){
        this.dados.clear();
        lerDados();
        this.fireTableDataChanged();
    }
    
    public void lerDadosPesq(String pesq){
        VendaDAO compdao = new VendaDAO();

        try {
            for (Venda v : compdao.pesquisar(pesq)) {
            this.addLinha(v);
            }
            this.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados (646774651): " + e);
        }
    }
    
    public void recarregaTabelaPesq(String pesq){
        this.dados.clear();
        lerDadosPesq(pesq);
        this.fireTableDataChanged();
    }
}
