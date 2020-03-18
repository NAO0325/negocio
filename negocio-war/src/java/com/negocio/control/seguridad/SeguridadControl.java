package com.negocio.control.seguridad;

/*import com.vipduster.config.ParamFacade;
import com.vipduster.config.pojoaux.GeneralConfig;
import com.vipduster.control.general.FacesUtil;
import com.vipduster.facade.entity.UsuarioFacade;
import com.vipduster.jpa.pojo.Usuario;*/
import com.negocio.control.general.FacesUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Edwar Rojas - edwar.red@gmail.com
 */
@ManagedBean(name = "seguridadControl")
@RequestScoped
public class SeguridadControl {

    /*    @EJB
    SecurityFacade securityFacade;
    @EJB
    ParamFacade paramFacade;*/
    FacesUtil facesUtil = FacesUtil.currentInstance();

    private boolean isPermiso(int idFunc) {
        /*Usuario us = facesUtil.getCurrentUser();
        if (us != null && us.getIdusuario() != null) {
            return securityFacade.isFuncAutorizada(us.getIdusuario(), idFunc);
        }
        return false;*/
        return true;
    }

    private String getValidaPermiso(int idFunc) {
        if (isPermiso(idFunc)) {
            return null;
        } else {
            return noAccess();
        }

    }

    private String noAccess() {
        facesUtil.cerrarSesionAdminApp();
        return "<script tyle='text/javascript'>document.location.href='" + facesUtil.getProtocolHostPortContext() + "/app-admin/access.xhtml';</script>";
    }

    /*public boolean isPermisoAdmin() {
        if (isPermisoAdminAdmin()) {
            return true;
        }
        Usuario us = facesUtil.getCurrentUser();
        if (us != null && us.getIdusuario() != null) {
            GeneralConfig gc = paramFacade.getParamFromCache(GeneralConfig.class);
            if (gc != null && gc.getIdusuarioAdministrador() != null) {
                if (gc.getIdusuarioAdministrador().equals(us.getIdusuario())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isPermisoAdminAdmin() {
        Usuario us = facesUtil.getCurrentUser();
        if (us != null && us.getIdusuario() != null) {
            if (us.getIdusuario().equals(UsuarioFacade.USUARIO_ADMIN)) {
                return true;
            }
        }
        return false;
    }

    public String getValidaPermisoAdmin() {
        if (isPermisoAdmin()) {
            return null;
        } else {
            return noAccess();
        }
    }

    public String getValidaPermisoAdminAdmin() {
        if (isPermisoAdminAdmin()) {
            return null;
        } else {
            return noAccess();
        }
    }*/
    //PERMISOS 
    public boolean isPermiso_7916() {
        return isPermiso(7916);
    }

    public String getValidaPermiso_7916() {
        return getValidaPermiso(7916);
    }

    public boolean isPermiso_7917() {
        return isPermiso(7917);
    }

    public String getValidaPermiso_7917() {
        return getValidaPermiso(7917);
    }

    public boolean isPermiso_7918() {
        return isPermiso(7918);
    }

    public String getValidaPermiso_7918() {
        return getValidaPermiso(7918);
    }

    public boolean isPermiso_7919() {
        return isPermiso(7919);
    }

    public String getValidaPermiso_7919() {
        return getValidaPermiso(7919);
    }

    public boolean isPermiso_7920() {
        return isPermiso(7920);
    }

    public String getValidaPermiso_7920() {
        return getValidaPermiso(7920);
    }

    public boolean isPermiso_7921() {
        return isPermiso(7921);
    }

    public String getValidaPermiso_7921() {
        return getValidaPermiso(7921);
    }

    public boolean isPermiso_7922() {
        return isPermiso(7922);
    }

    public String getValidaPermiso_7922() {
        return getValidaPermiso(7922);
    }

    public boolean isPermiso_7923() {
        return isPermiso(7923);
    }

    public String getValidaPermiso_7923() {
        return getValidaPermiso(7923);
    }

    public boolean isPermiso_7924() {
        return isPermiso(7924);
    }

    public String getValidaPermiso_7924() {
        return getValidaPermiso(7924);
    }

    public boolean isPermiso_7925() {
        return isPermiso(7925);
    }

    public String getValidaPermiso_7925() {
        return getValidaPermiso(7925);
    }

    public boolean isPermiso_7926() {
        return isPermiso(7926);
    }

    public String getValidaPermiso_7926() {
        return getValidaPermiso(7926);
    }

    public boolean isPermiso_7927() {
        return isPermiso(7927);
    }

    public String getValidaPermiso_7927() {
        return getValidaPermiso(7927);
    }

    public boolean isPermiso_7928() {
        return isPermiso(7928);
    }

    public String getValidaPermiso_7928() {
        return getValidaPermiso(7928);
    }

    public boolean isPermiso_7929() {
        return isPermiso(7929);
    }

    public String getValidaPermiso_7929() {
        return getValidaPermiso(7929);
    }

    public boolean isPermiso_7930() {
        return isPermiso(7930);
    }

    public String getValidaPermiso_7930() {
        return getValidaPermiso(7930);
    }

    public boolean isPermiso_7931() {
        return isPermiso(7931);
    }

    public String getValidaPermiso_7931() {
        return getValidaPermiso(7931);
    }

    public boolean isPermiso_7932() {
        return isPermiso(7932);
    }

    public String getValidaPermiso_7932() {
        return getValidaPermiso(7932);
    }

    public boolean isPermiso_7933() {
        return isPermiso(7933);
    }

    public String getValidaPermiso_7933() {
        return getValidaPermiso(7933);
    }

    public boolean isPermiso_7934() {
        return isPermiso(7934);
    }

    public String getValidaPermiso_7934() {
        return getValidaPermiso(7934);
    }

    public boolean isPermiso_7935() {
        return isPermiso(7935);
    }

    public String getValidaPermiso_7935() {
        return getValidaPermiso(7935);
    }

    public boolean isPermiso_7937() {
        return isPermiso(7937);
    }

    public String getValidaPermiso_7937() {
        return getValidaPermiso(7937);
    }

    public boolean isPermiso_7938() {
        return isPermiso(7938);
    }

    public String getValidaPermiso_7938() {
        return getValidaPermiso(7938);
    }

    public boolean isPermiso_7939() {
        return isPermiso(7939);
    }

    public String getValidaPermiso_7939() {
        return getValidaPermiso(7939);
    }

    public boolean isPermiso_7940() {
        return isPermiso(7940);
    }

    public String getValidaPermiso_7940() {
        return getValidaPermiso(7940);
    }

    public boolean isPermiso_7941() {
        return isPermiso(7941);
    }

    public String getValidaPermiso_7941() {
        return getValidaPermiso(7941);
    }

    public boolean isPermiso_7942() {
        return isPermiso(7942);
    }

    public String getValidaPermiso_7942() {
        return getValidaPermiso(7942);
    }

    public boolean isPermiso_7943() {
        return isPermiso(7943);
    }

    public String getValidaPermiso_7943() {
        return getValidaPermiso(7943);
    }

    public boolean isPermiso_7944() {
        return isPermiso(7944);
    }

    public String getValidaPermiso_7944() {
        return getValidaPermiso(7944);
    }

    public boolean isPermiso_7945() {
        return isPermiso(7945);
    }

    public String getValidaPermiso_7945() {
        return getValidaPermiso(7945);
    }

    public boolean isPermiso_7946() {
        return isPermiso(7946);
    }

    public String getValidaPermiso_7946() {
        return getValidaPermiso(7946);
    }

    public boolean isPermiso_7947() {
        return isPermiso(7947);
    }

    public String getValidaPermiso_7947() {
        return getValidaPermiso(7947);
    }

    public boolean isPermiso_7948() {
        return isPermiso(7948);
    }

    public String getValidaPermiso_7948() {
        return getValidaPermiso(7948);
    }

    public boolean isPermiso_7949() {
        return isPermiso(7949);
    }

    public String getValidaPermiso_7949() {
        return getValidaPermiso(7949);
    }

    public boolean isPermiso_7950() {
        return isPermiso(7950);
    }

    public String getValidaPermiso_7950() {
        return getValidaPermiso(7950);
    }

    public boolean isPermiso_7951() {
        return isPermiso(7951);
    }

