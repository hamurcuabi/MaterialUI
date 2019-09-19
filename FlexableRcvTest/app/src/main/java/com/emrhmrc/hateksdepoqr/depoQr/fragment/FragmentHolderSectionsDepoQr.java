package com.emrhmrc.hateksdepoqr.depoQr.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.emrhmrc.hateksdepoqr.R;
import com.emrhmrc.hateksdepoqr.api.ApiClient;
import com.emrhmrc.hateksdepoqr.api.JsonApi;
import com.emrhmrc.hateksdepoqr.depoQr.adapter.rcvadapter.RcvProductAdapter;
import com.emrhmrc.hateksdepoqr.depoQr.model.Product;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.OnItemClickListener;
import com.emrhmrc.hateksdepoqr.samples.flexibleadapter.fragments.OnFragmentInteractionListener;
import com.emrhmrc.sweetdialoglib.DialogCreater;
import com.emrhmrc.sweetdialoglib.SweetAlertDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a list of Holder Items.
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
public class FragmentHolderSectionsDepoQr extends Fragment implements OnItemClickListener, NumberPicker.OnValueChangeListener {

    public static final String TAG = FragmentHolderSectionsDepoQr.class.getSimpleName();
    private RcvProductAdapter mAdapter;
    private JsonApi jsonApi;
    private SweetAlertDialog dialog;
    private List<Product> products;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private Product lastSelected;
    private int lastPosition;

    public static FragmentHolderSectionsDepoQr newInstance() {
        return new FragmentHolderSectionsDepoQr();
    }

    public FragmentHolderSectionsDepoQr() {
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
        for (int i = 1; i < 50; i++) {

            Product product = new Product();
            product.setId(i);
            product.setProductId(100 + i);
            product.setProductCode("Ürün-" + i);
            products.add(product);

        }
        if (products != null)
            mAdapter.setItems(products);
        dialog.dismissWithAnimation();

    }

    private void initializeRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        mAdapter = new RcvProductAdapter(getActivity().getApplicationContext(), this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

    }

    private void initApi() {

        jsonApi = ApiClient.getClient().create(JsonApi.class);
        Call<List<Product>> call = jsonApi.getTest();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    dialog.dismissWithAnimation();
                    products = response.body();
                    if (products != null)
                        mAdapter.setItems(products);
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

                dialog.dismissWithAnimation();
                DialogCreater.errorDialog(getActivity(), t.getLocalizedMessage());
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }


    @Override
    public void onItemClicked(Object item, int positon) {

        lastSelected = (Product) item;
        lastPosition = positon;
        showNumberPicker(((Product) item).getCount());

    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {

        lastSelected.setCount(numberPicker.getValue());
        mAdapter.notifyItemChanged(lastPosition, lastSelected);

    }

    public void showNumberPicker(int count) {
        NumberPickerDialog newFragment = new NumberPickerDialog(count);
        newFragment.setValueChangeListener(this);
        newFragment.show(getActivity().getSupportFragmentManager(), "Number Picker");
    }
}