package com.emrhmrc.flexablercvtest.depoQr.adapter.rcvadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.emrhmrc.flexablercvtest.R;
import com.emrhmrc.flexablercvtest.databinding.RecyclerItemProductBinding;
import com.emrhmrc.flexablercvtest.databinding.RecyclerItemProductinboxProductBinding;
import com.emrhmrc.flexablercvtest.depoQr.model.Product;
import com.emrhmrc.flexablercvtest.depoQr.model.ProductInBox;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.GenericAdapter;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.OnItemClickListener;

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