    public String getValidaPermiso_7951() {
        return getValidaPermiso(7951);
    }

    public boolean isPermiso_7952() {
        return isPermiso(7952);
    }

    public String getValidaPermiso_7952() {
        return getValidaPermiso(7952);
    }

    public boolean isPermiso_7953() {
        return isPermiso(7953);
    }

    public String getValidaPermiso_7953() {
        return getValidaPermiso(7953);
    }

    public boolean isPermiso_7954() {
        return isPermiso(7954);
    }

    public String getValidaPermiso_7954() {
        return getValidaPermiso(7954);
    }

    public boolean isPermiso_7955() {
        return isPermiso(7955);
    }

    public String getValidaPermiso_7955() {
        return getValidaPermiso(7955);
    }

    public boolean isPermiso_7956() {
        return isPermiso(7956);
    }

    public String getValidaPermiso_7956() {
        return getValidaPermiso(7956);
    }

    public boolean isPermiso_7957() {
        return isPermiso(7957);
    }

    public String getValidaPermiso_7957() {
        return getValidaPermiso(7957);
    }

    public boolean isPermiso_7958() {
        return isPermiso(7958);
    }

    public String getValidaPermiso_7958() {
        return getValidaPermiso(7958);
    }

    public boolean isPermiso_7959() {
        return isPermiso(7959);
    }

    public String getValidaPermiso_7959() {
        return getValidaPermiso(7959);
    }

    public boolean isPermiso_7960() {
        return isPermiso(7960);
    }

    public String getValidaPermiso_7960() {
        return getValidaPermiso(7960);
    }

    public boolean isPermiso_7961() {
        return isPermiso(7961);
    }

    public String getValidaPermiso_7961() {
        return getValidaPermiso(7961);
    }

    public boolean isPermiso_7962() {
        return isPermiso(7962);
    }

    public String getValidaPermiso_7962() {
        return getValidaPermiso(7962);
    }

    public boolean isPermiso_7963() {
        return isPermiso(7963);
    }

    public String getValidaPermiso_7963() {
        return getValidaPermiso(7963);
    }

    public boolean isPermiso_7964() {
        return isPermiso(7964);
    }

    public String getValidaPermiso_7964() {
        return getValidaPermiso(7964);
    }

    public boolean isPermiso_7965() {
        return isPermiso(7965);
    }

    public String getValidaPermiso_7965() {
        return getValidaPermiso(7965);
    }

    public boolean isPermiso_7966() {
        return isPermiso(7966);
    }

    public String getValidaPermiso_7966() {
        return getValidaPermiso(7966);
    }

    public boolean isPermiso_7967() {
        return isPermiso(7967);
    }

    public String getValidaPermiso_7967() {
        return getValidaPermiso(7967);
    }

    public boolean isPermiso_7968() {
        return isPermiso(7968);
    }

    public String getValidaPermiso_7968() {
        return getValidaPermiso(7968);
    }

    public boolean isPermiso_7969() {
        return isPermiso(7969);
    }

    public String getValidaPermiso_7969() {
        return getValidaPermiso(7969);
    }

    public boolean isPermiso_7970() {
        return isPermiso(7970);
    }

    public String getValidaPermiso_7970() {
        return getValidaPermiso(7970);
    }

    public boolean isPermiso_7971() {
        return isPermiso(7971);
    }

    public String getValidaPermiso_7971() {
        return getValidaPermiso(7971);
    }

    public boolean isPermiso_7972() {
        return isPermiso(7972);
    }

    public String getValidaPermiso_7972() {
        return getValidaPermiso(7972);
    }

    public boolean isPermiso_7973() {
        return isPermiso(7973);
    }

    public String getValidaPermiso_7973() {
        return getValidaPermiso(7973);
    }

    public boolean isPermiso_7974() {
        return isPermiso(7974);
    }

    public String getValidaPermiso_7974() {
        return getValidaPermiso(7974);
    }

    public boolean isPermiso_7975() {
        return isPermiso(7975);
    }

    public String getValidaPermiso_7975() {
        return getValidaPermiso(7975);
    }

    public boolean isPermiso_7976() {
        return isPermiso(7976);
    }

    public String getValidaPermiso_7976() {
        return getValidaPermiso(7976);
    }

    public boolean isPermiso_7977() {
        return isPermiso(7977);
    }

    public String getValidaPermiso_7977() {
        return getValidaPermiso(7977);
    }

    public boolean isPermiso_7978() {
        return isPermiso(7978);
    }

    public String getValidaPermiso_7978() {
        return getValidaPermiso(7978);
    }

    public boolean isPermiso_7979() {
        return isPermiso(7979);
    }

    public String getValidaPermiso_7979() {
        return getValidaPermiso(7979);
    }

    public boolean isPermiso_7980() {
        return isPermiso(7980);
    }

    public String getValidaPermiso_7980() {
        return getValidaPermiso(7980);
    }

    public boolean isPermiso_7981() {
        return isPermiso(7981);
    }

    public String getValidaPermiso_7981() {
        return getValidaPermiso(7981);
    }

    public boolean isPermiso_7982() {
        return isPermiso(7982);
    }

    public String getValidaPermiso_7982() {
        return getValidaPermiso(7982);
    }

    public boolean isPermiso_7983() {
        return isPermiso(7983);
    }

    public String getValidaPermiso_7983() {
        return getValidaPermiso(7983);
    }

    public boolean isPermiso_7984() {
        return isPermiso(7984);
    }

    public String getValidaPermiso_7984() {
        return getValidaPermiso(7984);
    }

    public boolean isPermiso_7985() {
        return isPermiso(7985);
    }

    public String getValidaPermiso_7985() {
        return getValidaPermiso(7985);
    }

    public boolean isPermiso_7986() {
        return isPermiso(7986);
    }

    public String getValidaPermiso_7986() {
        return getValidaPermiso(7986);
    }

    public boolean isPermiso_7987() {
        return isPermiso(7987);
    }

    public String getValidaPermiso_7987() {
        return getValidaPermiso(7987);
    }

    public boolean isPermiso_7988() {
        return isPermiso(7988);
    }

    public String getValidaPermiso_7988() {
        return getValidaPermiso(7988);
    }

    public boolean isPermiso_7989() {
        return isPermiso(7989);
    }

    public String getValidaPermiso_7989() {
        return getValidaPermiso(7989);
    }

    public boolean isPermiso_7990() {
        return isPermiso(7990);
    }

    public String getValidaPermiso_7990() {
        return getValidaPermiso(7990);
    }

    public boolean isPermiso_7991() {
        return isPermiso(7991);
    }

    public String getValidaPermiso_7991() {
        return getValidaPermiso(7991);
    }

    public boolean isPermiso_7992() {
        return isPermiso(7992);
    }

    public String getValidaPermiso_7992() {
        return getValidaPermiso(7992);
    }

    public boolean isPermiso_7993() {
        return isPermiso(7993);
    }

    public String getValidaPermiso_7993() {
        return getValidaPermiso(7993);
    }

    public boolean isPermiso_7994() {
        return isPermiso(7994);
    }

    public String getValidaPermiso_7994() {
        return getValidaPermiso(7994);
    }

    public boolean isPermiso_7995() {
        return isPermiso(7995);
    }

    public String getValidaPermiso_7995() {
        return getValidaPermiso(7995);
    }

    public boolean isPermiso_7996() {
        return isPermiso(7996);
    }

    public String getValidaPermiso_7996() {
        return getValidaPermiso(7996);
    }

    public boolean isPermiso_7997() {
        return isPermiso(7997);
    }

    public String getValidaPermiso_7997() {
        return getValidaPermiso(7997);
    }

    public boolean isPermiso_7998() {
        return isPermiso(7998);
    }

    public String getValidaPermiso_7998() {
        return getValidaPermiso(7998);
    }

    public boolean isPermiso_7999() {
        return isPermiso(7999);
    }

    public String getValidaPermiso_7999() {
        return getValidaPermiso(7999);
    }

    public boolean isPermiso_8000() {
        return isPermiso(8000);
    }

    public String getValidaPermiso_8000() {
        return getValidaPermiso(8000);
    }

    public boolean isPermiso_8001() {
        return isPermiso(8001);
    }

    public String getValidaPermiso_8001() {
        return getValidaPermiso(8001);
    }

