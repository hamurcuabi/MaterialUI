package com.emrhmrc.hateksdepoqr.depoQr.model.apimodels;

import com.emrhmrc.hateksdepoqr.depoQr.base.BaseModel;

import java.util.List;

public class ViewProductInGeneratedBox extends BaseModel {


    private int Id;
    private String BoxQr;
    private MemberJson MemberJson;
    private List<ProductJsons> ProductJsons;
    private State StateJson;
    private PlaceJson PlaceJson;

    public ViewProductInGeneratedBox() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getBoxQr() {
        return BoxQr;
    }

    public void setBoxQr(String boxQr) {
        BoxQr = boxQr;
    }

    public com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.MemberJson getMemberJson() {
        return MemberJson;
    }

    public void setMemberJson(com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.MemberJson memberJson) {
        MemberJson = memberJson;
    }

    public List<com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.ProductJsons> getProductJsons() {
        return ProductJsons;
    }

    public void setProductJsons(List<com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.ProductJsons> productJsons) {
        ProductJsons = productJsons;
    }

    public State getStateJson() {
        return StateJson;
    }

    public void setStateJson(State stateJson) {
        StateJson = stateJson;
    }

    public com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.PlaceJson getPlaceJson() {
        return PlaceJson;
    }

    public void setPlaceJson(com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.PlaceJson placeJson) {
        PlaceJson = placeJson;
    }
}
