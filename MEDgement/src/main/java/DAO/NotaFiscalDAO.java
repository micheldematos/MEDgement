/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.ConectarBd;
import Objetos.NotaFiscal;
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
public class NotaFiscalDAO {
    
    public List<NotaFiscal> read(){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<NotaFiscal> notasFiscais = new ArrayList<>();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM notafiscal");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                NotaFiscal nf = new NotaFiscal();
                nf.setNumeronf(Integer.parseInt(rs.getString("numeronf")));
                nf.setDataemissaonf(rs.getString("dataemissaonf"));
                nf.setValornfvenda(Double.parseDouble(rs.getString("valornfvenda")));
                nf.setCodpedido(Integer.parseInt(rs.getString("codpedido")));
                notasFiscais.add(nf);
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "080620231353 - Falha ao obter dados " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return notasFiscais;
    }
    
    public void criar(NotaFiscal f){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("INSERT INTO notafiscal VALUES (null,?,?,?)");
            stmt.setString(1, f.getDataemissaonf());
            stmt.setDouble(2, f.getValornfvenda());
            stmt.setInt(3, f.getCodpedido());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "135608062023 - Falha ao cadastrar nota fiscal: " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public void cancelar(Venda nf){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("DELETE FROM notafiscal WHERE numeronf = ?");
            stmt.setInt(1, nf.getEmissaoNf());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Nota fiscal cancelada com sucesso!", "CONCLUÍDO", JOptionPane.NO_OPTION);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "080620231400 - Falha ao cancelar nota fiscal: " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public void cancelarI(NotaFiscal nf){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("DELETE FROM notafiscal WHERE numeronf = ?");
            stmt.setInt(1, nf.getNumeronf());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Nota fiscal cancelada com sucesso!", "CONCLUÍDO", JOptionPane.NO_OPTION);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "080620231400 - Falha ao cancelar nota fiscal: " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
}
