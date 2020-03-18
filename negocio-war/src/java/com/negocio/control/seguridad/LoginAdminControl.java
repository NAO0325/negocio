/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.control.seguridad;

/*
import com.vipduster.facade.entity.PerfilFacade;
import com.vipduster.facade.entity.UsuarioFacade;
import com.vipduster.jpa.pojo.Perfil;
import com.vipduster.jpa.pojo.Persona;
import com.vipduster.jpa.pojo.Usuario;*/
import com.negocio.control.general.FacesUtil;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "loginAdminControl")
@SessionScoped
public class LoginAdminControl implements Serializable {

    /*@EJB
    UsuarioFacade usuarioFacade;
    @EJB
    PerfilFacade perfilFacade;

    Usuario usLog = new Usuario();*/
    boolean successful = false;
    String userName;
    String password;
    //Persona personaTmp;

    public void validaIngreso() {
        successful = false;
        /*usLog = usuarioFacade.buscarByLogin(userName.trim());
        if (usLog == null) {
            FacesUtil.currentInstance().msgError("ALERTA: ", "Usuario no encontrado !");
            return;
        }
        if (!usLog.getIsActivo()) {
            FacesUtil.currentInstance().msgError("ALERTA: ", "Usuario Inactivo!");
            return;
        }
        if (!usLog.getContrasena().equals(HashUtil.md5(password.trim()))) {
            FacesUtil.currentInstance().msgError("ALERTA: ", "Contraseña o usuario incorrecto !");
            return;
        }
        List<Perfil> lstP = perfilFacade.listByUsuario(usLog.getIdusuario());
        if (lstP.isEmpty() && !FacesUtil.currentInstance().isCurrentUserAdmin()) {
            FacesUtil.currentInstance().msgError("ALERTA:", "El usuario no tiene perfiles asignados!");
            return;
        }*/

        successful = true;
    }

    public void salir() {
        //usLog = null;
        successful = false;
    }

    public boolean isSessionValida() {
        /*if (usLog != null && successful) {
            return true;
        }
        return false;*/
        return true;
    }

    public String validaSession() {
        if (!isSessionValida()) {
            FacesUtil.currentInstance().msgError("", "La sesión ha caducado !");
            return "<script type='text/javascript'>document.location.href='" + FacesUtil.currentInstance().getProtocolHostPortContext() + "/app-admin/access.xhtml';</script>";
        }
        return null;
    }

    /*public Usuario getUsLog() {
        return usLog;
    }

    public void setUsLog(Usuario usLog) {
        this.usLog = usLog;
    }*/

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public Persona getPersonaTmp() {
        return personaTmp;
    }

    public void setPersonaTmp(Persona personaTmp) {
        this.personaTmp = personaTmp;
    }*/

}
