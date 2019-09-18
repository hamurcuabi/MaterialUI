package com.emrhmrc.flexablercvtest.depoQr.adapter.rcvadapter;


import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.emrhmrc.flexablercvtest.R;
import com.emrhmrc.flexablercvtest.databinding.RecyclerItemProductinboxBinding;
import com.emrhmrc.flexablercvtest.databinding.RecyclerItemProductinboxProductBinding;
import com.emrhmrc.flexablercvtest.depoQr.model.ProductInBox;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.BaseViewHolder;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.OnItemClickListener;

import butterknife.BindView;
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
