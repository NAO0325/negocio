/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.util;

/**
 *
 * @author root
 */
public class EncodeDecode {

    public int encode(int x) {
        return (x ^ 15485863); //1.000.000th prime
    }

    public int decode(int x) {
        return (x ^ 15485863);
    }

    public String encode(String val) {
        return new Base64().encode(val);
    }

    public String decode(String val) {
        try {
            byte[] by = new Base64().decode(val);
            String cad = "";
            for (int i = 0; i < by.length; i++) {
                cad += (char) by[i];
            }
            return cad.trim();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public static void main(String[] args) {
        String val = "789456123";
        String code = new EncodeDecode().encode(val);
        String decode = new EncodeDecode().decode(code);
        System.out.println("CODIFICANDO '" + val + "' => " + code);
        System.out.println("DECODIFICANDO '" + code + "'=>" + decode);

        int val2 = 0;
        int code2 = new EncodeDecode().encode(val2);
        int decode2 = new EncodeDecode().decode(code2);

        System.out.println("CODIFICANDO '" + val2 + "' => " + code2);
        System.out.println("DECODIFICANDO '" + code2 + "'=>" + decode2);
    }
}
