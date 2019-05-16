package com.emrhmrc.motionsteel.ocr.text_detection;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.camerakit.CameraKit;
import com.camerakit.CameraKitView;
import com.emrhmrc.motionsteel.ocr.R;
import com.emrhmrc.motionsteel.ocr.activity.LiveRecognationActivity;
import com.emrhmrc.motionsteel.ocr.activity.MainCameraActivity;
import com.emrhmrc.motionsteel.ocr.activity.PreviewActivity;
import com.emrhmrc.motionsteel.ocr.others.ResultHolder;


public class CameraControls extends LinearLayout {

    private static final String TAG = "CameraControls";
    private static final int REQUEST_GET_SINGLE_FILE = 1001;
    ImageView facingButton;
    ImageView flashButton;
    ImageView captureImageButton;
    ImageView imgOpenGallery;
    ImageView imgChangeCamera;
    private int cameraViewId = -1;
    private CameraKitView cameraView;
    private int coverViewId = -1;
    private View coverView;
    private long captureStartTime;
    private boolean pendingVideoCapture;
    private boolean capturingVideo;
    private OnTouchListener onTouchCaptureImage = new OnTouchListener() {
        @Override
        public boolean onTouch(final View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    handleViewTouchFeedback(view, motionEvent);
                    if (capturingVideo) {
                        capturingVideo = false;
                        cameraView.stopVideo();
                    } else {
                        captureStartTime = System.currentTimeMillis();
                        cameraView.captureImage(new CameraKitView.ImageCallback() {
                            @Override
                            public void onImage(CameraKitView cameraKitView, byte[] bytes) {
                                imageCaptured(bytes);
                            }
                        });
                    }
                    break;
                }

                case MotionEvent.ACTION_UP: {
                    handleViewTouchFeedback(view, motionEvent);
                    break;
                }
            }
            return true;
        }
    };
    private OnTouchListener onTouchOpenGallery = new OnTouchListener() {
        @Override
        public boolean onTouch(final View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {

                case MotionEvent.ACTION_UP: {
                    //  changeViewImageResource((ImageView) view, R.drawable.gallery);
                    touchDownAnimation(imgOpenGallery);
                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    intent.setType("image/*");
                    if (getContext() instanceof MainCameraActivity) {
                        ((MainCameraActivity) getContext()).startActivityForResult(Intent.createChooser(intent,
                                "Select " +
                                        "Picture"), REQUEST_GET_SINGLE_FILE);
                    } else {
                        Log.d(TAG, "mContext should be an instanceof Activity.");
                    }
                }
            }
            return true;
        }
    };
    private OnTouchListener onTouchChangeCamera = new OnTouchListener() {
        @Override
        public boolean onTouch(final View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {

                case MotionEvent.ACTION_UP: {
                    touchDownAnimation(imgChangeCamera);
                    if (getContext() instanceof MainCameraActivity) {
                        getContext().startActivity(new Intent(getContext(),
                                LiveRecognationActivity.class));
                    }
                    break;
                }
            }
            return true;
        }
    };

    private OnTouchListener onTouchFlash = new OnTouchListener() {
        @Override
        public boolean onTouch(final View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_UP: {
                    if (cameraView.getFlash() == com.camerakit.CameraKit.FLASH_OFF) {
                        cameraView.setFlash(CameraKit.FLASH_ON);
                        changeViewImageResource((ImageView) view, R.drawable.ic_flash_on);
                    } else if (cameraView.getFlash() == CameraKit.FLASH_AUTO) {
                        cameraView.setFlash(CameraKit.FLASH_OFF);
                        changeViewImageResource((ImageView) view, R.drawable.ic_flash_off);
                    } else if (cameraView.getFlash() == CameraKit.FLASH_ON) {
                        cameraView.setFlash(CameraKit.FLASH_AUTO);
                        changeViewImageResource((ImageView) view, R.drawable.ic_flash_auto);
                    }
                    break;
                }
            }
            return true;
        }
    };

    public CameraControls(Context context) {
        this(context, null);
    }

    public CameraControls(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CameraControls(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(getContext()).inflate(R.layout.camera_controls, this);

        facingButton = findViewById(R.id.facingButton);
        flashButton = findViewById(R.id.flashButton);
        captureImageButton = findViewById(R.id.captureImageButton);
        imgOpenGallery = findViewById(R.id.captureVideoButton);
        imgChangeCamera = findViewById(R.id.img_change_camera);

        flashButton.setOnTouchListener(onTouchFlash);
        captureImageButton.setOnTouchListener(onTouchCaptureImage);
        imgOpenGallery.setOnTouchListener(onTouchOpenGallery);
        imgChangeCamera.setOnTouchListener(onTouchChangeCamera);

        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.CameraControls,
                    0, 0);

            try {
                cameraViewId = a.getResourceId(R.styleable.CameraControls_camera, -1);
                coverViewId = a.getResourceId(R.styleable.CameraControls_cover, -1);
            } finally {
                a.recycle();
            }
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (cameraViewId != -1) {
            View view = getRootView().findViewById(cameraViewId);
            if (view instanceof CameraKitView) {
                cameraView = (CameraKitView) view;

            }
        }

        if (coverViewId != -1) {
            View view = getRootView().findViewById(coverViewId);
            if (view != null) {
                coverView = view;
                coverView.setVisibility(GONE);
            }
        }
    }


    public void imageCaptured(byte[] image) {
        ResultHolder.setImage(image);
        long callbackTime = System.currentTimeMillis();
        Intent intent = new Intent(getContext(), PreviewActivity.class);
        getContext().startActivity(intent);
    }


    boolean handleViewTouchFeedback(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                touchDownAnimation(view);
                return true;
            }

            case MotionEvent.ACTION_UP: {
                touchUpAnimation(view);
                return true;
            }

            default: {
                return true;
            }
        }
    }

    void touchDownAnimation(View view) {
        view.animate()
                .scaleX(0.88f)
                .scaleY(0.88f)
                .setDuration(300)
                .setInterpolator(new OvershootInterpolator())
                .start();
    }

    void touchUpAnimation(View view) {
        view.animate()
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(300)
                .setInterpolator(new OvershootInterpolator())
                .start();
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

}
