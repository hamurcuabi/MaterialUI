package com.emrhmrc.hateksdepoqr.depoQr.activity;

import android.widget.NumberPicker;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.emrhmrc.hateksdepoqr.api.APIHelper;
import com.emrhmrc.hateksdepoqr.api.ApiClient;
import com.emrhmrc.hateksdepoqr.depoQr.adapter.rcvadapter.RcvProductApiAdapter;
import com.emrhmrc.hateksdepoqr.depoQr.adapter.rcvadapter.RcvProductApiBottomsheetAdapter;
import com.emrhmrc.hateksdepoqr.depoQr.api.ApiJsonBoxes;
import com.emrhmrc.hateksdepoqr.depoQr.api.ApiJsonProductInBoxes;
import com.emrhmrc.hateksdepoqr.depoQr.api.ApiJsonProducts;
import com.emrhmrc.hateksdepoqr.depoQr.base.BaseRecyclerViewActivtity;
import com.emrhmrc.hateksdepoqr.depoQr.fragment.NumberPickerDialog;
import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.Box;
import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.Product;
import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.ProductInBoxes;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.OnItemClickListener;
import com.emrhmrc.hateksdepoqr.depoQr.util.SessionUtil;
import com.emrhmrc.sweetdialoglib.DialogButtonListener;
import com.emrhmrc.sweetdialoglib.DialogCreater;
import com.emrhmrc.sweetdialoglib.SweetAlertDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListOfProductActivity extends BaseRecyclerViewActivtity implements OnItemClickListener, NumberPicker.OnValueChangeListener, DialogButtonListener {

    private RcvProductApiAdapter mAdapter;
    private RcvProductApiBottomsheetAdapter mBottomsheetAdapter;
    private ApiJsonProducts jsonProducts;
    private ApiJsonBoxes jsonBoxes;
    private ApiJsonProductInBoxes jsonProductInBoxes;
    private SweetAlertDialog dialog;
    private List<Product> productList;
    private List<Product> productListBottomSheet;
    private Product lastSelected;
    private int lastPosition;
    private Box box;


    @Override
    protected String getHeaderString() {
        return "Ürünler";
    }

    @Override
    protected void initializeRecyclerView() {
        getRecyclerView().setHasFixedSize(true);
        getRecyclerView().setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RcvProductApiAdapter(this, this);
        getRecyclerView().setAdapter(mAdapter);
        getRecyclerView().setLayoutManager(new SmoothScrollLinearLayoutManager(this));
        getRecyclerView().setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    protected void initializeBottomSheetRecyclerView() {
        getBottomsheetRecyclerView().setHasFixedSize(true);
        getBottomsheetRecyclerView().setLayoutManager(new LinearLayoutManager(this));
        mBottomsheetAdapter = new RcvProductApiBottomsheetAdapter(this, this);
        getBottomsheetRecyclerView().setAdapter(mBottomsheetAdapter);
        getBottomsheetRecyclerView().setLayoutManager(new SmoothScrollLinearLayoutManager(this));
        getBottomsheetRecyclerView().setItemAnimator(new DefaultItemAnimator());
        productListBottomSheet = new ArrayList<>();
        mBottomsheetAdapter.setItems(productListBottomSheet, true);
    }

    @Override
    protected void onLoad() {

        initializeBox();
        initApi();
        getAll();
        initializeBottomSheetRecyclerView();


    }

    private void initializeBox() {
        box = new Box();
        box.setMemberId(SessionUtil.MEMBER_ID);
    }

    private void getAll() {
        dialog = DialogCreater.loadingDialog(this);
        Call<List<Product>> call = jsonProducts.getAll();
        APIHelper.enqueueWithRetry(call, new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

                if (response.isSuccessful()) {
                    productList = response.body();
                    mAdapter.setItems(productList);

                } else {

                    DialogCreater.errorDialog(ListOfProductActivity.this, response.message());

                }
                dialog.dismissWithAnimation();

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                dialog.dismissWithAnimation();
                DialogCreater.errorDialog(ListOfProductActivity.this, t.getLocalizedMessage());
            }
        });


    }

    private void initApi() {
        jsonProducts = ApiClient.getClient().create(ApiJsonProducts.class);
        jsonBoxes = ApiClient.getClient().create(ApiJsonBoxes.class);
        jsonProductInBoxes = ApiClient.getClient().create(ApiJsonProductInBoxes.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    public void onItemClicked(Object item, int positon) {

        lastSelected = (Product) item;
        lastPosition = positon;
        if (lastSelected.isChecked()) {

            showNumberPicker(((Product) item).getCount());
        } else {

            deleteItemFromBox();
        }


    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {

        lastSelected.setCount(numberPicker.getValue());
        mAdapter.notifyItemChanged(lastPosition, lastSelected);

        if (lastSelected.isChecked()) {
            //yeni kutu oluşturma için soru sor
            if (box.getId() == 0) {
                DialogCreater.questionDialog(this, this, "Yeni Koli Oluşturma İşlemi", 1);
            } else {
                //db ye kayıt et bu sonuncu objeyi
                addItemToBox();
            }

        }


    }

    public void showNumberPicker(int count) {
        NumberPickerDialog newFragment = new NumberPickerDialog(count);
        newFragment.setValueChangeListener(this);
        newFragment.show(getSupportFragmentManager(), "Number Picker");
    }

    private void generateBox() {
        //Member Id Lazım
        dialog = DialogCreater.loadingDialog(this);
        box.setDate(Calendar.getInstance().getTime());
        Call<Box> call = jsonBoxes.post(box);
        APIHelper.enqueueWithRetry(call, new Callback<Box>() {
            @Override
            public void onResponse(Call<Box> call, Response<Box> response) {

                if (response.isSuccessful()) {
                    box = response.body();
                    DialogCreater.basicDialog(ListOfProductActivity.this, "Koli Oluşturuldu"
                            , box.getName());
                    resetItem();
                    getSheetHeader().setText(box.getName());
                } else {

                    DialogCreater.errorDialog(ListOfProductActivity.this, response.message());
                }
                dialog.dismissWithAnimation();
            }

            @Override
            public void onFailure(Call<Box> call, Throwable t) {
                dialog.dismissWithAnimation();
                DialogCreater.errorDialog(ListOfProductActivity.this, t.getLocalizedMessage());
            }
        });


    }

    @Override
    public void onConfirmButton(int id) {
        switch (id) {
            case 1:
                generateBox();
                break;
        }
    }

    @Override
    public void onCancelButton(int id) {

        switch (id) {
            case 1:
                resetItem();
                break;
        }

    }

    private void resetItem() {
        lastSelected.setCount(1);
        lastSelected.setChecked(false);
        mAdapter.notifyItemChanged(lastPosition, lastSelected);

    }

    private void addItemToBox() {
        dialog = DialogCreater.loadingDialog(this);
        ProductInBoxes productInBoxes = new ProductInBoxes();
        productInBoxes.setMemberId(1);
        productInBoxes.setBoxId(box.getId());
        productInBoxes.setProductCount(lastSelected.getCount());
        productInBoxes.setProductId(lastSelected.getId());


        Call<ProductInBoxes> call = jsonProductInBoxes.post(productInBoxes);
        APIHelper.enqueueWithRetry(call, new Callback<ProductInBoxes>() {
            @Override
            public void onResponse(Call<ProductInBoxes> call, Response<ProductInBoxes> response) {
                if (response.isSuccessful()) {
                    DialogCreater.basicDialog(ListOfProductActivity.this, "Ürün Koliye Başarıyla Eklendi");
                    addItemToBottomsheet();

                } else {

                    DialogCreater.errorDialog(ListOfProductActivity.this, response.message());

                }
                dialog.dismissWithAnimation();
            }

            @Override
            public void onFailure(Call<ProductInBoxes> call, Throwable t) {
                dialog.dismissWithAnimation();
                DialogCreater.errorDialog(ListOfProductActivity.this, t.getLocalizedMessage());
            }
        });


    }

    private void deleteItemFromBox() {

        //boxid ve productid alıp silmek lazım
        dialog = DialogCreater.loadingDialog(this);
        ProductInBoxes productInBoxes = new ProductInBoxes();
        productInBoxes.setProductId(lastSelected.getId());
        productInBoxes.setBoxId(box.getId());
        Call<ProductInBoxes> call = jsonProductInBoxes.deleteWithBody(productInBoxes);
        APIHelper.enqueueWithRetry(call, new Callback<ProductInBoxes>() {
            @Override
            public void onResponse(Call<ProductInBoxes> call, Response<ProductInBoxes> response) {
                if (response.isSuccessful()) {
                    DialogCreater.basicDialog(ListOfProductActivity.this, "Ürün Koliden Başarıyla Silindi");
                    removeItemToBottomsheet();
                } else {
                    lastSelected.setChecked(true);
                    DialogCreater.errorDialog(ListOfProductActivity.this, response.message());

                }
                dialog.dismissWithAnimation();
            }

            @Override
            public void onFailure(Call<ProductInBoxes> call, Throwable t) {
                dialog.dismissWithAnimation();
                DialogCreater.errorDialog(ListOfProductActivity.this, t.getLocalizedMessage());
            }
        });


    }


    private void addItemToBottomsheet() {

        productListBottomSheet.add(lastSelected);
        mBottomsheetAdapter.setItems(productListBottomSheet);
        getSheetHeaderRight().setText(String.valueOf(mBottomsheetAdapter.getItemCount()));

    }

    private void removeItemToBottomsheet() {
        productListBottomSheet.remove(lastSelected);
        mBottomsheetAdapter.setItems(productListBottomSheet);
        getSheetHeaderRight().setText(String.valueOf(mBottomsheetAdapter.getItemCount()));

    }

}
