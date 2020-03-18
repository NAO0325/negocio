package com.negocio.control.entity.view;

import com.negocio.facade.general.AbstractFacade;
import com.negocio.control.general.AbstractControl;
import com.negocio.facade.entity.ProductoFacade;
import com.negocio.pojo.jpa.Producto;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ProductoControlNegocio extends AbstractControl<Producto> {

    @EJB
    ProductoFacade facade;

    public ProductoControlNegocio() {
        super(Producto.class);
        attrOrd = "nombre";
        ascDesc = "ASC";
    }

    @Override
    protected AbstractFacade getFacade() {
        return facade;
    }

    @Override
    protected String displayObj(Producto obj) {
        return obj.getNombre() + " $" + obj.getValor();
    }

    public String calculaListaProductos() {
        setLst(facade.listAll());
        return "";
    }

    public void comprar(Producto p) {
        Object val = facesUtil.getSessionVar("productosVenta");
        if (val != null) {
            setLst((List<Producto>) val);
        }
        getLst().add(p);
        facesUtil.setSessionVar("productosVenta", getLst());
    }
}