    public boolean isPermiso_8002() {
        return isPermiso(8002);
    }

    public String getValidaPermiso_8002() {
        return getValidaPermiso(8002);
    }

    public boolean isPermiso_8003() {
        return isPermiso(8003);
    }

    public String getValidaPermiso_8003() {
        return getValidaPermiso(8003);
    }

    public boolean isPermiso_8004() {
        return isPermiso(8004);
    }

    public String getValidaPermiso_8004() {
        return getValidaPermiso(8004);
    }

    public boolean isPermiso_8005() {
        return isPermiso(8005);
    }

    public String getValidaPermiso_8005() {
        return getValidaPermiso(8005);
    }

    public boolean isPermiso_8006() {
        return isPermiso(8006);
    }

    public String getValidaPermiso_8006() {
        return getValidaPermiso(8006);
    }

    public boolean isPermiso_8007() {
        return isPermiso(8007);
    }

    public String getValidaPermiso_8007() {
        return getValidaPermiso(8007);
    }

    public boolean isPermiso_8008() {
        return isPermiso(8008);
    }

    public String getValidaPermiso_8008() {
        return getValidaPermiso(8008);
    }

    public boolean isPermiso_8009() {
        return isPermiso(8009);
    }

    public String getValidaPermiso_8009() {
        return getValidaPermiso(8009);
    }

    public boolean isPermiso_8010() {
        return isPermiso(8010);
    }

    public String getValidaPermiso_8010() {
        return getValidaPermiso(8010);
    }

    public boolean isPermiso_8011() {
        return isPermiso(8011);
    }

    public String getValidaPermiso_8011() {
        return getValidaPermiso(8011);
    }

    public boolean isPermiso_8012() {
        return isPermiso(8012);
    }

    public String getValidaPermiso_8012() {
        return getValidaPermiso(8012);
    }

    public boolean isPermiso_8013() {
        return isPermiso(8013);
    }

    public String getValidaPermiso_8013() {
        return getValidaPermiso(8013);
    }

    public boolean isPermiso_8014() {
        return isPermiso(8014);
    }

    public String getValidaPermiso_8014() {
        return getValidaPermiso(8014);
    }

    public boolean isPermiso_8015() {
        return isPermiso(8015);
    }

    public String getValidaPermiso_8015() {
        return getValidaPermiso(8015);
    }

    public boolean isPermiso_8016() {
        return isPermiso(8016);
    }

    public String getValidaPermiso_8016() {
        return getValidaPermiso(8016);
    }

    public boolean isPermiso_8017() {
        return isPermiso(8017);
    }

    public String getValidaPermiso_8017() {
        return getValidaPermiso(8017);
    }

    public boolean isPermiso_8018() {
        return isPermiso(8018);
    }

    public String getValidaPermiso_8018() {
        return getValidaPermiso(8018);
    }

    public boolean isPermiso_8019() {
        return isPermiso(8019);
    }

    public String getValidaPermiso_8019() {
        return getValidaPermiso(8019);
    }

    public boolean isPermiso_8020() {
        return isPermiso(8020);
    }

    public String getValidaPermiso_8020() {
        return getValidaPermiso(8020);
    }

    public boolean isPermiso_8021() {
        return isPermiso(8021);
    }

    public String getValidaPermiso_8021() {
        return getValidaPermiso(8021);
    }

    public boolean isPermiso_8022() {
        return isPermiso(8022);
    }

    public String getValidaPermiso_8022() {
        return getValidaPermiso(8022);
    }

    public boolean isPermiso_8023() {
        return isPermiso(8023);
    }

    public String getValidaPermiso_8023() {
        return getValidaPermiso(8023);
    }

    public boolean isPermiso_8024() {
        return isPermiso(8024);
    }

    public String getValidaPermiso_8024() {
        return getValidaPermiso(8024);
    }

    public boolean isPermiso_8025() {
        return isPermiso(8025);
    }

    public String getValidaPermiso_8025() {
        return getValidaPermiso(8025);
    }

    public boolean isPermiso_8026() {
        return isPermiso(8026);
    }

    public String getValidaPermiso_8026() {
        return getValidaPermiso(8026);
    }

    public boolean isPermiso_8027() {
        return isPermiso(8027);
    }

    public String getValidaPermiso_8027() {
        return getValidaPermiso(8027);
    }

    public boolean isPermiso_8028() {
        return isPermiso(8028);
    }

    public String getValidaPermiso_8028() {
        return getValidaPermiso(8028);
    }

    public boolean isPermiso_8029() {
        return isPermiso(8029);
    }

    public String getValidaPermiso_8029() {
        return getValidaPermiso(8029);
    }

    public boolean isPermiso_8030() {
        return isPermiso(8030);
    }

    public String getValidaPermiso_8030() {
        return getValidaPermiso(8030);
    }

    public boolean isPermiso_8031() {
        return isPermiso(8031);
    }

    public String getValidaPermiso_8031() {
        return getValidaPermiso(8031);
    }

    public boolean isPermiso_8032() {
        return isPermiso(8032);
    }

    public String getValidaPermiso_8032() {
        return getValidaPermiso(8032);
    }

    public boolean isPermiso_8033() {
        return isPermiso(8033);
    }

    public String getValidaPermiso_8033() {
        return getValidaPermiso(8033);
    }

    public boolean isPermiso_8034() {
        return isPermiso(8034);
    }

    public String getValidaPermiso_8034() {
        return getValidaPermiso(8034);
    }

    public boolean isPermiso_8035() {
        return isPermiso(8035);
    }

    public String getValidaPermiso_8035() {
        return getValidaPermiso(8035);
    }

    public boolean isPermiso_8036() {
        return isPermiso(8036);
    }

    public String getValidaPermiso_8036() {
        return getValidaPermiso(8036);
    }

    public boolean isPermiso_8037() {
        return isPermiso(8037);
    }

    public String getValidaPermiso_8037() {
        return getValidaPermiso(8037);
    }

    public boolean isPermiso_8038() {
        return isPermiso(8038);
    }

    public String getValidaPermiso_8038() {
        return getValidaPermiso(8038);
    }

    public boolean isPermiso_8046() {
        return isPermiso(8046);
    }

    public String getValidaPermiso_8046() {
        return getValidaPermiso(8046);
    }

    public boolean isPermiso_8047() {
        return isPermiso(8047);
    }

    public String getValidaPermiso_8047() {
        return getValidaPermiso(8047);
    }

    public boolean isPermiso_8048() {
        return isPermiso(8048);
    }

    public String getValidaPermiso_8048() {
        return getValidaPermiso(8048);
    }

    public boolean isPermiso_8049() {
        return isPermiso(8049);
    }

    public String getValidaPermiso_8049() {
        return getValidaPermiso(8049);
    }

    public boolean isPermiso_8050() {
        return isPermiso(8050);
    }

    public String getValidaPermiso_8050() {
        return getValidaPermiso(8050);
    }

    public boolean isPermiso_8051() {
        return isPermiso(8051);
    }

    public String getValidaPermiso_8051() {
        return getValidaPermiso(8051);
    }

    public boolean isPermiso_8052() {
        return isPermiso(8052);
    }

    public String getValidaPermiso_8052() {
        return getValidaPermiso(8052);
    }

    public boolean isPermiso_8053() {
        return isPermiso(8053);
    }

    public String getValidaPermiso_8053() {
        return getValidaPermiso(8053);
    }

    public boolean isPermiso_8054() {
        return isPermiso(8054);
    }

    public String getValidaPermiso_8054() {
        return getValidaPermiso(8054);
    }

    public boolean isPermiso_8055() {
        return isPermiso(8055);
    }

    public String getValidaPermiso_8055() {
        return getValidaPermiso(8055);
    }

    public boolean isPermiso_8056() {
        return isPermiso(8056);
    }

    public String getValidaPermiso_8056() {
        return getValidaPermiso(8056);
    }

    public boolean isPermiso_8057() {
        return isPermiso(8057);
    }

    public String getValidaPermiso_8057() {
        return getValidaPermiso(8057);
    }

    public boolean isPermiso_8058() {
        return isPermiso(8058);
    }

    public String getValidaPermiso_8058() {
        return getValidaPermiso(8058);
    }

    public boolean isPermiso_8059() {
        return isPermiso(8059);
    }

