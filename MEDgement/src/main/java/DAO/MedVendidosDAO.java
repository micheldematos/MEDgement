/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.ConectarBd;
import Objetos.MedVendidos;
import Objetos.Venda;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author miche
 */
public class MedVendidosDAO {
    
    public boolean criar(MedVendidos medVend, Venda vend){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        boolean cadastro = false;        
        
        try {
            stmt = c.prepareStatement("INSERT INTO med_vendidos VALUES (?,?,?,?,?,?)");
            stmt.setString(1, medVend.getDatavenda());
            stmt.setDouble(2, medVend.getValorUnMed());
            stmt.setDouble(3, medVend.getValorvenda());
            stmt.setInt(4, medVend.getQuantidademed());
            stmt.setInt(5, medVend.getCodmedicamento());
            stmt.setInt(6, vend.getCodpedido());
            
            stmt.execute();
            
            cadastro = true;
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em cadastrar medicamento: " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
        return cadastro;
    }
    
    public boolean remover(MedVendidos medVend, Venda vend){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        boolean cadastro = false;
        
        try {
            stmt = c.prepareStatement("DELETE FROM med_vendidos WHERE codmedicamento = ? AND codpedido = ?");
            stmt.setInt(1, medVend.getCodmedicamento());
            stmt.setInt(2, vend.getCodpedido());
            
            stmt.execute();
            
            MedicamentoDAO medDao = new MedicamentoDAO();
            medDao.adicionarDataComp(medVend.getCodmedicamento());
            
            cadastro = true;
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em remover venda(9295558445): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
        return cadastro;
    }
    
    public boolean atualizar(MedVendidos medVend, Venda vend){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        boolean cadastro = false;
        
        try {
            stmt = c.prepareStatement("UPDATE med_vendidos SET "
                    + "valorUnMed = ?,"
                    + "valorvenda = ?,"
                    + "quantidademed = ?"
                    + " WHERE codmedicamento = ? AND codpedido = ?");
            
            stmt.setDouble(1, medVend.getValorUnMed());
            stmt.setDouble(2, medVend.getValorvenda());
            stmt.setInt(3, medVend.getQuantidademed());
            stmt.setInt(4, medVend.getCodmedicamento());
            stmt.setInt(5, vend.getCodpedido());
            
            stmt.execute();
            
            cadastro = true;
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em remover venda(9295558445): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
        return cadastro;
    }
    
    public boolean adicionarEstoque(MedVendidos medVendidos, int QntMed){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        boolean cadastro = false;
        
        try {
            stmt = c.prepareCall("UPDATE medicamento SET "
                    + "quantidadeestoque = (quantidadeestoque + ?) "
                    + "WHERE codmedicamento = ?");
            
            stmt.setInt(1, QntMed);
            stmt.setInt(2, medVendidos.getCodmedicamento());
            
            stmt.execute();
            
            cadastro = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em atualizar estoque (806454): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
        return cadastro;
    }
    
    public boolean removerEstoque(MedVendidos medVendidos, int qntMed){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        boolean cadastro = false;
        
        try {
            stmt = c.prepareCall("UPDATE medicamento SET "
                    + "quantidadeestoque = (quantidadeestoque - ?) "
                    + "WHERE codmedicamento = ?");
            
            stmt.setInt(1, qntMed);
            stmt.setInt(2, medVendidos.getCodmedicamento());
            
            stmt.execute();
            
            cadastro = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em atualizar estoque (806454): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
        return cadastro;
    }
}
