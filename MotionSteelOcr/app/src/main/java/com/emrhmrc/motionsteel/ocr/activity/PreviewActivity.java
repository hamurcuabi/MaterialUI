package com.emrhmrc.motionsteel.ocr.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.emrhmrc.motionsteel.ocr.R;
import com.emrhmrc.motionsteel.ocr.others.LanguagItemClick;
import com.emrhmrc.motionsteel.ocr.others.LanguageListFragment;
import com.emrhmrc.motionsteel.ocr.others.ResultHolder;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.cloud.FirebaseVisionCloudDetectorOptions;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.document.FirebaseVisionDocumentText;
import com.google.firebase.ml.vision.document.FirebaseVisionDocumentTextRecognizer;

import java.util.List;

public class PreviewActivity extends AppCompatActivity implements View.OnClickListener, LanguagItemClick {
    private static final String API_KEY = "AIzaSyBp6fJ4VcTtC4ZjbJjZu7jOp_W3aQPQL5U";
    final Handler textViewHandler = new Handler();
    EditText edtResult;
    byte[] bytes;
    ProgressDialog progressDialog;
    ImageView imgShare;
    ImageView imgRemoveSpace;
    ImageView imgTranslate;
    String result = "";
    boolean align;
    ActionBarDrawerToggle drawerToggle;
    FrameLayout container;
    LinearLayout lnrMain;


    private static float getApproximateFileMegabytes(Bitmap bitmap) {
        return (bitmap.getRowBytes() * bitmap.getHeight()) / 1024 / 1024;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        edtResult = findViewById(R.id.captureLatency);
        imgShare = findViewById(R.id.img_share);
        imgRemoveSpace = findViewById(R.id.img_remove_space);
        imgTranslate = findViewById(R.id.img_translate);
        container = findViewById(R.id.container);
        lnrMain = findViewById(R.id.lnr_main);
        imgTranslate.setOnClickListener(this);
        imgShare.setOnClickListener(this);
        imgRemoveSpace.setOnClickListener(this);
        setupToolbar();
        align = false;
        bytes = ResultHolder.getImage();
        if (bytes != null) {
            if (isNetworkAvailable()) {
                runCloudTextRecognition();
            } else {
                super.onBackPressed();
                showToast("Check Internet Connection");
            }
        } else {
            finish();
            return;
        }
    }

    private void setupToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(false);

            View toolbarView = getLayoutInflater().inflate(R.layout.action_bar, null, false);
            TextView titleView = toolbarView.findViewById(R.id.toolbar_title);
            ImageView imgLogo = toolbarView.findViewById(R.id.img_logo);
            ImageView imgBack = toolbarView.findViewById(R.id.img_back);
            imgLogo.setOnClickListener(this);
            imgBack.setOnClickListener(this);
            titleView.setText(Html.fromHtml("<b>OCR</b>MotionSteel"));