    public String getValidaPermiso_8059() {
        return getValidaPermiso(8059);
    }

    public boolean isPermiso_8060() {
        return isPermiso(8060);
    }

    public String getValidaPermiso_8060() {
        return getValidaPermiso(8060);
    }

    public boolean isPermiso_8061() {
        return isPermiso(8061);
    }

    public String getValidaPermiso_8061() {
        return getValidaPermiso(8061);
    }

    public boolean isPermiso_8062() {
        return isPermiso(8062);
    }

    public String getValidaPermiso_8062() {
        return getValidaPermiso(8062);
    }

    public boolean isPermiso_8063() {
        return isPermiso(8063);
    }

    public String getValidaPermiso_8063() {
        return getValidaPermiso(8063);
    }

    public boolean isPermiso_8064() {
        return isPermiso(8064);
    }

    public String getValidaPermiso_8064() {
        return getValidaPermiso(8064);
    }

    public boolean isPermiso_8065() {
        return isPermiso(8065);
    }

    public String getValidaPermiso_8065() {
        return getValidaPermiso(8065);
    }

    public boolean isPermiso_8066() {
        return isPermiso(8066);
    }

    public String getValidaPermiso_8066() {
        return getValidaPermiso(8066);
    }

    public boolean isPermiso_8067() {
        return isPermiso(8067);
    }

    public String getValidaPermiso_8067() {
        return getValidaPermiso(8067);
    }

    public boolean isPermiso_8068() {
        return isPermiso(8068);
    }

    public String getValidaPermiso_8068() {
        return getValidaPermiso(8068);
    }

    public boolean isPermiso_8069() {
        return isPermiso(8069);
    }

    public String getValidaPermiso_8069() {
        return getValidaPermiso(8069);
    }

    public boolean isPermiso_8305() {
        return isPermiso(8305);
    }

    public String getValidaPermiso_8305() {
        return getValidaPermiso(8305);
    }

    public boolean isPermiso_8306() {
        return isPermiso(8306);
    }

    public String getValidaPermiso_8306() {
        return getValidaPermiso(8306);
    }

    public boolean isPermiso_8307() {
        return isPermiso(8307);
    }

    public String getValidaPermiso_8307() {
        return getValidaPermiso(8307);
    }

    public boolean isPermiso_8308() {
        return isPermiso(8308);
    }

    public String getValidaPermiso_8308() {
        return getValidaPermiso(8308);
    }

    public boolean isPermiso_8309() {
        return isPermiso(8309);
    }

    public String getValidaPermiso_8309() {
        return getValidaPermiso(8309);
    }

    public boolean isPermiso_8311() {
        return isPermiso(8311);
    }

    public String getValidaPermiso_8311() {
        return getValidaPermiso(8311);
    }

    public boolean isPermiso_8312() {
        return isPermiso(8312);
    }

    public String getValidaPermiso_8312() {
        return getValidaPermiso(8312);
    }

    public boolean isPermiso_8313() {
        return isPermiso(8313);
    }

    public String getValidaPermiso_8313() {
        return getValidaPermiso(8313);
    }

    public boolean isPermiso_8315() {
        return isPermiso(8315);
    }

    public String getValidaPermiso_8315() {
        return getValidaPermiso(8315);
    }

    public boolean isPermiso_8316() {
        return isPermiso(8316);
    }

    public String getValidaPermiso_8316() {
        return getValidaPermiso(8316);
    }

    public boolean isPermiso_8317() {
        return isPermiso(8317);
    }

    public String getValidaPermiso_8317() {
        return getValidaPermiso(8317);
    }

    public boolean isPermiso_8318() {
        return isPermiso(8318);
    }

    public String getValidaPermiso_8318() {
        return getValidaPermiso(8318);
    }

    public boolean isPermiso_8319() {
        return isPermiso(8319);
    }

    public String getValidaPermiso_8319() {
        return getValidaPermiso(8319);
    }

    public boolean isPermiso_8320() {
        return isPermiso(8320);
    }

    public String getValidaPermiso_8320() {
        return getValidaPermiso(8320);
    }

    public boolean isPermiso_8321() {
        return isPermiso(8321);
    }

    public String getValidaPermiso_8321() {
        return getValidaPermiso(8321);
    }

    public boolean isPermiso_8322() {
        return isPermiso(8322);
    }

    public String getValidaPermiso_8322() {
        return getValidaPermiso(8322);
    }

    public boolean isPermiso_8323() {
        return isPermiso(8323);
    }

    public String getValidaPermiso_8323() {
        return getValidaPermiso(8323);
    }

    public boolean isPermiso_8324() {
        return isPermiso(8324);
    }

    public String getValidaPermiso_8324() {
        return getValidaPermiso(8324);
    }

    public boolean isPermiso_8325() {
        return isPermiso(8325);
    }

    public String getValidaPermiso_8325() {
        return getValidaPermiso(8325);
    }

    public boolean isPermiso_8326() {
        return isPermiso(8326);
    }

    public String getValidaPermiso_8326() {
        return getValidaPermiso(8326);
    }

    public boolean isPermiso_8327() {
        return isPermiso(8327);
    }

    public String getValidaPermiso_8327() {
        return getValidaPermiso(8327);
    }

    public boolean isPermiso_8328() {
        return isPermiso(8328);
    }

    public String getValidaPermiso_8328() {
        return getValidaPermiso(8328);
    }

    public boolean isPermiso_8329() {
        return isPermiso(8329);
    }

    public String getValidaPermiso_8329() {
        return getValidaPermiso(8329);
    }

    public boolean isPermiso_8330() {
        return isPermiso(8330);
    }

    public String getValidaPermiso_8330() {
        return getValidaPermiso(8330);
    }

    public boolean isPermiso_8331() {
        return isPermiso(8331);
    }

    public String getValidaPermiso_8331() {
        return getValidaPermiso(8331);
    }

    public boolean isPermiso_8332() {
        return isPermiso(8332);
    }

    public String getValidaPermiso_8332() {
        return getValidaPermiso(8332);
    }

    public boolean isPermiso_8333() {
        return isPermiso(8333);
    }

    public String getValidaPermiso_8333() {
        return getValidaPermiso(8333);
    }

    public boolean isPermiso_8334() {
        return isPermiso(8334);
    }

    public String getValidaPermiso_8334() {
        return getValidaPermiso(8334);
    }

    public boolean isPermiso_8335() {
        return isPermiso(8335);
    }

    public String getValidaPermiso_8335() {
        return getValidaPermiso(8335);
    }

    public boolean isPermiso_8336() {
        return isPermiso(8336);
    }

    public String getValidaPermiso_8336() {
        return getValidaPermiso(8336);
    }

    public boolean isPermiso_8337() {
        return isPermiso(8337);
    }

    public String getValidaPermiso_8337() {
        return getValidaPermiso(8337);
    }

    public boolean isPermiso_8338() {
        return isPermiso(8338);
    }

    public String getValidaPermiso_8338() {
        return getValidaPermiso(8338);
    }

    public boolean isPermiso_8339() {
        return isPermiso(8339);
    }

    public String getValidaPermiso_8339() {
        return getValidaPermiso(8339);
    }

    public boolean isPermiso_8340() {
        return isPermiso(8340);
    }

    public String getValidaPermiso_8340() {
        return getValidaPermiso(8340);
    }

    public boolean isPermiso_8341() {
        return isPermiso(8341);
    }

    public String getValidaPermiso_8341() {
        return getValidaPermiso(8341);
    }

    public boolean isPermiso_8342() {
        return isPermiso(8342);
    }

    public String getValidaPermiso_8342() {
        return getValidaPermiso(8342);
    }

    public boolean isPermiso_8343() {
        return isPermiso(8343);
    }

    public String getValidaPermiso_8343() {
        return getValidaPermiso(8343);
    }

    public boolean isPermiso_8344() {
        return isPermiso(8344);
    }

    public String getValidaPermiso_8344() {
        return getValidaPermiso(8344);
    }

    public boolean isPermiso_8345() {
        return isPermiso(8345);
    }

    public String getValidaPermiso_8345() {
        return getValidaPermiso(8345);
    }

    public boolean isPermiso_8346() {
        return isPermiso(8346);
    }

