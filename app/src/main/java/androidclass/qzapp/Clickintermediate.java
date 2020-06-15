package androidclass.qzapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hp on 7/6/2018.
 */

public class Clickintermediate extends AppCompatActivity {

        View viewLayout;

        Button answer1,answer2,answer3,answer4;
        TextView score,questions,rt;

        //private Pre_questions mQuestions = new Pre_questions();

   Pre_questions2 mQuestions = new Pre_questions2();

        String mAnswer;
        public int mScore=0;
        //private int mQuestionsLength = mQuestions.mQuestions.length;
        public int mQuestionsNumber = 0;
    MyCountDownTimer countDownTimer=new MyCountDownTimer(21000,1000);
        //Random r;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.pre_questions);

            //For Custom Toast
            LayoutInflater layoutInflater = getLayoutInflater();
            viewLayout =layoutInflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_layout));
            rt=(TextView)findViewById(R.id.rt);

            // r = new Random();

            answer1 = (Button) findViewById(R.id.answer1);
            answer2 = (Button) findViewById(R.id.answer2);
            answer3 = (Button) findViewById(R.id.answer3);
            answer4 = (Button) findViewById(R.id.answer4);

            score = (TextView) findViewById(R.id.score);
            questions = (TextView) findViewById(R.id.questions);

            score.setText("Your Score: "+ mScore);

            //updateQuestion(r.nextInt(mQuestionsLength));
            updateQuestion();
            countDownTimer.start();

            answer1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    countDownTimer.cancel();
                    if(answer1.getText() == mAnswer)
                    {
                        mScore++;
                        score.setText("Your Score: "+ mScore);

                        //For CustomToast
                        Toast toast1 = Toast.makeText(Clickintermediate.this,"Toast:Gravity.TOP", Toast.LENGTH_SHORT);
                        toast1.setGravity(Gravity.CENTER,0,0);
                        toast1.setView(viewLayout);
                        toast1.show();

                        if(mQuestionsNumber<mQuestions.c) {
                            updateQuestion();
                            countDownTimer.start();
                        }
                        else
                        {/*Toast.makeText(Clickintermediate.this,"LEVEL COMPLETED",Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(Clickintermediate.this,levels.class);
                            startActivity(i);
                            finish();*/
                        gameOver();
                        }

                    }
                    else
                    {if(mQuestionsNumber<mQuestions.c) {
                        updateQuestion();
                        countDownTimer.start();
                    }
                    else {
                        gameOver();

                    }
                    }

                }
            });

            answer2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    countDownTimer.cancel();
                    if(answer2.getText() == mAnswer)
                    {
                        mScore++;
                        score.setText("Your Score: "+ mScore);

                        //For CustomToast
                        Toast toast1 = Toast.makeText(Clickintermediate.this,"Toast:Gravity.TOP",Toast.LENGTH_SHORT);
                        toast1.setGravity(Gravity.CENTER,0,0);
                        toast1.setView(viewLayout);
                        toast1.show();

                        if(mQuestionsNumber<mQuestions.c) {
                            updateQuestion();
                            countDownTimer.start();
                        }
                        else
                        {gameOver();}

                    }
                    else
                    {if(mQuestionsNumber<mQuestions.c) {
                        updateQuestion();
                        countDownTimer.start();
                    }
                    else {
                        gameOver();
                    }
                    }

                }
            });

            answer3.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    countDownTimer.cancel();
                    if(answer3.getText() == mAnswer)
                    {
                        mScore++;
                        score.setText("Your Score: "+ mScore);

                        //For CustomToast
                        Toast toast1 = Toast.makeText(Clickintermediate.this,"Toast:Gravity.TOP",Toast.LENGTH_SHORT);
                        toast1.setGravity(Gravity.CENTER,0,0);
                        toast1.setView(viewLayout);
                        toast1.show();

                        if(mQuestionsNumber<mQuestions.c) {
                            updateQuestion();
                            countDownTimer.start();
                        }
                        else
                        {/*Toast.makeText(Clickintermediate.this,"LEVEL COMPLETED",Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(Clickintermediate.this,levels.class);
                            startActivity(i);
                            finish();
                        */ gameOver();}

                    }
                    else
                    {if(mQuestionsNumber<mQuestions.c) {
                        updateQuestion();
                        countDownTimer.start();
                    }
                    else {
                        gameOver();
                    }
                    }
                }
            });

            answer4.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    countDownTimer.cancel();
                    if(answer4.getText() == mAnswer)
                    {
                        mScore++;
                        score.setText("Your Score: "+ mScore);

                        //For CustomToast
                        Toast toast1 = Toast.makeText(Clickintermediate.this,"Toast:Gravity.TOP",Toast.LENGTH_SHORT);
                        toast1.setGravity(Gravity.CENTER,0,0);
                        toast1.setView(viewLayout);
                        toast1.show();

                        if(mQuestionsNumber<mQuestions.c) {
                            updateQuestion();
                            countDownTimer.start();
                        }
                        else
                        {gameOver();}

                    }
                    else
                    {if(mQuestionsNumber<mQuestions.c) {
                        updateQuestion();
                        countDownTimer.start();
                    }
                    else {
                        gameOver();
                    }
                    }

                }
            });

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
                        countDownTimer.cancel();
                        finish();
                    }
                }).create().show();
    }


    private void updateQuestion(){
        questions.setText(mQuestions.getQuestions(mQuestionsNumber));
        answer1.setText(mQuestions.getChoice1(mQuestionsNumber));
        answer2.setText(mQuestions.getChoice2(mQuestionsNumber));
        answer3.setText(mQuestions.getChoice3(mQuestionsNumber));
        answer4.setText(mQuestions.getChoice4(mQuestionsNumber));

        mAnswer = mQuestions.getCorrectAnswer(mQuestionsNumber);
        mQuestionsNumber++;

    }

    private void gameOver()
    {
        Intent intent = new Intent(Clickintermediate.this, ResultActivity.class);
        Bundle b = new Bundle();
        b.putInt("score", mScore); //Your score
        intent.putExtras(b); //Put your score to your next Intent
        startActivity(intent);
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        countDownTimer.start();

    }

    public class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        public void onFinish() {
            Log.e("Times up", "Times up");
            rt.setText("Times up");
            countDownTimer.cancel();
            // int count=new DbHelper(getApplicationContext()).rowcount();
            if (mQuestionsNumber<mQuestions.c) {
                updateQuestion();
                //    Start The timer again
                countDownTimer.start();
            }
            else {
                gameOver();
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

