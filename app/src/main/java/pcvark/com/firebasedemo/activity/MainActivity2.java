package pcvark.com.firebasedemo.activity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import pcvark.com.firebasedemo.R;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private ProgressBar progressBar;
    private Context context;
    private TextView tx_date , tx_welcome;
    private Button btn_pills, btn_btn_Cluocose_Value, btn_btn_Heart_Rate_data;
    //private FirebaseUser currentUser;
    //private Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        Calendar c = Calendar.getInstance();

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String date = df.format(c.getTime());
        //TextView Date;
        tx_date = (TextView) findViewById(R.id.tx_date);
        tx_welcome = (TextView) findViewById(R.id.tx_welcome);
        tx_date.setText(date);
        //String s = "TEST TYPES";
        tx_welcome.setText("TEST TYPES");
        // some();
        Button button1 = (Button) findViewById(R.id.btn_Cluocose_Value);
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                //tx_welcome.setText("bye");
                Intent i;
                PackageManager manager = getPackageManager();
                try {
                    i = manager.getLaunchIntentForPackage("com.example.easytutonotes");
                    i.addCategory(Intent.CATEGORY_LAUNCHER);
                    if (i == null)
                        throw new PackageManager.NameNotFoundException();
                    startActivity(i);
                } catch (PackageManager.NameNotFoundException e) {

                }
            }
        });

        Button button2 = (Button) findViewById(R.id.btn_pills);
        button2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.gautam.medicinetime.mock");
                if (launchIntent != null) {
                    //tx_welcome.setText("gggggg");
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }
            }

        });

        Button button3 = (Button) findViewById(R.id.btn_Heart_Rate_data);
        button3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), HeartRate.class);
                startActivity(intent);
            }
        });
    }
    private void setClickListeners() {

        btn_btn_Cluocose_Value.setOnClickListener(this);

    }
    private void open() {
        //openApplication( MainActivity2.this, "com.gautam.medicinetime");
    }

    private void shareOrViewUrlViaThisApp(String appPackageName,String url) {
        boolean found = false;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));

        List<ResolveInfo> resInfo = getPackageManager().queryIntentActivities(intent, 0);
        if (!resInfo.isEmpty()){
            for (ResolveInfo info : resInfo) {
                if (info.activityInfo.packageName.toLowerCase().contains(appPackageName) ||
                        info.activityInfo.name.toLowerCase().contains(appPackageName) ) {

                    intent.setPackage(info.activityInfo.packageName);
                    found = true;
                    break;
                }
            }
            if (!found)
                return;

            startActivity(Intent.createChooser(intent, "Select"));
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Cluocose_Value:
                tx_welcome.setText("bye");
                glc(this);
                //Toast.makeText(this, "bbbbbbb", Toast.LENGTH_SHORT).show();
               /* Intent i;
                PackageManager manager = getPackageManager();
                try {
                    i = manager.getLaunchIntentForPackage("com.example.easytutonotes");
                    if (i == null)
                        throw new PackageManager.NameNotFoundException();
                    i.addCategory(Intent.CATEGORY_LAUNCHER);
                    startActivity(i);
                } catch (PackageManager.NameNotFoundException e) {

                }*/
                break;
        }}

    public void glc (MainActivity2 v)
    {
        tx_welcome.setText("fukllaa");
    }
    private void init() {
        context = this;
        progressBar = findViewById(R.id.progressBar);
        btn_pills = findViewById(R.id.btn_pills);
        btn_btn_Cluocose_Value = findViewById(R.id.btn_Cluocose_Value);
        btn_btn_Heart_Rate_data = findViewById(R.id.btn_Heart_Rate_data);
        //btn_btn_Tracking_step = findViewById(R.id.btn_Tracking_step);
    }


    private void some() {
        final Calendar t = Calendar.getInstance();
        tx_date.setText(DateFormat.getTimeFormat(this/*Context*/).format(t.getTime()));
    }
}