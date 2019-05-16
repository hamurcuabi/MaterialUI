package com.emrhmrc.motionsteel.ocr.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.emrhmrc.motionsteel.ocr.R;
import com.emrhmrc.motionsteel.ocr.camera.CameraSource;
import com.emrhmrc.motionsteel.ocr.camera.CameraSourcePreview;
import com.emrhmrc.motionsteel.ocr.others.GraphicOverlay;
import com.emrhmrc.motionsteel.ocr.text_detection.TextRecognitionProcessor;

import java.io.IOException;

public class LiveRecognationActivity extends AppCompatActivity implements View.OnClickListener {

    //region ----- Instance Variables -----

    private static final String TAG = "LiveRecognationActivity";
    private CameraSource cameraSource = null;
    private CameraSourcePreview preview;
    private GraphicOverlay graphicOverlay;
    private ImageView imgBack;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_recognation);

        //FirebaseApp.initializeApp(this);

        preview = (CameraSourcePreview) findViewById(R.id.camera_source_preview);
        if (preview == null) {
            Log.d(TAG, "Preview is null");
        }
        graphicOverlay = (GraphicOverlay) findViewById(R.id.graphics_overlay);
        if (graphicOverlay == null) {
            Log.d(TAG, "graphicOverlay is null");
        }

        if (!isNetworkAvailable()) {
            showToast("Check Internet connection");
        }
        createCameraSource();
        startCameraSource();
        imgBack = findViewById(R.id.img_change_camera);
        imgBack.setOnClickListener(this);
    }

    private void showToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        startCameraSource();
    }

    /**
     * Stops the camera.
     */
    @Override
    protected void onPause() {
        super.onPause();
        preview.stop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (cameraSource != null) {
            cameraSource.release();
        }
    }

    private void createCameraSource() {

        if (cameraSource == null) {
            cameraSource = new CameraSource(this, graphicOverlay);
            cameraSource.setFacing(CameraSource.CAMERA_FACING_BACK);
        }

        cameraSource.setMachineLearningFrameProcessor(new TextRecognitionProcessor());
    }

    private void startCameraSource() {
        if (cameraSource != null) {
            try {
                if (preview == null) {
                    Log.d(TAG, "resume: Preview is null");
                }
                if (graphicOverlay == null) {
                    Log.d(TAG, "resume: graphOverlay is null");
                }
                preview.start(cameraSource, graphicOverlay);
            } catch (IOException e) {
                Log.e(TAG, "Unable to start camera source.", e);
                cameraSource.release();
                cameraSource = null;
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_change_camera:
                super.onBackPressed();
                break;
        }
    }
}
