package com.emrhmrc.motionsteel.ocr.others;

import android.support.annotation.Nullable;

public class ResultHolder {

    private static byte[] image;


    @Nullable
    public static byte[] getImage() {
        return image;
    }

    public static void setImage(@Nullable byte[] image) {
        ResultHolder.image = image;
    }

}
