package androidclass.qzapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hp on 7/6/2018.
 */

public class admin_signup extends AppCompatActivity {
    private EditText emailtext;
    private EditText passtext;
    private EditText confirmpasstext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_signup);


        final EditText nametext = (EditText) findViewById(R.id.text1);
        nametext.setHint("Your name");
        emailtext = (EditText) findViewById(R.id.edittext_email);
        passtext = (EditText) findViewById(R.id.edittext_pass);
        confirmpasstext = (EditText) findViewById(R.id.edittext_confirmpass);
        // DatabaseHandler db = new DatabaseHandler(this);

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
                                                      @Override
                                                      public void onClick(View view) {
                                                          int flag = 0;

                                                          final String name = nametext.getText().toString();
                                                          String email = emailtext.getText().toString();
                                                          String pass = passtext.getText().toString();
                                                          final String confirmpass = confirmpasstext.getText().toString();
                                                          if (name.length() == 0) {
                                                              nametext.setError("Field is mandatory");
                                                              flag = 1;
                                                          }

                                                          if (!isValidEmail(email)) {
                                                              emailtext.setError("Invalid Email");
                                                              flag = 1;
                                                          }


                                                          if (!isValidPassword(pass)) {
                                                              passtext.setError("Invalid password");
                                                              flag = 1;
                                                          }

                                                          if (!isValidConfirmPassword(pass, confirmpass)) {
                                                              confirmpasstext.setError("Password and Confirmpassword are not same");
                                                              flag = 1;
                                                          }
                                                          //If that email already exists then set error
                                                          DatabaseHandler db1 = new DatabaseHandler(admin_signup.this);
                                                          if(!((db1.searchPass(email)).equals("NOT FOUND IN DATABASE")) && isValidEmail(email)){
                                                              flag=1;
                                                              emailtext.setError("Emailid already exists");
                                                          }

                                                          if (flag == 0) {
                                                              Toast.makeText(getApplicationContext(), getString(R.string.success), Toast.LENGTH_SHORT).show();
                                                              //wait for 1 seconds
                                                              long futuretime = System.currentTimeMillis() + 500;
                                                              while (System.currentTimeMillis() < futuretime) {
                                                                  synchronized (this) {
                                                                      try {
                                                                          wait(futuretime - System.currentTimeMillis());
                                                                          finish();
                                                                      } catch (Exception e) {
                                                                      }
                                                                  }
                                                              }
                                                              Toast.makeText(getApplicationContext(), "Now login please", Toast.LENGTH_SHORT).show();

                                                              savesignupInfo();
                                                              DatabaseHandler db = new DatabaseHandler(admin_signup.this);
                                                              Log.d("Insert: ", "Inserting ..");
                                                              db.addContact(new Contact(email, pass));
                                                              // Reading all contacts
                                                              Log.d("Reading: ", "Reading all contacts..");
                                                              List<Contact> contacts = db.getAllContacts();

                                                              for (Contact cn : contacts) {
                                                                  String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                                                                  // Writing Contacts to log
                                                                  Log.d("Name: ", log);
                                                                  db.close();
                                                              }

                                                          }
                                                      }
                                                  }
        );
    }


    //Validating email id
    private boolean isValidEmail(String email) {
        String empattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "gmail.com";
        Pattern pattern = Pattern.compile(empattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() >= 6) {
            return true;
        }
        return false;
    }

    private boolean isValidConfirmPassword(String pass, String confirmpass) {
        if (confirmpass != null && confirmpass.length() >= 6 && pass.compareTo(confirmpass) == 0) {
            return true;
        }
        return false;
    }


    //Save the usersignup info
    public void savesignupInfo() {
        // SharedPreferences sharedPref= PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences sharedPref1 = getSharedPreferences("signupInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref1.edit();
        editor.putString("username", emailtext.getText().toString());
        editor.putString("password", passtext.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved yuhu!", Toast.LENGTH_SHORT).show();
    }
}
