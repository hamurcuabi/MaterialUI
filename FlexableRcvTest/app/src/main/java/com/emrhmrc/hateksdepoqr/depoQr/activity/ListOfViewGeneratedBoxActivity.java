package com.emrhmrc.hateksdepoqr.depoQr.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.emrhmrc.hateksdepoqr.R;
import com.emrhmrc.hateksdepoqr.api.APIHelper;
import com.emrhmrc.hateksdepoqr.api.ApiClient;
import com.emrhmrc.hateksdepoqr.depoQr.adapter.rcvadapter.RcvViewProductInGeneratedBoxesAdapter;
import com.emrhmrc.hateksdepoqr.depoQr.adapter.swipeadapter.BaseAdapterSwipeToDelete;
import com.emrhmrc.hateksdepoqr.depoQr.api.ApiJsonBoxInPalets;
import com.emrhmrc.hateksdepoqr.depoQr.api.ApiJsonPalets;
import com.emrhmrc.hateksdepoqr.depoQr.api.ApiJsonProductInBoxes;
import com.emrhmrc.hateksdepoqr.depoQr.api.ApiJsonViewProductInGeneratedBoxes;
import com.emrhmrc.hateksdepoqr.depoQr.base.BaseRecyclerViewActivtity;
import com.emrhmrc.hateksdepoqr.depoQr.interfaces.IOnSwipe;
import com.emrhmrc.hateksdepoqr.depoQr.model.BottomSheetModel;
import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.BoxInPalet;
import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.BoxInPalets;
import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.GeneratedBox;
import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.Palet;
import com.emrhmrc.hateksdepoqr.depoQr.model.apimodels.ViewProductInGeneratedBox;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.OnItemClickListener;
import com.emrhmrc.hateksdepoqr.depoQr.util.SessionUtil;
import com.emrhmrc.hateksdepoqr.utils.Utils;
import com.emrhmrc.sweetdialoglib.DialogButtonListener;
import com.emrhmrc.sweetdialoglib.DialogCreater;
import com.emrhmrc.sweetdialoglib.SweetAlertDialog;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;

