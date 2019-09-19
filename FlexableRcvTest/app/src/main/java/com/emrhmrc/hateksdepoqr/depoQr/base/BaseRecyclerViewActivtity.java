package com.emrhmrc.hateksdepoqr.depoQr.base;

import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.emrhmrc.hateksdepoqr.R;
import com.emrhmrc.hateksdepoqr.printer.util.SavedFormatProvider;
import com.emrhmrc.hateksdepoqr.printer.util.SelectedPrinterManager;
import com.emrhmrc.hateksdepoqr.printer.util.UIHelper;
import com.emrhmrc.hateksdepoqr.printer.util.UsbHelper;
import com.emrhmrc.hateksdepoqr.samples.flexibleadapter.views.HeaderView;
import com.emrhmrc.sweetdialoglib.SweetAlertDialog;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textview.MaterialTextView;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.printer.discovery.DiscoveredPrinter;
import com.zebra.sdk.printer.discovery.DiscoveredPrinterUsb;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseRecyclerViewActivtity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_header_view)
    HeaderView headerView;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.bootsheet_recycler_view)
    RecyclerView bottomsheetRecyclerView;
    @BindView(R.id.bottom_sheet)
    LinearLayout layoutBottomSheet;
    BottomSheetBehavior sheetBehavior;
    @BindView(R.id.boxName)
    MaterialTextView sheetHeader;
    @BindView(R.id.productCount)
    MaterialButton sheetHeaderRight;
    @BindView(R.id.btn_continue)
    MaterialButton btnJobDone;
    @BindView(R.id.fab)
    FloatingActionButton fab;


//Printer

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

    public SweetAlertDialog getLoadingDialog() {
        return loadingDialog;
    }

    public Connection getConnection() {
        return connection;
    }
//

    public RecyclerView getBottomsheetRecyclerView() {
        return bottomsheetRecyclerView;
    }

    public MaterialTextView getSheetHeader() {
        return sheetHeader;
    }

    public MaterialButton getSheetHeaderRight() {
        return sheetHeaderRight;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        savedFormatProvider = new SavedFormatProvider(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_recylerview);
        ButterKnife.bind(this);
        setToolbar();
        setStatusBar();
        setHeaderView();
        initializeRecyclerView();
        setSheetBehavior();
        usbHelper.onCreate(getIntent());
        onLoad();

    }

    public DiscoveredPrinter getFormatPrinter() {
        return formatPrinter;
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

    protected void setSheetBehavior() {
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        // btnBottomSheet.setText("Close Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        // btnBottomSheet.setText("Expand Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    private void setStatusBar() {
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark_light));
    }

    private void setHeaderView() {
        headerView.bindTo(getString(R.string.app_name), getHeaderString());
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected abstract String getHeaderString();

    protected abstract void initializeRecyclerView();

    protected abstract void initializeBottomSheetRecyclerView();

    protected abstract void onLoad();

    public void hideBtnJobDone() {
        btnJobDone.setVisibility(View.GONE);
    }

    public void showtnJobDone() {
        btnJobDone.setVisibility(View.VISIBLE);
    }

    public void hideFab() {
        fab.setVisibility(View.GONE);
    }

    public void showFab() {
        fab.setVisibility(View.VISIBLE);
    }

    public void hideBottomsheet() {
        layoutBottomSheet.setVisibility(View.GONE);
    }

    public void showBottomsheet() {
        layoutBottomSheet.setVisibility(View.VISIBLE);
    }

    public FloatingActionButton getFab() {
        return fab;
    }

    public BottomSheetBehavior getSheetBehavior() {
        return sheetBehavior;
    }
}
