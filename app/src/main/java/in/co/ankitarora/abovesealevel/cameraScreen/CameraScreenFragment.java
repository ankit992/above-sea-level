package in.co.ankitarora.abovesealevel.cameraScreen;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import in.co.ankitarora.abovesealevel.Common.Base.BaseFragment;
import in.co.ankitarora.abovesealevel.Common.CameraContract;
import in.co.ankitarora.abovesealevel.Common.CameraPreview;
import in.co.ankitarora.abovesealevel.R;

/**
 * Written by Ankit Arora on 22/10/16.
 */

public class CameraScreenFragment extends BaseFragment implements CameraScreenContract.view, CameraContract {
    CameraScreenContract.listener listener;
    private static final int CAMERA_REQUEST = 1888;
    private FrameLayout cameraImageView;
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
        if(CameraPreview.getCameraInstance()!=null){
            CameraPreview cameraPreview=new CameraPreview(getContext(),CameraPreview.getCameraInstance(),this);
            cameraImageView.addView(cameraPreview);
        }
    }

    private void bindViews(View contentView) {
        cameraImageView=(FrameLayout) contentView.findViewById(R.id.camera_view);
    }

    public void getListener() {
        listener=new CameraScreenPresenter(this);
    }
}
