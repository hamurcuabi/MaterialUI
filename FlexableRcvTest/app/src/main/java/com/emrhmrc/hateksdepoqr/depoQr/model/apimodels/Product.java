package com.emrhmrc.hateksdepoqr.depoQr.model.apimodels;

import com.emrhmrc.hateksdepoqr.depoQr.base.BaseModel;
import com.google.gson.annotations.Expose;

public class Product extends BaseModel {

    private int Id;
    private int ProductId;
    private String ProductCode;
    @Expose
    private int Count = 1;

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }


    public Product() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String productCode) {
        ProductCode = productCode;
    }
}
