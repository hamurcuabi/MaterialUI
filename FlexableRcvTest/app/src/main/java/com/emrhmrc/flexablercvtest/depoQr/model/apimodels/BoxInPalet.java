package com.emrhmrc.flexablercvtest.depoQr.model.apimodels;

import com.emrhmrc.flexablercvtest.depoQr.base.BaseModel;

public class BoxInPalet extends BaseModel {

    private int Id;
    private int BoxCoun;
    private int GeneratedBoxId;
    private int PaletId;
    private int MemberId;
    private String Date;

    public BoxInPalet() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getBoxCoun() {
        return BoxCoun;
    }

    public void setBoxCoun(int boxCoun) {
        BoxCoun = boxCoun;
    }

    public int getGeneratedBoxId() {
        return GeneratedBoxId;
    }

    public void setGeneratedBoxId(int generatedBoxId) {
        GeneratedBoxId = generatedBoxId;
    }

    public int getPaletId() {
        return PaletId;
    }

    public void setPaletId(int paletId) {
        PaletId = paletId;
    }

    public int getMemberId() {
        return MemberId;
    }

    public void setMemberId(int memberId) {
        MemberId = memberId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
