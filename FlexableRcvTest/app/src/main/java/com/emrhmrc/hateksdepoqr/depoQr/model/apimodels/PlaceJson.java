package com.emrhmrc.hateksdepoqr.depoQr.model.apimodels;

public class PlaceJson {
    private int PlaceId;
    private String PlaceName;

    public String getPlaceName() {
        return PlaceName;
    }

    public void setPlaceName(String placeName) {
        PlaceName = placeName;
    }

    public int getPlaceId() {
        return PlaceId;
    }

    public void setPlaceId(int placeId) {
        PlaceId = placeId;
    }
}