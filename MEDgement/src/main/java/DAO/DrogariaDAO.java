/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.ConectarBd;
import java.sql.Connection;
import java.util.List;
import Objetos.Drogaria;
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
public class DrogariaDAO {
    
    public List <Drogaria> read(){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Drogaria> drogarias = new ArrayList<>();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM drogaria ORDER BY situacaocliente DESC");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Drogaria d = new Drogaria();
                d.setCoddrogaria(Integer.parseInt(rs.getString("coddrogaria")));
                d.setSituacaodrogaria(Integer.parseInt(rs.getString("situacaocliente")));
                d.setCnpjdrogaria(rs.getString("cnpjdrogaria"));
                d.setNomedrogaria(rs.getString("nomedrogaria"));
                d.setRuadrogaria(rs.getString("ruadrogaria"));
                d.setNumerodrogaria(rs.getString("numerodrogaria"));
                d.setComplementodrogaria(rs.getString("complementodrogaria"));
                d.setBairrodrogaria(rs.getString("bairrodrogaria"));
                d.setCidadedrogaria(rs.getString("cidadedrogaria"));
                d.setEstadodrogaria(rs.getString("estadodrogaria"));
                d.setCepdrogaria(rs.getString("cepdrogaria"));
                drogarias.add(d);
            }
                
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return drogarias;
    }
    
    public List <Drogaria> pesquisarCod(String pesq){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Drogaria> drogarias = new ArrayList<>();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM drogaria WHERE coddrogaria LIKE '"+pesq+"'");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Drogaria d = new Drogaria();
                d.setCoddrogaria(Integer.parseInt(rs.getString("coddrogaria")));
                d.setSituacaodrogaria(Integer.parseInt(rs.getString("situacaocliente")));
                d.setCnpjdrogaria(rs.getString("cnpjdrogaria"));
                d.setNomedrogaria(rs.getString("nomedrogaria"));
                d.setRuadrogaria(rs.getString("ruadrogaria"));
                d.setNumerodrogaria(rs.getString("numerodrogaria"));
                d.setComplementodrogaria(rs.getString("complementodrogaria"));
                d.setBairrodrogaria(rs.getString("bairrodrogaria"));
                d.setCidadedrogaria(rs.getString("cidadedrogaria"));
                d.setEstadodrogaria(rs.getString("estadodrogaria"));
                d.setCepdrogaria(rs.getString("cepdrogaria"));
                drogarias.add(d);
            }
                
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return drogarias;
    }
    
    public List <Drogaria> pesquisarNome(String pesq){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Drogaria> drogarias = new ArrayList<>();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM drogaria WHERE nomedrogaria LIKE '%"+pesq+"%'");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Drogaria d = new Drogaria();
                d.setCoddrogaria(Integer.parseInt(rs.getString("coddrogaria")));
                d.setSituacaodrogaria(Integer.parseInt(rs.getString("situacaocliente")));
                d.setCnpjdrogaria(rs.getString("cnpjdrogaria"));
                d.setNomedrogaria(rs.getString("nomedrogaria"));
                d.setRuadrogaria(rs.getString("ruadrogaria"));
                d.setNumerodrogaria(rs.getString("numerodrogaria"));
                d.setComplementodrogaria(rs.getString("complementodrogaria"));
                d.setBairrodrogaria(rs.getString("bairrodrogaria"));
                d.setCidadedrogaria(rs.getString("cidadedrogaria"));
                d.setEstadodrogaria(rs.getString("estadodrogaria"));
                d.setCepdrogaria(rs.getString("cepdrogaria"));
                drogarias.add(d);
            }
                
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return drogarias;
    }
    
    public void criar(Drogaria d){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("INSERT INTO drogaria VALUES (null,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, d.getSituacaodrogaria());
            stmt.setString(2, d.getCnpjdrogaria());
            stmt.setString(3, d.getNomedrogaria());
            stmt.setString(4, d.getRuadrogaria());
            stmt.setString(5, d.getNumerodrogaria());
            stmt.setString(6, d.getComplementodrogaria());
            stmt.setString(7, d.getBairrodrogaria());
            stmt.setString(8, d.getCidadedrogaria());
            stmt.setString(9, d.getEstadodrogaria());
            stmt.setString(10, d.getCepdrogaria());
            
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Cadastro de drogaria efetuado com sucesso!", "CONCLUÍDO", JOptionPane.NO_OPTION);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em cadastrar medicamento: " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    
    public void atualizar(Drogaria d){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("UPDATE drogaria SET cnpjdrogaria = ?,"
                    + "nomedrogaria = ?,"
                    + "ruadrogaria = ?,"
                    + "numerodrogaria = ?,"
                    + "complementodrogaria = ?,"
                    + "bairrodrogaria = ?,"
                    + "cidadedrogaria = ?,"
                    + "estadodrogaria = ?,"
                    + "cepdrogaria = ? "
                    + "WHERE coddrogaria = ?");
            
            stmt.setString(1, d.getCnpjdrogaria());
            stmt.setString(2, d.getNomedrogaria());
            stmt.setString(3, d.getRuadrogaria());
            stmt.setString(4, d.getNumerodrogaria());
            stmt.setString(5, d.getComplementodrogaria());
            stmt.setString(6, d.getBairrodrogaria());
            stmt.setString(7, d.getCidadedrogaria());
            stmt.setString(8, d.getEstadodrogaria());
            stmt.setString(9, d.getCepdrogaria());
            stmt.setInt(10, d.getCoddrogaria());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Drogaria atualizada com sucesso!", "CONCLUÍDO", JOptionPane.NO_OPTION);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em atualizar medicamento: " + e);
        } finally{
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public void inativar(Drogaria d){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("CALL sp_inativardrogaria (?)");
            stmt.setInt(1, d.getCoddrogaria());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Drogaria inativada com sucesso!", "CONCLUÍDO", JOptionPane.NO_OPTION);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em inativar drogaria (99547748116): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public void ativar(Drogaria d){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("CALL sp_ativardrogaria (?)");
            stmt.setInt(1, d.getCoddrogaria());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Drogaria ativada com sucesso!", "CONCLUÍDO", JOptionPane.NO_OPTION);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em ativar drogaria (99547748116): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public ArrayList pesquisar(){
        return null;
    }
}
