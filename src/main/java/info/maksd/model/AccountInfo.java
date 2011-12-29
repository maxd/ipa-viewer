package info.maksd.model;

import net.sf.plist.NSDictionary;
import net.sf.plist.NSObject;

public class AccountInfo {
    private int accountKind;
    private int accountServiceTypes;
    private String accountStoreFront;
    private int accountAvailableServiceTypes;
    private int dsPersonID;
    private String appleID;
    private boolean accountSocialEnabled;
    private String creditDisplayString;
    private String accountURLBagType;

    public AccountInfo(NSObject object) {
        assert object instanceof NSDictionary;

        NSDictionary metadata = (NSDictionary)object;

        accountKind = Integer.parseInt(metadata.get("AccountKind").toString());
        accountServiceTypes = Integer.parseInt(metadata.get("AccountServiceTypes").toString());
        accountStoreFront = metadata.get("AccountStoreFront").toString();
        accountAvailableServiceTypes = Integer.parseInt(metadata.get("AccountAvailableServiceTypes").toString());
        dsPersonID = Integer.parseInt(metadata.get("DSPersonID").toString());
        appleID = metadata.get("AppleID").toString();
        accountSocialEnabled = Boolean.parseBoolean(metadata.get("AccountSocialEnabled").toString());
        creditDisplayString = metadata.get("CreditDisplayString").toString();
        accountURLBagType = metadata.get("AccountURLBagType").toString();
    }

    public int getAccountKind() {
        return accountKind;
    }

    public int getAccountServiceTypes() {
        return accountServiceTypes;
    }

    public String getAccountStoreFront() {
        return accountStoreFront;
    }

    public int getAccountAvailableServiceTypes() {
        return accountAvailableServiceTypes;
    }

    public int getDsPersonID() {
        return dsPersonID;
    }

    public String getAppleID() {
        return appleID;
    }

    public boolean isAccountSocialEnabled() {
        return accountSocialEnabled;
    }

    public String getCreditDisplayString() {
        return creditDisplayString;
    }

    public String getAccountURLBagType() {
        return accountURLBagType;
    }
}
