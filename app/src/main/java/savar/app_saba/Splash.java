package savar.app_saba;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
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

        blackBord = new BlackBord(Splash.this);

        Notification();

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

    private void Notification(){
        int NotiID=1000;
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        Intent intent=new Intent(this,Menu.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,NotiID,intent,PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setSmallIcon(R.drawable.icon);
        builder.setContentTitle("سلام");
        builder.setContentText("خیلی وقت بود به ما سر نزده بودی");
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.icon));
        builder.setSubText("خوش آمدید");
        builder.setContentIntent(pendingIntent);
        Notification notification=builder.build();
        NotificationManager mgr=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        mgr.notify(NotiID,notification);

    }
}
