package com.emrhmrc.hateksdepoqr.depoQr.model.apimodels;

import com.emrhmrc.hateksdepoqr.depoQr.base.BaseModel;

public class ProductInBoxes extends BaseModel {


    private int Id;
    private int MemberId;
    private int ProductId;
    private int BoxId;
    private int ProductCount;
    private String Date;

    public ProductInBoxes() {
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

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public int getBoxId() {
        return BoxId;
    }

    public void setBoxId(int boxId) {
        BoxId = boxId;
    }

    public int getProductCount() {
        return ProductCount;
    }

    public void setProductCount(int productCount) {
        ProductCount = productCount;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
