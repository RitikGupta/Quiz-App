package androidclass.qzapp;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hp on 6/30/2018.
 */

public class Splash1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar(DHYAN RKHNE KI CHIJ ........ SHORT CODE H)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash1);


        VideoView videoView =(VideoView)findViewById(R.id.videoView);

        //Creating MediaController(VIDEO PLAY KRNE KO H YAHA PE)
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);


        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.loading));
        videoView.requestFocus();
        videoView.start();



        Timer RunSplash = new Timer();


        TimerTask ShowSplash = new TimerTask() {
            @Override
            public void run() {

                finish();


                Intent myIntent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(myIntent);
            }
        };

        RunSplash.schedule(ShowSplash, 10000);
    }
}

