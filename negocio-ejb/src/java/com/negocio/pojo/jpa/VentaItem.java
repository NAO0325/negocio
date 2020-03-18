/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.pojo.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Desarrollo 01
 */
@Entity
@Table(name = "venta_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaItem.findAll", query = "SELECT v FROM VentaItem v")
    , @NamedQuery(name = "VentaItem.findByIditem", query = "SELECT v FROM VentaItem v WHERE v.iditem = :iditem")
    , @NamedQuery(name = "VentaItem.findByCantidad", query = "SELECT v FROM VentaItem v WHERE v.cantidad = :cantidad")})
public class VentaItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "iditem")
    private Integer iditem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto idproducto;
    @JoinColumn(name = "idventa", referencedColumnName = "idventa")
    @ManyToOne(optional = false)
    private Venta idventa;

    public VentaItem() {
    }

    public VentaItem(Integer iditem) {
        this.iditem = iditem;
    }

    public VentaItem(Integer iditem, int cantidad) {
        this.iditem = iditem;
        this.cantidad = cantidad;
    }

    public Integer getIditem() {
        return iditem;
    }

    public void setIditem(Integer iditem) {
        this.iditem = iditem;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    public Venta getIdventa() {
        return idventa;
    }

    public void setIdventa(Venta idventa) {
        this.idventa = idventa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditem != null ? iditem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaItem)) {
            return false;
        }
        VentaItem other = (VentaItem) object;
        if ((this.iditem == null && other.iditem != null) || (this.iditem != null && !this.iditem.equals(other.iditem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.negocio.pojo.jpa.VentaItem[ iditem=" + iditem + " ]";
    }
    
}
