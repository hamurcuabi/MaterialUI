package com.emrhmrc.flexablercvtest.depoQr.adapter.rcvadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.emrhmrc.flexablercvtest.R;
import com.emrhmrc.flexablercvtest.databinding.RecyclerItemBoxInPaletBinding;
import com.emrhmrc.flexablercvtest.depoQr.model.BoxInPalet;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.GenericAdapter;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.OnItemClickListener;

public class RcvBoxInPaletAdapter extends GenericAdapter<BoxInPalet,
        OnItemClickListener<BoxInPalet>,
        RcvBoxInPaletViewHolder> {

    private Context context;

    public Context getContext() {
        return context;
    }


    public RcvBoxInPaletAdapter(Context context, OnItemClickListener listener) {
        super(context, listener);
        this.context = context;


    }

    @Override
    public RcvBoxInPaletViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerItemBoxInPaletBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.recycler_item_box_in_palet, parent, false);
        return new RcvBoxInPaletViewHolder(binding, getContext());

    }


    @Override
    public int getItemViewType(int position) {
        final BoxInPalet item = getItem(position);
        return position;
    }


}