    public String getValidaPermiso_8346() {
        return getValidaPermiso(8346);
    }

    public boolean isPermiso_8347() {
        return isPermiso(8347);
    }

    public String getValidaPermiso_8347() {
        return getValidaPermiso(8347);
    }

    public boolean isPermiso_8348() {
        return isPermiso(8348);
    }

    public String getValidaPermiso_8348() {
        return getValidaPermiso(8348);
    }

    public boolean isPermiso_8349() {
        return isPermiso(8349);
    }

    public String getValidaPermiso_8349() {
        return getValidaPermiso(8349);
    }

    public boolean isPermiso_8350() {
        return isPermiso(8350);
    }

    public String getValidaPermiso_8350() {
        return getValidaPermiso(8350);
    }

    public boolean isPermiso_8351() {
        return isPermiso(8351);
    }

    public String getValidaPermiso_8351() {
        return getValidaPermiso(8351);
    }

    public boolean isPermiso_8352() {
        return isPermiso(8352);
    }

    public String getValidaPermiso_8352() {
        return getValidaPermiso(8352);
    }

    public boolean isPermiso_8353() {
        return isPermiso(8353);
    }

    public String getValidaPermiso_8353() {
        return getValidaPermiso(8353);
    }

    public boolean isPermiso_8354() {
        return isPermiso(8354);
    }

    public String getValidaPermiso_8354() {
        return getValidaPermiso(8354);
    }

    public boolean isPermiso_8361() {
        return isPermiso(8361);
    }

    public String getValidaPermiso_8361() {
        return getValidaPermiso(8361);
    }

    public boolean isPermiso_8362() {
        return isPermiso(8362);
    }

    public String getValidaPermiso_8362() {
        return getValidaPermiso(8362);
    }

    public boolean isPermiso_8364() {
        return isPermiso(8364);
    }

    public String getValidaPermiso_8364() {
        return getValidaPermiso(8364);
    }

    public boolean isPermiso_8365() {
        return isPermiso(8365);
    }

    public String getValidaPermiso_8365() {
        return getValidaPermiso(8365);
    }

    public boolean isPermiso_8366() {
        return isPermiso(8366);
    }

    public String getValidaPermiso_8366() {
        return getValidaPermiso(8366);
    }

    public boolean isPermiso_8367() {
        return isPermiso(8367);
    }

    public String getValidaPermiso_8367() {
        return getValidaPermiso(8367);
    }

    public boolean isPermiso_8368() {
        return isPermiso(8368);
    }

    public String getValidaPermiso_8368() {
        return getValidaPermiso(8368);
    }

    public boolean isPermiso_8369() {
        return isPermiso(8369);
    }

    public String getValidaPermiso_8369() {
        return getValidaPermiso(8369);
    }

    public boolean isPermiso_8370() {
        return isPermiso(8370);
    }

    public String getValidaPermiso_8370() {
        return getValidaPermiso(8370);
    }

    public boolean isPermiso_8372() {
        return isPermiso(8372);
    }

    public String getValidaPermiso_8372() {
        return getValidaPermiso(8372);
    }

    public boolean isPermiso_8373() {
        return isPermiso(8373);
    }

    public String getValidaPermiso_8373() {
        return getValidaPermiso(8373);
    }

    public boolean isPermiso_8376() {
        return isPermiso(8376);
    }

    public String getValidaPermiso_8376() {
        return getValidaPermiso(8376);
    }

    public boolean isPermiso_8386() {
        return isPermiso(8386);
    }

    public String getValidaPermiso_8386() {
        return getValidaPermiso(8386);
    }

    public boolean isPermiso_8387() {
        return isPermiso(8387);
    }

    public String getValidaPermiso_8387() {
        return getValidaPermiso(8387);
    }

    public boolean isPermiso_8388() {
        return isPermiso(8388);
    }

    public String getValidaPermiso_8388() {
        return getValidaPermiso(8388);
    }

    public boolean isPermiso_8389() {
        return isPermiso(8389);
    }

    public String getValidaPermiso_8389() {
        return getValidaPermiso(8389);
    }

    public boolean isPermiso_8390() {
        return isPermiso(8390);
    }

    public String getValidaPermiso_8390() {
        return getValidaPermiso(8390);
    }

    public boolean isPermiso_8391() {
        return isPermiso(8391);
    }

    public String getValidaPermiso_8391() {
        return getValidaPermiso(8391);
    }

    public boolean isPermiso_8392() {
        return isPermiso(8392);
    }

    public String getValidaPermiso_8392() {
        return getValidaPermiso(8392);
    }

    public boolean isPermiso_8393() {
        return isPermiso(8393);
    }

    public String getValidaPermiso_8393() {
        return getValidaPermiso(8393);
    }

    public boolean isPermiso_8394() {
        return isPermiso(8394);
    }

    public String getValidaPermiso_8394() {
        return getValidaPermiso(8394);
    }

    public boolean isPermiso_8395() {
        return isPermiso(8395);
    }

    public String getValidaPermiso_8395() {
        return getValidaPermiso(8395);
    }

    public boolean isPermiso_8396() {
        return isPermiso(8396);
    }

    public String getValidaPermiso_8396() {
        return getValidaPermiso(8396);
    }

    public boolean isPermiso_8397() {
        return isPermiso(8397);
    }

    public String getValidaPermiso_8397() {
        return getValidaPermiso(8397);
    }

    public boolean isPermiso_8398() {
        return isPermiso(8398);
    }

    public String getValidaPermiso_8398() {
        return getValidaPermiso(8398);
    }

    public boolean isPermiso_8399() {
        return isPermiso(8399);
    }

    public String getValidaPermiso_8399() {
        return getValidaPermiso(8399);
    }

    public boolean isPermiso_8400() {
        return isPermiso(8400);
    }

    public String getValidaPermiso_8400() {
        return getValidaPermiso(8400);
    }

    public boolean isPermiso_8402() {
        return isPermiso(8402);
    }

    public String getValidaPermiso_8402() {
        return getValidaPermiso(8402);
    }

    public boolean isPermiso_8403() {
        return isPermiso(8403);
    }

    public String getValidaPermiso_8403() {
        return getValidaPermiso(8403);
    }

    public boolean isPermiso_8404() {
        return isPermiso(8404);
    }

    public String getValidaPermiso_8404() {
        return getValidaPermiso(8404);
    }

    public boolean isPermiso_8405() {
        return isPermiso(8405);
    }

    public String getValidaPermiso_8405() {
        return getValidaPermiso(8405);
    }

    public boolean isPermiso_8406() {
        return isPermiso(8406);
    }

    public String getValidaPermiso_8406() {
        return getValidaPermiso(8406);
    }

    public boolean isPermiso_8407() {
        return isPermiso(8407);
    }

    public String getValidaPermiso_8407() {
        return getValidaPermiso(8407);
    }

    public boolean isPermiso_8408() {
        return isPermiso(8408);
    }

    public String getValidaPermiso_8408() {
        return getValidaPermiso(8408);
    }

    public boolean isPermiso_8409() {
        return isPermiso(8409);
    }

    public String getValidaPermiso_8409() {
        return getValidaPermiso(8409);
    }

    public boolean isPermiso_8410() {
        return isPermiso(8410);
    }

    public String getValidaPermiso_8410() {
        return getValidaPermiso(8410);
    }

    public boolean isPermiso_8411() {
        return isPermiso(8411);
    }

    public String getValidaPermiso_8411() {
        return getValidaPermiso(8411);
    }

    public boolean isPermiso_8412() {
        return isPermiso(8412);
    }

    public String getValidaPermiso_8412() {
        return getValidaPermiso(8412);
    }

    public boolean isPermiso_8413() {
        return isPermiso(8413);
    }

    public String getValidaPermiso_8413() {
        return getValidaPermiso(8413);
    }

    public boolean isPermiso_8414() {
        return isPermiso(8414);
    }

    public String getValidaPermiso_8414() {
        return getValidaPermiso(8414);
    }

    public boolean isPermiso_8415() {
        return isPermiso(8415);
    }

    public String getValidaPermiso_8415() {
        return getValidaPermiso(8415);
    }

    public boolean isPermiso_8416() {
        return isPermiso(8416);
    }

    public String getValidaPermiso_8416() {
        return getValidaPermiso(8416);
    }

