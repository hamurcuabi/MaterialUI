package com.emrhmrc.hateksdepoqr.depoQr.model;

import com.emrhmrc.hateksdepoqr.depoQr.base.BaseModel;

public class Product extends BaseModel {

    private int Id;
    private int ProductId;
    private String ProductCode;
    private int Count = 1;

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public Product() {
        setChecked(false);

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
