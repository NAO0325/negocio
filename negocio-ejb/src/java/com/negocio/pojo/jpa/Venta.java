package com.negocio.pojo.jpa;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByIdventa", query = "SELECT v FROM Venta v WHERE v.idventa = :idventa")
    , @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Venta.findByTotal", query = "SELECT v FROM Venta v WHERE v.total = :total")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idventa")
    private Integer idventa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private long total;
    @JoinColumn(name = "idpersona_vendedor", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersonaVendedor;
    @JoinColumn(name = "idpersona_cliente", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersonaCliente;

    public Venta() {
    }

    public Venta(Integer idventa) {
        this.idventa = idventa;
    }

    public Venta(Integer idventa, Date fecha, long total) {
        this.idventa = idventa;
        this.fecha = fecha;
        this.total = total;
    }

    public Integer getIdventa() {
        return idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Persona getIdpersonaVendedor() {
        return idpersonaVendedor;
    }

    public void setIdpersonaVendedor(Persona idpersonaVendedor) {
        this.idpersonaVendedor = idpersonaVendedor;
    }

    public Persona getIdpersonaCliente() {
        return idpersonaCliente;
    }

    public void setIdpersonaCliente(Persona idpersonaCliente) {
        this.idpersonaCliente = idpersonaCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idventa != null ? idventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idventa == null && other.idventa != null) || (this.idventa != null && !this.idventa.equals(other.idventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.negocio.pojo.jpa.Venta[ idventa=" + idventa + " ]";
    }
    
}
