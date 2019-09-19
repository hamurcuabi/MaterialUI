package com.emrhmrc.hateksdepoqr.depoQr.model.apimodels;

import java.util.List;

public class PaletJson {

    private int PaletId;
    private String PaletName;
    private List<GeneratedBoxInBoxInPaletJsons> GeneratedBoxInBoxInPaletJsons;

    public List<GeneratedBoxInBoxInPaletJsons> getGeneratedBoxInBoxInPaletJsons() {
        return GeneratedBoxInBoxInPaletJsons;
    }

    public void setGeneratedBoxInBoxInPaletJsons(List<GeneratedBoxInBoxInPaletJsons> generatedBoxInBoxInPaletJsons) {
        GeneratedBoxInBoxInPaletJsons = generatedBoxInBoxInPaletJsons;
    }

    public PaletJson() {
    }

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
}