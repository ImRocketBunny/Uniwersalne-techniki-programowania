package zad1;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CountryTable extends JTable {
    private String countriesFile;
    private MyTableModel model;

    public CountryTable(String countriesFileName) {
        this.countriesFile = countriesFileName;
        this.setRowHeight(60);
    }

    public CountryTable create() {
        model = new MyTableModel(countriesFile);
        this.setModel(model);
        this.setDefaultRenderer(Integer.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
                cell.setForeground(((int) value)<20000000 ? Color.black : Color.red);
                return cell;

            }
        });
        return this;
    }
}
