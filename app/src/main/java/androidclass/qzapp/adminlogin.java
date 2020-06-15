package androidclass.qzapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.content.ContentValues.TAG;

/**
 * Created by hp on 7/6/2018.
 */

public class adminlogin extends AppCompatActivity {
    Button lv_login;
    EditText emailtxt,passtxt;
    public static Boolean KEY_IS_LOGGED_IN=false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminlogin);
        lv_login = (Button) findViewById(R.id.lv_login);
        emailtxt = (EditText) findViewById(R.id.login_email);
        passtxt = (EditText) findViewById(R.id.login_pass);
        if(isLogin())
        {
            Intent intent = new Intent(adminlogin.this, admin_question.class);
            startActivity(intent);
            finish();
        }
        lv_login.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            int flag = 0;
                                            final String email = emailtxt.getText().toString();
                                            final String pass = passtxt.getText().toString();


                                            //validation of email and password of login page
                                            if (!isValidEmail(email)) {
                                                emailtxt.setError("Invalid Email");
                                                flag = 1;
                                            }


                                            if (!isValidPassword(pass)) {
                                                passtxt.setError("Invalid password");
                                                flag = 1;
                                            }

                                            //Checking that Login id and password exist in database or not
                                            DatabaseHandler db=new DatabaseHandler(adminlogin.this);
                                            String passwrd=db.searchPass(email);
                                            //Not Signed up yet
                                            if((passwrd.equals("NOT FOUND IN DATABASE")) && isValidEmail(email)){
                                                flag=1;
                                                emailtxt.setError("First Signup please");
                                                passtxt.setText(null);
                                                passtxt.setError(null);
                                            }
                                            //Signed up but incorrect password
                                            if(!(passwrd.equals("NOT FOUND IN DATABASE")) && !(pass.equals(passwrd)) && isValidEmail(email)){
                                                flag=1;
                                                passtxt.setError("Password not matched");
                                            }


                                            if (flag == 0) {
                                                Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                                                saveInfo();
                                                setLogin(true);
                                                Intent i = new Intent(adminlogin.this, admin_question.class);
                                                startActivity(i);
                                                finish();
                                                emailtxt.setText(null);
                                                passtxt.setText(null);
                                            }
                                        }
                                    }
        );
    }

    public void move_to_admin_signup(View v){
        Intent ic=new Intent(adminlogin.this,admin_signup.class);
        startActivity(ic);
    }

    //Validating email id
    private boolean isValidEmail(String email)
    {String empattern="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "gmail.com";
        Pattern pattern=Pattern.compile(empattern);
        Matcher matcher=pattern.matcher(email);
        return matcher.matches();
    }
    private boolean isValidPassword(String pass){
        if(pass!=null && pass.length()>=6){
            return true;
        }
        return false;
    }
    //Displaying or setting signupinfo into logininfo so that user don't have to type it again using shared preference
    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPreferences sharedPref1 = getSharedPreferences("signupInfo", Context.MODE_PRIVATE);
        //SharedPreferences sharedPref= PreferenceManager.getDefaultSharedPreferences(Second.this);
        String eml = sharedPref1.getString("username", "");
        String pw = sharedPref1.getString("password", "");
        emailtxt.setText(eml);
        passtxt.setText(pw);
    }

    @Override
    protected void onResume() {
        super.onResume();
        emailtxt.setError(null);
        passtxt.setError(null);
        //Already logged in then on back press not reach again to login screen
    }

    //Save the user login info
    public void saveInfo(){
        // SharedPreferences sharedPref= PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences sharedPref=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPref.edit();
        editor.putString("username",emailtxt.getText().toString());
        editor.putString("password",passtxt.getText().toString());
        editor.apply();

        Toast.makeText(this,"Saved!",Toast.LENGTH_SHORT).show();
    }
    //Session Manager
    public void setLogin(boolean isLoggedIn)
    {SharedPreferences sharedPref=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();;
        editor.putBoolean(String.valueOf(KEY_IS_LOGGED_IN),isLoggedIn);
        editor.apply();
        Log.d(TAG,"User Login Session Modified");
    }
    public boolean isLogin() {
        SharedPreferences sharedPref=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        return sharedPref.getBoolean(String.valueOf(KEY_IS_LOGGED_IN), false);
    }

}