    public boolean isPermiso_8417() {
        return isPermiso(8417);
    }

    public String getValidaPermiso_8417() {
        return getValidaPermiso(8417);
    }

    public boolean isPermiso_8418() {
        return isPermiso(8418);
    }

    public String getValidaPermiso_8418() {
        return getValidaPermiso(8418);
    }

    public boolean isPermiso_8419() {
        return isPermiso(8419);
    }

    public String getValidaPermiso_8419() {
        return getValidaPermiso(8419);
    }

    public boolean isPermiso_8420() {
        return isPermiso(8420);
    }

    public String getValidaPermiso_8420() {
        return getValidaPermiso(8420);
    }

    public boolean isPermiso_8421() {
        return isPermiso(8421);
    }

    public String getValidaPermiso_8421() {
        return getValidaPermiso(8421);
    }

    public boolean isPermiso_8422() {
        return isPermiso(8422);
    }

    public String getValidaPermiso_8422() {
        return getValidaPermiso(8422);
    }

    public boolean isPermiso_8423() {
        return isPermiso(8423);
    }

    public String getValidaPermiso_8423() {
        return getValidaPermiso(8423);
    }

    public boolean isPermiso_8424() {
        return isPermiso(8424);
    }

    public String getValidaPermiso_8424() {
        return getValidaPermiso(8424);
    }

    public boolean isPermiso_8425() {
        return isPermiso(8425);
    }

    public String getValidaPermiso_8425() {
        return getValidaPermiso(8425);
    }

    public boolean isPermiso_8426() {
        return isPermiso(8426);
    }

    public String getValidaPermiso_8426() {
        return getValidaPermiso(8426);
    }

    public boolean isPermiso_8427() {
        return isPermiso(8427);
    }

    public String getValidaPermiso_8427() {
        return getValidaPermiso(8427);
    }

    public boolean isPermiso_8428() {
        return isPermiso(8428);
    }

    public String getValidaPermiso_8428() {
        return getValidaPermiso(8428);
    }

    public boolean isPermiso_8429() {
        return isPermiso(8429);
    }

    public String getValidaPermiso_8429() {
        return getValidaPermiso(8429);
    }

    public boolean isPermiso_8430() {
        return isPermiso(8430);
    }

    public String getValidaPermiso_8430() {
        return getValidaPermiso(8430);
    }

    public boolean isPermiso_8431() {
        return isPermiso(8431);
    }

    public String getValidaPermiso_8431() {
        return getValidaPermiso(8431);
    }

    public boolean isPermiso_8432() {
        return isPermiso(8432);
    }

    public String getValidaPermiso_8432() {
        return getValidaPermiso(8432);
    }

    public boolean isPermiso_8433() {
        return isPermiso(8433);
    }

    public String getValidaPermiso_8433() {
        return getValidaPermiso(8433);
    }

    public boolean isPermiso_8434() {
        return isPermiso(8434);
    }

    public String getValidaPermiso_8434() {
        return getValidaPermiso(8434);
    }

    public boolean isPermiso_8435() {
        return isPermiso(8435);
    }

    public String getValidaPermiso_8435() {
        return getValidaPermiso(8435);
    }

    public boolean isPermiso_8436() {
        return isPermiso(8436);
    }

    public String getValidaPermiso_8436() {
        return getValidaPermiso(8436);
    }

    public boolean isPermiso_8437() {
        return isPermiso(8437);
    }

    public String getValidaPermiso_8437() {
        return getValidaPermiso(8437);
    }

    public boolean isPermiso_8438() {
        return isPermiso(8438);
    }

    public String getValidaPermiso_8438() {
        return getValidaPermiso(8438);
    }

    public boolean isPermiso_8439() {
        return isPermiso(8439);
    }

    public String getValidaPermiso_8439() {
        return getValidaPermiso(8439);
    }

    public boolean isPermiso_8440() {
        return isPermiso(8440);
    }

    public String getValidaPermiso_8440() {
        return getValidaPermiso(8440);
    }

    public boolean isPermiso_8441() {
        return isPermiso(8441);
    }

    public String getValidaPermiso_8441() {
        return getValidaPermiso(8441);
    }

    public boolean isPermiso_8442() {
        return isPermiso(8442);
    }

    public String getValidaPermiso_8442() {
        return getValidaPermiso(8442);
    }

    public boolean isPermiso_8443() {
        return isPermiso(8443);
    }

    public String getValidaPermiso_8443() {
        return getValidaPermiso(8443);
    }

    public boolean isPermiso_8444() {
        return isPermiso(8444);
    }

    public String getValidaPermiso_8444() {
        return getValidaPermiso(8444);
    }

    public boolean isPermiso_8445() {
        return isPermiso(8445);
    }

    public String getValidaPermiso_8445() {
        return getValidaPermiso(8445);
    }

    public boolean isPermiso_8446() {
        return isPermiso(8446);
    }

    public String getValidaPermiso_8446() {
        return getValidaPermiso(8446);
    }

    public boolean isPermiso_8447() {
        return isPermiso(8447);
    }

    public String getValidaPermiso_8447() {
        return getValidaPermiso(8447);
    }

    public boolean isPermiso_8448() {
        return isPermiso(8448);
    }

    public String getValidaPermiso_8448() {
        return getValidaPermiso(8448);
    }

    public boolean isPermiso_8449() {
        return isPermiso(8449);
    }

    public String getValidaPermiso_8449() {
        return getValidaPermiso(8449);
    }

    public boolean isPermiso_8450() {
        return isPermiso(8450);
    }

    public String getValidaPermiso_8450() {
        return getValidaPermiso(8450);
    }

    public boolean isPermiso_8451() {
        return isPermiso(8451);
    }

    public String getValidaPermiso_8451() {
        return getValidaPermiso(8451);
    }

    public boolean isPermiso_8452() {
        return isPermiso(8452);
    }

    public String getValidaPermiso_8452() {
        return getValidaPermiso(8452);
    }

    public boolean isPermiso_8453() {
        return isPermiso(8453);
    }

    public String getValidaPermiso_8453() {
        return getValidaPermiso(8453);
    }

    public boolean isPermiso_8454() {
        return isPermiso(8454);
    }

    public String getValidaPermiso_8454() {
        return getValidaPermiso(8454);
    }

    public boolean isPermiso_8455() {
        return isPermiso(8455);
    }

    public String getValidaPermiso_8455() {
        return getValidaPermiso(8455);
    }

    public boolean isPermiso_8456() {
        return isPermiso(8456);
    }

    public String getValidaPermiso_8456() {
        return getValidaPermiso(8456);
    }

    public boolean isPermiso_8457() {
        return isPermiso(8457);
    }

    public String getValidaPermiso_8457() {
        return getValidaPermiso(8457);
    }

    public boolean isPermiso_8458() {
        return isPermiso(8458);
    }

    public String getValidaPermiso_8458() {
        return getValidaPermiso(8458);
    }

    public boolean isPermiso_8459() {
        return isPermiso(8459);
    }

    public String getValidaPermiso_8459() {
        return getValidaPermiso(8459);
    }

    public boolean isPermiso_8460() {
        return isPermiso(8460);
    }

    public String getValidaPermiso_8460() {
        return getValidaPermiso(8460);
    }

    public boolean isPermiso_8461() {
        return isPermiso(8461);
    }

    public String getValidaPermiso_8461() {
        return getValidaPermiso(8461);
    }

    public boolean isPermiso_8462() {
        return isPermiso(8462);
    }

    public String getValidaPermiso_8462() {
        return getValidaPermiso(8462);
    }

    public boolean isPermiso_8463() {
        return isPermiso(8463);
    }

    public String getValidaPermiso_8463() {
        return getValidaPermiso(8463);
    }

    public boolean isPermiso_8464() {
        return isPermiso(8464);
    }

    public String getValidaPermiso_8464() {
        return getValidaPermiso(8464);
    }

    public boolean isPermiso_8465() {
        return isPermiso(8465);
    }

    public String getValidaPermiso_8465() {
        return getValidaPermiso(8465);
    }

    public boolean isPermiso_8466() {
        return isPermiso(8466);
    }

    public String getValidaPermiso_8466() {
        return getValidaPermiso(8466);
    }

    public boolean isPermiso_8467() {
        return isPermiso(8467);
    }

