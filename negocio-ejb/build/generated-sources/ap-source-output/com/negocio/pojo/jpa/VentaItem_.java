package com.negocio.pojo.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VentaItem.class)
public abstract class VentaItem_ {

	public static volatile SingularAttribute<VentaItem, Venta> idventa;
	public static volatile SingularAttribute<VentaItem, Integer> iditem;
	public static volatile SingularAttribute<VentaItem, Integer> cantidad;
	public static volatile SingularAttribute<VentaItem, Producto> idproducto;

}

