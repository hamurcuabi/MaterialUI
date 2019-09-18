package com.emrhmrc.flexablercvtest.depoQr.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.emrhmrc.flexablercvtest.api.APIHelper;
import com.emrhmrc.flexablercvtest.api.ApiClient;
import com.emrhmrc.flexablercvtest.depoQr.adapter.rcvadapter.RcvBaseBottomsheetAdapter;
import com.emrhmrc.flexablercvtest.depoQr.adapter.rcvadapter.RcvViewProductInBoxesAdapter;
import com.emrhmrc.flexablercvtest.depoQr.adapter.swipeadapter.BaseAdapterSwipeToPrint;
import com.emrhmrc.flexablercvtest.depoQr.api.ApiJsonGeneratedBoxes;
import com.emrhmrc.flexablercvtest.depoQr.api.ApiJsonViewProductInBoxes;
import com.emrhmrc.flexablercvtest.depoQr.base.BaseRecyclerViewActivtity;
import com.emrhmrc.flexablercvtest.depoQr.interfaces.IOnSwipe;
import com.emrhmrc.flexablercvtest.depoQr.model.BottomSheetModel;
import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.GeneratedBox;
import com.emrhmrc.flexablercvtest.depoQr.model.apimodels.ViewProductInBox;
import com.emrhmrc.flexablercvtest.depoQr.recyclerview.OnItemClickListener;
import com.emrhmrc.flexablercvtest.depoQr.util.SessionUtil;
import com.emrhmrc.flexablercvtest.printer.ChooseFormatScreen;
import com.emrhmrc.flexablercvtest.printer.util.SelectedPrinterManager;
import com.emrhmrc.sweetdialoglib.DialogButtonListener;
import com.emrhmrc.sweetdialoglib.DialogCreater;
import com.emrhmrc.sweetdialoglib.SweetAlertDialog;
import com.google.zxing.Result;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterFactory;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;
import com.zebra.sdk.printer.discovery.DiscoveredPrinter;

import java.util.ArrayList;
import java.util.List;

