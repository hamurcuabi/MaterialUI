package com.emrhmrc.flexablercvtest.depoQr.adapter.rcvadapter;


import androidx.annotation.Nullable;

import com.emrhmrc.flexablercvtest.databinding.RcvBasebottomsheetmodelBinding;
import com.emrhmrc.flexablercvtest.databinding.RcvProductBottomsheetBinding;
import com.emrhmrc.flexablercvtest.depoQr.model.BottomSheetModel;
import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.Product;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.BaseViewHolder;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.OnItemClickListener;

import butterknife.ButterKnife;

public class RcvBaseBottomSheetViewHolder extends BaseViewHolder<BottomSheetModel,
        OnItemClickListener<BottomSheetModel>> {

    private RcvBasebottomsheetmodelBinding binding;

    public RcvBaseBottomSheetViewHolder(RcvBasebottomsheetmodelBinding binding) {
        super(binding.getRoot());
        ButterKnife.bind(this, binding.getRoot());
        this.binding = binding;

    }


    @Override
    public void onBind(final BottomSheetModel item, final @Nullable
            OnItemClickListener<BottomSheetModel> listener) {
        binding.setItem(item);


    }


}
