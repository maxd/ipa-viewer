package info.maksd.helpers;

public class OSValidator {
    private static String os;
    
    static {
        os = System.getProperty("os.name").toLowerCase();
    }

   	public static boolean isWindows() {
   		return (os.contains("win"));
   	}

   	public static boolean isMac() {
   		return (os.contains("mac"));
   	}

   	public static boolean isUnix() {
   		return (os.contains("nix") || os.contains("nux"));
   	}

   	public static boolean isSolaris() {
   		return (os.contains("sunos"));
   	}
}
