package com.emrhmrc.motionsteel.ocr.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.camerakit.CameraKitView;
import com.emrhmrc.motionsteel.ocr.R;

import java.io.File;
import java.io.IOException;

public class MainCameraActivity extends AppCompatActivity {

    private static final String TAG = "MainCameraActivity";

    private static final int REQUEST_GET_SINGLE_FILE = 1001;
    private CameraKitView cameraKitView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_camera);
        init();
    }

    private void init() {
        cameraKitView = findViewById(R.id.camera);

    }

    @Override
    protected void onStart() {
        super.onStart();
        cameraKitView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraKitView.onResume();
    }

    @Override
    protected void onPause() {
        cameraKitView.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        cameraKitView.onStop();
        super.onStop();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        if (requestCode == REQUEST_GET_SINGLE_FILE && resultCode == RESULT_OK) {

            Uri selectedImageUri = data.getData();
            final String path = getPathFromURI(selectedImageUri);
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
                if (path != null) {
                    File f = new File(path);
                    selectedImageUri = Uri.fromFile(f);
                    bitmap = reduceBitmapSize(f);
                }

                long callbackTime = System.currentTimeMillis();
                Intent intent = new Intent(MainCameraActivity.this, PreviewActivity.class);
                startActivity(intent);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }

    private Bitmap reduceBitmapSize(File imageFilePath) {
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imageFilePath.getAbsolutePath(), bmOptions);
        bmOptions.inSampleSize = 2;
        //bmOptions.inSampleSize = calculateInSampleSize(bmOptions);
        bmOptions.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeFile(imageFilePath.getAbsolutePath(), bmOptions);
        return bitmap;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        cameraKitView.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
