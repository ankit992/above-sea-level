package in.co.ankitarora.abovesealevel.cameraScreen;

/**
 * Written by Ankit Arora on 22/10/16.
 */

class CameraScreenPresenter implements CameraScreenContract.listener {
    CameraScreenContract.view view;
    CameraScreenPresenter(CameraScreenContract.view view) {
        this.view=view;
    }
}
