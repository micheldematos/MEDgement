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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author michel.matos
//// */
public class CompraDAO {
    public List<Compra> read(){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Compra> compras = new ArrayList<>();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM compra");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Compra comp = new Compra();
                comp.setCodCompra(Integer.parseInt(rs.getString("codcompra")));
                comp.setDataCompra(rs.getString("datacompra"));
                comp.setDataEntregaCompra(rs.getString("dataentregacompra"));
                comp.setNumeroNFCompra(Integer.parseInt(rs.getString("numeronfcompra")));
                comp.setValorNFCompra(Double.parseDouble(rs.getString("valornfcompra")));
                comp.setFormaPagamentoCompra(rs.getString("formapagamentocompra"));
                comp.setCodFornecedor(Integer.parseInt(rs.getString("codfornecedor")));
                compras.add(comp);
            }
            
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha para obter dados (1650469): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return compras;
    }
    
    public List<MedComprados> pesqItens (String pesq){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<MedComprados> compras = new ArrayList<>();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM med_comprados WHERE codcompra = "+pesq+";");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                MedComprados medComp = new MedComprados();
                
                medComp.setDatacompra(rs.getString("datacompra"));
                medComp.setValorUnMed(Double.valueOf(rs.getString("valorUnMed")));
                medComp.setValorComp(Double.parseDouble(rs.getString("valorComp")));
                medComp.setQuantidademed(Integer.parseInt(rs.getString("quantidademed")));
                medComp.setCodmedicamento(Integer.parseInt(rs.getString("codmedicamento")));
                compras.add(medComp);
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha para obter dados (1650469): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return compras;
    }
    
    public List<Compra> pesquisar(String pesq){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Compra> compras = new ArrayList<>();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM compra WHERE codcompra LIKE '%"+pesq+"%'");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Compra comp = new Compra();
                comp.setCodCompra(Integer.parseInt(rs.getString("codcompra")));
                comp.setDataCompra(rs.getString("datacompra"));
                comp.setDataEntregaCompra(rs.getString("dataentregacompra"));
                comp.setNumeroNFCompra(Integer.parseInt(rs.getString("numeronfcompra")));
                comp.setValorNFCompra(Double.parseDouble(rs.getString("valornfcompra")));
                comp.setFormaPagamentoCompra(rs.getString("formapagamentocompra"));
                comp.setCodFornecedor(Integer.parseInt(rs.getString("codfornecedor")));
                compras.add(comp);
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha para obter dados (1650469): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return compras;
    }
    
    public List<Compra> pesquisarNF(String pesq){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Compra> compras = new ArrayList<>();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM compra WHERE numeronfcompra LIKE '%"+pesq+"%'");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Compra comp = new Compra();
                comp.setCodCompra(Integer.parseInt(rs.getString("codcompra")));
                comp.setDataCompra(rs.getString("datacompra"));
                comp.setDataEntregaCompra(rs.getString("dataentregacompra"));
                comp.setNumeroNFCompra(Integer.parseInt(rs.getString("numeronfcompra")));
                comp.setValorNFCompra(Double.parseDouble(rs.getString("valornfcompra")));
                comp.setFormaPagamentoCompra(rs.getString("formapagamentocompra"));
                comp.setCodFornecedor(Integer.parseInt(rs.getString("codfornecedor")));
                compras.add(comp);
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha para obter dados (1650469): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return compras;
    }
    
    public int criar(Compra comp){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = c.prepareStatement("INSERT INTO compra VALUES (null,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, comp.getDataCompra());
            stmt.setString(2, comp.getDataEntregaCompra());
            stmt.setInt(3, comp.getNumeroNFCompra());
            stmt.setDouble(4, comp.getValorNFCompra());
            stmt.setString(5, comp.getFormaPagamentoCompra());
            stmt.setInt(6, comp.getCodFornecedor());
            stmt.executeUpdate();
            
            rs = stmt.getGeneratedKeys();
            rs.next();
            
            comp.setCodCompra(rs.getInt(1));
            
            JOptionPane.showMessageDialog(null, "Compra cadastrada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em cadastrar compra(68707894): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
        return comp.getCodCompra();
    }
    
    public boolean addItensComp(Compra comp, List<MedComprados> medComprados){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        MedicamentoDAO medDao = new MedicamentoDAO();
        
        boolean addItens = false;
        
        try {
            for (int i = 0; i < medComprados.size(); i++) {
                stmt = c.prepareStatement("INSERT INTO med_comprados VALUES (?,?,?,?,?,?)");
                stmt.setString(1, medComprados.get(i).getDatacompra());
                stmt.setDouble(2, medComprados.get(i).getValorUnMed());
                stmt.setDouble(3, medComprados.get(i).getValorComp());
                stmt.setInt(4, medComprados.get(i).getQuantidademed());
                stmt.setInt(5, medComprados.get(i).getCodmedicamento());
                stmt.setInt(6, comp.getCodCompra());
                stmt.execute();
                
                medDao.adicionarDataComp(medComprados.get(i).getCodmedicamento());
            }
            
            addItens = true;
            JOptionPane.showMessageDialog(null, "Itens adicionados com sucesso!");
            
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Falha em adicionar item na compra: " + e);
            } finally {
                ConectarBd.closeConnection(c, stmt);
            }
        return addItens;
    }
    
    public void atualizar(Compra comp){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        MedicamentoDAO medDao = new MedicamentoDAO();
        
        try {
            
            MedCompradosDAO medComp = new MedCompradosDAO();
            List<MedComprados> medicamentos =  medComp.consultaMedComprados(comp.getCodCompra());
            
            stmt = c.prepareStatement("UPDATE compra SET datacompra = ?,"
                    + "dataentregacompra = ?,"
                    + "numeronfcompra = ?,"
                    + "formapagamentocompra = ?,"
                    + "codfornecedor = ?"
                    + " WHERE codcompra = ?;");
            
            stmt.setString(1, comp.getDataCompra());
            stmt.setString(2, comp.getDataEntregaCompra());
            stmt.setInt(3, comp.getNumeroNFCompra());
            stmt.setString(4, comp.getFormaPagamentoCompra());
            stmt.setInt(5, comp.getCodFornecedor());
            stmt.setInt(6, comp.getCodCompra());
            
            stmt.execute();
            
            for (int i = 0; i < medicamentos.size(); i++) {
                medDao.adicionarDataComp(medicamentos.get(i).getCodmedicamento());
            }
            
            JOptionPane.showMessageDialog(null, "Compra atualizada com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar medicamento(87098798): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public void atualizarValor(Compra comp){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = c.prepareStatement("UPDATE compra SET "
                    + "valornfcompra = ? "
                    + " WHERE codcompra = ?;");
            
            stmt.setDouble(1, comp.getValorNFCompra());
            stmt.setInt(2, comp.getCodCompra());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Compra atualizada com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar medicamento(87098798): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public void deletar(Compra comp){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        MedicamentoDAO medDao = new MedicamentoDAO();
        
        try {
                       
            MedCompradosDAO medComp = new MedCompradosDAO();
            List<MedComprados> medicamentos =  medComp.consultaMedComprados(comp.getCodCompra());
            
            stmt = c.prepareStatement("DELETE FROM compra WHERE codcompra = ?");
            stmt.setInt(1, comp.getCodCompra());
            stmt.execute();
            
            for (int i = 0; i < medicamentos.size(); i++) {
                medDao.adicionarDataComp(medicamentos.get(i).getCodmedicamento());
            }
            
            JOptionPane.showMessageDialog(null, "Data atualizada");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em remover compra(9995558445): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public String ultimaData(int codMed){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String ultComp = null;
        
        MedComprados medComp = new MedComprados();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM med_comprados WHERE codmedicamento = ? ORDER BY datacompra ASC");
            stmt.setInt(1, codMed);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                medComp.setDatacompra(rs.getString("datacompra"));
            }
            
            ultComp = medComp.getDatacompra();
            
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em obter dados: " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return ultComp;
    }
    
    public double ultimoValor(int codMed){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double ultValor = 0.0;
        
        MedComprados medComp = new MedComprados();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM med_comprados WHERE codmedicamento = ? ORDER BY datacompra ASC");
            stmt.setInt(1, codMed);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                medComp.setValorUnMed(Double.valueOf(rs.getString("valorUnMed")));
                ultValor = medComp.getValorUnMed();
            }
            
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em obter dados: " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return ultValor;
    }
}
