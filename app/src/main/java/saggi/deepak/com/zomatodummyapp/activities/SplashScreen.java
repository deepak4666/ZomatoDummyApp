package saggi.deepak.com.zomatodummyapp.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import saggi.deepak.com.zomatodummyapp.R;
import saggi.deepak.com.zomatodummyapp.base.BaseActivity;


public class SplashScreen extends BaseActivity {

    private Handler handler = new Handler();
    private Runnable animateSplash = new Runnable() {
        @Override
        public void run() {

                startActivity(new Intent(mContext,SearchScreen.class));

        }
    };
    public SplashScreen() {
        mLayoutId = R.layout.splash_screen;
    }

    @Override
    protected void setUpUi(Bundle savedInstanceState) {
        mContext = this;

    }


    @Override
    protected void loadData(Bundle savedInstanceState) {
        handler = new Handler();
        handler.postDelayed(animateSplash, 3000L);
    }






}
