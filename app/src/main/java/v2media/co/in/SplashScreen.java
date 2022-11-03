package v2media.co.in;

import androidx.appcompat.app.AppCompatActivity;

import android.app.UiModeManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;


public class SplashScreen extends AppCompatActivity implements Animation.AnimationListener {

    Handler handler;
    private UiModeManager uiModeManager;
    // Animation
    Animation animZoomOut;
    ImageView imageview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageview = findViewById(R.id.imageview);

        uiModeManager = (UiModeManager) getSystemService(UI_MODE_SERVICE);
        uiModeManager.setNightMode(UiModeManager.MODE_NIGHT_NO);

        getSupportActionBar().hide();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        handler = new Handler();

        // load the animation
        animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_in);

        // set animation listener
        animZoomOut.setAnimationListener(this);

        imageview.startAnimation(animZoomOut);

       /* handler.postDelayed(new Runnable() {

            @Override
            public void run() {

                // This method will be executed once the timer is over

                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                Animatoo.animateZoom(SplashScreen.this);
            }
        }, 3000);*/
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        if (animation == animZoomOut) {

            Intent i = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(i);
            Animatoo.animateSlideRight(SplashScreen.this);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}