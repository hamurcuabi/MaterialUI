package com.emrhmrc.flexablercvtest.depoQr.model;

import com.emrhmrc.flexablercvtest.depoQr.base.BaseModel;

import java.util.ArrayList;
import java.util.List;

public class ProductInBox extends BaseModel {

    private int BoxId;
    private String BoxName;
    private List<SubProductItem> subProductItemList;

    public ProductInBox() {
        subProductItemList=new ArrayList<>();
    }

    public List<SubProductItem> getSubProductItemList() {
        return subProductItemList;
    }

    public void setSubProductItemList(List<SubProductItem> subProductItemList) {
        this.subProductItemList = subProductItemList;
    }

    public int getBoxId() {
        return BoxId;
    }

    public void setBoxId(int boxId) {
        BoxId = boxId;
    }

    public String getBoxName() {
        return BoxName;
    }

    public void setBoxName(String boxName) {
        BoxName = boxName;
    }

    public static class SubProductItem {
        private String ProductName;
        private int ProductCount;

        public SubProductItem() {
        }

        public String getProductName() {
            return ProductName;
        }

        public void setProductName(String productName) {
            ProductName = productName;
        }

        public int getProductCount() {
            return ProductCount;
        }

        public void setProductCount(int productCount) {
            ProductCount = productCount;
        }
    }

}
