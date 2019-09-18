package com.emrhmrc.flexablercvtest.samples.flexibleadapter;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.transition.Fade;
import android.view.Window;

import com.emrhmrc.flexablercvtest.depoQr.activity.HomeActivity;
import com.emrhmrc.flexablercvtest.utils.Utils;



@SuppressWarnings("unchecked")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Utils.hasLollipop()) requestWindowFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);

        if (Utils.hasLollipop()) {
            getWindow().setExitTransition(new Fade());
        }

        Intent intent = new Intent(this, HomeActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        ActivityCompat.startActivity(this, intent, options.toBundle());
        ActivityCompat.finishAfterTransition(this);
    }

}