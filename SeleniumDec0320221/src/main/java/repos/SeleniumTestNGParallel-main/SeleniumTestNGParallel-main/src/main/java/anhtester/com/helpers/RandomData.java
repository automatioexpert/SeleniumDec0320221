package anhtester.com.helpers;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;

public class RandomData {

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom random = new SecureRandom();

    public static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(random.nextInt(AB.length())));
        }
//        System.out.println(sb.toString());
        return sb.toString();
    }

    public static String randomStringHexToken(int byteLength) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[byteLength];
        secureRandom.nextBytes(token);
        return new BigInteger(1, token).toString(16); // Hexadecimal encoding
    }

    public static String randomStringUUID() {
        String uuid = UUID.randomUUID().toString();
//        System.out.println(uuid);
        return uuid;
    }

    public static int randomNumberIntFromTo(int from, int to) {
        int random_int = (int) Math.floor(Math.random() * (to - from + 1) + from);
//        System.out.println(random_int);
        return random_int;
    }

}
