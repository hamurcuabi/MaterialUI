package com.emrhmrc.hateksdepoqr.depoQr.model.apimodels;

import com.emrhmrc.hateksdepoqr.depoQr.base.BaseModel;

public class ViewGeneratedBox extends BaseModel {

    /*public int Id { get; set; }
    public String BoxQr { get; set; }
    public MemberJson MemberJson;
    public List<ProductJson> ProductJsons;
    public StateJson StateJson;
    public PlaceJson PlaceJson;*/

    private int Id;
    private int MemberId;
    private int StateId;
    private int PlaceId;
    private int BoxId;
    private String BoxQr;
    private String Name;
    private String PlaceName;
    private String StateName;
    private String PrintedDate;
    private String Date;

    public ViewGeneratedBox() {
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

    public boolean isPrinted() {
        return IsPrinted;
    }

    public void setPrinted(boolean printed) {
        IsPrinted = printed;
    }

    private boolean IsPrinted;
}
