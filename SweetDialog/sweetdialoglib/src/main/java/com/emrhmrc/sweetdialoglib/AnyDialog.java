package com.emrhmrc.sweetdialoglib;

import android.app.Activity;
import android.graphics.Color;

public class AnyDialog {

    private Activity activity;
    private SweetAlertDialog dialog;

    public AnyDialog(Activity activity) {
        this.activity = activity;
    }

    public SweetAlertDialog loading(String title) {
        dialog = new SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE);
        dialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        dialog.setTitleText(title);
        dialog.setCancelable(false);
        return dialog;
    }
}
