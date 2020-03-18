/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;
import com.negocio.util.SerialClone;

public class Propiedad implements Serializable {

    Properties propVersion = new Properties();
    Properties propGlobal = new Properties();

    private static Propiedad p = null;

    private Propiedad() {
        try {
            InputStream in = this.getClass().getResourceAsStream("/com/negocio/properties/version.properties");
            propVersion.load(in);
            in.close();

            in = this.getClass().getResourceAsStream("/com/negocio/properties/param.properties");
            propGlobal.load(in);
            in.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static Propiedad getCurrentInstance() {
        if (p == null) {
            p = SerialClone.clone(new Propiedad());
        }
        return p;
    }

    //GLOBAL
    public String getPathTmp() {
        return propGlobal.getProperty("PATH_TMP");
    }

    public String getPathBin() {
        return propGlobal.getProperty("PATH_BIN");
    }

    public String getPathUpload() {
        return propGlobal.getProperty("PATH_UPLOAD_FILE");
        //return paramFacade.getPathUploadFile();
    }

    public String getEncryptAesKey() {
        return propGlobal.getProperty("ENCRYPT_AES_KEY");
    }
    
    public String getHashAdd() {
        return propGlobal.getProperty("HASH_ADD");
    }

    //Informes
    public String getPathInformes() {
        return propGlobal.getProperty("PATH_INFORMES");
    }

    //Informes
    public String getPathLogs() {
        return propGlobal.getProperty("PATH_LOGS");
    }

    public String getOsmGeocodingUrl() {
        return propGlobal.getProperty("OSM_GEOCODING_URL");
    }

    public String getPathFfmpegHome() {
        return propGlobal.getProperty("PATH_FFMPEG_HOME");
    }

    //VERSION
    public String getVersion() {
        return propVersion.getProperty("VERSION");
    }

    public String getVersionUpdated() {
        return propVersion.getProperty("VERSION_UPDATED");
    }

    public static void main(String args[]) {
        System.out.println("PARAM=" + Propiedad.getCurrentInstance().getPathTmp() + ";" + Propiedad.getCurrentInstance().getVersion());
    }
}
