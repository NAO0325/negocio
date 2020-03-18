/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.util;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author inmoticamaster
 */
public class JsonUtil {

    public static <T> T jsonToObject(String json, Class<T> c) {
        T data = new Gson().fromJson(json, c);
        return data;
    }

    public static String objectToJson(Object obj) {
        return new Gson().toJson(obj);
    }

    public static void main(String... args) throws Exception {
        TestData td = new TestData();
        td.setId(new Long(1));
        td.setName("First");
        td.getLstD().add("A");
        td.getLstD().add("B");
        td.getLstD().add("C");

        System.out.println("JSON:" + objectToJson(td));

        String json = "{\"id\":1,\"name\":\"First\",\"lstD\":[\"A\",\"B\",\"C\"]}";
        TestData tdRes = jsonToObject(json, TestData.class);
        System.out.println("ID:" + tdRes.getId());

        System.out.println("Example 2 -------------------------");
        json = "{data:[{\"id\":1,\"name\":\"First\",\"lstD\":[\"A\",\"B\",\"C\"]},{\"id\":2,\"name\":\"Second\",\"lstD\":[\"X\",\"Y\",\"Z\"]}]}";
        List<TestData> lstD = jsonToObject(json, TestData.class).getData();
        System.out.println("Size:"+lstD.size());

    }

}

class TestData {

    private Long id;
    private String name;
    private List<String> lstD = new ArrayList<>();
    private List<TestData> data = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLstD() {
        return lstD;
    }

    public void setLstD(List<String> lstD) {
        this.lstD = lstD;
    }

    public List<TestData> getData() {
        return data;
    }

    public void setData(List<TestData> data) {
        this.data = data;
    }

}
