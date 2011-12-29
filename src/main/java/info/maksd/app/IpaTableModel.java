package info.maksd.app;

import info.maksd.helpers.ImageHelper;
import info.maksd.model.Ipa;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class IpaTableModel extends AbstractTableModel {

    private Ipa[] ipas;
    
    private String[] columnNames = new String[] {
            "",
            "Name"
    };

    public IpaTableModel(Ipa[] ipas) {
        this.ipas = ipas;
    }

    @Override
    public int getRowCount() {
        return ipas.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    @Override
    public Object getValueAt(int row, int column) {
            Ipa ipa = ipas[row];
            switch (column) {
                case -1:
                    return ipa;
                case 0:
                    try{
                        Image artwork = ImageHelper.createResizedCopy(ipa.getiTunesArtwork(), 64, 64, true);
                        return new ImageIcon(artwork);
                    } catch (Exception ex) {
                        return null;
                    }
                case 1:
                    return ipa.getFileName();
                default:
                    return "[Unknown]";
            }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int column) {
        switch (column) {
            case 0:
                return ImageIcon.class;
            default:
                return super.getColumnClass(column);
        }
    }
}
