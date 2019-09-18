package com.emrhmrc.flexablercvtest.depoQr.model.apimodels;

import com.emrhmrc.flexablercvtest.depoQr.base.BaseModel;

public class Palet extends BaseModel {
    /*"Id": 9,
            "MemberId": 1,
            "Name": "Palet-0000009",
            "Date": "2019-09-16T11:04:20.14"*/

    private int Id;
    private int MemberId;
    private String Name;
    private String Date;

    public Palet() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getMemberId() {
        return MemberId;
    }

    public void setMemberId(int memberId) {
        MemberId = memberId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
