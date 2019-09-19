package com.emrhmrc.hateksdepoqr.depoQr.adapter.rcvadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.emrhmrc.hateksdepoqr.R;
import com.emrhmrc.hateksdepoqr.databinding.RecyclerItemProductBinding;
import com.emrhmrc.hateksdepoqr.databinding.RecyclerItemProductinboxProductBinding;
import com.emrhmrc.hateksdepoqr.depoQr.model.ProductInBox;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.GenericAdapter;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.OnItemClickListener;

public class RcvProductInBoxProductAdapter extends GenericAdapter<ProductInBox.SubProductItem,
        OnItemClickListener<ProductInBox.SubProductItem>,
        RcvProductInBoxProductViewHolder> {


    public RcvProductInBoxProductAdapter(Context context, OnItemClickListener listener) {
        super(context, listener);


    }

    @Override
    public RcvProductInBoxProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerItemProductinboxProductBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.recycler_item_productinbox_product, parent, false);
        return new RcvProductInBoxProductViewHolder(binding);

    }


    @Override
    public int getItemViewType(int position) {
        final ProductInBox.SubProductItem item = getItem(position);
        return position;
    }


}
