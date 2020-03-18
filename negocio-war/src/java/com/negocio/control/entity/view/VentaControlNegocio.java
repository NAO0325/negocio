package com.negocio.control.entity.view;

import com.negocio.facade.general.AbstractFacade;
import com.negocio.control.general.AbstractControl;
import com.negocio.facade.entity.PersonaFacade;
import com.negocio.facade.entity.VentaFacade;
import com.negocio.pojo.jpa.Persona;
import com.negocio.pojo.jpa.Producto;
import com.negocio.pojo.jpa.Venta;
import com.negocio.pojo.jpa.VentaItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean(name = "ventaControlNegocio")
@ViewScoped
public class VentaControlNegocio extends AbstractControl<Venta> {

    @EJB
    VentaFacade facade;
    @EJB
    PersonaFacade personaFacade;
    private List<VentaItem> lstItem = new ArrayList<>();
    private long totalVenta;
    Integer idpersonaVendedor;
    Integer idpersonaCliente;
    private Date fechaInicio;
    private Date fechaFin;

    public VentaControlNegocio() {
        super(Venta.class);
        attrOrd = "fecha";
        ascDesc = "DESC";
    }

    public List<VentaItem> getLstItem() {
        return lstItem;
    }

    public long getTotalVenta() {
        return totalVenta;
    }

    public Integer getIdpersonaVendedor() {
        return idpersonaVendedor;
    }

    public void setIdpersonaVendedor(Integer idpersonaVendedor) {
        this.idpersonaVendedor = idpersonaVendedor;
    }

    public Integer getIdpersonaCliente() {
        return idpersonaCliente;
    }

    public void setIdpersonaCliente(Integer idpersonaCliente) {
        this.idpersonaCliente = idpersonaCliente;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    protected AbstractFacade getFacade() {
        return facade;
    }

    @Override
    protected String displayObj(Venta obj) {
        return "No. " + obj.getIdventa() + " $" + obj.getTotal();
    }

    public String calculaListaVentas() {
        setLst(facade.listAll());
        return "";
    }

    private void calculaTotal() {
        for (VentaItem it : lstItem) {
            totalVenta += (it.getCantidad() * it.getIdproducto().getValor());
        }
    }

    public String recuperaArticulos() {
        Object sessionVar = facesUtil.getSessionVar("productosVenta");
        if (sessionVar != null) {
            List<Producto> lstPv = (List<Producto>) sessionVar;
            lstItem = facade.recuperaProductosAgrupados(lstPv);
            calculaTotal();
        }
        return "";
    }

    public List<SelectItem> getSelectAllVendedor() {
        List<SelectItem> lst = new ArrayList<>();
        List<Persona> lstP = personaFacade.listAllVendedor();
        for (Persona persona : lstP) {
            SelectItem it = new SelectItem(persona.getIdpersona(), persona.getNombres() + " " + persona.getApellidos());
            lst.add(it);
        }
        return lst;
    }

    public List<SelectItem> getSelectAllCliente() {
        List<SelectItem> lst = new ArrayList<>();
        List<Persona> lstP = personaFacade.listAllCliente();
        for (Persona persona : lstP) {
            SelectItem it = new SelectItem(persona.getIdpersona(), persona.getNombres() + " " + persona.getApellidos());
            lst.add(it);
        }
        return lst;
    }

    public List<SelectItem> getSelectAllClienteReporte() {
        List<SelectItem> lst = new ArrayList<>();
        List<Persona> lstP = personaFacade.listAllCliente();
        lst.add(new SelectItem(null, "---"));
        for (Persona persona : lstP) {
            SelectItem it = new SelectItem(persona.getIdpersona(), persona.getNombres() + " " + persona.getApellidos());
            lst.add(it);
        }
        return lst;
    }

    public void nuevo() {
        StringBuilder err = new StringBuilder();

        facade.nuevo(getObj(), lstItem, idpersonaVendedor, idpersonaCliente, totalVenta, err);

        if (err.toString().trim().isEmpty()) {
            facesUtil.msgOk("", "Venta Registrada !");
            facesUtil.setSessionVar("productosVenta", null);
            successful = true;
        } else {
            facesUtil.msgError("ALERTA", err.toString());
            successful = false;
        }
    }

    public String listarVentas() {
        StringBuilder err = new StringBuilder();
        setLstGeneral(facade.listAllByReporte(fechaInicio, fechaFin, idpersonaCliente, err));
        return "";
    }

    public void consultar() {
        StringBuilder err = new StringBuilder();
        setLstGeneral(facade.listAllByReporte(fechaInicio, fechaFin, idpersonaCliente, err));
        if (!err.toString().trim().isEmpty()) {
            facesUtil.msgError("ALERTA", err.toString());
        }
    }
}
