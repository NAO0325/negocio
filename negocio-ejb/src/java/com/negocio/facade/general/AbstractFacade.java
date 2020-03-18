package com.negocio.facade.general;

import com.negocio.util.Cadena;
import com.negocio.util.EntityUtil;
import com.negocio.util.SerialClone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import org.hibernate.Transaction;
import org.hibernate.impl.SessionImpl;


public abstract class AbstractFacade<T> {

    @PersistenceUnit
    private EntityManagerFactory emf;
    private Transaction tx;
    private SessionImpl sess;
    private EntityManager em_;

    protected EntityManager getEntityManager2() {
        return emf.createEntityManager();
    }
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    protected abstract String[] attrFullTextCriteria();

    protected abstract String[] attrsQueryLight();

    protected abstract T parseObject(Object[] o);

    public abstract void create(T obj, StringBuilder err);

    public abstract void edit(T obj, StringBuilder err);

    public abstract void delete(Object valueId, StringBuilder err);

    protected void createGeneral(T obj, StringBuilder err) {
        beginTransaction();
        try {
            SessionImpl sess = getSess();
            sess.save(obj);
            commitTransaction();
        } catch (Exception e) {
            err.append(e.toString());
            rollbackTransaction();
            e.printStackTrace();
        }
        endTransaction();
    }

    protected void editGeneral(T obj, StringBuilder err) {
        beginTransaction();
        try {
            SessionImpl sess = getSess();
            sess.update(obj);
            commitTransaction();
        } catch (Exception e) {
            err.append(e.toString());
            rollbackTransaction();
            e.printStackTrace();
        }
        endTransaction();
    }

    protected void deleteGeneral(Object valueId, StringBuilder err) {
        beginTransaction();
        try {
            SessionImpl sess = getSess();

            String sql = "DELETE FROM " + EntityUtil.getTableName(entityClass) + " WHERE " + EntityUtil.getAttrId_SqlName(entityClass) + " = '" + valueId + "' ";
            sess.createSQLQuery(sql).executeUpdate();

            commitTransaction();
        } catch (Exception e) {
            err.append(e.toString());
            rollbackTransaction();
            e.printStackTrace();
        }
        endTransaction();
    }

    public List<T> listFullTextSearchLight(String valBusq, String attrOrder, String ascDesc, int firstReg, int maxReg) {
        return listFullTextSearch(valBusq, attrOrder, ascDesc, false, firstReg, maxReg, false, true);
    }

    public List<T> listFullTextSearch_NoLight(String valBusq, String attrOrder, String ascDesc, int firstReg, int maxReg) {
        return listFullTextSearch(valBusq, attrOrder, ascDesc, false, firstReg, maxReg, false, false);
    }

    public List<T> listFullTextSearchLight(String valBusq, String attrOrder, String ascDesc) {
        return listFullTextSearch(valBusq, attrOrder, ascDesc, true, 0, 0, false, true);
    }

    public List<T> listFullTextSearchLightHtmlResult(String valBusq, String attrOrder, String ascDesc, int firstReg, int maxReg) {
        return listFullTextSearch(valBusq, attrOrder, ascDesc, false, firstReg, maxReg, true, true);
    }

    public List<T> listFullTextSearchHtmlResult_NoLight(String valBusq, String attrOrder, String ascDesc, int firstReg, int maxReg) {
        return listFullTextSearch(valBusq, attrOrder, ascDesc, false, firstReg, maxReg, true, false);
    }

    public List<T> listFullTextSearchLightHtmlResult(String valBusq, String attrOrder, String ascDesc) {
        return listFullTextSearch(valBusq, attrOrder, ascDesc, true, 0, 0, true, true);
    }

    public long countFullTextSearch(String valBusq) {
        String sql = sqlQueryFullText(valBusq, null, null, false, true, false);
        List l = findNative(sql);
        if (l.size() > 0 && l.get(0) != null) {
            return new Long(l.get(0).toString());
        } else {
            return 0;
        }
    }

