package com.emrhmrc.flexablercvtest.depoQr.model.apimodels;

import com.emrhmrc.flexablercvtest.depoQr.base.BaseModel;

public class ViewProductInGeneratedBox extends BaseModel {

   /* "Id": 9,
            "MemberId": 1,
            "BoxQr": "B0000009",
            "ProductId": 16,
            "ProductTexttileId": 207,
            "ProductCode": "Mavi Havlu",
            "ProductCount": 1,
            "MemberName": "admin",
            "StateId": 1,
            "StateName": "OK",
            "PlaceId": 1,
            "PlaceName": "Konfeksiyon"*/

    private int Id;
    private int MemberId;
    private String BoxQr;
    private String MemberName;
    private String ProductCode;
    private String StateName;

    public ViewProductInGeneratedBox() {
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

    public String getBoxQr() {
        return BoxQr;
    }

    public void setBoxQr(String boxQr) {
        BoxQr = boxQr;
    }

    public String getMemberName() {
        return MemberName;
    }

    public void setMemberName(String memberName) {
        MemberName = memberName;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String productCode) {
        ProductCode = productCode;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public String getPlaceName() {
        return PlaceName;
    }

    public void setPlaceName(String placeName) {
        PlaceName = placeName;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public int getPlaceId() {
        return PlaceId;
    }

    public void setPlaceId(int placeId) {
        PlaceId = placeId;
    }

    public int getProductCount() {
        return ProductCount;
    }

    public void setProductCount(int productCount) {
        ProductCount = productCount;
    }

    public int getStateId() {
        return StateId;
    }

    public void setStateId(int stateId) {
        StateId = stateId;
    }

    public int getProductTexttileId() {
        return ProductTexttileId;
    }

    public void setProductTexttileId(int productTexttileId) {
        ProductTexttileId = productTexttileId;
    }

    private String PlaceName;
    private int ProductId;
    private int PlaceId;
    private int ProductCount;
    private int StateId;
    private int ProductTexttileId;


}
