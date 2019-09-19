package com.emrhmrc.hateksdepoqr.depoQr.model.apimodels;

import com.emrhmrc.hateksdepoqr.depoQr.base.BaseModel;
import com.emrhmrc.hateksdepoqr.depoQr.model.PaletJsonview;

import java.util.List;

public class ViewProductInPalet extends BaseModel {

    private PaletJsonview PaletJson;
    private List<BoxInPalets> BoxInPalets;

    public ViewProductInPalet() {
    }

    public PaletJsonview getPaletJson() {
        return PaletJson;
    }

    public void setPaletJson(PaletJsonview paletJson) {
        PaletJson = paletJson;
    }

    public List<BoxInPalets> getBoxInPalets() {
        return BoxInPalets;
    }

    public void setBoxInPalets(List<BoxInPalets> boxInPalets) {
        BoxInPalets = boxInPalets;
    }
}





