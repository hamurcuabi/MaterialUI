package com.infinite.fireapp;

import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

public class CustomLinkMovementMethod extends LinkMovementMethod {

    private static final String TAG = "CustomLinkMovementMetho";
    private static CustomLinkMovementMethod sInstance;

    public static MovementMethod getInstance() {
        if (sInstance == null)
            sInstance = new CustomLinkMovementMethod();
        return sInstance;
    }


    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        Log.d(TAG, "OLDUU: ");
        int action = event.getAction();
        if (action == MotionEvent.ACTION_UP) {
            //Implement your code for handling the click.
        }
        return super.onTouchEvent(widget, buffer, event);
    }
}
