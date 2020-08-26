package com.tutorial.student_service.models;

import java.util.Dictionary;
import java.util.Hashtable;

import org.springframework.stereotype.Component;

@Component
public class SendResponse {

    public Object getData() {
        return data;
    }

    public void setData(String key, Object value) {
        Dictionary<String, Object> setData = new Hashtable<String, Object>();
        setData.put(key, value);
        this.data = setData;
    }

    Object data;
}
