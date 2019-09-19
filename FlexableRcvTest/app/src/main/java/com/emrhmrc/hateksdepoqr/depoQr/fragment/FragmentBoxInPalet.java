package com.emrhmrc.hateksdepoqr.depoQr.fragment;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.emrhmrc.hateksdepoqr.R;
import com.emrhmrc.hateksdepoqr.api.ApiClient;
import com.emrhmrc.hateksdepoqr.api.JsonApi;
import com.emrhmrc.hateksdepoqr.depoQr.adapter.rcvadapter.RcvBoxInPaletAdapter;
import com.emrhmrc.hateksdepoqr.depoQr.adapter.swipeadapter.SwipeController;
import com.emrhmrc.hateksdepoqr.depoQr.adapter.swipeadapter.SwipeControllerActions;
import com.emrhmrc.hateksdepoqr.depoQr.model.BoxInPalet;
import com.emrhmrc.hateksdepoqr.depoQr.model.ProductInBox;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.OnItemClickListener;
import com.emrhmrc.sweetdialoglib.DialogCreater;
import com.emrhmrc.sweetdialoglib.SweetAlertDialog;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.printer.discovery.DiscoveredPrinter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.common.FlexibleItemDecoration;
import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager;

public class FragmentBoxInPalet extends Fragment implements OnItemClickListener {

    public static final String TAG = FragmentBoxInPalet.class.getSimpleName();
    private RcvBoxInPaletAdapter mAdapter;
    private JsonApi jsonApi;
    private SweetAlertDialog dialog;
    private List<ProductInBox> products;
    private List<BoxInPalet> palets;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    //printer


    DiscoveredPrinter formatPrinter;
    SweetAlertDialog loadingDialog;
    Connection connection;

    public static FragmentBoxInPalet newInstance() {
        return new FragmentBoxInPalet();
    }

    public FragmentBoxInPalet() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_product_list, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeRecyclerView();

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dialog = DialogCreater.loadingDialog(getActivity());
        testDb();

    }

    public void testDb() {
        int koli = 1;
        dialog.dismissWithAnimation();
        products = new ArrayList<>();
        palets = new ArrayList<>();
        for (int j = 1; j < 5; j++) {

            for (int i = 1; i < 10; i++) {

                koli++;
                ProductInBox productInBox = new ProductInBox();
                productInBox.setBoxId(i);
                productInBox.setBoxName("Koli-" + koli);
                for (int k = 1; k < 4; k++) {

                    ProductInBox.SubProductItem item = new ProductInBox.SubProductItem();
                    item.setProductCount(k);
                    item.setProductName("Ürün-" + k);
                    productInBox.getSubProductItemList().add(item);


                }
                products.add(productInBox);
            }
            BoxInPalet boxInPalet = new BoxInPalet();
            boxInPalet.setProductInBoxes(products);
            boxInPalet.setPaletId(j);
            boxInPalet.setPaletName("Palet-" + j);
            palets.add(boxInPalet);

        }

        mAdapter.setItems(palets);
        dialog.dismissWithAnimation();

    }

    private void initializeRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        mAdapter = new RcvBoxInPaletAdapter(getActivity().getApplicationContext(), this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new SmoothScrollLinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new FlexibleItemDecoration(getActivity())
                .addItemViewType(R.layout.recycler_expandable_header_item)
                .withOffset(1));

        SwipeController swipeController = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {

                mAdapter.notifyItemRemoved(position);
                mAdapter.notifyItemRangeChanged(position, mAdapter.getItemCount());
            }
        });
        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(mRecyclerView);

        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });
        mRecyclerView.setNestedScrollingEnabled(true);

    }

    private void initApi() {

        jsonApi = ApiClient.getClient().create(JsonApi.class);

    }


    @Override
    public void onItemClicked(Object item, int positon) {

    }
}