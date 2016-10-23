package in.co.ankitarora.abovesealevel.Common.Base;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import in.co.ankitarora.abovesealevel.FullscreenActivity;
import in.co.ankitarora.abovesealevel.R;
import in.co.ankitarora.abovesealevel.cameraScreen.CameraScreenActivity;

/**
 * Written by Ankit Arora on 22/10/16.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_contact)
        {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto","ankit992@live.in", null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "APP Feature/Issue");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Explain the requirement here: ");
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
        else if(item.getItemId()==R.id.action_camera)
        {
            Intent cameraIntent=new Intent(this, CameraScreenActivity.class);
            startActivity(cameraIntent);
        }
        else if(item.getItemId()==R.id.action_home)
        {
            Intent cameraIntent=new Intent(this, FullscreenActivity.class);
            startActivity(cameraIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
