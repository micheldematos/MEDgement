/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import Objetos.Fornecedor;
import java.util.List;
import BD.ConectarBd;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author michel.matos
 */
public class FornecedorDAO {
    
    public List<Fornecedor> read(){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Fornecedor> fornecedores = new ArrayList<>();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM fornecedor ORDER BY situacaofornecedor DESC");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Fornecedor f = new Fornecedor();
                f.setNomefornecedor(rs.getString("nomefornecedor"));
                f.setCodfornecedor(rs.getInt("codfornecedor"));
                f.setSituacaofornecedor((rs.getInt("situacaofornecedor")));
                f.setCnpjfornecedor(rs.getString("cnpjfornecedor"));
                f.setInscricaoestadualfornecedor(rs.getString("inscricaoestadualfornecedor"));
                f.setRuafornecedor(rs.getString("ruafornecedor"));
                f.setNumerofornecedor(rs.getString("numerofornecedor"));
                f.setComplementofornecedor(rs.getString("complementofornecedor"));
                f.setBairrofornecedor(rs.getString("bairrofornecedor"));
                f.setCidadefornecedor(rs.getString("cidadefornecedor"));
                f.setEstadofornecedor(rs.getString("estadofornecedor"));
                f.setCepfornecedor(rs.getString("cepfornecedor"));
                fornecedores.add(f);
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Falha ao obter dados " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return fornecedores;
    }
    
    public List<Fornecedor> pesquisarCod(String pesq){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Fornecedor> fornecedores = new ArrayList<>();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM fornecedor WHERE codfornecedor LIKE '"+pesq+"'");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Fornecedor f = new Fornecedor();
                f.setNomefornecedor(rs.getString("nomefornecedor"));
                f.setCodfornecedor(rs.getInt("codfornecedor"));
                f.setSituacaofornecedor((rs.getInt("situacaofornecedor")));
                f.setCnpjfornecedor(rs.getString("cnpjfornecedor"));
                f.setInscricaoestadualfornecedor(rs.getString("inscricaoestadualfornecedor"));
                f.setRuafornecedor(rs.getString("ruafornecedor"));
                f.setNumerofornecedor(rs.getString("numerofornecedor"));
                f.setComplementofornecedor(rs.getString("complementofornecedor"));
                f.setBairrofornecedor(rs.getString("bairrofornecedor"));
                f.setCidadefornecedor(rs.getString("cidadefornecedor"));
                f.setEstadofornecedor(rs.getString("estadofornecedor"));
                f.setCepfornecedor(rs.getString("cepfornecedor"));
                fornecedores.add(f);
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Falha ao obter dados " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return fornecedores;
    }
    
    public List<Fornecedor> pesquisarNome(String pesq){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Fornecedor> fornecedores = new ArrayList<>();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM fornecedor WHERE nomefornecedor LIKE '%"+pesq+"%'");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Fornecedor f = new Fornecedor();
                f.setNomefornecedor(rs.getString("nomefornecedor"));
                f.setCodfornecedor(rs.getInt("codfornecedor"));
                f.setSituacaofornecedor((rs.getInt("situacaofornecedor")));
                f.setCnpjfornecedor(rs.getString("cnpjfornecedor"));
                f.setInscricaoestadualfornecedor(rs.getString("inscricaoestadualfornecedor"));
                f.setRuafornecedor(rs.getString("ruafornecedor"));
                f.setNumerofornecedor(rs.getString("numerofornecedor"));
                f.setComplementofornecedor(rs.getString("complementofornecedor"));
                f.setBairrofornecedor(rs.getString("bairrofornecedor"));
                f.setCidadefornecedor(rs.getString("cidadefornecedor"));
                f.setEstadofornecedor(rs.getString("estadofornecedor"));
                f.setCepfornecedor(rs.getString("cepfornecedor"));
                fornecedores.add(f);
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Falha ao obter dados " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return fornecedores;
    }
    
    public void criar(Fornecedor f){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("INSERT INTO fornecedor VALUES (null,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, f.getSituacaofornecedor());
            stmt.setString(2, f.getInscricaoestadualfornecedor());
            stmt.setString(3, f.getCnpjfornecedor());
            stmt.setString(4, f.getNomefornecedor());
            stmt.setString(5, f.getRuafornecedor());
            stmt.setString(6, f.getNumerofornecedor());
            stmt.setString(7, f.getComplementofornecedor());
            stmt.setString(8, f.getBairrofornecedor());
            stmt.setString(9, f.getCidadefornecedor());
            stmt.setString(10, f.getEstadofornecedor());
            stmt.setString(11, f.getCepfornecedor());
            
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso","CONCLUÍDO", JOptionPane.NO_OPTION);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar fornecedor: " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public void atualizar(Fornecedor f){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("UPDATE fornecedor SET "
                    + "inscricaoestadualfornecedor = ?,"
                    + "cnpjfornecedor = ?,"
                    + "nomefornecedor = ?,"
                    + "ruafornecedor = ?,"
                    + "numerofornecedor = ?,"
                    + "complementofornecedor = ?,"
                    + "bairrofornecedor = ?,"
                    + "cidadefornecedor = ?,"
                    + "estadofornecedor = ?,"
                    + "cepfornecedor = ?"
                    + "WHERE codfornecedor = ?");
            stmt.setString(1, f.getInscricaoestadualfornecedor());
            stmt.setString(2, f.getCnpjfornecedor());
            stmt.setString(3, f.getNomefornecedor());
            stmt.setString(4, f.getRuafornecedor());
            stmt.setString(5, f.getNumerofornecedor());
            stmt.setString(6, f.getComplementofornecedor());
            stmt.setString(7, f.getBairrofornecedor());
            stmt.setString(8, f.getCidadefornecedor());
            stmt.setString(9, f.getEstadofornecedor());
            stmt.setString(10, f.getCepfornecedor());
            stmt.setInt(11, f.getCodfornecedor());
            
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso","CONCLUÍDO", JOptionPane.NO_OPTION);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar " + e);
        } finally{
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public void inativar(Fornecedor f){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("CALL sp_inativarfornecedor (?)");
            stmt.setInt(1, f.getCodfornecedor());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Fornecedor inativado com sucesso","CONCLUÍDO", JOptionPane.NO_OPTION);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em inativar fornecedor (225669770): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public void ativar(Fornecedor f){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("CALL sp_ativarfornecedor (?)");
            stmt.setInt(1, f.getCodfornecedor());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Fornecedor ativado com sucesso","CONCLUÍDO", JOptionPane.NO_OPTION);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em ativar fornecedor (225669770): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
}
