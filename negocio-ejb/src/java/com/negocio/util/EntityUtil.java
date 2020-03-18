
package com.negocio.util;

import com.negocio.pojo.jpa.Persona;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


public class EntityUtil {

    public static String getAttrHqlToSql(String attr, Class entityClass) {
        for (Field f : entityClass.getDeclaredFields()) {
            if (f.getName().equals(attr)) {
                Column c = f.getAnnotation(Column.class);
                if (c != null) {
                    return c.name();
                }
            }
        }
        return null;
    }

    public static String getTableName(Class entityClass) {
        Annotation a = entityClass.getAnnotation(Table.class);
        Table t = (Table) a;
        if (t != null) {
            return t.name();
        }
        return null;
    }

    public static String getAttrId_SqlName(Class entityClass) {
        return getAttrHqlToSql(getAttrId(entityClass), entityClass);
    }

    public static String getAttrId(Class entityClass) {
        for (Field f : entityClass.getDeclaredFields()) {
            Id c = f.getAnnotation(Id.class);
            if (c != null) {
                return f.getName();
            }
        }
        return null;
    }

    public static Class getAttrIdClass(Class entityClass) {
        for (Field f : entityClass.getDeclaredFields()) {
            Id c = f.getAnnotation(Id.class);
            if (c != null) {
                return f.getType();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getAttrHqlToSql("nombres", Persona.class));
        System.out.println(getTableName(Persona.class));
        System.out.println(getAttrId(Persona.class));
        System.out.println(getAttrIdClass(Persona.class));
        System.out.println(getAttrId_SqlName(Persona.class));
    }
}
