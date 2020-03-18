/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.control.entity;

import com.negocio.control.general.AbstractControl;
import com.negocio.facade.entity.PersonaFacade;
import com.negocio.facade.general.AbstractFacade;
import com.negocio.pojo.jpa.Persona;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "personaControl")
@RequestScoped
public class PersonaControl extends AbstractControl<Persona> {

    @EJB
    PersonaFacade facade;

    public PersonaControl() {
        super(Persona.class);
        attrOrd = "apellidos";
        ascDesc = "ASC";
    }

    public void nuevo() {
        createDefault();
    }

    public void editar() {
        editDefault();
    }

    public void eliminar() {
        StringBuilder err = new StringBuilder();
        facade.delete(facesUtil.getFacesParamLong("idpersona_"), err);
        if (err.toString().isEmpty()) {
            successful = true;
            facesUtil.msgOk("", "Registro eliminado !");
        } else {
            successful = false;
            facesUtil.msgError("ALERTA: ", err.toString());
        }
    }

    @Override
    protected AbstractFacade getFacade() {
        return facade;
    }

    protected PersonaFacade getPersonaFacade() {
        return facade;
    }

    @Override
    protected String displayObj(Persona obj) {
        return obj.getNombres() + " " + obj.getApellidos();
    }

}
