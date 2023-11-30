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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author michel.matos
 */
public class VendaDAO {
    
    public List<Venda> read(){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Venda> vendas = new ArrayList<>();
        
        try {
            stmt = c.prepareCall("SELECT * FROM pedidovenda");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Venda v = new Venda();
                v.setCodpedido(Integer.parseInt(rs.getString("codpedido")));
                v.setDatavenda(rs.getString("datavenda"));
                v.setFormapagamentovenda(rs.getString("formapagamentovenda"));
                v.setValorpedidovenda(Double.valueOf(rs.getString("valorpedidovenda")));
                v.setCoddrogaria(Integer.parseInt(rs.getString("coddrogaria")));
                v.setEmissaoNf(Integer.parseInt(rs.getString("emissaoNf")));
                vendas.add(v);
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em obter dados(35640654): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return vendas;
    }
    
    public List<MedVendidos> pesqItens (String pesq){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<MedVendidos> vendas = new ArrayList<>();
        
        try {
            stmt = c.prepareCall("SELECT * FROM med_vendidos WHERE codpedido LIKE '"+pesq+"'");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                MedVendidos medVend = new MedVendidos();
                
                medVend.setDatavenda(rs.getString("datavenda"));
                medVend.setValorUnMed(Double.parseDouble(rs.getString("valorUnMed")));
                medVend.setValorvenda(Double.parseDouble(rs.getString("valorvenda")));
                medVend.setQuantidademed(Integer.parseInt(rs.getString("quantidademed")));
                medVend.setCodmedicamento(Integer.parseInt(rs.getString("codmedicamento")));
                medVend.setCodpedido(Integer.parseInt(rs.getString("codpedido")));
                vendas.add(medVend);
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em obter dados(35640654): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return vendas;
    }
    
    public List<Venda> pesquisar(String pesq){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Venda> vendas = new ArrayList<>();
        
        try {
            stmt = c.prepareCall("SELECT * FROM pedidovenda WHERE codpedido LIKE '%"+pesq+"%'");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Venda v = new Venda();
                v.setCodpedido(Integer.parseInt(rs.getString("codpedido")));
                v.setDatavenda(rs.getString("datavenda"));
                v.setFormapagamentovenda(rs.getString("formapagamentovenda"));
                v.setValorpedidovenda(Double.valueOf(rs.getString("valorpedidovenda")));
                v.setCoddrogaria(Integer.parseInt(rs.getString("coddrogaria")));
                v.setEmissaoNf(Integer.parseInt(rs.getString("emissaoNf")));
                vendas.add(v);
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em obter dados(35640654): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return vendas;
    }
    
    public int criar(Venda v){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = c.prepareStatement("INSERT INTO pedidovenda VALUES (null,?,?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, v.getDatavenda());
            stmt.setString(2, v.getFormapagamentovenda());
            stmt.setDouble(3, v.getValorpedidovenda());
            stmt.setInt(4, v.getCoddrogaria());
            stmt.setInt(5, 0);
            stmt.executeUpdate();
            
            rs = stmt.getGeneratedKeys();
            rs.next();
            
            v.setCodpedido(rs.getInt(1));
            
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em efetuar cadastro (6806048): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
        return v.getCodpedido();
    }
    
    public boolean addItensVend (Venda v, List<MedVendidos> medVendidos){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        boolean addItens = false;
        
        try {
            for (int i = 0; i < medVendidos.size(); i++) {
                stmt = c.prepareStatement("INSERT INTO med_vendidos VALUES (?,?,?,?,?,?)");
                stmt.setString(1, medVendidos.get(i).getDatavenda());
                stmt.setDouble(2, medVendidos.get(i).getValorUnMed());
                stmt.setDouble(3, medVendidos.get(i).getValorvenda());
                stmt.setInt(4, medVendidos.get(i).getQuantidademed());
                stmt.setInt(5, medVendidos.get(i).getCodmedicamento());
                stmt.setInt(6, v.getCodpedido());
                stmt.execute();
            }
            
            addItens = true;
            JOptionPane.showMessageDialog(null, "Item adicionado com sucesso!");
            
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Falha em adicionar item na compra: " + e);
            } finally {
                ConectarBd.closeConnection(c, stmt);
            }
        
        return addItens;
    }
    
    public void atualizar(Venda v){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("UPDATE pedidovenda SET "
                    + "datavenda = ?,"
                    + "formapagamentovenda = ?,"
                    + "coddrogaria = ?"
                    + " WHERE codpedido = ?");
            
            stmt.setString(1, v.getDatavenda());
            stmt.setString(2, v.getFormapagamentovenda());
            stmt.setInt(3, v.getCoddrogaria());
            stmt.setInt(4, v.getCodpedido());
            
            stmt.execute();
            
            
            JOptionPane.showMessageDialog(null, "Pedido de venda atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em atualizar pedido de venda(987546532): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public void atualizarValor(Venda v){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("UPDATE pedidovenda SET "
                    + "valorpedidovenda = ?"
                    + " WHERE codpedido = ?");
            
            stmt.setDouble(1, v.getValorpedidovenda());
            stmt.setInt(2, v.getCodpedido());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Pedido de venda atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em atualizar pedido de venda(987546532): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public void deletar(Venda v){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("DELETE FROM pedidovenda WHERE codpedido = ?");
            stmt.setInt(1, v.getCodpedido());
            
            stmt.execute();
            
            MedicamentoDAO dao = new MedicamentoDAO();
            // dao.adicionarEstoque(v);
            
            JOptionPane.showMessageDialog(null, "Venda removida com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em remover venda(9295558445): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
}
