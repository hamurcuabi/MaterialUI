package com.emrhmrc.hateksdepoqr.depoQr.adapter.rcvadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.emrhmrc.hateksdepoqr.R;
import com.emrhmrc.hateksdepoqr.databinding.RcvViewproductinBoxesBinding;
import com.emrhmrc.hateksdepoqr.databinding.RcvViewproductinGenerateboxesBinding;
import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.ViewProductInGeneratedBox;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.GenericAdapter;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.OnItemClickListener;

public class RcvViewProductInGeneratedBoxesAdapter extends GenericAdapter<ViewProductInGeneratedBox,
        OnItemClickListener<ViewProductInGeneratedBox>,
        RcvViewProductInGeneratedBoxesViewHolder> {

    private Context context;

    public Context getContext() {
        return context;
    }


    public RcvViewProductInGeneratedBoxesAdapter(Context context, OnItemClickListener listener) {
        super(context, listener);
        this.context = context;


    }

    @Override
    public RcvViewProductInGeneratedBoxesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RcvViewproductinGenerateboxesBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.rcv_viewproductin_generateboxes, parent, false);
        return new RcvViewProductInGeneratedBoxesViewHolder(binding, getContext());

    }


    @Override
    public int getItemViewType(int position) {
        final ViewProductInGeneratedBox item = getItem(position);
        return position;
    }


}
