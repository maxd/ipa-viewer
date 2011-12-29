package info.maksd.app;

import info.maksd.helpers.ImageHelper;
import info.maksd.model.ITunesMetadata;
import info.maksd.model.Ipa;

import javax.swing.*;
import java.awt.*;

public class IpaDetails {
    public JPanel contentPane;
    private JButton btnExtract;
    private JLabel lblArtwork;
    private JTextField txtName;
    private JTextField txtAuthor;
    private JTextField txtVersion;
    private JTextField txtBundleId;
    private JTextField txtReleaseDate;
    private JTextField txtRating;
    private JTextField txtGenre;
    private JTextField txtSupportedDevices;

    public IpaDetails(Ipa ipa) {
        Image image = ImageHelper.createResizedCopy(ipa.getiTunesArtwork(), 256, 256, true);
        lblArtwork.setIcon(new ImageIcon(image));

        ITunesMetadata metadata = ipa.getiTunesMetadata();

        txtName.setText(metadata.getItemName());
        txtAuthor.setText(metadata.getArtistName());
        txtVersion.setText(metadata.getBundleVersion());
        txtBundleId.setText(metadata.getSoftwareVersionBundleId());
        txtReleaseDate.setText(metadata.getReleaseDate().toString());
        txtRating.setText(metadata.getRating().getLabel());
        txtGenre.setText(metadata.getGenre());
        
        
        String dev = "";
        for(int devId : metadata.getSoftwareSupportedDeviceIds()) 
            dev += Integer.toString(devId);
        txtSupportedDevices.setText(dev);
    }
}
