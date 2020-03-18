package com.negocio.conversor.entity;

import com.negocio.facade.entity.PersonaFacade;
import com.negocio.pojo.jpa.Persona;
import com.negocio.util.BeanUtil;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author napoavi@gmail.com
 */
@FacesConverter(forClass = Persona.class)
public class PersonaConversor implements Converter {

    PersonaFacade bean = BeanUtil.lookupFacadeBean(PersonaFacade.class);

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        return bean.find(Integer.parseInt(string));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        Persona o = (Persona) object;
        if (o.getIdpersona()== null) {
            return null;
        }
        return o.getIdpersona().toString();
    }
}
