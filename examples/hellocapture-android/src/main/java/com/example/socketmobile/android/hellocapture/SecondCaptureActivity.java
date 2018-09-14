package com.example.socketmobile.android.hellocapture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.socketmobile.capture.client.DataEvent;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SecondCaptureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_capture);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onData(DataEvent event) {
        String data = event.getData().getString();
        String dataSource = event.getData().getDataSource().getName();
        ((TextView) findViewById(R.id.dataView)).setText(data);
        ((TextView) findViewById(R.id.dataSourceView)).setText(dataSource);
    }

    public void prevActivity(View view) {
        finish();
    }
}
