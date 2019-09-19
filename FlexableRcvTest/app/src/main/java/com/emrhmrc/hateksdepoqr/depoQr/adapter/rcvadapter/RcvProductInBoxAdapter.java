package com.emrhmrc.hateksdepoqr.depoQr.adapter.rcvadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.emrhmrc.hateksdepoqr.R;
import com.emrhmrc.hateksdepoqr.databinding.RecyclerItemProductinboxBinding;
import com.emrhmrc.hateksdepoqr.depoQr.model.ProductInBox;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.GenericAdapter;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.OnItemClickListener;

public class RcvProductInBoxAdapter extends GenericAdapter<ProductInBox,
        OnItemClickListener<ProductInBox>,
        RcvProductInBoxViewHolder> {

    private Context context;

    public Context getContext() {
        return context;
    }


    public RcvProductInBoxAdapter(Context context, OnItemClickListener listener) {
        super(context, listener);
        this.context = context;


    }

    @Override
    public RcvProductInBoxViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerItemProductinboxBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.recycler_item_productinbox, parent, false);
        return new RcvProductInBoxViewHolder(binding, getContext());

    }


    @Override
    public int getItemViewType(int position) {
        final ProductInBox item = getItem(position);
        return position;
    }


}
