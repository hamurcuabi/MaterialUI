package com.emrhmrc.hateksdepoqr.depoQr.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.emrhmrc.hateksdepoqr.R;
import com.emrhmrc.hateksdepoqr.printer.util.SelectedPrinterManager;
import com.emrhmrc.sweetdialoglib.DialogCreater;
import com.emrhmrc.sweetdialoglib.SweetAlertDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterFactory;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;
import com.zebra.sdk.printer.discovery.DiscoveredPrinter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentPrintDialog extends DialogFragment {

    @BindView(R.id.btnOk)
    MaterialButton btn_Ok;
    @BindView(R.id.btnCancel)
    MaterialButton btn_cancel;
    @BindView(R.id.txtHeader)
    MaterialTextView txt_header;
    private String qr, header;

    //printer
    private DiscoveredPrinter formatPrinter;
    private SweetAlertDialog loadingDialog;
    private Connection connection;

    public FragmentPrintDialog() {
    }

    public static FragmentPrintDialog newInstance(String header, String qr) {

        Bundle args = new Bundle();
        args.putString("header", header);
        args.putString("qr", qr);
        FragmentPrintDialog fragment = new FragmentPrintDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_dialog_print, null, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        header = getArguments().getString("header");
        txt_header.setText(header);
        formatPrinter = SelectedPrinterManager.getSelectedPrinter();
    }

    @OnClick(R.id.btnOk)
    public void print() {
        new AsyncTask<String, String, String>() {

            protected void onPreExecute() {
                loadingDialog = DialogCreater.loadingDialog(getActivity());

            }

            @Override
            protected String doInBackground(String... params) {
                String failMessage = "";
                connection = SelectedPrinterManager.getPrinterConnection();

                if (connection != null) {
                    try {
                        connection.open();
                        ZebraPrinter printer = ZebraPrinterFactory.getInstance(connection);
                        /*printer.sendCommand("^XA\n" +
                                "^FO50,50^BQ2,2,10\n" +
                                "^FD000Emre Hamurcu^FS\n" +
                                "^FO277,75^AAN,20,10^FDP00000001^FS\n" +
                                "^FO277,150^AAN,20,10^FD" + "DepoQr Test" + "^FS\n" +
                                "^FO277,2250^AAN,20,10^FDTestLabelTest^FS\n" +
                                "^XZ");*/
                        printer.sendCommand("^XA\n" +
                                "^FO50,50^BQ2,2,10\n" +
                                "^FD000Emre Hamurcu^FS\n" +
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
                    DialogCreater.errorDialog(getActivity(), result);
                } else {
                    loadingDialog.dismissWithAnimation();
                    DialogCreater.doneDialog(getActivity());
                }

            }

        }.execute(qr, header);

    }

    @OnClick(R.id.btnCancel)
    public void cancel() {
        dismiss();
    }

}
