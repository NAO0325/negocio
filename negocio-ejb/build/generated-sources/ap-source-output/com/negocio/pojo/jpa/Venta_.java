package com.negocio.pojo.jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Venta.class)
public abstract class Venta_ {

	public static volatile SingularAttribute<Venta, Integer> idventa;
	public static volatile SingularAttribute<Venta, Date> fecha;
	public static volatile SingularAttribute<Venta, Long> total;
	public static volatile SingularAttribute<Venta, Persona> idpersonaCliente;
	public static volatile SingularAttribute<Venta, Persona> idpersonaVendedor;

}

