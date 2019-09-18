package com.emrhmrc.flexablercvtest.depoQr.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.emrhmrc.flexablercvtest.R;
import com.emrhmrc.flexablercvtest.api.ApiClient;
import com.emrhmrc.flexablercvtest.api.JsonApi;
import com.emrhmrc.flexablercvtest.depoQr.adapter.rcvadapter.RcvProductAdapter;
import com.emrhmrc.flexablercvtest.depoQr.adapter.rcvadapter.RcvProductInBoxAdapter;
import com.emrhmrc.flexablercvtest.depoQr.model.Product;
import com.emrhmrc.flexablercvtest.depoQr.model.ProductInBox;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.OnItemClickListener;
import com.emrhmrc.flexablercvtest.samples.flexibleadapter.fragments.OnFragmentInteractionListener;
import com.emrhmrc.sweetdialoglib.DialogCreater;
import com.emrhmrc.sweetdialoglib.SweetAlertDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.common.FlexibleItemDecoration;
import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a list of Holder Items.
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
public class FragmentProductInBox extends Fragment implements OnItemClickListener {

    public static final String TAG = FragmentProductInBox.class.getSimpleName();
    private RcvProductInBoxAdapter mAdapter;
    private JsonApi jsonApi;
    private SweetAlertDialog dialog;
    private List<ProductInBox> products;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    public static FragmentProductInBox newInstance() {
        return new FragmentProductInBox();
    }

    public FragmentProductInBox() {
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
        dialog.dismissWithAnimation();
        products = new ArrayList<>();
        for (int i = 1; i < 20; i++) {

            ProductInBox productInBox = new ProductInBox();
            productInBox.setBoxId(i);
            productInBox.setBoxName("Koli-" + i);
            for (int k = 1; k < 5; k++) {

                ProductInBox.SubProductItem item = new ProductInBox.SubProductItem();
                item.setProductCount(k);
                item.setProductName("Ürün-" + k);
                productInBox.getSubProductItemList().add(item);


            }
        products.add(productInBox);
        }
        if (products != null)
            mAdapter.setItems(products);
        dialog.dismissWithAnimation();

    }

    private void initializeRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        mAdapter = new RcvProductInBoxAdapter(getActivity().getApplicationContext(), this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new SmoothScrollLinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new FlexibleItemDecoration(getActivity())
                .addItemViewType(R.layout.recycler_expandable_header_item)
                .withOffset(1));

    }

    private void initApi() {

        jsonApi = ApiClient.getClient().create(JsonApi.class);

    }


    @Override
    public void onItemClicked(Object item, int positon) {


    }


}