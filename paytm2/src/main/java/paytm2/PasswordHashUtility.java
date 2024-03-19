package paytm2;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashUtility {
    public static String hashPassword(String plainPassword, String salt) {
        return BCrypt.hashpw(plainPassword, salt);
    }

    public static String generateSalt() {
        return BCrypt.gensalt();
    }

    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}