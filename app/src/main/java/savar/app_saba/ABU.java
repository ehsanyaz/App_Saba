package savar.app_saba;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ABU extends Activity {

    private TextView txtTextView,txtTextView1,dialNumber,email;
    private ImageView Savar,Mersa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abu);

        txtTextView = (TextView) findViewById(R.id.txt_abu);
        txtTextView1= (TextView) findViewById(R.id.txt_abu1);
        dialNumber = (TextView) findViewById(R.id.abu_dialNumber);
        email = (TextView) findViewById(R.id.abu_email);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Font/iransansweb.ttf");
        txtTextView.setTypeface(typeface);
        txtTextView1.setTypeface(typeface);
        dialNumber.setTypeface(typeface);
        email.setTypeface(typeface);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] emails={email.getText().toString()};
                Intent intent=new Intent(Intent.ACTION_SEND);
                //intent.putExtra(Intent.EXTRA_EMAIL,emails);
                intent.setType("plain/text");
                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
        dialNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:+989361497779"));
                startActivity(i);
            }
        });
        Savar=(ImageView)findViewById(R.id.abu_savar);
        Savar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i =new Intent(Intent.ACTION_VIEW, Uri.parse("http://savar-computer.com"));
                startActivity(i);
            }
        });
        Mersa=(ImageView)findViewById(R.id.abu_mersa);
        Mersa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Intent.ACTION_VIEW, Uri.parse("http://imdt-co.com"));
                startActivity(i);
            }
        });

    }

    public void manbehClick(View v){
        Intent intent=new Intent(ABU.this,Manbeh.class);
        startActivity(intent);
    }
}
