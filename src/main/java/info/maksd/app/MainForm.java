package info.maksd.app;

import info.maksd.app.actions.ExitAction;
import info.maksd.app.actions.OpenIpaAction;
import info.maksd.app.actions.SelectIpaAction;
import info.maksd.model.Ipa;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    public static final int FORM_WIDTH = 800;
    public static final int FORM_HEIGHT = 600;

    private JPanel contentPane;
    private IpaDetails ipaDetails;

    public MainForm() {
        super("IPA Viewer");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(FORM_WIDTH, FORM_HEIGHT));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(contentPane);
        setJMenuBar(createMainMenu());
    }

    private JMenuBar createMainMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        fileMenu.add(new OpenIpaAction());
        fileMenu.add(new SelectIpaAction(this));
        fileMenu.addSeparator();
        fileMenu.add(new ExitAction());

        return menuBar;
    }

    public void showIpaDetails(Ipa ipa) {
        if (ipaDetails != null)
            contentPane.remove(ipaDetails.contentPane);
        
        if (ipa != null) {
            ipaDetails = new IpaDetails(ipa);
            contentPane.add(ipaDetails.contentPane, BorderLayout.CENTER);
        }

        contentPane.validate();
    }
}
