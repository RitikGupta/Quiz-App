package androidclass.qzapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

/**
 * Created by hp on 7/11/2018
 */

public class BackService extends Service {
    MediaPlayer mp;
    private final int resID = R.raw.background;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();

        mp = MediaPlayer.create(getApplicationContext(), resID);
        mp.setLooping(true); //so that song will stop after getting finished once and not just keep on playing again and again
    }
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        mp.start();
    }
    /*@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp=MediaPlayer.create(this,R.raw.background);
        mp.setLooping(true);
        mp.setVolume(100,100);
        mp.start();
        return 1;
    }*/
    @Override
    public void onDestroy() {
        mp.stop();
        super.onDestroy();

    }


}
