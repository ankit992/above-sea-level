package in.co.ankitarora.abovesealevel.cameraScreen;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private ImageView cameraImageView;
    private Bitmap imageBitMap;

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
    String mCurrentPhotoPath;

    private File createImageFile() throws IOException {
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String imageFileName = "Above_Sea_level_" + timeStamp + "_";
    File storageDir = getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    File image = File.createTempFile(imageFileName,".jpg",storageDir);
    mCurrentPhotoPath = image.getAbsolutePath();
    return image;
    }

    private void initializeViews() {
       cameraImageView.setImageBitmap(imageBitMap);
    }

    private void bindViews(View contentView) {
        cameraImageView=(ImageView) contentView.findViewById(R.id.camera_view);
    }

    public void getListener() {
        listener=new CameraScreenPresenter(this);
    }

    public void setBitMap(Bitmap imageBitmap) {
        this.imageBitMap=imageBitmap;
    }
}
