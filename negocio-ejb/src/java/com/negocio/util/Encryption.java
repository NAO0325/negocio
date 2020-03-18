/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author root
 */
public class Encryption {

    /**
     *
     * @param inputTxt Texto a cifrar
     * @param key Clave de cifrado
     * @return Texto cifrado trasmitible como texto
     */
    public static String encrypt(String inputTxt, String key) {
        return encryptByte(inputTxt, key);
    }

    public static String decrypt(String inputTxt, String key) {
        return decryptByte(inputTxt, key);
    }

    private static String encryptByte(String input, String key) {
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

    private static String decryptByte(String input, String key) {
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

    public static void main(String[] args) {
        //String key = "1234567891234567";
        //String data = "Klartext";
        //System.out.println(Encryption.decrypt(Encryption.encrypt(data, key), key));
        //System.out.println(Encryption.encrypt(data, key));
        System.out.println("E:"+Encryption.decrypt("jvHrGsS9KeFd9puAARvOYA", "U234567XX1234568"));
    }
}
