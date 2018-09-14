package com.example.socketmobile.android.hellocapture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.socketmobile.capture.android.Capture;
import com.socketmobile.capture.client.DataEvent;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        setContentView(R.layout.activity_main);

        Capture.builder(getApplicationContext())
                .enableLogging(BuildConfig.DEBUG)
                .build();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onScan(DataEvent event) {
        Log.d(TAG, "onScan() called with: event = [" + event + "]");
        String data = event.getData().getString();
        String dataSource = event.getData().getDataSource().getName();
        ((TextView) findViewById(R.id.dataView)).setText(data);
        ((TextView) findViewById(R.id.dataSourceView)).setText(dataSource);
    }

    public void nextActivity(View view) {
        startActivity(new Intent(this, NonCaptureActivity.class));
    }
}
