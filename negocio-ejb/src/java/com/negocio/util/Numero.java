/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author root
 */
public class Numero {

    public static double redondear(double numero, int digitos) {
        String tmp = String.format("%." + digitos + "f", numero);
        tmp = tmp.replace(',', '.');

        return Double.parseDouble(tmp);
    }

    public static double truncar(double numero, int digitos) {
        BigDecimal tmp = new BigDecimal(numero);
        BigDecimal tmp2 = new BigDecimal(numero + "");

        //System.out.println("tmp: " + tmp + " / tmp2: " + tmp2);
        tmp = tmp2.setScale(digitos, RoundingMode.DOWN);
        double result = tmp.doubleValue();
        return result;
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("[-+]?\\d*\\.?\\d+");
    }

    public static boolean isImpar(int num) {
        if (num % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Numero app = new Numero();

        double num = 4.3;
        int digitos = 1;

        double resultado = app.redondear(num, digitos);
        double resultado2 = app.truncar(num, digitos);

        System.out.println("Numero: " + num);
        System.out.println("Digitos: " + digitos);
        System.out.println("Redondeado: " + resultado);
        System.out.println("Truncado: " + resultado2);
        System.out.println("Impar: " + isImpar(digitos));
    }
}
