/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author michel.matos
 */
public class ConectarBd {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/projetoIntegrador?user=";
    private static final String USER = "root";
    private static final String PASS = "123456"; 
        
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return java.sql.DriverManager.getConnection(URL,USER,PASS);
        } catch (ClassNotFoundException | SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro ao conectar: " + e);
        }
        return null;
    }
    
    public static void closeConnection(Connection c){
        try {
            if (c != null){
                c.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e);
        }
    }
    
    public static void closeConnection(Connection c, PreparedStatement stmt) {
        closeConnection(c);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + ex);
        }
    }
    
    public static void closeConnection(Connection c, PreparedStatement stmt, ResultSet rs){
        closeConnection(c, stmt);
        try {
            if (rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e);
        }
    }
}
