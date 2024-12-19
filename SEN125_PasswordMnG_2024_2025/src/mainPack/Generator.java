package mainPack;

import java.util.Random;

public class Generator {

    public String generatePassword(int length, boolean includeUppercase, boolean includeDigits, boolean includeSpecial) {
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String special = "!@#$%^&*()-_=+<>?/";

        StringBuilder characterPool = new StringBuilder(lowerCase);
        if (includeUppercase) {
            characterPool.append(upperCase);
        }
        if (includeDigits) {
            characterPool.append(digits);
        }
        if (includeSpecial) {
            characterPool.append(special);
        }

        if (characterPool.length() == 0) {
            throw new IllegalArgumentException("No character sets selected for password generation.");
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }
}