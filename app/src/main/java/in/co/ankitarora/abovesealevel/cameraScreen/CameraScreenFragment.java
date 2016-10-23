package in.co.ankitarora.abovesealevel.cameraScreen;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import in.co.ankitarora.abovesealevel.Common.Base.BaseFragment;
import in.co.ankitarora.abovesealevel.Common.CameraContract;
import in.co.ankitarora.abovesealevel.R;

/**
 * Written by Ankit Arora on 22/10/16.
 */

public class CameraScreenFragment extends BaseFragment implements CameraScreenContract.view, CameraContract {
    CameraScreenContract.listener listener;
    private static final int CAMERA_REQUEST = 1888;
    private ImageView cameraImageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView= super.onCreateView(inflater, container, savedInstanceState);
        if(contentView==null)
            contentView=inflater.inflate(R.layout.camera_screen_fragment,container,false);
        bindViews(contentView);
        initializeViews();
        getListener();
        return contentView;
    }

    private void initializeViews() {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    private void bindViews(View contentView) {
        cameraImageView=(ImageView) contentView.findViewById(R.id.camera_view);
    }

    public void getListener() {
        listener=new CameraScreenPresenter(this);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            cameraImageView.setImageBitmap(photo);
        }
    }
}
