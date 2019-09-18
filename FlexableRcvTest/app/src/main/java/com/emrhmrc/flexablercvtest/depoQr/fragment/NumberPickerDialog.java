package com.emrhmrc.flexablercvtest.depoQr.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.NumberPicker;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.emrhmrc.flexablercvtest.R;

public class NumberPickerDialog extends DialogFragment {
    private int defaultCount;
    private NumberPicker.OnValueChangeListener valueChangeListener;

    public NumberPickerDialog(int count) {
        this.defaultCount = count;

    }

    public NumberPickerDialog() {
        this.defaultCount = 1;

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        final NumberPicker numberPicker = new NumberPicker(getActivity());
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(20);
        numberPicker.setValue(defaultCount);


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Miktarı Seçiniz");

        // builder.setMessage("Choose a number :");
        builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                valueChangeListener.onValueChange(numberPicker,
                        numberPicker.getValue(), numberPicker.getValue());
            }
        });

       /* builder.setNegativeButton("İPTAL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                valueChangeListener.onValueChange(numberPicker,
                        numberPicker.getValue(), numberPicker.getValue());
            }
        });*/

        builder.setView(numberPicker);
        return builder.create();
    }

    public NumberPicker.OnValueChangeListener getValueChangeListener() {
        return valueChangeListener;
    }

    public void setValueChangeListener(NumberPicker.OnValueChangeListener valueChangeListener) {
        this.valueChangeListener = valueChangeListener;
    }
}
