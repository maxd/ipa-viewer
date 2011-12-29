package info.maksd.app.actions;

import info.maksd.app.MainForm;
import info.maksd.app.SelectIpaDialog;
import info.maksd.model.Ipa;
import net.sf.plist.NSObject;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SelectIpaAction extends AbstractAction {
    private MainForm mainForm;

    public SelectIpaAction(MainForm mainForm) {
        this.mainForm = mainForm;
        putValue(NAME, "Select IPA...");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        SelectIpaDialog selectIpaDialog = new SelectIpaDialog();
        Ipa ipa = selectIpaDialog.showDialog(mainForm);
        if (ipa != null) {
            mainForm.showIpaDetails(ipa);

            NSObject y = ipa.getInfoPlist();
        }
    }
}