package info.maksd.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssz");

    public static Date parseiTunesDate(String dateAsString) {
        String source = dateAsString.replaceAll("Z", "UTC"); // Java 1.6 doesn't support ISO 8601 time zones
        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
