package com.emrhmrc.flexablercvtest.depoQr.adapter.rcvadapter;


import android.widget.CompoundButton;

import androidx.annotation.Nullable;

import com.emrhmrc.flexablercvtest.R;
import com.emrhmrc.flexablercvtest.databinding.RcvProductBinding;
import com.emrhmrc.flexablercvtest.databinding.RcvProductBottomsheetBinding;
import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.Product;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.BaseViewHolder;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.OnItemClickListener;
import com.google.android.material.checkbox.MaterialCheckBox;

import butterknife.BindView;
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
