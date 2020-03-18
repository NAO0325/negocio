/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.control.entity;

import com.negocio.control.general.AbstractControl;
import com.negocio.facade.entity.PersonaFacade;
import com.negocio.facade.entity.VentaFacade;
import com.negocio.facade.general.AbstractFacade;
import com.negocio.pojo.jpa.Persona;
import com.negocio.pojo.jpa.Producto;
import com.negocio.pojo.jpa.Venta;
import com.negocio.pojo.jpa.VentaItem;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Desarrollo 01
 */
@ManagedBean(name = "ventaControl")
@RequestScoped
public class VentaControl extends AbstractControl<Venta> {

    @EJB
    VentaFacade facade;
    @EJB
    PersonaFacade personaFacade;
    private List<VentaItem> lstItem = new ArrayList<>();

    public VentaControl() {
        super(Venta.class);
        attrOrd = "nombre";
        ascDesc = "ASC";
    }

    public List<VentaItem> getLstItem() {
        return lstItem;
    }

    @Override
    protected AbstractFacade getFacade() {
        return facade;
    }

    @Override
    protected String displayObj(Venta obj) {
        return "No. " + obj.getIdventa() + " $" + obj.getTotal();
    }

    public String listarItems() {
        Integer idv = facesUtil.getFacesParamInteger("idventa_");
        lstItem = facade.listAllItemByVenta(idv);
        return "";
    }

}
