package androidclass.qzapp;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hp on 7/6/2018.
 */

public class questions extends Activity {

    List<Question> quesList;
    int score=0;
    int qid=0;
    Question currentQ;
    TextView txtQuestion,rt;
    RadioButton rda, rdb, rdc,rdd;
    Button butNext;
    RadioGroup radioGroup;
    MyCountDownTimer countDownTimer=new MyCountDownTimer(21000,1000);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);
        DbHelper db=new DbHelper(this);
    //    quesList=db.getAllQuestions();
//        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        rdd=(RadioButton)findViewById(R.id.radio3);
        butNext=(Button)findViewById(R.id.button1);
        rt=(TextView)findViewById(R.id.rt);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup1);
        final int count=db.rowcount();
        if(count < 1){
            Intent i=new Intent(questions.this,no_ques_added.class);
            startActivity(i);
            finish();
        }
        else
        {quesList=db.getAllQuestions();
            currentQ=quesList.get(qid);
        setQuestionView();
        countDownTimer.start();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroup1);
                if (grp.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(questions.this,"Please select one option",Toast.LENGTH_SHORT).show();
                } else {
                    RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                    Log.d("yourans", currentQ.getANSWER() + " " + answer.getText());
                    countDownTimer.cancel();
                    radioGroup.clearCheck();
                    if (currentQ.getANSWER().equals(answer.getText())) {
                        score++;

                    } else {
                        Toast.makeText(questions.this, "OOPS! INCORRECT", Toast.LENGTH_SHORT).show();
                    }
                    if (qid < count) {
                        currentQ = quesList.get(qid);
                        setQuestionView();
                        countDownTimer.start();
                    } else {
                        Toast.makeText(questions.this, "OOPS! INCORRECT", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(questions.this, ResultActivity.class);
                        Bundle b = new Bundle();
                        b.putInt("score", score); //Your score
                        intent.putExtras(b); //Put your score to your next Intent
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });


    }
    }

    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        rdd.setText(currentQ.getOPTD());
        qid++;
    }

    public class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        public void onFinish() {
            Log.e("Times up", "Times up");
            rt.setText("Times up");
            countDownTimer.cancel();
            int count=new DbHelper(getApplicationContext()).rowcount();
            if (qid<count) {
                currentQ = quesList.get(qid);
                setQuestionView();
                //    Start The timer again
                countDownTimer.start();
            }
            else {
                Intent intent = new Intent(questions.this, ResultActivity.class);
                Bundle b = new Bundle();
                b.putInt("score", score); //Your score
                intent.putExtras(b); //Put your score to your next Intent
                startActivity(intent);
                finish();
            }
        }
        @Override
        public void onTick(long millisUntilFinished) {
            rt.setText((millisUntilFinished / 1000) + "");
            Log.e("Second Gone", "Another Second Gone");
            Log.e("Time Remaining", "seconds remaining: " + millisUntilFinished
                    / 1000);
        }
    }

}

