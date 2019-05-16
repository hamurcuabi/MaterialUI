package com.emrhmrc.motionsteel.ocr.others;

public interface TranslateCallback {
    void onSuccess(String translatedText);
    void onFailure();
}
