package com.emrhmrc.hateksdepoqr.depoQr.adapter.rcvadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.emrhmrc.hateksdepoqr.depoQr.model.Product;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.GenericAdapter;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.OnItemClickListener;
import com.emrhmrc.hateksdepoqr.R;
import com.emrhmrc.hateksdepoqr.databinding.RecyclerItemProductBinding;

public class RcvProductAdapter extends GenericAdapter<Product,
        OnItemClickListener<Product>,
        RcvProductViewHolder> {


    public RcvProductAdapter(Context context, OnItemClickListener listener) {
        super(context, listener);


    }

    @Override
    public RcvProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerItemProductBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.recycler_item_product, parent, false);
        return new RcvProductViewHolder(binding);

    }


    @Override
    public int getItemViewType(int position) {
        final Product item = getItem(position);
        return position;
    }


}