    public String getValidaPermiso_8467() {
        return getValidaPermiso(8467);
    }

    public boolean isPermiso_8468() {
        return isPermiso(8468);
    }

    public String getValidaPermiso_8468() {
        return getValidaPermiso(8468);
    }

    public boolean isPermiso_8469() {
        return isPermiso(8469);
    }

    public String getValidaPermiso_8469() {
        return getValidaPermiso(8469);
    }

    public boolean isPermiso_8470() {
        return isPermiso(8470);
    }

    public String getValidaPermiso_8470() {
        return getValidaPermiso(8470);
    }

    public boolean isPermiso_8471() {
        return isPermiso(8471);
    }

    public String getValidaPermiso_8471() {
        return getValidaPermiso(8471);
    }

    public boolean isPermiso_8472() {
        return isPermiso(8472);
    }

    public String getValidaPermiso_8472() {
        return getValidaPermiso(8472);
    }

    public boolean isPermiso_8473() {
        return isPermiso(8473);
    }

    public String getValidaPermiso_8473() {
        return getValidaPermiso(8473);
    }

    public boolean isPermiso_8474() {
        return isPermiso(8474);
    }

    public String getValidaPermiso_8474() {
        return getValidaPermiso(8474);
    }

    public boolean isPermiso_8475() {
        return isPermiso(8475);
    }

    public String getValidaPermiso_8475() {
        return getValidaPermiso(8475);
    }

    public boolean isPermiso_8476() {
        return isPermiso(8476);
    }

    public String getValidaPermiso_8476() {
        return getValidaPermiso(8476);
    }

    public boolean isPermiso_8477() {
        return isPermiso(8477);
    }

    public String getValidaPermiso_8477() {
        return getValidaPermiso(8477);
    }

    public boolean isPermiso_8478() {
        return isPermiso(8478);
    }

    public String getValidaPermiso_8478() {
        return getValidaPermiso(8478);
    }

    public boolean isPermiso_8479() {
        return isPermiso(8479);
    }

    public String getValidaPermiso_8479() {
        return getValidaPermiso(8479);
    }

    public boolean isPermiso_8480() {
        return isPermiso(8480);
    }

    public String getValidaPermiso_8480() {
        return getValidaPermiso(8480);
    }

    public boolean isPermiso_8481() {
        return isPermiso(8481);
    }

    public String getValidaPermiso_8481() {
        return getValidaPermiso(8481);
    }

    public boolean isPermiso_8482() {
        return isPermiso(8482);
    }

    public String getValidaPermiso_8482() {
        return getValidaPermiso(8482);
    }

    public boolean isPermiso_8484() {
        return isPermiso(8484);
    }

    public String getValidaPermiso_8484() {
        return getValidaPermiso(8484);
    }

    public boolean isPermiso_8485() {
        return isPermiso(8485);
    }

    public String getValidaPermiso_8485() {
        return getValidaPermiso(8485);
    }

    public boolean isPermiso_8486() {
        return isPermiso(8486);
    }

    public String getValidaPermiso_8486() {
        return getValidaPermiso(8486);
    }

    public boolean isPermiso_8487() {
        return isPermiso(8487);
    }

    public String getValidaPermiso_8487() {
        return getValidaPermiso(8487);
    }

    public boolean isPermiso_8488() {
        return isPermiso(8488);
    }

    public String getValidaPermiso_8488() {
        return getValidaPermiso(8488);
    }

    public boolean isPermiso_8489() {
        return isPermiso(8489);
    }

    public String getValidaPermiso_8489() {
        return getValidaPermiso(8489);
    }

    public boolean isPermiso_8490() {
        return isPermiso(8490);
    }

    public String getValidaPermiso_8490() {
        return getValidaPermiso(8490);
    }

    public boolean isPermiso_8491() {
        return isPermiso(8491);
    }

    public String getValidaPermiso_8491() {
        return getValidaPermiso(8491);
    }

    public boolean isPermiso_8492() {
        return isPermiso(8492);
    }

    public String getValidaPermiso_8492() {
        return getValidaPermiso(8492);
    }

    public boolean isPermiso_8493() {
        return isPermiso(8493);
    }

    public String getValidaPermiso_8493() {
        return getValidaPermiso(8493);
    }

    public boolean isPermiso_8494() {
        return isPermiso(8494);
    }

    public String getValidaPermiso_8494() {
        return getValidaPermiso(8494);
    }

    public boolean isPermiso_8495() {
        return isPermiso(8495);
    }

    public String getValidaPermiso_8495() {
        return getValidaPermiso(8495);
    }

    public boolean isPermiso_8496() {
        return isPermiso(8496);
    }

    public String getValidaPermiso_8496() {
        return getValidaPermiso(8496);
    }

    public boolean isPermiso_8497() {
        return isPermiso(8497);
    }

    public String getValidaPermiso_8497() {
        return getValidaPermiso(8497);
    }

    public boolean isPermiso_8498() {
        return isPermiso(8498);
    }

    public String getValidaPermiso_8498() {
        return getValidaPermiso(8498);
    }

    public boolean isPermiso_8499() {
        return isPermiso(8499);
    }

    public String getValidaPermiso_8499() {
        return getValidaPermiso(8499);
    }

    public boolean isPermiso_8500() {
        return isPermiso(8500);
    }

    public String getValidaPermiso_8500() {
        return getValidaPermiso(8500);
    }

    public boolean isPermiso_8501() {
        return isPermiso(8501);
    }

    public String getValidaPermiso_8501() {
        return getValidaPermiso(8501);
    }

    public boolean isPermiso_8502() {
        return isPermiso(8502);
    }

    public String getValidaPermiso_8502() {
        return getValidaPermiso(8502);
    }

    public boolean isPermiso_8503() {
        return isPermiso(8503);
    }

    public String getValidaPermiso_8503() {
        return getValidaPermiso(8503);
    }

    public boolean isPermiso_8504() {
        return isPermiso(8504);
    }

    public String getValidaPermiso_8504() {
        return getValidaPermiso(8504);
    }

    public boolean isPermiso_8505() {
        return isPermiso(8505);
    }

    public String getValidaPermiso_8505() {
        return getValidaPermiso(8505);
    }

    public boolean isPermiso_8506() {
        return isPermiso(8506);
    }

    public String getValidaPermiso_8506() {
        return getValidaPermiso(8506);
    }

    public boolean isPermiso_8507() {
        return isPermiso(8507);
    }

    public String getValidaPermiso_8507() {
        return getValidaPermiso(8507);
    }

    public boolean isPermiso_8508() {
        return isPermiso(8508);
    }

    public String getValidaPermiso_8508() {
        return getValidaPermiso(8508);
    }

    public boolean isPermiso_8509() {
        return isPermiso(8509);
    }

    public String getValidaPermiso_8509() {
        return getValidaPermiso(8509);
    }

    public boolean isPermiso_8510() {
        return isPermiso(8510);
    }

    public String getValidaPermiso_8510() {
        return getValidaPermiso(8510);
    }

    public boolean isPermiso_8511() {
        return isPermiso(8511);
    }

    public String getValidaPermiso_8511() {
        return getValidaPermiso(8511);
    }

    public boolean isPermiso_8512() {
        return isPermiso(8512);
    }

    public String getValidaPermiso_8512() {
        return getValidaPermiso(8512);
    }

    public boolean isPermiso_8513() {
        return isPermiso(8513);
    }

    public String getValidaPermiso_8513() {
        return getValidaPermiso(8513);
    }

    public boolean isPermiso_8515() {
        return isPermiso(8515);
    }

    public String getValidaPermiso_8515() {
        return getValidaPermiso(8515);
    }

    public boolean isPermiso_8516() {
        return isPermiso(8516);
    }

    public String getValidaPermiso_8516() {
        return getValidaPermiso(8516);
    }

    public boolean isPermiso_8517() {
        return isPermiso(8517);
    }

    public String getValidaPermiso_8517() {
        return getValidaPermiso(8517);
    }

    public boolean isPermiso_8518() {
        return isPermiso(8518);
    }

    public String getValidaPermiso_8518() {
        return getValidaPermiso(8518);
    }

    public boolean isPermiso_8519() {
        return isPermiso(8519);
    }

