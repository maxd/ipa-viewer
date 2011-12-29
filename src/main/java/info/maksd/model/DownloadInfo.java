package info.maksd.model;

import info.maksd.helpers.DateHelper;
import net.sf.plist.NSDictionary;
import net.sf.plist.NSObject;

import java.util.Date;

public class DownloadInfo {
    private AccountInfo accountInfo;
    private Date purchaseDate;

    public DownloadInfo(NSObject object) {
        assert object instanceof NSDictionary;

        NSDictionary downloadInfo = (NSDictionary)object;

        accountInfo = new AccountInfo(downloadInfo.get("accountInfo"));
        purchaseDate = DateHelper.parseiTunesDate(downloadInfo.get("purchaseDate").toString());
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }
}
