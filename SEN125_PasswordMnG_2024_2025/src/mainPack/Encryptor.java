package mainPack;

import java.security.MessageDigest;
import java.security.SecureRandom;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;
import java.util.Base64;

public class Encryptor {
    private static final Base64.Encoder encoder = Base64.getEncoder();
    private static final Base64.Decoder decoder = Base64.getDecoder();

    public static String cipher(String password) throws Exception {
        byte[] salt = generateSalt();
        SecretKeySpec key = new SecretKeySpec(getKeyFromPassword(password, salt), "AES");
        return encoder.encodeToString(key.getEncoded()) + encoder.encodeToString(salt);
    }

    public static boolean compare(String hashed, String input) {
        try {
            int separatorIndex = hashed.indexOf("=");
            String saltBase64 = hashed.substring(separatorIndex + 1);
            byte[] salt = decoder.decode(saltBase64);
            SecretKeySpec keyFromInput = new SecretKeySpec(getKeyFromPassword(input, salt), "AES");
            String inputHash = encoder.encodeToString(keyFromInput.getEncoded()) + saltBase64;
            return hashed.equals(inputHash);
        } catch (Exception e) {
            return false;
        }
    }

    private static byte[] getKeyFromPassword(String password, byte[] salt) throws Exception {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        return factory.generateSecret(spec).getEncoded();
    }

    private static byte[] generateSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return salt;
    }
}
