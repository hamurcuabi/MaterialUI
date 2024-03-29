package com.emrhmrc.hateksdepoqr.depoQr.adapter.rcvadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.emrhmrc.hateksdepoqr.R;
import com.emrhmrc.hateksdepoqr.databinding.RcvProductBinding;
import com.emrhmrc.hateksdepoqr.databinding.RecyclerItemProductBinding;
import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.Product;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.GenericAdapter;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.OnItemClickListener;

public class RcvProductApiAdapter extends GenericAdapter<Product,
        OnItemClickListener<Product>,
        RcvProductApiViewHolder> {


    public RcvProductApiAdapter(Context context, OnItemClickListener listener) {
        super(context, listener);

    }

    @Override
    public RcvProductApiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RcvProductBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.rcv_product, parent, false);
        return new RcvProductApiViewHolder(binding);

    }


    @Override
    public int getItemViewType(int position) {
        final Product item = getItem(position);
        return position;
    }


}
