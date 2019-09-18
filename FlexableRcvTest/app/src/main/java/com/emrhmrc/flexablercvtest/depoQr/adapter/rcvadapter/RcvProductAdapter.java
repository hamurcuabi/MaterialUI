package com.emrhmrc.flexablercvtest.depoQr.adapter.rcvadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.emrhmrc.flexablercvtest.depoQr.model.Product;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.GenericAdapter;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.OnItemClickListener;
import com.emrhmrc.flexablercvtest.R;
import com.emrhmrc.flexablercvtest.databinding.RecyclerItemProductBinding;

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
