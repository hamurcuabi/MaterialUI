package com.emrhmrc.hateksdepoqr.depoQr.activity;

import android.app.Activity;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.emrhmrc.hateksdepoqr.depoQr.util.StringUtil;
import com.emrhmrc.hateksdepoqr.printer.ChooseFormatScreen;
import com.emrhmrc.hateksdepoqr.printer.util.FinishInfo;
import com.emrhmrc.hateksdepoqr.printer.util.SavedFormatProvider;
import com.emrhmrc.hateksdepoqr.printer.util.SelectedPrinterManager;
import com.emrhmrc.hateksdepoqr.printer.util.UIHelper;
import com.emrhmrc.hateksdepoqr.printer.util.UsbHelper;
import com.emrhmrc.sweetdialoglib.DialogCreater;
import com.emrhmrc.sweetdialoglib.SweetAlertDialog;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterFactory;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;
import com.zebra.sdk.printer.discovery.DiscoveredPrinter;
import com.zebra.sdk.printer.discovery.DiscoveredPrinterUsb;

public class PrintActivity extends AppCompatActivity implements FinishInfo {

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

    private String ID;
    private String NAME;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        savedFormatProvider = new SavedFormatProvider(this);
        super.onCreate(savedInstanceState);
        usbHelper.onCreate(getIntent());
        ID = getIntent().getStringExtra(StringUtil.EXTRA_SESSION_ID);
        NAME = getIntent().getStringExtra(StringUtil.EXTRA_SESSION_NAME);
        startActivityForResult(new Intent(PrintActivity.this, ChooseFormatScreen.class),
                1);

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
    public void onBackPressed() {
        super.onBackPressed();

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
                loadingDialog = DialogCreater.loadingDialog(PrintActivity.this);

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
                    DialogCreater.errorDialog(PrintActivity.this, result);
                } else {
                    loadingDialog.dismissWithAnimation();
                    DialogCreater.doneDialog(PrintActivity.this);
                }
                finish();

            }

        }.execute(ID, NAME);

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
                finish();
            }
        }
    }


}


