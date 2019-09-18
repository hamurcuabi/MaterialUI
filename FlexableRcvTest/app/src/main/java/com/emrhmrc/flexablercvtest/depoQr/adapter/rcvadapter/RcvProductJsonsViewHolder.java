package com.emrhmrc.flexablercvtest.depoQr.adapter.rcvadapter;


import androidx.annotation.Nullable;

import com.emrhmrc.flexablercvtest.databinding.RcvProductJsonsBinding;
import com.emrhmrc.flexablercvtest.databinding.RecyclerItemProductinboxProductBinding;
import com.emrhmrc.flexablercvtest.depoQr.model.ProductInBox;
import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.ProductJsons;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.BaseViewHolder;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.OnItemClickListener;

import butterknife.ButterKnife;

public class RcvProductJsonsViewHolder extends BaseViewHolder<ProductJsons,
        OnItemClickListener<ProductJsons>> {


    RcvProductJsonsBinding binding;


    public RcvProductJsonsViewHolder(RcvProductJsonsBinding binding) {
        super(binding.getRoot());
        ButterKnife.bind(this, binding.getRoot());
        this.binding = binding;

    }


    @Override
    public void onBind(final ProductJsons item, final @Nullable
            OnItemClickListener<ProductJsons> listener) {
        binding.setProduct(item);


    }


}
