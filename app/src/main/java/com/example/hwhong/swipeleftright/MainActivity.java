package com.example.hwhong.swipeleftright;

import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView imageview;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        imageview = (ImageView) findViewById(R.id.imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //moving down animation
                float bottomOfScreen = getResources().getDisplayMetrics()
                        .heightPixels - (imageview.getHeight() * 4);

                imageview.animate()
                        .translationY(bottomOfScreen)
                        .setInterpolator(new AccelerateInterpolator())
                        .setInterpolator(new BounceInterpolator())
                        .setDuration(7000);
            }
        });


        imageview.setOnTouchListener(new SwipeListener(getApplicationContext()) {
            public void onSwipeTop() {

            }
            public void onSwipeRight() {
                Display mdisp = getWindowManager().getDefaultDisplay();
                Point mdispSize = new Point();
                mdisp.getSize(mdispSize);
                int maxX = mdispSize.x;
                int maxY = mdispSize.y;


                TranslateAnimation animation = new TranslateAnimation(0.0f, maxX,
                        0.0f, 0.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
                animation.setDuration(5000);  // animation duration
                animation.setRepeatCount(5);  // animation repeat count
                animation.setRepeatMode(2);   // repeat animation (left to right, right to left )
                //animation.setFillAfter(true);

                imageview.startAnimation(animation);
            }
            public void onSwipeLeft() {
                Display mdisp = getWindowManager().getDefaultDisplay();
                Point mdispSize = new Point();
                mdisp.getSize(mdispSize);
                int maxX = mdispSize.x;
                int maxY = mdispSize.y;


                TranslateAnimation animation = new TranslateAnimation(0.0f, -maxX,
                        0.0f, 0.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
                animation.setDuration(5000);  // animation duration
                animation.setRepeatCount(5);  // animation repeat count
                animation.setRepeatMode(2);   // repeat animation (left to right, right to left )
                //animation.setFillAfter(true);

                imageview.startAnimation(animation);
            }
            public void onSwipeBottom() {


            }

        });
    }


}
