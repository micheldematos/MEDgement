/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.ConectarBd;
import Objetos.Usuario;
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
public class UsuarioDAO {
    
    public List<Usuario> read(){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Usuario u = new Usuario();
                
                u.setCodusuario(Integer.parseInt(rs.getString("codusuario")));
                u.setSenhausuario(rs.getString("senhausuario"));
                u.setNomecompleto(rs.getString("nomecompleto"));
                u.setCpf(rs.getString("cpf"));
                u.setTipousuario(rs.getInt("tipousuario"));
                u.setSituacaousuario(rs.getInt("situacaousuario"));
                u.setCargo(rs.getString("cargo"));
                
                usuarios.add(u);
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em obter dados: " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return usuarios;
    }
    
    public List<Usuario> pesquisarCod(String pesq){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM usuario WHERE codusuario LIKE '%"+pesq+"%'");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Usuario u = new Usuario();
                
                u.setCodusuario(Integer.parseInt(rs.getString("codusuario")));
                u.setSenhausuario(rs.getString("senhausuario"));
                u.setNomecompleto(rs.getString("nomecompleto"));
                u.setCpf(rs.getString("cpf"));
                u.setTipousuario(rs.getInt("tipousuario"));
                u.setSituacaousuario(rs.getInt("situacaousuario"));
                u.setCargo(rs.getString("cargo"));
                
                usuarios.add(u);
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em obter dados: " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return usuarios;
    }
    
    public List<Usuario> pesquisarNome(String pesq){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM usuario WHERE nomecompleto LIKE '%"+pesq+"%'");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Usuario u = new Usuario();
                
                u.setCodusuario(Integer.parseInt(rs.getString("codusuario")));
                u.setSenhausuario(rs.getString("senhausuario"));
                u.setNomecompleto(rs.getString("nomecompleto"));
                u.setCpf(rs.getString("cpf"));
                u.setTipousuario(rs.getInt("tipousuario"));
                u.setSituacaousuario(rs.getInt("situacaousuario"));
                u.setCargo(rs.getString("cargo"));
                
                usuarios.add(u);
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em obter dados: " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return usuarios;
    }
    
    public void criar(Usuario u){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("INSERT INTO usuario VALUES (null,?,?,?,?,?,?)");
            
            stmt.setString(1,u.getSenhausuario());
            stmt.setString(2, u.getNomecompleto());
            stmt.setString(3, u.getCpf());
            stmt.setInt(4, u.getTipousuario());
            stmt.setInt(5, 1);
            stmt.setString(6, u.getCargo());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "CONCLUÍDO", JOptionPane.NO_OPTION);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em cadastrar usuário (65465651): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public void atualizar(Usuario u){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("UPDATE usuario SET "
                    + "senhausuario = ?,"
                    + "nomecompleto = ?,"
                    + "cpf = ?,"
                    + "tipousuario = ?,"
                    + "situacaousuario = ?,"
                    + "cargo = ?"
                    + " WHERE codusuario = ?");
            
            stmt.setString(1, u.getSenhausuario());
            stmt.setString(2, u.getNomecompleto());
            stmt.setString(3, u.getCpf());
            stmt.setInt(4, u.getTipousuario());
            stmt.setInt(5, u.getSituacaousuario());
            stmt.setString(6, u.getCargo());
            stmt.setInt(7, u.getCodusuario());
            
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Cadastro de usuário atualizado!", "CONCLUÍDO", JOptionPane.NO_OPTION);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em atualizar cadastro do usuário (6540563336): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public boolean checarLogin(String codusuario, String senhausuario){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean logado = false;
        
        try {
            stmt = c.prepareStatement("SELECT * FROM usuario WHERE codusuario = ? AND senhausuario = ? AND situacaousuario = 1;");
            
            stmt.setString(1, codusuario);
            stmt.setString(2, senhausuario);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                logado = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Verificar código do usuário ou senha!");
        } finally {
            ConectarBd.closeConnection(c, stmt, rs);
        }
        return logado;
    }
    
    public void deletar(Usuario u){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("DELETE FROM usuario WHERE codusuario = ?");
            stmt.setInt(1, u.getCodusuario());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em deletar usuário (6655448877): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public void inativar(Usuario u){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("CALL sp_inativarusuario (?)");
            stmt.setInt(1, u.getCodusuario());
            
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Usuário inativado com sucesso!", "CONCLUÍDO", JOptionPane.NO_OPTION);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em inativar usuário (22556649770): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public void ativar(Usuario u){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = c.prepareStatement("CALL sp_ativarusuario (?)");
            stmt.setInt(1, u.getCodusuario());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastro de usuário atualizado!", "CONCLUÍDO", JOptionPane.NO_OPTION);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha em ativar usuário (266979770): " + e);
        } finally {
            ConectarBd.closeConnection(c, stmt);
        }
    }
    
    public Usuario dadosUsuario(String codusuario, String senhausuario){
        Connection c = ConectarBd.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario u = new Usuario();
        
        try {
            stmt = c.prepareStatement("SELECT * FROM usuario WHERE codusuario = ? AND senhausuario = ?");
            stmt.setString(1, codusuario);
            stmt.setString(2, senhausuario);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            }
            
        } catch (SQLException e) {
        }
        return null;
    }
}
