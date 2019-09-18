package com.emrhmrc.flexablercvtest.depoQr.adapter.rcvadapter;


import android.widget.CompoundButton;

import androidx.annotation.Nullable;

import com.emrhmrc.flexablercvtest.R;
import com.emrhmrc.flexablercvtest.databinding.RcvProductBinding;
import com.emrhmrc.flexablercvtest.databinding.RecyclerItemProductBinding;
import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.Product;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.BaseViewHolder;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.OnItemClickListener;
import com.google.android.material.checkbox.MaterialCheckBox;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RcvProductApiViewHolder extends BaseViewHolder<Product,
        OnItemClickListener<Product>> {

    @BindView(R.id.checkbox)
    MaterialCheckBox checkBox;

    private RcvProductBinding binding;

    public RcvProductApiViewHolder(RcvProductBinding binding) {
        super(binding.getRoot());
        ButterKnife.bind(this, binding.getRoot());
        this.binding = binding;

    }


    @Override
    public void onBind(final Product item, final @Nullable
            OnItemClickListener<Product> listener) {
        binding.setProduct(item);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (listener != null) {
                        checkBox.setOnClickListener(view -> listener.onItemClicked(item, getAdapterPosition()));

                    }
                } else {
                    //checkBox.setOnClickListener(null);
                }
                item.setChecked(b);
            }
        });

    }


}
