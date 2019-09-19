package com.emrhmrc.hateksdepoqr.depoQr.model;

import java.util.List;

public class BoxInPalet {
    private List<ProductInBox> productInBoxes;

    public List<ProductInBox> getProductInBoxes() {

        return productInBoxes;
    }

    public void setProductInBoxes(List<ProductInBox> productInBoxes) {
        this.productInBoxes = productInBoxes;
    }

    private int PaletId;

    public int getPaletId() {
        return PaletId;
    }

    public void setPaletId(int paletId) {
        PaletId = paletId;
    }

    public String getPaletName() {
        return PaletName;
    }

    public void setPaletName(String paletName) {
        PaletName = paletName;
    }

    private String PaletName;

    public String getSubProductItemCount() {

        int count = 0;
        for (ProductInBox item : getProductInBoxes()
        ) {

            count += item.getSubProductItemList().size();

        }

        return String.valueOf(count);

    }


}
