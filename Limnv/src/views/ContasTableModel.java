package views;

import java.util.*;
import javax.swing.table.DefaultTableModel;
import models.*;

/**
 *
 * @author luism
 */
public class ContasTableModel extends DefaultTableModel {
    
    private String ColumnNames[] = new String[]{"Cód.","Descrição","Tipo"};
    
    private List<ContasVM> Dados;
    
    public ContasTableModel(List<Conta> contas){
        this.setColumnIdentifiers(ColumnNames);
        
        Dados = new ArrayList<ContasVM>();
        
        for (int i = 0; i < contas.size(); i++) {
            Conta c = contas.get(i);
            Dados.add(new ContasVM(c));
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
    @Override
    public int getRowCount() {
        if (Dados == null){
            return 0;
        }
        return Dados.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        ContasVM c = Dados.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return c.getCodigo();
            case 1:
                return c.getDescricao();
            case 2:
                return c.getTipo();
            default:
                return null;            
        }
    }
    
}
