/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.control.entity;

import com.negocio.control.general.AbstractControl;
import com.negocio.facade.entity.ProductoFacade;
import com.negocio.facade.general.AbstractFacade;
import com.negocio.pojo.jpa.Producto;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "productoControl")
@RequestScoped
public class ProductoControl extends AbstractControl<Producto> {

    @EJB
    ProductoFacade facade;

    public ProductoControl() {
        super(Producto.class);
        attrOrd = "nombre";
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
        facade.delete(facesUtil.getFacesParamLong("idproducto_"), err);
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

    protected ProductoFacade getProductoFacade() {
        return facade;
    }

    @Override
    protected String displayObj(Producto obj) {
        return obj.getNombre() + " $" + obj.getValor();
    }

}
