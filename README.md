# QRCodeScannerDemo
QRCodeScanner Library


[![](https://jitpack.io/v/grath92/QRCodeScannerDemo.svg)](https://jitpack.io/#grath92/QRCodeScannerDemo)


### Add it in your root build.gradle at the end of repositories:

```sh
allprojects {
   repositories {
		  ...
		  maven { url 'https://jitpack.io' }
	 }
}
```

### Add the dependency:

```sh
  dependencies {
	     implementation 'com.github.grath92:QRCodeScannerDemo:1.0'
  }
```


### Use it on your app:

```sh
   private static final int REQUEST_CODE_QR_SCAN = 101;

```

```sh
   Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent qrCodeActivity = new Intent(MainActivity.this, QrCodeActivity.class);
                startActivityForResult( qrCodeActivity, REQUEST_CODE_QR_SCAN);

            }
        });
```

```sh
   @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    
        if(resultCode != Activity.RESULT_OK)
        {
            Log.d(LOGTAG,"COULD NOT GET A GOOD RESULT.");
            if(data==null)
                return;
            //Getting the passed result
            String result = data.getStringExtra("error_decoding_image");
            Log.d(TAG,"QR Code could not be scanned :"+ result);
            return;
        }

        if (requestCode == REQUEST_CODE_QR_SCAN){
            if(data==null) {
                txtResult.setText("Scan Error, Please try again");
                return;
            }

            String result = data.getStringExtra("got_qr_scan_result");
            Log.d(TAG,"Have scan result in your app activity :"+ result);
        }
    }
```