    private List<T> listFullTextSearch(String valBusq, String attrOrder, String ascDesc, boolean allReg, int firstReg, int maxReg, boolean htmlResult, boolean isLight) {
        if (valBusq == null || valBusq.trim().isEmpty()) {
            return new ArrayList();
        }

        String sql = sqlQueryFullText(valBusq, attrOrder, ascDesc, htmlResult, false, isLight);

        List<T> lstT = new ArrayList<>();

        if (isLight) {
            List<Object[]> lst;
            if (allReg) {
                lst = findNativeGeneric(sql);
            } else {
                lst = findNativeGeneric(sql, firstReg, maxReg);
            }
            for (Object[] o : lst) {
                T obj = parseObject(o);
                lstT.add(obj);
            }
        } else {
            if (allReg) {
                lstT = findNative(sql, entityClass);
            } else {
                lstT = findNative(sql, firstReg, maxReg, entityClass);
            }
        }

        return lstT;
    }

    protected String getSelectLight(String alias) {
        String select = " SELECT ";
        for (String attr : attrsQueryLight()) {
            select += alias + "." + EntityUtil.getAttrHqlToSql(attr, entityClass) + ",";
        }
        select = select.substring(0, select.length() - 1);
        return select;
    }

    private String sqlQueryFullText(String valBusq, String attrOrder, String ascDesc, boolean htmlResult, boolean isCount, boolean isLight) {
        String select = getSelectLight("t");

        if (!isLight) {
            select = " SELECT * ";
        }

        if (isCount) {
            select = "SELECT count(*) ";
        }

        String tsvector = "";
        for (String attr : attrFullTextCriteria()) {
            tsvector += EntityUtil.getAttrHqlToSql(attr, entityClass) + "||' '||";
        }
        tsvector = tsvector.substring(0, tsvector.length() - 7);

        String orderBy = "";
        if (!isCount) {
            orderBy = " ORDER BY t." + EntityUtil.getAttrHqlToSql(attrOrder, entityClass) + " " + ascDesc;
        }

        String language = "spanish";

        valBusq = valBusq.trim().replaceAll(" ", "&");

        String sql = select
                + " FROM " + EntityUtil.getTableName(entityClass) + " t "
                + " WHERE to_tsvector(" + tsvector + ")@@to_tsquery('" + language + "','" + new Cadena().reemplazaEspacios(valBusq, "&").trim() + "')"
                + orderBy;

        if (htmlResult) {
            sql = select + ",ts_rank(to_tsvector(" + tsvector + "),to_tsquery('" + language + "','" + valBusq + "')) as rank,ts_headline('" + language + "'," + tsvector + ",to_tsquery('" + language + "','" + valBusq + "')) as highlighting "
                    + " FROM " + EntityUtil.getTableName(entityClass) + " t "
                    + " WHERE to_tsvector(" + tsvector + ")@@to_tsquery('" + language + "','" + valBusq + "') "
                    + orderBy;
        }

        return sql;
    }

    public List<T> listAllLight(String attrOrder, String ascDesc, int firstReg, int maxReg) {
        return listAllLight(attrOrder, ascDesc, false, firstReg, maxReg);
    }

    public List<T> listAllLight(String attrOrder, String ascDesc) {
        return listAllLight(attrOrder, ascDesc, true, 0, 0);
    }

    public long countAll() {
        String hql = "SELECT count(obj) FROM " + entityClass.getName() + " obj ";
        return numFromHQL(hql, new Long(0));
    }

    private List<T> listAllLight(String attrOrder, String ascDesc, boolean allReg, int firstReg, int maxReg) {
        String select = " SELECT ";
        for (String attr : attrsQueryLight()) {
            select += "obj." + attr + ",";
        }
        select = select.substring(0, select.length() - 1);

        List<T> lstT = new ArrayList<>();

        String hql = select
                + "   FROM " + entityClass.getName() + " obj "
                + "ORDER BY obj." + attrOrder + " " + ascDesc;

        List<Object[]> lst;

        if (allReg) {
            lst = findGeneric(hql);
        } else {
            lst = findGeneric(hql, firstReg, maxReg);
        }

        for (Object[] o : lst) {
            T objT = parseObject(o);
            lstT.add(objT);
        }
        return lstT;
    }

    protected void beginTransaction() {
        //Obteniendo sesion
        em_ = getEntityManager2();
        sess = (SessionImpl) em_.getDelegate();
        tx = sess.getTransaction();

        //Empezando Transaccion
        tx.begin();
    }

    protected void commitTransaction() {
        tx.commit();
    }

