package info.maksd.app;

import info.maksd.model.Ipa;
import info.maksd.model.IpaList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SelectIpaDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable tblIpaList;

    private IpaList ipaList;
    private Ipa selectedIpa;

    public SelectIpaDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        initTable();
    }

    private void initTable() {
        try {
            ipaList = new IpaList();
            Ipa[] ipas = ipaList.getListFromITunesDirectory();

            tblIpaList.setModel(new IpaTableModel(ipas));
            tblIpaList.getColumnModel().getColumn(0).setMaxWidth(68);
            tblIpaList.setRowHeight(68);
        } catch (Exception e) {
            //TODO: change exception handler
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void onOK() {
        Integer selectedRow = tblIpaList.convertRowIndexToModel(tblIpaList.getSelectedRow());
        selectedIpa = (Ipa) tblIpaList.getModel().getValueAt(selectedRow, -1);

        dispose();
    }

    private void onCancel() {
        dispose();
    }
    
    public Ipa showDialog(JFrame frame) {
        setPreferredSize(new Dimension(640, 480));
        pack();
        setLocationRelativeTo(frame);
        setVisible(true);

        return selectedIpa;
    }
}
