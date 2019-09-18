package com.emrhmrc.flexablercvtest.depoQr.model.apimodels;

import com.emrhmrc.flexablercvtest.depoQr.base.BaseModel;

import java.util.List;

public class ViewProductInBox extends BaseModel {

    private MemberJson MemberJson;
    private BoxJson BoxJson;
    private List<ProductJsons> ProductJsons;

    public ViewProductInBox() {
    }

    public MemberJson getMemberJson() {
        return MemberJson;
    }

    public void setMemberJson(MemberJson memberJson) {
        MemberJson = memberJson;
    }

    public BoxJson getBoxJson() {
        return BoxJson;
    }

    public void setBoxJson(BoxJson boxJson) {
        BoxJson = boxJson;
    }

    public List<ProductJsons> getProductJsons() {
        return ProductJsons;
    }

    public void setProductJsons(List<ProductJsons> productJsons) {
        ProductJsons = productJsons;
    }
}


