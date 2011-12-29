package info.maksd.model;

import info.maksd.helpers.DateHelper;
import net.sf.plist.NSArray;
import net.sf.plist.NSDictionary;
import net.sf.plist.NSObject;

import java.util.Date;

public class ITunesMetadata {
    private final String genre;
    private final String playlistName;
    private final String playlistArtistName;
    private final String kind;
    private final String softwareVersionBundleId;
    private final String bundleVersion;
    private final Date releaseDate;
    private final int artistId;
    private final String itemName;
    private final String copyright;
    private final int vendorId;
    private final int itemId;
    private final int versionRestrictions;
    private final DownloadInfo downloadInfo;
    private final int softwareVersionExternalIdentifier;
    private final Rating rating;
    private final int drmVersionNumber;
    private final String artistName;
    private final int[] softwareSupportedDeviceIds;
    private final int genreId;
    private final AssetInfo assetInfo;

    public ITunesMetadata(NSObject object) {
        assert object instanceof NSDictionary;

        NSDictionary metadata = (NSDictionary) object;

        genre = metadata.get("genre").toString();
        playlistName = metadata.get("playlistName").toString();
        playlistArtistName = metadata.get("playlistArtistName").toString();
        kind = metadata.get("kind").toString();
        softwareVersionBundleId = metadata.get("softwareVersionBundleId").toString();
        bundleVersion = metadata.get("bundleVersion").toString();
        releaseDate = DateHelper.parseiTunesDate(metadata.get("releaseDate").toString());
        artistId = Integer.parseInt(metadata.get("artistId").toString());
        itemName = metadata.get("itemName").toString();
        copyright = metadata.get("copyright").toString();
        vendorId = Integer.parseInt(metadata.get("vendorId").toString());
        itemId = Integer.parseInt(metadata.get("itemId").toString());
        versionRestrictions = Integer.parseInt(metadata.get("versionRestrictions").toString());
        downloadInfo = new DownloadInfo(metadata.get("com.apple.iTunesStore.downloadInfo"));
        softwareVersionExternalIdentifier = Integer.parseInt(metadata.get("softwareVersionExternalIdentifier").toString());
        rating = new Rating(metadata.get("rating"));
        drmVersionNumber = Integer.parseInt(metadata.get("drmVersionNumber").toString());
        artistName = metadata.get("artistName").toString();
        
        NSObject[] softwareSupportedDeviceIdsArray = ((NSArray)metadata.get("softwareSupportedDeviceIds")).array();
        softwareSupportedDeviceIds = new int[softwareSupportedDeviceIdsArray.length];
        for(int i = 0; i < softwareSupportedDeviceIdsArray.length; i++) {
            softwareSupportedDeviceIds[i] = Integer.parseInt(softwareSupportedDeviceIdsArray[i].toString());
        }

        genreId = Integer.parseInt(metadata.get("genreId").toString());
        assetInfo = new AssetInfo(metadata.get("asset-info"));
    }

    public String getGenre() {
        return genre;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public String getPlaylistArtistName() {
        return playlistArtistName;
    }

    public String getKind() {
        return kind;
    }

    public String getSoftwareVersionBundleId() {
        return softwareVersionBundleId;
    }

    public String getBundleVersion() {
        return bundleVersion;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }
    
    public int getArtistId() {
        return artistId;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public String getCopyright() {
        return copyright;
    }
    
    public int getVendorId() {
        return vendorId;
    }
    
    public int getItemId() {
        return itemId;
    }
    
    public int getVersionRestrictions() {
        return versionRestrictions;
    }

    public DownloadInfo getDownloadInfo() {
        return downloadInfo;
    }

    public int getSoftwareVersionExternalIdentifier() {
        return softwareVersionExternalIdentifier;
    }

    public Rating getRating() {
        return rating;
    }

    public int getDrmVersionNumber() {
        return drmVersionNumber;
    }

    public String getArtistName() {
        return artistName;
    }

    public int[] getSoftwareSupportedDeviceIds() {
        return softwareSupportedDeviceIds;
    }

    public int getGenreId() {
        return genreId;
    }

    public AssetInfo getAssetInfo() {
        return assetInfo;
    }
}
