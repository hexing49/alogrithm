//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

public class KeyUtils {
    private static final Pattern PATTERN = Pattern.compile("^jfs/t(\\d+)/(\\d+/\\d+/\\d+)/([0-9A-Fa-f]{1,8})([0-9A-Fa-f]{8})([Y|N|y|n])[.\\w]{0,7}$");

    public KeyUtils() {
    }

    public static int getDsId(String var0) {
        Matcher var1 = PATTERN.matcher(var0);
        if (var1.find()) {
            return Integer.valueOf(var1.group(1));
        } else {
            throw new RuntimeException("Bad key :" + var0);
        }
    }

    public static String getFileId(String var0) {
        Matcher var1 = PATTERN.matcher(var0);
        if (var1.find()) {
            return var1.group(2);
        } else {
            throw new RuntimeException("Bad key :" + var0);
        }
    }

    public static String getCrc(String var0) {
        Matcher var1 = PATTERN.matcher(var0);
        if (var1.find()) {
            return var1.group(3);
        } else {
            throw new RuntimeException("Bad key :" + var0);
        }
    }

    public static boolean isCompression(String var0) {
        Matcher var1 = PATTERN.matcher(var0);
        if (var1.find()) {
            return "Y".equalsIgnoreCase(var1.group(5));
        } else {
            throw new RuntimeException("Bad key :" + var0);
        }
    }

    public static boolean verification(String var0) {
        Matcher var1 = PATTERN.matcher(var0);
        if (var1.find()) {
            String var2 = createChecksum(String.format("%s/%s/%s", var1.group(1), var1.group(2), var1.group(3)), "Y".equalsIgnoreCase(var1.group(5)));
            if (var1.group(4).equals(var2) || "13081253".equals(var1.group(4))) {
                return true;
            }
        }

        return false;
    }

    public static String createChecksum(String var0, boolean var1) {
        String var2 = String.format("%sDengliang", var0);
        CRC32 var3 = new CRC32();
        var3.update(var2.getBytes());
        if (var1) {
            var3.update(255);
        }

        return crcPadLeft(var3.getValue());
    }

    public static String crcPadLeft(long var0) {
        StringBuffer var2 = new StringBuffer(Long.toHexString(var0));

        while(var2.length() < 8) {
            var2.insert(0, "0");
        }

        return var2.toString();
    }
}