            getSupportActionBar().setCustomView(toolbarView, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_main_about: {
                Drawable icon = ContextCompat.getDrawable(this, R.mipmap.ic_launcher);
                new AlertDialog.Builder(this)
                        .setIcon(icon)
                        .setTitle(getString(R.string.about_dialog_title))
                        .setMessage(getString(R.string.about_dialog_message))
                        .setPositiveButton("DONE", null)
                        .show();
                return true;
            }

            case R.id.menu_main_github: {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.url_github)));
                startActivity(intent);
                return true;
            }

            case R.id.menu_main_website: {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.url_website)));
                startActivity(intent);
                return true;
            }

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //ProgressDialog
    private void loadingDialogShow() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading..."); // Setting Message
        progressDialog.setTitle("Ocr Proccesing"); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.show(); // Display Progress Dialog
        progressDialog.setCancelable(false);
    }

    private void stopDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    //TextRecognation
    private void runCloudTextRecognition() {
        loadingDialogShow();
        FirebaseVisionCloudDetectorOptions options =
                new FirebaseVisionCloudDetectorOptions.Builder()
                        .setModelType(FirebaseVisionCloudDetectorOptions.LATEST_MODEL)
                        // .setMaxResults(25)
                        .build();
        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
        FirebaseVisionDocumentTextRecognizer detector = FirebaseVision.getInstance().getCloudDocumentTextRecognizer();
        ;
        detector.processImage(image)
                .addOnSuccessListener(
                        new OnSuccessListener<FirebaseVisionDocumentText>() {
                            @Override
                            public void onSuccess(FirebaseVisionDocumentText texts) {
                                processCloudTextRecognitionResult(texts);
                            }
                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                e.printStackTrace();
                                stopDialog();
                                showToast(e.toString());
                            }
                        });
    }

    private void processCloudTextRecognitionResult(FirebaseVisionDocumentText text) {

        if (text == null) {
            stopDialog();
            super.onBackPressed();
            showToast("No text found");
            return;
        }
        List<FirebaseVisionDocumentText.Block> blocks = text.getBlocks();
        for (int i = 0; i < blocks.size(); i++) {
            result += "" + blocks.get(i).getText();
           /* List<FirebaseVisionDocumentText.Paragraph> paragraphs = blocks.get(i).getParagraphs();
            for (int j = 0; j < paragraphs.size(); j++) {
                List<FirebaseVisionDocumentText.Word> words = paragraphs.get(j).getWords();
                for (int l = 0; l < words.size(); l++) {
                   *//* CloudTextGraphic cloudDocumentTextGraphic = new CloudTextGraphic(mGraphicOverlay,
                            words.get(l));
                    mGraphicOverlay.add(cloudDocumentTextGraphic);*//*

                }

            }*/
        }
        stopDialog();
        edtResult.setText(result);

    }

    private void showToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }

    //Share Directly
    private void shareText() {
        touchDownAnimation(imgShare);
        String shareBody = edtResult.getText().toString();
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Ocr App");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, getResources().getString(R.string.share_using)));
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.img_share:
                shareText();
                break;
            case R.id.img_remove_space:
                removeSpaceOrNot();
                break;
            case R.id.img_translate:
                showLangList();
                break;
            case R.id.img_logo:
                super.onBackPressed();
                break;
            case R.id.img_back:
                super.onBackPressed();
                break;
        }
    }

    private void showLangList() {

        lnrMain.setVisibility(View.GONE);
        container.setVisibility(View.VISIBLE);
        LanguageListFragment fragment = new LanguageListFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment).commit();
    }

    private void removeSpaceOrNot() {
        if (!align) {
            align = true;
            changeViewImageResource(imgRemoveSpace, R.drawable.align_text);
            String withSpace = edtResult.getText().toString();
            edtResult.setText(withSpace.replaceAll("\n", " "));
        } else {
            align = false;
            changeViewImageResource(imgRemoveSpace, R.drawable.right_alignment);
            edtResult.setText(result);
        }
        touchDownAnimation(imgRemoveSpace);
    }

    void changeViewImageResource(final ImageView imageView, @DrawableRes final int resId) {
        imageView.setRotation(0);
        imageView.animate()
                .rotationBy(360)
                .setDuration(400)
                .setInterpolator(new OvershootInterpolator())
                .start();

        imageView.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setImageResource(resId);
            }
        }, 120);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    void touchDownAnimation(View view) {
        view.animate()
                .scaleX(0.88f)
                .scaleY(0.88f)
                .setDuration(300)
                .setInterpolator(new OvershootInterpolator())
                .start();
    }

    private void translate(final String target) {
        new AsyncTask<String, Void, Void>() {
            @Override
            protected Void doInBackground(String... params) {
                TranslateOptions options = TranslateOptions.newBuilder()
                        .setApiKey(API_KEY)
                        .build();
                Translate translate = options.getService();
                final Translation translation =
                        translate.translate(edtResult.getText().toString(),
                                Translate.TranslateOption.targetLanguage(target));
                textViewHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        edtResult.setText(translation.getTranslatedText());
                    }
                });
                return null;
            }
        }.execute();
    }

    @Override
    public void itemClick(String lang) {
        lnrMain.setVisibility(View.VISIBLE);
        container.setVisibility(View.GONE);
        translate(lang);
    }
}
