package com.emrhmrc.sweetdialoglib;

import android.app.Activity;
import android.graphics.Color;

public class DialogCreater {

    private static String LOADING_COLOR = "#A5DC86";
    private static String SURE = "Emin misiniz?";
    private static String YES = "Evet";
    private static String NO = "Hayır";
    private static String INFO = "Bilgi";
    private static String LOADING = "Yükleniyor";
    private static String SUCCES = "İşlem Başarılı";
    private static String FAIL = "İşlem Başarısız";
    private static String OK = "Tamam";

    public static void basicDialog(Activity activity, String title) {
        new SweetAlertDialog(activity)
                .setTitleText(title)
                .show();
    }

    public static void basicDialog(Activity activity, String title, String content) {
        new SweetAlertDialog(activity)
                .setTitleText(title)
                .setContentText(content)
                .show();
    }

    public static void errorDialog(Activity activity, String content) {
        new SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(INFO)
                .setContentText(content)
                .show();
    }

    public static void warningDialog(Activity activity, String content) {
        new SweetAlertDialog(activity, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(INFO)
                .setContentText(content)
                .show();
    }

    public static void succesDialog(Activity activity, String content) {
        new SweetAlertDialog(activity, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText(INFO)
                .setContentText(content)
                .show();
    }

    public static void succesDialog(Activity activity) {
        new SweetAlertDialog(activity, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText(INFO)
                .setContentText(SUCCES)
                .show();
    }

    public static void questionDialog(Activity activity, DialogButtonListener listener,
                                      String question, int id) {

        new SweetAlertDialog(activity, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(SURE)
                .setContentText(question)
                .setCancelText(NO)
                .setConfirmText(YES)
                .showCancelButton(true)
                .setConfirmClickListener(sweetAlertDialog -> {

                    //Ok Do it
                    listener.onConfirmButton(id);
                    sweetAlertDialog.dismissWithAnimation();

                })
                .setCancelClickListener(sDialog -> {

                    //Dont do it
                    listener.onCancelButton(id);
                    sDialog.dismissWithAnimation();
                })
                .show();

    }

    public static SweetAlertDialog loadingDialog(Activity activity, String loadingText) {

        SweetAlertDialog pDialog = new SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor(LOADING_COLOR));
        pDialog.setTitleText(loadingText);
        pDialog.setCancelable(false);
        pDialog.show();
        return pDialog;
    }
    public static SweetAlertDialog loadingDialog(Activity activity, String loadingText,boolean cancelable) {

        SweetAlertDialog pDialog = new SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor(LOADING_COLOR));
        pDialog.setTitleText(loadingText);
        pDialog.setCancelable(cancelable);
        pDialog.show();
        return pDialog;
    }

    public static SweetAlertDialog loadingDialog(Activity activity) {

        SweetAlertDialog pDialog = new SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor(LOADING_COLOR));
        pDialog.setTitleText(LOADING);
        pDialog.setCancelable(false);
        pDialog.show();
        return pDialog;
    }
    public static SweetAlertDialog loadingDialog(Activity activity,boolean cancelable) {

        SweetAlertDialog pDialog = new SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor(LOADING_COLOR));
        pDialog.setTitleText(LOADING);
        pDialog.setCancelable(cancelable);
        pDialog.show();
        return pDialog;
    }

    public static void doneDialog(Activity activity) {
        new SweetAlertDialog(activity, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText(INFO)
                .setContentText(SUCCES)
                .setConfirmClickListener(sweetAlertDialog -> sweetAlertDialog.dismissWithAnimation())
                .show();
    }

    public static void failDialog(Activity activity) {
        new SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(INFO)
                .setContentText(FAIL)
                .setConfirmClickListener(sweetAlertDialog -> sweetAlertDialog.dismissWithAnimation())
                .show();
    }

    public static void changeDoneDialog(Activity activity, String question) {
        new SweetAlertDialog(activity, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(SURE)
                .setContentText(question)
                .setConfirmText(YES)
                .setCancelText(NO)
                .setConfirmClickListener(sDialog -> sDialog
                        .setTitleText(INFO)
                        .setContentText(SUCCES)
                        .setConfirmText(OK)
                        .showCancelButton(false)
                        .setConfirmClickListener(null)
                        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE))
                .show();
    }

    public static void changeFailDialog(Activity activity, String question) {
        new SweetAlertDialog(activity, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(SURE)
                .setContentText(question)
                .setConfirmText(YES)
                .setCancelText(NO)
                .setConfirmClickListener(sDialog -> sDialog
                        .setTitleText(INFO)
                        .setContentText(FAIL)
                        .setConfirmText(OK)
                        .showCancelButton(false)
                        .setConfirmClickListener(null)
                        .changeAlertType(SweetAlertDialog.ERROR_TYPE))
                .show();
    }
}
