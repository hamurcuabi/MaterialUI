package com.emrhmrc.hateksdepoqr.depoQr.adapter.rcvadapter;


import androidx.annotation.Nullable;

import com.emrhmrc.hateksdepoqr.databinding.RcvProductBinding;
import com.emrhmrc.hateksdepoqr.databinding.RcvProductBottomsheetBinding;
import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.Product;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.BaseViewHolder;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.OnItemClickListener;

import butterknife.ButterKnife;

public class RcvProductApiBottomSheetViewHolder extends BaseViewHolder<Product,
        OnItemClickListener<Product>> {

    private RcvProductBottomsheetBinding binding;

    public RcvProductApiBottomSheetViewHolder(RcvProductBottomsheetBinding binding) {
        super(binding.getRoot());
        ButterKnife.bind(this, binding.getRoot());
        this.binding = binding;

    }


    @Override
    public void onBind(final Product item, final @Nullable
            OnItemClickListener<Product> listener) {
        binding.setProduct(item);


    }


}
