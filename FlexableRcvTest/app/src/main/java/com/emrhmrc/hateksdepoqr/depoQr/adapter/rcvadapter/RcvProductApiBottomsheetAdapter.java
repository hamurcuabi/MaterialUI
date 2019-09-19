package com.emrhmrc.hateksdepoqr.depoQr.adapter.rcvadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.emrhmrc.hateksdepoqr.R;
import com.emrhmrc.hateksdepoqr.databinding.RcvProductBinding;
import com.emrhmrc.hateksdepoqr.databinding.RcvProductBottomsheetBinding;
import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.Product;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.GenericAdapter;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.OnItemClickListener;

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
