package com.emrhmrc.hateksdepoqr.depoQr.adapter.rcvadapter;


import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import com.emrhmrc.hateksdepoqr.R;
import com.emrhmrc.hateksdepoqr.databinding.RecyclerItemProductBinding;
import com.emrhmrc.hateksdepoqr.databinding.RecyclerItemProductinboxBinding;
import com.emrhmrc.hateksdepoqr.depoQr.model.ProductInBox;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.BaseViewHolder;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.OnItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.common.FlexibleItemDecoration;
import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager;

public class RcvProductInBoxViewHolder extends BaseViewHolder<ProductInBox,
        OnItemClickListener<ProductInBox>> implements OnItemClickListener {


    private RecyclerItemProductinboxBinding binding;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.row_handle)
    ImageView imageView;
    @BindView(R.id.front_view)
    ConstraintLayout constraintLayout;
    private Context context;
    private int SPAN_COUNT = 2;

    public RcvProductInBoxViewHolder(RecyclerItemProductinboxBinding binding, Context context) {
        super(binding.getRoot());
        ButterKnife.bind(this, binding.getRoot());
        this.binding = binding;
        this.context = context;


    }


    @Override
    public void onBind(final ProductInBox item, final @Nullable
            OnItemClickListener<ProductInBox> listener) {
        binding.setProductinbox(item);
        RcvProductInBoxProductAdapter adapter = new RcvProductInBoxProductAdapter(context, this::onItemClicked);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new SmoothScrollLinearLayoutManager(context));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new FlexibleItemDecoration(context)
                .addItemViewType(R.layout.recycler_expandable_header_item)
                .withOffset(3));
        adapter.setItems(item.getSubProductItemList());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAnimations();

            }
        });
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setAnimations();

            }
        });


    }

    private void setAnimations() {

        if (recyclerView.getVisibility() == View.VISIBLE) {
            AnimateSlideUp(recyclerView);
            imageView.animate().rotation(-90).start();
            recyclerView.setVisibility(View.GONE);
        } else {
            AnimateSlideDown(recyclerView);
            imageView.animate().rotation(0).start();
            recyclerView.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void onItemClicked(Object item, int positon) {

    }

    private void AnimateSlideDown(View view) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide_down);
        view.startAnimation(animation);
    }

    private void AnimateSlideUp(View view) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide_up);
        view.startAnimation(animation);
    }


}
