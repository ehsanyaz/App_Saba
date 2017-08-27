package savar.app_saba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Context;

public class BlackBord {

    private static String Matn[][];
    private static int count = 0;

    public static int Selected=0;

    public static final String Spliter = "@";

    public static Context myContext;

    public BlackBord(Context context) {
        this.myContext = context;
        try {
            setCount(myContext);
        } catch (IOException e) {
        }
        try {
            setMatn(context);
        } catch (IOException e) {

        }
    }

    public static String[][] getMatn(int type) {
        String[][] Sub = new String[getTypeCount(type)][2];
        int l = 0;
        for (int i = 0; i < count; i++) {
            if (Integer.parseInt(Matn[i][2]) == type) {
                Sub[l][0] = Matn[i][0];
                Sub[l][1] = Matn[i][1];
                l++;
            }
        }
        return Sub;
    }

    public static int getTypeCount(int type) {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (Integer.parseInt(Matn[i][2]) == type)
                c++;
        }
        return c;
    }

    private static void setCount(Context context) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open("Files/db.txt")));
        // do reading, usually loop until end of file reading
        String mLine = reader.readLine();
        while (mLine != null) {
            mLine = reader.readLine();
            count++;
        }
        reader.close();
    }

    private static void setMatn(Context context) throws IOException {
        Matn = new String[101][3];

        BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open("Files/db.txt")));

        // do reading, usually loop until end of file reading
        String mLine;
        String[] line;
        for (int i = 0; i < count; i++) {
            mLine = reader.readLine();
            line = mLine.split(Spliter);
            Matn[i][0] = line[0];
            Matn[i][1] = line[1];
            Matn[i][2] = line[2];
        }
        reader.close();
    }
}
