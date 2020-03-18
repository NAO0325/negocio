/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.control.general;

import com.negocio.facade.general.AbstractFacade;
import com.negocio.util.EntityUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

public abstract class AbstractControl<T> {

    private Class<T> entityClass;
    protected T obj;
    protected long totalConsulta = 0;
    protected String valBusq;//Valor de busqueda
    protected boolean successful = false;
    protected int firstRegLista = 0;
    protected int maxRegLista = 25;
    protected List<T> lst = new ArrayList<>();
    protected List lstGeneral = new ArrayList();
    protected String attrOrd;
    protected String ascDesc;

    protected FacesUtil facesUtil = FacesUtil.currentInstance();

    protected abstract AbstractFacade getFacade();

    protected abstract String displayObj(T obj);

    public AbstractControl(Class<T> entityClass) {
        this.entityClass = entityClass;
        try {
            obj = entityClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void recuperaById() {
        String val = facesUtil.getFacesParamValue(EntityUtil.getAttrId(entityClass) + "_");
        recuperaByIdValue(val);
    }

   
    public void recuperaByIdValue(String id) {
        Object pk = null;
        Class cPk = EntityUtil.getAttrIdClass(entityClass);

        if (cPk.equals(Long.class)) {
            pk = new Long(id);
        }
        if (cPk.equals(Integer.class)) {
            pk = new Integer(id);
        }
        if (cPk.equals(String.class)) {
            pk = id;
        }
        if (pk == null) {
            System.err.println("ALERTA AbstracControl negocio : el tipo de dato de la llave primaria no está programado !!!");
        }

        obj = (T) getFacade().find(pk);
    }

    public List<SelectItem> selectAll() {
        List<SelectItem> lstS = new ArrayList<>();
        lstS.add(new SelectItem(null, "---"));

        List<T> lstObj = getFacade().listAllLight(attrOrd, ascDesc);
        for (T obj : lstObj) {
            SelectItem it = new SelectItem(obj, displayObj(obj));
            lstS.add(it);
        }
        return lstS;
    }

    protected List<SelectItem> selectItems(List<T> lstObjs) {
        List<SelectItem> lstS = new ArrayList<>();
        lstS.add(new SelectItem(null, "---"));

        for (T obj : lstObjs) {
            SelectItem it = new SelectItem(obj, displayObj(obj));
            lstS.add(it);
        }
        return lstS;
    }

    public List<T> autoCompleteAllRegLight(String query) {
        return getFacade().listFullTextSearchLight(query, attrOrd, ascDesc);
    }

    public List<T> autoCompleteWithMaxRegLight(String query) {
        return getFacade().listFullTextSearchLight(query, attrOrd, ascDesc, 0, maxRegLista);
    }

    public List<T> autoCompleteWithMaxReg_NoLight(String query) {
        return getFacade().listFullTextSearch_NoLight(query, attrOrd, ascDesc, 0, maxRegLista);
    }

    public void createDefault() {
        successful = false;
        StringBuilder err = new StringBuilder();
        getFacade().create(obj, err);
        if (err.toString().trim().isEmpty()) {
            facesUtil.msgOk("", "Registro Creado !");
            successful = true;
        } else {
            facesUtil.msgError("ALERTA", err.toString());
            successful = false;
        }
    }

    public void editDefault() {
        successful = false;
        StringBuilder err = new StringBuilder();
        getFacade().edit(obj, err);
        if (err.toString().trim().isEmpty()) {
            facesUtil.msgOk("", "Registro Actualizado !");
            successful = true;
        } else {
            facesUtil.msgError("ALERTA", err.toString());
            successful = false;
        }
    }

    public void deleteDefault(Object valueID) {
        successful = false;
        StringBuilder err = new StringBuilder();
        getFacade().delete(valueID, err);
        if (err.toString().trim().isEmpty()) {
            facesUtil.msgOk("", "Registro eliminado !");
            successful = true;
        } else {
            facesUtil.msgError("ALERTA", err.toString());
            successful = false;
        }
    }

    public void recuperaCountTotalReg() {
        totalConsulta = getFacade().countAll();
    }

    private void recuperaAllRegPaginationLight(boolean isLight) {
        int first = facesUtil.getFacesParamInteger("pag_") * maxRegLista;

        String cOrder = facesUtil.getFacesParamValue("cOrder_");
        if (cOrder != null && !cOrder.trim().isEmpty()) {
            attrOrd = cOrder;
        }
        String ascDesc_ = facesUtil.getFacesParamValue("ascDesc_");

        if (ascDesc_ != null && !ascDesc_.trim().isEmpty()) {
            ascDesc = ascDesc_;
        }

        if (isLight) {
            lst = getFacade().listAllLight(attrOrd, ascDesc, first, maxRegLista);
        } else {
            lst = getFacade().listAll(attrOrd, ascDesc, first, maxRegLista);
        }
    }

    public void buscarLigth() {
        buscar(true);
    }

    public void buscarNoLigth() {
        buscar(false);
    }

    public void recuperaBuscarCount() {
        totalConsulta = getFacade().countFullTextSearch(valBusq);
    }

    private void buscar(boolean isLight) {
        int first = facesUtil.getFacesParamInteger("pag_") * maxRegLista;

        String cOrder = facesUtil.getFacesParamValue("cOrder_");
        if (cOrder != null && !cOrder.trim().isEmpty()) {
            attrOrd = cOrder;
        }
        String ascDesc_ = facesUtil.getFacesParamValue("ascDesc_");

        if (ascDesc_ != null && !ascDesc_.trim().isEmpty()) {
            ascDesc = ascDesc_;
        }

        if (isLight) {
            lst = getFacade().listFullTextSearchLightHtmlResult(valBusq, attrOrd, ascDesc, first, maxRegLista);
        } else {
            lst = getFacade().listFullTextSearchHtmlResult_NoLight(valBusq, attrOrd, ascDesc, first, maxRegLista);
        }
    }

    public void recuperaAllRegPaginationLight() {
        recuperaAllRegPaginationLight(true);
    }

    public void recuperaAllRegPaginationNoLight() {
        recuperaAllRegPaginationLight(false);
    }

    public void setObj(Object obj) {
        this.obj = entityClass.cast(obj);
    }

    public T getObj() {
        return obj;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public long getTotalConsulta() {
        return totalConsulta;
    }

    public void setTotalConsulta(long totalConsulta) {
        this.totalConsulta = totalConsulta;
    }

    public String getValBusq() {
        return valBusq;
    }

    public void setValBusq(String valBusq) {
        this.valBusq = valBusq;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public int getFirstRegLista() {
        return firstRegLista;
    }

    public void setFirstRegLista(int firstRegLista) {
        this.firstRegLista = firstRegLista;
    }

    public int getMaxRegLista() {
        return maxRegLista;
    }

    public void setMaxRegLista(int maxRegLista) {
        this.maxRegLista = maxRegLista;
    }

    public List<T> getLst() {
        return lst;
    }

    public void setLst(List<T> lst) {
        this.lst = lst;
    }

    public List getLstGeneral() {
        return lstGeneral;
    }

    public void setLstGeneral(List lstGeneral) {
        this.lstGeneral = lstGeneral;
    }

    public String getAttrOrd() {
        return attrOrd;
    }

    public void setAttrOrd(String attrOrd) {
        this.attrOrd = attrOrd;
    }

    public String getAscDesc() {
        return ascDesc;
    }

    public void setAscDesc(String ascDesc) {
        this.ascDesc = ascDesc;
    }

}
