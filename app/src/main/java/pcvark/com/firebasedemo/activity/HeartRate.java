package pcvark.com.firebasedemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.annotation.RequiresApi;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.os.Bundle;

import pcvark.com.firebasedemo.R;

public class HeartRate extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_rate);
        int min = 4000;
        int max = 10000;
        int min1 = 100;
        int max1 = 400;
        int min2 = 60;
        int max2 = 90;
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        int c = (int) (Math.random()*(max1-min1+1)+min1);
        int h = (int) (Math.random()*(max2-min2+1)+min2);
        int a = (int) (Math.random()*(max-min+1)+min);
        int  dst = (int) (a/1.4);
        TextView count = (TextView) findViewById(R.id.textView2);
        count.setText(a+" Steps");
        TextView calories = (TextView) findViewById(R.id.calories);
        calories.setText(c +" Kcal");
        TextView distance = (TextView) findViewById(R.id.distance);
        distance.setText(dst+ " meters");
        TextView heartRate = (TextView) findViewById(R.id.heartrate);
        heartRate.setText(h+" bpm");

    }
}