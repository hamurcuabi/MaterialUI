package com.emrhmrc.hateksdepoqr.depoQr.adapter.rcvadapter;


import androidx.annotation.Nullable;

import com.emrhmrc.hateksdepoqr.databinding.RecyclerItemProductinboxBinding;
import com.emrhmrc.hateksdepoqr.databinding.RecyclerItemProductinboxProductBinding;
import com.emrhmrc.hateksdepoqr.depoQr.model.ProductInBox;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.BaseViewHolder;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.OnItemClickListener;

import butterknife.ButterKnife;

public class RcvProductInBoxProductViewHolder extends BaseViewHolder<ProductInBox.SubProductItem,
        OnItemClickListener<ProductInBox.SubProductItem>> {


    RecyclerItemProductinboxProductBinding binding;
    

    public RcvProductInBoxProductViewHolder(RecyclerItemProductinboxProductBinding binding) {
        super(binding.getRoot());
        ButterKnife.bind(this, binding.getRoot());
        this.binding = binding;

    }


    @Override
    public void onBind(final ProductInBox.SubProductItem item, final @Nullable
            OnItemClickListener<ProductInBox.SubProductItem> listener) {
        binding.setProduct(item);


    }


}
