package com.emrhmrc.flexablercvtest.depoQr.adapter.rcvadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.emrhmrc.flexablercvtest.R;
import com.emrhmrc.flexablercvtest.databinding.RcvBasebottomsheetmodelBinding;
import com.emrhmrc.flexablercvtest.databinding.RcvProductBottomsheetBinding;
import com.emrhmrc.flexablercvtest.depoQr.model.BottomSheetModel;
import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.Product;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.GenericAdapter;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.OnItemClickListener;

public class RcvBaseBottomsheetAdapter extends GenericAdapter<BottomSheetModel,
        OnItemClickListener<BottomSheetModel>,
        RcvBaseBottomSheetViewHolder> {


    public RcvBaseBottomsheetAdapter(Context context, OnItemClickListener listener) {
        super(context, listener);

    }

    @Override
    public RcvBaseBottomSheetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RcvBasebottomsheetmodelBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.rcv_basebottomsheetmodel, parent, false);
        return new RcvBaseBottomSheetViewHolder(binding);

    }


    @Override
    public int getItemViewType(int position) {
        final BottomSheetModel item = getItem(position);
        return position;
    }


}
