package com.negocio.facade.entity;

import com.negocio.facade.general.AbstractFacade;
import com.negocio.pojo.jpa.Producto;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ProductoFacade() {
        super(Producto.class);
    }

    @Override
    protected String[] attrsQueryLight() {
        String[] attrs = {"idproducto", "tipo", "nombre", "valor"};
        return attrs;
    }

    @Override
    protected String[] attrFullTextCriteria() {
        String[] attrs = {"idproducto", "tipo", "nombre", "valor"};
        return attrs;
    }

    @Override
    protected Producto parseObject(Object[] o) {
        Producto p = new Producto((Integer) o[0]);
        p.setTipo((String) o[1]);
        p.setNombre((String) o[2]);
        p.setValor(new BigInteger(o[3].toString()).longValue());

        return p;
    }

    @Override
    public void create(Producto obj, StringBuilder err) {
        createGeneral(obj, err);
    }

    @Override
    public void edit(Producto obj, StringBuilder err) {
        editGeneral(obj, err);
    }

    @Override
    public void delete(Object idperson, StringBuilder err) {
        deleteGeneral(idperson, err);
    }

    public List<Producto> listAll() {
        String hql = "SELECT p FROM Producto p ORDER BY p.nombre";
        return this.findList(hql);
    }

    public List<Producto> listAllIn(String in) {
        String hql = "SELECT p FROM Producto p WHERE p.idproducto IN (" + in + ") ORDER BY p.nombre";
        return this.findList(hql);
    }
    
    public HashMap<Integer, Producto> mapAllIn(String in) {
        HashMap<Integer, Producto> map = new HashMap<>();
        List<Producto> listAllIn = listAllIn(in);
        for (Producto p : listAllIn) {
            map.put(p.getIdproducto(), p);
        }
        return map;
    }

}
