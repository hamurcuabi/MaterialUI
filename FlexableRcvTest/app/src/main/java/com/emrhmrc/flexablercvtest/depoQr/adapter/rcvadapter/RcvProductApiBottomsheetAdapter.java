package com.emrhmrc.flexablercvtest.depoQr.adapter.rcvadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.emrhmrc.flexablercvtest.R;
import com.emrhmrc.flexablercvtest.databinding.RcvProductBinding;
import com.emrhmrc.flexablercvtest.databinding.RcvProductBottomsheetBinding;
import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.Product;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.GenericAdapter;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.OnItemClickListener;

public class RcvProductApiBottomsheetAdapter extends GenericAdapter<Product,
        OnItemClickListener<Product>,
        RcvProductApiBottomSheetViewHolder> {


    public RcvProductApiBottomsheetAdapter(Context context, OnItemClickListener listener) {
        super(context, listener);

    }

    @Override
    public RcvProductApiBottomSheetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RcvProductBottomsheetBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.rcv_product_bottomsheet, parent, false);
        return new RcvProductApiBottomSheetViewHolder(binding);

    }


    @Override
    public int getItemViewType(int position) {
        final Product item = getItem(position);
        return position;
    }


}
