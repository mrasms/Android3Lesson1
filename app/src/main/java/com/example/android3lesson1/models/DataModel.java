package com.example.android3lesson1.models;

import java.io.Serializable;

public class DataModel implements Serializable {

    private String text;

    public DataModel(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
