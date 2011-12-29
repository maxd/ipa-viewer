package info.maksd.model;

import info.maksd.helpers.TempFileHelper;
import net.sf.plist.NSObject;
import net.sf.plist.io.PropertyListException;
import net.sf.plist.io.bin.BinaryParser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Ipa {
    private File ipaFile;
    private ZipFile zipFile;
    
    private Image iTunesArtwork;
    private ITunesMetadata iTunesMetadata;
    private String appDirectoryName;

    public Ipa(File ipaFile) {
        this.ipaFile = ipaFile;
    }

    private ZipFile getZipFile() throws IOException {
        if (zipFile == null)
            zipFile = new ZipFile(ipaFile);
        return zipFile;
    }

    public String getFileName() {
        return ipaFile.getName();
    }

    public Image getiTunesArtwork() {
        if (iTunesArtwork == null) {
            try {
                ZipEntry artworkEntry = getZipFile().getEntry("iTunesArtwork");
                InputStream inputStream = getZipFile().getInputStream(artworkEntry);
                iTunesArtwork = ImageIO.read(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return iTunesArtwork;
    }

    public ITunesMetadata getiTunesMetadata() {
        if (iTunesMetadata == null) {
            try {
                ZipEntry metadataEntry = getZipFile().getEntry("iTunesMetadata.plist");
                InputStream inputStream = getZipFile().getInputStream(metadataEntry);

                File extractedFile = TempFileHelper.saveTempFile(inputStream);
                NSObject nsObject = BinaryParser.parse(extractedFile);

                iTunesMetadata = new ITunesMetadata(nsObject);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (PropertyListException e) {
                e.printStackTrace();
            }
        }
        return iTunesMetadata;
    }

    public NSObject getInfoPlist() {
        try {
            String infoPlistFile = String.format("Payload/%1$s/Info.plist", getAppDirectoryName());

            ZipEntry metadataEntry = getZipFile().getEntry(infoPlistFile);
            InputStream inputStream = getZipFile().getInputStream(metadataEntry);

            File extractedFile = TempFileHelper.saveTempFile(inputStream);
            NSObject nsObject = BinaryParser.parse(extractedFile);

            return nsObject;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private String getAppDirectoryName() {
        if (appDirectoryName == null) {
            try {
                Pattern regexp = Pattern.compile("^Payload/([\\w\\. -]+\\.app)/");
                for(Enumeration<? extends ZipEntry> e = getZipFile().entries(); e.hasMoreElements();) {
                    ZipEntry zipEntry = e.nextElement();
                    String name = zipEntry.getName();
                    Matcher matcher = regexp.matcher(name);
                    if (matcher.find()) {
                        appDirectoryName =  matcher.group(1);
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return appDirectoryName;
    }
}