import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListOfViewGeneratedBoxActivity extends BaseRecyclerViewActivtity implements OnItemClickListener, DialogButtonListener, IOnSwipe, View.OnClickListener {

    private RcvViewProductInGeneratedBoxesAdapter mAdapter;
    private List<BottomSheetModel> bottomSheetModelList;
    private ApiJsonViewProductInGeneratedBoxes apiJsonViewProductInGeneratedBoxes;
    private ApiJsonPalets apiJsonPalets;
    private ApiJsonBoxInPalets apiJsonBoxInPalets;
    private SweetAlertDialog dialog;
    private List<ViewProductInGeneratedBox> viewProductInGeneratedBoxList;
    private int lastPosition;
    private ViewProductInGeneratedBox lastSelected;
    private Palet generatedPalet = new Palet();
    private List<BoxInPalet> boxInPaletList = new ArrayList<>();

    @Override
    protected String getHeaderString() {
        return "Palet Oluştur";
    }

    @Override
    protected void initializeRecyclerView() {

        getRecyclerView().setHasFixedSize(true);
        getRecyclerView().setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RcvViewProductInGeneratedBoxesAdapter(this, this);
        getRecyclerView().setAdapter(mAdapter);
        getRecyclerView().setLayoutManager(new SmoothScrollLinearLayoutManager(this));
        getRecyclerView().setItemAnimator(new DefaultItemAnimator());
        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(new BaseAdapterSwipeToDelete(mAdapter, this::printOnSwipe));
        itemTouchhelper.attachToRecyclerView(getRecyclerView());
    }

    @Override
    protected void initializeBottomSheetRecyclerView() {
        bottomSheetModelList = new ArrayList<>();

    }

    @Override
    protected void onLoad() {
        viewProductInGeneratedBoxList = new ArrayList<>();
        initApi();
        getSheetHeader().setText("Qr Kod Okutun");
        initializeBottomSheetRecyclerView();
        getFab().setOnClickListener(this);
        showFab();
        setSheetListner();

    }

    private void setSheetListner() {
        final BottomSheetBehavior behavior = getSheetBehavior();
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });
    }

    private boolean checkIfExist(String qr) {

        for (ViewProductInGeneratedBox item : viewProductInGeneratedBoxList
        ) {
            if (item.getBoxQr().equals(qr)) {
                return true;
            }
        }
        return false;

    }

    private void getById(String qr) {

        if (!checkIfExist(qr)) {
            dialog = DialogCreater.loadingDialog(this);
            Call<ViewProductInGeneratedBox> call = apiJsonViewProductInGeneratedBoxes.getById(qr);
            APIHelper.enqueueWithRetry(call, new Callback<ViewProductInGeneratedBox>() {
                @Override
                public void onResponse(Call<ViewProductInGeneratedBox> call, Response<ViewProductInGeneratedBox> response) {
                    if (response.isSuccessful()) {
                        dialog.dismissWithAnimation();
                        viewProductInGeneratedBoxList.add(response.body());
                        mAdapter.setItems(viewProductInGeneratedBoxList);
                        addItemToBottomsheet();
                        addItemOnBoxInPalet(response.body());

                    } else {

                        DialogCreater.errorDialog(ListOfViewGeneratedBoxActivity.this, response.message());

                    }
                    dialog.dismissWithAnimation();
                }

                @Override
                public void onFailure(Call<ViewProductInGeneratedBox> call, Throwable t) {
                    dialog.dismissWithAnimation();
                    DialogCreater.errorDialog(ListOfViewGeneratedBoxActivity.this, t.getLocalizedMessage());
                }
            });

        } else {

            DialogCreater.errorDialog(this, "Ürün Okutulmuş!");

        }


    }

    private void addItemOnBoxInPalet(ViewProductInGeneratedBox item) {

        dialog = DialogCreater.loadingDialog(this);
        BoxInPalet boxInPalets = new BoxInPalet();
        boxInPalets.setMemberId(SessionUtil.MEMBER_ID);
        boxInPalets.setGeneratedBoxId(item.getId());
        boxInPalets.setPaletId(generatedPalet.getId());
        Call<BoxInPalet> call = apiJsonBoxInPalets.post(boxInPalets);
        APIHelper.enqueueWithRetry(call, new Callback<BoxInPalet>() {
            @Override
            public void onResponse(Call<BoxInPalet> call, Response<BoxInPalet> response) {
                if (response.isSuccessful()) {
                    boxInPaletList.add(response.body());
                    DialogCreater.succesDialog(ListOfViewGeneratedBoxActivity.this, "Başarıyla Eklendi");

                } else {
                    DialogCreater.errorDialog(ListOfViewGeneratedBoxActivity.this, response.message());
                }
                dialog.dismissWithAnimation();
            }

            @Override
            public void onFailure(Call<BoxInPalet> call, Throwable t) {
                dialog.dismissWithAnimation();
                DialogCreater.errorDialog(ListOfViewGeneratedBoxActivity.this, t.getLocalizedMessage());
            }
        });

    }

    @Override
    public void onItemClicked(Object item, int positon) {

    }

    @Override
    public void onConfirmButton(int id) {

    }

    @Override
    public void onCancelButton(int id) {

    }

    @Override
    public void printOnSwipe(Object item, int position, int direction) {

        lastPosition = position;
        lastSelected = (ViewProductInGeneratedBox) item;

        switch (direction) {
            case ItemTouchHelper.RIGHT:
                deleteFromBoxInPalet(position);
                break;
            default:
                mAdapter.notifyItemChanged(position);
                break;

        }

    }

    private void deleteFromList(int position) {

        viewProductInGeneratedBoxList.remove(position);
        mAdapter.remove(position);
        removeItemToBottomsheet(position);
    }

    private void initApi() {
        apiJsonViewProductInGeneratedBoxes = ApiClient.getClient().create(ApiJsonViewProductInGeneratedBoxes.class);
        apiJsonPalets = ApiClient.getClient().create(ApiJsonPalets.class);
        apiJsonBoxInPalets = ApiClient.getClient().create(ApiJsonBoxInPalets.class);

    }

    private void deleteFromBoxInPalet(int position) {

        dialog = DialogCreater.loadingDialog(this);
        Call<BoxInPalet> call = apiJsonBoxInPalets.delete(boxInPaletList.get(position).getId());
        APIHelper.enqueueWithRetry(call, new Callback<BoxInPalet>() {
            @Override
            public void onResponse(Call<BoxInPalet> call, Response<BoxInPalet> response) {
                if (response.isSuccessful()) {
                    deleteFromList(position);
                    DialogCreater.succesDialog(ListOfViewGeneratedBoxActivity.this, "Başarıyla Silindi");
                } else {
                    DialogCreater.errorDialog(ListOfViewGeneratedBoxActivity.this, response.message());
                }
                dialog.dismissWithAnimation();
            }

            @Override
            public void onFailure(Call<BoxInPalet> call, Throwable t) {
                dialog.dismissWithAnimation();
                DialogCreater.errorDialog(ListOfViewGeneratedBoxActivity.this, t.getLocalizedMessage());
            }
        });


    }

    private void addItemToBottomsheet() {
        BottomSheetModel sheetModel = new BottomSheetModel();
        sheetModel.setHeader(viewProductInGeneratedBoxList.get(viewProductInGeneratedBoxList.size() - 1).getBoxQr());
        sheetModel.setId(viewProductInGeneratedBoxList.get(viewProductInGeneratedBoxList.size() - 1).getId());
        sheetModel.setCount(1);
        int total = 0;
        bottomSheetModelList.add(sheetModel);


        for (BottomSheetModel item : bottomSheetModelList
        ) {
            total += item.getCount();

        }
        getSheetHeaderRight().setText(String.valueOf(total));


    }

    private void removeItemToBottomsheet(int position) {
        bottomSheetModelList.remove(position);
        int size = bottomSheetModelList.size();
        if (size > 0) {
            getSheetHeaderRight().setText(String.valueOf(bottomSheetModelList.size()));

        } else {
            getSheetHeaderRight().setText(String.valueOf(0));
            getSheetHeader().setText("Qr Kod Okutun");
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.fab:
                openScan();
                break;

        }
    }

    private void openScan() {
        if (generatedPalet.getId() > 0) {
            getSheetHeader().setText(generatedPalet.getName());
            Intent i = new Intent(this, ScanActivity.class);
            startActivityForResult(i, 1);
        } else {
            generatePalet();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra("result");
                getById(result);
            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        }
    }

    private void generatePalet() {
        dialog = DialogCreater.loadingDialog(this);
        generatedPalet.setMemberId(SessionUtil.MEMBER_ID);
        Call<Palet> call = apiJsonPalets.post(generatedPalet);
        APIHelper.enqueueWithRetry(call, new Callback<Palet>() {
            @Override
            public void onResponse(Call<Palet> call, Response<Palet> response) {
                if (response.isSuccessful()) {
                    dialog.dismissWithAnimation();
                    generatedPalet = response.body();
                    openScan();

                } else {
                    DialogCreater.errorDialog(ListOfViewGeneratedBoxActivity.this, response.message());
                }
                dialog.dismissWithAnimation();
            }

            @Override
            public void onFailure(Call<Palet> call, Throwable t) {
                dialog.dismissWithAnimation();
                DialogCreater.errorDialog(ListOfViewGeneratedBoxActivity.this, t.getLocalizedMessage());
            }
        });

    }
}
