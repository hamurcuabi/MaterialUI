package com.emrhmrc.hateksdepoqr.depoQr.activity;

import android.app.Activity;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.emrhmrc.hateksdepoqr.R;
import com.emrhmrc.hateksdepoqr.api.ApiClient;
import com.emrhmrc.hateksdepoqr.api.JsonApi;
import com.emrhmrc.hateksdepoqr.depoQr.adapter.rcvadapter.RcvBoxInPaletAdapter;
import com.emrhmrc.hateksdepoqr.depoQr.adapter.swipeadapter.BaseSwipeToPrint;
import com.emrhmrc.hateksdepoqr.depoQr.interfaces.IOnSwipe;
import com.emrhmrc.hateksdepoqr.depoQr.model.BoxInPalet;
import com.emrhmrc.hateksdepoqr.depoQr.model.ProductInBox;
import com.emrhmrc.hateksdepoqr.depoQr.recyclerview.OnItemClickListener;
import com.emrhmrc.hateksdepoqr.printer.ChooseFormatScreen;
import com.emrhmrc.hateksdepoqr.printer.util.FinishInfo;
import com.emrhmrc.hateksdepoqr.printer.util.SavedFormatProvider;
import com.emrhmrc.hateksdepoqr.printer.util.SelectedPrinterManager;
import com.emrhmrc.hateksdepoqr.printer.util.UIHelper;
import com.emrhmrc.hateksdepoqr.printer.util.UsbHelper;
import com.emrhmrc.hateksdepoqr.samples.flexibleadapter.views.HeaderView;
import com.emrhmrc.sweetdialoglib.DialogButtonListener;
import com.emrhmrc.sweetdialoglib.DialogCreater;
import com.emrhmrc.sweetdialoglib.SweetAlertDialog;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterFactory;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;
import com.zebra.sdk.printer.discovery.DiscoveredPrinter;
import com.zebra.sdk.printer.discovery.DiscoveredPrinterUsb;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager;

public class ListOfPaletActivity extends AppCompatActivity implements OnItemClickListener, DialogButtonListener, FinishInfo, IOnSwipe {

    private RcvBoxInPaletAdapter mAdapter;
    private JsonApi jsonApi;
    private SweetAlertDialog dialog;
    private List<ProductInBox> products;
    private List<BoxInPalet> palets;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_header_view)
    HeaderView headerView;
    private BoxInPalet lastActiveBoxInPalet;

    private DiscoveredPrinter formatPrinter;
    private SweetAlertDialog loadingDialog;
    private Connection connection;
    private SavedFormatProvider savedFormatProvider;
    private int scanTargetIndex = -1;
    private UIHelper uiHelper = new UIHelper(this);
    private UsbHelper usbHelper = new UsbHelper(this) {
        @Override
        public void usbDisconnected(UsbDevice device) {

            DiscoveredPrinter[] printers = SelectedPrinterManager.getPrinterHistory();
            for (int i = 0; i < printers.length; i++) {
                DiscoveredPrinter printer = printers[i];
                if (printer instanceof DiscoveredPrinterUsb && device.getDeviceName().equals(((DiscoveredPrinterUsb) printer).device.getDeviceName())) {
                    SelectedPrinterManager.removeHistoryItemAtIndex(i);
                    if (printer.address.equals(formatPrinter.address)) {
                        uiHelper.dismissLoadingDialog();
                        finish();
                    }
                    return;
                }
            }
        }

        @Override
        public void usbConnectedAndPermissionGranted(UsbDevice device) {
            uiHelper.dismissLoadingDialog();
            finish();
        }
    };
    private volatile boolean isFinished = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        savedFormatProvider = new SavedFormatProvider(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_palet);
        ButterKnife.bind(this);
        initializeRecyclerView();
        setToolbar();
        setStatusBar();
        setHeaderView();
        dialog = DialogCreater.loadingDialog(this);
        testDb();
        usbHelper.onCreate(getIntent());


    }

    @Override
    protected void onResume() {
        super.onResume();
        usbHelper.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        usbHelper.onPause();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        usbHelper.onNewIntent(intent);
    }

    private void setStatusBar() {
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark_light));
    }

    private void setHeaderView() {
        headerView.bindTo(getString(R.string.app_name), "Sub Ttile");
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RcvBoxInPaletAdapter(this, this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new SmoothScrollLinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(new BaseSwipeToPrint(mAdapter, this::printOnSwipe));
        itemTouchhelper.attachToRecyclerView(mRecyclerView);


    }

    private void initApi() {

        jsonApi = ApiClient.getClient().create(JsonApi.class);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    public void onItemClicked(Object item, int positon) {
        //item clik

    }


    @Override
    public void onConfirmButton(int id) {
        startActivityForResult(new Intent(ListOfPaletActivity.this, ChooseFormatScreen.class),
                1);
    }

    @Override
    public void onCancelButton(int id) {

    }

    @Override
    public void finish() {
        isFinished = true;
        uiHelper.dismissLoadingDialog();
        super.finish();
        overridePendingTransition(0, android.R.anim.slide_out_right);
    }



    public boolean isFinished() {
        return isFinished;
    }

    public void print() {

        formatPrinter = SelectedPrinterManager.getSelectedPrinter();
        new AsyncTask<String, String, String>() {

            protected void onPreExecute() {
                loadingDialog = DialogCreater.loadingDialog(ListOfPaletActivity.this);

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
                    DialogCreater.errorDialog(ListOfPaletActivity.this, result);
                } else {
                    loadingDialog.dismissWithAnimation();
                    DialogCreater.doneDialog(ListOfPaletActivity.this);
                }

            }

        }.execute(String.valueOf(lastActiveBoxInPalet.getPaletId()), lastActiveBoxInPalet.getPaletName());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                print();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult

    @Override
    public void printOnSwipe(Object item, int position, int direction) {
        if (direction == ItemTouchHelper.RIGHT) {
            lastActiveBoxInPalet = (BoxInPalet) item;
            DialogCreater.questionDialog(ListOfPaletActivity.this, this, ((BoxInPalet) item).getPaletName() + " Yazdırma İşlemi", 1);
        } else {
            mAdapter.notifyItemChanged(position);
        }

    }
}
