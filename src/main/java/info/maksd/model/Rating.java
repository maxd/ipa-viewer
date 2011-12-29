package info.maksd.model;

import net.sf.plist.NSDictionary;
import net.sf.plist.NSObject;

public class Rating {
    private final String content;
    private final int rank;
    private final String system;
    private final String label;
    
    public Rating(NSObject object) {
        assert object instanceof NSDictionary;

        NSDictionary metadata = (NSDictionary)object;

        content = metadata.get("content").toString();
        rank = Integer.parseInt(metadata.get("rank").toString());
        system = metadata.get("system").toString();
        label = metadata.get("label").toString();
    }

    public String getContent() {
        return content;
    }

    public int getRank() {
        return rank;
    }

    public String getSystem() {
        return system;
    }

    public String getLabel() {
        return label;
    }
}