    protected void rollbackTransaction() {
        try {
            tx.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void rollbackTransaction(StringBuilder err) {
        if (!err.toString().isEmpty()) {
            try {
                tx.rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void endTransaction() {
        //Cerrando conexion
        if (em_ != null) {
            em_.close();
        }
    }

    protected SessionImpl getSess() {
        return sess;
    }

    public T find(Object id) {
        Object obj = getEntityManager().find(entityClass, id);
        //Evita problema two-session
        Object copy = SerialClone.clone(obj);
        return (T) copy;
    }

    private List<T> findList(String hql, boolean all, int firstReg, int maxReg) {
        EntityManager em = getEntityManager();
        List l = new ArrayList();
        try {
            Query q = em.createQuery(hql);
            if (!all) {
                q.setMaxResults(maxReg);
                q.setFirstResult(firstReg);
            }
            l = q.getResultList();
        } catch (Exception e) {
            System.out.println("Supertree3 dice FALLA, ejecutando HQL: " + hql);
            e.printStackTrace();
        }
        return l;
    }

    public List<T> findList(String hql, int firstReg, int maxReg) {
        return findList(hql, false, firstReg, maxReg);
    }

    public List<T> findList(String hql) {
        return findList(hql, true, 0, 0);
    }

    protected long countNative(String sql) {
        EntityManager em = getEntityManager();

        long cuenta = 0;
        try {
            Query q = em.createNativeQuery(sql);

            Object result = q.getSingleResult();

            if (result != null) {
                cuenta = Long.parseLong(result.toString());
            }
        } catch (Exception e) {
            System.out.println("Supertree3 dice FALLA, ejecutando SQL: " + sql);
            e.printStackTrace();
        }
        return cuenta;
    }

    protected long countGeneric(String hql) {
        EntityManager em = getEntityManager();

        long cuenta = 0;
        try {
            Query q = em.createQuery(hql);

            Object result = q.getSingleResult();

            if (result != null) {
                cuenta = Long.parseLong(result.toString());
            }
        } catch (Exception e) {
            System.out.println("Supertree3 dice FALLA, ejecutando HQL: " + hql);
            e.printStackTrace();
        }
        return cuenta;
    }

    private List findGeneric(String hql, boolean all, int firstReg, int maxReg) {
        EntityManager em = getEntityManager();
        List l = new ArrayList();
        try {
            Query q = em.createQuery(hql);
            if (!all) {
                q.setMaxResults(maxReg);
                q.setFirstResult(firstReg);
            }
            l = q.getResultList();
        } catch (Exception e) {
            System.out.println("Supertree3 dice FALLA, ejecutando HQL: " + hql);
            e.printStackTrace();
        }
        return l;
    }

    protected List findGeneric(String hql, int firstReg, int maxReg) {
        return findGeneric(hql, false, firstReg, maxReg);
    }

    protected List findGeneric(String hql) {
        return findGeneric(hql, true, 0, 0);
    }

    private List<T> find(String sql, Class classResult, boolean all, int firstReg, int maxReg) {
        EntityManager em = getEntityManager();
        List l = new ArrayList();
        try {
            Query q = em.createNativeQuery(sql, classResult);
            if (!all) {
                q.setMaxResults(maxReg);
                q.setFirstResult(firstReg);
            }
            l = q.getResultList();
        } catch (Exception e) {
            System.out.println("Supertree3 dice FALLA, ejecutando SQL: " + sql);
            e.printStackTrace();
        }
        return l;
    }

    protected List<T> find(String sql, Class classResult, int firstReg, int maxReg) {
        return find(sql, classResult, false, firstReg, maxReg);
    }

    protected List<T> find(String sql, Class classResult) {
        return find(sql, classResult, true, 0, 0);
    }

    private List<T> findNative(String sql, boolean all, int firstReg, int maxReg) {
        EntityManager em = getEntityManager();
        List l2 = new ArrayList();
        try {
            Query q = em.createNativeQuery(sql);
            if (!all) {
                q.setMaxResults(maxReg);
                q.setFirstResult(firstReg);
            }
            l2 = q.getResultList();
        } catch (Exception e) {
            System.out.println("Supertree3 dice FALLA, ejecutando SQL: " + sql);
            e.printStackTrace();
        }
        return l2;
    }

    protected List<T> findNative(String sql, int firstReg, int maxReg) {
        return findNative(sql, false, firstReg, maxReg);
    }

    protected List<T> findNative(String sql) {
        return findNative(sql, true, 0, 0);
    }

    private List findNative(String sql, boolean all, int firstReg, int maxReg, Class cla) {
        EntityManager em = getEntityManager();
        List l2 = new ArrayList();
        try {
            Query q = em.createNativeQuery(sql, cla);
            if (!all) {
                q.setMaxResults(maxReg);
                q.setFirstResult(firstReg);
            }
            l2 = q.getResultList();
        } catch (Exception e) {
            System.out.println("Supertree3 dice FALLA, ejecutando SQL: " + sql);
            e.printStackTrace();
        }
        return l2;
    }

    protected List findNative(String sql, int firstReg, int maxReg, Class cla) {
        return findNative(sql, false, firstReg, maxReg, cla);
    }

    protected List findNative(String sql, Class cla) {
        return findNative(sql, true, 0, 0, cla);
    }

    private List findNativeGeneric(String sql, boolean all, int firstReg, int maxReg) {
        EntityManager em = getEntityManager();
        List l2 = new ArrayList();
        try {
            Query q = em.createNativeQuery(sql);
            if (!all) {
                q.setMaxResults(maxReg);
                q.setFirstResult(firstReg);
            }
            l2 = q.getResultList();
        } catch (Exception e) {
            System.out.println("Supertree3 dice FALLA, ejecutando SQL: " + sql);
            e.printStackTrace();
        }
        return l2;
    }

    protected List findNativeGeneric(String sql, int firstReg, int maxReg) {
        return findNativeGeneric(sql, false, firstReg, maxReg);
    }

    protected List findNativeGeneric(String sql) {
        return findNativeGeneric(sql, true, 0, 0);
    }

    protected int deleteUpdateNative(String sql) {
        EntityManager em = getEntityManager();
        Query q = em.createNativeQuery(sql);
        return q.executeUpdate();
    }

    public int delete(Integer iddr) {
        return deleteUpdateNative("DELETE FROM Descuento_Rul WHERE iddr=" + iddr);
    }

    //DELEGATE
    public List<T> listAll(String attrOrd, String ascDesc, int firstReg, int maxReg) {
        String hql = "SELECT obj FROM " + entityClass.getCanonicalName() + " obj ORDER BY obj." + attrOrd + " " + ascDesc;
        return findList(hql, firstReg, maxReg);
    }

    protected <T> T numFromHQL(String hql, T valInit) {
        List l = findGeneric(hql);
        if (l.size() > 0 && l.get(0) != null) {
            return (T) l.get(0);
        } else {
            return valInit;
        }
    }

    protected <T> T numFromSQL(String sql, T valInit) {
        List l = findNative(sql);
        if (l.size() > 0 && l.get(0) != null) {
            return (T) l.get(0);
        } else {
            return valInit;
        }
    }

    protected T objectFromHQL(String hql) {
        List l = findGeneric(hql);
        if (l.size() > 0 && l.get(0) != null) {
            return (T) l.get(0);
        } else {
            return null;
        }
    }

    protected T objectFromSQL(String sql) {
        List l = findNative(sql, true, 0, 0, entityClass);
        if (l.size() > 0 && l.get(0) != null) {
            return (T) l.get(0);
        } else {
            return null;
        }
    }

    /*protected List<T> parseListLightFromHQL(String hql) {
        List<Object[]> lstObjs = findGeneric(hql);
        return new HqlLightUtil(entityClass).parseObjectLightList(hql, lstObjs);
    }

    protected List<T> parseListLightFromHQL(String hql, int firstReg, int maxReg) {
        List<Object[]> lstObjs = findGeneric(hql, firstReg, maxReg);
        return new HqlLightUtil(entityClass).parseObjectLightList(hql, lstObjs);
    }*/

 /*protected T parseObjectLightFromHQL(String hql, Object[] objs) {
     return new HqlLightUtil(entityClass).parseObjectLight(hql, objs);
     }*/
 /*protected List parseListLightFromHQL(String hql, Class classLoader) {
        List<Object[]> lstObjs = findGeneric(hql);
        return new HqlLightUtil(classLoader).parseObjectLightList(hql, lstObjs);
    }

    protected List parseListLightFromHQL(String hql, int firstReg, int maxReg, Class classLoader) {
        List<Object[]> lstObjs = findGeneric(hql, firstReg, maxReg);
        return new HqlLightUtil(classLoader).parseObjectLightList(hql, lstObjs);
    }

    protected Object parseObjectLightFromHQL(String hql, Object[] objs, Class classLoader) {
        return new HqlLightUtil(classLoader).parseObjectLight(hql, objs);
    }*/
}
