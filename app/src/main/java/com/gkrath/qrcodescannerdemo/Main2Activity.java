package com.gkrath.qrcodescannerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Main2Activity extends AppCompatActivity {

    ZXingScannerView zScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        zScannerView = (ZXingScannerView) findViewById(R.id.zScannerView);

        zScannerView.setResultHandler(new ZXingScannerView.ResultHandler() {
            @Override
            public void handleResult(Result rawResult) {
                Log.d("Main2", "Contents = " + rawResult.getText() +
                        ", Format = " + rawResult.getBarcodeFormat().toString());
            }
        });

    }
}
