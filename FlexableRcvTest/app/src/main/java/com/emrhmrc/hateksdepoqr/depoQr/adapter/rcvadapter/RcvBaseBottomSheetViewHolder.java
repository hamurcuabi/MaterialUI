package com.emrhmrc.hateksdepoqr.depoQr.adapter.rcvadapter;


import androidx.annotation.Nullable;

import com.emrhmrc.hateksdepoqr.databinding.RcvBasebottomsheetmodelBinding;
import com.emrhmrc.hateksdepoqr.databinding.RcvProductBottomsheetBinding;
import com.emrhmrc.hateksdepoqr.depoQr.model.BottomSheetModel;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.BaseViewHolder;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.OnItemClickListener;

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
