package com.postRequest;

import java.util.ArrayList;
import java.util.List;

import com.hello.Values;

public class ValuesList {
    private List<Values> values;

    public ValuesList() {
    }

    public ValuesList(List<Values> values) {
        this.values = values;
    }

    public List<Values>getValues() {
        return values;
    }

    public void setValues(List<Values> values) {
        this.values = values;
    }
}
