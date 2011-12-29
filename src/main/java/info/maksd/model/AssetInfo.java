package info.maksd.model;

import net.sf.plist.NSDictionary;
import net.sf.plist.NSObject;

public class AssetInfo {
    private final String flavor;
    private final int fileSize;

    public AssetInfo(NSObject object) {
        assert object instanceof NSDictionary;

        NSDictionary metadata = (NSDictionary)object;

        flavor = metadata.get("flavor").toString();
        fileSize = Integer.parseInt(metadata.get("file-size").toString());
    }

    public String getFlavor() {
        return flavor;
    }

    public int getFileSize() {
        return fileSize;
    }
}
