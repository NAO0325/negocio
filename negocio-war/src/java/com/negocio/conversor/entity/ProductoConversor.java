package com.negocio.conversor.entity;

import com.negocio.facade.entity.ProductoFacade;
import com.negocio.pojo.jpa.Producto;
import com.negocio.util.BeanUtil;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author napoavi@gmail.com
 */
@FacesConverter(forClass = Producto.class)
public class ProductoConversor implements Converter {

    ProductoFacade bean = BeanUtil.lookupFacadeBean(ProductoFacade.class);

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
        Producto o = (Producto) object;
        if (o.getIdproducto()== null) {
            return null;
        }
        return o.getIdproducto().toString();
    }
}
