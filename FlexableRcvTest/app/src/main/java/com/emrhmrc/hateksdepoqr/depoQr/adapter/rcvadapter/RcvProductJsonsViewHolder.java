package com.emrhmrc.hateksdepoqr.depoQr.adapter.rcvadapter;


import androidx.annotation.Nullable;

import com.emrhmrc.hateksdepoqr.databinding.RcvProductJsonsBinding;
import com.emrhmrc.hateksdepoqr.databinding.RecyclerItemProductinboxProductBinding;
import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.ProductJsons;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.BaseViewHolder;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.OnItemClickListener;

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
