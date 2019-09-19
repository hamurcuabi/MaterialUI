package com.emrhmrc.hateksdepoqr.depoQr.adapter.rcvadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.emrhmrc.hateksdepoqr.R;
import com.emrhmrc.hateksdepoqr.databinding.RcvBasebottomsheetmodelBinding;
import com.emrhmrc.hateksdepoqr.databinding.RcvProductBottomsheetBinding;
import com.emrhmrc.hateksdepoqr.depoQr.model.BottomSheetModel;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.GenericAdapter;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.OnItemClickListener;

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
