package info.maksd.model;

import info.maksd.helpers.OSValidator;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class IpaList {
    public Ipa[] getListFromDirectory(String directoryName) {
        File directory = new File(directoryName);
        File[] ipaFiles = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                return s.endsWith(".ipa");
            }
        });

        ArrayList<Ipa> result = new ArrayList<Ipa>();
        for(File ipaFile : ipaFiles) {
            result.add(new Ipa(ipaFile));
        }
        return result.toArray(new Ipa[result.size()]);
    }
    
    public Ipa[] getListFromITunesDirectory() throws Exception {
        if (OSValidator.isWindows()) {
            File homeDirectory = new File(System.getProperty("user.home"));
            File musicDirectory = new File(homeDirectory, "Music");
            File mobileApplicationsDirectory = new File(musicDirectory, "iTunes\\iTunes Media\\Mobile Applications");

            return getListFromDirectory(mobileApplicationsDirectory.getAbsolutePath());
        }
        throw new Exception("This OS don't support now.");
    }
}
