package com.gkrath.qrcodescannerdemo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gkrath.qrcodescannerlib.QrCodeActivity;

import java.util.List;


public class MainActivity extends AppCompatActivity{

    private static  final String TAG = "Main Screen";

    private static final int REQUEST_CODE_QR_SCAN = 101;

    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult = (TextView) findViewById(R.id.txtResult);

        findViewById(R.id.btnScan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, QrCodeActivity.class);
                startActivityForResult( i,REQUEST_CODE_QR_SCAN);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == REQUEST_CODE_QR_SCAN){
            if(data==null) {
                txtResult.setText("Scan Error, Please try again");
                return;
            }

            String result = data.getStringExtra("got_qr_scan_result");
            Log.d(TAG,"Have scan result in your app activity :"+ result);
            txtResult.setText(result);
            txtResult.setVisibility(View.VISIBLE);
        }
    }
}
