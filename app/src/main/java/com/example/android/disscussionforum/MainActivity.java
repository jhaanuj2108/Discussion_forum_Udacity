package com.example.android.disscussionforum;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    public void delayRun() {
        Intent intent = new Intent(this,WebViewActivity.class);
        startActivity(intent);
    }

    public void start_learn_btn_functiion(View view) {
        mButton = findViewById(R.id.button);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        bounceInterpolator interpolator = new bounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        mButton.startAnimation(myAnim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                delayRun();
            }
        }, 100);
    }

}
