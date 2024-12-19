package mainPack;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {

    // Generate a SHA-256 hash for the given input
    public static String cipher(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(input.getBytes());
        return bytesToHex(encodedHash);
    }

    // Compare a hash with the input string by hashing the input and checking equality
    public static boolean compare(String hash, String input) throws NoSuchAlgorithmException {
        return hash.equals(cipher(input));
    }

    // Helper method to convert bytes to a hexadecimal string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
