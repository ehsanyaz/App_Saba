package savar.app_saba;

import android.app.ListActivity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShowMatn extends ListActivity {


    private TextView matnSelfTextView;

    private String[][] Matn;
    private String[] Sub;
    private String[] Sup;

    private ImageView backbtn;

    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);
        pref = PreferenceManager.getDefaultSharedPreferences(this);

        matnSelfTextView = (TextView) findViewById(R.id.showMatn_name);

        String name = null;
        switch (BlackBord.Selected) {
            case 1:
                name = "برق";
                break;
            case 2:
                name = "گاز";
                break;
            case 3:
                name = "بنزین";
                break;
            case 4:
                name = "آب";
                break;
            default:
                break;
        }

        matnSelfTextView.setText(name);
        this.Matn = BlackBord.getMatn(BlackBord.Selected);
        this.Sub = new String[BlackBord.getTypeCount(BlackBord.Selected)];
        this.Sup = new String[BlackBord.getTypeCount(BlackBord.Selected)];
        for (int i = 0; i < BlackBord.getTypeCount(BlackBord.Selected); i++) {
            Sub[i] = Matn[i][0];
            Sup[i] = Matn[i][1];
        }
        setListAdapter(new AA());

        backbtn = (ImageView) findViewById(R.id.back_btn_show);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    ////------------------------------------------------------Array Adaptor
    class AA extends ArrayAdapter<String> {
        public AA() {
            super(ShowMatn.this, R.layout.showmatn_raw, Sub);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater in = getLayoutInflater();
            View row = in.inflate(R.layout.showmatn_raw, parent, false);

            LinearLayout container;
            container = (LinearLayout) row.findViewById(R.id.showmatnraw);

            TextView sub = (TextView) row.findViewById(R.id.raw_showMatn_textView_title);
            TextView sup = (TextView) row.findViewById(R.id.raw_showMatn_textView_subject);

            if (!pref.getBoolean("Light", false)) {
                //do nothing
            } else {
                sub.setTextColor(getResources().getColor(R.color.white));
                sup.setTextColor(getResources().getColor(R.color.white));
                container.setBackgroundColor(getResources().getColor(R.color.DarkBackGround));
            }

            if (pref.getString("listPref", "2").trim().equals("1")) {
                sub.setTextSize(32f);
                sup.setTextSize(22f);
            } else if (pref.getString("listPref", "").trim().equals("3")) {
                sub.setTextSize(20f);
                sup.setTextSize(10f);
            }

            Typeface tpf = Typeface.createFromAsset(getAssets(), "Font/iransansweb.ttf");

            sub.setTypeface(tpf);

            Typeface F = Typeface.createFromAsset(getAssets(), "Font/iransansweb.ttf");
            sup.setTypeface(F);

            sub.setText(Sub[position]);
            sup.setText(Sup[position]);

            return (row);
        }
    }

}

