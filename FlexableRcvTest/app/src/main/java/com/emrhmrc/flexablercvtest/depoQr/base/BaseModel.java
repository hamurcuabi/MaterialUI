package com.emrhmrc.flexablercvtest.depoQr.base;

import com.google.gson.annotations.Expose;

public class BaseModel {

    @Expose
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
