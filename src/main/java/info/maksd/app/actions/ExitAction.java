package info.maksd.app.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ExitAction extends AbstractAction {

    public ExitAction() {
        putValue(NAME, "Exit");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Bye.");
        System.exit(0);
    }
}
