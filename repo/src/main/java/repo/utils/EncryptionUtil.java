package repo.utils;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

/**
 * Created by Jandie on 14-Jun-17.
 */
public class EncryptionUtil {
    public static String encrypt(String password, String secret) {
        String salt = "da2516082ee5d006";

        TextEncryptor encryptor = Encryptors.text(password, salt);
        String encryptedText = encryptor.encrypt(secret);

        return encryptedText;
    }

    public static String decrypt(String password, String secret) {
        String salt = "da2516082ee5d006";

        TextEncryptor decryptor = Encryptors.text(password, salt);
        String decryptedText = decryptor.decrypt(secret);

        return decryptedText;
    }
}
