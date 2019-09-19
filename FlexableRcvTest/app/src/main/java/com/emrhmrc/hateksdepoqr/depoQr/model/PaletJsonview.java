package com.emrhmrc.hateksdepoqr.depoQr.model;

public class PaletJsonview {

    private int PaletId;
    private int PaletMemberId;
    private int PaletStateId;
    private String PaletPlace;
    private String PaletStateName;
    private String PaletMemberName;
    private String PaletQr;


    public PaletJsonview() {
    }

    public int getPaletId() {
        return PaletId;
    }

    public void setPaletId(int paletId) {
        PaletId = paletId;
    }

    public int getPaletMemberId() {
        return PaletMemberId;
    }

    public void setPaletMemberId(int paletMemberId) {
        PaletMemberId = paletMemberId;
    }

    public int getPaletStateId() {
        return PaletStateId;
    }

    public void setPaletStateId(int paletStateId) {
        PaletStateId = paletStateId;
    }

    public String getPaletPlace() {
        return PaletPlace;
    }

    public void setPaletPlace(String paletPlace) {
        PaletPlace = paletPlace;
    }

    public String getPaletStateName() {
        return PaletStateName;
    }

    public void setPaletStateName(String paletStateName) {
        PaletStateName = paletStateName;
    }

    public String getPaletMemberName() {
        return PaletMemberName;
    }

    public void setPaletMemberName(String paletMemberName) {
        PaletMemberName = paletMemberName;
    }

    public String getPaletQr() {
        return PaletQr;
    }

    public void setPaletQr(String paletQr) {
        PaletQr = paletQr;
    }

}