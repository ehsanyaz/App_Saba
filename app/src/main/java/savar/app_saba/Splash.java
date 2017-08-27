package savar.app_saba;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends Activity {

    private MediaPlayer mediaPlayer;

    private ImageView behineh;
    private ImageView shakhsiat;

    private TextView txt;

    private Handler handler;

    private BlackBord blackBord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        blackBord=new BlackBord(Splash.this);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sound);
        mediaPlayer.start();

        behineh = (ImageView) findViewById(R.id.Splash_behineh);
        Animation animBehineh = AnimationUtils.loadAnimation(this, R.anim.anim_splash_behineh);
        behineh.startAnimation(animBehineh);

        shakhsiat = (ImageView) findViewById(R.id.Splash_shaksiat);
        Animation animShaksiat = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_splash_shakhsiat);
        shakhsiat.startAnimation(animShaksiat);

        txt = (TextView) findViewById(R.id.Splash_txt);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Font/g.ttf");
        txt.setTypeface(typeface);
        Animation anim_txt = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_splash_txt);
        txt.startAnimation(anim_txt);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Menu.class);
                overridePendingTransition(R.anim.anim_splash_go, R.anim.anim_menu_come);
                startActivity(intent);
                mediaPlayer.stop();
                finish();
            }
        }, 3900);
    }
}
