package in.co.ankitarora.abovesealevel.cameraScreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.co.ankitarora.abovesealevel.Common.Base.BaseFragment;
import in.co.ankitarora.abovesealevel.R;

/**
 * Written by Ankit Arora on 22/10/16.
 */

public class CameraScreenFragment extends BaseFragment implements CameraScreenContract.view {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView= super.onCreateView(inflater, container, savedInstanceState);
        if(contentView==null)
            contentView=inflater.inflate(R.layout.camera_screen_fragment,container,false);
        return contentView;
    }
}
