package com.emrhmrc.hateksdepoqr.depoQr.model.apimodels;

import java.util.List;

public class BoxInPalets {

    private int BoxMemberId;
    private int BoxStateId;
    private int GeneratedBoxId;
    private int BoxCount;
    private String BoxMemberName;
    private String BoxQr;
    private String BoxStateName;
    private String BoxPlace;
    private List<ProductInBox> ProductInBox;

    public BoxInPalets() {
    }

    public int getBoxMemberId() {
        return BoxMemberId;
    }

    public void setBoxMemberId(int boxMemberId) {
        BoxMemberId = boxMemberId;
    }

    public int getBoxStateId() {
        return BoxStateId;
    }

    public void setBoxStateId(int boxStateId) {
        BoxStateId = boxStateId;
    }

    public int getGeneratedBoxId() {
        return GeneratedBoxId;
    }

    public void setGeneratedBoxId(int generatedBoxId) {
        GeneratedBoxId = generatedBoxId;
    }

    public int getBoxCount() {
        return BoxCount;
    }

    public void setBoxCount(int boxCount) {
        BoxCount = boxCount;
    }

    public String getBoxMemberName() {
        return BoxMemberName;
    }

    public void setBoxMemberName(String boxMemberName) {
        BoxMemberName = boxMemberName;
    }

    public String getBoxQr() {
        return BoxQr;
    }

    public void setBoxQr(String boxQr) {
        BoxQr = boxQr;
    }

    public String getBoxStateName() {
        return BoxStateName;
    }

    public void setBoxStateName(String boxStateName) {
        BoxStateName = boxStateName;
    }

    public String getBoxPlace() {
        return BoxPlace;
    }

    public void setBoxPlace(String boxPlace) {
        BoxPlace = boxPlace;
    }

    public List<com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.ProductInBox> getProductInBox() {
        return ProductInBox;
    }

    public void setProductInBox(List<com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.ProductInBox> productInBox) {
        ProductInBox = productInBox;
    }
}
