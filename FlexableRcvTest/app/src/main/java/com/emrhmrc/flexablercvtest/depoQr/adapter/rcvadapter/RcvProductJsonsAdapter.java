package com.emrhmrc.flexablercvtest.depoQr.adapter.rcvadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.emrhmrc.flexablercvtest.R;
import com.emrhmrc.flexablercvtest.databinding.RcvProductJsonsBinding;
import com.emrhmrc.flexablercvtest.databinding.RecyclerItemProductinboxProductBinding;
import com.emrhmrc.flexablercvtest.depoQr.model.ProductInBox;
import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.ProductJsons;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.GenericAdapter;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.OnItemClickListener;

public class RcvProductJsonsAdapter extends GenericAdapter<ProductJsons,
        OnItemClickListener<ProductJsons>,
        RcvProductJsonsViewHolder> {


    public RcvProductJsonsAdapter(Context context, OnItemClickListener listener) {
        super(context, listener);


    }

    @Override
    public RcvProductJsonsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RcvProductJsonsBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.rcv_product_jsons, parent, false);
        return new RcvProductJsonsViewHolder(binding);

    }


    @Override
    public int getItemViewType(int position) {
        final ProductJsons item = getItem(position);
        return position;
    }


}
