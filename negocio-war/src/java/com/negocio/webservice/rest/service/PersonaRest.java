package com.negocio.webservice.rest.service;

import com.negocio.facade.entity.PersonaFacade;
import com.negocio.pojo.jpa.Persona;
import com.negocio.util.BeanUtil;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("negocio.personaRest")
public class PersonaRest {

    private PersonaFacade personaFacade = BeanUtil.lookupFacadeBean(PersonaFacade.class);

    @Context
    private UriInfo context;

    @GET
    @Path("hola")
    @Produces(MediaType.TEXT_PLAIN)
    public String hola() {
        return "Hello!";
    }

    @GET
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public String create(@QueryParam("nombres") String nombres, @QueryParam("apellidos") String apellidos, @QueryParam("numdocumento") String numdocumento, @QueryParam("tipo") String tipo) {

        String result = "";
        StringBuilder err = new StringBuilder();

        result = validaCampos(false, null, nombres, apellidos, numdocumento, tipo);

        if (!result.isEmpty()) {
            return result;
        }

        Persona p = new Persona();
        p.setNombres(nombres);
        p.setApellidos(apellidos);
        p.setNumdocumento(Long.parseLong(numdocumento));
        p.setTipo(tipo);

        personaFacade.create(p, err);

        if (err.toString().trim().isEmpty()) {
            return "{\"SUCCESS\":\"Persona Creada!\"}";
        } else {
            return "{\"ALERT\":\"" + err.toString() + "\"}";
        }
    }

    @GET
    @Path("/edit")
    @Produces(MediaType.APPLICATION_JSON)
    public String edit(@QueryParam("idpersona") Integer idpersona, @QueryParam("nombres") String nombres, @QueryParam("apellidos") String apellidos, @QueryParam("numdocumento") String numdocumento, @QueryParam("tipo") String tipo) {

        String result = "";
        StringBuilder err = new StringBuilder();

        if (idpersona == null) {
            return "{\"ALERT\":\"Falta  idpersona!\"}";
        }

        if (!result.isEmpty()) {
            return result;
        }

        Persona p = personaFacade.find(idpersona);

        if (p == null) {
            return "{\"WARNING\":\"Persona no registred!\"}";
        }

        if (nombres != null && !nombres.isEmpty()) {
            p.setNombres(nombres);
        }

        if (apellidos != null && !apellidos.isEmpty()) {
            p.setApellidos(numdocumento);
        }

        if (numdocumento != null && !numdocumento.isEmpty()) {
            p.setNumdocumento(Long.parseLong(numdocumento));
        }
        
        if (tipo != null && !tipo.isEmpty()) {
            p.setTipo(tipo);
        }

        personaFacade.edit(p, err);

        if (err.toString().trim().isEmpty()) {
            return "{\"SUCCESS\":\"Persona Editada!\"}";
        } else {
            return "{\"ALERT\":\"" + err.toString() + "\"}";
        }
    }

    @GET
    @Path("/remove")
    @Produces(MediaType.APPLICATION_JSON)
    public String remove(@QueryParam("idpersona") Integer idpersona) {

        StringBuilder err = new StringBuilder();

        if (idpersona == null) {
            return "{\"ALERT\":\"Falta  idpersona!\"}";
        }

        Persona p = personaFacade.find(idpersona);

        if (p == null) {
            return "{\"WARNING\":\"Persona no registred!\"}";
        }

        personaFacade.delete(p.getIdpersona(), err);

        if (err.toString().trim().isEmpty()) {
            return "{\"SUCCESS\":\"Persona Deleted!\"}";
        } else {
            return "{\"ALERT\":\"" + err.toString() + "\"}";
        }
    }

    @GET
    @Path("/find")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Persona find(@QueryParam("idpersona") Integer idpersona) {
        return personaFacade.find(idpersona);
    }

    @GET
    @Path("/findAll")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Persona> findAll() {
        return personaFacade.listAllLight("idpersona", "ASC");
    }

    private String validaCampos(boolean isEdit, Integer idpersona, String nombres, String apellidos, String numdocumento, String tipo) {

        String res = "";

        if (isEdit) {
            if (idpersona == null) {
                res = "{\"ALERT\":\"Falta  idpersona!\"}";
            }
        }

        if (nombres == null || nombres.trim().isEmpty()) {
            res = "{\"ALERT\":\"Falta campo nombres!\"}";
        }

        if (apellidos == null || apellidos.trim().isEmpty()) {
            res = "{\"ALERT\":\"Falta campo apellidos!\"}";
        }

        if (numdocumento == null || numdocumento.trim().isEmpty()) {
            res = "{\"ALERT\":\"Falta campo numdocumento!\"}";
        }

        if (tipo == null || tipo.trim().isEmpty()) {
            res = "{\"ALERT\":\"Falta campo tipo!\"}";
        }

        return res;
    }
}
