package androidclass.qzapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

/**
 * Created by hp on 7/6/2018.
 */

public class levels extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levels);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.beginner:
                if (checked) {
                    Intent i = new Intent(levels.this, Clickbeg.class);
                    startActivity(i);
                    break;
                }
            case R.id.intermediate:
                if (checked) {
                    Intent i = new Intent(levels.this, Clickintermediate.class);
                    startActivity(i);
                    break;
                }
            case R.id.advance:
                if (checked) {
                    Intent i = new Intent(levels.this, Clickadv.class);
                    startActivity(i);
                    break;
                }
        }
    }

    //For Overflow menu


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.activity_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.music:

                break;

            case R.id.about_us:
                break;

            case R.id.quit:
                onBackPressed();
                break;
        }
        return true;
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

}