import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListOfViewGeneratedBoxActivity extends BaseRecyclerViewActivtity implements OnItemClickListener, DialogButtonListener, IOnSwipe {

    private RcvViewProductInBoxesAdapter mAdapter;
    private RcvBaseBottomsheetAdapter bottomsheetAdapter;
    private List<BottomSheetModel> bottomSheetModelList;
    private ApiJsonViewProductInBoxes apiJsonViewProductInBoxes;
    private ApiJsonGeneratedBoxes apiJsonGeneratedBoxes;
    private SweetAlertDialog dialog;
    private List<ViewProductInBox> viewProductInBoxList;
    private int lastPosition;
    private ViewProductInBox lastSelected;
    //Yazdrıma işlemi
    private DiscoveredPrinter formatPrinter;
    private Connection connection;
    private SweetAlertDialog loadingDialog;
    private GeneratedBox generatedBox;

    @Override
    protected String getHeaderString() {
        return "Koli Oluştur";
    }

    @Override
    protected void initializeRecyclerView() {

        getRecyclerView().setHasFixedSize(true);
        getRecyclerView().setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RcvViewProductInBoxesAdapter(this, this);
        getRecyclerView().setAdapter(mAdapter);
        getRecyclerView().setLayoutManager(new SmoothScrollLinearLayoutManager(this));
        getRecyclerView().setItemAnimator(new DefaultItemAnimator());
        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(new BaseAdapterSwipeToPrint(mAdapter, this::printOnSwipe));
        itemTouchhelper.attachToRecyclerView(getRecyclerView());
    }

    @Override
    protected void initializeBottomSheetRecyclerView() {
        getBottomsheetRecyclerView().setHasFixedSize(true);
        getBottomsheetRecyclerView().setLayoutManager(new LinearLayoutManager(this));
        bottomsheetAdapter = new RcvBaseBottomsheetAdapter(this, this);
        getBottomsheetRecyclerView().setAdapter(bottomsheetAdapter);
        getBottomsheetRecyclerView().setLayoutManager(new SmoothScrollLinearLayoutManager(this));
        getBottomsheetRecyclerView().setItemAnimator(new DefaultItemAnimator());
        bottomSheetModelList = new ArrayList<>();
        bottomsheetAdapter.setItems(bottomSheetModelList, true);
    }

    @Override
    protected void onLoad() {
        initApi();
        getAll();
        hideBtnJobDone();
        getSheetHeader().setText("Yazdırılan Koli Sayısı");
        initializeBottomSheetRecyclerView();
        setPrinter();

    }


    private void setPrinter() {
        formatPrinter = getFormatPrinter();
        connection = getConnection();
        loadingDialog = getLoadingDialog();
    }

    private void getAll() {
        dialog = DialogCreater.loadingDialog(this);
        Call<List<ViewProductInBox>> call = apiJsonViewProductInBoxes.getAll();
        APIHelper.enqueueWithRetry(call, new Callback<List<ViewProductInBox>>() {
            @Override
            public void onResponse(Call<List<ViewProductInBox>> call, Response<List<ViewProductInBox>> response) {
                if (response.isSuccessful()) {
                    viewProductInBoxList = response.body();
                    mAdapter.setItems(viewProductInBoxList);

                } else {

                    DialogCreater.errorDialog(ListOfViewGeneratedBoxActivity.this, response.message());

                }
                dialog.dismissWithAnimation();
            }

            @Override
            public void onFailure(Call<List<ViewProductInBox>> call, Throwable t) {
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
        lastSelected = (ViewProductInBox) item;

        switch (direction) {
            case ItemTouchHelper.RIGHT:
                insertToGenereteBox();
                break;
            default:
                mAdapter.notifyItemChanged(position);
                Intent i = new Intent(this, ScanActivity.class);
                startActivityForResult(i, 2);
                break;

        }

    }


    private void initApi() {
        apiJsonViewProductInBoxes = ApiClient.getClient().create(ApiJsonViewProductInBoxes.class);
        apiJsonGeneratedBoxes = ApiClient.getClient().create(ApiJsonGeneratedBoxes.class);

    }

    private void addItemToBottomsheet() {
        BottomSheetModel sheetModel = new BottomSheetModel();
        sheetModel.setHeader(lastSelected.getBoxJson().getBoxName());
        sheetModel.setId(lastSelected.getBoxJson().getBoxId());
        sheetModel.setCount(1);
        boolean isNew = true;
        int position = 0;
        int total = 0;
        for (BottomSheetModel item : bottomSheetModelList
        ) {
            if (item.getId() == sheetModel.getId()) {
                item.setCount(1 + item.getCount());
                isNew = false;
                break;
            }
            position++;

        }
        if (isNew) {
            bottomSheetModelList.add(sheetModel);
            bottomsheetAdapter.setItems(bottomSheetModelList);
        } else {
            bottomsheetAdapter.notifyItemChanged(position);
        }

        for (BottomSheetModel item : bottomSheetModelList
        ) {
            total += item.getCount();

        }
        getSheetHeaderRight().setText(String.valueOf(total));

    }

    private void removeItemToBottomsheet(BottomSheetModel sheetModel) {
        bottomSheetModelList.remove(sheetModel);
        bottomsheetAdapter.setItems(bottomSheetModelList);
        getSheetHeaderRight().setText(String.valueOf(bottomsheetAdapter.getItemCount()));

    }

    private void print() {
        formatPrinter = SelectedPrinterManager.getSelectedPrinter();
        new AsyncTask<String, String, String>() {

            protected void onPreExecute() {
                loadingDialog = DialogCreater.loadingDialog(ListOfViewGeneratedBoxActivity.this);

            }


            @Override
            protected String doInBackground(String... params) {
                String failMessage = "";
                connection = SelectedPrinterManager.getPrinterConnection();

                if (connection != null) {
                    try {
                        connection.open();
                        ZebraPrinter printer = ZebraPrinterFactory.getInstance(connection);
                        printer.sendCommand("^XA\n" +
                                "^FO50,50^BQ2,2,10\n" +
                                "^FD000" + params[0] + "^FS\n" +
                                "^FO277,75^AAN,20,10^FD" + params[0] + "^FS\n" +
                                "^FO277,150^AAN,20,10^FD" + params[1] + "^FS\n" +
                                "^XZ");

                    } catch (ConnectionException e) {
                        failMessage += e.getMessage();

                    } catch (ZebraPrinterLanguageUnknownException e) {
                        failMessage += e.getMessage();
                    } finally {
                        try {
                            connection.close();
                        } catch (ConnectionException e) {
                            failMessage += e.getMessage();

                        }
                    }
                } else {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        failMessage += e.getMessage();
                    }
                }
                return failMessage;
            }

            protected void onPostExecute(String result) {

                if (!result.isEmpty()) {
                    loadingDialog.dismissWithAnimation();
                    DialogCreater.errorDialog(ListOfViewGeneratedBoxActivity.this, result);
                } else {
                    setIsPrintedGenerateBox();
                }

            }

            ;
        }.execute(generatedBox.getBoxQr(), generatedBox.getBoxQr());

    }

    private void insertToGenereteBox() {

        dialog = DialogCreater.loadingDialog(this);
        generatedBox = new GeneratedBox();
        generatedBox.setBoxId(lastSelected.getBoxJson().getBoxId());
        generatedBox.setMemberId(SessionUtil.MEMBER_ID);

        Call<GeneratedBox> call = apiJsonGeneratedBoxes.post(generatedBox);
        APIHelper.enqueueWithRetry(call, new Callback<GeneratedBox>() {
            @Override
            public void onResponse(Call<GeneratedBox> call, Response<GeneratedBox> response) {
                dialog.dismissWithAnimation();
                if (response.isSuccessful()) {
                    generatedBox = response.body();
                    //try to print
                    startActivityForResult(new Intent(ListOfViewGeneratedBoxActivity.this, ChooseFormatScreen.class),
                            1);
                } else {

                    DialogCreater.errorDialog(ListOfViewGeneratedBoxActivity.this, response.message());

                }

            }

            @Override
            public void onFailure(Call<GeneratedBox> call, Throwable t) {
                dialog.dismissWithAnimation();
                DialogCreater.errorDialog(ListOfViewGeneratedBoxActivity.this, t.getLocalizedMessage());
            }
        });

    }

    private void setIsPrintedGenerateBox() {

        generatedBox.setPrinted(true);
        Call<Void> call = apiJsonGeneratedBoxes.put(generatedBox.getId(), generatedBox);
        APIHelper.enqueueWithRetry(call, new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                if (response.isSuccessful()) {
                    DialogCreater.succesDialog(ListOfViewGeneratedBoxActivity.this, "İşlem Başarılı");
                    addItemToBottomsheet();

                } else {

                    DialogCreater.errorDialog(ListOfViewGeneratedBoxActivity.this, response.message());
                }
                loadingDialog.dismissWithAnimation();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                loadingDialog.dismissWithAnimation();
                DialogCreater.errorDialog(ListOfViewGeneratedBoxActivity.this, t.getLocalizedMessage());

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                print();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                DialogCreater.errorDialog(ListOfViewGeneratedBoxActivity.this, "Yazıcı Bağlantı Hatası-ListOfViewProductInBoxesActivity");
            }
        } else if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra("result");
                DialogCreater.succesDialog(ListOfViewGeneratedBoxActivity.this, result);

            }
        }
    }


}
