/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.ConectarBd;
import java.sql.Connection;
import Objetos.Medicamento;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author michel.matos
 */
public class MedicamentoDAO {
    
    
    public List<Medicamento> read(){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Medicamento> medicamentos = new ArrayList<>();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM medicamento ORDER BY situacaomed DESC");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Medicamento med = new Medicamento();
                med.setCodmedicamento(Integer.parseInt(rs.getString("codmedicamento")));
                med.setNomemedicamento(rs.getString("nomemedicamento"));
                med.setDescricaomedicamento(rs.getString("descricaomedicamento"));
                med.setDataultimacompra(rs.getString("dataultimacompra"));
                med.setValorcusto(Double.parseDouble(rs.getString("valorcusto")));
                med.setValorvenda(Double.parseDouble(rs.getString("valorvenda")));
                med.setSituacaomed(Integer.parseInt(rs.getString("situacaomed")));
                med.setQuantidadeestoque(Integer.parseInt(rs.getString("quantidadeestoque")));
                med.setCodfornecedor(Integer.parseInt(rs.getString("codfornecedor")));
                medicamentos.add(med);
            }
            
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        } finally{
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return medicamentos;
    }
            
    public List<Medicamento> pesquisar(String pesq){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Medicamento> medicamentos = new ArrayList<>();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM medicamento WHERE nomemedicamento LIKE '%"+pesq+"%';");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Medicamento med = new Medicamento();
                med.setCodmedicamento(Integer.parseInt(rs.getString("codmedicamento")));
                med.setNomemedicamento(rs.getString("nomemedicamento"));
                med.setDescricaomedicamento(rs.getString("descricaomedicamento"));
                med.setDataultimacompra(rs.getString("dataultimacompra"));
                med.setValorcusto(Double.parseDouble(rs.getString("valorcusto")));
                med.setValorvenda(Double.parseDouble(rs.getString("valorvenda")));
                med.setSituacaomed(Integer.parseInt(rs.getString("situacaomed")));
                med.setQuantidadeestoque(Integer.parseInt(rs.getString("quantidadeestoque")));
                med.setCodfornecedor(Integer.parseInt(rs.getString("codfornecedor")));
                medicamentos.add(med);
            }
            
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        } finally{
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return medicamentos;
    }
    
    public List<Medicamento> pesquisarCod(String pesq){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Medicamento> medicamentos = new ArrayList<>();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM medicamento WHERE codmedicamento LIKE "+pesq+";");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Medicamento med = new Medicamento();
                med.setCodmedicamento(Integer.parseInt(rs.getString("codmedicamento")));
                med.setNomemedicamento(rs.getString("nomemedicamento"));
                med.setDescricaomedicamento(rs.getString("descricaomedicamento"));
                med.setDataultimacompra(rs.getString("dataultimacompra"));
                med.setValorcusto(Double.parseDouble(rs.getString("valorcusto")));
                med.setValorvenda(Double.parseDouble(rs.getString("valorvenda")));
                med.setSituacaomed(Integer.parseInt(rs.getString("situacaomed")));
                med.setQuantidadeestoque(Integer.parseInt(rs.getString("quantidadeestoque")));
                med.setCodfornecedor(Integer.parseInt(rs.getString("codfornecedor")));
                medicamentos.add(med);
            }
            
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        } finally{
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return medicamentos;
    }
    
    public void criar(Medicamento med){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("INSERT INTO medicamento VALUES (null,?,?,?,?,?,?,?,?)");
            stmt.setString(1, med.getNomemedicamento());
            stmt.setString(2, med.getDescricaomedicamento());
            stmt.setString(3, med.getDataultimacompra());
            stmt.setDouble(4, med.getValorcusto());
            stmt.setDouble(5, med.getValorvenda());
            stmt.setDouble(6, med.getSituacaomed());
            stmt.setInt(7, med.getQuantidadeestoque());
            stmt.setInt(8, med.getCodfornecedor());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastro de medicamento efetuado com sucesso!");
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em cadastrar medicamento: " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public void atualizar(Medicamento med){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("UPDATE medicamento SET "
                    + "nomemedicamento = ?,"
                    + "descricaomedicamento = ?,"
                    + "valorvenda = ?,"
                    + "codfornecedor = ? "
                    + "WHERE codmedicamento = ?");
            stmt.setString(1, med.getNomemedicamento());
            stmt.setString(2, med.getDescricaomedicamento());
            stmt.setDouble(3, med.getValorvenda());
            stmt.setInt(4, med.getCodfornecedor());
            stmt.setInt(5, med.getCodmedicamento());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Atualização de medicamento efetuado com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em atualizar medicamento: " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public double consultarPreco (double codMed){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        double valor = 0;
        
        try {
            stmt = c.prepareStatement("SELECT * FROM medicamento WHERE codmedicamento = ?");
            stmt.setDouble(1, codMed);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                valor = Double.parseDouble(rs.getString("valorvenda"));
            }
            
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em obter valor: " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return valor;
    }
    
    public void ativar(Medicamento med){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("CALL sp_ativarmedicamento (?)");
            stmt.setInt(1, med.getCodmedicamento());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Medicamento ativado com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em ativar medicamento (6695549770): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public void inativar(Medicamento med){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("CALL sp_inativarmedicamento (?)");
            stmt.setInt(1, med.getCodmedicamento());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Medicamento ativado com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em ativar medicamento (6695549770): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public String teste (int codMed){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        CompraDAO compDao = new CompraDAO();
        
        String ultimaData = compDao.ultimaData(codMed);
        double ultimoValor = compDao.ultimoValor(codMed);
        
        return ultimaData;
    }
    
    public boolean adicionarDataComp(int codMed){
        MedCompradosDAO medComp = new MedCompradosDAO();
        CompraDAO compDao = new CompraDAO();
        boolean validacao = false;
        
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
            
            try {
                String ultimaData = compDao.ultimaData(codMed);
                double ultimoValor = compDao.ultimoValor(codMed);

                if (null == ultimaData) {
                        ultimaData = null;
                        ultimoValor = 0.00;
                        System.out.println(ultimaData + "  " + ultimoValor + "  " + codMed + " TESTEEEEEEE");
                }
                
                System.out.println("testeeeeeeeeeeeeeeeeeeeeeeeeeeee");
                
                stmt = c.prepareStatement("UPDATE medicamento SET dataultimacompra = ?, valorcusto = ? WHERE codmedicamento = ?;");
                stmt.setString(1, ultimaData);
                stmt.setDouble(2, ultimoValor);
                stmt.setInt(3, codMed);

                System.out.println(stmt + "   ");
                System.out.println(ultimaData + "  " + ultimoValor);

                stmt.execute();
                
            validacao = true;
            JOptionPane.showMessageDialog(null, "Atualização de medicamento efetuado com sucesso!");
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Falha em atualizar medicamento: " + e);
            } finally {
                ConectarBd.closeConnection(c, stmt);
            }
            
            return validacao;
    }
}
