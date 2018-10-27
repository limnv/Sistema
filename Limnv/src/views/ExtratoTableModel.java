package views;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Extrato;

/**
 *
 * @author luism
 */
public class ExtratoTableModel extends DefaultTableModel {
    
    private String ColumnNames[] = new String[]{"Data","Descrição","Vlr. Oper", "Vlr. Final"};
    
    private List<Extrato> Dados;
    
    public ExtratoTableModel(List<Extrato> e){
        this.setColumnIdentifiers(ColumnNames);
        
        Dados = e;
        
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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Extrato e = Dados.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return e.getData();
            case 1:
                return e.getDescricao();
            case 2:
                return e.getValorOperacao();
            case 3:
                return e.getValorFinal();
            default:
                return null;            
        }
    }
}
