package com.negocio.webservice.rest.service;

import com.negocio.facade.entity.VentaFacade;
import com.negocio.pojo.jpa.Venta;
import com.negocio.util.BeanUtil;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("negocio.ventaRest")
public class VentaRest {

    private VentaFacade ventaFacade = BeanUtil.lookupFacadeBean(VentaFacade.class);

    @Context
    private UriInfo context;

    @POST
    @Path("ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "ping ok!";
    }

    @POST
    @Path("/listAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAll() {
        List<Venta> lst = ventaFacade.listAll();
        return Response.ok(lst).build();
    }
}
