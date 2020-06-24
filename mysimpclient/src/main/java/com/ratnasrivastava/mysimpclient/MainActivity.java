package com.ratnasrivastava.mysimpclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ratnasrivastava.mylib.ISimp;

public class MainActivity extends AppCompatActivity implements ServiceConnection {
    private ISimp service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.d("unique7", "" + service.add(10, 20));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        service = ISimp.Stub.asInterface(iBinder);
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        bindService(new Intent("com.ratnasrivastava.aidl.MySimpService").setPackage("com.ratnasrivastava.aidl"), this, BIND_AUTO_CREATE);
    }
}
