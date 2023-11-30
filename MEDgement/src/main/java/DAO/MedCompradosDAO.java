/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.ConectarBd;
import Objetos.Compra;
import Objetos.MedComprados;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MedCompradosDAO {
    
    public boolean criar(MedComprados medComp, Compra comp){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        boolean cadastro = false;
        
        MedicamentoDAO medDao = new MedicamentoDAO();
        
        try {
            stmt = c.prepareStatement("INSERT INTO med_comprados VALUES (?,?,?,?,?,?)");
            stmt.setString(1, medComp.getDatacompra());
            stmt.setDouble(2, medComp.getValorUnMed());
            stmt.setDouble(3, medComp.getValorComp());
            stmt.setInt(4, medComp.getQuantidademed());
            stmt.setInt(5, medComp.getCodmedicamento());
            stmt.setInt(6, comp.getCodCompra());
            
            stmt.execute();
            
            cadastro = true;
            
            medDao.adicionarDataComp(medComp.getCodmedicamento());
            
            JOptionPane.showMessageDialog(null, "Cadastro de medicamento efetuado com sucesso!");
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em cadastrar medicamento: " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
        return cadastro;
    }
    
    public boolean remover(MedComprados medComp, Compra comp){        
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        MedicamentoDAO medDao = new MedicamentoDAO();
        boolean cadastro = false;
        
        try {
            stmt = c.prepareStatement("DELETE FROM med_comprados WHERE codmedicamento = ? AND codcompra = ?");
            stmt.setInt(1, medComp.getCodmedicamento());
            stmt.setInt(2, comp.getCodCompra());
            stmt.execute();
            
            medDao.adicionarDataComp(medComp.getCodmedicamento());
            cadastro = true;
            JOptionPane.showMessageDialog(null, "Compra removida com sucesso!");
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em remover compra(9295558445): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
        return cadastro;
    }
    
    public boolean adicionarEstoque(MedComprados medComp, int qntMed){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        boolean cadastro = false;
        
        try {
            stmt = c.prepareCall("UPDATE medicamento SET "
                    + "quantidadeestoque = (quantidadeestoque + ?) "
                    + "WHERE codmedicamento = ?");
            
            stmt.setInt(1, qntMed);
            stmt.setInt(2, medComp.getCodmedicamento());
            
            stmt.execute();
            
            cadastro = true;
            
            JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em atualizar estoque (806454): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
        return cadastro;
    }
    
    public boolean removerEstoque(MedComprados medComp, int qntMed){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        boolean cadastro = false;
        
        try {
            stmt = c.prepareCall("UPDATE medicamento SET "
                    + "quantidadeestoque = (quantidadeestoque - ?) "
                    + "WHERE codmedicamento = ?");
            
            stmt.setInt(1, qntMed);
            stmt.setInt(2, medComp.getCodmedicamento());
            
            stmt.execute();
            
            cadastro = true;
            
            JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em atualizar estoque (806454): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
        return cadastro;
    }
    
    public boolean atualizar(MedComprados medComp, Compra comp){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        boolean cadastro = false;
        MedicamentoDAO medDao = new MedicamentoDAO();
        
        try {
            stmt = c.prepareStatement("UPDATE med_comprados SET "
                    + "valorUnMed = ?,"
                    + "valorComp = ?,"
                    + "quantidademed = ?"
                    + " WHERE codmedicamento = ? AND codcompra = ?");
            
            stmt.setDouble(1, medComp.getValorUnMed());
            stmt.setDouble(2, medComp.getValorComp());
            stmt.setInt(3, medComp.getQuantidademed());
            stmt.setInt(4, medComp.getCodmedicamento());
            stmt.setInt(5, comp.getCodCompra());
            
            stmt.execute();
            medDao.adicionarDataComp(medComp.getCodmedicamento());
            cadastro = true;
            
            JOptionPane.showMessageDialog(null, "Compra atualizada com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em atualizar compra (9295558445): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
        return cadastro;
    }
    
    public List<MedComprados> consultaMedComprados(int codCompra){
        
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null; 
        ResultSet rs = null;
        
        List<MedComprados> medicamentos = new ArrayList();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM med_comprados WHERE codcompra = "+codCompra+";");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                MedComprados medComp = new MedComprados();
                
                medComp.setCodmedicamento(rs.getInt("codmedicamento"));
                medicamentos.add(medComp);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a operação: 46366654987");
        } finally{
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return medicamentos;
    }
}
