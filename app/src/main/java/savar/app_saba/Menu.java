package savar.app_saba;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Menu extends Activity {

    private ImageView water;
    private ImageView flm;
    private ImageView gas;
    private ImageView elc;
    private ImageView setting;
    private ImageView abu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        water = (ImageView) findViewById(R.id.menu_water);
        flm = (ImageView) findViewById(R.id.menu_flame);
        setting = (ImageView) findViewById(R.id.menu_setting);
        elc = (ImageView) findViewById(R.id.menu_elc);
        abu = (ImageView) findViewById(R.id.menu_abu);
        gas = (ImageView) findViewById(R.id.menu_gas);

        Animation anim_frist = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.menu_icon_frist);
        Animation anim_second = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.menu_icon_second);
        Animation anim_third = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.menu_icon_third);

        water.startAnimation(anim_frist);
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlackBord.Selected = 4;
                Intent intent = new Intent(Menu.this, ShowMatn.class);
                startActivity(intent);
            }
        });
        elc.startAnimation(anim_frist);
        elc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlackBord.Selected = 1;
                Intent intent = new Intent(Menu.this, ShowMatn.class);
                startActivity(intent);
            }
        });
        gas.startAnimation(anim_second);
        gas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlackBord.Selected = 3;
                Intent intent = new Intent(Menu.this, ShowMatn.class);
                startActivity(intent);
            }
        });
        flm.startAnimation(anim_second);
        flm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlackBord.Selected = 2;
                Intent intent = new Intent(Menu.this, ShowMatn.class);
                startActivity(intent);
            }
        });
        setting.startAnimation(anim_third);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Setting.class);
                startActivity(intent);
            }
        });
        abu.startAnimation(anim_third);
        abu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, ABU.class);
                startActivity(intent);
            }
        });


    }
}
