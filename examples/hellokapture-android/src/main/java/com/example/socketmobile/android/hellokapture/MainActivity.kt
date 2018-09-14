package com.example.socketmobile.android.hellokapture

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.socketmobile.capture.android.Capture
import com.socketmobile.capture.client.DataEvent
import kotlinx.android.synthetic.main.activity_main.dataSourceView
import kotlinx.android.synthetic.main.activity_main.dataView
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode.MAIN

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Capture.builder(applicationContext)
            .enableLogging(BuildConfig.DEBUG)
            .build()
    }

    @Subscribe(threadMode = MAIN)
    fun onData(event: DataEvent) {
        Log.i(TAG, event.data.string)
        dataSourceView.text = event.data.dataSource.name
        dataView.text = event.data.string
    }

    companion object {
        private val TAG : String = MainActivity::class.java.name
    }
}
