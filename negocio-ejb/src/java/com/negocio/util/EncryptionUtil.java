package com.negocio.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;


public class EncryptionUtil {

    /**
     *
     * @param inputTxt Texto a cifrar
     * @param key Clave de cifrado
     * @return Texto cifrado trasmitible como texto
     */
    public static String encryptAES(String inputTxt, String key) {
        return encryptByteAES(inputTxt, key);
    }

    public static String decryptAES(String inputTxt, String key) {
        return decryptByteAES(inputTxt, key);
    }

    private static String encryptByteAES(String input, String key) {
        byte[] crypted = null;
        try {
            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            crypted = cipher.doFinal(input.getBytes());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return new String(Base64.encodeBase64URLSafe(crypted));
    }

    private static String decryptByteAES(String input, String key) {
        byte[] output = null;
        try {
            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skey);
            output = cipher.doFinal(org.apache.commons.codec.binary.Base64.decodeBase64(input));
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
        return new String(output);
    }

}
