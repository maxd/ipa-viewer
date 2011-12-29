package info.maksd;

import info.maksd.app.MainForm;

public class Program {
    public static void main(String[] args) throws Exception {
        MainForm frame = new MainForm();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
