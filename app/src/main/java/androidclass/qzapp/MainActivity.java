package androidclass.qzapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
ToggleButton btn_toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        btn_toggle=(ToggleButton)findViewById(R.id.togglebutton);
        //startService(new Intent(this,BackService.class));
        btn_toggle.setChecked(true);
        startService(new Intent(MainActivity.this,BackService.class));
        //For Music
        /*btn_toggle.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean on=((ToggleButton)view).isChecked();
                if(on){
                    startService(new Intent(MainActivity.this,BackService.class));
                }
                else
                { stopService(new Intent(MainActivity.this,BackService.class));}
            }
        }));*/
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        btn_toggle=(ToggleButton)findViewById(R.id.togglebutton);
        if(btn_toggle.isChecked())
            startService(new Intent(MainActivity.this,BackService.class));
        else
            stopService(new Intent(MainActivity.this,BackService.class));
    }

     public void onToggleClicked(View view) {
            // Is the toggle on?
           boolean on=((ToggleButton)view).isChecked();
                // Enable sound
            if(on){
                startService(new Intent(this,BackService.class));
            } else {
                // Disable sound
                stopService(new Intent(this,BackService.class));
            }
        }
    @Override
    protected void onPause() {
        super.onPause();
        stopService(new Intent(this,BackService.class));
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Confirm Exit")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no,null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                    }
                }).create().show();
    }

    public void move_to_levels(View v){
        Intent i=new Intent(MainActivity.this,levels.class);
        startActivity(i);
    }
    public void move_to_adminlogin(View v){
        Intent ic=new Intent(MainActivity.this,adminlogin.class);
        startActivity(ic);
    }
    public void move_to_questions(View v){
        Intent ij=new Intent(MainActivity.this,questions.class);
        startActivity(ij);
    }
}
