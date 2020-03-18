/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.control.general;

import com.negocio.control.seguridad.LoginAdminControl;
import com.negocio.util.EncryptionUtil;
import com.negocio.properties.Propiedad;
import java.net.URLEncoder;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nl.bitwalker.useragentutils.UserAgent;

public class FacesUtil {

    //ParamFacade paramFacade = BeanUtil.lookupFacadeBean(ParamFacade.class);

    FacesContext facesContext;

    private static FacesUtil facesU;

    private FacesUtil(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    public static FacesUtil currentInstance() {
        if (facesU == null) {
            facesU = new FacesUtil(FacesContext.getCurrentInstance());
        }
        return facesU;
    }

    public void redirect(String url) {
        try {
            //facesContext.getCurrentInstance().getExternalContext().redirect(url);
            HttpServletResponse res = (HttpServletResponse) facesContext.getCurrentInstance().getExternalContext().getResponse();
            res.sendRedirect(url);
        } catch (Exception e) {
            System.out.println("FALLA, redireccionando a: " + url + " :: " + e);
            e.printStackTrace();
        }
    }

    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public void redirectLoginEstudiante() {
        redirect(getProtocolHostPortContext() + "/app-estudiante/index.xhtml");
    }

    public void redirectLoginProfesor() {
        redirect(getProtocolHostPortContext() + "/app-profesor/index.xhtml");
    }

    public String getHostClient() {
        HttpServletRequest r_ = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
        return r_.getRemoteAddr();
    }

    public String getHostServer() {
        HttpServletRequest r_ = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
        return r_.getServerName();
    }

    public String getCurrentClient() {
        HttpServletRequest r_ = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
        return r_.getScheme() + "://" + r_.getServerName() + ":" + r_.getServerPort() + r_.getRequestURI();
    }

    private String getHost() {
        HttpServletRequest r_ = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return r_.getServerName();
    }

    private Integer getPort() {
        HttpServletRequest r_ = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return r_.getServerPort();
    }

    private String getPath() {
        HttpServletRequest r_ = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return r_.getContextPath();
    }

    private String getProtocol() {
        HttpServletRequest r_ = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return r_.getScheme();
    }

    public String getPathInfo() {
        HttpServletRequest r_ = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return r_.getPathInfo();
    }

    private String getContext() {
        HttpServletRequest r_ = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return r_.getContextPath() + "/faces";
    }

    private String getHostPortContext() {
        FacesContext fc = facesContext.getCurrentInstance();
        if (fc == null) {
            fc = facesContext;
        }
        HttpServletRequest r_ = (HttpServletRequest) fc.getExternalContext().getRequest();
        return r_.getServerName() + ":" + r_.getServerPort() + r_.getContextPath() + "/faces";
    }

    private String getHostPortPath() {
        FacesContext fc = facesContext.getCurrentInstance();
        if (fc == null) {
            fc = facesContext;
        }
        HttpServletRequest r_ = (HttpServletRequest) fc.getExternalContext().getRequest();
        return r_.getServerName() + ":" + r_.getServerPort() + r_.getContextPath();
    }

    public String getFacesParamValue(String nomParam) {
        FacesContext fc = facesContext.getCurrentInstance();
        if (fc == null) {
            fc = facesContext;
        }
        return fc.getExternalContext().getRequestParameterMap().get(nomParam);
    }

    public Integer getFacesParamInteger(String nomParam) {
        String value = this.getFacesParamValue(nomParam);
        if (value != null) {
            try {
                return Integer.parseInt(value);
            } catch (Exception e) {
                return null;
            }

        } else {
            return null;
        }
    }

    public Long getFacesParamLong(String nomParam) {
        String value = this.getFacesParamValue(nomParam);
        if (value != null) {
            try {
                return Long.parseLong(value);
            } catch (Exception e) {
                return null;
            }

        } else {
            return null;
        }
    }

    public String getCookieValue(String nameCookie) {
        Cookie cook_ = (Cookie) facesContext.getExternalContext().getRequestCookieMap().get(nameCookie);
        if (cook_ != null) {
            return cook_.getValue();
        }
        return null;
    }

    public Object getSessionVar(String nombreVar) {
        return facesContext.getCurrentInstance().getExternalContext().getSessionMap().get(nombreVar);
    }

    public void setSessionVar(String nombreVar, Object valor) {
        facesContext.getCurrentInstance().getExternalContext().getSessionMap().put(nombreVar, valor);
    }

    public void destroySessionVar(String nomVar) {
        facesContext.getExternalContext().getSessionMap().remove(nomVar);
    }

    private void setMsg(String msg) {
        setSessionVar("msg_", msg);
    }

    private int msgCount() {
        if (getSessionVar("msgCount_") == null) {
            return 0;
        }
        return (Integer) getSessionVar("msgCount_");
    }

    private void msgCountRestart() {
        setSessionVar("msgCount_", 0);
    }

    private void msgCountAdd() {
        int n = msgCount() + 1;
        setSessionVar("msgCount_", n);
    }

    private String getMsg() {
        Object o = getSessionVar("msg_");
        if (o != null) {
            return o.toString();
        } else {
            return null;
        }
    }

    private void setMsgTitle(String msg) {
        setSessionVar("msgT_", msg);
    }

    private String getMsgTitle() {
        Object o = getSessionVar("msgT_");
        if (o != null) {
            return o.toString();
        } else {
            return null;
        }
    }

    private void setMsgStyle(String msg) {
        setSessionVar("msgS_", msg);
    }

    private String getMsgStyle() {
        Object o = getSessionVar("msgS_");
        if (o != null) {
            return o.toString();
        } else {
            return null;
        }
    }

    public String getMsgContent() {
        String t = getMsgTitle();
        String m = getMsg();
        if (t == null || t.trim().equals("")) {
            t = "";
        }
        if (m == null || m.trim().equals("")) {
            m = "";
        }
        if (t.isEmpty() && m.isEmpty()) {
            return "";
        }

        msgCountAdd();

        String s = "<div class='" + getMsgStyle() + "'><b>" + t + "</b> " + m + "</div>";

        if (msgCount() > 1) {
            setMsgTitle("");
            setMsg("");
            setMsgStyle("");
            msgCountRestart();
        }
        return s;
    }

    private void msg(String styleClass, String title, String msgContent) {
        setMsgTitle(title);
        setMsg(msgContent);
        setMsgStyle(styleClass);
    }

    public void msgInfo(String title, String msg) {
        msg("info-blue", title, msg);
    }

    public void msgWarning(String title, String msg) {
        msg("info-yellow", title, msg);
    }

    public void msgError(String title, String msg) {
        msg("info-red", title, msg);
    }

    public void msgOk(String title, String msg) {
        msg("info-green", title, msg);
    }

    public String getImgSeguridadHtml() {
        return "<img src='http://" + getHostPortContext() + "/img/peligro.gif'/>";
    }

    public boolean isBrowserFirefox() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest serv = (HttpServletRequest) fc.getExternalContext().getRequest();
        String userAgent = serv.getHeader("User-Agent");
        UserAgent ua = new UserAgent(userAgent);

        String namB = ua.getBrowser().getName();

        if (namB != null && namB.trim().toUpperCase().contains("FIREFOX")) {
            return true;
        } else {
            return false;
        }
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

    private String buildProtocolPortCP(boolean isPath, String protocol, String host, Integer port) {
        String pp;
        if (isPath) {
            pp = getPath();
        } else {
            pp = getContext();
        }
        return protocol + "://" + host + ":" + port + pp;
    }

    private String getProtocolHostPortCP(boolean isPath) {
        String protocol = getProtocol();
        String host = getHost();
        Integer port = getPort();

        return buildProtocolPortCP(isPath, protocol, host, port);
    }

    public String getWsHostPortPath() {
        return "ws://" + getHostPortPath();
    }

    public String getProtocolHostPortContext() {
        return getProtocolHostPortCP(false);
    }

    public String getProtocolHostPortPath() {
        return getProtocolHostPortCP(true);
    }

    public UserAgent getUserAgent() {
        FacesContext fc = facesContext.getCurrentInstance();
        HttpServletRequest serv = (HttpServletRequest) fc.getExternalContext().getRequest();

        //Tomando datos del usuario (IP, Navegador y Sistema operativo)
        String userAgent = serv.getHeader("User-Agent");
        UserAgent ua = new UserAgent(userAgent);
        return ua;
    }

    private LoginAdminControl getLoginAdminControl() {
        return (LoginAdminControl) getSessionVar("loginAdminControl");
    }

    /*public Usuario getCurrentUserAppAdmin() {
        return getLoginAdminControl().getUsLog();
    }

    public Persona getPersonaTmp() {
        return getLoginAdminControl().getPersonaTmp();
    }*/

    public void cerrarSesionAdminApp() {
        getLoginAdminControl().salir();
    }

    /*public Usuario getCurrentUser() {
        return getLoginAdminControl().getUsLog();
    }

    public boolean isCurrentUserAdminAdmin() {
        Usuario us = getCurrentUser();
        if (us.getIdusuario().equals(UsuarioFacade.USUARIO_ADMIN)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isCurrentUserAdmin() {
        if (isCurrentUserAdminAdmin()) {
            return true;
        }
        Usuario us = getCurrentUser();
        GeneralConfig gc = paramFacade.getParamFromCache(GeneralConfig.class);
        if (gc != null && gc.getIdusuarioAdministrador() != null) {
            if (gc.getIdusuarioAdministrador().equals(us.getIdusuario())) {
                return true;
            }
        }

        return false;
    }*/
}
