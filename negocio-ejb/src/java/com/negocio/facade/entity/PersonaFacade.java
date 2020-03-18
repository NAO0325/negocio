package com.negocio.facade.entity;

import com.negocio.facade.general.AbstractFacade;
import com.negocio.pojo.jpa.Persona;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public PersonaFacade() {
        super(Persona.class);
    }

    @Override
    protected String[] attrsQueryLight() {
        String[] attrs = {"idpersona", "nombres", "apellidos", "numdocumento"};
        return attrs;
    }

    @Override
    protected String[] attrFullTextCriteria() {
        String[] attrs = {"idpersona", "nombres", "apellidos", "numdocumento"};
        return attrs;
    }

    @Override
    protected Persona parseObject(Object[] o) {
        Persona p = new Persona((Integer) o[0]);
        p.setNombres((String) o[1]);
        p.setApellidos((String) o[2]);
        p.setNumdocumento(new BigInteger(o[3].toString()).longValue());

        return p;
    }

    @Override
    public void create(Persona obj, StringBuilder err) {
        createGeneral(obj, err);
    }

    @Override
    public void edit(Persona obj, StringBuilder err) {
        editGeneral(obj, err);
    }

    @Override
    public void delete(Object idperson, StringBuilder err) {
        deleteGeneral(idperson, err);
    }
    
    public List<Persona> listAllVendedor(){
        String hql = "SELECT p FROM Persona p WHERE p.tipo = 'VENDEDOR' ORDER BY p.apellidos";
        return this.findList(hql);
    }
    
    public List<Persona> listAllCliente(){
        String hql = "SELECT p FROM Persona p WHERE p.tipo = 'CLIENTE' ORDER BY p.apellidos";
        return this.findList(hql);
    }
}
