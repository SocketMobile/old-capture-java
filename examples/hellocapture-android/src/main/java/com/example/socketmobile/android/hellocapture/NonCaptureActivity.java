package com.example.socketmobile.android.hellocapture;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class NonCaptureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_capture);
    }

    public void nextActivity(View view) {
        startActivity(new Intent(this, SecondCaptureActivity.class));
    }

    public void prevActivity(View view) {
        finish();
    }
}
