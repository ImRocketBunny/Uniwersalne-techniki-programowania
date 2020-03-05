package zad1;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyTableModel extends AbstractTableModel {
    private String countriesPath;

    private List<String> columns = new ArrayList<>();
    private List<Country> rows = new ArrayList<>();


    public MyTableModel(String countriesFile) {
        this.countriesPath = countriesFile;
        try {

            FileReader in = new FileReader(countriesPath);
            BufferedReader br = new BufferedReader(in);
            int n = 0;
            BufferedReader reader = new BufferedReader(new FileReader(countriesPath));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();
            int o = 2;
            while (o>0) {
                if (n == 0) {
                    String str = br.readLine();
                    String[] nazwy = str.split("    ");

                    for(String a : nazwy) {
                        columns.add(a);
                    }
                    n++;
                    o--;
                    columns.add("Flags");
                }
                if (n >= 1) {
                    int licz = lines-1;
                    for(int i = 0; i<licz; i++){
                        String str = br.readLine();
                        String[] dane = str.split("    ");
                        rows.add(new Country(dane[0], dane[1],Integer.parseInt(dane[2])*1000, new ImageIcon("data\\flags\\"+dane[0]+".png")));
                    }
                    o--;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public Object getValueAt(int index, int country) {
        switch(country) {
            case 0:
                return rows.get(index).getName();
            case 1:
                return rows.get(index).getCap();
            case 2:
                return rows.get(index).getPop();
            case 3:
                return rows.get(index).getFlag();
        }

        return null;
    }
    @Override
    public String getColumnName(int index) {
        return columns.get(index);
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Country p = rows.get(rowIndex);
        p.setPop((int) aValue);
        rows.set(rowIndex, p);
        fireTableCellUpdated(rowIndex, columnIndex);

    }
    @Override
    public boolean isCellEditable(int index, int country) {
        if(country!=2) return false;
        return true;
    }
    @Override
    public Class<?> getColumnClass(int column) {
        Object value=this.getValueAt(0,column);
        return (value==null?Object.class:value.getClass());
    }
}


