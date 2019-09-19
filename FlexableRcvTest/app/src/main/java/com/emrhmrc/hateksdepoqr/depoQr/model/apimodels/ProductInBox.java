package com.emrhmrc.hateksdepoqr.depoQr.model.apimodels;

public class ProductInBox {
    private int ProductCount;
    private String ProductCode;

    public ProductInBox() {
    }

    public int getProductCount() {
        return ProductCount;
    }

    public void setProductCount(int productCount) {
        ProductCount = productCount;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String productCode) {
        ProductCode = productCode;
    }
}