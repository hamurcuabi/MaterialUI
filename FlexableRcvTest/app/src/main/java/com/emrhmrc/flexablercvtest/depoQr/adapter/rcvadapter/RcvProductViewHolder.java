package com.emrhmrc.flexablercvtest.depoQr.adapter.rcvadapter;


import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

import com.emrhmrc.flexablercvtest.R;
import com.emrhmrc.flexablercvtest.depoQr.model.Product;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.BaseViewHolder;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.OnItemClickListener;
import com.emrhmrc.flexablercvtest.databinding.RecyclerItemProductBinding;
import com.google.android.material.checkbox.MaterialCheckBox;


import butterknife.BindView;
import butterknife.ButterKnife;

public class RcvProductViewHolder extends BaseViewHolder<Product,
        OnItemClickListener<Product>> {

    @BindView(R.id.checkbox)
    MaterialCheckBox checkBox;

    private RecyclerItemProductBinding binding;

    public RcvProductViewHolder(RecyclerItemProductBinding binding) {
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
                }
                else{
                    checkBox.setOnClickListener(null);
                }
                item.setChecked(b);
            }
        });

    }


}