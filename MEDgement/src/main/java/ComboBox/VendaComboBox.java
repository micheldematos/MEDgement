/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComboBox;

import DAO.VendaDAO;
import Objetos.Venda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user_acronus
 */
public class VendaComboBox extends AbstractTableModel  {
    
    private List<Venda> dados = new ArrayList<>();
    
    public void addLinha(Venda v) {
        this.dados.add(v);
        this.fireTableDataChanged();
    }
    
    public void recarregaTabela(){
        this.dados.clear();
        lerDados();
        this.fireTableDataChanged();
    }
    
    public void lerDados(){
        VendaDAO dao = new VendaDAO();

        try {
            for (Venda v : dao.read()) {
            this.addLinha(v);
            }
            this.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados (646774651): " + e);
        }
    }
    
    
    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
    
    
}
