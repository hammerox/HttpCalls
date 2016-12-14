package com.hammerox.retrofit.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignIn {

    private Integer count;
    private List<Person> data = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     *
     * @return
     * The data
     */
    public List<Person> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(List<Person> data) {
        this.data = data;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}