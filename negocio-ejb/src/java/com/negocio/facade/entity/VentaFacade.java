package com.negocio.facade.entity;

import com.negocio.facade.general.AbstractFacade;
import com.negocio.pojo.jpa.Persona;
import com.negocio.pojo.jpa.Producto;
import com.negocio.pojo.jpa.Venta;
import com.negocio.pojo.jpa.VentaItem;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.hibernate.impl.SessionImpl;

@Stateless
public class VentaFacade extends AbstractFacade<Venta> {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public VentaFacade() {
        super(Venta.class);
    }

    @Override
    protected String[] attrsQueryLight() {
        String[] attrs = {"idventa", "fecha", "total", "idpersonaCliente.nombres", "idpersonaCliente.apellidos", "idpersonaVendedor.nombres", "idpersonaVendedor.apellidos"};
        return attrs;
    }

    @Override
    protected String[] attrFullTextCriteria() {
        String[] attrs = {"idventa", "fecha", "total"};
        return attrs;
    }

    @Override
    protected Venta parseObject(Object[] o) {
        Venta p = new Venta((Integer) o[0]);
        p.setFecha((Date) o[1]);
        p.setTotal(new BigInteger(o[2].toString()).longValue());
        p.setIdpersonaCliente(new Persona());
        p.getIdpersonaCliente().setNombres((String) o[3]);
        p.getIdpersonaCliente().setNombres((String) o[4]);
        p.setIdpersonaVendedor(new Persona());
        p.getIdpersonaVendedor().setNombres((String) o[5]);
        p.getIdpersonaVendedor().setNombres((String) o[6]);
        return p;
    }

    @Override
    public void create(Venta obj, StringBuilder err) {
        createGeneral(obj, err);
    }

    @Override
    public void edit(Venta obj, StringBuilder err) {
        editGeneral(obj, err);
    }

    @Override
    public void delete(Object idperson, StringBuilder err) {
        deleteGeneral(idperson, err);
    }

    public List<Venta> listAll() {
        String hql = "SELECT p FROM venta p ORDER BY p.fecha";
        return this.findList(hql);
    }

    public List<Venta> listAllByReporte(Date fechaIni, Date fechaFin, Integer idusuarioCliente, StringBuilder error) {

        List<Venta> lst = new ArrayList<>();

        String condF = "";
        String condCliente = "";

        if (fechaIni != null && fechaFin == null) {
            error.append("Debe seleccionar una fecha de fin.");
            return lst;
        }

        if (fechaIni == null && fechaFin != null) {
            error.append("Debe seleccionar una fecha de inicio.");
            return lst;
        }

        if (fechaIni != null && fechaFin != null) {
            if (fechaIni.getTime() > fechaFin.getTime()) {
                error.append("La fecha de inicio debe ser menor que la fecha fin.");
                return lst;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
            condF = " AND p.fecha >= '" + sdf.format(fechaIni) + "' "
                    + " AND p.fecha <= ' " + sdf.format(fechaFin) + "' ";
        }

        if (idusuarioCliente != null) {
            condCliente = " AND p.idpersonaCliente = " + idusuarioCliente;
        }

        String hql = "SELECT p "
                + " FROM Venta p "
                + " WHERE 1=1 "
                + condF
                + condCliente
                + " ORDER BY p.fecha DESC";
        lst = this.findList(hql);
        return lst;
    }

    public List<VentaItem> listAllItemByVenta(Integer idventa) {
        List<VentaItem> lst = new ArrayList<>();

        String hql = " SELECT it.iditem, "
                + "           it.cantidad,"
                + "           it.idproducto.idproducto,"
                + "           it.idproducto.nombre,"
                + "           it.idproducto.valor,"
                + "           it.idproducto.tipo"
                + "    FROM VentaItem it "
                + "    WHERE it.idventa.idventa = " + idventa
                + "   ORDER BY it.iditem";

        List<Object[]> data = this.findGeneric(hql);
        
        for (Object[] obj : data) {
            VentaItem it = new VentaItem((Integer) obj[0]);
            it.setCantidad((Integer) obj[1]);
            it.setIdproducto(new Producto((Integer) obj[2]));
            it.getIdproducto().setNombre((String) obj[3]);
            it.getIdproducto().setValor((Long) obj[4]);
            it.getIdproducto().setTipo((String) obj[5]);
            lst.add(it);
        }

        return lst;
    }

    public List<VentaItem> recuperaProductosAgrupados(List<Producto> lstPv) {
        List<VentaItem> lst = new ArrayList<>();
        List<Producto> lstPvAux = new ArrayList<>(lstPv);
        HashMap<Producto, Integer> map = new HashMap<>();

        for (Producto p1 : lstPv) {
            int cant = 0;
            for (Producto p2 : lstPvAux) {
                if (p1.equals(p2)) {
                    cant++;
                }
            }
            if (cant != 0) {
                map.put(p1, cant - 1);
            }
        }

        Set<Producto> hs = new HashSet<>();
        hs.addAll(lstPv);
        lstPv.clear();
        lstPv.addAll(hs);

        for (Producto p : lstPv) {
            VentaItem it = new VentaItem();
            it.setCantidad(map.get(p));
            it.setIdproducto(p);
            if (it.getCantidad() != 0) {
                lst.add(it);
            }
        }

        return lst;
    }

    public void nuevo(Venta v, List<VentaItem> lstIt, Integer idpv, Integer idpc, Long total, StringBuilder error) {
        //Importante que sea e una nueva transacción
        beginTransaction();
        try {

            SessionImpl sess = getSess();

            v.setFecha(new Date());
            v.setIdpersonaVendedor(new Persona(idpv));
            v.setIdpersonaCliente(new Persona(idpc));
            v.setTotal(total);
            sess.persist(v);

            for (VentaItem it : lstIt) {
                it.setIdventa(v);
                sess.persist(it);
            }

            commitTransaction();
        } catch (Exception ex) {
            error.append(ex.toString());
            rollbackTransaction();
            System.out.println("FALLA, registrando venta: " + ex);
            ex.printStackTrace();
        }
        endTransaction();
    }

}
