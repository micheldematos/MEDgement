/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.UsuarioDAO;
import Objetos.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author miche
 */
public class UsuarioTableModel extends AbstractTableModel {

    private List<Usuario> dados = new ArrayList<>();
    private String[] colunas = {"CÓDIGO","NOME","CPF","SITUAÇÃO"};
    
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
                return dados.get(linha).getCodusuario();
            }
//            case 1:{
//                return dados.get(linha).getSenhausuario();
//            }
            case 1:{
                return dados.get(linha).getNomecompleto();
            }
            case 2:{
                return dados.get(linha).getCpf();
            }
//            case 4:{
//                return dados.get(linha).getTipousuario();
//            }
            case 3:{
                String situacao = null;
                if (dados.get(linha).getSituacaousuario() == 1) {
                    situacao = "Ativo";
                } else {
                    situacao = "Inativo";
                }
                return situacao;
            }
//            case 6:{
//                return dados.get(linha).getCargo();
//            }
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        switch (coluna) {
            case 0:{
                dados.get(linha).setCodusuario(Integer.parseInt((String) valor));
                break;
            }
            case 1:{
                dados.get(linha).setSenhausuario((String) valor);
                break;
            }
            case 2:{
                dados.get(linha).setNomecompleto((String)valor);
                break;
            }
            case 3:{
                dados.get(linha).setCpf((String)valor);
                break;
            }
            case 4:{
                dados.get(linha).setTipousuario(Integer.parseInt((String) valor));
                break;
            }
            case 5:{
                dados.get(linha).setSituacaousuario(Integer.parseInt((String) valor));
                break;
            }
            case 6:{
                dados.get(linha).setCargo((String)valor);
                break;        
            }
        }
    }
    
    public void addLinha(Usuario u) {
        this.dados.add(u);
        this.fireTableDataChanged();
    }
    
    public void removeLinha(int linha) {
        this.dados.remove(linha);
        this.fireTableDataChanged();
    }
    
    public Usuario pegaDadosLinha(int linha){
        return dados.get(linha);
    }
    
    public void lerDados(){
        UsuarioDAO udao = new UsuarioDAO();

        try {
            for (Usuario u : udao.read()) {
            this.addLinha(u);
            }
            this.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados (6877962): " + e);
        }
    }
    
    public void recarregaTabela(){
        this.dados.clear();
        lerDados();
        this.fireTableDataChanged();
    }
    
    public void lerDadosPesq(String pesq){
        UsuarioDAO udao = new UsuarioDAO();

        try {
            for (Usuario u : udao.pesquisarCod(pesq)) {
            this.addLinha(u);
            }
            for (Usuario u : udao.pesquisarNome(pesq)) {
            this.addLinha(u);
            }
            this.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados (6877962): " + e);
        }
    }
    
    public void recarregaTabelaPesq(String pesq){
        this.dados.clear();
        lerDadosPesq(pesq);
        this.fireTableDataChanged();
    }
}
