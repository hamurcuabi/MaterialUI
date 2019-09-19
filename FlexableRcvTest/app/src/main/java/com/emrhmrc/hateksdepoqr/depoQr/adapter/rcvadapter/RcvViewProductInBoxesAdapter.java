package com.emrhmrc.hateksdepoqr.depoQr.adapter.rcvadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.emrhmrc.hateksdepoqr.R;
import com.emrhmrc.hateksdepoqr.databinding.RcvViewproductinBoxesBinding;
import com.emrhmrc.hateksdepoqr.databinding.RecyclerItemProductinboxBinding;
import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.ViewProductInBox;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.GenericAdapter;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.OnItemClickListener;

public class RcvViewProductInBoxesAdapter extends GenericAdapter<ViewProductInBox,
        OnItemClickListener<ViewProductInBox>,
        RcvViewProductInBoxesViewHolder> {

    private Context context;

    public Context getContext() {
        return context;
    }


    public RcvViewProductInBoxesAdapter(Context context, OnItemClickListener listener) {
        super(context, listener);
        this.context = context;


    }

    @Override
    public RcvViewProductInBoxesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RcvViewproductinBoxesBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.rcv_viewproductin_boxes, parent, false);
        return new RcvViewProductInBoxesViewHolder(binding, getContext());

    }


    @Override
    public int getItemViewType(int position) {
        final ViewProductInBox item = getItem(position);
        return position;
    }


}
