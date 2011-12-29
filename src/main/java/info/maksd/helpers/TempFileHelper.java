package info.maksd.helpers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TempFileHelper {
    public static File saveTempFile(InputStream inputStream) {
        try {
            File tempFile = File.createTempFile("tmp", ".tmp");
            FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
    
            int read = 0;
            byte[] buffer = new byte[1024];
    
            while ((read = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, read);
            }
    
            fileOutputStream.flush();
            fileOutputStream.close();

            return tempFile;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
