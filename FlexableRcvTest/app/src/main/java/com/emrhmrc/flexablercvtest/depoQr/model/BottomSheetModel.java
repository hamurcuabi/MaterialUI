package com.emrhmrc.flexablercvtest.depoQr.model;

import java.util.Date;

public class BottomSheetModel {

    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    private String header;
    private int count;

    public BottomSheetModel(int Id , String header, int count) {
        this.header = header;
        this.count = count;
        this.Id=Id;
    }

    public BottomSheetModel() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
