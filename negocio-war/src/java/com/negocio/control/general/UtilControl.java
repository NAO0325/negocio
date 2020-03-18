/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.control.general;

import com.negocio.properties.Propiedad;
import com.negocio.util.Cadena;
import com.negocio.util.EncodeDecode;
import com.negocio.util.EncryptionUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class UtilControl {

    FacesUtil facesUtil = FacesUtil.currentInstance();
    String value;

    /**
     * Creates a new instance of UtilControl
     */
    public UtilControl() {
    }

    public String getWsHostPortPath() {
        return facesUtil.getWsHostPortPath();
    }

    public String getCurrentUrl() {
        return facesUtil.getCurrentClient();
    }

    public Long getCurrentTime() {
        return new Date().getTime();
    }


    public Date getCurrentDate2() {
        return new Date();
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getModalBoxWidth() {
        String w_ = "";
        String src_ = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("item_");

        String[] arrSrc = src_.trim().split("@");
        for (int i = 0; i < arrSrc.length; i++) {
            String[] var = arrSrc[i].split("=");
            if (var[0].trim().compareTo("w_") == 0) {
                w_ = var[1];
                break;
            }
        }
        return w_;
    }

    public String getModalBoxHeight() {
        String h_ = "";
        String src_ = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("item_");

        String[] arrSrc = src_.trim().split("@");
        for (int i = 0; i < arrSrc.length; i++) {
            String[] var = arrSrc[i].split("=");
            if (var[0].trim().compareTo("h_") == 0) {
                h_ = var[1];
                break;
            }
        }
        return h_;
    }

    public String getModalBoxScr() {
        String src_ = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("item_");
        src_ = src_.replaceFirst("@", "?");
        src_ = src_.replaceAll("@", "&");
        return src_;
    }

    public String getMenorQue() {
        return "<";
    }

    public String getMayorQue() {
        return ">";
    }

    public String getMenorIgualQue() {
        return "<=";
    }

    public String getMayorIgualQue() {
        return ">=";
    }

    public String getCharAmpersand() {
        return "&";
    }

    public String getChar_Atilde() {
        return "Á";
    }

    public String getChar_Etilde() {
        return "É";
    }

    public String getChar_Itilde() {
        return "Í";
    }

    public String getChar_Otilde() {
        return "Ó";
    }

    public String getChar_Utilde() {
        return "Ú";
    }

    public String getChar_atilde() {
        return "á";
    }

    public String getChar_etilde() {
        return "é";
    }

    public String getChar_itilde() {
        return "í";
    }

    public String getChar_otilde() {
        return "ó";
    }

    public String getChar_utilde() {
        return "ú";
    }

    public String getCharAtilde() {
        return "Á";
    }

    public String getCharEtilde() {
        return "É";
    }

    public String getCharItilde() {
        return "Í";
    }

    public String getCharOtilde() {
        return "Ó";
    }

    public String getChar_Ntilde() {
        return "Ñ";
    }

    public String getChar_ntilde() {
        return "ñ";
    }

    public String getCharNumeral() {
        return "#";
    }
    String tmp = "";

    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }

    public String getMsg() {
        String msgRequest = facesUtil.getFacesParamValue("msg_");
        String msgErrRequest = facesUtil.getFacesParamValue("msgErr_");
        if (msgRequest != null && !msgRequest.trim().equals("")) {
            facesUtil.msgOk("", msgRequest);
        }
        if (msgErrRequest != null && !msgErrRequest.trim().equals("")) {
            facesUtil.msgError("", msgErrRequest);
        }

        return facesUtil.getMsgContent();
    }

    public String cambiarFecha() {
        String s = null;
        try {
            String comando = "date -s" + tmp;
            Process p = Runtime.getRuntime().exec(comando);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(
                    p.getErrorStream()));

            String sa = "";

            // Leemos la salida del comando
            while ((s = stdInput.readLine()) != null) {
                sa += s;
            }

            // Leemos los errores si los hubiera
            while ((s = stdError.readLine()) != null) {
                sa += s;
            }
            //msg = "Fecha cambiada a: " + tmp + "<br/><br/><i style='color:gray'>" + sa + "</i>";
        } catch (Exception e) {
            e.printStackTrace();
            //msg = e.toString();
        }
        return null;
    }

    public String maxCharacter(String txt, int maxCh) {
        if (txt == null) {
            return "";
        }
        if (maxCh >= txt.trim().length()) {
            maxCh = txt.trim().length();
        }
        return txt.trim().substring(0, maxCh);
    }

    /*public String urlServlet(String path) {
        return Archivo.getURLServlet(path, getProtocolHostPortContext());
    }

    public String urlServlet(String path, String nombreDw) {
        return Archivo.getURLServlet(path, getProtocolHostPortContext(), nombreDw);
    }

    public String urlServlet2(String path) {
        return Archivo.getURLServlet2(path, getProtocolHostPortContext());
    }*/

    public String returnPar(int i, String valReturn) {
        if (i % 2 == 0) {
            return valReturn;
        } else {
            return "";
        }
    }

    public String num2Letra(int num) {
        return genNum2Letra(num);
    }

    /*public String numToLetras(double num) {
        return new Num2Letras().toLetras(Math.round(num));
    }*/

    public static String genNum2Letra(int num) {
        String al = "abcdefghijklmnñopqrstuvwxyz";
        if (num >= 0 && num < al.length()) {
            return al.charAt(num) + "";
        }
        return null;
    }

    public String encode(String key) {
        return new EncodeDecode().encode(key);
    }

    public String decode(String code) {
        return new EncodeDecode().decode(code);
    }

    public String bytesToHumanLong(long bytes) {
        return bytesToHuman(bytes + "");
    }

    public String bytesToHuman(String bytes) {
        if (bytes == null || bytes.trim().equals("")) {
            return "0B";
        }
        return Cadena.bytesToHuman(Long.parseLong(bytes), true);
    }

    public String nomArchivo(String path) {
        File f = new File(path);
        return f.getName();
    }

    /*public String fileIconFontAwesonme(String pathCrypt, int size) {
        return Archivo.fileIconFontAwesonme(new File(EncryptionUtil.decryptAES(pathCrypt, Propiedad.getCurrentInstance().getEncryptAesKey())), size);
    }

    public boolean fileIsImg(String pathCrypt) {
        return Archivo.fileIsImg(new File(EncryptionUtil.decryptAES(pathCrypt, Propiedad.getCurrentInstance().getEncryptAesKey())));
    }*/

    public String concat(String s1, String s2) {
        return s1 + s2;
    }

    public String encrypt(String str) {
        String se = EncryptionUtil.encryptAES(str, Propiedad.getCurrentInstance().getEncryptAesKey());
        try {
            se = URLEncoder.encode(se, "UTF8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return se;
    }

    public String decrypt(String str) {
        return EncryptionUtil.decryptAES(str, Propiedad.getCurrentInstance().getEncryptAesKey());
    }

    public Date fechaFromTime(long time) {
        return new Date(time);
    }

    public Date fechaHoraActual() {
        return new Date();
    }

    public long time() {
        return new Date().getTime();
    }

    public double getDouble(String val) {
        return new Double(val);
    }

    public boolean isBrowserFirefox() {
        return facesUtil.isBrowserFirefox();
    }

    public String getProtocolHostPortContext() {
        return facesUtil.getProtocolHostPortContext();
    }

    public String getProtocolHostPortPath() {
        return facesUtil.getProtocolHostPortPath();
    }
}
