package com.emrhmrc.flexablercvtest.depoQr.model.apimodels;

import com.emrhmrc.flexablercvtest.depoQr.base.BaseModel;

public class ViewGeneratedPalet extends BaseModel {

     /*"Id": 7,
             "MemberId": 1,
             "PaletId": 9,
             "PaletQr": "P0000007",
             "StateId": 1,
             "PlaceId": 1,
             "IsPrinted": false,
             "PrintedDate": null,
             "Date": "2019-09-16T11:05:17",
             "Name": "admin",
             "PlaceName": "Konfeksiyon",
             "StateName": "OK"


}*/

    private int Id;
    private int MemberId;
    private int PaletId;
    private String PaletQr;
    private int StateId;
    private int PlaceId;
    private boolean IsPrinted;
    private String Name;
    private String PlaceName;

    public ViewGeneratedPalet() {
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

    public int getPaletId() {
        return PaletId;
    }

    public void setPaletId(int paletId) {
        PaletId = paletId;
    }

    public String getPaletQr() {
        return PaletQr;
    }

    public void setPaletQr(String paletQr) {
        PaletQr = paletQr;
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPlaceName() {
        return PlaceName;
    }

    public void setPlaceName(String placeName) {
        PlaceName = placeName;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
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

    private String StateName;
    private String PrintedDate;
    private String Date;


}
