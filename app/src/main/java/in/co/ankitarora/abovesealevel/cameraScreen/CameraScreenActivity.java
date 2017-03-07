package in.co.ankitarora.abovesealevel.cameraScreen;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import in.co.ankitarora.abovesealevel.Common.Base.BaseActivity;
import in.co.ankitarora.abovesealevel.FullscreenActivity;
import in.co.ankitarora.abovesealevel.R;

/**
 * Written by Ankit Arora on 22/10/16.
 */

public class CameraScreenActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);
        dispatchTakePictureIntent();
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
        else {
            startActivity(new Intent(this, FullscreenActivity.class));
        }
    }

    private void initFragment(CameraScreenFragment fragment, Bitmap imageBitmap) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment.setBitMap(imageBitmap);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        initFragment(new CameraScreenFragment(),imageBitmap);
        }
    }
}
