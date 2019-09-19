package com.emrhmrc.hateksdepoqr.depoQr.model.apimodels;

import com.emrhmrc.hateksdepoqr.depoQr.base.BaseModel;

public class GeneratedBox extends BaseModel {

    private int Id;
    private int MemberId;
    private int BoxId;
    private String BoxQr;
    private int StateId;
    private int PlaceId;
    private boolean IsPrinted;
    private String PrintedDate;
    private String Date;

    public GeneratedBox() {
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

    public int getBoxId() {
        return BoxId;
    }

    public void setBoxId(int boxId) {
        BoxId = boxId;
    }

    public String getBoxQr() {
        return BoxQr;
    }

    public void setBoxQr(String boxQr) {
        BoxQr = boxQr;
    }

    public int getStateId() {
        return StateId;
    }

    public void setStateId(int stateId) {
        StateId = stateId;
    }

    public int getPlaceId() {
        return PlaceId;
    }

    public void setPlaceId(int placeId) {
        PlaceId = placeId;
    }

    public boolean isPrinted() {
        return IsPrinted;
    }

    public void setPrinted(boolean printed) {
        IsPrinted = printed;
    }

    public String getPrintedDate() {
        return PrintedDate;
    }

    public void setPrintedDate(String printedDate) {
        PrintedDate = printedDate;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