    public String getValidaPermiso_8519() {
        return getValidaPermiso(8519);
    }

    public boolean isPermiso_8520() {
        return isPermiso(8520);
    }

    public String getValidaPermiso_8520() {
        return getValidaPermiso(8520);
    }

    public boolean isPermiso_8521() {
        return isPermiso(8521);
    }

    public String getValidaPermiso_8521() {
        return getValidaPermiso(8521);
    }

    public boolean isPermiso_8522() {
        return isPermiso(8522);
    }

    public String getValidaPermiso_8522() {
        return getValidaPermiso(8522);
    }

    public boolean isPermiso_8523() {
        return isPermiso(8523);
    }

    public String getValidaPermiso_8523() {
        return getValidaPermiso(8523);
    }

    public boolean isPermiso_8524() {
        return isPermiso(8524);
    }

    public String getValidaPermiso_8524() {
        return getValidaPermiso(8524);
    }

    public boolean isPermiso_8525() {
        return isPermiso(8525);
    }

    public String getValidaPermiso_8525() {
        return getValidaPermiso(8525);
    }

    public boolean isPermiso_8526() {
        return isPermiso(8526);
    }

    public String getValidaPermiso_8526() {
        return getValidaPermiso(8526);
    }

    public boolean isPermiso_8527() {
        return isPermiso(8527);
    }

    public String getValidaPermiso_8527() {
        return getValidaPermiso(8527);
    }

    public boolean isPermiso_8528() {
        return isPermiso(8528);
    }

    public String getValidaPermiso_8528() {
        return getValidaPermiso(8528);
    }

    public boolean isPermiso_8529() {
        return isPermiso(8529);
    }

    public String getValidaPermiso_8529() {
        return getValidaPermiso(8529);
    }

    public boolean isPermiso_8530() {
        return isPermiso(8530);
    }

    public String getValidaPermiso_8530() {
        return getValidaPermiso(8530);
    }

    public boolean isPermiso_8531() {
        return isPermiso(8531);
    }

    public String getValidaPermiso_8531() {
        return getValidaPermiso(8531);
    }

    public boolean isPermiso_8532() {
        return isPermiso(8532);
    }

    public String getValidaPermiso_8532() {
        return getValidaPermiso(8532);
    }

    public boolean isPermiso_8533() {
        return isPermiso(8533);
    }

    public String getValidaPermiso_8533() {
        return getValidaPermiso(8533);
    }

    public boolean isPermiso_8534() {
        return isPermiso(8534);
    }

    public String getValidaPermiso_8534() {
        return getValidaPermiso(8534);
    }

    public boolean isPermiso_8535() {
        return isPermiso(8535);
    }

    public String getValidaPermiso_8535() {
        return getValidaPermiso(8535);
    }

    public boolean isPermiso_8536() {
        return isPermiso(8536);
    }

    public String getValidaPermiso_8536() {
        return getValidaPermiso(8536);
    }

    public boolean isPermiso_8537() {
        return isPermiso(8537);
    }

    public String getValidaPermiso_8537() {
        return getValidaPermiso(8537);
    }

    public boolean isPermiso_8538() {
        return isPermiso(8538);
    }

    public String getValidaPermiso_8538() {
        return getValidaPermiso(8538);
    }

    public boolean isPermiso_8539() {
        return isPermiso(8539);
    }

    public String getValidaPermiso_8539() {
        return getValidaPermiso(8539);
    }

    public boolean isPermiso_8540() {
        return isPermiso(8540);
    }

    public String getValidaPermiso_8540() {
        return getValidaPermiso(8540);
    }

    public boolean isPermiso_8541() {
        return isPermiso(8541);
    }

    public String getValidaPermiso_8541() {
        return getValidaPermiso(8541);
    }

    public boolean isPermiso_8542() {
        return isPermiso(8542);
    }

    public String getValidaPermiso_8542() {
        return getValidaPermiso(8542);
    }

    public boolean isPermiso_8543() {
        return isPermiso(8543);
    }

    public String getValidaPermiso_8543() {
        return getValidaPermiso(8543);
    }

    public boolean isPermiso_8544() {
        return isPermiso(8544);
    }

    public String getValidaPermiso_8544() {
        return getValidaPermiso(8544);
    }

    public boolean isPermiso_8545() {
        return isPermiso(8545);
    }

    public String getValidaPermiso_8545() {
        return getValidaPermiso(8545);
    }

    public boolean isPermiso_8546() {
        return isPermiso(8546);
    }

    public String getValidaPermiso_8546() {
        return getValidaPermiso(8546);
    }

    public boolean isPermiso_8633() {
        return isPermiso(8633);
    }

    public String getValidaPermiso_8633() {
        return getValidaPermiso(8633);
    }

    public boolean isPermiso_8634() {
        return isPermiso(8634);
    }

    public String getValidaPermiso_8634() {
        return getValidaPermiso(8634);
    }

    public boolean isPermiso_8635() {
        return isPermiso(8635);
    }

    public String getValidaPermiso_8635() {
        return getValidaPermiso(8635);
    }

    public boolean isPermiso_8636() {
        return isPermiso(8636);
    }

    public String getValidaPermiso_8636() {
        return getValidaPermiso(8636);
    }

    public boolean isPermiso_8640() {
        return isPermiso(8640);
    }

    public String getValidaPermiso_8640() {
        return getValidaPermiso(8640);
    }

    public boolean isPermiso_8641() {
        return isPermiso(8641);
    }

    public String getValidaPermiso_8641() {
        return getValidaPermiso(8641);
    }

    public boolean isPermiso_8642() {
        return isPermiso(8642);
    }

    public String getValidaPermiso_8642() {
        return getValidaPermiso(8642);
    }

    public boolean isPermiso_8643() {
        return isPermiso(8643);
    }

    public String getValidaPermiso_8643() {
        return getValidaPermiso(8643);
    }

    public boolean isPermiso_8644() {
        return isPermiso(8644);
    }

    public String getValidaPermiso_8644() {
        return getValidaPermiso(8644);
    }

    public boolean isPermiso_8645() {
        return isPermiso(8645);
    }

    public String getValidaPermiso_8645() {
        return getValidaPermiso(8645);
    }

    public boolean isPermiso_8646() {
        return isPermiso(8646);
    }

    public String getValidaPermiso_8646() {
        return getValidaPermiso(8646);
    }

    public boolean isPermiso_8647() {
        return isPermiso(8647);
    }

    public String getValidaPermiso_8647() {
        return getValidaPermiso(8647);
    }

    public boolean isPermiso_8648() {
        return isPermiso(8648);
    }

    public String getValidaPermiso_8648() {
        return getValidaPermiso(8648);
    }

    public boolean isPermiso_8649() {
        return isPermiso(8649);
    }

    public String getValidaPermiso_8649() {
        return getValidaPermiso(8649);
    }

    public boolean isPermiso_8650() {
        return isPermiso(8650);
    }

    public String getValidaPermiso_8650() {
        return getValidaPermiso(8650);
    }

    public boolean isPermiso_8651() {
        return isPermiso(8651);
    }

    public String getValidaPermiso_8651() {
        return getValidaPermiso(8651);
    }

    public boolean isPermiso_8652() {
        return isPermiso(8652);
    }

    public String getValidaPermiso_8652() {
        return getValidaPermiso(8652);
    }

    public boolean isPermiso_8653() {
        return isPermiso(8653);
    }

    public String getValidaPermiso_8653() {
        return getValidaPermiso(8653);
    }

    public boolean isPermiso_8663() {
        return isPermiso(8663);
    }

    public String getValidaPermiso_8663() {
        return getValidaPermiso(8663);
    }

    public boolean isPermiso_8664() {
        return isPermiso(8664);
    }

    public String getValidaPermiso_8664() {
        return getValidaPermiso(8664);
    }

    public boolean isPermiso_8665() {
        return isPermiso(8665);
    }

    public String getValidaPermiso_8665() {
        return getValidaPermiso(8665);
    }

    public boolean isPermiso_8666() {
        return isPermiso(8666);
    }

    public String getValidaPermiso_8666() {
        return getValidaPermiso(8666);
    }

    public boolean isPermiso_8667() {
        return isPermiso(8667);
    }

    public String getValidaPermiso_8667() {
        return getValidaPermiso(8667);
    }
}
