package androidclass.qzapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import  android.os.Bundle;
import android.provider.ContactsContract;
import  android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import static android.content.ContentValues.TAG;
import static androidclass.qzapp.adminlogin.KEY_IS_LOGGED_IN;


/**
 * Created by hp on 7/6/2018.
 */

public class admin_question extends AppCompatActivity {
    ProgressDialog progress;

    EditText ques,opta,optb,optc,optd,ans;
    Button btn_ok,btn_finish;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_question);


        ques=(EditText)findViewById(R.id.ques);
        opta=(EditText)findViewById(R.id.opta);
        optb=(EditText)findViewById(R.id.optb);
        optc=(EditText)findViewById(R.id.optc);
        optd=(EditText)findViewById(R.id.optd);
        ans=(EditText)findViewById(R.id.ans);
        btn_ok=(Button)findViewById(R.id.ok);
        btn_finish=(Button)findViewById(R.id.finish);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int flag1 = 0;

                String txt_ques=ques.getText().toString();
                String txt_opta=opta.getText().toString();
                String txt_optb=optb.getText().toString();
                String txt_optc=optc.getText().toString();
                String txt_optd=optd.getText().toString();
                String txt_ans=ans.getText().toString();

                if(txt_ques.length()==0){
                    ques.setError("Please Enter Question");
                    flag1 = 1;
                }

                if(txt_opta.length()==0){
                    opta.setError("Please Enter option A");
                    flag1 = 1;
                }

                if(txt_optb.length()==0){
                    optb.setError("Please Enter option B");
                    flag1 = 1;
                }

                if(txt_optc.length()==0){
                    optc.setError("Please Enter option C");
                    flag1 = 1;
                }

                if(txt_optd.length()==0){
                    optd.setError("Please Enter option D");
                    flag1 = 1;
                }

                if(txt_ans.length()==0){
                    ans.setError("Please Enter Answer");
                    flag1 = 1;
                }

                if(flag1 == 0) {
                    DbHelper db = new DbHelper(admin_question.this);
                    db.addQuestion(new Question(txt_ques, txt_opta, txt_optb, txt_optc, txt_optd, txt_ans));
                    ques.setText(null);
                    opta.setText(null);
                    optb.setText(null);
                    optc.setText(null);
                    optd.setText(null);
                    ans.setText(null);
                    //  count++;
                }
            }
        });

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(admin_question.this,MainActivity.class);
                startActivity(i);
            }
        });
    }


    public void toLogout(View view)
    {progress=new ProgressDialog(admin_question.this);
        progress.setMax(100);
        progress.setMessage("Log Out");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setCancelable(false);
        progress.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while(progress.getProgress()<=progress.getMax()){
                        Thread.sleep(200);
                        progress.incrementProgressBy(10);
                        if(progress.getProgress()==progress.getMax()){
                            progress.dismiss();
                            setLog(false);
                            Intent i=new Intent(admin_question.this,MainActivity.class);
                            startActivity(i);
                            Toast.makeText(admin_question.this,"Done",Toast.LENGTH_LONG).show();
                            finish();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    // private class LogoutAsyncTask extends AsyncTask<>
    public void setLog(boolean isLoggedIn)
    {SharedPreferences sharedPref=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();;
        editor.putBoolean(String.valueOf(KEY_IS_LOGGED_IN),isLoggedIn);
        editor.apply();
        Log.d(TAG,"User Login Session Modified");
    }

}
